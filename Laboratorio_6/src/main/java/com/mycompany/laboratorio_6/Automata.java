/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laboratorio_6;

/**
 *
 * @author aleja
 */
public class Automata {
    public boolean parsear(String cadena){
        boolean aceptar = true;
        char estado = 'A';
        
        char[] simbolos = cadena.toCharArray();
        
        for(char simbolo:simbolos){
            switch(estado){
                case 'A' ->{
                    switch(simbolo){
                        case 'c'->{
                            estado = 'B';
                            aceptar = true;
                        }
                        default ->{
                            return false;
                        }
                    }
                }
                case 'B' ->{
                    switch(simbolo){
                        case 'a' ->{
                            estado = 'C';
                            aceptar = false;
                        }
                        case 'b'->{
                            estado = 'C';
                            aceptar = false;
                        }
                        default ->{
                            return false;
                        }
                    }
                }
                case 'C' ->{
                    switch(simbolo){
                        case 'b'->{
                            estado = 'E';
                            aceptar = false;
                        }
                        case 'c'->{
                            estado = 'F';
                            aceptar = true;
                        }
                        default ->{
                            return false;
                        }
                    }
                }
                case 'E' ->{
                    switch(simbolo){
                        case 'a'->{
                            estado = 'F';
                            aceptar = true;
                        }
                        default ->{
                            return false;
                        }
                    }
                }
                case 'F' ->{
                    switch(simbolo){
                        case 'a'->{
                            estado = 'C';
                            aceptar = false;
                        }
                        case 'b'->{
                            estado = 'E';
                            aceptar = false;
                        }
                        default ->{
                            return false;
                        }
                    }
                }
            }
        }
        
        return aceptar;
    }
}
