package com.estacionamento.gerenciamento.Entity.Fabrica;

import com.estacionamento.gerenciamento.Entity.Cartao;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
public class Carro {

    String placa;
    String modelo;
    String marca;

    public Carro(String placa, String modelo, String marca) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Carro (" +
                "placa= " + placa +
                ", modelo= " + modelo +
                ", marca= " + marca +
                ')';
    }
}
