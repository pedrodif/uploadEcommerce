package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import business.Pagamento;
import business.MeioPagamento;

public class MeioPagamentoTest {
    private MeioPagamento meioPagamento;

    @Test
    void testCriarMeioPagamentoSucesso() {
        assertNotNull(new MeioPagamento("pix"));
    }

    @Test
    void testCriarMeioPagamentoErro() {
        assertNotNull(new MeioPagamento("paypal"));
    }

    @Test
    void testSetTaxaCartaoErro() throws Exception {
        MeioPagamento meioPagamento = new MeioPagamento("dinheiro");

        meioPagamento.setTaxaCartao(4);
        assertEquals(0.04, meioPagamento.getTaxaCartao());
    }

    @BeforeEach
    public void configMeioPagamento() {
        this.meioPagamento = new MeioPagamento("cartao_credito");
    }

    @Test
    void testSetTaxaCartaoSucesso() throws Exception {
        this.meioPagamento.setTaxaCartao(4);
        assertEquals(0.04, this.meioPagamento.getTaxaCartao());
    }

    @Test
    void testSetNumParcelasSucesso() throws Exception {
        this.meioPagamento.setNumParcelas(2);
        assertEquals(2, this.meioPagamento.getNumParcelas());
    }

    @Test
    void testSetNumParcelasErro() throws Exception {
        this.meioPagamento.setNumParcelas(5);
        assertEquals(5, this.meioPagamento.getNumParcelas());
    }

    @Test
    void testSetNumParcelasErroSegundoCenario() throws Exception {
        this.meioPagamento.setNumParcelas(0);
        assertEquals(0, this.meioPagamento.getNumParcelas());
    }

    @Test
    void testAddPagamento() {
        Pagamento pagamento = new Pagamento(550.00);
        assertTrue(this.meioPagamento.addPagamento(pagamento));
    }
}
