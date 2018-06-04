package model;

public class Pessoa {

	private String nome;
	private int idade;
	
	public Pessoa() { // metodo construtor 
	}

	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() { // metodo to String com Sobrescrita
		return "Pessoa [nome=" + nome + ", idade=" + idade + "]";
	}
}
