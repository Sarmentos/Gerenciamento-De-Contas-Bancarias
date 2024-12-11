package banco;

import java.io.Serializable;

public class ContaPoupanca extends Conta implements Serializable {
	private double rendimento;

    public ContaPoupanca(String numeroConta, Cliente titular) {
        super(numeroConta, titular);
        this.rendimento = 0.02; 
    }

    @Override
    public boolean transferir(Conta destino, double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    public double calcularRendimento() {
        return saldo * rendimento;
    }
}
