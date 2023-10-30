package com.estacionamento.gerenciamento.Service.Pagamentos;

import com.estacionamento.gerenciamento.Service.Logger.Logger;

public class CartaoDédito implements PagamentosStrategy{
    @Override
    public void realizarPagamento(double valor) {
        Logger logger = Logger.getInstance();
        logger.println("Pagamento via cartão de débito de R$" + valor);
    }
}
