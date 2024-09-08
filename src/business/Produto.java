package business;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Produto {
    private String nomeProduto;
    private double valorProduto;

    private int codProduto, quantidade;
    private static final int ESTOQUE_MIN = 5;
    private ArrayList<ItemDeOrcamento> itensDeOrcamento;

    public Produto(int codProduto, String nomeProduto) {
        this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
        this.itensDeOrcamento = new ArrayList<ItemDeOrcamento>();
    }

    public int getCodProduto() {
        return codProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean temEstoque(int quantidade) {
        return this.quantidade < quantidade ? false : true;
    }

    public void verificaEstoqueSeguranca() {
        if (this.quantidade < ESTOQUE_MIN) {
            geraPedidoCompra();
        }
    }

    public void addEstoque(int quantidade) {
        this.quantidade += quantidade;
    }

    public void removeEstoque(int quantidade) {
        this.quantidade -= quantidade;
    }

    public void geraPedidoCompra() {
        addEstoque(10);
    }

    public boolean incluirItemEmOrcamento(int quantidade) throws Exception {
        if (temEstoque(quantidade)) {
            removeEstoque(quantidade);
            verificaEstoqueSeguranca();
            return this.itensDeOrcamento.add(new ItemDeOrcamento(this, quantidade));
        } else {
            throw new IllegalArgumentException("Quantidade do produto não disponível em estoque.");
        }
    }

    public List<ItemDeOrcamento> getItensOrcamento() {
        return Collections.unmodifiableList(this.itensDeOrcamento);
    }
}
