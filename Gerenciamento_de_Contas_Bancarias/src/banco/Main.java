package banco;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter("banco.txt", true));

            Agencia agencia = lerArquivo();
            if (agencia == null){

            // System.out.println("=== CONFIGURAÇÃO DO BANCO ===");
            // System.out.print("Informe o nome do banco: ");
            // String nomeBanco = scanner.nextLine();
            // writer.write("Nome do banco: " + nomeBanco + "\n");

            // System.out.print("Informe o código do banco: ");
            // int codigoBanco = scanner.nextInt();
            // writer.write("Código do banco: " + codigoBanco + "\n");
            // scanner.nextLine();

            // Banco banco = new Banco(nomeBanco, codigoBanco);

            // System.out.println("\n=== CONFIGURAÇÃO DA AGÊNCIA ===");
            // System.out.print("Informe a cidade: ");
            // String cidade = scanner.nextLine();
            // writer.write("Cidade: " + cidade + "\n");

            // System.out.print("Informe o bairro: ");
            // String bairro = scanner.nextLine();
            // writer.write("Bairro: " + bairro + "\n");

            // System.out.print("Informe a rua: ");
            // String rua = scanner.nextLine();
            // writer.write("Rua: " + rua + "\n");

            // System.out.print("Informe o número: ");
            // int numero = scanner.nextInt();
            // writer.write("Número: " + numero + "\n");
            // scanner.nextLine();

            // Endereco endereco = new Endereco(cidade, bairro, rua, numero);
            // Agencia agencia = new Agencia(banco, endereco);

            Banco banco = Banco.criarBancoTeste();
            Endereco endereco = Endereco.criarEnderecoteste();
            agencia = new Agencia(banco, endereco);
            }

            System.out.println("\nBanco e agência configurados com sucesso!");

            int opcao;
            do {
                System.out.println("\n=== SISTEMA DE GERENCIAMENTO BANCÁRIO ===");
                System.out.println("1. Cadastrar Cliente");
                System.out.println("2. Abrir Conta");
                System.out.println("3. Realizar Transação");
                System.out.println("4. Listar Contas");
                System.out.println("5. Atualizar Endereço do Cliente");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                writer.write("Opção escolhida: " + opcao + "\n");
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        cadastrarCliente(agencia, scanner, writer);
                        break;
                    case 2:
                        abrirConta(agencia, scanner, writer);
                        break;
                    case 3:
                        realizarTransacao(agencia, scanner, writer);
                        break;
                    case 4:
                        listarContas(agencia);
                        break;
                    case 5:
                        atualizarEnderecoCliente(agencia, scanner, writer);
                        break;
                    case 6:
                        agencia = lerArquivo();
                        break;
                    case 0:
                        salvarArquivo(agencia);
                        System.out.println("Encerrando o sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } while (opcao != 0);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }


    private static void cadastrarCliente(Agencia agencia, Scanner scanner, BufferedWriter writer) throws IOException {
        System.out.println("\n=== CADASTRAR CLIENTE ===");
        System.out.print("Tipo de cliente (1 - Pessoa Física, 2 - Pessoa Jurídica): ");
        int tipo = scanner.nextInt();
        writer.write("Tipo de cliente: " + tipo + "\n");
        scanner.nextLine();

        if (tipo == 1) {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            writer.write("Nome do cliente: " + nome + "\n");

            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            writer.write("CPF: " + cpf + "\n");

            List<Cliente> listaClientes = agencia.getClientes(); // Obtém a lista de clientes
            boolean cpfExistente = verificarClienteCpfExistente(listaClientes, "111");
            if (cpfExistente) {
                System.out.println("CPF já cadastrado.");
            } else {
                System.out.println("CPF não encontrado.");
            }

            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            writer.write("Telefone: " + telefone + "\n");

            System.out.println("\n=== INSERIR ENDEREÇO ===");
            System.out.print("Cidade: ");
            String cidade = scanner.nextLine();
            writer.write("Cidade: " + cidade + "\n");

            System.out.print("Bairro: ");
            String bairro = scanner.nextLine();
            writer.write("Bairro: " + bairro + "\n");

            System.out.print("Rua: ");
            String rua = scanner.nextLine();
            writer.write("Rua: " + rua + "\n");

            System.out.print("Número: ");
            int numero = scanner.nextInt();
            writer.write("Número: " + numero + "\n");
            scanner.nextLine();

            PessoaFisica pessoaFisica = new PessoaFisica(telefone, null, null, cpf, nome);

            agencia.cadastrarCliente(pessoaFisica);
            System.out.println("Cliente Pessoa Física cadastrado com sucesso!");
        } else if (tipo == 2) {
            System.out.print("Razão Social: ");
            String razaoSocial = scanner.nextLine();
            writer.write("Razão Social: " + razaoSocial + "\n");

            System.out.print("Nome Fantasia: ");
            String nomeFantasia = scanner.nextLine();
            writer.write("Nome Fantasia: " + nomeFantasia + "\n");

            System.out.print("CNPJ: ");
            String cnpj = scanner.nextLine();
            writer.write("CNPJ: " + cnpj + "\n");

            List<Cliente> listaClientes = agencia.getClientes(); // Obtém a lista de clientes
            boolean cnpjExistente = verificarClienteCnpjExistente(listaClientes, "111");
            if (cnpjExistente) {
                System.out.println("CNPJ já cadastrado.");
            } else {
                System.out.println("CNPJ não encontrado.");
            }

            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            writer.write("Telefone: " + telefone + "\n");

            System.out.println("\n=== INSERIR ENDEREÇO ===");
            System.out.print("Cidade: ");
            String cidade = scanner.nextLine();
            writer.write("Cidade: " + cidade + "\n");

            System.out.print("Bairro: ");
            String bairro = scanner.nextLine();
            writer.write("Bairro: " + bairro + "\n");

            System.out.print("Rua: ");
            String rua = scanner.nextLine();
            writer.write("Rua: " + rua + "\n");

            System.out.print("Número: ");
            int numero = scanner.nextInt();
            writer.write("Número: " + numero + "\n");
            // scanner.nextLine();

            PessoaJuridica pessoaJuridica = new PessoaJuridica(telefone, null, null, cnpj, razaoSocial, nomeFantasia);

            agencia.cadastrarCliente(pessoaJuridica);
            System.out.println("Cliente Pessoa Jurídica cadastrado com sucesso!");
        } else {
            System.out.println("Tipo de cliente inválido!");
        }
    }
    
    private static boolean verificarClienteCpfExistente(List<Cliente> clientes, String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente instanceof PessoaFisica) {
                PessoaFisica pf = (PessoaFisica) cliente;
                if (pf.getCpf().equals(cpf)) {
                    return true; 
                }
            }
        }
        return false; 
    }

    private static boolean verificarClienteCnpjExistente(List<Cliente> clientes, String cnpj) {
        for (Cliente cliente : clientes) {
            if (cliente instanceof PessoaJuridica) {
                PessoaJuridica pj = (PessoaJuridica) cliente;
                if (pj.getCnpj().equals(cnpj)) {
                    return true; 
                }
            }
        }
        return false; 
    }

    private static void abrirConta(Agencia agencia, Scanner scanner, BufferedWriter writer) throws IOException {
        System.out.println("\n=== ABRIR CONTA ===");
        System.out.print("Nome do cliente: ");
        // scanner.nextLine();
        String nomeCliente = scanner.nextLine();
        writer.write("Nome do cliente: " + nomeCliente + "\n");

        Cliente cliente = agencia.buscarCliente(nomeCliente);
        // if (cliente == null) {
        // System.out.println("Cliente não encontrado!");
        // return;
        // }

        System.out.print("Tipo de conta (1 - Poupança, 2 - Corrente): ");
        int tipoConta = scanner.nextInt();
        writer.write("Tipo de conta: " + tipoConta + "\n");

        if (tipoConta == 1) {
            ContaPoupanca conta = new ContaPoupanca(nomeCliente, cliente);
            agencia.abrirConta(conta);
            System.out.println("Conta Poupança criada com sucesso!");
        } else if (tipoConta == 2) {
            ContaCorrente conta = new ContaCorrente(nomeCliente, cliente);
            agencia.abrirConta(conta);
            System.out.println("Conta Corrente criada com sucesso!");
        } else {
            System.out.println("Tipo de conta inválido!");
        }
    }

    private static void realizarTransacao(Agencia agencia, Scanner scanner, BufferedWriter writer) throws IOException {
        System.out.println("\n=== REALIZAR TRANSAÇÃO ===");

        System.out.print("Número da conta: ");
        String numeroConta = scanner.nextLine();
        writer.write("Número da conta: " + numeroConta + "\n");

        Conta conta = agencia.buscarConta(numeroConta);
        // if (conta == null) {
        // System.out.println("Conta não encontrada!");
        // return;
        // }

        System.out.print("Tipo de transação (1 - Depósito, 2 - Saque, 3 - Transferência): ");
        int tipo = scanner.nextInt();
        // scanner.nextLine();
        writer.write("Tipo de transação: " + tipo + "\n");

        switch (tipo) {
            case 1:
                System.out.print("Valor do depósito: ");
                double valorDeposito = scanner.nextDouble();
                writer.write("Valor do depósito: " + valorDeposito + "\n");
                conta.depositar(valorDeposito);
                System.out.println("Depósito realizado com sucesso!");
                break;
            case 2:
                System.out.print("Valor do saque: ");
                double valorSaque = scanner.nextDouble();
                writer.write("Valor do saque: " + valorSaque + "\n");
                if (conta.sacar(valorSaque)) {
                    System.out.println("Saque realizado com sucesso!");
                } else {
                    System.out.println("Saldo insuficiente!");
                }
                break;
            case 3:
                System.out.print("Número da conta de destino: ");
                String numeroContaDestino = scanner.nextLine();
                System.out.print("Valor da transferência: ");
                double valorTransferencia = scanner.nextDouble();
                writer.write("Valor da transferência: " + valorTransferencia + "\n");
                Conta contaDestino = agencia.buscarConta(numeroContaDestino);
                if (contaDestino != null && conta.transferir(contaDestino, valorTransferencia)) {
                    System.out.println("Transferência realizada com sucesso!");
                } else {
                    System.out.println("Erro ao realizar a transferência!");
                }
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }
    
    private static void salvarArquivo(Agencia agencia){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Agencia.txt"))) {
            oos.writeObject(agencia);
            System.out.println("Objetos salvos com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Agencia lerArquivo(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Agencia.txt"))) {
            Agencia agencia = (Agencia) ois.readObject();
            System.out.println("Objetos lidos com sucesso!");
            return agencia;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void listarContas(Agencia agencia) {
        System.out.println("\n=== LISTAR CONTAS ===");
        List<Conta> contas = agencia.listarContas();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("banco.txt", true))) {
            if (contas.isEmpty()) {
                System.out.println("Nenhuma conta cadastrada!");
                writer.write("Nenhuma conta cadastrada!\n");
            } else {
                for (Object conta : contas) {
                    System.out.println((conta).toString());
                    writer.write(conta.toString() + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar as contas no arquivo: " + e.getMessage());
        }
    }

    private static void atualizarEnderecoCliente(Agencia agencia, Scanner scanner, BufferedWriter writer)
            throws IOException {
        System.out.println("\n=== ATUALIZAR ENDEREÇO DO CLIENTE ===");
        System.out.print("Nome do cliente: ");
        // scanner.nextLine();
        String nomeCliente = scanner.nextLine();
        writer.write("Nome do cliente: " + nomeCliente + "\n");

        Cliente cliente = agencia.buscarCliente(nomeCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        System.out.print("Nova cidade: ");
        String novaCidade = scanner.nextLine();
        writer.write("Nova cidade: " + novaCidade + "\n");

        System.out.print("Novo bairro: ");
        String novoBairro = scanner.nextLine();
        writer.write("Novo bairro: " + novoBairro + "\n");

        System.out.print("Nova rua: ");
        String novaRua = scanner.nextLine();
        writer.write("Nova rua: " + novaRua + "\n");

        System.out.print("Novo número: ");
        int novoNumero = scanner.nextInt();
        writer.write("Novo número: " + novoNumero + "\n");

        Endereco novoEndereco = new Endereco(novaCidade, novoBairro, novaRua, novoNumero);
        cliente.setEndereco(novoEndereco);
        System.out.println("Endereço atualizado com sucesso!");
    }
}