import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Concessionaria {
    private static final String FILE_NAME = "patio.txt";


    public void adicionar(Veiculo veiculo) {
       try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(formatarVeiculoParaLinha(veiculo));
            writer.newLine();
            System.out.println("Veiculo adicionado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao adicionar veiculo: " + e.getMessage());
        }
    }

    public List<Veiculo> listar(){
        List<Veiculo> veiculos= new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                Veiculo veiculo  = formatarLinhaParaVeiculo(linha);
                veiculos.add(veiculo);
            }
        } catch (IOException e) {
            System.out.println("Erro ao listar veiculos: " + e.getMessage());
        }
        return veiculos;
    }
    public Veiculo buscarVeiculo(int id) {
        List<Veiculo> veiculos = listar(); // Certifique-se de que este método retorna a lista correta
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getId() == id) {
                return veiculo;
            }
        }
        return null; // Retorne null se não encontrar
    }


    public void remover(int id) {
        List<Veiculo> veiculos =  listar();
        boolean removido = veiculos.removeIf(p -> p.getId() == id);

        if (removido) {
           salvarVeiculos(veiculos);
            System.out.println("Veiculo removido.");
        } else {
            System.out.println("Veiculo não encontrado.");
        }
    }

    public void editar(int id, Veiculo nVeiculo) {
        List<Veiculo> veiculos =  listar();
        boolean atualizado = false;
        for (int i = 0; i < veiculos.size(); i++) {
            if (veiculos.get(i).getId() == id) {
                veiculos.set(i, nVeiculo);
                atualizado = true;
                break;
            }
        }

        if (atualizado) {
           salvarVeiculos(veiculos);
            System.out.println("Veiculo atualizado.");
        } else {
            System.out.println("Veiculo não encontrado.");
        }
    }

    private void salvarVeiculos(List<Veiculo> veiculos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Veiculo veiculo: veiculos) {
                writer.write(formatarVeiculoParaLinha(veiculo));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar veiculos: " + e.getMessage());
        }
    }


    private String formatarVeiculoParaLinha(Veiculo veiculo) {
        if (veiculo instanceof Carro) {
            Carro carro = (Carro) veiculo;
            return String.join(";",
                    String.valueOf(veiculo.getId()),
                    veiculo.getCor(),
                    veiculo.getMarca(),
                    veiculo.getModelo(),
                    veiculo.getPlaca(),
                    String.valueOf(veiculo.getAno()),
                    String.valueOf(veiculo.getPreco()),
                    String.valueOf(veiculo.getKm()),
                    String.valueOf(carro.getQuantidadePortas()),
                    "1" // Indica que é um carro
            );
        } else if (veiculo instanceof Moto) {
            Moto moto = (Moto) veiculo;
            return String.join(";",
                    String.valueOf(veiculo.getId()),
                    veiculo.getCor(),
                    veiculo.getMarca(),
                    veiculo.getModelo(),
                    veiculo.getPlaca(),
                    String.valueOf(veiculo.getAno()),
                    String.valueOf(veiculo.getPreco()),
                    String.valueOf(veiculo.getKm()),
                    String.valueOf(moto.getCilindradas()),
                    "2" // Indica que é uma moto
            );
        } else {
            throw new IllegalArgumentException("Veículo inválido");
        }
    }

    private Veiculo formatarLinhaParaVeiculo(String linha) {
        String[] campos = linha.split(";");
        if (campos.length < 5) return null; // Validação simples
    
        int id = Integer.parseInt(campos[0]);
        String cor = campos[1];
        String marca = campos[2];
        String modelo = campos[3];
        String placa = campos[4];
        int ano = Integer.parseInt(campos[5]);
        double preco = Double.parseDouble(campos[6]);
        double km = Double.parseDouble(campos[7]);
        int tipo = Integer.parseInt(campos[8]); // Tipo do veículo
    
        switch (tipo) {
            case 1: // Carro
                int quantidadePortas = Integer.parseInt(campos[9]);
                return new Carro(id, cor, marca, modelo, placa, ano, preco, km, quantidadePortas);
            case 2: // Moto
                int cilindradas = Integer.parseInt(campos[9]);
                return new Moto(id, cor, marca, modelo, placa, ano, preco, km, cilindradas);
            default:
                return null; // Tipo desconhecido
        }
    }
}