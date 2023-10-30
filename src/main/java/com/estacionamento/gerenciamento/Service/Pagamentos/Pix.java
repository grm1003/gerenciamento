package com.estacionamento.gerenciamento.Service.Pagamentos;

import com.estacionamento.gerenciamento.Service.Logger.Logger;

public class Pix implements PagamentosStrategy{
    @Override
    public void realizarPagamento(double valor) {
        Logger logger = Logger.getInstance();
        logger.println("Pagamento via pix de R$" + valor);
    }
}
