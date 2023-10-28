package com.estacionamento.gerenciamento.Service.Estacionamento;

import com.estacionamento.gerenciamento.Entity.Estrutura.PisoEstacionamento;
import com.estacionamento.gerenciamento.Entity.Fabrica.Carro;
import com.estacionamento.gerenciamento.Entity.Fabrica.HondaFabrica;
import com.estacionamento.gerenciamento.Service.Fachada.EstacionamentoFachada;

import java.util.ArrayList;

public class EstacionamentoMain {
    public static void main(String[] args) {
        HondaFabrica honda = new HondaFabrica();
        Carro fit = honda.criaCarro("KHM1092","FIT");
        EstacionamentoFachada estacionamentoFachada = new EstacionamentoFachada();
        Estacionamento estacionamento = new Estacionamento();
        estacionamentoFachada.estacionamentoAbre(estacionamento.getPisos());
        estacionamentoFachada.entraCarro(estacionamento.getPisos().get(0),4,fit);
        estacionamentoFachada.saiCarro(estacionamento.getPisos().get(0),4,fit,"Pix");

    }
}
