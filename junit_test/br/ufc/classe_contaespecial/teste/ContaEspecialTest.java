package br.ufc.classe_contaespecial.teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContaEspecialTest {

	private ContaEspecial conta = null;

	@Before
	public void setUp() throws Exception {
		conta = new ContaEspecial("123ABC");
	}

	// Teste separadamente a classe obter juros
	@Test
	public void obterBonusTest() {
		conta.creditar(100);
		assertEquals(1, conta.obterBonus(), 0);
	}

	// Teste a classe renderJuros
	@Test
	public void renderBonusTest() {
		conta.creditar(100);
		conta.rendeBonus();
		assertEquals(101, conta.obterSaldo(), 0);
	}

	//Verifica o valor do bonus ao tentar creditar valor negativo
	@Test (expected = IllegalArgumentException.class)
	public void testBonusNegativo(){
		double bonusAntesDeCreditar = conta.obterBonus();
		conta.creditar(-100);
		assertEquals(bonusAntesDeCreditar, conta.obterBonus(), 0);		
	}
	
	// Teste creditar valor gerando o bonus corretamente
	@Test
	public void creditarGerandoBonusTest() {
		conta.creditar(100);
		double bonus = conta.obterBonus();
		conta.rendeBonus();
		double saldo = conta.obterSaldo();
		assertEquals(bonus, saldo - 100, 0);
	}

	// Valore negativos informados a creditar
	@Test(expected = IllegalArgumentException.class)
	public void creditarValorNegativoTest() {
		double saldoAntesDeCreditar = conta.obterSaldo();
		conta.creditar(-100);
		double saldoDespoisDeCreditar = conta.obterSaldo();
		assertEquals(saldoAntesDeCreditar, saldoDespoisDeCreditar, 0);
	}

	// Creditar valor normal
	@Test
	public void creditarValorNormalTest() {
		conta.creditar(100);
		assertEquals(100, conta.obterSaldo(), 0);
	}
}
