/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

/**
 *
 * @author Erick
 */
public class Errores {
    
    String texto;
    int linea;
    int columna;
    String descripcion;
    String tipo;
    
    
    public Errores(String tipo, int linea, int columna, String valor)
    {
        this.tipo=tipo;
        this.linea= linea;
        this.columna = columna;
        this.texto = valor;
        this.descripcion = valor;
    }
    
    public Errores(){
    texto="";
    linea=0;
    columna=0;
    descripcion="";
    tipo="";
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

   

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.descripcion = Descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String Tipo) {
        this.tipo = Tipo;
    }
    
    
    
}
