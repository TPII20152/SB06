package br.ufc.banco.bb.interfaces;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.ufc.banco.bb.BancoBrasil;
import br.ufc.banco.conta.Conta;
import br.ufc.banco.conta.ContaAbstrata;
import br.ufc.banco.dados.VectorContas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceMenu {

	private ContaAbstrata conta;
	BancoBrasil banco;
	
	public InterfaceMenu(){
		
		this.conta = null;
		this.banco = new BancoBrasil(new VectorContas());
		
		banco.loadData();
	}
	
	public void show(){
		
		JButton cadastrarConta = new JButton("Cadastrar Conta");
		JButton fazerDepposito = new JButton("Fazer Depósito");
		JButton realizarSaque = new JButton("Realizar Saque");
		JButton transferencia = new JButton("Transferência");
		JButton visualizarSaldo = new JButton("Visualizar Saldo");
		JButton removerConta = new JButton("Remover Conta");
		JButton renderJuros = new JButton("Render Juros");
		JButton renderBonus = new JButton("Render Bonus");
		JButton sair = new JButton("Sair");

		JPanel painel = new JPanel(new GridLayout(0, 1));
		painel.add(cadastrarConta);
		painel.add(fazerDepposito);
		painel.add(realizarSaque);
		painel.add(transferencia);
		painel.add(visualizarSaldo);
		painel.add(removerConta);
		painel.add(renderJuros);
		painel.add(renderBonus);
		painel.add(sair);
		
		cadastrarConta.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
  				//String numeroConta = JOptionPane.showInputDialog("Digite o número da conta comum:");
  				
  				//conta = new Conta(numeroConta);
  			}
		});
		
		sair.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				
  				banco.saveData();
  				
    			System.exit(0);
  			}
		});
		
		JFrame janela = new JFrame("Argentum");
		janela.add(painel);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.pack();
		janela.setVisible(true);
		janela.setSize(300,300);
	}
}
