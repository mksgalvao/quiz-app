package hello;

import java.util.Scanner;

import model.Pergunta;
import model.Pessoa;
import model.Quiz;

public class QuizConsole extends Quiz {

	Scanner scanner = new Scanner(System.in);

	public QuizConsole() {

	}

	private void printApresentacao() {
		System.out.println("Seja bem Vindo ao Quiz da Sustentabilidade da UNIP");
	}

	private void iniciaPessoa() {
		System.out.println("Qual seu nome?");
		String nome = scanner.nextLine();
		System.out.println("Qual sua idade?");
		int idade = scanner.nextInt();
		scanner.nextLine();
		super.setPessoa(new Pessoa(nome, idade));
	}

	private void executaQuiz() {

		for (Pergunta pergunta : super.getPerguntas()) {
			System.out.println(pergunta);
			String respostaUsuario = scanner.nextLine();
			char resposta = respostaUsuario.toUpperCase().charAt(0);

			String validacao = pergunta.validaResposta(resposta);
			System.out.println(validacao);

			System.out.println("Continuar...");
			scanner.nextLine();
		}
	}

	private void printConclusao() {
		System.out.println("Obrigado, você concluiu o QUIZ! \n"
				+ "\t o intuito deste jogo é mostrar dados importantes da sustentabilidade mundial"
				+ "\t que nos nunca lembramos e nem prestamos atenção!"
				+ "\t Essa é uma oportunidade para refletir o que fazemos para contribuir por um mundo melhor"
				+ "\t Cuidar do meio ambiente começa dentro de nossas casas!!");
	}

	public void run() {
		printApresentacao();
		iniciaPessoa();
		executaQuiz();
		printConclusao();
	}

}
