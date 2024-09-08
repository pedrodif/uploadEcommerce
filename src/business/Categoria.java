package business;

import java.util.ArrayList;

public class Categoria {
    private int codCategoria;
    private ArrayList<Produto> produtos;
    private String nomeCategoria, departamento;

    public Categoria(int codCategoria, String nomeCategoria, String departamento) {
        this.codCategoria = codCategoria;
        this.departamento = departamento;
        this.nomeCategoria = nomeCategoria;
        this.produtos = new ArrayList<Produto>();
    }

    public int getCodCategoria() {
        return codCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public String getDepartamento() {
        return departamento;
    }

    public boolean addProduto(Produto produto) {
        return this.produtos.add(produto);
    }
}
