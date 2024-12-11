package banco;

import java.io.Serializable;
import java.util.Date;

public class Cliente implements Serializable {
	private String telefone;
    private Date dataCadastro;
    private Date dataAprovacao;
    private String status;
    private Endereco endereco;

    public Cliente(String telefone, Date dataCadastro, Endereco endereco) {
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
        this.endereco = endereco;
        this.status = "Ativo"; 
    }

    public Cliente(String nome, String telefone2) {
    }

    public void atualizarInformacoes(String telefone, Endereco endereco) {
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public Date getDataAprovacao() {
        return dataAprovacao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getStatus() {
        return status;
    }

    public String getNome() {
        throw new UnsupportedOperationException("Unimplemented method 'getNome'");
    }
    
    public static Cliente clienTeste(){
        return new Cliente("a", new Date(), Endereco.criarEnderecoteste());
    }

    public Conta getConta() {
        throw new UnsupportedOperationException("Unimplemented method 'getConta'");
    }

    public String toString(){
        return "teste";
    }
}
