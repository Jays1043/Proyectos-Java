/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;


public class Tipo {
    private int codigo;
    private String nombre;
    
    public Tipo(){
    
    }
    
    public Tipo(int codigo, String nombre){
          this.codigo = codigo;
          this.nombre = nombre;
    }
    
    public int getCodigo(){
    return this.codigo;
    }
    
    public String getNombre(){
    return this.nombre;
    }
    
    public void setCodigo(int codigo){
       this.codigo = codigo;
    }
    
    public void setNombre(String nombre){
    this.nombre = nombre;
    }
}
