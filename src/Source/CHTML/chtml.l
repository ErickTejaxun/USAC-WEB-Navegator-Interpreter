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

path = ({letra}":"("\\"({id})+)+"."{id})


idComillas = ("\""{id}"\""|"\""{digito}"\""|"\""{decimal}"\"") 
rgbComillas = ("\""{rgb}"\"")
valorAlineado = ("\"izquierda\""|"\"derecha\""|"\"centrado\"")

metodo = {id}"()"


%state COMENTARIO, ENCABEZADO1, ENCABEZADO2, CUERPO, TITULO1, TITULO2, TITULO3, ELEMENTOS,TEXTO1,TEXTO2
%state IMAGEN1,IMAGEN2, BOTON1, BOTON2, ENLACE1,ENLACE2,T1,T2,T3,T4,T5,T6,T7,TB,TB2,TI,TI2,TB3
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
        cadena = "";
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
        System.out.println("*****************************************************************");
        return new Symbol(simbolos.menorQue, yychar, yyline, yytext()); 
    }

    /*----------  > ----------------*/
    ">"	
    {
        cadena = "";
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


    "panel"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("inicioPanel");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("panel: Declaracion panel");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
               
        yybegin(ELEMENTOS);        
        return new Symbol(simbolos.inicioPanel, yychar, yyline, yytext());        
        
    } 

    "fin-panel"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("finPanel");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("fin-panel: Cierre panel");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                          
        return new Symbol(simbolos.finPanel, yychar, yyline, yytext());        
        
    }  


    "texto"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("texto");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("texto: Inicio texto");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
        yybegin(TEXTO1);                            
        return new Symbol(simbolos.inicioTexto, yychar, yyline, yytext());        
        
    } 

    "fin-texto"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("fin-texto");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("fin-texto: Fin texto");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);                                    
        return new Symbol(simbolos.finTexto, yychar, yyline, yytext());        
        
    }   

    "imagen"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("imagen");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("imagen: Inicio imagen");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
        yybegin(IMAGEN1);                                    
        return new Symbol(simbolos.inicioImagen, yychar, yyline, yytext());        
        
    }  

    "boton"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("boton");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("boton: Inicio boton");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
        yybegin(BOTON1);                                    
        return new Symbol(simbolos.inicioBoton, yychar, yyline, yytext());        
        
    } 

    "fin-boton"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("fin-boton");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("fin-boton: Fin boton");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);                                 
        return new Symbol(simbolos.finBoton, yychar, yyline, yytext());        
        
    }   


    "enlace"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("enlace");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("enlace: Inicio enlace");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
        yybegin(ENLACE1);                                    
        return new Symbol(simbolos.inicioEnlace, yychar, yyline, yytext());        
        
    } 

    "fin-enlace"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("fin-enlace");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("fin-enlace: Fin enlace");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);                                 
        return new Symbol(simbolos.finEnlace, yychar, yyline, yytext());        
        
    }     
    
    "tabla"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("tabla");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("tabla: Inicio tabla");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
        yybegin(T1);                                    
        return new Symbol(simbolos.inicioTabla, yychar, yyline, yytext());        
        
    }           

                
}

<T1>
{


    "id"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("id Ccss");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("id : Identificador grupo ccss");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.idCcss, yychar, yyline, yytext());

    }

    "grupo"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("grupo");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("grupo : grupo ccss");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.grupo, yychar, yyline, yytext());

    } 

    "alto"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("alto");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("alto : Altura objeto");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.alto, yychar, yyline, yytext());

    }     


    "ancho"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("ancho");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("ancho : Anchura objeto");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.ancho, yychar, yyline, yytext());

    } 

    "alineado"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("alineado");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("alineado : Alineación objeto");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.alineado, yychar, yyline, yytext());

    }  
      
    "="
    {        
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("asignacion");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("= : Asignacion");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                
        Interfaz.tablaSimbolos_.add(simbolo);
                             
        return new Symbol(simbolos.asignacion, yychar, yyline, yytext());

    } 

    {valorAlineado}
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("valorAlineado");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("valorAlineado : Alineación");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.valorAlineado, yychar, yyline, yytext());

    }         


    {idComillas}
    {        
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("id");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("id: Posible nombre de color.");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);

        return new Symbol(simbolos.id, yychar, yyline, yytext());

    } 



    ";"
    {        
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("puntoComa");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("; : Punto coma");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                    
        return new Symbol(simbolos.puntoComa, yychar, yyline, yytext());

    } 
                

    ">"	
    {    
        yybegin(T2);                           
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
    {

    }
}


<T2>
{

    {espacio}
    {

    }  

    "<"	
    {
        cadena = "";
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
        System.out.println("*****************************************************************");
        return new Symbol(simbolos.menorQue, yychar, yyline, yytext()); 
    }   

    ">"	
    {
        cadena = "";
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
        System.out.println("*****************************************************************");
        return new Symbol(simbolos.mayorQue, yychar, yyline, yytext()); 
    }       


    "fin-tabla"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("fin-tabla");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("fin-tabla: Fin tabla");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);  
        yybegin(YYINITIAL);
        return new Symbol(simbolos.finTabla, yychar, yyline, yytext());        
        
    } 


    "fil_t"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("fil_t");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("fil_t: Inicio fila");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo); 
        yybegin(T3);                                
        return new Symbol(simbolos.inicioFila, yychar, yyline, yytext());        
        
    }     


}

<T3>
{


    "id"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("id Ccss");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("id : Identificador grupo ccss");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.idCcss, yychar, yyline, yytext());

    }

    "grupo"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("grupo");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("grupo : grupo ccss");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.grupo, yychar, yyline, yytext());

    } 

    "alto"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("alto");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("alto : Altura objeto");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.alto, yychar, yyline, yytext());

    }     


    "ancho"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("ancho");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("ancho : Anchura objeto");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.ancho, yychar, yyline, yytext());

    } 

    "alineado"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("alineado");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("alineado : Alineación objeto");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.alineado, yychar, yyline, yytext());

    }  
      
    "="
    {        
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("asignacion");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("= : Asignacion");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                
        Interfaz.tablaSimbolos_.add(simbolo);
                             
        return new Symbol(simbolos.asignacion, yychar, yyline, yytext());

    } 

    {valorAlineado}
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("valorAlineado");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("valorAlineado : Alineación");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.valorAlineado, yychar, yyline, yytext());

    }         


    {idComillas}
    {        
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("id");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("id: Posible nombre de color.");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);

        return new Symbol(simbolos.id, yychar, yyline, yytext());

    } 



    ";"
    {        
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("puntoComa");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("; : Punto coma");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                    
        return new Symbol(simbolos.puntoComa, yychar, yyline, yytext());

    } 
                

    ">"	
    {    
        yybegin(T4);                           
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
    {

    }
}



<T4>
{
    {espacio}
    {

    }  

    "<"	
    {
        cadena = "";
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


    ">"	
    {
        cadena = "";
        Interfaz.auxContador++;                                
        //Generamos la entrada en la tabla de simbolos.
        tablaSimbolos simbolo=new tablaSimbolos();
        simbolo.setTipo("mayorQue");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("> : Mayor que T4");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);	        
        return new Symbol(simbolos.mayorQue, yychar, yyline, yytext()); 
    }


    "fin-fil_t"
    {        
        Interfaz.auxContador++;                                
        //Generamos la entrada en la tabla de simbolos.
        tablaSimbolos simbolo=new tablaSimbolos();
        simbolo.setTipo("fin-fil_t");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("fin-fil_t : Fin Fila");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);   
        yybegin(T2);     	        
        return new Symbol(simbolos.finFila, yychar, yyline, yytext());        
    } 

    "cb"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("cb");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("cb: Inicio Celda cabecera");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
        yybegin(T5);   
        System.out.println("SALTAR A T5");
        return new Symbol(simbolos.inicioCeldaCabecera, yychar, yyline, yytext());                
    }

    "ct"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("ct");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("ct: Inicio Celda");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
        yybegin(T5);    
        System.out.println("SALTAR A T5");                                
        return new Symbol(simbolos.inicioCelda, yychar, yyline, yytext());                
    }    

}

<T5>
{


    "id"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("id Ccss");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("id : Identificador grupo ccss T5");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);                            
        return new Symbol(simbolos.idCcss, yychar, yyline, yytext());

    }

    "grupo"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("grupo");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("grupo : grupo ccss T5");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.grupo, yychar, yyline, yytext());

    } 

    "alto"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("alto");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("alto : Altura objeto T5");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.alto, yychar, yyline, yytext());

    }     


    "ancho"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("ancho");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("ancho : Anchura objeto T5");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.ancho, yychar, yyline, yytext());

    } 

    "alineado"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("alineado");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("alineado : Alineación objeto T5");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.alineado, yychar, yyline, yytext());

    }  
      
    "="
    {        
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("asignacion");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("= : Asignacion T5");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                
        Interfaz.tablaSimbolos_.add(simbolo);
                             
        return new Symbol(simbolos.asignacion, yychar, yyline, yytext());

    } 

    {valorAlineado}
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("valorAlineado");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("valorAlineado : Alineación T5");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.valorAlineado, yychar, yyline, yytext());

    }         


    {idComillas}
    {        
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("id");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("id: Posible nombre de color. T5");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);

        return new Symbol(simbolos.id, yychar, yyline, yytext());

    } 



    ";"
    {        
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("puntoComa");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("; : Punto coma T5");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                    
        return new Symbol(simbolos.puntoComa, yychar, yyline, yytext());

    } 
                

    ">"	
    {    
        yybegin(T6);                           
        System.out.println("Saltar a T6");
        Interfaz.auxContador++;                                
        //Generamos la entrada en la tabla de simbolos.
        tablaSimbolos simbolo=new tablaSimbolos();
        simbolo.setTipo("mayorQue");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("> : Mayor que T5");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);	                
        return new Symbol(simbolos.mayorQue, yychar, yyline, yytext()); 
    } 

    {espacio}
    {

    }
}

<T6>
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
            
            yybegin(T7);
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
            return new Symbol(simbolos.cadena, yychar, yyline, cadena); 

        }                       
    }     
}


<T7>
{


    "<"	
    {    
         
        Interfaz.auxContador++;                                
        //Generamos la entrada en la tabla de simbolos.
        tablaSimbolos simbolo=new tablaSimbolos();
        simbolo.setTipo("menorQue");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("< : MenorQue T7");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);	                
        return new Symbol(simbolos.menorQue, yychar, yyline, yytext()); 
    }


    "fin-cb"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("finCelda");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("finCelda : Fin Celda");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
        yybegin(T4);       
        System.out.println("SALTAR A T4");                           
        return new Symbol(simbolos.finCeldaCabecera, yychar, yyline, yytext());

    } 

    "fin-ct"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("finCeldaCabecera");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("finCeldaCabecera : Fin cabecera");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);    
        yybegin(T4);  
        System.out.println("SALTAR A T4");                               
        return new Symbol(simbolos.finCelda, yychar, yyline, yytext());

    }            



    "imagen"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("imagen");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("imagen : Inicio imagen");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);    
        yybegin(TI);                        
        return new Symbol(simbolos.inicioImagen, yychar, yyline, yytext());

    }   


    "boton"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("boton");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("boton : Inicio boton");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);    
        yybegin(TB);                        
        return new Symbol(simbolos.inicioBoton, yychar, yyline, yytext());

    }              
    {espacio}
    {}    
}

/*ffffffffffffffffffffffffffffffffffffffff*/
<TB>
{
    "click"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("click");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("click : Evento Click");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);                            
        return new Symbol(simbolos.click, yychar, yyline, yytext());

    }  

    "="
    {        
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("asignacion");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("= : Asignacion");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                
        Interfaz.tablaSimbolos_.add(simbolo);
                             
        return new Symbol(simbolos.asignacion, yychar, yyline, yytext());

    }   

    {metodo}
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("metodo");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("metodo : Llamada a metodo");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.metodo, yychar, yyline, yytext());

    } 

    {direccionWindows}
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("path");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("path : Direccion a imagen");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.pathComillas, yychar, yyline, yytext());

    }     

    ";"
    {        
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("puntoComa");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("; : Punto coma");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                    
        return new Symbol(simbolos.puntoComa, yychar, yyline, yytext());

    }    

    ">"	
    {    
        yybegin(TB2);                           
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
               
        return new Symbol(simbolos.ruta, yychar, yyline, yytext());

    } 



    "id"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("id Ccss");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("id : Identificador grupo ccss");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.idCcss, yychar, yyline, yytext());

    }

    "grupo"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("grupo");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("grupo : grupo ccss");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.grupo, yychar, yyline, yytext());

    } 

    "alto"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("alto");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("alto : Altura objeto");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.alto, yychar, yyline, yytext());

    }     


    "ancho"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("ancho");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("ancho : Anchura objeto");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.ancho, yychar, yyline, yytext());

    } 

    "alineado"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("alineado");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("alineado : Alineación objeto");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.alineado, yychar, yyline, yytext());

    }  
      


    {valorAlineado}
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("valorAlineado");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("valorAlineado : Alineación");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.valorAlineado, yychar, yyline, yytext());

    }         


    {idComillas}
    {        
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("id");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("id: Posible nombre de color.");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);

        return new Symbol(simbolos.id, yychar, yyline, yytext());

    } 

    
                

    {espacio}
    {

    }              


}

<TB2>
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
            
            yybegin(TB3);
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
            return new Symbol(simbolos.cadena, yychar, yyline, cadena); 

        }                       
    } 


}

<TB3>
{
    "<"	
    {    
         
        Interfaz.auxContador++;                                
        //Generamos la entrada en la tabla de simbolos.
        tablaSimbolos simbolo=new tablaSimbolos();
        simbolo.setTipo("menorQue");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("< : MenorQue inicio TB3");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);	                
        return new Symbol(simbolos.menorQue, yychar, yyline, yytext()); 
    }

    "fin-boton"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("fin-boton");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("fin-boton: Fin boton TB3");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);            
        return new Symbol(simbolos.finBoton, yychar, yyline, yytext());        
        
    }  


    ">"	
    {    
        yybegin(T6);                           
        System.out.println("Saltar a estado ENCABEZADO2");
        Interfaz.auxContador++;                                
        //Generamos la entrada en la tabla de simbolos.
        tablaSimbolos simbolo=new tablaSimbolos();
        simbolo.setTipo("mayorQue");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("> : Mayor que TB3");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);	                
        return new Symbol(simbolos.mayorQue, yychar, yyline, yytext()); 
    }  

    {espacio}
    {

    }         

}



<TI>
{

    "click"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("click");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("click : Evento Click");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);                            
        return new Symbol(simbolos.click, yychar, yyline, yytext());

    }  

    "="
    {        
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("asignacion");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("= : Asignacion");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                
        Interfaz.tablaSimbolos_.add(simbolo);
                             
        return new Symbol(simbolos.asignacion, yychar, yyline, yytext());

    }   

    {metodo}
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("metodo");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("metodo : Llamada a metodo");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.metodo, yychar, yyline, yytext());

    } 

    {direccionWindows}
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("path");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("path : Direccion a imagen");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.pathComillas, yychar, yyline, yytext());

    }     

    ";"
    {        
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("puntoComa");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("; : Punto coma");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                    
        return new Symbol(simbolos.puntoComa, yychar, yyline, yytext());

    }    

    ">"	
    {    
        yybegin(TI2);                           
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
               
        return new Symbol(simbolos.ruta, yychar, yyline, yytext());

    } 

    {espacio}
    {

    }              


}


<TI2>
{
    {espacio}
    {

    }    

    {path}
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("path");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("path : Direccion a imagen TI2");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);                          
        return new Symbol(simbolos.path, yychar, yyline, yytext());
        

    }     


    "<"	
    {    
         
        Interfaz.auxContador++;                                
        //Generamos la entrada en la tabla de simbolos.
        tablaSimbolos simbolo=new tablaSimbolos();
        simbolo.setTipo("menorQue");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("< : MenorQue inicio TI2");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);	                
        return new Symbol(simbolos.menorQue, yychar, yyline, yytext()); 
    }

    "fin-imagen"
    {        
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("fin-imagen");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("fin-imagen: Fin imagen TI2");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);                                    
        return new Symbol(simbolos.finImagen, yychar, yyline, yytext());        
        
    }  


    ">"	
    {    
         
        Interfaz.auxContador++;                                
        //Generamos la entrada en la tabla de simbolos.
        tablaSimbolos simbolo=new tablaSimbolos();
        simbolo.setTipo("mayorQue");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("> : mayorQue fin Imagen TI2");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);	
        yybegin(T6);                
        return new Symbol(simbolos.mayorQue, yychar, yyline, yytext()); 
    }        

}


<ENLACE1>
{
    {espacio}
    {

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
               
        return new Symbol(simbolos.ruta, yychar, yyline, yytext());

    }     
    "="
    {        
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("asignacion");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("= : Asignacion");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                
        Interfaz.tablaSimbolos_.add(simbolo);
                             
        return new Symbol(simbolos.asignacion, yychar, yyline, yytext());

    }    


    {direccionWindows}
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("path");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("path : Direccion a imagen");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.pathComillas, yychar, yyline, yytext());

    }      

    ";"
    {        
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("puntoComa");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("; : Punto coma");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                    
        return new Symbol(simbolos.puntoComa, yychar, yyline, yytext());

    }    




    "id"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("id Ccss");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("id : Identificador grupo ccss");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.idCcss, yychar, yyline, yytext());

    }

    "grupo"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("grupo");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("grupo : grupo ccss");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.grupo, yychar, yyline, yytext());

    } 

    "alto"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("alto");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("alto : Altura objeto");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.alto, yychar, yyline, yytext());

    }     


    "ancho"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("ancho");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("ancho : Anchura objeto");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.ancho, yychar, yyline, yytext());

    } 

    "alineado"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("alineado");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("alineado : Alineación objeto");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.alineado, yychar, yyline, yytext());

    }  
      


    {valorAlineado}
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("valorAlineado");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("valorAlineado : Alineación");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.valorAlineado, yychar, yyline, yytext());

    }         


    {idComillas}
    {        
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("id");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("id: Posible nombre de color.");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);

        return new Symbol(simbolos.id, yychar, yyline, yytext());

    } 



                

    ">"	
    {    
        yybegin(ENLACE2);                           
        System.out.println("Saltar a estado ENLACE2");
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

<ENLACE2>
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
            
            yybegin(YYINITIAL);
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
            return new Symbol(simbolos.cadena, yychar, yyline, cadena); 

        }                       
    } 



}



<BOTON1>
{
    "click"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("click");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("click : Evento Click");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);                            
        return new Symbol(simbolos.click, yychar, yyline, yytext());

    }  

    "="
    {        
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("asignacion");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("= : Asignacion");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                
        Interfaz.tablaSimbolos_.add(simbolo);
                             
        return new Symbol(simbolos.asignacion, yychar, yyline, yytext());

    }   

    {metodo}
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("metodo");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("metodo : Llamada a metodo");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.metodo, yychar, yyline, yytext());

    } 

    {direccionWindows}
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("path");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("path : Direccion a imagen");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.pathComillas, yychar, yyline, yytext());

    }     

    ";"
    {        
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("puntoComa");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("; : Punto coma");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                    
        return new Symbol(simbolos.puntoComa, yychar, yyline, yytext());

    }    

    ">"	
    {    
        yybegin(BOTON2);                           
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
               
        return new Symbol(simbolos.ruta, yychar, yyline, yytext());

    } 



    "id"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("id Ccss");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("id : Identificador grupo ccss");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.idCcss, yychar, yyline, yytext());

    }

    "grupo"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("grupo");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("grupo : grupo ccss");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.grupo, yychar, yyline, yytext());

    } 

    "alto"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("alto");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("alto : Altura objeto");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.alto, yychar, yyline, yytext());

    }     


    "ancho"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("ancho");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("ancho : Anchura objeto");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.ancho, yychar, yyline, yytext());

    } 

    "alineado"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("alineado");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("alineado : Alineación objeto");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.alineado, yychar, yyline, yytext());

    }  
      


    {valorAlineado}
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("valorAlineado");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("valorAlineado : Alineación");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.valorAlineado, yychar, yyline, yytext());

    }         


    {idComillas}
    {        
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("id");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("id: Posible nombre de color.");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);

        return new Symbol(simbolos.id, yychar, yyline, yytext());

    } 

    
                

    {espacio}
    {

    }              


}

<BOTON2>
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
            
            yybegin(YYINITIAL);
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
            return new Symbol(simbolos.cadena, yychar, yyline, cadena); 

        }                       
    } 


}



<IMAGEN1>
{

    "click"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("click");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("click : Evento Click");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);                            
        return new Symbol(simbolos.click, yychar, yyline, yytext());

    }  

    "="
    {        
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("asignacion");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("= : Asignacion");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                
        Interfaz.tablaSimbolos_.add(simbolo);
                             
        return new Symbol(simbolos.asignacion, yychar, yyline, yytext());

    }   

    {metodo}
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("metodo");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("metodo : Llamada a metodo");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.metodo, yychar, yyline, yytext());

    } 

    {direccionWindows}
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("path");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("path : Direccion a imagen");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.pathComillas, yychar, yyline, yytext());

    }     

    ";"
    {        
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("puntoComa");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("; : Punto coma");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                    
        return new Symbol(simbolos.puntoComa, yychar, yyline, yytext());

    }    

    ">"	
    {    
        yybegin(IMAGEN2);                           
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
               
        return new Symbol(simbolos.ruta, yychar, yyline, yytext());

    } 

    {espacio}
    {

    }              


}


<IMAGEN2>
{
    {espacio}
    {

    }    

    {path}
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("path");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("path : Direccion a imagen");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);                          
        return new Symbol(simbolos.path, yychar, yyline, yytext());
        

    }     


    "<"	
    {    
         
        Interfaz.auxContador++;                                
        //Generamos la entrada en la tabla de simbolos.
        tablaSimbolos simbolo=new tablaSimbolos();
        simbolo.setTipo("menorQue");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("< : MenorQue fin Imagen");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);	                
        return new Symbol(simbolos.menorQue, yychar, yyline, yytext()); 
    }

    "fin-imagen"
    {
        yybegin(YYINITIAL); 
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("fin-imagen");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("fin-imagen: Fin imagen");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);                                    
        return new Symbol(simbolos.finImagen, yychar, yyline, yytext());        
        
    }      

}


<TEXTO1>
{
    "id"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("id Ccss");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("id : Identificador grupo ccss");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);                            
        return new Symbol(simbolos.idCcss, yychar, yyline, yytext());

    }

    "grupo"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("grupo");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("grupo : grupo ccss");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.grupo, yychar, yyline, yytext());

    } 

    "alto"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("alto");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("alto : Altura objeto");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.alto, yychar, yyline, yytext());

    }     


    "ancho"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("ancho");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("ancho : Anchura objeto");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.ancho, yychar, yyline, yytext());

    } 

    "alineado"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("alineado");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("alineado : Alineación objeto");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.alineado, yychar, yyline, yytext());

    }  
      
    "="
    {        
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("asignacion");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("= : Asignacion");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                
        Interfaz.tablaSimbolos_.add(simbolo);
                             
        return new Symbol(simbolos.asignacion, yychar, yyline, yytext());

    } 

    {valorAlineado}
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("valorAlineado");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("valorAlineado : Alineación");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.valorAlineado, yychar, yyline, yytext());

    }         


    {idComillas}
    {        
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("id");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("id: Posible nombre de color.");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);

        return new Symbol(simbolos.id, yychar, yyline, yytext());

    } 



    ";"
    {        
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("puntoComa");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("; : Punto coma");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                    
        return new Symbol(simbolos.puntoComa, yychar, yyline, yytext());

    } 
                

    ">"	
    {    
        yybegin(TEXTO2);                           
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
    {

    }   


}


<TEXTO2>
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
            
            yybegin(YYINITIAL);
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
            return new Symbol(simbolos.cadena, yychar, yyline, cadena); 

        }                       
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
            return new Symbol(simbolos.cadena, yychar, yyline, cadena); 

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

<ELEMENTOS>
{


    "id"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("id Ccss");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("id : Identificador grupo ccss");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.idCcss, yychar, yyline, yytext());

    }

    "grupo"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("grupo");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("grupo : grupo ccss");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.grupo, yychar, yyline, yytext());

    } 

    "alto"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("alto");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("alto : Altura objeto");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.alto, yychar, yyline, yytext());

    }     


    "ancho"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("ancho");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("ancho : Anchura objeto");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.ancho, yychar, yyline, yytext());

    } 

    "alineado"
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("alineado");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("alineado : Alineación objeto");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.alineado, yychar, yyline, yytext());

    }  
      
    "="
    {        
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("asignacion");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("= : Asignacion");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                
        Interfaz.tablaSimbolos_.add(simbolo);
                             
        return new Symbol(simbolos.asignacion, yychar, yyline, yytext());

    } 

    {valorAlineado}
    {
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("valorAlineado");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("valorAlineado : Alineación");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                            
        return new Symbol(simbolos.valorAlineado, yychar, yyline, yytext());

    }         


    {idComillas}
    {        
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("id");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("id: Posible nombre de color.");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);

        return new Symbol(simbolos.id, yychar, yyline, yytext());

    } 



    ";"
    {        
        //Generamos la entrada en la tabla de simbolos
        tablaSimbolos simbolo = new tablaSimbolos();
        simbolo.setTipo("puntoComa");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("; : Punto coma");
        simbolo.setIndex(Interfaz.auxContador++);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);
                    
        return new Symbol(simbolos.puntoComa, yychar, yyline, yytext());

    } 
                

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

    {espacio}
    {

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
    { cadena = "";}

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
