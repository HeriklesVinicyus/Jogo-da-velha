package telas;

import java.util.Scanner;

import codigos.Jogador;
import codigos.Tabuleiro;
import negocio.Controlador;

public class Jogo {

	public static void main(String[] args) {
		Tabuleiro t = new Tabuleiro();
		Jogador[] j = new Jogador[2];
		Controlador c = new Controlador();
		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < j.length; i++) {
			System.out.println("Digite o nome do Jogador: " + (i + 1));
			String nome = scan.next();

			j[i] = new Jogador(i+1, nome);
		}

		for (int i = 0;; i++) {
			
			boolean vencedor = false;
			do {
				System.out.println("\n"+j[0].getNome()+": "+j[0].getPontuacao() );
				System.out.println(j[1].getNome()+": "+j[1].getPontuacao()+"\n" );
				System.out.println(t);
				
				int x;
				int y;
				int ind;
				boolean jogadaValida;
				
				do{
					ind = i%2;
					System.out.print(j[ind].getNome()+" Digite uma linha: ");
					x = scan.nextInt();
					System.out.print(j[ind].getNome()+" Digite uma coluna: ");
					y = scan.nextInt();
					
					jogadaValida = c.verificarPosicao(t, x, y);
					
					if(!jogadaValida)
						System.out.println("Jogada invalida, por favor verifique os dados");
					
				}while (!jogadaValida);
				
				t.inserirValor(j[ind], x, y);
				
				
				
				vencedor = c.verificarVencedor(j[i%2], t);
				
				i++;
				
				if(vencedor){
					System.out.println("Jogador: "+j[ind].getNome()+" eh o vencedor");
					j[ind].setPontuacao();
					i = ind;
				}
				
				
				vencedor = c.verificarImpate(t);
				if(vencedor){
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
