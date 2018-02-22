/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.CHTML;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author erick
 */
public class dibujador 
{
    public dibujador()
    {
    }
    public void generarGrafica(nodoChtml raiz) throws IOException 
    {
        

        String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";        
        String direccionSalida = PathActual()+"\\ast.jpg";
        String direccionEntrada = PathActual()+"\\ast.txt";
        
        String cadena = "digraph G\n" +
                        "{\n" +
                        //"rankdir=LR;"+
                        dibujarArbol(raiz)+
                        "}";
        cadena = cadena.replace("\"\"","\"");
        cadena = cadena.replace("\\","\\\\");
        /*---------------------------------------------------------------------------------*/
        try (  PrintWriter writer = new PrintWriter(direccionEntrada)) {
            writer.print(cadena);            
        } 
        /*---------------------------------------------------------------------------------*/
        
        
        String tParam = "-Tpng";
        String tOParam = "-o";
        
        //dot -Tpng ast.txt -o ast.jpg

        String[] cmd = new String[5];
              cmd[0] = dotPath;
              cmd[1] = tParam;
              cmd[2] = direccionEntrada;
              cmd[3] = tOParam;
              cmd[4] = direccionSalida;

              Runtime rt = Runtime.getRuntime();

              rt.exec( cmd );
              
    }
    public String dibujarArbol(nodoChtml raiz)
    {
        String cadena = "N"+raiz.hashCode()+"[label=\""+raiz.getTipo()+"\"]; \n";
        
        if(!raiz.getHijos().isEmpty())
        {
            for(int cont = 0; cont<raiz.getHijos().size();cont++)
            {
                cadena = cadena +"N"+raiz.getHijos().get(cont).hashCode()+"[label=\""+raiz.getHijos().get(cont).getValue()+"\"]; \n";
                //a -> b[label="0.2",weight="0.2"];
            }
            for(int cont = 0; cont<raiz.getHijos().size();cont++)
            {
                cadena = cadena +"N"+raiz.hashCode()+"->"  +"N"+raiz.getHijos().get(cont).hashCode()+" ; \n";
                //a -> b[label="0.2",weight="0.2"];
            }
            
            for(int cont = 0; cont<raiz.getHijos().size();cont++)
            {
                cadena = cadena + dibujarArbol(raiz.getHijos().get(cont));                
            }            
        }               
        return cadena;
    }
    
    
    public String PathActual(){
        String path="";
         File miDir = new File (".");
         try {
           //System.out.println (miDir.getCanonicalPath());
           path=miDir.getCanonicalPath();
         }
         catch(Exception e) {
           e.printStackTrace();
           }
         return path;
    }     
}
