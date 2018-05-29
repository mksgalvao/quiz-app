package hello;

import java.util.ArrayList;
import java.util.List;

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
	}
	
	@GetMapping("/inicio")
	public String inicia(Model model) {
		model.addAttribute("pessoa", new Pessoa());
		return "apresentacao";
	}

	@PostMapping("/iniciaPessoa")
	public String iniciaPessoa(@ModelAttribute Pessoa pessoa) {
		System.out.println(pessoa);
		return "quiz";
	}
	
	@GetMapping("/quiz")
	public String iniciaQuiz(Model model) {
		int index = 0;
		Pergunta pergunta = perguntas.get(index);
		model.addAttribute("pergunta" , pergunta);
		model.addAttribute("index" , index+1);
		model.addAttribute("resposta", new RespostaPergunta());
		return "quiz";
	}
	
	@PostMapping("/resposta")
	public ModelAndView resposta(@ModelAttribute RespostaPergunta resposta, Model model) {
		System.out.println(resposta.getLetra());
		return new ModelAndView("redirect:/quiz");
	}

}
