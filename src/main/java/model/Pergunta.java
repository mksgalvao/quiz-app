package model;

import java.util.ArrayList;
import java.util.List;

public class Pergunta {

	private String texto;
	private char resposta;
	private String explicacao;
	private List<Opcao> opcoes = new ArrayList<>(); // Lista de opçoes

	public Pergunta() {
	}

	public Pergunta(String texto, String explicacao) {
		this.texto = texto;
		this.explicacao = explicacao;
	}

	public Pergunta addOpcaoCorreta(Opcao opcao) {
		this.resposta = opcao.getLetra();
		return addOpcao(opcao);
	}

	public Pergunta addOpcao(Opcao opcao) {
		opcoes.add(opcao);
		return this;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public char getResposta() {
		return resposta;
	}

	public void setResposta(char resposta) {
		this.resposta = resposta;
	}

	public String getExplicacao() {
		return explicacao;
	}

	public void setExplicacao(String explicacao) {
		this.explicacao = explicacao;
	}

	public List<Opcao> getOpcoes() {
		return opcoes;
	}

	public void setOpcoes(List<Opcao> opcoes) {
		this.opcoes = opcoes;
	}
	
	//metodo que valida as respostas
	public String validaResposta(char letra) { 
		String res;
		if (letra == resposta) {
			res = "Resposta correta!\n" + "Explicação: " + explicacao;
		} else {
			res = "Resposta incorreta!\n" + "Explicação: " + explicacao;
		}

		return res + "\n";
	}

	@Override // sobrescrita do metodo 
	public String toString() {
		String result = "";
		for (Opcao opcao : opcoes) {
			result += "\t" + opcao + "\n";
		}
		return texto + "\n\n" + result;
	}
}
