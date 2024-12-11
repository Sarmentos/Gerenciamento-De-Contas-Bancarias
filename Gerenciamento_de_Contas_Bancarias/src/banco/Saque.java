package banco;

import java.io.Serializable;

public class Saque extends Transacao implements Serializable{
    private static final long serialVersionUID = 1L;
	private int codigoOperador;

    public Saque(double valor, Conta contaOrigem, int codigoOperador) {
        super(valor, contaOrigem);
        this.codigoOperador = codigoOperador;
    }

    public int getCodigoOpedrador(){
        return codigoOperador;
    }

    @Override
    public boolean realizar() {
        if (valor > 0 && contaOrigem.sacar(valor)) {
            sucesso = true;
        }
        return sucesso;
    }
}
