public class Moto extends Veiculo {
    
    private int cilindradas;

    public Moto(int id, String cor, String marca, String modelo, String placa, int ano, double preco, double km, int cilindradas) {
        super(id, cor, marca, modelo, placa, ano,preco,km);
        this.cilindradas = cilindradas;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    @Override
    public String toString() {
        return "Moto [cilindradas=" + cilindradas + ", getCilindradas()=" + getCilindradas() + ", getId()=" + getId()
                + ", getCor()=" + getCor() + ", getMarca()=" + getMarca() + ", getModelo()=" + getModelo()
                + ", getPlaca()=" + getPlaca() + ", getAno()=" + getAno() + ", getPreco()=" + getPreco()
                + ", getClass()=" + getClass() + ", getKm()=" + getKm() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }

   
    // public void getDetalhes() {
    //     System.out.println("Moto: ");
    //     System.out.println("Cor: " + getCor());
    //     System.out.println("Placa: " + getPlaca());
    //     System.out.println("Ano: " + getAno());
    //     System.out.println("Preço: " + getPreco());
    //     System.out.println("Km: " + getKm());
    //     System.out.println("Cilindradas: " + getCilindradas());
    // }

    

}
