package com.lucasmurilo.desafiozup.fipe.entities;

import com.lucasmurilo.desafiozup.entities.Carro;
import com.lucasmurilo.desafiozup.exceptions.ResourceNotFoundException;
import com.lucasmurilo.desafiozup.fipe.FeingFipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TratamentoFipe {

    @Autowired
    private FeingFipe feingFipe;

    public String getValor(Carro carro){
        Marca marca = feingFipe.getMarca()
                .stream()
                .filter(m -> m.getNome().equalsIgnoreCase(carro.getMarca()))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException(carro.getMarca()));

        String codigoMarca = marca.getCodigo();

        Modelos.Modelo modelo = feingFipe.getModelo(codigoMarca).getModelos()
                .stream()
                .filter(md -> md.getNome().equalsIgnoreCase(carro.getModelo()))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException(carro.getModelo()));

        String codigoModelo = modelo.getCodigo();

        AnoCarro ano = feingFipe.getAno(codigoMarca, codigoModelo)
                .stream()
                .filter(a -> a.getNome().equalsIgnoreCase(carro.getAno()))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException(carro.getAno()));

        String codigoAno = ano.getCodigo();
        ValorCarro valorCarro = feingFipe.getValor(codigoMarca,codigoModelo,codigoAno);
        return valorCarro.getValor();
    }
}
