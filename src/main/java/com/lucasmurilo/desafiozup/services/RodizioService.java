package com.lucasmurilo.desafiozup.services;

import com.lucasmurilo.desafiozup.entities.Carro;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class RodizioService {

    public String diaRodizio(Carro carro){
        String ano = carro.getAno();
        String finalAno = ano.substring(3,4);
        String diaSemana = null;
        switch (finalAno){
            case "0":
            case "1":
                diaSemana = "segunda-feira";
                break;

            case "2":
            case "3":
                diaSemana = "terça-feira";
                break;

            case "4":
            case "5":
                diaSemana = "quarta-feira";
                break;
            case "6":
            case "7":
                diaSemana = "quinta-feira";
                break;

            case "8":
            case "9":
                diaSemana = "sexta-feira";
                break;
        }
        return diaSemana;
    }

   public Boolean getStatus(String diaRodizio){
        String statusRodizio = new SimpleDateFormat("EEEE").format(new Date());
        if(diaRodizio.equals(statusRodizio)){
            return true;
        }else{

            return false;
        }
   }
}
