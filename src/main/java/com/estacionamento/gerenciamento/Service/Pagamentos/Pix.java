package com.estacionamento.gerenciamento.Service.Pagamentos;

public class Pix implements PagamentosStrategy{
    @Override
    public void realizarPagamento(double valor) {
        System.out.println("Pagamento via pix de R$" + valor);
    }
}
