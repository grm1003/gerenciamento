package com.estacionamento.gerenciamento.Entity.Estrutura;

import com.estacionamento.gerenciamento.Entity.Fabrica.Carro;

public class Vaga {
    private boolean vazia;
    private Carro carro;

    public Vaga(boolean vazia, Carro carro) {
        this.vazia = vazia;
        this.carro = carro;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public boolean isVazia() {
        return vazia;
    }

    public void setVazia(boolean vazia) {
        this.vazia = vazia;
    }
}
