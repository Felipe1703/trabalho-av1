public  abstract class  Veiculo {
    private int id;
    private String cor;
    private String marca;
    private String modelo;
    private String placa;
    private int ano;
    private double preco;
    private double km;


    public Veiculo(int id, String cor, String marca, String modelo, String placa, int ano, double preco, double km) {
        this.id = id;
        this.cor = cor;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.preco = preco;
        this.km = km;
    }

    
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getCor() {
        return cor;
    }


    public void setCor(String cor) {
        this.cor = cor;
    }


    public String getMarca() {
        return marca;
    }


    public void setMarca(String marca) {
        this.marca = marca;
    }


    public String getModelo() {
        return modelo;
    }


    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public String getPlaca() {
        return placa;
    }


    public void setPlaca(String placa) {
        this.placa = placa;
    }


    public int getAno() {
        return ano;
    }


    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreço(double preco) {
        this.preco = preco;
    }

    public double getKm() {
        return km;
    }   

    public void setKm(double km) {  
        this.km = km;
    }

    // public abstract String getDetalhes();

}
