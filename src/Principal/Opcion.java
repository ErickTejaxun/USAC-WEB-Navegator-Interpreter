/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Source.CJS.principal.Nodo;

/**
 *
 * @author erick
 */
public class Opcion 
{
    String id="";
    String cadena="";
    Object metodo="";
    Object listo="";
    Object modificado="";
    String grupo="";
    

    public Opcion(String id, String cadena, Object metodo, Object listo, Object modificado) {
        this.id = id;
        this.cadena = cadena;
        this.metodo = metodo;
        this.listo = listo;
        this.modificado = modificado;
    }

    public Opcion()
    {}
    public void setId(String id) {
        this.id = id;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public String getGrupo() {
        return grupo;
    }
    
    public void setGrupo(String grupo)
    {
        this.grupo = grupo;
    }

    public void setMetodo(Object metodo) {
        this.metodo = metodo;
    }

    public void setListo(Object listo) {
        this.listo = listo;
    }

    public void setModificado(Object modificado) {
        this.modificado = modificado;
    }

    public String getId() {
        return id;
    }

    public String getCadena() {
        return cadena;
    }

    public Object getMetodo() {
        return metodo;
    }

    public Object getListo() {
        return listo;
    }

    public Object getModificado() {
        return modificado;
    }
    
    
    
    
    
}
