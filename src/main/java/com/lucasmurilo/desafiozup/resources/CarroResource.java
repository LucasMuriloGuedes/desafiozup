package com.lucasmurilo.desafiozup.resources;

import com.lucasmurilo.desafiozup.entities.Carro;
import com.lucasmurilo.desafiozup.fipe.FeingFipe;
import com.lucasmurilo.desafiozup.fipe.entities.TratamentoFipe;
import com.lucasmurilo.desafiozup.services.CarroService;
import com.lucasmurilo.desafiozup.services.RodizioService;
import com.lucasmurilo.desafiozup.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/carros")
public class CarroResource {

    @Autowired
    private CarroService carroService;

    @Autowired
    private TratamentoFipe fipe;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RodizioService rodizioService;

    @PostMapping(value = "/{id}")
    public ResponseEntity<Carro> insert(@RequestBody Carro carro, @PathVariable Long id){
        Carro obj = carro;
        obj.setValor(fipe.getValor(carro));
        obj.setUsuario(usuarioService.findById(id));
        obj.setDiaRodizio(rodizioService.diaRodizio(carro));
        obj.setStatusRodizio(rodizioService.getStatus(obj.getDiaRodizio()));
        carroService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
}
