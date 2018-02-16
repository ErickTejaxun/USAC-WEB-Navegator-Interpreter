package Source.CHTML;
import java_cup.runtime.Symbol;
import java.util.ArrayList;
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
%eofval}

espacio = \t|\f|" "|\r|\n
digito = [0-9][0-9]*
decimal= {digito}"."{digito}
simbolos1= "@"|":"|"!"|"¿"|"\""|"ñ"|","
simbolos2= "("|")"|"*"|"-"|"+"|"."|"!"
letra = [a-zA-Z]|"ñ"
linea = [^\r\n\"\\]
metodo = {id}"()"
rgb = "#"({digito}|{letra})+
id = {letra}({letra}|{digito}|"_")*
direccionWindows= ({letra}":"("\\"({linea})+)+) 
direccionLinux=(("/"{linea}+))+
archivocjs = {direccionWindows}"\\"\"{id}."cjs"\"
            |{direccionLinux}"/"\"{id}."cjs"\"
archivoccss = {direccionWindows}"\\"\"{id}."ccss"\"
             |{direccionLinux}"/"\"{id}."ccss"\" 

archivo = {direccionWindows}"\\"\"{id}."{id}"
            |{direccionLinux}"/"\"{id}."{id}"

pathComillas = "\""{archivo}"\""           

cadenaComillas = "\""{id}"\""  
rgbComillas =    "\""{rgb}"\""  

valorComillas =  {cadenaComillas} | "\""{digito}"\"" 

%state COMENTARIO
%%



[\n] { yychar=0;}




<YYINITIAL>
{

    /*----------  < ----------------*/
    "<"	
    {
        Interfaz.auxContador++;                                
        //Generamos la entrada en la tabla de simbolos.
        tablaSimbolos simbolo=new tablaSimbolos();
        simbolo.setTipo("<");
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
        simbolo.setTipo(">");
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
        simbolo.setTipo("<CHTML>");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("<CHTML> : Inicio Documento");
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
        simbolo.setTipo("FIN-CHTML");
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
        Interfaz.auxContador++;                                
        //Generamos la entrada en la tabla de simbolos.
        tablaSimbolos simbolo=new tablaSimbolos();
        simbolo.setTipo("encabezado");
        simbolo.setLinea(yyline);
        simbolo.setColumna(yychar);
        simbolo.setDescripcion("encabezado : Fin encabezado");
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(yytext());                 
        Interfaz.tablaSimbolos_.add(simbolo);	

        
        return new Symbol(simbolos.inicioEncabezado, yychar, yyline, yytext()); 
    } 

    {espacio}
    {System.out.println("Salto de linea");}	


}


/*Comentarios de chtml*/
<COMENTARIO>{espacio} {}
<COMENTARIO>[^"*/"] {System.out.println(yytext());}
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
