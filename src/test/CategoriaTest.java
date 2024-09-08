package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import business.Produto;
import business.Categoria;

public class CategoriaTest {
    private Categoria categoria;

    @BeforeEach
    public void configCategoria() {
        this.categoria = new Categoria(1, "Áudio Stream", "Eletrônicos");
    }

    @Test
    void testAddProduto() {
        Produto speaker = new Produto(1, "Speaker");
        assertTrue(categoria.addProduto(speaker));
    }
}
