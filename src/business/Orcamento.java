package business;

import java.util.ArrayList;

public class Orcamento {
    private int codOrcamento;
    private ArrayList<Pagamento> pagamentos;
    private double valorTotal, valorPago, desconto;

    public Orcamento(int codOrcamento, double valorTotal) {
        this.valorTotal = valorTotal;
        this.codOrcamento = codOrcamento;
        this.pagamentos = new ArrayList<Pagamento>();
    }

    public int getCodOrcamento() {
        return codOrcamento;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public boolean adicionarItem() {
        return false;
    }

    public void cadastrarPagamento(double valorPagamento) throws Exception {
        if (this.pagamentos.size() < 2) {
            this.pagamentos.add(new Pagamento(valorPagamento));
        } else {
            throw new Exception("Excede o número de pegamentos por orçamento");
        }
    }

    public boolean confirmarPgtos() {
        this.valorPago = this.pagamentos.stream().mapToDouble(pagamento -> pagamento.getValorPagamento()).sum();

        if (this.valorPago == this.valorTotal) {
            return true;
        } else {
            return false;
        }
    }
}
