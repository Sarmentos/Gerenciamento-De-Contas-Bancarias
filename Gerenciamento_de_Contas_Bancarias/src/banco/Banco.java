package banco;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Banco implements Serializable {
    private static final long serialVersionUID = 1L;
	private String nome;
    private int codigo;
    private List<Conta> contas;

    public Banco(String nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
        this.contas = new ArrayList<>();
    }

    public boolean abrirConta(Conta conta) {
        return contas.add(conta);
    }

    public boolean fecharConta(Conta conta) {
        return contas.remove(conta);
    }

    public Conta buscarConta(String numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public List<Conta> listarContas() {
        return contas;
    }

    public void adicionarAgencia(Agencia agencia) {
    }

    public static Banco criarBancoTeste(){
        Banco banco = new Banco("nomeBanco", 500);
        return banco;
    }
}
