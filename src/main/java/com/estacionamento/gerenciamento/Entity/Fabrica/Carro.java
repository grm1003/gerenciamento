package com.estacionamento.gerenciamento.Entity.Fabrica;

import com.estacionamento.gerenciamento.Entity.Cartao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@Entity
@Table(name = "Carros")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String modelo;
    private String marca;

    public Long getId() {
        return id;
    }

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
