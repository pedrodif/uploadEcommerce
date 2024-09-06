package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import business.Pagamento;

public class PagamentoTest {
    @Test
    void testCriarPagamentoSucesso() {
        assertNotNull(new Pagamento(550.00));
    }

    @Test
    void testCriarPagamentoErro() {
        assertNotNull(new Pagamento(0.0));
    }
}
