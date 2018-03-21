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
public class nodo {
    public String texto, tipo;
    public int cantidadHijos;
    public ArrayList<nodo> hijos;
    public int fila, columna;
    public String archivo;

    public ArrayList<nodo> getHijos() {
        return hijos;
    }
    
    
    public nodo(){
        hijos = new ArrayList<>();
        this.archivo = "CCSS";
        this.cantidadHijos= 0;
    }
    
    public nodo(String tipo){
        this.tipo = tipo;
        hijos = new ArrayList<>();
        this.cantidadHijos= 0;
    }
    
    public nodo(String tipo, int fila, int columna){
        this.tipo = tipo;
        this.fila = fila;
        this.columna = columna;
        this.cantidadHijos= 0;
        hijos = new ArrayList<>();
    }

    public nodo(String texto, String tipo) {
        this.texto = texto;
        this.tipo = tipo;
        this.cantidadHijos= 0;
        hijos = new ArrayList<>();
    }

    public nodo(String texto, String tipo, int fila, int columna) {
        this.texto = texto;
        this.tipo = tipo;
        this.fila = fila;
        this.columna = columna;
        this.cantidadHijos= 0;
        hijos = new ArrayList<>();
    }
    
    public void add(nodo nodo){
        if(nodo != null){
            hijos.add(nodo);
            cantidadHijos= cantidadHijos +1;
        }
    }
    
    
    
    
    
}
