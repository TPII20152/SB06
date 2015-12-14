package br.ufc.banco.bb.interfaces;

import javax.swing.JOptionPane;

import br.ufc.banco.bb.BancoBrasil;
import br.ufc.banco.dados.excecoes.CIException;

public class InterfaceRemoverConta {

	private BancoBrasil banco;
	
	public InterfaceRemoverConta(BancoBrasil banco){
		this.banco = banco;
	}
	
	public void show(){
		String numeroConta = JOptionPane.showInputDialog("Digite o número da conta:");
		
		try {
			banco.remover(numeroConta);
			JOptionPane.showMessageDialog(null,"Operação realizada com sucesso!");
		} catch (CIException cnee) {
			JOptionPane.showMessageDialog(null,cnee.getMessage());
		}
	}
}
