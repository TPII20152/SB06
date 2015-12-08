package br.ufc.classe_contapoupanca.teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufc.banco.conta.ContaPoupanca;

public class ContaPoupancaTest {
	private ContaPoupanca conta;
	
	@Before
	public void setUp() throws Exception {
	conta = new ContaPoupanca("12345");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRendeJuros() {
		double taxa= 0.01;
		conta.creditar(10);
		conta.creditar(90);
		double result = conta.obterSaldo()+ (conta.obterSaldo()*taxa);
		conta.rendeJuros(taxa);
		assertEquals(result, conta.obterSaldo(), 0);
	}

}
