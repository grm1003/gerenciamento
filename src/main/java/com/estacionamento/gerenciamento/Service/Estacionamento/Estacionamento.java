package com.estacionamento.gerenciamento.Service.Estacionamento;

import com.estacionamento.gerenciamento.Entity.Estrutura.PisoEstacionamento;
import com.estacionamento.gerenciamento.Service.Fachada.EstacionamentoFachada;

import java.util.ArrayList;

public class Estacionamento {
   ArrayList<PisoEstacionamento> pisos;

    public Estacionamento() {
        this.pisos = new ArrayList<>();
    }

    public ArrayList<PisoEstacionamento> getPisos() {
        return pisos;
    }

}
