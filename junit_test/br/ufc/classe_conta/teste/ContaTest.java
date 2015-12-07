package br.ufc.classe_conta.teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import br.ufc.banco.conta.*;
import br.ufc.banco.conta.excecoes.SIException;

public class ContaTest {

	private Conta conta;
	
	@Before
	public void setUp() throws Exception {
		conta = new Conta("12345");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreditarNormal() {
		double saldo = conta.obterSaldo();
		
		conta.creditar(10);
		assertEquals((saldo + 10),conta.obterSaldo(), 0);
	}
	
	@Test
	public void testCreditarNegativo(){
		double saldo = conta.obterSaldo();
		
		conta.creditar(-10);
		assertEquals(saldo,conta.obterSaldo(), 0);
	}
	
	@Test (expected = SIException.class)
	public void testDebitarNormal() throws SIException{
		double saldo = conta.obterSaldo();
		
		conta.debitar(10);
		assertEquals(saldo,conta.obterSaldo(),0);
	}
	
	@Test
	public void testDebitarNormalNoException() throws SIException{
		
		double saldo = conta.obterSaldo();
		
		conta.creditar(10);
		conta.debitar(10);
		
		assertEquals(saldo,conta.obterSaldo(),0);
	}
	
	@Test (expected = SIException.class)
	public void testDebitarNegativo() throws SIException{
		double saldo = conta.obterSaldo();
		
		conta.debitar(-10);
		assertEquals(saldo,conta.obterSaldo(),0);
	}
}
