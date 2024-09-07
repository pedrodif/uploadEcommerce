package business;

public class ItemDeOrcamento {
    private int quantidade;
    private Produto produto;
    private double valorItemOrcamento;

    public ItemDeOrcamento(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorItemOrcamento = this.produto.getValorProduto() * this.quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public double getValorItemOrcamento() {
        return this.valorItemOrcamento;
    }
}