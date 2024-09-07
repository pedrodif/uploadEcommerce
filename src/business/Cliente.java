package business;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Cliente {
    private String nome, cpf, email;
    private int codCliente, codEndereco, codOrcamento;

    private ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
    private ArrayList<Orcamento> orcamentos = new ArrayList<Orcamento>();

    public Cliente(int codCliente, String cpf) {
        this.cpf = cpf;
        this.codEndereco = 0;
        this.codOrcamento = 0;
        this.codCliente = codCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("E-mail inválido");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if (nome.matches("[A-Za-zÀ-ÖØ-öø-ÿ\\s]+")) {
            this.nome = nome;
        } else {
            throw new Exception("O nome não deve conter números ou símbolos.");
        }
    }

    public void incrementarCodEndereco() {
        this.codEndereco++;
    }

    public boolean cadastrarEndereco(int cep, String logradouro, int numero,
            String bairro,
            String cidade, String estado) {

        incrementarCodEndereco();
        return this.enderecos.add(new Endereco(this.codEndereco, cep, logradouro, numero, bairro, cidade, estado));
    }

    public List<Endereco> getAllEnderecos() {
        return Collections.unmodifiableList(this.enderecos);
    }

    public void incrementarCodOrcamento() {
        this.codOrcamento++;
    }

    public boolean cadastrarOrcamentos(double valorTotal) {
        incrementarCodOrcamento();
        return this.orcamentos.add(new Orcamento(this.codOrcamento, valorTotal));
    }

    public Orcamento getOrcamentoPorCodigo(int codOrcamento) {
        return this.orcamentos.stream().filter(orcamento -> orcamento.getCodOrcamento() == codOrcamento).findFirst()
                .orElse(null);
    }

    public List<Orcamento> getAllOrcamentos() {
        return Collections.unmodifiableList(this.orcamentos);
    }
}