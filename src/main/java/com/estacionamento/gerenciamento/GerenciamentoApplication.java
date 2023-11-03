package com.estacionamento.gerenciamento;

import com.estacionamento.gerenciamento.Entity.Cartao;
import com.estacionamento.gerenciamento.Entity.Fabrica.Carro;
import com.estacionamento.gerenciamento.Entity.Fabrica.HondaFabrica;
import com.estacionamento.gerenciamento.Repository.CarroRepository;
import com.estacionamento.gerenciamento.Service.Estacionamento.Estacionamento;
import com.estacionamento.gerenciamento.Service.Fachada.EstacionamentoFachada;
import com.estacionamento.gerenciamento.Service.Observer.DisplayObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableMongoRepositories
public class GerenciamentoApplication {
	@Autowired
	static CarroRepository carroRepository;

	public static void main(String[] args) {

		HondaFabrica honda = new HondaFabrica();
		Carro fit = honda.criaCarro("KHM1092","FIT");
		EstacionamentoFachada estacionamentoFachada = new EstacionamentoFachada(0.12, 3);
		carroRepository.save(fit);


	}

}
