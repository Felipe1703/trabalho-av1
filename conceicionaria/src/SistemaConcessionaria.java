import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaConcessionaria {

    private static Concessionaria concessionaria = new Concessionaria();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer de nova linha

            switch (opcao) {
                case 1:
                    cadastrarVeiculo();
                    break;
                case 2:
                    listarVeiculos();
                    break;
                case 3:
                    buscarVeiculo();
                    break;
                case 4:
                    atualizarVeiculo();
                    break;
                case 5:
                    removerVeiculo();
                    break;
                case 6:
                    continuar = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n--- Sistema de Concessionária ---");
        System.out.println("1. Cadastrar Veículo");
        System.out.println("2. Listar Veículos");
        System.out.println("3. Buscar Veículo");
        System.out.println("4. Atualizar Veículo");
        System.out.println("5. Remover Veículo");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarVeiculo() {
        System.out.println("Escolha o tipo de veículo:");
        System.out.println("1. Carro");
        System.out.println("2. Moto");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        System.out.print("Cor: ");
        String cor = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        System.out.print("Quilometragem: ");
        double km = scanner.nextDouble();
        Veiculo veiculo = null;
        if (tipo == 1) {
           veiculo = VeiculoFactory.criarVeiculo(tipo, cor, marca, modelo, placa, ano, preco, km, 1, null);
        }else{
          veiculo = VeiculoFactory.criarVeiculo(tipo, cor, marca, modelo, placa, ano, preco, km, null, 1);
        }
        //Veiculo veiculo = VeiculoFactory.criarVeiculo(tipo, cor, marca, modelo, placa, ano, preco, km, 1, null);
        if (veiculo != null) {
            concessionaria.adicionar(veiculo);
            System.out.println("Veículo cadastrado com sucesso!");
        } else {
            System.out.println("Tipo de veículo inválido.");
        }
    }

    private static void listarVeiculos() {
        System.out.println("--- Veículos Cadastrados ---");
        for (Veiculo veiculo : concessionaria.listar()) {
            System.out.println(veiculo.toString());
        }
    }

    private static void buscarVeiculo() {
        System.out.print("Informe o ID do veículo que deseja buscar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        Veiculo veiculo = concessionaria.buscarVeiculo(id);
        if (veiculo != null) {
            System.out.println(veiculo.toString());
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    private static void atualizarVeiculo() {
        System.out.print("Informe o ID do veículo que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        Veiculo veiculoExistente = concessionaria.buscarVeiculo(id);
        if (veiculoExistente == null) {
            System.out.println("Veículo não encontrado.");
            return;
        }

        System.out.println("Atualizando veículo...");
        System.out.println("Escolha o tipo de veículo:");
        System.out.println("1. Carro");
        System.out.println("2. Moto");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        System.out.print("Nova cor: ");
        String cor = scanner.nextLine();
        System.out.print("Nova marca: ");
        String marca = scanner.nextLine();
        System.out.print("Novo modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Nova placa: ");
        String placa = scanner.nextLine();
        System.out.print("Novo ano: ");
        int ano = scanner.nextInt();
        System.out.print("Novo preço: ");
        double preco = scanner.nextDouble();
        System.out.print("Nova quilometragem: ");
        double km = scanner.nextDouble();
        Veiculo veiculoAtualizado = null;
        if (tipo == 1) {
            veiculoAtualizado = VeiculoFactory.criarVeiculo(tipo, cor, marca, modelo, placa, ano, preco, km, 1, null);
        }else{
            veiculoAtualizado = VeiculoFactory.criarVeiculo(tipo, cor, marca, modelo, placa, ano, preco, km, null, 1);
        }
        if (veiculoAtualizado != null) {
            concessionaria.editar(id, veiculoAtualizado);
            System.out.println("Veículo atualizado com sucesso!");
        } else {
            System.out.println("Tipo de veículo inválido.");
        }
    }

    private static void removerVeiculo() {
        System.out.print("Informe o ID do veículo que deseja remover: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        concessionaria.remover(id);
        System.out.println("Veículo removido com sucesso!");
    }
}
