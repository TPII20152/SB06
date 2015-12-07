package br.ufc.banco.conta;


public class ContaImposto extends ContaAbstrata {

	public ContaImposto(String numero) {
		super(numero);
	}

	public void debitar(double valor)throws SIException {
		if (this.saldo >= (valor + (valor * 0.001)) && valor >=0){
		this.saldo = this.saldo - (valor + (valor * 0.001));
		}  else {
			throw new SIException(numero, valor);
		}
	}
}
