package banco;

import java.io.Serializable;
import java.util.Date;

public class PessoaFisica extends Cliente implements Serializable {
    private static final long serialVersionUID = 1L; 
	private String cpf;
    private String nome;

    public PessoaFisica(String telefone, Date dataCadastro, Endereco endereco, String cpf, String nome) {
        super(telefone, dataCadastro, endereco);
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome(){
        return nome;
    }

    // public static PessoaFisica criarClienteTeste(){
    //     return new PessoaFisica("27996433472", new Date(), Endereco.criarEnderecoteste(), "123456", "Lucas");
    // }

    // public String toString(){
    //     return super.toString() + "teste2";
    // }
}
