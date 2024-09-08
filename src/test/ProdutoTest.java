package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import business.Produto;

public class ProdutoTest {
    private Produto produto;

    @BeforeEach
    public void configProduto() {
        this.produto = new Produto(2, "Headphone");
    }

    @Test
    void testSetQuantidade() {
        this.produto.setQuantidade(10);
        assertEquals(10, this.produto.getQuantidade());
    }

    @Test
    void testSetValorProduto() {
        this.produto.setValorProduto(150.00);
        assertEquals(150.00, this.produto.getValorProduto());
    }

    @Test
    void testIncluirItemEmOrcamentoSucesso() throws Exception {
        this.produto.setQuantidade(6);
        assertTrue(this.produto.incluirItemEmOrcamento(3));
    }

    @Test
    void testIncluirItemEmOrcamentoErro() throws Exception {
        this.produto.setQuantidade(6);
        assertTrue(this.produto.incluirItemEmOrcamento(8));
    }

    @Test
    void testGenrenciarEstoque() throws Exception {
        this.produto.setQuantidade(4);
        this.produto.incluirItemEmOrcamento(2);
        assertEquals(12, this.produto.getQuantidade());
    }
}
