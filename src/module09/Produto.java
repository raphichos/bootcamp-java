package module09;

public class Produto {

        private final String nome;
        private final double preco;
        private final String categoria;

    public Produto(String nome, double preco, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public String formatado() {
            return "Produto: " + this.nome
                    + " | Categoria: " + this.categoria
                    + " | Preco: R$ " + String.format("%.2f", this.preco);
        }
}
