package model;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class OpcaoTest {
	
	@Test
	public void toStringTest() {
		Opcao opcao = new Opcao('A', "A cor do céu é azul.");
		System.out.println(opcao);
		Assertions.assertThat(opcao.toString())
			.isEqualTo("A) A cor do céu é azul.");
	}
}
