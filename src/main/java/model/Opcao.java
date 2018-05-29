package model;

public class Opcao {

	private char letra;
	private String texto;
	
	public Opcao() {
	}

	public Opcao(char letra, String texto) {
		this.letra = letra;
		this.texto = texto;
	}

	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return letra + ") " + texto;
	}

}
