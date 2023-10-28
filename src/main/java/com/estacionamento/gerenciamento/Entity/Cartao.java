package com.estacionamento.gerenciamento.Entity;

import com.estacionamento.gerenciamento.Entity.Fabrica.Carro;

import java.time.Duration;
import java.time.LocalDateTime;

public class Cartao {
    private  double preco_min;
    private  double preco_horas;
    Carro carro;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private double total;

    public Cartao(double preco_min, double preco_horas, Carro carro) {
        this.preco_min = preco_min;
        this.preco_horas = preco_horas;
        this.carro = carro;
        registrarEntrada();
        this.saida = null;
        this.total = 0;
    }

    public void registrarEntrada() {
        entrada = LocalDateTime.now();
    }

    public double registrarSaida() {
        saida = LocalDateTime.now();
        Duration duration = calcularDuracao();
        if(duration != null){
            this.total = calcularValor(duration.toHoursPart(), duration.toMinutesPart());
        }
        return total;

    }

    public Duration calcularDuracao() {
        if (entrada != null && saida != null) {
            return Duration.between(entrada, saida);
        }
        return null;
    }

    private double calcularValor(int horas, int minutos){
        return (horas*preco_horas)+(minutos*preco_min);
    }



}
