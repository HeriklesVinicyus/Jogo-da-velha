package negocio;

import java.util.Random;

import codigos.Jogador;
import codigos.Tabuleiro;

public class JogadorMaquina extends Jogador {

	public JogadorMaquina() {
		super(2, "God");
	}
	
	// esse matodo ainda está fraco, ele so reconhece as jogadas basica ainda e tenho que colocar estrategias para a maquina ganhar

	public int[] jogada(Tabuleiro t) {

		int[] res = new int[2];
		int[][] auxTab = t.getTabuleiro();
		int cont;

		boolean vazio = true;

		for (int i = 0; i < auxTab.length; i++) {
			for (int j = 0; j < auxTab[0].length; j++) {

				if (auxTab[i][j] != 0) {
					vazio = false;
					break;
				}
			}
			if (!vazio)
				break;
		}

		if (vazio || auxTab[1][1]==0) {
			res[0] = 1;
			res[1] = 1;
			return res;
		} else {

			for (int i = 0; i < auxTab.length; i++) {
				cont = 0;
				for (int j = 0; j < auxTab[0].length; j++) {
					if (auxTab[i][j] == 1) {
						cont++;
					}
				}
				if (cont == 2) {
					for (int j = 0; j < auxTab.length; j++) {
						if (auxTab[i][j] == 0) {
							res[0] = i;
							res[1] = j;
							return res;
						}
					}
				}

			}
			for (int i = 0; i < auxTab.length; i++) {
				cont = 0;
				for (int j = 0; j < auxTab[0].length; j++) {
					if (auxTab[j][i] == 1) {
						cont++;
					}
				}
				if (cont == 2) {
					for (int j = 0; j < auxTab.length; j++) {
						if (auxTab[j][i] == 0) {
							res[0] = j;
							res[1] = i;
							return res;
						}
					}
				}

			}
			cont = 0;
			for (int i = 0; i < auxTab.length; i++) {
				if (auxTab[i][i] == 1) {
					cont++;
				}

				if (cont == 2) {
					for (int j = 0; j < auxTab.length; j++) {
						if (auxTab[j][j] == 0) {
							res[0] = j;
							res[1] = j;
							return res;
						}
					}
				}

			}

			cont = 0;
			for (int i = 0; i < auxTab.length; i++) {
				if (auxTab[i][2 - i] == 1) {
					cont++;
				}

				if (cont == 2) {
					for (int j = 0; j < auxTab.length; j++) {
						if (auxTab[j][2 - j] == 0) {
							res[0] = j;
							res[1] = 2-j;
							return res;
						}
					}
				}
			}
			
			// tenho que melhorar a heuristica para a maquina vencer
			res[0] = new Random().nextInt(3);
			res[1] = new Random().nextInt(3);
			return res;
		}

	}

}
