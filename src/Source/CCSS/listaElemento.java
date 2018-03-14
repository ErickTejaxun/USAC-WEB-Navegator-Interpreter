/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.CCSS;

import Source.CCSS.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author erick
 */
public class listaElemento {

    public static void crearElemento(String nombre, String tipo, String identificador, ArrayList atributos, int fila, int columna){
        ArrayList<nodoLista> listabloques = grupos.lbloques;
        if(buscar(nombre, identificador)){
            nodoLista n =  new nodoLista(nombre, tipo, identificador, atributos);
            listabloques.add(n);
        }else{
            System.out.println("Error elemento ya existe");
        }

    }


    public static void imprimirBloque() {
        ArrayList<nodoLista> listabloques = grupos.lbloques;
        for (int i = 0; i < listabloques.size(); i++) {
            nodoLista Elemento = listabloques.get(i);
            System.out.println(" " + Elemento.nombreBloque + " - " + Elemento.tipo + " - " + Elemento.identificador);
        }
    }

    public static ArrayList obtenerElemento(String nombre, String tipo) {
        ArrayList<nodoLista> listaElementos = grupos.lbloques;
        for (int i = 0; i < listaElementos.size(); i++) {
            nodoLista listaatriutos = listaElementos.get(i);
            if (listaatriutos.identificador.equalsIgnoreCase(nombre) && listaatriutos.tipo.equalsIgnoreCase(tipo)) {
                if (listaatriutos.atributos == null) {
                    return new ArrayList();
                }
                return listaatriutos.atributos; //retorna lista de atributos
            }
        }
        System.out.println("Error, El bloque no existe");
        return new ArrayList();
    }


   public static boolean buscar(String nombre, String identificador){
        ArrayList<nodoLista> listabloques = grupos.lbloques;
        for (int i=0; i < listabloques.size(); i++) {
         nodoLista bloque = listabloques.get(i);
         if(bloque.nombreBloque.equalsIgnoreCase(nombre) && bloque.identificador.equalsIgnoreCase(identificador)){
             System.out.println("El bloque ya existe");
             return false;
         }
        }
        return true;
   }
}
