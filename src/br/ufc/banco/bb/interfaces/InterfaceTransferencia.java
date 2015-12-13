package br.ufc.banco.bb.interfaces;

import javax.swing.JOptionPane;

import br.ufc.banco.bb.BancoBrasil;
import br.ufc.banco.bb.excecoes.TNRException;

public class InterfaceTransferencia {

	private BancoBrasil banco;
	
	public InterfaceTransferencia(BancoBrasil banco){
		this.banco = banco;
	}
	
	public void show(){
		String contaOrigem = JOptionPane.showInputDialog("Digite o número da conta de origem: ");
		String contaDestino = JOptionPane.showInputDialog("Digite o número da conta de destino: ");
		double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser debitado: "));
		
		try {
			banco.transferir(contaOrigem, contaDestino, valor);
			JOptionPane.showMessageDialog(null,"Operação realizada com sucesso!");
		} catch (TNRException tnre) {
			JOptionPane.showMessageDialog(null,tnre.getMessage());
		}
	}
}




