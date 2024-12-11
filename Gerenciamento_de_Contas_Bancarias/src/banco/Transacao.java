package banco;

import java.io.Serializable;
import java.util.Date;

public abstract class Transacao implements Serializable {
    private static final long serialVersionUID = 1L;
	protected String token;
    protected double valor;
    protected Date data;
    protected boolean sucesso;
    protected Conta contaOrigem;
    protected Conta contaDestino;

    public Transacao(double valor, Conta contaOrigem) {
        this.valor = valor;
        this.data = new Date();
        this.token = gerarToken();
        this.sucesso = false;
        this.contaOrigem = contaOrigem;
    }

    public Transacao(double valor, Conta contaOrigem, Conta contaDestino) {
        this(valor, contaOrigem);
        this.contaDestino = contaDestino;
    }

    private String gerarToken() {
        return "TX-" + System.currentTimeMillis();
    }

    public abstract boolean realizar();

    public String getToken() {
        return token;
    }

    public double getValor() {
        return valor;
    }

    public Date getData() {
        return data;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public Conta getContaOrigem() {
        return contaOrigem;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }
}
