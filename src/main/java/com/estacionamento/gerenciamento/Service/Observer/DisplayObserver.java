package com.estacionamento.gerenciamento.Service.Observer;

public class DisplayObserver implements Observer{
    @Override
    public void update(String nome, int vagas) {
        System.out.println( nome + " Vagas Disponíveis : " + vagas );
    }
}
