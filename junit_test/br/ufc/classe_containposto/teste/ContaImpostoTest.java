package br.ufc.classe_containposto.teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufc.banco.conta.ContaImposto;
import br.ufc.banco.conta.excecoes.SIException;

public class ContaImpostoTest {
	
	private ContaImposto conta;

	@Before
	public void setUp() throws Exception {
		conta = new ContaImposto("123ABC");
	}

	@After
	public void tearDown() throws Exception {
	}

	/*Verifica se esta debitando 
	 * corretamente com os impostos
	 */
	@Test
	public void testDebitarNormal() throws SIException {
		conta.creditar(10);
		conta.debitar(9);
		double result = 10 - (9+(9* 0.001));
		assertEquals(result,conta.obterSaldo(),0);
	}
	
	/*Verifica se o saldo continua o mesmo apos tentar
	 * debitar um valor negativo
	 */
	@Test (expected = SIException.class)
	public void testDebitarNegativo() throws SIException{
		double saldo = conta.obterSaldo();
		conta.debitar(-10);
		assertEquals(saldo,conta.obterSaldo(),0);
	}
}
