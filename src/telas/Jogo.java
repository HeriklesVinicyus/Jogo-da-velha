package telas;

import java.util.Scanner;

import codigos.Jogador;
import codigos.Tabuleiro;
import negocio.Controlador;
import negocio.JogadorMaquina;

public class Jogo {
	
	public static int[] metodoParaUserBurro(int userInput){
		
		int[] res = new int[2];
		
		if(userInput>=7 && userInput<=9){
			res[0] = 0;
			res[1] = (userInput-7);
		}else if(userInput>=4 && userInput<=6){
			res[0] = 1;
			res[1] = (userInput-4);
		}else if(userInput>=1 && userInput<=3){
			res[0] = 2;
			res[1] = (userInput-1);
		}
		
		return res;
		
	}
	
	public static String mostraInd(){
		return "esses sao os indeces:\n7|8|9\n4|5|6\n1|2|3";
	}

	public static void main(String[] args) {
		Tabuleiro t;
		Jogador[] j = new Jogador[2];
		Controlador c = new Controlador();
		Scanner scan = new Scanner(System.in);

		/*for (int i = 0; i < j.length; i++) {
			System.out.println("Digite o nome do Jogador: " + (i + 1));
			String nome = scan.next();

			j[i] = new Jogador(i+1, nome);
		}*/
		
		System.out.println("Digite o nome do Jogador: 1");
		String nome = scan.next();

		j[0] = new Jogador(1, nome);
		j[1] = new JogadorMaquina();
		
		System.out.println(mostraInd());
		
		for (int i = 0;; i++) {
			
			t = new Tabuleiro();
			boolean vencedor = false;
			
			
			do {
				System.out.println("\n"+j[0].getNome()+": "+j[0].getPontuacao() );
				System.out.println(j[1].getNome()+": "+j[1].getPontuacao()+"\n" );
				System.out.println(t);
				
				int x;
				int[] aux;
				int ind = i%2;
				boolean jogadaValida;
				
				do{
					System.out.print(j[ind].getNome()+" "+((ind==0)?"(X)":"(O)")+": Digite um indice: ");
					x =(ind==0)?scan.nextInt():0;
					
					aux =(ind==0)?metodoParaUserBurro(x):((JogadorMaquina) j[1]).jogada(t);
					jogadaValida = c.verificarPosicao(t, aux[0], aux[1]);
					
					if(!jogadaValida && ind==0)
						System.out.println("Jogada invalida, por favor verifique os dados");
					
				}while (!jogadaValida);
				
				t.inserirValor(j[ind], aux[0], aux[1]);
				
				vencedor = c.verificarVencedor(j[ind], t);
				
				i++;
				
				if(vencedor){
					System.out.println("Jogador: "+j[ind].getNome()+" eh o vencedor");
					j[ind].setPontuacao();
					i = ind;
				}else if(c.verificarImpate(t)){
					vencedor = true;
					System.out.println("Deu Impate!\n");
					i = ind;
				}
				
			} while (!vencedor);
			
			System.out.println("Deseja continuar Jogando? \n 1)sim\n 0)nao");
			int resposta = scan.nextInt();
			if(resposta == 0)
				break;
		}
		
		scan.close();
	}

}
