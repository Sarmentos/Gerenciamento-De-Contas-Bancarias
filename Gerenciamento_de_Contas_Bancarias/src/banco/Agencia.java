package banco;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Agencia implements Serializable {
    private static final long serialVersionUID = 1L;
	private List<Cliente> clientes;
    private List<Conta> contas = new ArrayList<>();
    private List<Transacao> transacoes;
    private Banco banco;
    private Endereco endereco;

    public Agencia(Banco banco, Endereco endereco) {
        this.banco = banco;
        this.endereco = endereco;
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();
        this.transacoes = new ArrayList<>();
    }

    public boolean cadastrarCliente(Cliente cliente) {
        return clientes.add(cliente);
    }

    public boolean removerCliente(Cliente cliente) {
        return clientes.remove(cliente);
    }

    public boolean abrirConta(Conta conta) {
        return contas.add(conta);
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public List<Conta> listarContas() {
        return contas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
    
    public Banco getBanco() {
        return banco;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public boolean realizarTransacao(Transacao transacao) {
        if (transacao.realizar()) {
            return transacoes.add(transacao);
        }
        return false;
    }

   public Conta buscarConta(String numeroConta) {
    for (Conta conta : contas) {
        if (conta.getNumeroConta().equals(numeroConta)) {
            return conta;
        }
    }
    return null;
}

    public Cliente buscarCliente(String nomeCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nomeCliente)) { 
                return cliente;
            }
        }
        return null;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    // public boolean verificarClienteCpfExistente(String cpf) {
    //     throw new UnsupportedOperationException("Unimplemented method 'verificarClienteCpfExistente'");
    // }

    // public boolean verificarClienteCnpjExistente(String cnpj) {
    //     throw new UnsupportedOperationException("Unimplemented method 'verificarClienteCnpjExistente'");
    // }
}
