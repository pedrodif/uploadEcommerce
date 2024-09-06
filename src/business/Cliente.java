package business;

import java.util.ArrayList;

public class Cliente {
    private int codCliente;
    private String nome, cpf, email;

    private ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
    private ArrayList<Orcamento> orcamentos = new ArrayList<Orcamento>();

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void cadastrarEndereco(int codEndereco, int numero, int cep, String logradouro,
            String bairro,
            String cidade, String estado) {

        this.enderecos.add(new Endereco(codEndereco, numero, cep, logradouro, bairro, cidade, estado));
    }

    public void cadastrarOrcamentos(int codOrcamento, double valorTotal) {
        this.orcamentos.add(new Orcamento(codOrcamento, valorTotal));
    }

    public Orcamento getOrcamentoPorCodigo(int codOrcamento) {
        return this.orcamentos.stream().filter(orcamento -> orcamento.getCodOrcamento() == codOrcamento).findFirst()
                .orElse(null);
    }
}