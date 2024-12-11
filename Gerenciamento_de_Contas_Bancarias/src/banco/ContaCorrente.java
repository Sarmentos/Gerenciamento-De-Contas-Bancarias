package banco;

import java.io.Serializable;

public class ContaCorrente extends Conta implements Serializable{
	private double limiteChequeEspecial;
    private static final long serialVersionUID = 1L;

    public ContaCorrente(String numeroConta, Cliente titular) {
        super(numeroConta, titular);
        this.limiteChequeEspecial = 1000.0; 
    }

    @Override
    public boolean transferir(Conta destino, double valor) {
        if (valor > 0 && (saldo + limiteChequeEspecial) >= valor) {
            saldo -= valor;
            destino.depositar(valor);
            return true;
        }
        return false;
    }
}
