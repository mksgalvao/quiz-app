package model;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PessoaTest {
	
	@Test
	public void toStringTest() {
		Pessoa p = new Pessoa("Jose", 12);
		System.out.println(p);
		Assertions.assertThat(p.toString())
			.contains("Jose")
			.contains("12");
	}
}
