package com.estacionamento.gerenciamento.Service.Fachada;

import com.estacionamento.gerenciamento.Entity.Cartao;
import com.estacionamento.gerenciamento.Entity.Estrutura.PisoEstacionamento;
import com.estacionamento.gerenciamento.Entity.Fabrica.Carro;
import com.estacionamento.gerenciamento.Service.Pagamentos.CartaoCrédito;
import com.estacionamento.gerenciamento.Service.Pagamentos.CartaoDédito;
import com.estacionamento.gerenciamento.Service.Pagamentos.PagamentosStrategy;
import com.estacionamento.gerenciamento.Service.Pagamentos.Pix;

import java.util.ArrayList;

public class EstacionamentoFachada {
    private final double minuto = 0.10;
    private final double hora = 6.0;


    public void estacionamentoAbre(ArrayList<PisoEstacionamento> pisos){
        PisoEstacionamento piso1 = new PisoEstacionamento("Piso 1", 50);
        PisoEstacionamento piso2 = new PisoEstacionamento("Piso 2", 30);
        pisos.add(piso1);
        pisos.add(piso2);
    }

    public void entraCarro(PisoEstacionamento piso, int vaga, Carro carro){
        try {
            if(!piso.EstaCheio()){
                piso.PreencheVaga(vaga, carro);
                Cartao novo = new Cartao(minuto,hora, carro);
                carro.setCartao(novo);
            }
        }catch (Exception e){
            System.out.println("Erro: "+ e);
        }
    }
    public void saiCarro(PisoEstacionamento piso, int vaga, Carro carro, String tipoPagamento){
        CartaoCrédito cartaoCrédito = new CartaoCrédito();
        CartaoDédito cartaoDédito = new CartaoDédito();
        Pix pix = new Pix();
        try {
            if(piso.ContaVagasDisponiveis() < piso.tamanhoEstacionamento()){
                double total = carro.getCartao().registrarSaida();
                if(tipoPagamento.equals("Pix"))carro.getCartao().setPagamentoStrategy(pix);
                if(tipoPagamento.equals("Crédito"))carro.getCartao().setPagamentoStrategy(cartaoCrédito);
                else carro.getCartao().setPagamentoStrategy(cartaoDédito);
                carro.getCartao().realizaPagamento(total);
                if(carro.getCartao().isPago())piso.LiberaVaga(vaga, carro);
                System.out.println("Carro saiu do estacionamento");
            }
        }catch (Exception e){
            System.out.println("Erro: "+ e);
        }
    }
}
