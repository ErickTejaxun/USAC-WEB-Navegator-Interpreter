/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.CJS.principal;

import java.util.ArrayList;

/**
 *
 * @author BARRIOS
 */
public class Nodo {
    public String token;
    public String valor;
    public ArrayList<Nodo> hijos;
    
    public int col=0;
    public int row=0;
    public String tipocase;
    public String valcase;
    
    public Nodo(){
        this.token="";
        this.valor="";
        this.hijos=new ArrayList<>();
         
    }
    
    public Nodo(String token) {
        this.token = token;
        this.valor = "";
        this.hijos = new ArrayList<>();
    }

    public Nodo(String token, String valor) {
        this.token = token;
        this.valor = valor;
        this.hijos = new ArrayList<>();
    }
    
    public Nodo(String token, int fila, int columna) {
        this.token = token;
        this.valor = "";
        this.hijos = new ArrayList<>();
        
        this.row = fila;
        this.col = columna;
    }
    
    public Nodo(String token, String valor, int fila, int columna) {
        this.token = token;
        this.valor = valor;
        this.hijos = new ArrayList<>();
        
        this.row = fila;
        this.col = columna;
    }

    
    
    public void agregarHijo(Nodo hijo){
        this.hijos.add(hijo);
    }
    
    public void agregarHijos(Nodo hijo1, Nodo hijo2){
        this.hijos.add(hijo1);
        this.hijos.add(hijo2);
    }
    
    
    
    public void setToken(String token){
        this.token = token;
    }
    
    public void setValor(String valor){
        this.valor = valor;
    }
    
    
    public Nodo getHijo(int index){
        if(index < this.hijos.size())
            return this.hijos.get(index);
        else{
            System.err.println("Error accesando hijo ["+ index +"], el indice mayor es ["+ (this.hijos.size() - 1) +"] hijos");
            System.err.println("Token padre => " + this.token + " Valor padre => " + this.valor);
            System.out.println("Fila => " + this.row + " Columna => " + this.col + "\n");
            return null;
        }
    }
}
