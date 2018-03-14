/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.CJS.Ejecucion;

import Source.CJS.Ejecucion.*;
import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class Procedimiento {
    
    Nodo sentencias;
    Object retornar;
    ArrayList<Simbolo> parametro;
    int N;

    public Procedimiento() {
        parametro = new ArrayList<>();
        sentencias = null;
        retornar = null;
    }
    
}
