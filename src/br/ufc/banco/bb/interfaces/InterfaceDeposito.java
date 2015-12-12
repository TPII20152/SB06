package br.ufc.banco.bb.interfaces;

import javax.swing.JOptionPane;

import br.ufc.banco.bb.BancoBrasil;
import br.ufc.banco.bb.excecoes.TNRException;

public class InterfaceDeposito {
	
	private BancoBrasil banco;
	
	public InterfaceDeposito(BancoBrasil banco){
		this.banco = banco;
	}
	
	public void show(){
		String numeroConta = JOptionPane.showInputDialog("Digite o número da conta:");
		double valorCreditado = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser creditado:"));
		
		try {
			banco.creditar(numeroConta, valorCreditado);
			JOptionPane.showMessageDialog(null,"Operação realizada com sucesso!");
		} catch (TNRException tnre) {
			JOptionPane.showMessageDialog(null,tnre.getMessage());
		}
	}
}
