package com.estacionamento.gerenciamento.Repository;

import com.estacionamento.gerenciamento.Entity.Fabrica.Carro;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CarroRepository extends JpaRepository<Carro, Long> {
}
