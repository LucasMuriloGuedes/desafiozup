package com.lucasmurilo.desafiozup.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Object obj){
        super("Análise o erro: " +obj);
    }
}
