/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.CJS.principal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author BARRIOS
 */
public class Grafica {
    File f;
    FileWriter fw;
    BufferedWriter bw;
    PrintWriter pw;
    int indice;
    
    public Grafica(){
        this.f = null;
        this.fw = null;
        this.bw = null;
        this.pw = null;
        this.indice = -1;
    }
    
    public void graficar(Nodo raiz, String nombre) throws IOException{
        ProcessBuilder proceso;
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
        crear_nodos(raiz);

        indice = 0;
        enlazar_nodos(raiz, 0);

        pw.println("}");
        //**


        pw.close();
        bw.close();


        try{
            proceso=new ProcessBuilder(dopath,tparam,oparam,archivo_destino,archivo_origen);
            //Runtime rt = Runtime.getRuntime();
            //rt.exec(cmd);
            proceso.redirectErrorStream(true);
            proceso.start();
        }catch(Exception e){ 
            System.err.println(e.getMessage()); 
        }
    }

    private void crear_nodos(Nodo raiz) {
        if(raiz != null)
        {
            String token = raiz.token;
            String valor = raiz.valor.equals("") ? "" : "\n" + raiz.valor;
            
            pw.println("node"+indice+"[label = " +"\""+ token.replace("\"'","") + " " + valor.replace("\"'","") + "\","+ "];");
            indice++;
            for(Nodo nodo: raiz.hijos)
                crear_nodos(nodo);
        }
    }

    private void enlazar_nodos(Nodo raiz, int actual) {
        if(raiz != null)
        {
            for( Nodo nodo: raiz.hijos)
            {
                indice++;
                pw.println("\"node" + actual + "\"--" + "\"node" + indice+ "\"");
                enlazar_nodos(nodo,indice);
            }
        }
    }
    
}
