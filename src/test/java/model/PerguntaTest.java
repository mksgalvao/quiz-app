package model;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PerguntaTest {

	private Pergunta pergunta;

	@Before
	public void before() {
		pergunta = new Pergunta("Qual a cor do céu em um dia ensolarado?", "Porque os gases refletem e Deus fez assim.")
				.addOpcao(new Opcao('A', "Roxo")).addOpcaoCorreta(new Opcao('B', "Azul"))
				.addOpcao(new Opcao('C', "Vermelha")).addOpcao(new Opcao('D', "Preto"));
	}

	@Test
	public void toStringTest() {
		String resp = "Qual a cor do céu em um dia ensolarado?\n\n" + "\tA) Roxo\n" + "\tB) Azul\n" + "\tC) Vermelha\n"
				+ "\tD) Preto\n";
		System.out.println(resp);
		System.out.println(pergunta);
		Assertions.assertThat(pergunta.toString()).isEqualTo(resp);
	}

	@Test
	public void validaRespostaCorretaTest() {
		String resp = "Resposta correta!\n" + "Explicação: Porque os gases refletem e Deus fez assim.\n";
		System.out.println(resp);
		System.out.println(pergunta.validaResposta('B'));
		Assertions.assertThat(pergunta.validaResposta('B')).isEqualTo(resp);
	}

	@Test
	public void validaRespostaErradaTest() {
		String resp = "Resposta incorreta!\n" + "Explicação: Porque os gases refletem e Deus fez assim.\n";

		Assertions.assertThat(pergunta.validaResposta('C')).isEqualTo(resp);
	}
}
