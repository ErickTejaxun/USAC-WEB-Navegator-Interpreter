/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.CJS.principal;

import java.text.Collator;
import java.util.StringTokenizer;

/**
 *
 * @author BARRIOS
 */
public class Operacion {
    
    Nodo valorEval = null;

    public boolean casteoAsignacion(Simbolo var, Simbolo value) {

        if ((var.tipe.equals("bool") || var.tipe.equals("") )&& value.tipe.equals("bool")) {
            return true;
        } else if ((var.tipe.equals("bool") || var.tipe.equals("") ) && (value.value.equals("1") || value.value.equals("0") || value.tipe.equals("bool"))) {
            return true;
        } if( (var.tipe.equals("double") || var.tipe.equals("") ) && value.tipe.equals("double")) {
            return true;
        } else if ((var.tipe.equals("datetime")  || var.tipe.equals("") )&& value.tipe.equals("datetime")) {
            return true;
        } else if ((var.tipe.equals("date") || var.tipe.equals("") ) && value.tipe.equals("date")) {
            return true;
        }else if((var.tipe.equals("text")|| var.tipe.equals("") )){
            return true;
        } else {
            return false;
        }
    }

    /*OPERADORES ARITMETICOS*/
    public Simbolo sumar(Simbolo expr1, Simbolo expr2) {
        Simbolo valor = new Simbolo();

         if (expr1.tipe.equals("double") && expr2.tipe.equals("bool")) {
            double var = Double.parseDouble(expr1.value) + Double.parseDouble(expr2.value);
            valor.tipe = "double";
            valor.value = String.valueOf(var);

        } else if (expr1.tipe.equals("double") && expr2.tipe.equals("double")) {
            double var = Double.parseDouble(expr1.value) + Double.parseDouble(expr2.value);
            valor.tipe = "double";
            valor.value = String.valueOf(var);

        } else if (expr1.tipe.equals("double") && expr2.tipe.equals("text")) {
            valor.tipe = "text";
            valor.value = expr1.value + expr2.value;

        }else if (expr1.tipe.equals("bool") && expr2.tipe.equals("double")) {
            double var = Double.parseDouble(expr1.value) + Double.parseDouble(expr2.value);
            valor.tipe = "double";
            valor.value = String.valueOf(var);

        }else if (expr1.tipe.equals("bool") && expr2.tipe.equals("bool")) {
            valor = _or(expr1, expr2);
        } else if (expr1.tipe.equals("bool") && expr2.tipe.equals("text")) {
            valor.tipe = "text";
            valor.value = expr1.value + expr2.value;

        }else if ((expr1.tipe.equals("datetime") || expr1.tipe.equals("date"))  && expr2.tipe.equals("text")) {
            valor.tipe = "text";
            valor.value = expr1.value + expr2.value;

        }  else if (expr1.tipe.equals("text") && ( expr2.tipe.equals("text") ||expr2.tipe.equals("double") ||expr2.tipe.equals("bool") )) {
            valor.tipe = "text";
            valor.value = expr1.value + expr2.value;

        } else {
            msjError(" en la operacion de suma tipos invalidos");
            System.out.println("Error en la Suma");
        }

        return valor;
    }

    public Simbolo restar(Simbolo expr1, Simbolo expr2) {
        Simbolo valor = new Simbolo();

        if (expr1.tipe.equals("double") && expr2.tipe.equals("bool")) {
            double var = Double.parseDouble(expr1.value) - Double.parseDouble(expr2.value);
            valor.tipe = "double";
            valor.value = String.valueOf(var);

        } else if (expr1.tipe.equals("double") && expr2.tipe.equals("double")) {
            double var = Double.parseDouble(expr1.value) - Double.parseDouble(expr2.value);
            valor.tipe = "double";
            valor.value = String.valueOf(var);

        }else if (expr1.tipe.equals("bool") && expr2.tipe.equals("double")) {
            double var = Double.parseDouble(expr1.value) - Double.parseDouble(expr2.value);
            valor.tipe = "double";
            valor.value = String.valueOf(var);

        } else {
            msjError(" en la operacion de suma tipos invalidos");
            System.out.println("Error en la Suma");
        }

        return valor;
    }

    public Simbolo multiplicar(Simbolo expr1, Simbolo expr2) {
         Simbolo valor = new Simbolo();

         if (expr1.tipe.equals("double") && expr2.tipe.equals("bool")) {
            double var = Double.parseDouble(expr1.value) * Double.parseDouble(expr2.value);
            valor.tipe = "double";
            valor.value = String.valueOf(var);

        } else if (expr1.tipe.equals("double") && expr2.tipe.equals("double")) {
            double var = Double.parseDouble(expr1.value) * Double.parseDouble(expr2.value);
            valor.tipe = "double";
            valor.value = String.valueOf(var);

        } else if (expr1.tipe.equals("bool") && expr2.tipe.equals("double")) {
            double var = Double.parseDouble(expr1.value) * Double.parseDouble(expr2.value);
            valor.tipe = "double";
            valor.value = String.valueOf(var);

        }else if (expr1.tipe.equals("bool") && expr2.tipe.equals("bool")) {
            valor = _and(expr1, expr2);
        } else {
            msjError(" en la operacion de suma tipos invalidos");
            System.out.println("Error en la Suma");
        }

        return valor;
    }
    
    public Simbolo modulo(Simbolo expr1, Simbolo expr2) {
         Simbolo valor = new Simbolo();

         if (expr1.tipe.equals("double") && expr2.tipe.equals("bool")&& Double.parseDouble(expr2.value)!=0) {
            double var = Double.parseDouble(expr1.value) % Double.parseDouble(expr2.value);
            valor.tipe = "double";
            valor.value = String.valueOf(var);

        } else if (expr1.tipe.equals("double") && expr2.tipe.equals("double")&& Double.parseDouble(expr2.value)!=0) {
            double var = Double.parseDouble(expr1.value) % Double.parseDouble(expr2.value);
            valor.tipe = "double";
            valor.value = String.valueOf(var);

        } else if (expr1.tipe.equals("bool") && expr2.tipe.equals("double")&& Double.parseDouble(expr2.value)!=0) {
            double var = Double.parseDouble(expr1.value) % Double.parseDouble(expr2.value);
            valor.tipe = "double";
            valor.value = String.valueOf(var);

        }else if (expr1.tipe.equals("bool") && expr2.tipe.equals("bool")) {
            valor = _and(expr1, expr2);
        } else {
            msjError(" en la operacion de suma tipos invalidos");
            System.out.println("Error en la Suma");
        }

        return valor;
    }
    
    public Simbolo unario(Simbolo expr1) {
         Simbolo valor = new Simbolo();

        if (expr1.tipe.equals("double") ) {
            double var = Double.parseDouble(expr1.value) * (-1);
            valor.tipe = "double";
            valor.value = String.valueOf(var);

        } else {
            msjError(" en la operacion de suma tipos invalidos");
            System.out.println("Error en la Suma");
        }

        return valor;
    }

    public Simbolo dividir(Simbolo expr1, Simbolo expr2) {
         Simbolo valor = new Simbolo();

        if (expr1.tipe.equals("double") && expr2.tipe.equals("bool")&& Double.parseDouble(expr2.value)!=0) {
            double var = Double.parseDouble(expr1.value) / Double.parseDouble(expr2.value);
            valor.tipe = "double";
            valor.value = String.valueOf(var);

        } else if (expr1.tipe.equals("double") && expr2.tipe.equals("double")&& Double.parseDouble(expr2.value)!=0) {
            double var = Double.parseDouble(expr1.value) / Double.parseDouble(expr2.value);
            valor.tipe = "double";
            valor.value = String.valueOf(var);

        } else if (expr1.tipe.equals("bool") && expr2.tipe.equals("double")&& Double.parseDouble(expr2.value)!=0) {
            double var = Double.parseDouble(expr1.value) / Double.parseDouble(expr2.value);
            valor.tipe = "double";
            valor.value = String.valueOf(var);

        }else {
            msjError(" en la operacion de suma tipos invalidos");
            System.out.println("Error en la Suma");
        }

        return valor;
    }

    public Simbolo potencia(Simbolo expr1, Simbolo expr2) {
        Simbolo valor = new Simbolo();

        if (expr1.tipe.equals("double") && expr2.tipe.equals("bool")) {
            double var = Math.pow(Double.parseDouble(expr1.value), Double.parseDouble(expr2.value));
            valor.tipe = "double";
            valor.value = String.valueOf(var);

        } else if (expr1.tipe.equals("double") && expr2.tipe.equals("double")) {
            double var = Math.pow(Double.parseDouble(expr1.value), Double.parseDouble(expr2.value));
            valor.tipe = "double";
            valor.value = String.valueOf(var);

        } else if (expr1.tipe.equals("bool") && expr2.tipe.equals("double")) {
            double var = Math.pow(Double.parseDouble(expr1.value), Double.parseDouble(expr2.value));
            valor.tipe = "double";
            valor.value = String.valueOf(var);

        }else {
            msjError(" en la operacion de suma tipos invalidos");
            System.out.println("Error en la Suma");
        }

        return valor;
    }
    /*OPERADORES RELACIONALES*/

    public Simbolo igualar(Simbolo val1, Simbolo val2) {
        Simbolo valor = new Simbolo();
        if(val1.tipe.equals("double")&& val2.tipe.equals("double")){            
            if(val1.value.equals("0") || val2.value.equals("0")){
                StringTokenizer vv1 = new StringTokenizer(val1.value, ".");
                StringTokenizer vv2 = new StringTokenizer(val2.value, ".");
                String v1 = vv1.nextToken();
                String v2 = vv2.nextToken();
                //System.out.println(vv1+":"+vv2);
                val1.value=v1;
                val2.value=v2;
                //System.out.println("ceros");
            }else{
                val1.value=Double.parseDouble(val1.value)+"";
                val2.value=Double.parseDouble(val2.value)+"";
                //System.out.println("diferente a ceros");
            }
            
            
        }
        valor.value = (val1.value.equals(val2.value)) ? "1" : "0";
        valor.tipe = "bool";
        return valor;
    }

    public Simbolo distinto(Simbolo val1, Simbolo val2) {
        Simbolo valor = new Simbolo();
        if(val1.tipe.equals("double")&& val2.tipe.equals("double")){            
            if(val1.value.equals("0") || val2.value.equals("0")){
                StringTokenizer vv1 = new StringTokenizer(val1.value, ".");
                StringTokenizer vv2 = new StringTokenizer(val2.value, ".");
                String v1 = vv1.nextToken();
                String v2 = vv2.nextToken();
                //System.out.println(vv1+":"+vv2);
                val1.value=v1;
                val2.value=v2;
                //System.out.println("ceros");
            }else{
                val1.value=Double.parseDouble(val1.value)+"";
                val2.value=Double.parseDouble(val2.value)+"";
                //System.out.println("diferente a ceros");
            }
            
            
        }
        valor.value = (!val1.value.equals(val2.value)) ? "1" : "0";
        valor.tipe = "bool";
        return valor;

    }

    public Simbolo menor(Simbolo val1, Simbolo val2) {
        Simbolo valor = new Simbolo();
        valor.tipe = "bool";
        if (val1.tipe.equals("double") && val2.tipe.equals("double")) {
            valor.value = (Double.parseDouble(val1.value) < Double.parseDouble(val2.value)) ? "1" : "0";

        } else if ((val1.tipe.equals("date")|| val1.tipe.equals("datetime")|| val1.tipe.equals("text")) && (val2.tipe.equals("date")||val2.tipe.equals("datetime")|| val2.tipe.equals("text"))) {
            Collator comparador = Collator.getInstance();
            comparador.setStrength(Collator.PRIMARY);
            valor.value = (comparador.compare(val1.value, val2.value) == -1) ? "1" : "0";

        } else {
            msjError(" en operador relacional de menor tipos invalidos");
            System.out.println("Error en Menor");
        }

        return valor;

    }


    public Simbolo mayor(Simbolo val1, Simbolo val2) {
        Simbolo valor = new Simbolo();
        valor.tipe = "bool";
        if (val1.tipe.equals("double") && val2.tipe.equals("double")) {
            valor.value = (Double.parseDouble(val1.value) > Double.parseDouble(val2.value)) ? "1" : "0";

        } else if ((val1.tipe.equals("date")|| val1.tipe.equals("datetime")|| val1.tipe.equals("text")) && (val2.tipe.equals("date")||val2.tipe.equals("datetime")|| val2.tipe.equals("text"))) {
            Collator comparador = Collator.getInstance();
            comparador.setStrength(Collator.PRIMARY);
            valor.value = (comparador.compare(val1.value, val2.value) == 1) ? "1" : "0";

        } else {
            msjError(" en operador relacional de mayor tipos invalidos");
            System.out.println("Error en mayor");
        }

        return valor;
    }

    public Simbolo menorIgual(Simbolo val1, Simbolo val2) {
        Simbolo valor = new Simbolo();
        valor.tipe = "bool";
        if (val1.tipe.equals("double") && val2.tipe.equals("double")) {
            valor.value = (Double.parseDouble(val1.value) <= Double.parseDouble(val2.value)) ? "1" : "0";

        } else if ((val1.tipe.equals("date")|| val1.tipe.equals("datetime")|| val1.tipe.equals("text")) && (val2.tipe.equals("date")||val2.tipe.equals("datetime")|| val2.tipe.equals("text"))) {
            Collator comparador = Collator.getInstance();
            comparador.setStrength(Collator.PRIMARY);
            int res = comparador.compare(val1.value, val2.value);
            valor.value = (res == -1 || res == 0) ? "1" : "0";

        } else {
            msjError(" en operador relacional de menorIgual tipos invalidos");
            System.out.println("Error en Menor igual");
        }

        return valor;

    }

    public Simbolo mayorIgual(Simbolo val1, Simbolo val2) {
        Simbolo valor = new Simbolo();
        valor.tipe = "bool";
        if (val1.tipe.equals("double") && val2.tipe.equals("double")) {
            valor.value = (Double.parseDouble(val1.value) >= Double.parseDouble(val2.value)) ? "1" : "0";

        } else if ((val1.tipe.equals("date")|| val1.tipe.equals("datetime")|| val1.tipe.equals("text")) && (val2.tipe.equals("date")||val2.tipe.equals("datetime")|| val2.tipe.equals("text"))) {
            Collator comparador = Collator.getInstance();
            comparador.setStrength(Collator.PRIMARY);
            int res = comparador.compare(val1.value, val2.value);
            valor.value = (res == 1 || res == 0) ? "1" : "0";
        } else {
            msjError(" en operador relacional de mayorIguals tipos invalidos");
            System.out.println("Error en Mayor igual");
        }
        return valor;
    }

    /*OPERADORES LOGICOS*/
    public Simbolo _or(Simbolo expr1, Simbolo expr2) {
        Simbolo valor = new Simbolo();

        if ((expr1.tipe.equals("bool") || expr1.value.equals("1") || expr1.value.equals("0"))
                && (expr2.tipe.equals("bool") || expr2.value.equals("1") || expr2.tipe.equals("0"))) {

            boolean var1 = false;
            boolean var2 = false;

            if (expr1.value.equals("1")) {
                var1 = true;
            }
            if (expr2.value.equals("1")) {
                var2 = true;
            }

            if (var1 || var2) {
                valor.value = "1";
            } else {
                valor.value = "0";
            }
            valor.tipe = "bool";
        } else {
            msjError(" en operador logico de OR no es de tipo Boolean");
            System.out.println("Error en or");
        }
        return valor;
    }

    public Simbolo _and(Simbolo expr1, Simbolo expr2) {
        Simbolo valor = new Simbolo();

        if ((expr1.tipe.equals("bool") || expr1.value.equals("1") || expr1.value.equals("0"))
                && (expr2.tipe.equals("bool") || expr2.value.equals("1") || expr2.tipe.equals("0"))) {

            boolean var1 = false;
            boolean var2 = false;

            if (expr1.value.equals("1")) {
                var1 = true;
            }
            if (expr2.value.equals("1")) {
                var2 = true;
            }

            if (var1 && var2) {
                valor.value = "1";
            } else {
                valor.value = "0";
            }
            valor.tipe = "bool";

        } else {
            msjError(" en operador logico de AND no es de tipo Boolean");
            System.out.println("Error en and");
        }

        return valor;
    }
    public Simbolo _not(Simbolo expr) {
        Simbolo valor = new Simbolo();
        if (expr.tipe.equals("bool") || expr.value.equals("1") || expr.value.equals("0")) {
            if (expr.value.equals("1")) {
                valor.value = "0";
            } else {
                valor.value = "1";
            }
            valor.tipe = "bool";
        } else {
            msjError(" en operador logico de NOT no es de tipo Boolean");
            System.out.println("Error en NOT");
        }

        return valor;
    }

    public Simbolo incrementar(Simbolo temp) {

        switch (temp.tipe) {
            case "double": {
                double valor = Double.parseDouble(temp.value) + 1;
                temp.value = String.valueOf(valor);
                break;
            }
            default: {
                msjError(" nos se puede incrementar, tipo de dato incorrecto");
                System.out.println("Error Semantico el tipo de dato no se puede incremetnar");
                break;
            }
        }
        return temp;
    }

    public Simbolo decremetar(Simbolo temp) {

        switch (temp.tipe) {
            case "double": {
                double valor = Double.parseDouble(temp.value) - 1;
                temp.value = String.valueOf(valor);
                break;
            }
            default: {
                msjError(" nos se puede decrementar, tipo dato incorrecto");
                System.out.println("Error Semantico el tipo de dato no se puede decrementar");
                break;
            }
        }
        return temp;
    }

    private void msjError(String texto) {
        if (valorEval != null) {
            System.out.println("Error: "+ texto+": "+valorEval.row+": "+valorEval.col);
        }
    }

    /**
     * METODO QUE DEVUELVE EN EL NAME LA RUTA DE LA VARIABLE, Y NOS INDICA SI
     * EXISTE LA VAIRABLE LA BUSCA EN LA TABLA DE SIMBOLOS DADA
     *
     * @param id
     * @param nameMetod
     * @param tablaLocal
     * @param valor
     * @return
     */
    public Simbolo getVariable(String id, Execute tablas, Simbolo valor) {

        boolean find = false;
        String key = tablas.nameMetod + ">" + id;
        if (tablas.tablaLocal.containsKey(key)) {
            valor = tablas.tablaLocal.get(key);
            find = true;
        } else {
            key = id;
            if (tablas.tablaGlobal.containsKey(key)) {
                valor = tablas.tablaGlobal.get(key);
                find = true;
            }
        }
        if (!find) {
            msjError(" la variable no esta declarada en este ambito");
            System.out.println("Error la variable no existe o no esta declarada " + id);
        }
        return valor;
    }
    
}
