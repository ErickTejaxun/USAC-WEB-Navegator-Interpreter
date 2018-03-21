/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.CCSS.Ejecucion;

import Source.CCSS.AST.nodo;

/**
 *
 * @author erick
 */
public class semantico {
    
    public static  Object resolverOp(nodo nodo){
        Object resultado = operacion(nodo);
        return resultado;
    }
    
    public static Object operacion(nodo raiz){
        int numeroHijos = raiz.cantidadHijos;
        String dato = raiz.texto;
        String tipo = raiz.tipo;
        
        switch(numeroHijos){
            case 0:
                switch(tipo){
                    case "CADENA":
                        return dato;
                    case "Numero":
                        double numero = Double.parseDouble(dato);
                        if(numero%1 == 0){
                            return numero;
                        }else{
                            Double decimal = (double) numero;
                            return decimal;
                        }
                    case "BOOLEANO":
                        if(dato.equalsIgnoreCase("true")){
                            return true;
                        }else{
                            return false;
                        }
                    case "DECREMENTO":
                        Object Resultado = "";
                        Resultado = operacion(raiz.getHijos().get(0));
                        if(Resultado instanceof Integer){
                            Integer entero = (Integer) Resultado * (-1);
                            return entero;
                        }else if(Resultado instanceof Double){
                            Double decimal = (Double) Resultado * (-1);
                            return decimal;
                        } else{
                           ////Web.listaError.agregarError("Error semantico","El valor no puede negarse",raiz.getHijos().get(0).fila, raiz.getHijos().get(0).columna);
                           return "";
                        }
                    default:
                        return "";    
                }
            case 2:
                Object Numero1 = "";
                Object Numero2 = "";
                switch(dato){
                    case "+":
                        Numero1 = operacion(raiz.getHijos().get(0));
                        Numero2 = operacion(raiz.getHijos().get(1));
                        try{
                            if(Numero1 instanceof Integer && Numero2 instanceof Integer){
                                int v;
                                v = (Integer) Numero1 + (Integer) Numero2;
                                return v;
                            }else if(Numero1 instanceof Double && Numero2 instanceof Double){
                                double v2;
                                v2 = (Double) Numero1 + (Double) Numero2;
                                return v2;
                            }else if(Numero1 instanceof Double && Numero2 instanceof Integer){
                                double v3;
                                v3 = (Double) Numero1 + (Double) Numero2;
                                return v3;
                            }else if(Numero1 instanceof Integer && Numero2 instanceof Double){
                                double v4;
                                v4 = (Double) Numero1 + (Double) Numero2;
                                return v4;
                            
                            }else if(Numero1 instanceof String && Numero2 instanceof String){
                                String cadena;
                                cadena = String.valueOf(Numero1).replace("\"", "")  + String.valueOf(Numero2).replace("\"", "");
                                return cadena;
                            }
                            
                            else{
                                ////Web.listaError.agregarError("Error semantico","No se puede sumar valores que no sean numeros",raiz.getHijos().get(0).fila, raiz.getHijos().get(0).columna);
                            }
                        }catch (NumberFormatException e) {
                            System.out.println("E+ :" + e);
                            return "";
                        }
                    case "-":
                        Numero1 = operacion(raiz.getHijos().get(0));
                        Numero2 = operacion(raiz.getHijos().get(1));
                        try{
                            if(Numero1 instanceof Integer && Numero2 instanceof Integer){
                                int v;
                                v = (Integer) Numero1 - (Integer) Numero2;
                                return v;
                            }else if(Numero1 instanceof Double && Numero2 instanceof Double){
                                double v2;
                                v2 = (Double) Numero1 - (Double) Numero2;
                                return v2;
                            }else if(Numero1 instanceof Double && Numero2 instanceof Integer){
                                double v3;
                                v3 = (Double) Numero1 - (Double) Numero2;
                                return v3;
                            }else if(Numero1 instanceof Integer && Numero2 instanceof Double){
                                double v4;
                                v4 = (Double) Numero1 - (Double) Numero2;
                                return v4;
                            }else{
                                //Web.listaError.agregarError("Error semantico","No se puede restar valores que no sean numeros",raiz.getHijos().get(0).fila, raiz.getHijos().get(0).columna);
                            }
                        }catch (NumberFormatException e) {
                            System.out.println("E+ :" + e);
                            return "";
                        }
                    case "*":
                        Numero1 = operacion(raiz.getHijos().get(0));
                        Numero2 = operacion(raiz.getHijos().get(1));
                        try{
                            if(Numero1 instanceof Integer && Numero2 instanceof Integer){
                                int v;
                                v = (Integer) Numero1 * (Integer) Numero2;
                                return v;
                            }else if(Numero1 instanceof Double && Numero2 instanceof Double){
                                double v2;
                                v2 = (Double) Numero1 * (Double) Numero2;
                                return v2;
                            }else if(Numero1 instanceof Double && Numero2 instanceof Integer){
                                double v3;
                                v3 = (Double) Numero1 * (Double) Numero2;
                                return v3;
                            }else if(Numero1 instanceof Integer && Numero2 instanceof Double){
                                double v4;
                                v4 = (Double) Numero1 * (Double) Numero2;
                                return v4;
                            }else{
                                //Web.listaError.agregarError("Error semantico","No se puede multiplicar valores que no sean numeros",raiz.getHijos().get(0).fila, raiz.getHijos().get(0).columna);
                            }
                        }catch (NumberFormatException e) {
                            System.out.println("E+ :" + e);
                            return "";
                        }
                        
                    case "/":
                        Numero1 = operacion(raiz.getHijos().get(0));
                        Numero2 = operacion(raiz.getHijos().get(1));
                        try{
                            if(Numero1 instanceof Integer && Numero2 instanceof Integer){
                                int v;
                                v = (Integer) Numero1 / (Integer) Numero2;
                                return v;
                            }else if(Numero1 instanceof Double && Numero2 instanceof Double){
                                double v2;
                                v2 = (Double) Numero1 / (Double) Numero2;
                                return v2;
                            }else if(Numero1 instanceof Double && Numero2 instanceof Integer){
                                double v3;
                                v3 = (Double) Numero1 / (Double) Numero2;
                                return v3;
                            }else if(Numero1 instanceof Integer && Numero2 instanceof Double){
                                double v4;
                                v4 = (Double) Numero1 / (Double) Numero2;
                                return v4;
                            }else{
                                //Web.listaError.agregarError("Error semantico","No se puede dividir valores que no sean numeros",raiz.getHijos().get(0).fila, raiz.getHijos().get(0).columna);
                            }
                        }catch (NumberFormatException e) {
                            return "";
                        }
                        
                    default:
                        return  operacion(raiz.getHijos().get(0));
                }
                
        }
        
        
        
        
        return "";
    }
        
   
        
        
    
    
}
