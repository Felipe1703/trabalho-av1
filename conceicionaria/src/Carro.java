public class Carro extends Veiculo {
    private int quantidadePortas;
    public Carro(int id, String cor, String marca, String modelo, String placa, int ano, double preco, double km, int quantidadePortas) {
        super(id, cor, marca, modelo, placa, ano,preco,km);
        this.quantidadePortas = quantidadePortas;
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }


    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public String toString() {
        return "Carro [quantidadePortas=" + quantidadePortas + ", getQuantidadePortas()=" + getQuantidadePortas()
                + ", getId()=" + getId() + ", getCor()=" + getCor() + ", getMarca()=" + getMarca() + ", getModelo()="
                + getModelo() + ", getPlaca()=" + getPlaca() + ", getAno()=" + getAno() + ", getPreco()=" + getPreco()
                + ", getClass()=" + getClass() + ", getKm()=" + getKm() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }

    // public void getDetalhes() {
    //     System.out.println("Carro: ");  
    //     System.out.println("Quantidade de portas: " + getQuantidadePortas());
    //     System.out.println("Cor: " + getCor());
    //     System.out.println("Placa: " + getPlaca());
    //     System.out.println("Ano: " + getAno());
    //     System.out.println("Preço: " + getPreco());
    //     System.out.println("Km: " + getKm());
    // }

    
}
