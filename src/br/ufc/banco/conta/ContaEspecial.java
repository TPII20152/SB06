package br.ufc.banco.conta;

public class ContaEspecial extends Conta {

	private double bonus;

	public ContaEspecial(String numero) {
		super(numero);
		bonus = 0;
	}

	public void rendeBonus() {
		super.creditar(bonus);
		bonus = 0;
	}

	public double obterBonus() {
		return bonus;		
	}

	public void creditar(double valor) {
			if(valor >=0 ){
				bonus = bonus + (valor * 0.01);
				super.creditar(valor);			
			}
			else{
				throw new IllegalArgumentException("Valor Negativo!");
			}

	}

}
