package banco;

import java.io.Serializable;

public class Deposito extends Transacao implements Serializable{
    private static final long serialVersionUID = 1L;
	public Deposito(double valor, Conta contaOrigem) {
        super(valor, contaOrigem);
    }

    @Override
    public boolean realizar() {
        if (valor > 0) {
            contaOrigem.depositar(valor);
            sucesso = true;
        }
        return sucesso;
    }
}
