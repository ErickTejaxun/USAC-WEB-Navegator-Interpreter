package Analizadores.CHTML;

import Principal.Errores;
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

    public static ArrayList<Errores> erroresLexicos = new ArrayList();    

%}
%cupsym simbolos
%class Scanner /*Nombre de la clase a generar.*/
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

%state COMENTARIO,AUXSPINNER1,AUXSPINNER2,AUXOP2,AUXOP1,AUXCAJA1,AUXCAJA_A1,AUXCAJA_A2,AUXTEXTO_A1,AUXTEXTO_A2,AUXENLACE1,AUXENLACE2,AUXBOTON1,AUXBOTON2,AUXIMAGEN1,AUXIMAGEN2,AUXELEMENTOS,AUXENCABEZADO
%%
/*
    El estado YYINITIAL será el de CHTML ya que es el lenguaje guía
    El estado CJS será el del lenguaje CJS.
    El estado CCSS será el del lenguaje CCSS.
    El estado COMETARIOHTML será el de comentarios de CHTML
    El estado COMETARIOCJS será el de comentarios de CJS
    El estado COMETARIOCCSS será el de comentarios de CCSS
*/

[\n] { yychar=0;}




<YYINITIAL>
{

             /*----------1. CHTML----------------*/
            "<CHTML>"	
            {
                posicion = Interfaz.auxContador++;                                
                //Generamos la entrada en la tabla de simbolos.
                tablaSimbolos simbolo=new tablaSimbolos();
                simbolo.setTipo("<CHTML>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<CHTML> : Inicio Documento");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);	

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<CHTML>");
                token.setIndex(posicion);
                
                return new Symbol(simbolos.inicioChtml, yychar, yyline, yytext()); 
			}

            "<FIN-CHTML>"	
            {
                posicion = Interfaz.auxContador++;                                
                //Generamos la entrada en la tabla de simbolos.
                tablaSimbolos simbolo=new tablaSimbolos();
                simbolo.setTipo("<FIN-CHTML>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<FIN-CHTML> : Fin Documento");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);	

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<FIN-CHTML>");
                token.setIndex(posicion);
                
                return new Symbol(simbolos.finChtml, yychar, yyline, yytext()); 
			}  

            /**--------------2. ENCABEZADO ---------------------*/
            "<ENCABEZADO>"	
            {
                yybegin(AUXENCABEZADO);
                posicion = Interfaz.auxContador++;                                
                //Generamos la entrada en la tabla de simbolos.
                tablaSimbolos simbolo=new tablaSimbolos();
                simbolo.setTipo("<ENCABEZADO>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<ENCABEZADO> : Inicio encabezado");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);	

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<ENCABEZADO>");
                token.setIndex(posicion);
                
                return new Symbol(simbolos.inicioEncabezado, yychar, yyline, yytext()); 
			}  



            /*-----------------------4. titulo---------------*/  
            "<titulo>"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<titulo>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<titulo> : Inicio titulo");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<titulo>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioTitulo, yychar, yyline, yytext());

            } 
          
            "<titulo"
            {
                yybegin(AUXELEMENTOS);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<titulo");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<titulo : Inicio titulo");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<titulo");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioTitulo, yychar, yyline, yytext());

            }  

            "<fin-titulo>"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<fin-titulo>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<fin-titulo> : Fin titulo");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<fin-titulo>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.finTitulo, yychar, yyline, yytext());
            }  



            /*-----------------------5. panel ---------------*/                
            "<panel>"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<panel>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<panel> : Inicio panel");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<titpanelulo>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioPanel, yychar, yyline, yytext());

            } 


      
            "<panel"
            {
                yybegin(AUXELEMENTOS);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<panel");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<panel : Inicio panel");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<panel");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioPanel, yychar, yyline, yytext());

            }

           
            "<fin-panel>"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<fin-panel>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<fin-panel> : Fin panel");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<fin-panel>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.finPanel, yychar, yyline, yytext());

            }  


            /*-----------------------6.Texto ---------------*/
            "<texto>"
            {
                yybegin(texto);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<texto>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<texto> : Inicio texto");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<texto>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioPanel, yychar, yyline, yytext());

            } 


            
            "<texto"
            {
                yybegin(AUXELEMENTOS);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<texto");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<texto : Inicio texto");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<texto");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioTexto, yychar, yyline, yytext());

            }

        
            "<fin-texto>"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<fin-texto>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<fin-texto> : Fin texto");
                simbolo.setIndex(posicion);
                
                simbolo.setValor(yytext());                 Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<fin-texto>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.finTexto, yychar, yyline, yytext());

            }  



            /*-----------------------7.Imagen ---------------*/
            "<imagen>"
            {
                yybegin(AUXIMAGEN2);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<imagen>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<imagen> : Inicio imagen");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<imagen>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioImagen, yychar, yyline, yytext());

            }

            "<imagen"
            {
                yybegin(AUXIMAGEN1);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<imagen");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<imagen : Inicio imagen");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<imagen");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioImagen, yychar, yyline, yytext());

            } 



            /*-----------------------8.Botton ---------------*/
            "<boton>"
            {
                yybegin(AUXBOTON2);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<boton>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<boton> : Inicio boton");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<boton>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioBoton, yychar, yyline, yytext());

            } 


            
            "<boton"
            {
                yybegin(AUXBOTON1);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<boton");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<boton : Inicio boton");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<boton");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioBoton, yychar, yyline, yytext());

            }

            /*-----------------9. Enlace*/                                                                                                                
            "<enlace"
            {
                yybegin(AUXENLACE1);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<enlace");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<enlace : Inicio enlace");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<enlace");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioEnlace, yychar, yyline, yytext());

            }



            /*-----------------------10.Fila ---------------*/
            "<fil_t>"
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<fil_t>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<fil_t> : Inicio Fila");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<fil_t>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioFila, yychar, yyline, yytext());

            } 


            
            "<fil_t"
            {
                yybegin(AUXELEMENTOS);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<texto");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<texto : Inicio texto");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<texto");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioFila, yychar, yyline, yytext());

            }

        
            "<fin-fil_t>"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<fin-fil_t>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<fin-fil_t> : Fin Fila");
                simbolo.setIndex(posicion);
                
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<fin-fil_t>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.finFila, yychar, yyline, yytext());

            }


            /*-----------------------11.Celda encabezado ---------------*/
            "<cb>"
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<cb>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<cb> : Inicio Celda Encabezado");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<cb>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioCeldaEncabezado, yychar, yyline, yytext());

            } 


            
            "<cb"
            {
                yybegin(AUXELEMENTOS);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<cb");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<cb : Inicio celda encabezado");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<cb");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioCeldaEncabezado, yychar, yyline, yytext());

            }

        
            "<fin-cb>"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<fin-cb>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<fin-cb> : Fin Celda encabezado");
                simbolo.setIndex(posicion);
                
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<fin-cb>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.finCeldaEncabezado, yychar, yyline, yytext());

            }                          


            /*-----------------------12.Celda Normal ---------------*/
            "<ct>"
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<ct>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<ct> : Inicio Celda ");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<ct>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioCelda, yychar, yyline, yytext());

            } 


            
            "<ct"
            {
                yybegin(AUXELEMENTOS);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<ct");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<ct : Inicio celda");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<ct");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioCelda, yychar, yyline, yytext());

            }

        
            "<fin-ct>"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<fin-ct>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<fin-ct> : Fin Celda");
                simbolo.setIndex(posicion);
                
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<fin-ct>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.finCeldaEncabezado, yychar, yyline, yytext());

            }  



            /*-----------------------13. Caja área de texto ---------------*/
            "<texto_a>"
            {        
                yybegin(AUXTEXTO_A2);        
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<texto_a>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<texto_a> : Inicio Caja area de texto ");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<texto_a>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioCajaAreaTexto, yychar, yyline, yytext());

            } 


            
            "<texto_a"
            {
                yybegin(AUXTEXTO_A1);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<texto_a");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<texto_a :Inicio Caja area de texto");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<texto_a");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioCajaAreaTexto, yychar, yyline, yytext());

            }



            /*-----------------------14. Caja de texto ---------------*/
            "<caja_texto>"
            {        
                yybegin(AUXCAJA_A2);        
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<caja_texto>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<caja_texto> : Inicio Caja de texto ");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<caja_texto>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioCajaTexto, yychar, yyline, yytext());

            } 


            
            "<caja_texto"
            {
                yybegin(AUXCAJA_A1);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<caja_texto");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<caja_texto :Inicio Caja de texto");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<caja_texto");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioCajaTexto, yychar, yyline, yytext());

            }


            /*-----------------------15. Caja de seleccion ---------------*/
            "<caja>"
            {        
                yybegin(AUXCAJA2);        
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<caja>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<caja> : Inicio Caja de seleccion ");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<caja>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioCajaSeleccion, yychar, yyline, yytext());

            } 


            
            "<caja"
            {
                yybegin(etiqueta);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<caja");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<caja :Inicio Caja de seleccion");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<caja");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioCajaSeleccion, yychar, yyline, yytext());

            }  

            "<fin-caja>"
            {                            
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<caja>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<caja> : Inicio Caja de seleccion ");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<caja>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioCajaSeleccion, yychar, yyline, yytext());

            }    


            /*-----------------------16.Opcion ---------------*/
            "<opcion>"
            {        
                yybegin(AUXOP2);        
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<opcion>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<opcion> : Inicio Opcion ");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<opcion>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioOpcion, yychar, yyline, yytext());

            } 


            
            "<opcion"
            {
                yybegin(AUXOP1);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<opcion");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<opcion :Inicio opcion");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<opcion");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioOpcion, yychar, yyline, yytext());

            }  


   
            /*-----------------------17. Spiner ---------------*/
            "<spinner>"
            {        
                yybegin(AUXSPINNER2);        
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<spinner>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<spinner> : Inicio spinner ");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<spinner>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioSpinner, yychar, yyline, yytext());

            } 


            
            "<spinner"
            {
                yybegin(AUXSPINNER1);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<spinner");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<spinner :Inicio spinner");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<spinner");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioSpinner, yychar, yyline, yytext());

            } 


            /*-----------------------18. Salto  ---------------*/
            "<salto-fin>"
            {        
                yybegin(AUXSPINNER2);        
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<salto-fin>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<salto-fin> : Salto linea ");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<salto-fin>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.salto, yychar, yyline, yytext());

            }

            "<//-" 		
            {
                yybegin(COMENTARIO);
                System.out.println("Inicio Comentario comentario dentro de chtml");

            }                                                      
}


<AUXSPINNER1>
{
            /*Copiar los demás elementos del estado "Elementos"*/                        
            "id"
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("id");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("id : id ccss");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("id");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.idccss, yychar, yyline, yytext());
            }
            "grupo"
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("grupo");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("grupo :grupo ccss");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("grupo");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.grupoccss, yychar, yyline, yytext());
            }
            "alto"
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("alto");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("alto :alto");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("alto");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.alto, yychar, yyline, yytext());
            }  
            "ancho"
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("ancho");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("ancho :ancho ");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("ancho");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.ancho, yychar, yyline, yytext());
            } 

            "alineado"
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("alineado");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("alineado :alineado ");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("alineado");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.alineado, yychar, yyline, yytext());
            }   

            "\"izquierda\""
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("izquierda");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("izquierda :alineado  izquierda");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("izquierda");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.izquierda, yychar, yyline, yytext());
            }                                                                     



            "\"derecha\""
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("derecha");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("derecha :alineado  derecha");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("derecha");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.derecha, yychar, yyline, yytext());
            }
            "\"centrado\""
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("centrado");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("centrado :alineado  centrado");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("centrado");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.centrado, yychar, yyline, yytext());
            }            


            /*Parametro de salida*/
            ">"
            {
                yybegin(AUXSPINNER2);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("cierreTag");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("> : cierre de etiqueta");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("cierreTag");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.cierreTag, yychar, yyline, yytext()); 


}

<AUXSPINNER2>
{
            [^"*/"]
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("cadena");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("cadena : Texto ");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("cadena");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.cadena, yychar, yyline, yytext());
            }

            "<fin-spinner>"
            {
                yybegin(YYINITIAL);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<fin-spinner>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<fin-spinner> : Fin  spinner");
                simbolo.setIndex(posicion);
                
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<fin-spinner>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.finSpinner, yychar, yyline, yytext());

            }              

}


<AUXOP2>
{

            [^"*/"]
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("cadena");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("cadena : Texto ");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("cadena");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.cadena, yychar, yyline, yytext());
            }

            "<fin-opcion>"
            {
                yybegin(YYINITIAL);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<fin-opcion>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<fin-opcion> : Fin  opcion");
                simbolo.setIndex(posicion);
                
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<fin-opcion>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.finOpcion, yychar, yyline, yytext());

            }     

}


<AUXOP1>
{

            "valor"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("ruta");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("valor : declaracion valor");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("valor");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.valor, yychar, yyline, yytext());

            } 


            "="
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("=");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("= : Asignacion");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("=");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.asignacion, yychar, yyline, yytext());

            } 

            {valorComillas}
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("valor");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("valor: valor de la opcion");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("valor");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.valor, yychar, yyline, yytext());

            } 
             

            ";"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("puntoComa");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("; : Punto coma");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("puntoComa");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.puntoComa, yychar, yyline, yytext());

            }      

           /*Parametro de salida*/
            ">"
            {
                yybegin(AUXOP2);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("cierreTag");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("> : cierre de etiqueta");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("cierreTag");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.cierreTag, yychar, yyline, yytext()); 

}


<AUXCAJA1>
{
            /*Copiar los demás elementos del estado "Elementos"*/            
            "id"
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("id");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("id : id ccss");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("id");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.idccss, yychar, yyline, yytext());
            }
            "grupo"
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("grupo");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("grupo :grupo ccss");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("grupo");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.grupoccss, yychar, yyline, yytext());
            }
            "alto"
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("alto");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("alto :alto");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("alto");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.alto, yychar, yyline, yytext());
            }  
            "ancho"
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("ancho");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("ancho :ancho ");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("ancho");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.ancho, yychar, yyline, yytext());
            } 

            "alineado"
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("alineado");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("alineado :alineado ");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("alineado");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.alineado, yychar, yyline, yytext());
            }   

            "\"izquierda\""
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("izquierda");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("izquierda :alineado  izquierda");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("izquierda");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.izquierda, yychar, yyline, yytext());
            }                                                                     



            "\"derecha\""
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("derecha");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("derecha :alineado  derecha");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("derecha");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.derecha, yychar, yyline, yytext());
            }
            "\"centrado\""
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("centrado");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("centrado :alineado  centrado");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("centrado");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.centrado, yychar, yyline, yytext());
            }

            /*Parametro de salida*/
            ">"
            {
                yybegin(YYINITIAL);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("cierreTag");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("> : cierre de etiqueta");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("cierreTag");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.cierreTag, yychar, yyline, yytext());      


}



/*Caja de texto sin saltos de linea*/
<AUXCAJA_A1>
{
            /*Copiar los demás elementos del estado "Elementos"*/
            "id"
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("id");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("id : id ccss");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("id");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.idccss, yychar, yyline, yytext());
            }
            "grupo"
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("grupo");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("grupo :grupo ccss");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("grupo");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.grupoccss, yychar, yyline, yytext());
            }
            "alto"
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("alto");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("alto :alto");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("alto");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.alto, yychar, yyline, yytext());
            }  
            "ancho"
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("ancho");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("ancho :ancho ");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("ancho");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.ancho, yychar, yyline, yytext());
            } 

            "alineado"
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("alineado");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("alineado :alineado ");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("alineado");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.alineado, yychar, yyline, yytext());
            }   

            "\"izquierda\""
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("izquierda");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("izquierda :alineado  izquierda");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("izquierda");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.izquierda, yychar, yyline, yytext());
            }                                                                     



            "\"derecha\""
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("derecha");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("derecha :alineado  derecha");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("derecha");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.derecha, yychar, yyline, yytext());
            }
            "\"centrado\""
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("centrado");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("centrado :alineado  centrado");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("centrado");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.centrado, yychar, yyline, yytext());
            }

            /*Parametro de salida*/
            ">"
            {
                yybegin(AUXCAJA_A2);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("cierreTag");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("> : cierre de etiqueta");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("cierreTag");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.cierreTag, yychar, yyline, yytext());    
}

<AUXCAJA_A2>
{
            [^"*/"]
            {
             
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("cadena");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("cadena : Texto ");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("cadena");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.cadena, yychar, yyline, yytext());
            }

            "<fin-caja_texto>"
            {
                yybegin(YYINITIAL);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<fin-caja_texto>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<fin-caja_texto> : Fin Caja texto");
                simbolo.setIndex(posicion);
                
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<fin-caja_texto>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.finCajaTexto, yychar, yyline, yytext());

            }         
}



<AUXTEXTO_A1>
{
            /*Copiar los demás elementos del estado "Elementos"*/
            "id"
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("id");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("id : id ccss");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("id");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.idccss, yychar, yyline, yytext());
            }
            "grupo"
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("grupo");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("grupo :grupo ccss");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("grupo");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.grupoccss, yychar, yyline, yytext());
            }
            "alto"
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("alto");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("alto :alto");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("alto");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.alto, yychar, yyline, yytext());
            }  
            "ancho"
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("ancho");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("ancho :ancho ");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("ancho");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.ancho, yychar, yyline, yytext());
            } 

            "alineado"
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("alineado");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("alineado :alineado ");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("alineado");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.alineado, yychar, yyline, yytext());
            }   

            "\"izquierda\""
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("izquierda");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("izquierda :alineado  izquierda");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("izquierda");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.izquierda, yychar, yyline, yytext());
            }                                                                     



            "\"derecha\""
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("derecha");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("derecha :alineado  derecha");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("derecha");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.derecha, yychar, yyline, yytext());
            }
            "\"centrado\""
            {                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("centrado");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("centrado :alineado  centrado");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("centrado");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.centrado, yychar, yyline, yytext());
            }

            /*Parametro de salida*/
            ">"
            {
                yybegin(AUXTEXTO_A2);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("cierreTag");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("> : cierre de etiqueta");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("cierreTag");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.cierreTag, yychar, yyline, yytext());    
}

<AUXTEXTO_A2>
{
            [^"*/"]
            {
                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("cadena");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("cadena : Texto ");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("cadena");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.cadena, yychar, yyline, yytext());
            }

            "<fin-Texto_a>"
            {
                yybegin(YYINITIAL);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<fin-Texto_a>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<fin-Texto_a> : Fin Caja area texto");
                simbolo.setIndex(posicion);
                
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<fin-Texto_a>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.finCajaAreaTexto, yychar, yyline, yytext());

            }         
}

<AUXENLACE1>
{
            "ruta"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("ruta");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("ruta : Declaración ruta archivo");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("ruta");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.ruta, yychar, yyline, yytext());

            } 


            "="
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("=");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("= : Asignacion");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("=");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.asignacion, yychar, yyline, yytext());

            } 

            {pathComillas}
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("path");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("Path: Ruta a archivo");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("path");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.path, yychar, yyline, yytext());

            } 
             

            ";"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("puntoComa");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("; : Punto coma");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("puntoComa");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.puntoComa, yychar, yyline, yytext());

            }             



            /*Parametro de salida*/
            ">"
            {
                yybegin(AUXENLACE2);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("cierreTag");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("> : cierre de etiqueta");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("cierreTag");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.cierreTag, yychar, yyline, yytext());
            } 


}




<AUXENLACE2>
{


            
            [^"*/"]
            {
                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("cadena");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("cadena : Texto ");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("cadena");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.cadena, yychar, yyline, yytext());
            } 

            /*Parametro de salida*/
            "<fin-enlace>"
            {
                yybegin(YYINITIAL);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<fin-enlace>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<fin-enlace> : Fin enlace");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<fin-enlace>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.finEnlace, yychar, yyline, yytext());
            }     

}


<AUXBOTON1>
{

            "click"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("click");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("click : Evento click");
                simbolo.setIndex(posicion);
                
                simbolo.setValor(yytext());                 Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("click");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.click, yychar, yyline, yytext());

            } 

            "ruta"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("ruta");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("ruta : Declaración ruta archivo");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("ruta");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.ruta, yychar, yyline, yytext());

            } 


            "="
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("=");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("= : Asignacion");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("=");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.asignacion, yychar, yyline, yytext());

            } 

            {pathComillas}
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("path");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("Path: Ruta a archivo");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("path");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.path, yychar, yyline, yytext());

            } 

            {metodo}
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("Metodo");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("Metodo: Llamada a metodo");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("Metodo");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.metodo, yychar, yyline, yytext());

            }              

            ";"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("puntoComa");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("; : Punto coma");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("puntoComa");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.puntoComa, yychar, yyline, yytext());

            }             



            /*Parametro de salida*/
            ">"
            {
                yybegin(AUXBOTON2);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("cierreTag");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("> : cierre de etiqueta");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("cierreTag");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.cierreTag, yychar, yyline, yytext());
            } 
}

<AUXBOTON2>
{
            /*Parametro de salida*/
            [^"*/"]
            {
                
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("cadena");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("cadena : Texto ");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("cadena");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.cadena, yychar, yyline, yytext());
            } 

            /*Parametro de salida*/
            "<fin-boton>"
            {
                yybegin(YYINITIAL);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<fin-boton>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<fin-boton> : Fin boton");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<fin-boton>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.finBoton, yychar, yyline, yytext());
            }     

}




<AUXIMAGEN1>
{

            "click"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("click");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("click : Evento click");
                simbolo.setIndex(posicion);
                
                simbolo.setValor(yytext());                 Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("click");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.click, yychar, yyline, yytext());

            } 

            "ruta"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("ruta");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("ruta : Declaración ruta archivo");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("ruta");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.ruta, yychar, yyline, yytext());

            } 


            "="
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("=");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("= : Asignacion");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("=");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.asignacion, yychar, yyline, yytext());

            } 

            {pathComillas}
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("path");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("Path: Ruta a archivo");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("path");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.path, yychar, yyline, yytext());

            } 

            {metodo}
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("Metodo");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("Metodo: Llamada a metodo");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("Metodo");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.metodo, yychar, yyline, yytext());

            }              

            ";"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("puntoComa");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("; : Punto coma");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("puntoComa");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.puntoComa, yychar, yyline, yytext());

            }             



            /*Parametro de salida*/
            ">"
            {
                yybegin(AUXIMAGEN2);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("cierreTag");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("> : cierre de etiqueta");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("cierreTag");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.cierreTag, yychar, yyline, yytext());
            } 
}

<AUXIMAGEN2>
{
            /*Parametro de salida*/
            {archivo}
            {
                yybegin(YYINITIAL);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("Path");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("Path : ruta hacia imagen");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("Path");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.pathImagen, yychar, yyline, yytext());
            } 

            /*Parametro de salida*/
            "<fin-imagen>"
            {
                yybegin(YYINITIAL);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<fin-imagen>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<fin-imagen> : Fin imagen");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<fin-imagen>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.finImagen, yychar, yyline, yytext());
            }     

}



<AUXELEMENTOS>
{


            /*Parametro de salida*/
            ">"
            {
                yybegin(YYINITIAL);
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("cierreTag");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("> : cierre de etiqueta");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("cierreTag");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.cierreTag, yychar, yyline, yytext());
            } 
}

<AUXENCABEZADO>
{
            "<CJS"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<CJS");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<CJS : Inicio etiqueta CJS");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<CJS");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioCjs, yychar, yyline, yytext());

            }   

            "ruta"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("ruta");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("ruta : Declaración ruta archivo");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("ruta");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.ruta, yychar, yyline, yytext());

            } 


            "="
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("=");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("= : Asignacion");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("=");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.asignacion, yychar, yyline, yytext());

            } 

            {pathComillas}
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("path");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("Path: Ruta a archivo");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("path");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.path, yychar, yyline, yytext());

            }  

            ";"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("puntoComa");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("; : Punto coma");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("puntoComa");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.puntoComa, yychar, yyline, yytext());

            } 

            ">"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("cierreTag");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("> : cierre de etiqueta");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("cierreTag");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.cierreTag, yychar, yyline, yytext());

            }  

            "<fin-cjs>"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<fin-cjs>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<fin-cjs> : finCJs");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<fin-cjs>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.finCjs, yychar, yyline, yytext());
            } 

            "<CCSS"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<CCSS");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<CCSS : Inicio etiqueta CCSS");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<CCSS");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.inicioCcss, yychar, yyline, yytext());

            } 
            "<fin-CCSS>"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<fin-CCSS>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<fin-CCSS> : fin etiqueta CCSS");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<fin-CCSS>");
                token.setIndex(posicion);                
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.finCcss, yychar, yyline, yytext());

            }  

            "<FIN-ENCABEZADO>"	
            {
                yybegin(YYINITIAL);
                posicion = Interfaz.auxContador++;                                
                //Generamos la entrada en la tabla de simbolos.
                tablaSimbolos simbolo=new tablaSimbolos();
                simbolo.setTipo("<FIN-ENCABEZADO>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<FIN-ENCABEZADO> : Fin Encabezado");
                simbolo.setIndex(posicion);
                simbolo.setValor(yytext());                 Interfaz.tabla_simbolos.add(simbolo);	

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<FIN-ENCABEZADO>");
                token.setIndex(posicion);
                
                return new Symbol(simbolos.finEncabezado, yychar, yyline, yytext()); 
			}                                                      
}
		
/*Comentarios de chtml*/
<COMENTARIO>{espacio} {}
<COMENTARIO>[^"*/"] {System.out.println(yytext());}
<COMENTARIO> "-//>"	 {
						yybegin(YYINITIAL);	}
.			{
			System.out.println("Caracter ilegal: " + yytext()+" Linea : "+yyline +" Columna: "+yychar); 
			Errores errorLexico=new Errores();
			errorLexico.setTipo("Lexico");
			errorLexico.setLinea(yyline);
			errorLexico.setColumna(yychar);
			errorLexico.setDescripcion("Caracter Ilegal: "+yytext());
			Menu.errores_lexicos.add(errorLexico);
			//Proyecto1_Compiladores.listaLexico.add(errorLexico);
			//Menu.listaLexico=Proyecto1_Compiladores.listaLexico;
			}			

