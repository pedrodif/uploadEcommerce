package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import business.Produto;
import business.Orcamento;

public class OrcamentoTest {
    private Orcamento orcamento;
    private Produto produto;

    @BeforeEach
    public void configOrcamento() {
        this.orcamento = new Orcamento(1);
    }

    @Test
    void testCadastrarPagamentoSucesso() throws Exception {
        for (int i = 0; i < 2; i++) {
            assertTrue(this.orcamento.cadastrarPagamento(550.00));
        }
    }

    @Test
    void testCadastrarPagamentoErro() throws Exception {
        for (int i = 0; i < 3; i++) {
            assertTrue(this.orcamento.cadastrarPagamento(550.00));
        }
    }

    @BeforeEach
    public void configProduto() {
        this.produto = new Produto(1, "Speaker");
    }

    @Test
    void testSetDesconto() {
        this.produto.setValorProduto(225.00);
        this.orcamento.cadastrarItemOrcamento(produto, 2);
        assertEquals(427.50, this.orcamento.getValorTotal());
    }

    @Test
    void testConfirmarPgtosSucesso() throws Exception {
        this.produto.setValorProduto(225.00);
        this.orcamento.cadastrarItemOrcamento(produto, 3);
        this.orcamento.setDesconto(6);

        for (int i = 0; i < 2; i++) {
            this.orcamento.cadastrarPagamento(317.25);
        }

        assertTrue(this.orcamento.confirmarPgtos());
    }

    @Test
    void testConfirmarPgtosErro() throws Exception {
        this.produto.setValorProduto(225.00);
        this.orcamento.cadastrarItemOrcamento(produto, 3);

        for (int i = 0; i < 2; i++) {
            this.orcamento.cadastrarPagamento(237.50);
        }

        assertTrue(this.orcamento.confirmarPgtos());
    }
}
