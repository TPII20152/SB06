package br.ufc.tarefa7.teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufc.banco.conta.Conta;
import br.ufc.banco.conta.ContaAbstrata;
import br.ufc.banco.dados.VectorContas;
import br.ufc.banco.dados.excecoes.CEException;

public class VectorContasTest {

	private VectorContas vContas;
	private Conta conta1;
	@Before
	public void inicializar(){
		vContas = new VectorContas();
		// crinando cantos
		conta1 = new Conta("abc");
	}
	
	@Test
	public void testPopularVectorContas() throws CEException{
		int tamanhoAntes = vContas.numeroContas();
		
		// inserindo conta
		vContas.inserir(conta1);
		
		int tamanhoDepois = vContas.numeroContas();
		
		assertFalse(tamanhoAntes == tamanhoDepois);	
	}
	
	@Test
	public void testProcurarConta() throws CEException{
		String numeroConta = null;
		
		vContas.inserir(conta1);
		
		Conta conta = (Conta) vContas.procurar("abc");
		
		assertEquals(conta1.obterNumero(), conta.obterNumero());
	}
}
