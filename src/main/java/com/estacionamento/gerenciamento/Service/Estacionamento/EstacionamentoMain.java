package com.estacionamento.gerenciamento.Service.Estacionamento;

import com.estacionamento.gerenciamento.Entity.Cartao;
import com.estacionamento.gerenciamento.Entity.Fabrica.Carro;
import com.estacionamento.gerenciamento.Entity.Fabrica.HondaFabrica;
import com.estacionamento.gerenciamento.Service.Fachada.EstacionamentoFachada;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class EstacionamentoMain {
    public static void main(String[] args) {
        HondaFabrica honda = new HondaFabrica();
        Carro fit = honda.criaCarro("KHM1092","FIT");
        EstacionamentoFachada estacionamentoFachada = new EstacionamentoFachada(0.12, 3);
        Estacionamento estacionamento = new Estacionamento();
        estacionamentoFachada.estacionamentoAbre(estacionamento.getPisos());
        Cartao hondafit = estacionamentoFachada.entraCarro(estacionamento.getPisos().get(0),4,fit);
        hondafit.setEntrada(LocalDateTime.now().minusHours(2).minusMinutes(2));
        estacionamentoFachada.saiCarro(estacionamento.getPisos().get(0),4,hondafit,"Pix");

    }
}
