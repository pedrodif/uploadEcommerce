package business;

import java.util.ArrayList;

public class MeioPagamento {
    private int numParcelas;
    private double taxaCartao;

    private TipoPagamento tipoPagamento;
    private final int NUM_MAXPARCELAS = 3;
    private ArrayList<Pagamento> pagamentos;

    public MeioPagamento(String tipoPagamento) {
        try {
            this.tipoPagamento = TipoPagamento.valueOf(tipoPagamento.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo do pagamento inválido");
        }

        this.pagamentos = new ArrayList<Pagamento>();
    }

    public TipoPagamento getTipoPgto() {
        return tipoPagamento;
    }

    public double getTaxaCartao() {
        return taxaCartao;
    }

    public void setTaxaCartao(int taxaCartao) throws Exception {
        if (tipoPagamento == TipoPagamento.CARTAO_CREDITO) {
            this.taxaCartao = (double) taxaCartao / 100;
        } else {
            throw new Exception("A taxa só pode ser associada se o tipo do pagamento for cartão de crédito");
        }
    }

    public int getNUM_MAXPARCELAS() {
        return NUM_MAXPARCELAS;
    }

    public int getNumParcelas() {
        return numParcelas;
    }

    public void setNumParcelas(int numParcelas) throws Exception {
        if (tipoPagamento == TipoPagamento.CARTAO_CREDITO) {
            if (numParcelas > NUM_MAXPARCELAS) {
                throw new IllegalArgumentException("Numero de parcelas excede o permitido");
            } else if (numParcelas < 1) {
                throw new IllegalArgumentException("Numero de parcelas precisa ser maior que zero");
            }

            this.numParcelas = numParcelas;
        } else {
            throw new Exception(
                    "Só é possível cadastrar o número de parcelas se o tipo do pagamento for cartão de crédito");
        }
    }

    public boolean addPagamento(Pagamento pagamento) {
        return this.pagamentos.add(pagamento);
    }
}