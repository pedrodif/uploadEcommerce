package business;

public class Endereco {
    private int codEndereco, numero, cep;
    private String logradouro, complemento, bairro, cidade, estado;

    public Endereco(int codEndereco, int cep, String logradouro, int numero, String bairro,
            String cidade, String estado) {
        this.cep = cep;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.logradouro = logradouro;
        this.codEndereco = codEndereco;
    }

    public int getCodEndereco() {
        return codEndereco;
    }

    public int getNumero() {
        return numero;
    }

    public int getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
