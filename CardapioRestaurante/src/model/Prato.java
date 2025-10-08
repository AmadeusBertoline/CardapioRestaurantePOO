package model;

public class Prato {
    long id;
    public String codigo;
    public String nome;
    public int calorias;
    public double preco;
    public String ingredientes;

    public Prato(long id, String codigo, String nome, int calorias, double preco, String ingredientes) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.calorias = calorias;
        this.preco = preco;
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Calorias: " + calorias + ", Preço: R$ " + preco;
    }

    public boolean equals(Prato outroPrato) {
        if (outroPrato == null) return false;
        return this.codigo.equals(outroPrato.codigo);
    }
}
