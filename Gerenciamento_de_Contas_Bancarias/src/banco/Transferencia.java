package banco;

import java.io.Serializable;

public class Transferencia extends Transacao  implements Serializable{
    private static final long serialVersionUID = 1L;
	public Transferencia(double valor, Conta contaOrigem, Conta contaDestino) {
        super(valor, contaOrigem, contaDestino);
    }

    @Override
    public boolean realizar() {
        if (valor > 0 && contaOrigem.transferir(contaDestino, valor)) {
            sucesso = true;
        }
        return sucesso;
    }
}
