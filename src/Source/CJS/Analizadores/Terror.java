/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.CJS.Analizadores;

/**
 *
 * @author BARRIOS
 */
public class Terror {
     String lexema,tipo,descripcion;
    int linea,columna;
    
    public Terror(String le, int li, int co, String t,String de){
        lexema = le;
        linea = li;
        columna = co;
        tipo = t;
        descripcion = de;
    }
}
