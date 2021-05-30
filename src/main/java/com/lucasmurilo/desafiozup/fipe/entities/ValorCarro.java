package com.lucasmurilo.desafiozup.fipe.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ValorCarro {

    @JsonProperty("Valor")
    private String valor;

    public ValorCarro(){

    }
    public String getValor() {
        return valor;
    }
}
