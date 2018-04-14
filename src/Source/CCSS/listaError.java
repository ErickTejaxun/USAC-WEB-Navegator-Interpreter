/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.CCSS;

import java.util.ArrayList;
import Source.CCSS.*;

/**
 *
 * @author erick
 */
public class listaError {
    public static ArrayList<errorCcss>  listaErrores = new ArrayList<>();
    
    public static void agregarError(String tipo, String descripcion, int fila, int columna){
        errorCcss error = new errorCcss("",tipo, descripcion, fila, columna);
        listaErrores.add(error);
        System.out.println("Error: " + tipo+" Descripcion: " + descripcion+ " Fila: "+fila+" Columna:"+ columna);
    }
    
}
