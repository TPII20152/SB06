package br.ufc.banco.bb.interfaces;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.ufc.banco.bb.BancoBrasil;
import br.ufc.banco.conta.Conta;
import br.ufc.banco.conta.ContaAbstrata;
import br.ufc.banco.conta.ContaEspecial;
import br.ufc.banco.conta.ContaPoupanca;
import br.ufc.banco.dados.excecoes.CEException;

public class MenuCriarConta {

	private ContaAbstrata conta;
	private BancoBrasil banco;
	
	public MenuCriarConta(BancoBrasil banco){
		this.conta = null;
		this.banco = banco;
	}
	
	public void show(){
		
		JButton comum = new JButton("Comum");
		JButton especial = new JButton("Especial");
		JButton poupanca = new JButton("Poupança");
		JButton imposto = new JButton("Imposto");
		

		JPanel painel = new JPanel(new GridLayout(0, 1));
		painel.add(comum);
		painel.add(especial);
		painel.add(poupanca);
		painel.add(imposto);
		
		comum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
  				String numeroConta = JOptionPane.showInputDialog("Digite o número da conta comum:");
  				conta = new Conta(numeroConta);
  				salvarConta(conta);
  			}
		});
		
		especial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
  				String numeroConta = JOptionPane.showInputDialog("Digite o número da conta especial:");
  				conta = new ContaEspecial(numeroConta);
  				salvarConta(conta);
  			}
		});
		
		poupanca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
  				String numeroConta = JOptionPane.showInputDialog("Digite o número da conta poupança:");
  				conta = new ContaPoupanca(numeroConta);
  				salvarConta(conta);
  			}
		});
		
		imposto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
  				String numeroConta = JOptionPane.showInputDialog("Digite o número da conta imposto:");
  				conta = new ContaPoupanca(numeroConta);
  				salvarConta(conta);
  			}
		});
		
		
		JFrame janela = new JFrame("Argentum");
		janela.add(painel);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.pack();
		janela.setVisible(true);
		janela.setSize(300,300);
	}
	
	public void salvarConta(ContaAbstrata conta){
		try {
			banco.cadastrar(conta);
			JOptionPane.showMessageDialog(null,"Operação realizada com sucesso!");
		} catch (CEException e1) {
			JOptionPane.showMessageDialog(null,e1.getMessage());
		}
	}
}
