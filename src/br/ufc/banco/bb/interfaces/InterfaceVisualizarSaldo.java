package br.ufc.banco.bb.interfaces;

import javax.swing.JOptionPane;

import br.ufc.banco.bb.BancoBrasil;
import br.ufc.banco.bb.excecoes.TNRException;

public class InterfaceVisualizarSaldo {

	private BancoBrasil banco;
	
	public InterfaceVisualizarSaldo(BancoBrasil banco){
		this.banco = banco;
	}
	
	public void show(){
		String numeroConta = JOptionPane.showInputDialog("Digite o número da conta:");
		
		try {
			JOptionPane.showMessageDialog(null,"Saldo: " + banco.saldo(numeroConta));
		} catch (TNRException tnre) {
			JOptionPane.showMessageDialog(null,tnre.getMessage());
		}
	}
}
