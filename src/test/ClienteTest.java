package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import business.Cliente;
import business.Orcamento;

public class ClienteTest {
    private Cliente cliente;

    @BeforeEach
    public void configCliente() {
        this.cliente = new Cliente(1, "118.502.366-66");
    }

    @Test
    void testSetNomeSucesso() throws Exception {
        this.cliente.setNome("Pedro Ferreira");
        assertEquals("Pedro Ferreira", this.cliente.getNome());
    }

    @Test
    void testSetNomeErro() throws Exception {
        this.cliente.setNome("Pedro125**");
        assertEquals("Pedro125**", this.cliente.getNome());
    }

    @Test
    void testSetEmailSucesso() throws Exception {
        this.cliente.setEmail("pedrodif@icloud.com");
        assertEquals("pedrodif@icloud.com", this.cliente.getEmail());
    }

    @Test
    void testSetEmailErro() throws Exception {
        this.cliente.setEmail("pedrodificloud.com");
        assertEquals("pedrodificloud.com", this.cliente.getEmail());
    }

    @Test
    void testCadastrarEndereco() {
        assertTrue(this.cliente.cadastrarEndereco(34710210, "Rua Diana", 382, "Ana Lúcia", "Sabará", "MG"));
    }

    @Test
    void testCadastrarOrcamentos() {
        assertTrue(this.cliente.cadastrarOrcamentos(550.00));
    }

    @Test
    void testGetOrcamentoPorCodigo() {
        this.cliente.cadastrarOrcamentos(550.00);
        List<Orcamento> orcamentos = this.cliente.getAllOrcamentos();
        assertEquals(orcamentos.get(0), this.cliente.getOrcamentoPorCodigo(1));
    }
}
