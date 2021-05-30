package com.lucasmurilo.desafiozup.resources;

import com.lucasmurilo.desafiozup.entities.Usuario;
import com.lucasmurilo.desafiozup.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        Usuario usuario = service.findById(id);
        return ResponseEntity.ok().body(usuario);
    }
    @PostMapping
    public ResponseEntity<Usuario> insert(@RequestBody  Usuario usuario){
        Usuario obj = service.insert(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
}
