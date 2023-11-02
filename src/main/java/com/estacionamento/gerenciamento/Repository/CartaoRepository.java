package com.estacionamento.gerenciamento.Repository;

import com.estacionamento.gerenciamento.Entity.Cartao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartaoRepository extends MongoRepository<Cartao, String> {
    List<Cartao> findByPlaca(String placa);
}
