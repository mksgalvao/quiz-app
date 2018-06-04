package hello;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Opcao;
import model.Pergunta;
import model.Pessoa;
import model.RespostaPergunta;

@Controller
public class QuizController {
	
	private List<Pergunta> perguntas = new ArrayList<>();
	
	public QuizController() {
		perguntas.add(new Pergunta("Quantos quilos de lixo uma pessoa pruduz em média em 1 dia?",
				"Cada pessoa produz em média de 800 gramas a 1 kg de lixo por dia, ou de 4 a 6 litros. \n Isto equivale a aproximadamente "
						+ " 292kg por ano. Em São Paulo são geradas aproximadamente 15.000 toneladas de lixo por\n"
						+ " dia ou 75.000.000 delitros por dia. Isso eqüivale a 3.750 caminhões baú por dia.")
								.addOpcao(new Opcao('A', "aproximadamente 0.3 kg"))
								.addOpcaoCorreta(new Opcao('B', "aproximadamente 1kg"))
								.addOpcao(new Opcao('C', "aproximadamente 0.5 kg"))
								.addOpcao(new Opcao('D', "aproximadamente 2 kgs")));
		perguntas.add(new Pergunta("Quanto tempo leva para uma garrafa pet se decompor na natureza?",
				"Segundo pesquisadores da UNIFESP, o tempo de decomposição da garrafa PET é de\n"
						+ " no mínimo cem anos. Esse tempo, no entanto, é uma previsão média e pode\n"
						+ " variar de acordo com as condições ambientais.").addOpcao(new Opcao('A', "120 anos"))
								.addOpcao(new Opcao('B', "100 anos")).addOpcaoCorreta(new Opcao('C', "450 anos"))
								.addOpcao(new Opcao('D', "1000 anos")));
		perguntas.add(new Pergunta("Qual a quantidade de dioxido de carbono emitido pelo Brasil por ano?",
				"O Brasil emitiu em 2016 (ultima medição) 2,278 bilhões de toneladas brutas de gás carbônico equivalente\n"
						+ "(CO2e), contra 2,091 bilhões em 2015. Trata-se de 3,4% do total mundial,\n "
						+ "o que mantém o Brasil como sétimo maior poluidor do planeta.")
								.addOpcao(new Opcao('A', "292 bilhões de toneladas"))
								.addOpcao(new Opcao('B', "13 bilhões de toneladas"))
								.addOpcao(new Opcao('C', "0,7 bilhões de toneladas"))
								.addOpcaoCorreta(new Opcao('D', "2,278 bilhões de toneladas")));
		perguntas.add(new Pergunta("Quantos Km² de floresta Amazônica são derrumadas em média por ano?",
				"Entre agosto de 2015 e julho de 2016 (calendário oficial para medir o desmatamento), a Amazônia\n "
						+ "perdeu 7.989 quilômetros quadrados (km²) de floresta.O desmatamento no período equivale à derrubada \n"
						+ "de 128 campos de futebol por hora de floresta.").addOpcaoCorreta(new Opcao('A', " 7989 km²"))
								.addOpcao(new Opcao('B', "1300 km²")).addOpcao(new Opcao('C', "2042 km²"))
								.addOpcao(new Opcao('D', "15323 km²")));
		perguntas.add(new Pergunta("Quantos litros de água o brasileiro gasta por dia?",
				"De acordo com a Organização das Nações Unidas, cada pessoa necessita de 3,3 mil litros de água por mês "
						+ "(cerca de 110 litros de água por dia para atender as necessidades de consumo e higiene)."
						+ " No entanto, no Brasil, o consumo por pessoa pode chegar a mais de 200 litros/dia.")
								.addOpcao(new Opcao('A', "22 litros")).addOpcaoCorreta(new Opcao('B', "200 litros"))
								.addOpcao(new Opcao('C', "120,6 litros")).addOpcao(new Opcao('D', "240 litros")));
		perguntas.add(new Pergunta("Quantos litros de esgoto é produzido por pessoa por dia em uma cidade?",
				"Cada pessoa, ao consumir em média 200 litros de água por dia, converte cerca de 150 litros em \n"
						+ " esgoto. Os 50 litros restantes podem voltar à atmosfera através da evaporação ou se \n infiltrar no solo quando lavamos o quintal ou"
						+ " irrigamos jardins.").addOpcao(new Opcao('A', "300 litros"))
								.addOpcao(new Opcao('B', "70 litros")).addOpcao(new Opcao('C', "35 litros"))
								.addOpcaoCorreta(new Opcao('D', "150 litros")));
		perguntas.add(new Pergunta("Qual o percentual de lixo que é reciclado no Brasil?",
				"Os brasileiros jogam fora 76 milhões de toneladas de lixo – 30% poderiam ser reaproveitados,"
						+ " mas só 3% vão para a reciclagem.").addOpcao(new Opcao('A', "29%"))
								.addOpcaoCorreta(new Opcao('B', "3%")).addOpcao(new Opcao('C', "52%"))
								.addOpcao(new Opcao('D', "10% anos")));
		perguntas.add(new Pergunta("Qual o tamanho do buraco da camada de ozônio?",
				"Novos dados da Nasa, agência espacial americana, apontam que o buraco na camada de ozônio na\n"
						+ " Antártida não diminuiu nos últimos quatro anos. O tamanho do rombo é equivalente ao \n território"
						+ " da América do Norte, com dimensões de 24,1 milhões de quilômetros quadrados.")
								.addOpcaoCorreta(new Opcao('A', "24,1 milhões de quilômetros quadrados"))
								.addOpcao(new Opcao('B', "2 milhões de quilômetros quadrados"))
								.addOpcao(new Opcao('C', "7 milhões de quilômetros quadrados"))
								.addOpcao(new Opcao('D', "80  milhões de quilômetros quadrados")));
		perguntas.add(new Pergunta("Qual o percentual ainda existente da mata atlântica?",
				"Hoje, restam apenas 12,4% da floresta que existia originalmente e, desses remanescentes,"
						+ " 80% estão em áreas privadas")
				                .addOpcao(new Opcao('A', "55%"))
								.addOpcao(new Opcao('B', "29%")).addOpcaoCorreta(new Opcao('C', "12,4%"))
								.addOpcao(new Opcao('D', "13%")));
		perguntas.add(new Pergunta("Qual a quantidade de lixo eletrônico produzido na Terra?",
				"O volume de lixo eletrônico descartado em 2016 foi de 45 milhões de toneladas \n"
						+ "e aumentou 8% em relação a 2014, quando foi de 41 milhões de toneladas.\n ")
								.addOpcao(new Opcao('A', "11,2 milhões de toneladas"))
								.addOpcao(new Opcao('B', "450 toneladas"))
								.addOpcaoCorreta(new Opcao('C', "45 milhões de toneladas"))
								.addOpcao(new Opcao('D', "15 milhões de toneladas")));
	}
	
	@GetMapping("/inicio")
	public String inicia(Model model) {
		model.addAttribute("pessoa", new Pessoa());
		return "apresentacao";
	}

	@PostMapping("/iniciaPessoa")
	public ModelAndView iniciaPessoa(@ModelAttribute Pessoa pessoa, HttpSession session) {
		System.out.println(pessoa);
		session.setAttribute("indexQuiz", 0);
		return new ModelAndView("redirect:/quiz");
	}
	
	@GetMapping("/quiz")
	public String iniciaQuiz(Model model, HttpSession session) {
		int index = (int) session.getAttribute("indexQuiz");
		Pergunta pergunta = perguntas.get(index);
		model.addAttribute("pergunta" , pergunta);
		model.addAttribute("index" , index+1);
		model.addAttribute("resposta", new RespostaPergunta());
		return "quiz";
	}
	
	@PostMapping("/resposta")
	public ModelAndView resposta(@ModelAttribute RespostaPergunta resposta, Model model, HttpSession session) {
		int index = (int) session.getAttribute("indexQuiz");
		if(index>=perguntas.size()-1) {
			return new ModelAndView("fim");
		}
		Pergunta pergunta = perguntas.get(index);
		String res = pergunta.validaResposta(resposta.getLetra());
		
		session.setAttribute("indexQuiz", index+1);
		System.out.println(resposta.getLetra());
		System.out.println(res);
		model.addAttribute("res", res);
		return new ModelAndView("resposta");
	}

}
