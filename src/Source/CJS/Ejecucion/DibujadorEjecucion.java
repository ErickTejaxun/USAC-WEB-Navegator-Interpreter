/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.CJS.Ejecucion;

import Source.CJS.Ejecucion.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author erick
 */
public class DibujadorEjecucion {
    File f;
    FileWriter fw;
    BufferedWriter bw;
    PrintWriter pw;
    int indice;
    
    public DibujadorEjecucion(){
        this.f = null;
        this.fw = null;
        this.bw = null;
        this.pw = null;
        this.indice = -1;
    }
    
    public void grafica(Nodo raiz, String nombre) throws IOException{
        
        String dopath="C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
        String tparam="-Tpng";
        String oparam="-o";
        String archivo_origen;
        String archivo_destino;

        String[] cmd=new String[5];
        
        archivo_origen = nombre + ".txt";
        archivo_destino = nombre + ".png";

        cmd[0]=dopath;
        cmd[1]=tparam;
        cmd[2]=archivo_origen;
        cmd[3]=oparam;
        cmd[4]=archivo_destino;
        f = new File(archivo_origen);
        fw = new FileWriter(f);
        bw = new BufferedWriter(fw);
        pw = new PrintWriter(bw); 


        //**
        pw.println("graph G {");
        pw.println("node [shape= square];");

        indice = 0;
        crearNodo(raiz);

        indice = 0;
        aristas(raiz, 0);

        pw.println("}");
        //**


        pw.close();
        bw.close();


        try{
            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);
            
        }catch(Exception e){ 
            System.err.println(e.getMessage()); 
        }
    }

    private void crearNodo(Nodo raiz) {
        if(raiz != null)
        {
            String token = raiz.token;
            String valor = raiz.valor.equals("") ? "" : "\n" + raiz.valor;
            
            pw.println("node"+indice+"[label = " +"\""+ token + " " + valor + "\","+ "];");
            indice++;
            for(Nodo nodo: raiz.hijos)
                crearNodo(nodo);
        }
    }

    private void aristas(Nodo raiz, int actual) {
        if(raiz != null)
        {
            for( Nodo nodo: raiz.hijos)
            {
                indice++;
                pw.println("\"node" + actual + "\"--" + "\"node" + indice+ "\"");
                aristas(nodo,indice);
            }
        }
    }
    
}
