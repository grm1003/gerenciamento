package com.estacionamento.gerenciamento.Repository;

import com.estacionamento.gerenciamento.Entity.Cartao;
import com.estacionamento.gerenciamento.Entity.Fabrica.Carro;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends MongoRepository<Carro, String> {
    Carro findByPlaca(String placa);
}
