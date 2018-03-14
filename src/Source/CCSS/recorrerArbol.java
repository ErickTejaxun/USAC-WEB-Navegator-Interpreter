/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.CCSS;
import java.util.ArrayList;
import javax.swing.UIManager;
/**
 *
 * @author erick
 */
public class recorrerArbol {

    
    public static String nombregeneral="";
    
    public static Object recorrido(nodo raiz){
        Object result = null;
        
            if (raiz != null){
                switch (raiz.tipo){
                    case "INICIO":
                        result = recorrido(raiz.getHijos().get(0) );
                        break;
                    case "Lista Definiciones":
                       if(raiz.cantidadHijos > 1){
                           recorrido(raiz.getHijos().get(0));
                           result = recorrido(raiz.getHijos().get(1));
                       }else{
                        result = recorrido(raiz.getHijos().get(0));
                       }
                         break;
                    case "Definiciones":
                        if(raiz.cantidadHijos > 1){
                            nombregeneral = raiz.getHijos().get(0).texto;
                            result = recorrido(raiz.getHijos().get(1));
                        }else{
                            nombregeneral = raiz.getHijos().get(0).texto;
                        }
                        break;
                    case "DECREMENTO":
                        result = semantico.resolverOp(raiz);
                        break;
                    case "Elementos":
                        switch(raiz.cantidadHijos){
                            case 1:
                                result = recorrido(raiz.getHijos().get(0));
                                break;
                            case 2: 
                                recorrido(raiz.getHijos().get(0));
                                result = recorrido(raiz.getHijos().get(1));
                                break;
                        }
                        break;
                    case "GRUPO":
                        String tipo = raiz.getHijos().get(0).tipo;
                        String nombregrupo = raiz.getHijos().get(0).texto;
                        if(raiz.cantidadHijos ==2){
                            result= recorrido(raiz.getHijos().get(1));
                            ArrayList atributos = (ArrayList)result;
                            listaElemento.crearElemento(nombregeneral, tipo,nombregrupo,atributos, 0, 0);
                            //crear codigo para insertar a lista
                        }else{
                            ArrayList atributosVacios = new ArrayList();
                            listaElemento.crearElemento(nombregeneral, tipo,nombregrupo, atributosVacios, 0, 0);
                            //crear codigo para insertar a lista
                            
                        }
                        break;
                   
                    case "ATRIBUTO":
                       
                        switch(raiz.cantidadHijos){
                            case 2:
                                result = recorrido(raiz.getHijos().get(1));
                                tipoEstilo estilonormal = new tipoEstilo(result,raiz.getHijos().get(0).tipo);
                                result = estilonormal;
                                break;
                            case 3:
                                if(raiz.getHijos().get(0).tipo.equalsIgnoreCase("Autoredimension")){
                                    ArrayList autoredimention = new ArrayList();
                                    autoredimention.add(recorrido(raiz.getHijos().get(1)));
                                    autoredimention.add(recorrido(raiz.getHijos().get(2)));
                                    tipoEstilo estiloauto = new tipoEstilo(autoredimention, raiz.getHijos().get(0).tipo);
                                    result = estiloauto;
                                }
                            case 4:
                                if(raiz.getHijos().get(0).tipo.equalsIgnoreCase("Borde")){
                                    ArrayList borde = new ArrayList();
                                    borde.add(recorrido(raiz.getHijos().get(1)));
                                    borde.add(recorrido(raiz.getHijos().get(2)));
                                    borde.add(recorrido(raiz.getHijos().get(3)));
                                    tipoEstilo bordeest = new tipoEstilo(borde, raiz.getHijos().get(0).tipo);
                                    result = bordeest;
                                }
                        }
                       
                        break;
                       
                       
                    case "FORMATO":
                        ArrayList formato = new ArrayList();
                        for (int i = 0; i< raiz.cantidadHijos; i++){
                            result = raiz.getHijos().get(i);
                            formato.add(result);
                            
                        }
                        result = formato;
                        break;
                              
                    case "ATRIBUTOS":
                        
                        int hijitos = raiz.cantidadHijos;
                        
                        switch(hijitos){
                            case 1:
                                ArrayList listaAtri = new ArrayList();
                                result = recorrido(raiz.getHijos().get(0));
                                listaAtri.add(result);
                                result = listaAtri;
                                break;
                            case 2:
                                ArrayList listaatri2 = (ArrayList) recorrido(raiz.getHijos().get(0));
                              //  recorrido(raiz.getHijos().get(1));
                                listaatri2.add(recorrido(raiz.getHijos().get(1)));
                                result = listaatri2;
                                break;
                        }
                    
                        break;
             
                    case "ALINEADO":
                        result = raiz.texto;
                        break;
                    case "OP":
                        result = semantico.resolverOp(raiz);
                        break;
                        //operaciones y comprobaciones
                 
                    case "CADENA":
                        result = raiz.texto;
                        break;
                    case "BOOLEANO":
                        result = semantico.resolverOp(raiz);
                        break;
                    case "Numero":
                        result = semantico.resolverOp(raiz);
                        break;
                    case "Form":
                        result = raiz.texto;
                        break;
                    case "Area":
                        result = raiz.texto;
                        break;
                    
                  /*  case "Letra":
                        result = semantico.resolverOp(raiz);
                        break;
                    case "Opaque":
                        result = semantico.resolverOp(raiz);
                        break;
                    case "AutorRedimension":
                        result = semantico.resolverOp(raiz);*/
                    
                }   
                            
                
            }
            
        
        
        
        
        
        
        return result;
        
        
        
    }

    
}
