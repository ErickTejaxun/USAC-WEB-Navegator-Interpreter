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
public class Proc {
    
    Nodo sentencias;
    Object retornar;
    ArrayList<Simbolo> parametro;
    int N;

    public Proc() {
        parametro = new ArrayList<>();
        sentencias = null;
        retornar = null;
    }
    
}
