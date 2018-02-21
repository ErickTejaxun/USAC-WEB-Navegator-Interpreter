/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.CHTML;

import java.util.ArrayList;



/**
 *
 * @author erick
 */
public class nodoChtml 
{
    private String tipo;
    private String value;
    private int columna;
    private int linea;    
    private ArrayList<nodoChtml> hijos = new ArrayList();

    public nodoChtml() 
    {
        this.value="";
    }
    
    public nodoChtml(String value) 
    {
        this.value=value;
    }
    public nodoChtml(String value, int id) 
    {
        this.value=value;
        this.linea = id;
        this.tipo=value;
    }
    public nodoChtml(String value, int id, int x) 
    {
        this.value=value;
        this.linea = id;
        this.tipo=value;
    }    
    public nodoChtml(String value, int id, nodoChtml hijo) 
    {
        this.value=value;
        this.tipo=value;
        this.linea = id;
        this.hijos.add(hijo);
    }    
    
    public nodoChtml(String tipo, int id, String value) 
    {
        this.tipo=tipo;
        this.value=value;
        this.linea = id;
    }    
    public String getTipo() {
        return tipo;
    }

    public String getValue() {
        return value;
    }

    public int getColumna() {
        return columna;
    }

    public int getLinea() {
        return linea;
    }

    public ArrayList<nodoChtml> getHijos() {
        return hijos;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public void setHijos(ArrayList<nodoChtml> hijos) {
        this.hijos = hijos;
    }


    
    
}
