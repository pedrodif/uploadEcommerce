package business;

public class Pagamento {
    private double valorPagamento;

    public Pagamento(double valorPagamento) {
        if (valorPagamento <= 0.0) {
            throw new IllegalArgumentException("O valor do pagamento deve ser maior que zero reais");
        } else {
            this.valorPagamento = valorPagamento;
        }
    }

    public double getValorPagamento() {
        return this.valorPagamento;
    }
}
