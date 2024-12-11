package banco;

import java.io.Serializable;

public abstract class Conta implements Serializable {
	protected String contraSenha;
    protected String senha;
    protected String numeroConta;
    protected double saldo;
    protected String status;
    protected Cliente titular;

    public Conta(String numeroConta, Cliente titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.status = "Ativa"; 
        this.saldo = 0.0;
    }

    public boolean depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            return true;
        }
        return false;
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public abstract boolean transferir(Conta destino, double valor);

    public double consultarSaldo() {
        return saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public static Conta contaTeste() {
        return new ContaCorrente("0", Cliente.clienTeste());
    }

    public static Conta contaTeste2() {
        return new ContaPoupanca("0", Cliente.clienTeste());
    }
    
    @Override
    public String toString() {
    return "Conta numeroConta = " + numeroConta + ", titular = " + titular.getNome() + 
           ", saldo = " + saldo + ", status = " + status;
    }
}
