package model;

import java.util.ArrayList;
import java.util.List;

public class Quiz {

	private double pontos;
	private List<Pergunta> perguntas = new ArrayList<>();
	private Pessoa pessoa;

	public Quiz(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Quiz() {
	}

	public double getPontos() {
		return pontos;
	}

	public void setPontos(double pontos) {
		this.pontos = pontos;
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
