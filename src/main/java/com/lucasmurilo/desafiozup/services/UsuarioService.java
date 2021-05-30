package com.lucasmurilo.desafiozup.services;

import com.lucasmurilo.desafiozup.entities.Usuario;
import com.lucasmurilo.desafiozup.exceptions.ResourceNotFoundException;
import com.lucasmurilo.desafiozup.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    private Usuario obj;

    public Usuario findById(Long id){
       Optional<Usuario> obj = repository.findById(id);
       return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Usuario insert(Usuario usuario){
        try {
            obj = repository.save(usuario);
        }catch(DataIntegrityViolationException e){
            throw new ResourceNotFoundException("CPF ou e-mail registrados em nossa base de dados!");
        }
        return obj;
    }


}
