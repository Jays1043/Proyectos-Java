package com.mycompany.ejemploimpoarch;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author aleja
 */
public class EjemploImpoArch {

    public static void main(String[] args){
    //Leer un archivos
        String ubicacion = "C:\\Users\\aleja\\Desktop\\Info.txt";
        try {
            String contenido = Files.readAllLines(Paths.get(ubicacion));
            System.out.println(contenido);
        } catch (IOException ex){
            System.out.println("Ocurrio un error al tratar de leer el archivo");
        }
    }
    public static void escribir(){
    //Escribir un archivo
        String ubicacion = "C:\\Users\\aleja\\Desktop\\Info.txt";
        try(FileWriter fw = new FileWriter(ubicacion, true)){
            fw.write("Sos tronco");
        } catch (IOException ex){
            System.out.println("Ocurrio un error.");
        }
        System.out.println("Archivo creado exitosamente.");
    }
}


