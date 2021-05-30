package com.lucasmurilo.desafiozup.repositories;

import com.lucasmurilo.desafiozup.entities.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}
