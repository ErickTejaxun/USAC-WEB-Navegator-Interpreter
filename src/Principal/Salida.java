/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

/**
 *
 * @author erick
 */
public class Salida 
{
    public String archivo="";
    public int linea = 0;
    public int columna = 0;
    public String salida = "";
    
    public Salida(String path, int linea, int col, String out)
    {
        this.archivo = path;
        this.linea = linea;
        this.columna = columna ;
        this.salida = out;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    
    
    
    
    public String getArchivo() {
        return archivo;
    }

    public int getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    }

    public String getSalida() {
        return salida;
    }
    
    
    
    
    
    
    
    
}
