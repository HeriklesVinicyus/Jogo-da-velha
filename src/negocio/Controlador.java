package negocio;

import codigos.Jogador;
import codigos.Tabuleiro;

public class Controlador {

	public boolean verificarPosicao(Tabuleiro t, int x, int y) {
		
		int[][] auxTab = t.getTabuleiro();
		
		if (x >= auxTab.length || x < 0) {
			return false;
		} else if (y >= auxTab[0].length || y < 0) {
			return false;
		} else if (auxTab[x][y] != 0) {
			return false;
		}

		return true;
	}
	
	public boolean verificarImpate(Tabuleiro t){
		
		int[][] auxTab = t.getTabuleiro();
				for (int i = 0; i < auxTab.length; i++) {
					for (int k = 0; k < auxTab.length; k++) {
						if(auxTab[i][k]==0)
							return false;
					}
				}
		
		return true;
	}

	public boolean verificarVencedor(Jogador j, Tabuleiro t) {

		int[][] auxTab = t.getTabuleiro();
		int auxJog = j.getId_jogador();
		
		

		for (int i = 0; i < auxTab.length; i++) {
			if (auxTab[i][0] == auxJog && auxTab[i][1] == auxJog && auxTab[i][2] == auxJog) {
				return true;
			}
		}
		for (int i = 0; i < auxTab[0].length; i++) {
			if (auxTab[0][i] == auxJog && auxTab[1][i] == auxJog && auxTab[2][i] == auxJog) {
				return true;
			}
		}
		if (auxTab[0][0] == auxJog && auxTab[1][1] == auxJog && auxTab[2][3] == auxJog)
			return true;
		else if (auxTab[0][2] == auxJog && auxTab[1][1] == auxJog && auxTab[2][0] == auxJog)
			return true;

		return false;
	}

}
