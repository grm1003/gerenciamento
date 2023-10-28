package com.estacionamento.gerenciamento.Service.Fachada;

import com.estacionamento.gerenciamento.Entity.Cartao;
import com.estacionamento.gerenciamento.Entity.Estrutura.PisoEstacionamento;
import com.estacionamento.gerenciamento.Entity.Fabrica.Carro;

import java.util.ArrayList;

public class EstacionamentoFachada {
    private final double minuto = 0.10;
    private final double hora = 6.0;


    public void EstacionamentoAbre(){
        ArrayList<PisoEstacionamento> pisos = new ArrayList<>();
        PisoEstacionamento piso1 = new PisoEstacionamento("Piso 1", 50);
        PisoEstacionamento piso2 = new PisoEstacionamento("Piso 2", 30);
        pisos.add(piso1);
        pisos.add(piso2);
    }

    public void EntraCarro(PisoEstacionamento piso, int vaga, Carro carro){
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
    public void SaiCarro(PisoEstacionamento piso, int vaga, Carro carro){
        try {
            if(piso.ContaVagasDisponiveis() < piso.tamanhoEstacionamento()){
                piso.LiberaVaga(vaga, carro);
                double total = carro.getCartao().registrarSaida();
                System.out.println("Pagamento");
            }
        }catch (Exception e){
            System.out.println("Erro: "+ e);
        }
    }
}
