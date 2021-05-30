package com.lucasmurilo.desafiozup.fipe;

import com.lucasmurilo.desafiozup.fipe.entities.AnoCarro;
import com.lucasmurilo.desafiozup.fipe.entities.ValorCarro;
import com.lucasmurilo.desafiozup.fipe.entities.Marca;
import com.lucasmurilo.desafiozup.fipe.entities.Modelos;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(name = "Fipe", url = "https://parallelum.com.br/fipe/api/v1/carros")
public interface FeingFipe {

    @GetMapping("/marcas")
    List<Marca> getMarca();

    @GetMapping("/marcas/{codigo}/modelos")
    Modelos getModelo(@PathVariable String codigo);

    @GetMapping("/marcas/{codigo}/modelos/{codigoModelo}/anos")
    List<AnoCarro> getAno(@PathVariable String codigo, @PathVariable String codigoModelo);

    @GetMapping("/marcas/{codigo}/modelos/{codigoModelo}/anos/{codigoAno}")
    ValorCarro getValor(@PathVariable String codigo, @PathVariable String codigoModelo, @PathVariable String codigoAno);
}
