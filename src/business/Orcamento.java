package business;

import java.util.ArrayList;

public class Orcamento {
    private int codOrcamento;
    private double valorTotal, valorPago, desconto;

    private ArrayList<Pagamento> pagamentos;
    private ArrayList<ItemDeOrcamento> itensDeOrcamento;

    public Orcamento(int codOrcamento) {
        this.desconto = 0.0;
        this.valorPago = 0.0;
        this.valorTotal = 0.0;
        this.codOrcamento = codOrcamento;
        this.pagamentos = new ArrayList<Pagamento>();
        this.itensDeOrcamento = new ArrayList<ItemDeOrcamento>();
    }

    public int getCodOrcamento() {
        return codOrcamento;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = (double) 1 - (desconto / 100);
    }

    public double getValorTotal() {
        setValorTotal();
        return this.valorTotal;
    }

    public void setValorTotal() {
        double valorRecuperado = this.itensDeOrcamento.stream().mapToDouble(item -> item.getValorItemOrcamento()).sum();

        if (this.desconto > 0.0) {
            this.valorTotal = valorRecuperado * this.desconto;
        } else {
            this.valorTotal = valorRecuperado;
        }
    }

    public double getValorPago() {
        setValorPago();
        return this.valorPago;
    }

    public void setValorPago() {
        this.valorPago = this.pagamentos.stream().mapToDouble(pagamento -> pagamento.getValorPagamento()).sum();
    }

    public boolean adicionarItem(Produto produto, int quantidade) {
        return this.itensDeOrcamento.add(new ItemDeOrcamento(produto, quantidade));
    }

    public void cadastrarPagamento(double valorPagamento) throws Exception {
        if (this.pagamentos.size() < 2) {
            this.pagamentos.add(new Pagamento(valorPagamento));
        } else {
            throw new Exception("Excede o número de pegamentos por orçamento");
        }
    }

    public boolean confirmarPgtos() {
        setValorTotal();
        setValorPago();

        if (this.valorPago == this.valorTotal) {
            return true;
        } else {
            return false;
        }
    }
}
