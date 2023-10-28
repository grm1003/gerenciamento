package com.estacionamento.gerenciamento.Service.Pagamentos;

public class CartaoCrédito implements PagamentosStrategy{
    @Override
    public void realizarPagamento(double valor) {
        System.out.println("Pagamento via cartão de crédito de R$" + valor);
    }
}
