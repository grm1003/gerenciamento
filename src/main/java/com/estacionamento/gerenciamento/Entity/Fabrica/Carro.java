package com.estacionamento.gerenciamento.Entity.Fabrica;

import com.estacionamento.gerenciamento.Entity.Cartao;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Carro {
    Cartao cartao;

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public Cartao getCartao() {
        return cartao;
    }

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
