package com.lucasmurilo.desafiozup.services;

import com.lucasmurilo.desafiozup.entities.Carro;
import com.lucasmurilo.desafiozup.repositories.CarroRepository;
import com.lucasmurilo.desafiozup.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {

    @Autowired
    private CarroRepository repository;

    public Carro insert(Carro carro){
        return repository.save(carro);
    }
}
