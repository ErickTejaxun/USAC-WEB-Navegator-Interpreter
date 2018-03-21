/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.CCSS.Ejecucion;

import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class nodoLista {
    public String nombreBloque;
    public String tipo;
    public String identificador;
    public ArrayList atributos;

    public nodoLista(String nombreBloque, String tipo, String identificador, ArrayList atributos) {
        this.nombreBloque = nombreBloque;
        this.tipo = tipo;
        this.identificador = identificador;
        this.atributos = atributos;
    }

    public String getNombreBloque() {
        return nombreBloque;
    }

    public String getTipo() {
        return tipo;
    }

    public String getValor() {
        return identificador;
    }

    public ArrayList getAtributos() {
        return atributos;
    }

    public void setNombreBloque(String nombreBloque) {
        this.nombreBloque = nombreBloque;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setValor(String valor) {
        this.identificador = valor;
    }

    public void setAtributos(ArrayList atributos) {
        this.atributos = atributos;
    }
    
    
}
