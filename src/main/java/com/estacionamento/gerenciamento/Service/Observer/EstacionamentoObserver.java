package com.estacionamento.gerenciamento.Service.Observer;

import com.estacionamento.gerenciamento.Entity.Estrutura.PisoEstacionamento;

public interface EstacionamentoObserver {
    public void adicionarObserver(Observer observer);
    public void excluirObserver(Observer observer);
    public void notificarObserver(PisoEstacionamento pisos);
}
