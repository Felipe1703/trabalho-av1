
import java.util.concurrent.atomic.AtomicInteger;

class VeiculoFactory {
    private static final AtomicInteger idGenerator = new AtomicInteger(0);

    public static Veiculo criarVeiculo(int tipoVeiculo, String cor, String marca, String modelo, String placa,
            int ano, double preco, double km, Integer quantidadePortas, Integer cilindradas) {
        int id = idGenerator.incrementAndGet(); // Gera um ID único para o veículo

        switch (tipoVeiculo) {
            case 1: // Carro
                if (quantidadePortas == null) {
                    throw new IllegalArgumentException("Quantidade de portas é obrigatória para carros.");
                }
                return new Carro(id, cor, marca, modelo, placa, ano, preco, km, quantidadePortas);
            case 2: // Moto
                if (cilindradas == null) {
                    throw new IllegalArgumentException("Cilindradas são obrigatórias para motos.");
                }
                return new Moto(id, cor, marca, modelo, placa, ano, preco, ano, cilindradas);
            default:
                throw new IllegalArgumentException("Tipo de veículo inválido.");
        }
    }
}
