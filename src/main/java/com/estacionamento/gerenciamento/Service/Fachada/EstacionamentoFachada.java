package com.estacionamento.gerenciamento.Service.Fachada;

import com.estacionamento.gerenciamento.Entity.Cartao;
import com.estacionamento.gerenciamento.Entity.Estrutura.PisoEstacionamento;
import com.estacionamento.gerenciamento.Entity.Estrutura.Vaga;
import com.estacionamento.gerenciamento.Entity.Fabrica.Carro;
import com.estacionamento.gerenciamento.Service.Pagamentos.CartaoCrédito;
import com.estacionamento.gerenciamento.Service.Pagamentos.CartaoDédito;
import com.estacionamento.gerenciamento.Service.Pagamentos.PagamentosStrategy;
import com.estacionamento.gerenciamento.Service.Pagamentos.Pix;

import java.util.ArrayList;

public class EstacionamentoFachada {
    private  double minuto;
    private  double hora;

    public EstacionamentoFachada(double minuto, double hora) {
        this.minuto = minuto;
        this.hora = hora;
    }

    //seta por padrão quantidade de vagas e nome dos pisos
    public void estacionamentoAbre(ArrayList<PisoEstacionamento> pisos){
        PisoEstacionamento piso1 = new PisoEstacionamento("Piso 1", 50);
        PisoEstacionamento piso2 = new PisoEstacionamento("Piso 2", 30);
        pisos.add(piso1);
        pisos.add(piso2);
    }

    //processo de entrada de um carro no estacionamento
    public Cartao entraCarro(PisoEstacionamento piso, int vaga, Carro carro){
        try {
            //verifica se estacionamento não está cheio
            if(!piso.EstaCheio()){
                //preenche vaga com o carro
                piso.PreencheVaga(vaga, carro);

                //Cria um novo cartão para o carro que acabou de entrar
                return new Cartao(minuto,hora, carro);

                //teriamos que salvar esse cartão em algum banco de dados para salvar as informações
            }else System.out.println("Estacionameto ocupado");
        }catch (Exception e){
            System.out.println("Erro: "+ e);
        }
        return null;
    }

    //processo de saida de um carro no estacionamento
    public void saiCarro(PisoEstacionamento piso, int vaga, Cartao cartao, String tipoPagamento){
        CartaoCrédito cartaoCredito = new CartaoCrédito();
        CartaoDédito cartaoDedito = new CartaoDédito();
        Pix pix = new Pix();
        try {
            //verifica se tem vagas preenchidas
            if(piso.ContaVagasDisponiveis() < piso.tamanhoEstacionamento()){
                Vaga[] verif = piso.getVagas();
            if(verif[vaga].isVazia()) throw new IllegalStateException("Vaga está vazia");

            //retorna valor a ser pago e guarda em total
                double total = cartao.registrarSaida();

                //setar metodo de pagamento a preferencia do usuário
                if(tipoPagamento.equals("Pix"))cartao.setPagamentoStrategy(pix);
                if(tipoPagamento.equals("Crédito"))cartao.setPagamentoStrategy(cartaoCredito);
                if(tipoPagamento.equals("Débito")) cartao.setPagamentoStrategy(cartaoDedito);

                //realiza o pagamento do cartao e seta cartao como pago
                cartao.realizaPagamento(total);

                //verifica se foi pago se sim ele libera a vaga do carro
                if(cartao.isPago())piso.LiberaVaga(vaga);

                //salvar registro de banco de pagamento e utilização da vaga
                System.out.println("Carro saiu do estacionamento");
            }
        }catch (Exception e){
            System.out.println("Erro: "+ e);
        }
    }
}
