/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.CCSS.AST;

import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class nodoCJS {
    public String texto, ambito, tipo;
    public String Archivo;
    public ArrayList<nodoCJS> hijos;
    public int fila, columna, numeroHijos;
    
    
    public nodoCJS(){
        hijos = new ArrayList<>();
    }
    
    public nodoCJS(String tipo){
        this.tipo = tipo;
        this.Archivo = "CJS";
        hijos = new ArrayList<>();
    }
    
    public nodoCJS(String tipo, int fila, int columna){
        this.tipo = tipo;
        this.fila = fila;
        this.columna = columna;
        hijos = new ArrayList<>();
    }

    public nodoCJS(String texto, String tipo) {
        this.texto = texto;
        this.tipo = tipo;
        hijos = new ArrayList<>();
    }

    public nodoCJS(String texto, String tipo, int fila, int columna) {
        this.texto = texto;
        this.tipo = tipo;
        this.fila = fila;
        this.columna = columna;
        hijos = new ArrayList<>();
    }
    
    public void add(nodoCJS nodocjs){
        if(nodocjs != null){
            hijos.add(nodocjs);
        }
    }
    
}
