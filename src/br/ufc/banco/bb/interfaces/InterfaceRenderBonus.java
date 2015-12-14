package br.ufc.banco.bb.interfaces;

import javax.swing.JOptionPane;

import br.ufc.banco.bb.BancoBrasil;
import br.ufc.banco.bb.excecoes.TNRException;

public class InterfaceRenderBonus {

	private BancoBrasil banco;
	
	public InterfaceRenderBonus(BancoBrasil banco){
		this.banco = banco;
	}
	
	public void show(){
		String numeroConta = JOptionPane.showInputDialog("Digite o número da conta:");
		
		try {
			banco.renderBonus(numeroConta);
			JOptionPane.showMessageDialog(null,"Operação realizada com sucesso!");
		} catch (TNRException tnre) {
			JOptionPane.showMessageDialog(null,tnre.getMessage());
		}
	}
}
