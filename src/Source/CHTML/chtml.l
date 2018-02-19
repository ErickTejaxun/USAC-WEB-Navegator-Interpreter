package Source.CHTML;
import java_cup.runtime.Symbol;
import java.util.ArrayList;
import Principal.Errores;
import Principal.Interfaz;
import Principal.tablaSimbolos;
/*
Directivas:
public: clase publica
cup: compatibilidad con cup
full: extender el alfabeto con todos los valores de 8 bits
line: agrega la variable int yyline, para indicar la fila del lexema
char: agrega la variable int yychar, indica el indice del primer caracter del lexema
ignorecase: validar, indistitntamente si la letra es mayuscula o minuscula
eofval: especifica un valor de retorno al final del archivo
*/




%%
%{	public static ArrayList<Errores> listaLexico=new ArrayList();	
	public static String urlAuxliar="";
	public static Boolean fin=false;
	public static String txt_temporal="";
	public static int linea=0;
	public static int columna=0;



    public static int flagInicio = 0;
    public String cadena = "";
%}

%class Scanner /*Nombre de la clase a generar.%cupsym simbolos*/
%unicode /*Caracteres unicode*/
%public /*Se generará una clase pública.*/
%cup
%full
%line   /*Almacenar el número de linea actual.*/
%char   /* Contador de caracteres.*/
%ignorecase /*Indiferente entre mayusculas y minusculas*/
%eofval{
	return new Symbol(simbolos.EOF,new String("Fin del archivo"));
    /*({letra}":"("\\"({linea})+)+)*/
%eofval}

espacio = \t|\f|" "|\r|\n
digito = [0-9][0-9]*
decimal= {digito}"."{digito}
simbolos1= "@"|":"|"!"|"¿"|"\""|"ñ"|","
simbolos2= "("|")"|"*"|"-"|"+"|"."|"!"
letra = ([a-zA-Z]|"ñ"|"á"|"é"|"í"|"ó"|"ú")
linea = ([^\r\n\"\\])
id = ({letra}({letra}|{digito}|"_"|"-")*)
rgb  = ("#"{id}| "#"{digito}{id})
direccionWindows= ("\"" ({letra}":"("\\"({id})+)+"."{id}) "\"")
direccionLinux=(("/"{linea}+))+

idComillas = ("\""{id}"\"")
rgbComillas = ("\""{rgb}"\"")



%state COMENTARIO, ENCABEZADO1, ENCABEZADO2, CUERPO, TITULO1, TITULO2, TITULO3
%%



[\n] { yychar=0;}




<YYINITIAL>
{

    
    {espacio}
    {System.out.println("Salto de linea");}	


    /*----------  < ----------------*/
    "<//-"	
    {   
        yybegin(COMENTARIO);
    }


    /*----------  < ----------------*/
    "<"	
    {

        Interfaz.auxContador++;                                
        //Generamos la entrada en la tabla de simbolos.
        tablaSimbolos simbolo=new tablaSimbolos();
        simbolo.setTipo("menorQue");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("< : Menor que");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);	
       
        return new Symbol(simbolos.menorQue, yychar, yyline, yytext()); 
    }

    /*----------  > ----------------*/
    ">"	
    {
        Interfaz.auxContador++;                                
        //Generamos la entrada en la tabla de simbolos.
        tablaSimbolos simbolo=new tablaSimbolos();
        simbolo.setTipo("mayorQue");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("> : Mayor que");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);	        
        return new Symbol(simbolos.mayorQue, yychar, yyline, yytext()); 
    }    

    /*----------1. CHTML----------------*/
    "CHTML"	
    {
        Interfaz.auxContador++;                                
        //Generamos la entrada en la tabla de simbolos.
        tablaSimbolos simbolo=new tablaSimbolos();
        simbolo.setTipo("inicioChtml");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("CHTML : Inicio Documento");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);	
        
        return new Symbol(simbolos.inicioChtml, yychar, yyline, yytext()); 
    }


    "FIN-CHTML"	
    {
        Interfaz.auxContador++;                                
        //Generamos la entrada en la tabla de simbolos.
        tablaSimbolos simbolo=new tablaSimbolos();
        simbolo.setTipo("finChtml");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("FIN-CHTML : Fin Documento");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);	
        
        return new Symbol(simbolos.finChtml, yychar, yyline, yytext()); 
    }

    "encabezado"
    {        
        yybegin(ENCABEZADO1);
        System.out.println("Saltar a estado ENCABEZADO1");
        Interfaz.auxContador++;                                
        //Generamos la entrada en la tabla de simbolos.
        tablaSimbolos simbolo=new tablaSimbolos();
        simbolo.setTipo("inicioEncabezado");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("encabezado : Inicio encabezado");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);        	        
        return new Symbol(simbolos.inicioEncabezado, yychar, yyline, yytext()); 
       
    } 

    "cuerpo"
    {        
        yybegin(CUERPO);
        System.out.println("Saltar a estado CUERPO");
        Interfaz.auxContador++;                                
        //Generamos la entrada en la tabla de simbolos.
        tablaSimbolos simbolo=new tablaSimbolos();
        simbolo.setTipo("cuerpo");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("cuerpo : Inicio cuerpo");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);        	        
        return new Symbol(simbolos.inicioCuerpo, yychar, yyline, yytext()); 
       
    } 

    "fin-cuerpo"
    {        
        Interfaz.auxContador++;                                
        //Generamos la entrada en la tabla de simbolos.
        tablaSimbolos simbolo=new tablaSimbolos();
        simbolo.setTipo("fin-cuerpo");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("fin-cuerpo : Fin cuerpo");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);        	        
        return new Symbol(simbolos.finCuerpo, yychar, yyline, yytext()); 
       
    }    
}


<TITULO1>
{

    {espacio}
    {}

    ">"	
    {    
        yybegin(TITULO2);                           
        System.out.println("Saltar a estado TITULO2");
        Interfaz.auxContador++;                                
        //Generamos la entrada en la tabla de simbolos.
        tablaSimbolos simbolo=new tablaSimbolos();
        simbolo.setTipo("mayorQue");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("> : Mayor que");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);	
        
        
        return new Symbol(simbolos.mayorQue, yychar, yyline, yytext()); 
    }    


}



<TITULO2>
{
    {espacio}
    {cadena  = cadena + yytext();}	


    [^]
    {  
        if(!yytext().equals("<"))
        {
            cadena  = cadena + yytext();
            //System.out.println(cadena);
        }
        else 
        {

            //cadena = cadena + yytext();
            
            yybegin(ENCABEZADO2);
            Interfaz.auxContador++;                                
            //Generamos la entrada en la tabla de simbolos.
            tablaSimbolos simbolo=new tablaSimbolos();
            simbolo.setTipo("cadena");
            simbolo.setLinea(yyline);
            simbolo.setColumna(yychar);
            simbolo.setDescripcion("Cadena : cadena de texto");
            simbolo.setIndex(Interfaz.auxContador);
            simbolo.setValor(cadena);                 
            Interfaz.tablaSimbolos_.add(simbolo);
            yypushback(1);	                
            return new Symbol(simbolos.cadena, yychar, yyline, yytext()); 

        }                       
    } 


   


}

<TITULO3>
{

    {espacio}
    {}

    "<"	
    {    
        yybegin(ENCABEZADO2);  
        System.out.println("----------------------------------------------Saliendo de titulo3");                         
        System.out.println("Saltar a estado ENCABEZADO2");
        Interfaz.auxContador++;                                
        //Generamos la entrada en la tabla de simbolos.
        tablaSimbolos simbolo=new tablaSimbolos();
        simbolo.setTipo("menorQue");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("< : Menor que titulo");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);	                
        return new Symbol(simbolos.mayorQue, yychar, yyline, yytext()); 
    }    


}


<CUERPO>
{
    {espacio}
    {}	

    ">"	
    {    
        yybegin(YYINITIAL);                           
        System.out.println("Saltar a estado ENCABEZADO2");
        Interfaz.auxContador++;                                
        //Generamos la entrada en la tabla de simbolos.
        tablaSimbolos simbolo=new tablaSimbolos();
        simbolo.setTipo("mayorQue");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("> : Mayor que");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);	
        
        
        return new Symbol(simbolos.mayorQue, yychar, yyline, yytext()); 
    }      

    "fondo"	
    {
        Interfaz.auxContador++;                                
        //Generamos la entrada en la tabla de simbolos.
        tablaSimbolos simbolo=new tablaSimbolos();
        simbolo.setTipo("fondo");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("fondo : declaracion fondo");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);	
       
        return new Symbol(simbolos.fondo, yychar, yyline, yytext()); 
    }  

    "="
    {
        Interfaz.auxContador++;
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("asignacion");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("= : Asignacion");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                
        Interfaz.tablaSimbolos_.add(simbolo);
             
        
        //Nos movemos al estado auxiliar para declaracion cjs
        return new Symbol(simbolos.asignacion, yychar, yyline, yytext());

    }  

    ";"
    {
        Interfaz.auxContador++;
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("puntoComa");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("; : Punto coma");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
            
        
        //Nos movemos al estado auxiliar para declaracion cjs
        return new Symbol(simbolos.puntoComa, yychar, yyline, yytext());

    }    


    {rgbComillas}
    {
        Interfaz.auxContador++;
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("rgb");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("rgb: Posible nombre de color.");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
               
        
        //Nos movemos al estado auxiliar para declaracion cjs
        return new Symbol(simbolos.rgb, yychar, yyline, yytext());

    }

    {idComillas}
    {
        Interfaz.auxContador++;
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("id");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("id: Posible nombre de color.");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
               
        
        //Nos movemos al estado auxiliar para declaracion cjs
        return new Symbol(simbolos.id, yychar, yyline, yytext());

    } 

  

             


}


<ENCABEZADO1>
{



    /*----------  > ----------------*/
    ">"	
    {    
        yybegin(ENCABEZADO2);                           
        System.out.println("Saltar a estado ENCABEZADO2");
        Interfaz.auxContador++;                                
        //Generamos la entrada en la tabla de simbolos.
        tablaSimbolos simbolo=new tablaSimbolos();
        simbolo.setTipo("mayorQue");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("> : Mayor que");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);	
        
        
        return new Symbol(simbolos.mayorQue, yychar, yyline, yytext()); 
    }  

    {espacio}
    {}	       
}

<ENCABEZADO2>
{
    {espacio}
    {}

    "fin-titulo"
    {        
        Interfaz.auxContador++;                                
        //Generamos la entrada en la tabla de simbolos.
        tablaSimbolos simbolo=new tablaSimbolos();
        simbolo.setTipo("fin-titulo");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("fin-titulo : Fin titulo");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);        	        
        return new Symbol(simbolos.finTitulo, yychar, yyline, yytext()); 
       
    }      	

    "titulo"
    {        
        yybegin(TITULO1);
        System.out.println("Saltar a estado CUERPO");
        Interfaz.auxContador++;                                
        //Generamos la entrada en la tabla de simbolos.
        tablaSimbolos simbolo=new tablaSimbolos();
        simbolo.setTipo("titulo");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("titulo : Inicio titulo");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);        	        
        return new Symbol(simbolos.inicioTitulo, yychar, yyline, yytext()); 
       
    }

    



    "<"	
    {
        Interfaz.auxContador++;                                
        //Generamos la entrada en la tabla de simbolos.
        tablaSimbolos simbolo=new tablaSimbolos();
        simbolo.setTipo("menorQue");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("< : Menor que");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);	
       
        return new Symbol(simbolos.menorQue, yychar, yyline, yytext()); 
    }

    "CJS"
    {
        Interfaz.auxContador++;
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("inicioCjs");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("CJS : Inicio etiqueta CJS");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
              
        
        //Nos movemos al estado auxiliar para declaracion cjs
        return new Symbol(simbolos.inicioCjs, yychar, yyline, yytext());

    }   

    "ruta"
    {
        Interfaz.auxContador++;
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("ruta");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("ruta : Declaración ruta archivo");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
               
        
        //Nos movemos al estado auxiliar para declaracion cjs
        return new Symbol(simbolos.ruta, yychar, yyline, yytext());

    } 


    "="
    {
        Interfaz.auxContador++;
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("asignacion");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("= : Asignacion");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                
        Interfaz.tablaSimbolos_.add(simbolo);
             
        
        //Nos movemos al estado auxiliar para declaracion cjs
        return new Symbol(simbolos.asignacion, yychar, yyline, yytext());

    } 

  

    ";"
    {
        Interfaz.auxContador++;
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("puntoComa");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("; : Punto coma");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
            
        
        //Nos movemos al estado auxiliar para declaracion cjs
        return new Symbol(simbolos.puntoComa, yychar, yyline, yytext());

    } 

    ">"
    {
        Interfaz.auxContador++;
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("mayorQue");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("> : Mayor que");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);


        //Nos movemos al estado auxiliar para declaracion cjs
        return new Symbol(simbolos.mayorQue, yychar, yyline, yytext());

    }  

    "fin-cjs"
    {
        Interfaz.auxContador++;
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("finCjs");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("fin-cjs : finCJs");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
             
        
        //Nos movemos al estado auxiliar para declaracion cjs
        return new Symbol(simbolos.finCjs, yychar, yyline, yytext());
    } 

    "CCSS"
    {
        Interfaz.auxContador++;
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("inicioCcss");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("CCSS : Inicio etiqueta CCSS");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
              
        
        //Nos movemos al estado auxiliar para declaracion cjs
        return new Symbol(simbolos.inicioCcss, yychar, yyline, yytext());

    } 
    "fin-CCSS"
    {
        Interfaz.auxContador++;
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("finCcss");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("fin-CCSS : fin etiqueta CCSS");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
             
        
        //Nos movemos al estado auxiliar para declaracion cjs
        return new Symbol(simbolos.finCcss, yychar, yyline, yytext());

    }  

    "FIN-ENCABEZADO"	
    {
        yybegin(YYINITIAL);
        Interfaz.auxContador++;                                
        //Generamos la entrada en la tabla de simbolos.
        tablaSimbolos simbolo=new tablaSimbolos();
        simbolo.setTipo("finEncabezado");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("FIN-ENCABEZADO : Fin Encabezado");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);	
        
        return new Symbol(simbolos.finEncabezado, yychar, yyline, yytext()); 
    }  

    {direccionWindows}
    {
        Interfaz.auxContador++;
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("pathComillas");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("Path: Ruta a archivo");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
               
        
        //Nos movemos al estado auxiliar para declaracion cjs
        return new Symbol(simbolos.pathComillas, yychar, yyline, yytext());

    }   

    

}



/*Comentarios de chtml*/
<COMENTARIO>{espacio} {}
<COMENTARIO>[^"*/"] {System.out.print(yytext());}
<COMENTARIO> "-//>"	 
            {
						yybegin(YYINITIAL);	
            }
.			{
			System.out.println("Caracter ilegal: " + yytext()+" Linea : "+yyline +" Columna: "+yychar); 
			Errores errorLexico=new Errores();
			errorLexico.setTipo("Lexico");
			errorLexico.setLinea(yyline);
			errorLexico.setColumna(yychar);
			errorLexico.setDescripcion("Caracter Ilegal: "+yytext());
			Interfaz.erroresLexicos.add(errorLexico);
			//Proyecto1_Compiladores.listaLexico.add(errorLexico);
			//Menu.listaLexico=Proyecto1_Compiladores.listaLexico;
			}			
