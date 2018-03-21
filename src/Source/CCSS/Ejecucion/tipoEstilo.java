/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.CCSS.Ejecucion;

/**
 *
 * @author erick
 */
public class tipoEstilo {
    public Object valor;
    public String nombre;

    public tipoEstilo(Object valor, String nombre) {
        this.valor = valor;
        this.nombre = nombre;
    }

    
    public Object getValor() {
        return valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
