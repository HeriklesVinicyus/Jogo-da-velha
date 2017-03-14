package codigos;

public class Tabuleiro {

	private int[][] tabuleiro = new int[3][3];
	
	public void inserirValor(Jogador j,int x,int y){
		tabuleiro[x][y] = j.getId_jogador();
	}
	
	public int[][] getTabuleiro(){
		return tabuleiro;
	}

	@Override
	public String toString() {

		String res = "";

		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[0].length; j++) {

				if (tabuleiro[i][j] == 0) {
					res += " ";
				} else if (tabuleiro[i][j] == 1) {
					res += "X";
				} else if (tabuleiro[i][j] == 2) {
					res += "O";
				}

				if (j < 2)
					res += "|";
			}
			if (i < 2)
				res += "\n- - - \n";
		}
		return res;
	}

}
