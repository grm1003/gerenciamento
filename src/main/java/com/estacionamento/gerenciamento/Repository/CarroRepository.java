package com.estacionamento.gerenciamento.Repository;

import com.estacionamento.gerenciamento.Entity.Fabrica.Carro;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends MongoRepository<Carro, String> {
}
