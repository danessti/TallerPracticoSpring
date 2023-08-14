package com.example.Taller2;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ValidarXLSX {

    static List<List<String>> validData = new ArrayList<>();
    static List<List<String>> invalidData = new ArrayList<>();

    public static String validarXLSX(String route) {

        int validador = 0;
        int invalidador = 0;

        Set<String> tipoReporte = new HashSet<>();
        tipoReporte.add("Near Miss");
        tipoReporte.add("Lost Time");
        tipoReporte.add("First Aid");

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(route));

            XSSFSheet sheet = workbook.getSheet("SafetyData");
            XSSFRow file = null;
            int i=0;

            while((file = sheet.getRow(i)) != null){

                if(!file.getCell(1).getStringCellValue().equals("N/A") && tipoReporte
                        .contains(file.getCell(7).getStringCellValue())){
                    validador++;
                }else{
                    invalidador++;
                }
                i++;
            }

        }catch(IOException e){
            e.printStackTrace();
        }

        return "Datos válidos " + validador + " Datos inválidos " + invalidador;
    }

}