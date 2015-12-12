package br.ufc.banco.bb.interfaces;

import javax.swing.JOptionPane;

import br.ufc.banco.bb.BancoBrasil;
import br.ufc.banco.bb.excecoes.TNRException;

public class InterfaceSaque {

	private BancoBrasil banco;
	
	public InterfaceSaque(BancoBrasil banco){
		this.banco = banco;
	}
	
	public void show(){
		String numeroConta = JOptionPane.showInputDialog("Digite o número da conta:");
		double valorDebitado = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser debitado:"));
		
		try {
			banco.debitar(numeroConta, valorDebitado);
			JOptionPane.showMessageDialog(null,"Operação realizada com sucesso!");
		} catch (TNRException tnre) {
			JOptionPane.showMessageDialog(null,tnre.getMessage());
		}
	}
	
}
