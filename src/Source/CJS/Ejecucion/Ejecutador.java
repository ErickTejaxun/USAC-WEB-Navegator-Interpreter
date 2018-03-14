/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.CJS.Ejecucion;


import Source.CJS.ErrorCjs;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import javax.swing.JTextArea;
import javax.xml.bind.ParseConversionEvent;

/**
 *
 * @author erick
 */
public class Ejecutador {
    public Hashtable<String, Simbolo> tablaSimbolosLocal;
    public Hashtable<String, Simbolo> tablaSimbolosGlobal;
    public static LinkedList<ErrorCjs> tablaErrores = new LinkedList<ErrorCjs>();
    public ArrayList<Nodo> inicial;
    public ArrayList<Nodo> objetosTemporales;
    public Simbolo nombreSimbolo;
    public String path;
    String nombreMetodo;
    String tiposMet;
    Operacion operar;
    boolean exit;
    boolean retorno;
    boolean continuar;
    Simbolo retorna;


    public Hashtable<String, Simbolo> tablitaObjetos;
 
  
    JTextArea txtArea;
    HashMap<String, Simbolo> hashtemp;
    
    public Ejecutador() {
        
        tablaSimbolosLocal = new Hashtable<>();
        tablaSimbolosGlobal = new Hashtable<>();
        
        inicial = new ArrayList<>();
        operar = new Operacion();
        nombreMetodo = "";
        retorna = null;
        nombreSimbolo = new Simbolo();
        retorno = false;
        path = "";
        
        tablitaObjetos = new Hashtable<>();
        objetosTemporales=new ArrayList<>();
        
    }
    
    @SuppressWarnings("UnusedAssignment")
    public Simbolo cargarVariablesFuncion(Nodo raiz) {
        
         Simbolo result = null;
        if (raiz == null) {
            return null;
        }
        switch (raiz.token) {
            case "INICIO_CJS": {
                
                for(Nodo l_cjs: raiz.hijos){
                    cargarVariablesFuncion(l_cjs);
                    
                }                
                break;
            }
            case "L_CJS": {
                
                for(Nodo cjs: raiz.hijos){
                    cargarVariablesFuncion(cjs);
                    
                }                
                break;
            }
            case "METFUNC": {
                Simbolo newFuntion = new Simbolo();
                newFuntion.metodo = new Procedimiento();
                
                newFuntion.tipe = "void";
                newFuntion.rol = "metodo";
                
                newFuntion.name = raiz.hijos.get(0).valor;
                
                nombreMetodo=raiz.hijos.get(0).valor.toLowerCase();
                String key = null;
                
                   //////tiene parametros
                if(raiz.hijos.size()==3){
                    Nodo ident,param,sentencias;
                    
                    ident=raiz.hijos.get(0);
                    param=raiz.hijos.get(1);
                    sentencias=raiz.hijos.get(2);
                    tiposMet = "";
                    tipoParametros(param, 1, null);//tipos de parametros                      
                    nombreMetodo += tiposMet;
                    tipoParametros(param, 2, newFuntion.metodo.parametro);//agregando los parametros a la funcion
                    newFuntion.metodo.sentencias = sentencias;
                                    
                }
                //sin parametros
                else if(raiz.hijos.size()==2)
                newFuntion.name = key = nombreMetodo;
                if(!tablaSimbolosGlobal.containsKey(key)){
                    tablaSimbolosGlobal.put(key, newFuntion);//insertamos a la tabla Funciones
                    
                }else{
                    ErrorCjs datos = new ErrorCjs(key,raiz.row,raiz.col,"Error SEMANTICO","Ya existe funcion");
                    tablaErrores.add(datos);
                }
                  nombreMetodo="";
                break;
            }
            case "DECLVAR":{
                Nodo lista=raiz.hijos.get(0);
                
                for(Nodo variable:lista.hijos){
                    
                    declararVar(variable,"", 0);
                }
                break;
            }
            case "DECLVECT":{
                Nodo lista=raiz.hijos.get(0);
                Nodo dimension=raiz.hijos.get(1);
                Simbolo va=Expre(dimension);
                
                for(Nodo variable:lista.hijos){
                    
                    declararVect(variable,"",va, 0);
                }
                
                break;
            }
            case "DECLASIGVAR":{
                inicial.add(raiz);
                break;
            }
            case "DECLASIGVECT":{
                inicial.add(raiz);
                break;
            }
            case "DECLASIGOBJ":{
                objetosTemporales.add(raiz);
                break;
            }
            case "EVENTOBSERVADOR":{
                objetosTemporales.add(raiz);
                break;
            }
            case "ASIG_VAR":{
                inicial.add(raiz);
                break;
            }
            case "ASIG_POSVECT":{
                inicial.add(raiz);
                break;
            }
            case "ASIG_VECT":{
                inicial.add(raiz);
                break;
            }
            case "OPSIMPLE":{
                inicial.add(raiz);
                break;
            }
            case "ASIG_OBJ":{
                inicial.add(raiz);
                break;
            }
            case "SET_OBJ":{
                inicial.add(raiz);
                break;
            }
            case "IF":{
                inicial.add(raiz);
                break;
            }
            case "SELECCIONAR":{
                inicial.add(raiz);
                break;
            }
            case "FOR":{
                inicial.add(raiz);
                break;
            }
            case "MIENTRAS":{
                inicial.add(raiz);
                break;
            }
            case "IMPRIMIR":{
                inicial.add(raiz);
                break;
            }
            case "MENSAJE":{
                inicial.add(raiz);
                break;
            }
            case "CALL_METFUN":{
                inicial.add(raiz);
                break;
            }
            
            
        }
        
            return result;

    }
    
    public Simbolo InitialExecute(){
        Simbolo result=null;
        
        for(int i =0; i<inicial.size();i++){
            
            executeInitialCode(inicial.get(i));
            
        }
        return result;
        
    }
    
    public Simbolo executeInitialCode(Nodo raiz){
        Simbolo result=null;
        
        switch (raiz.token){
            case "DECLASIGVAR":{
                Nodo lista=raiz.hijos.get(0);
                Simbolo value = Expre(raiz.hijos.get(1));
                
                for(Nodo variable:lista.hijos){
                    
                    declararVar(variable,"", 0);
                                      
                    operar.evaluacion = variable;
                    
                    Simbolo var = operar.getVariable(variable.valor.toLowerCase(), Ejecutador.this, new Simbolo());
                    
                    asignacion(var, variable, value);
                    
                }
                
                
                
                break;
            }
            case "DECLASIGVECT":{
                
                Nodo lista=raiz.hijos.get(0);
                Nodo lexp=raiz.hijos.get(1);
                
                
                for(Nodo variable:lista.hijos){
                    
                    declararAsigVect(variable,"", 0,lexp);
                }
                
                break;
            }
            case "DECLASIGOBJ":{
                
                break;
            }
            case "EVENTOBSERVADOR":{
                
                break;
            }
            case "ASIG_VAR":{
                Nodo variable=raiz.hijos.get(0);
                Nodo exp=raiz.hijos.get(1);
                
                Simbolo value=Expre(exp);
                
                operar.evaluacion = variable;
                    
                Simbolo var = operar.getVariable(variable.valor.toLowerCase(), Ejecutador.this, new Simbolo());
                    
                asignacion(var, variable, value);
                break;
            }
            case "ASIG_POSVECT":{
                Nodo variable=raiz.hijos.get(0);
                Nodo posicion=raiz.hijos.get(1);
                Nodo expr=raiz.hijos.get(2);
                
                Simbolo value=Expre(expr);
                Simbolo pos=Expre(posicion);
                
                operar.evaluacion = variable;
                    
                Simbolo var = operar.getVariable(variable.valor.toLowerCase(), Ejecutador.this, new Simbolo());
                    
                    
                    try {
                        if(pos.tipe.equals("double") && var.isArray){
                            
                            int i=Integer.valueOf(pos.value);
                            if(i<var.tamvec){
                            var.tipoarreglo.set(i, value.tipe);
                            var.arreglo.set(i, value.value);
                            Simbolo variab=new  Simbolo();
                            asignacion(var, variable,variab );
                            }else{
                                msjError(raiz, "error dimension vector");
                            }
                        }
                    
                } catch (Exception e) {
                        msjError(raiz, "error acceso vector");
                }
                break;
            }
            case "ASIG_VECT":{
                Nodo variable=raiz.hijos.get(0);
                Nodo lexrp=raiz.hijos.get(1);
                
                operar.evaluacion = variable;
                    
                Simbolo var = operar.getVariable(variable.valor.toLowerCase(), Ejecutador.this, new Simbolo());
                
                var.tamvec=lexrp.hijos.size();
                if(var.isArray){
                for(int i =0;i<lexrp.hijos.size();i++){
                    Simbolo value=Expre(lexrp.hijos.get(i));
                    
                    var.arreglo.add(i, value.value);
                    var.tipoarreglo.add(i,value.tipe);
                            
                    
                }
                }
                Simbolo variab=new  Simbolo();
                asignacion(var, variable,variab );
                break;
            }
            case "OPSIMPLE":{
                Nodo var=raiz.hijos.get(0);
                Nodo operacion=raiz.hijos.get(1);
                
                
                Nodo acceder=var.hijos.get(0);
                
                if(acceder.token.equals("VACCESO")){
                    accion(raiz);
                    
                }else if(acceder.token.equals("VACCESOVECT")){
                    operar.evaluacion = raiz;
                    
                    Nodo nvar=raiz.hijos.get(0).hijos.get(0);
                    
                    Nodo posicion=raiz.hijos.get(0).hijos.get(1);
                    Simbolo pos=Expre(posicion);
                    
                    
                    Simbolo variable = operar.getVariable(nvar.valor, Ejecutador.this, new Simbolo());
                    //es para verificar si la variable existe
                    
                    try {
                        if(pos.tipe.equals("double") && variable.isArray){
                            
                            int i=Integer.valueOf(pos.value);
                            if(i<variable.tamvec && variable.tipoarreglo.get(i).equals("double")){
                                
                            Simbolo valor=new Simbolo();
                            valor.tipe=variable.tipoarreglo.get(i);
                            valor.value=variable.arreglo.get(i);
                            
                            if(operacion.token.equals("INCR")){
                                valor=operar.incrementar(valor);
                                
                            }else if(operacion.token.equals("DECR")){
                                valor=operar.decremetar(valor);
                            }
                                variable.tipoarreglo.add(i, valor.tipe);
                                variable.arreglo.add(i, valor.value);
                                
                                Simbolo variab=new  Simbolo();
                                asignacion(variable, raiz,variab );
                            
                            }else{
                                msjError(raiz, "error dimension vector");
                            }
                        }
                    
                } catch (Exception e) {
                        msjError(raiz, "error acceso vector");
                }
                    
                    
                    
                    
                }
                break;
            }
            case "ASIG_OBJ":{
                inicial.add(raiz);
                break;
            }
            case "SET_OBJ":{
                inicial.add(raiz);
                break;
            }
            case "IF":{
                executeCode(raiz);
                break;
            }
            case "SELECCIONAR":{
                executeCode(raiz);
                break;
            }
            case "FOR":{
                executeCode(raiz);
                break;
            }
            case "MIENTRAS":{
                executeCode(raiz);
                break;
            }
            case "IMPRIMIR":{
                executeCode(raiz);
                break;
            }
            case "MENSAJE":{
                executeCode(raiz);
                break;
            }
            case "CALL_METFUN":{
                callMetodo(raiz, new Simbolo(), 0);
                break;
            }
        }
        
        
        return result;
    }
    
    private void tipoParametros(Nodo root, int opcion, ArrayList<Simbolo> parame) {
        switch (opcion) {
            case 1: {
                //solo obteniendo tipos para el nombre del metodo
                tiposMet += ">" + root.hijos.size();
                break;
            }
            case 2: {
                //se guardan los parametros en la lista de parametros del metodo
                for(Nodo parametro:root.hijos){
                    Simbolo var = new Simbolo();
                    var.name = parametro.valor;
                    var.tipe = "";
                    var.ambito = nombreMetodo;
                    var.rol = "Parametro";
                    var.acceso = "privado";
                    parame.add((Simbolo) var);                    
                }
                
                break;
            }
        }
    }
    
    private Simbolo declararVar(Nodo root, String ambito, int caso) {//0 global // 1 local

        Simbolo result = null;
        Simbolo var = new Simbolo();
        var.name = root.valor.toLowerCase();
        var.tipe = "";
        var.rol = "variable";
        var.value="0";
        
        String key = var.name;
        
        if (caso == 1) {
                    key = ambito + ">" + var.name;
                    tablaSimbolosLocal.put(key, var);
                } else {
                    tablaSimbolosGlobal.put(key, var);
                }
        
        
        return result;
    }
        
    private Simbolo declararVect(Nodo root, String ambito,Simbolo dim, int caso) {//0 global // 1 local

        Simbolo result = null;
        Simbolo var = new Simbolo();
        var.name = root.valor.toLowerCase();
        var.tipe = "";
        var.rol = "variable";
        var.value="0";
       
        try {
        if(dim.tipe.equalsIgnoreCase("double")){
            
            var.isArray=true;
            int dd=Integer.parseInt(dim.value);
            var.tamvec=dd;
            
            for(int i=0;i<dd;i++){
                var.arreglo.add("0");
                var.tipoarreglo.add("");
            
            }
            
        }
        } catch (NumberFormatException e) {
            
            ErrorCjs error = new ErrorCjs(root.valor,root.row, root.col,"Semantico" , "tamano vector");
            tablaErrores.add(error);
      //No problem this time, but still it is good practice to care about exceptions.
      //Never trust user input :)
      //Do something! Anything to handle the exception.
}
        
        
        
        
        String key = var.name;
        
        if (caso == 1) {
                    key = ambito + ">" + var.name;
                    tablaSimbolosLocal.put(key, var);
                } else {
                    tablaSimbolosGlobal.put(key, var);
                }
        
        
        return result;
    }
        
        private Simbolo declararAsigVect(Nodo root, String ambito, int caso,Nodo lexpr) {//0 global // 1 local

        Simbolo result = null;
        Simbolo var = new Simbolo();
        var.name = root.valor.toLowerCase();
        var.tipe = "";
        var.rol = "variable";
        var.value="0";
        var.isArray=true;
        var.tamvec=lexpr.hijos.size();
        
        
        for(int i=0;i<lexpr.hijos.size();i++){
            
            Simbolo value = Expre(lexpr.hijos.get(i));
            var.tipoarreglo.add(i, value.tipe);
            var.arreglo.add(i, value.value);
            
            
        }
        
        
        
        
        String key = var.name;
        
        if (caso == 1) {
                    key = ambito + ">" + var.name;
                    tablaSimbolosLocal.put(key, var);
                } else {
                    tablaSimbolosGlobal.put(key, var);
                }
        
        
        return result;
    }
        
        
        
        @SuppressWarnings("UnusedAssignment")
    public Simbolo Expre(Nodo expr) {

        Simbolo result=null;
        if (expr == null) {
            return null;
        }
        switch (expr.token) {
            case "+":{
                Simbolo val1=Expre((Nodo)expr.hijos.get(0));
                Simbolo val2=Expre((Nodo)expr.hijos.get(1));
                result=operar.sumar(val1, val2);
                return result;
            
            }
            case "-":{
                Simbolo val1=Expre((Nodo)expr.hijos.get(0));
                Simbolo val2=Expre((Nodo)expr.hijos.get(1));
                result=operar.restar(val1, val2);
                return result;
            
            }
            case "*":{
                Simbolo val1=Expre((Nodo)expr.hijos.get(0));
                Simbolo val2=Expre((Nodo)expr.hijos.get(1));
                result=operar.multiplicar(val1, val2);
                return result;
            
            }
            case "/":{
                Simbolo val1=Expre((Nodo)expr.hijos.get(0));
                Simbolo val2=Expre((Nodo)expr.hijos.get(1));
                result=operar.multiplicar(val1, val2);
                return result;
            
            }
            case "%":{
                Simbolo val1=Expre((Nodo)expr.hijos.get(0));
                Simbolo val2=Expre((Nodo)expr.hijos.get(1));
                result=operar.modulo(val1, val2);
                return result;
            
            }
            case "_":{
                Simbolo val1=Expre((Nodo)expr.hijos.get(0));
                
                result=operar.unario(val1);
                return result;
            
            }
            case "^":{
                Simbolo val1=Expre((Nodo)expr.hijos.get(0));
                Simbolo val2=Expre((Nodo)expr.hijos.get(1));
                result=operar.multiplicar(val1, val2);
                return result;
            
            }
            case "<":{
                Simbolo val1=Expre((Nodo)expr.hijos.get(0));
                Simbolo val2=Expre((Nodo)expr.hijos.get(1));
                result=operar.menor(val1, val2);
                return result;
            
            }
             case ">":{
                Simbolo val1=Expre((Nodo)expr.hijos.get(0));
                Simbolo val2=Expre((Nodo)expr.hijos.get(1));
                result=operar.mayor(val1, val2);
                return result;
            
            }
             case ">=":{
                Simbolo val1=Expre((Nodo)expr.hijos.get(0));
                Simbolo val2=Expre((Nodo)expr.hijos.get(1));
                result=operar.mayorIgual(val1, val2);
                return result;
            
            }
            case "<=":{
                Simbolo val1=Expre((Nodo)expr.hijos.get(0));
                Simbolo val2=Expre((Nodo)expr.hijos.get(1));
                result=operar.menorIgual(val1, val2);
                return result;
            
            }
            
            case "==":{
                Simbolo val1=Expre((Nodo)expr.hijos.get(0));
                Simbolo val2=Expre((Nodo)expr.hijos.get(1));
                result=operar.igualar(val1, val2);
                return result;
            
            }
            
            case "!=":{
                Simbolo val1=Expre((Nodo)expr.hijos.get(0));
                Simbolo val2=Expre((Nodo)expr.hijos.get(1));
                result=operar.distinto(val1, val2);
                return result;
            
            }
            
            case "||":{
                Simbolo val1=Expre((Nodo)expr.hijos.get(0));
                Simbolo val2=Expre((Nodo)expr.hijos.get(1));
                result=operar._or(val1, val2);
                return result;
            
            }
            case "&&":{
                Simbolo val1=Expre((Nodo)expr.hijos.get(0));
                Simbolo val2=Expre((Nodo)expr.hijos.get(1));
                result=operar._and(val1, val2);
                return result;
            
            }
            case "!":{
                Simbolo val1=Expre((Nodo)expr.hijos.get(0));
             
                result=operar._not(val1);
                return result;
            
            }
            
            default:{
                return getValue(expr);
            
            }
            
            
        }
            
        // return null;
    }
    @SuppressWarnings("UnusedAssignment")
    private Simbolo getValue(Nodo expr) {//H
        Simbolo valor = new Simbolo();
        operar.evaluacion = expr;
        switch (expr.token) {
            case "NUM": {//entero
                valor.tipe = "double";
                valor.value = expr.valor;
                break;
            }
            case "BOOL": {//caracter
                valor.tipe = "bool";
                valor.value="0";
                if(expr.valor.equalsIgnoreCase("true")){
                    valor.value="1";
                
                }else{
                    valor.value="0";
                }
                break;
            }
            case "CAD": {//cadena
                valor.tipe = "text";
                String cad = expr.valor.replace("\"", "");
                valor.value = cad;
                break;
            }
            case "FECHA": {//date
                valor.tipe = "date";
                String caracter = expr.valor.replace("'", "");
                valor.value = caracter;
                break;
            }
            case "FECHAHORA": {//datetime
                valor.tipe = "datetime";
                String caracter = expr.valor.replace("'", "");
                valor.value = caracter;
                break;
            }
            case "VACCESO": {//variable
                Nodo var= expr.hijos.get(0);
                
                valor = operar.getVariable(var.valor, Ejecutador.this, valor);
                break;
            }
            case "VACCESOVECT": {//vector
                Nodo var= expr.hijos.get(0);
                Nodo pos=expr.hijos.get(1);
                
                Simbolo posicion=Expre(pos);
                valor = operar.getVariable(var.valor, Ejecutador.this, valor);
                
                try {
                        if(posicion.tipe.equals("double") && valor.isArray){
                            
                            int i=Integer.valueOf(posicion.value);
                            if(i<valor.tamvec){
                                                        
                            Simbolo variab=new  Simbolo();
                            variab.value=valor.arreglo.get(i);
                            variab.tipe=valor.tipoarreglo.get(i);
                            valor=variab;
                           
                            }else{
                                msjError(expr, "error dimension vector");
                            }
                        }
                    
                } catch (Exception e) {
                        msjError(expr, "error acceso vector");
                }
                
                
                
                break;
            }
                        
            case "CALL_METFUN": {//llamada metodo
                valor = callMetodo(expr, valor, 1);
                break;
            }
            case "CPRIMITIVAS": {//cuenta
                valor.tipe = "integer";
                int count = expr.getHijo(0).hijos.size();
                valor.value = count + "";
                
                Nodo var= expr.hijos.get(0);
                Nodo tipo=expr.hijos.get(1);
               
                valor = operar.getVariable(var.valor, Ejecutador.this, valor);
                
                try {
                        if(valor.isArray){
                            if(tipo.token.toLowerCase().equals("atexto")){
                                
                            String cadena="";
                            
                            for(int i=0;i<valor.tamvec;i++){
                                cadena+=valor.arreglo.get(i);
                            
                            }
                            valor.value=cadena;
                            valor.tipe="text";
                            }
                            else if(tipo.token.toLowerCase().equals("conteo")){
                                int cant=valor.tamvec;
                                valor.value=String.valueOf(cant);
                                valor.tipe="double";
                            }
                            }else{
                                msjError(expr, "no es array");
                            }
                        
                    
                } catch (Exception e) {
                        msjError(expr, "error acceso vector");
                }
                break;
            }
            case "OPSIMPLE":{
                executeCode(expr);
                Nodo acceder=expr.hijos.get(0);
                
                valor=Expre(acceder);
                
                
                break;
            }
            
            
            default:
                System.err.println("TOKEN = "+  expr.token);
                System.err.println("TOKEN = "+  expr.valor);
                break;

        }
        return valor;
    }
    
    public void Executemetodo(String idMetodo) {

      
        //recorremos tabla Global
        

        if (tablaSimbolosGlobal.containsKey(idMetodo)) {
            Simbolo main_ = tablaSimbolosGlobal.get(idMetodo);
            nombreMetodo = idMetodo;
            exit = false;
            retorno = false;
            executeCode(main_.metodo.sentencias);
        } else{
            msjError(new Nodo(),"No existe metodo");
        }
       
    }
    
    protected Simbolo callMetodo(Nodo root, Simbolo valor, int opcion) {
        String actualAmb = nombreMetodo;
        tiposMet = "";
        if (root.hijos.size() == 2) {
            tipoParametro2((Nodo)root.hijos.get(1), null, 0, 1);
        }
        nombreMetodo = root.hijos.get(0).valor.toLowerCase() + tiposMet;//nombre del metodo a llamar con tipo parametros

        String key = nombreMetodo;
        if (tablaSimbolosGlobal.containsKey(key)) {

            Simbolo myMeto = tablaSimbolosGlobal.get(key);//obteniendo la funcion
            Procedimiento funcion = myMeto.metodo;

            Ejecutador ejecut = new Ejecutador();
            ejecut.tablaSimbolosGlobal = this.tablaSimbolosGlobal;
            ejecut.nombreMetodo = nombreMetodo;
            ejecut.tablitaObjetos = this.tablitaObjetos;

            if (funcion.parametro.isEmpty() && root.hijos.size() == 2) {//si no tiene parametros lo ejecuta
                ejecut.executeCode(funcion.sentencias);
            } else {
                //colocando parametros
                nombreMetodo = actualAmb;
                tipoParametro2((Nodo)root.hijos.get(1), funcion.parametro, 0, 2);//obteniendo valores                
                setParametrosInTabla(funcion.parametro, ejecut.tablaSimbolosLocal);//pasandolos a la tabla de simbolos
                ejecut.executeCode(funcion.sentencias);
            }
            if (opcion == 1) {//para retornar el valor
                if (ejecut.retorna == null && myMeto.tipe.equalsIgnoreCase("void")) {
                    msjError(root, " este metodo no tiene un return");
                    System.out.println("Error en el retorn del metodo");
                } else if (myMeto.tipe.equalsIgnoreCase("void")) {
                    valor.tipe = ejecut.retorna.tipe;
                    valor.value = ejecut.retorna.value;
                    valor.isArray=ejecut.retorna.isArray;
                    valor.arreglo=ejecut.retorna.arreglo;
                    valor.tipoarreglo=ejecut.retorna.arreglo;
                    
                    valor.isobjeto = ejecut.retorna.isobjeto;
                    valor.acceso = ejecut.retorna.acceso;
                    if (valor.isobjeto) {
                        valor.atributos = ejecut.retorna.atributos;
                    }
                    funcion.retornar = ejecut.retorna;
                } else {
                    msjError(root, " el dato retornado no son del mismo tipo del metodo");
                }
            }

            //tablaLocal.clear();
            //tablaLocal.putAll(aux);
            
            //obteniendo las variables del metodo llamado
            copiarData(tablaSimbolosLocal, ejecut.tablaSimbolosLocal);
            retorno = false;
            exit = false;
            continuar = false;
            retorna = null;
        } else {
            msjError(root, " metodo no esta declarado");
            System.out.println("No Existe el metodo " + nombreMetodo);
        }
        nombreMetodo = actualAmb;
        return valor;
    }
    
    String tipocase="";
     String valcase="";
    protected Simbolo executeCode(Nodo root) {
        Simbolo RESULT = null;
        if (root == null) {
            return null;
        }
        switch (root.token) {
            case "LIST_SENTE": {
                
                if (!root.hijos.isEmpty() && !exit && !retorno) {

                    for(Nodo sentencia: root.hijos){
                        if(!exit && !retorno){
                        executeCode(sentencia);
                        }
                    }
                }
                break;
            }
            case "DECLVAR":{
                Nodo lista=root.hijos.get(0);
                
                for(Nodo variable:lista.hijos){
                    
                    declararVar(variable,nombreMetodo, 1);
                }
                break;
            }
            case "DECLVECT":{
                Nodo lista=root.hijos.get(0);
                Nodo dimension=root.hijos.get(1);
                Simbolo va=Expre(dimension);
                
                for(Nodo variable:lista.hijos){
                    
                    declararVect(variable,nombreMetodo,va, 1);
                }
                
                break;
            }
            case "DECLASIGVAR":{
                Nodo lista=root.hijos.get(0);
                Simbolo value = Expre(root.hijos.get(1));
                
                for(Nodo variable:lista.hijos){
                    
                    declararVar(variable,nombreMetodo, 1);
                                      
                    operar.evaluacion = variable;
                    
                    Simbolo var = operar.getVariable(variable.valor.toLowerCase(), Ejecutador.this, new Simbolo());
                    
                    asignacion(var, variable, value);
                    
                }
                
                
                
                break;
            }
            case "DECLASIGVECT":{
                
                Nodo lista=root.hijos.get(0);
                Nodo lexp=root.hijos.get(1);
                
                
                for(Nodo variable:lista.hijos){
                    
                    declararAsigVect(variable,nombreMetodo, 1,lexp);
                }
                
                break;
            }
            case "ASIG_VAR":{
                Nodo variable=root.hijos.get(0);
                Nodo exp=root.hijos.get(1);
                
                Simbolo value=Expre(exp);
                
                operar.evaluacion = variable;
                    
                Simbolo var = operar.getVariable(variable.valor.toLowerCase(), Ejecutador.this, new Simbolo());
                    
                asignacion(var, variable, value);
                
                break;
            }
            case "ASIG_POSVECT":{
                Nodo variable=root.hijos.get(0);
                Nodo posicion=root.hijos.get(1);
                Nodo expr=root.hijos.get(2);
                
                Simbolo value=Expre(expr);
                Simbolo pos=Expre(posicion);
                
                operar.evaluacion = variable;
                    
                Simbolo var = operar.getVariable(variable.valor.toLowerCase(), Ejecutador.this, new Simbolo());
                    
                    
                    try {
                        if(pos.tipe.equals("double") && var.isArray){
                            
                            int i=Integer.valueOf(pos.value);
                            if(i<var.tamvec){
                            var.tipoarreglo.set(i, value.tipe);
                            var.arreglo.set(i, value.value);
                            Simbolo variab=new  Simbolo();
                            asignacion(var, variable,variab );
                            }else{
                                msjError(root, "error dimension vector");
                            }
                        }
                    
                } catch (Exception e) {
                        msjError(root, "error acceso vector");
                }
                    

                
                
                break;
            }
            case "ASIG_VECT":{
                Nodo variable=root.hijos.get(0);
                Nodo lexrp=root.hijos.get(1);
                
                operar.evaluacion = variable;
                    
                Simbolo var = operar.getVariable(variable.valor.toLowerCase(), Ejecutador.this, new Simbolo());
                
                var.tamvec=lexrp.hijos.size();
                if(var.isArray){
                for(int i =0;i<lexrp.hijos.size();i++){
                    Simbolo value=Expre(lexrp.hijos.get(i));
                    
                    var.arreglo.add(i, value.value);
                    var.tipoarreglo.add(i,value.tipe);
                            
                    
                }
                }
                Simbolo variab=new  Simbolo();
                asignacion(var, variable,variab );
                
                
                
                
                break;
            }
            case "OPSIMPLE":{
                Nodo var=root.hijos.get(0);
                Nodo operacion=root.hijos.get(1);
                
                
                Nodo acceder=var.hijos.get(0);
                
                if(acceder.token.equals("VACCESO")){
                    accion(root);
                    
                }else if(acceder.token.equals("VACCESOVECT")){
                    operar.evaluacion = root;
                    
                    Nodo nvar=root.hijos.get(0).hijos.get(0);
                    
                    Nodo posicion=root.hijos.get(0).hijos.get(1);
                    Simbolo pos=Expre(posicion);
                    
                    
                    Simbolo variable = operar.getVariable(nvar.valor, Ejecutador.this, new Simbolo());
                    //es para verificar si la variable existe
                    
                    try {
                        if(pos.tipe.equals("double") && variable.isArray){
                            
                            int i=Integer.valueOf(pos.value);
                            if(i<variable.tamvec && variable.tipoarreglo.get(i).equals("double")){
                                
                            Simbolo valor=new Simbolo();
                            valor.tipe=variable.tipoarreglo.get(i);
                            valor.value=variable.arreglo.get(i);
                            
                            if(operacion.token.equals("INCR")){
                                valor=operar.incrementar(valor);
                                
                            }else if(operacion.token.equals("DECR")){
                                valor=operar.decremetar(valor);
                            }
                                variable.tipoarreglo.add(i, valor.tipe);
                                variable.arreglo.add(i, valor.value);
                                
                                Simbolo variab=new  Simbolo();
                                asignacion(variable, root,variab );
                            
                            }else{
                                msjError(root, "error dimension vector");
                            }
                        }
                    
                } catch (Exception e) {
                        msjError(root, "error acceso vector");
                }
                    
                    
                    
                    
                }
                
                break;
            }
            case "ASIG_OBJ":{
                
                break;
            }
            case "SET_OBJ":{
                
                break;
            }
            
            case "IF": {
             
                Simbolo cond = Expre((Nodo)root.hijos.get(0));
                if (cond.value.equals("1") || cond.value.equals("0")) {

                    if (cond.value.equals("1")) {//if
                        executeCode((Nodo) root.hijos.get(1));
                    }

                    if (root.hijos.size() == 3 && cond.value.equals("0")) {//else
                        executeCode((Nodo) root.hijos.get(2));
                    }
                } else {
                    msjError(root, " la sentencia del if, no es un dato boolean");
                }
                break;
            }
            case "IMPRIMIR": {
                
                Simbolo expr = Expre((Nodo) root.hijos.get(0));
                System.out.println("Print( " + expr.value + " );");
                //Consola.writeln(expr.value);
                break;
            }
            case "MENSAJE":{
                Simbolo expr = Expre((Nodo) root.hijos.get(0));
                System.out.println("MENSAJE( " + expr.value + " );");
            }
            case "MIENRAS": {
                exit = false;
                //continuar = false;

                Simbolo cond = Expre((Nodo) root.hijos.get(0));

                if (cond.value.equals("1") || cond.value.equals("0")) {

                    while (cond.value.equals("1")) {
                      

                        executeCode((Nodo) root.hijos.get(1));
                        if (exit || retorno) {
                            break;
                        }
                        cond = Expre((Nodo) root.hijos.get(0));
                        //continuar = false;
                    }
                } else {
                    msjError(root, " la sentencia del Mientras, no es un dato boolean");
                }
                exit = false;
                break;
            }
            
           
            case "SELECCIONAR": {
                exit = false;
                //continuar = false;
                valcase="false";

               

                Simbolo expr = Expre((Nodo) root.hijos.get(0));
                Nodo lcaso = (Nodo) root.hijos.get(1);
                
                for(Nodo caso: lcaso.hijos){
                
                    caso.tipocase = expr.tipe;
                    caso.valcase= expr.value;
                    executeCode(caso);
                }
                
                if (!exit && root.hijos.size() == 3 && !retorno) {
                    executeCode((Nodo) root.hijos.get(2));
                }
                exit = false;
                //continuar = false;
                break;
            }
            case "CASOS": {
              
                Simbolo expr = Expre((Nodo) root.hijos.get(0));                
                if (expr.value.equals(root.valcase) || valcase.equals("true")) {                    
                    executeCode((Nodo) root.hijos.get(1));
                    if (!exit  && !retorno) {
                        
                        valcase = "true";
                        
                    }else{
                        valcase="false";
                    }
                } 
                break;
            }
            case "CDEFECTO":{
                
                for(Nodo sentencias:root.hijos){
                    executeCode(sentencias);
                    
                }
                
                break;
            }
            case "DETENER": {
                
                exit = true;
                break;
            }
            case "FOR": {
                //continuar = false;
                exit = false;

                executeCode((Nodo) root.hijos.get(0));//asignando variable inicial
                Simbolo cond = Expre((Nodo) root.hijos.get(1));//condicion del for
                if (cond.value.equals("1") || cond.value.equals("0")) {
                    while (cond.value.equals("1")) {
                        
                        /*se ejecuta si y solo si es verdadera la condicion, y 
                         se sale cuando la condicion sea false
                         /*ejecutamos sentencias*/
                        executeCode((Nodo) root.hijos.get(3));

                        if(root.hijos.get(2).token.equals("DECR")){
                        if (!decrementar((Nodo) root.hijos.get(0).hijos.get(0)) || exit || retorno)//incremento
                        {
                            break;
                        }
                        }else if(root.hijos.get(2).token.equals("INCR")){
                         if (!incrementar((Nodo) root.hijos.get(0).hijos.get(0)) || exit || retorno)//incremento
                        {
                            break;
                        }   
                        }
                        //continuar = false;
                        cond = Expre((Nodo) root.hijos.get(1));//condicion final del for  

                    }
                } else {
                    msjError(root, " la sentencia del Hacer, no es un dato boolean");
                }
                exit = false;
                break;
            }
            
            case "RETORNAR": {
                
                retorna = Expre((Nodo) root.hijos.get(0));
                retorno = true;
                break;
            }
            case "CALL_METFUN": {//llamada metodo
                callMetodo(root, new Simbolo(), 0);
                break;
            }
            
            
            default:
                break;
        }
        return RESULT;
    }
    
    
    private void setParametrosInTabla(ArrayList<Simbolo> paramet, Hashtable<String, Simbolo> copiaTab) {
        for (Simbolo sim : paramet) {
            copiaTab.put(sim.ambito + ">" + sim.name, (Simbolo) sim.clone());
        }
    }

    private void tipoParametro2(Nodo root, ArrayList<Simbolo> paramet, int i, int caso) {
        
        switch (caso) {
            case 1: {
                
                    int numparametros=root.hijos.size();
                    tiposMet += ">" + String.valueOf(numparametros);
                             
            
                
                break;
            }
            case 2: {
                
                for(Nodo hijo:root.hijos){
                    Simbolo valor = Expre((Nodo) hijo);
                    Simbolo par = paramet.get(i);
                    par.value = valor.value;
                    par.tipe=valor.tipe;
                    
                    
                    par.isobjeto = valor.isobjeto;
                    par.atributos = valor.atributos;
                
                    
                    i++;
                
                }
                
                
                break;
            }
        }
        
    }
    
     private void copiarData(Hashtable<String, Simbolo> copia, Hashtable<String, Simbolo> original) {
        Enumeration e = original.keys();
        String clave;
        Simbolo valor;
        while (e.hasMoreElements()) {
            clave = (String) e.nextElement();
            valor = original.get(clave);
            copia.put(clave, (Simbolo) valor.clone());
        }

    }
    private void asignacion(Simbolo variable, Nodo root, Simbolo valor) {
        
        if (operar.cast(variable, valor)) {
            variable.value = valor.value;
            variable.tipe=valor.tipe;
        } else {
            msjError(root, " no es posible realizar la asignacion,\n porque no se puede castear");
            System.out.println("Error en asignacion no se puede asignar");
        }
    }

    private boolean incrementar(Nodo root){
        operar.evaluacion = root;
        Simbolo variable = operar.getVariable(root.valor, Ejecutador.this, new Simbolo());//es para verificar si la variable existe
        if (variable.name.equals("")) {
            return false;
        }
        
        operar.incrementar(variable);
        
        return true;
    }
    
    private boolean decrementar(Nodo root){
        operar.evaluacion = root;
        Simbolo variable = operar.getVariable(root.valor, Ejecutador.this, new Simbolo());//es para verificar si la variable existe
        if (variable.name.equals("")) {
            return false;
        }
        
        operar.decremetar(variable);
        
        return true;
    }
    private boolean accion(Nodo root) {
        operar.evaluacion = root;
        Simbolo variable = operar.getVariable(root.hijos.get(0).hijos.get(0).valor, Ejecutador.this, new Simbolo());//es para verificar si la variable existe
        if (variable.name.equals("")) {
            return false;
        }
        
       
        switch (root.hijos.get(1).token) {
            
            case "INCR": {//++
               
                    operar.incrementar(variable);
                
                break;
            }
            case "DECR": {//--
               
                    operar.decremetar(variable);
                
                break;
            }
        }
        return true;
    }
        protected void msjError(Nodo root, String texto) {
        String val = (String) root.token;
        tablaErrores.add(new ErrorCjs(val,root.row,root.col,"Error Semantico",texto));
    }

}
