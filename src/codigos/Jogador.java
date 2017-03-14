package codigos;

public class Jogador {
	
	private int id_jogador;
	private String nome;
	private int pontuacao;
	
	public Jogador(int id_jogador, String nome) {
		this.id_jogador = id_jogador;
		this.nome = nome;
		this.pontuacao = 0;
	}

	public int getId_jogador() {
		return id_jogador;
	}

	public String getNome() {
		return nome;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao() {
		this.pontuacao++;
	}

	@Override
	public String toString() {
		return "Jogador: " + nome + ", pontuacao=" + pontuacao;
	}
}	