package com.lucasmurilo.desafiozup.config;


import com.lucasmurilo.desafiozup.entities.Usuario;

import com.lucasmurilo.desafiozup.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository userRepository;



    @Override
    public void run(String... args) throws Exception {


        Usuario u2 = new Usuario(null,45658795874L, "Romario Baixinho", "baixinho@gmail.com", "17/08/1970");
        Usuario u3 = new Usuario(null,45645899785L, "Ronaldo Fenomeno", "fenomeno@gmail.com", "19/11/1975");
        Usuario u4 = new Usuario(null, 99854789665L, "Lionel Messi", "messi@gmail.com", "09/01/1987");
        userRepository.saveAll(Arrays.asList(u2, u3, u4));

    }
}
