package br.ufc.tarefa7.teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufc.banco.conta.Conta;
import br.ufc.banco.dados.ArrayContas;
import br.ufc.banco.dados.excecoes.CEException;
import br.ufc.banco.dados.excecoes.CIException;


public class ArrayContasTest {

	private ArrayContas aContas;
	private Conta conta1;
	
	@Before
	public void inicializar(){
		aContas = new ArrayContas();
		// criando conta
		conta1 = new Conta("abc");

	}
	
	@Test
	public void testInserirContas() throws CEException{
		int tamanhoAntes = aContas.numeroContas();
		
		// inserindo conta
		aContas.inserir(conta1);
		
		int tamanhoDepois = aContas.numeroContas();
		
		assertFalse(tamanhoAntes == tamanhoDepois);	
	}
	
	@Test
	public void testProcurarConta() throws CEException{
		String numeroConta = null;
		
		aContas.inserir(conta1);
		
		Conta conta = (Conta) aContas.procurar("abc");
		
		assertEquals(conta1.obterNumero(), conta.obterNumero());
	}
	
	@Test
	public void testApagarConta() throws CEException, CIException{
		// inserindo contas
		aContas.inserir(conta1);
		int tamanhoAntes = aContas.numeroContas();
		// apagando conta
		aContas.apagar("abc");
		
		//verificar tamanho
		int tamanhoDepois = aContas.numeroContas();
		
		assertEquals(0, tamanhoDepois);
		
	}
}

