package com.example.Taller2;

public class ValidatorService {

    public String validateData(String ruta) {

        String archivo = "";

        if (ruta.contains(".csv")) {
           archivo = LectorDatos.readCSV(ruta);
        } else if (ruta.contains(".xlsx")) {
            archivo = LectorDatos.readXSLX(ruta);
        }
        return archivo;
    }

}