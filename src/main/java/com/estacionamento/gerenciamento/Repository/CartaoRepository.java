package com.estacionamento.gerenciamento.Repository;

import com.estacionamento.gerenciamento.Entity.Cartao;
import com.estacionamento.gerenciamento.Entity.Fabrica.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
}
