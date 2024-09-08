package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import business.Orcamento;
import business.Produto;

public class OrcamentoTest {
    private Orcamento orcamento;

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

    @Test
    void testConfirmarPgtos() {
        Produto speaker = new Produto(1, "Speaker");
        speaker.setValorProduto(225.50);

        orcamento.cadastrarItemOrcamento(speaker, 2);
    }
}
