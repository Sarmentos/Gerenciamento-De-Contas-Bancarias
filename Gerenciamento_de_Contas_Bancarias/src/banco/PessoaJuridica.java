package banco;

import java.io.Serializable;
import java.util.Date;

public class PessoaJuridica extends Cliente implements Serializable{
    private static final long serialVersionUID = 1L;
	private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;

    public PessoaJuridica(String telefone, Date dataCadastro, Endereco endereco, String cnpj, String razaoSocial, String nomeFantasia) {
        super(telefone, dataCadastro, endereco);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getRazaoSocial(){
        return razaoSocial;
    }


    public String getNome(){
        return nomeFantasia;
    }

    // public static PessoaJuridica pessoaJuridicaTeste(){
    //     return new PessoaJuridica ("123456789",            
    //     new Date(),           
    //     Endereco.criarEnderecoteste(),
    //     "12345678000199",     
    //     "Razão Social Teste",  
    //     "Nome Fantasia Teste"   
    // );
    // }
}
