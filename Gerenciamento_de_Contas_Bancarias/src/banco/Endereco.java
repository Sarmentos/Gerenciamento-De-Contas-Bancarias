package banco;

import java.io.Serializable;

public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
	private String cidade;
    private String bairro;
    private String endereco;
    private int numeroCasa;

    public Endereco(String cidade, String bairro, String endereco, int numeroCasa) {
        this.cidade = cidade;
        this.bairro = bairro;
        this.endereco = endereco;
        this.numeroCasa = numeroCasa;
    }

    public void atualizarEndereco(String cidade, String bairro, String endereco, int numeroCasa) {
        this.cidade = cidade;
        this.bairro = bairro;
        this.endereco = endereco;
        this.numeroCasa = numeroCasa;
    }

    @Override
    public String toString() {
        return cidade + ", " + bairro + ", " + endereco + ", Nº " + numeroCasa;
    }

    public static Endereco criarEnderecoteste(){
        return new Endereco("cidade", "bairro", "rua", 500);
    }
}
