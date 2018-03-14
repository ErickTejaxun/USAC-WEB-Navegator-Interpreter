/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.CJS;

/**
 *
 * @author erick
 */
public class ErrorCjs {
     String lexema,tipo,descripcion;
    int linea,columna;
    
    public ErrorCjs(String le, int li, int co, String t,String de){
        lexema = le;
        linea = li;
        columna = co;
        tipo = t;
        descripcion = de;
    }
}
