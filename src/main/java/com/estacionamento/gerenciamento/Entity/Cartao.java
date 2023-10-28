package com.estacionamento.gerenciamento.Entity;

import com.estacionamento.gerenciamento.Entity.Fabrica.Carro;
import com.estacionamento.gerenciamento.Service.Pagamentos.PagamentosStrategy;

import java.time.Duration;
import java.time.LocalDateTime;

public class Cartao {
    private final double preco_min;
    private final double preco_horas;
    Carro carro;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private double total;
    private PagamentosStrategy pagamentoStrategy;
    private boolean pago;

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public void setPagamentoStrategy(PagamentosStrategy pagamentoStrategy) {
        this.pagamentoStrategy = pagamentoStrategy;
    }

    public Cartao(double preco_min, double preco_horas, Carro carro) {
        this.preco_min = preco_min;
        this.preco_horas = preco_horas;
        this.carro = carro;
        registrarEntrada();
        this.saida = null;
        this.total = 0;
        this.pago = false;
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

    public void realizaPagamento(double valor) {
        pagamentoStrategy.realizarPagamento(valor);
        setPago(true);
        setPago(true);
    }

    private Duration calcularDuracao() {
        if (entrada != null && saida != null) {
            return Duration.between(entrada, saida);
        }
        return null;
    }

    private double calcularValor(int horas, int minutos){
        return (horas*preco_horas)+(minutos*preco_min);
    }



}
