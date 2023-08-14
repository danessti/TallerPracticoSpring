package com.example.Taller2;

public class LectorDatos {

    public static String readCSV(String route)  {
      return ValidarCSV.validators(route);
    }

    // XLSX Validador
    public static  String readXSLX(String route) {
        return ValidarXLSX.validarXLSX(route);
    }

}