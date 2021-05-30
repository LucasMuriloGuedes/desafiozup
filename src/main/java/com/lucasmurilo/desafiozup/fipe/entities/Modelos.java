package com.lucasmurilo.desafiozup.fipe.entities;

import java.util.ArrayList;
import java.util.List;

public class Modelos {
    private List<Modelo> modelos = new ArrayList<>();

    public Modelos(){

    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public static class Modelo{

        private String codigo;
        private String nome;

        public Modelo(){

        }
        public Modelo(String codigo, String nome) {
            this.codigo = codigo;
            this.nome = nome;
        }

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
    }
}
