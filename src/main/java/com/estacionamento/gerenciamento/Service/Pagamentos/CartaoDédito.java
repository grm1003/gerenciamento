package com.estacionamento.gerenciamento.Service.Pagamentos;

public class CartaoDédito implements PagamentosStrategy{
    @Override
    public void realizarPagamento(double valor) {
        System.out.println("Pagamento via cartão de débito de R$" + valor);
    }
}
