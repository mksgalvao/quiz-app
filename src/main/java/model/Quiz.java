package model;

import java.util.ArrayList;
import java.util.List;

public class Quiz {

	private List<Pergunta> perguntas = new ArrayList<>(); // lista de perguntas
	private Pessoa pessoa;

	public Quiz(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Quiz() {
	}


	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
