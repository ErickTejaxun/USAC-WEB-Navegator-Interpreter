package Analizadores.CHTML;
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
%cupsym simbolos
%class Scanner
%unicode
%public
%cup
%full
%line
%char
%ignorecase
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
id = {letra}({letra}|{digito}|"_")*
direccionWindows= ({letra}":"("\\"({linea})+)+) 
direccionLinux=(("/"{linea}+))+
archivocjs = direccionWindows"\\"\"id."cjs"\"
            |direccionLinux"/"\"id."cjs"\"


archivoccss = direccionWindows"\\"\"id."ccss"\"
            |direccionLinux"/"\"id."ccss"\"            

%state COMENTARIO,PHP
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


<YYINITIAL>"<CHTML>"	
            {
                posicion = Interfaz.auxContador++;                                
                //Generamos la entrada en la tabla de simbolos.
                tablaSimbolos simbolo=new tablaSimbolos();
                simbolo.setTipo("<CHTML>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<CHTML> : Inicio Documento");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);	

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<CHTML>");
                token.setIndex(posicion);
                
                return new Symbol(simbolos.inicio, yychar, yyline, yytext()); 
			}


<YYINITIAL>"<FIN-CHTML>"	
            {
                posicion = Interfaz.auxContador++;                                
                //Generamos la entrada en la tabla de simbolos.
                tablaSimbolos simbolo=new tablaSimbolos();
                simbolo.setTipo("<FIN-CHTML>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<FIN-CHTML> : Fin Documento");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);	

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<FIN-CHTML>");
                token.setIndex(posicion);
                
                return new Symbol(simbolos.inicio, yychar, yyline, yytext()); 
			}            


<YYINITIAL>"<FIN-CHTML>"	
            {
                posicion = Interfaz.auxContador++;                                
                //Generamos la entrada en la tabla de simbolos.
                tablaSimbolos simbolo=new tablaSimbolos();
                simbolo.setTipo("<FIN-CHTML>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<FIN-CHTML> : Fin Documento");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);	

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<FIN-CHTML>");
                token.setIndex(posicion);
                
                return new Symbol(simbolos.inicio, yychar, yyline, yytext()); 
			} 

<YYINITIAL>"<ENCABEZADO>"	
            {
                posicion = Interfaz.auxContador++;                                
                //Generamos la entrada en la tabla de simbolos.
                tablaSimbolos simbolo=new tablaSimbolos();
                simbolo.setTipo("<ENCABEZADO>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<ENCABEZADO> : Inicio encabezado");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);	

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<ENCABEZADO>");
                token.setIndex(posicion);
                
                return new Symbol(simbolos.inicio, yychar, yyline, yytext()); 
			}             



<YYINITIAL>"<FIN-ENCABEZADO>"	
            {
                posicion = Interfaz.auxContador++;                                
                //Generamos la entrada en la tabla de simbolos.
                tablaSimbolos simbolo=new tablaSimbolos();
                simbolo.setTipo("<FIN-ENCABEZADO>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<FIN-ENCABEZADO> : Fin Encabezado");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);	

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<FIN-ENCABEZADO>");
                token.setIndex(posicion);
                
                return new Symbol(simbolos.inicio, yychar, yyline, yytext()); 
			} 


<YYINITIAL>"<CUERPO>"	
            {
                posicion = Interfaz.auxContador++;                                
                //Generamos la entrada en la tabla de simbolos.
                tablaSimbolos simbolo=new tablaSimbolos();
                simbolo.setTipo("<CUERPO>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<CUERPO> : Inicio cuerpo");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);	

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<CUERPO>");
                token.setIndex(posicion);
                
                return new Symbol(simbolos.inicio, yychar, yyline, yytext()); 
			}             



<YYINITIAL>"<FIN-CUERPO>"	
            {
                posicion = Interfaz.auxContador++;                                
                //Generamos la entrada en la tabla de simbolos.
                tablaSimbolos simbolo=new tablaSimbolos();
                simbolo.setTipo("<FIN-CUERPO>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<FIN-CUERPO> : Fin cuerpo");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);	

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<FIN-CUERPO>");
                token.setIndex(posicion);
                
                return new Symbol(simbolos.inicio, yychar, yyline, yytext()); 
			} 

<YYINITIAL>"<TITULO>"	
            {
                posicion = Interfaz.auxContador++;                                
                //Generamos la entrada en la tabla de simbolos.
                tablaSimbolos simbolo=new tablaSimbolos();
                simbolo.setTipo("<TITULO>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<TITULO> : Inicio titulo");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);	

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<TITULO>");
                token.setIndex(posicion);
                
                return new Symbol(simbolos.inicio, yychar, yyline, yytext()); 
			}             



<YYINITIAL>"<FIN-TITULO>"	
            {
                posicion = Interfaz.auxContador++;                                
                //Generamos la entrada en la tabla de simbolos.
                tablaSimbolos simbolo=new tablaSimbolos();
                simbolo.setTipo("<FIN-TITULO>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<FIN-TITULO> : Fin titulo");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);	

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<FIN-TITULO>");
                token.setIndex(posicion);
                
                return new Symbol(simbolos.inicio, yychar, yyline, yytext()); 
			} 


<YYINITIAL>"<PANEL>"	
            {
                posicion = Interfaz.auxContador++;                                
                //Generamos la entrada en la tabla de simbolos.
                tablaSimbolos simbolo=new tablaSimbolos();
                simbolo.setTipo("<PANEL>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<PANEL> : Inicio panel");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);	

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<PANEL>");
                token.setIndex(posicion);
                
                return new Symbol(simbolos.inicio, yychar, yyline, yytext()); 
			}             



<YYINITIAL>"<FIN-PANEL>"	
            {
                posicion = Interfaz.auxContador++;                                
                //Generamos la entrada en la tabla de simbolos.
                tablaSimbolos simbolo=new tablaSimbolos();
                simbolo.setTipo("<FIN-PANEL>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<FIN-PANEL> : Fin panel");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);	

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<FIN-PANEL>");
                token.setIndex(posicion);
                
                return new Symbol(simbolos.inicio, yychar, yyline, yytext()); 
			} 


<YYINITIAL>"<TEXTO>"	
            {
                posicion = Interfaz.auxContador++;                                
                //Generamos la entrada en la tabla de simbolos.
                tablaSimbolos simbolo=new tablaSimbolos();
                simbolo.setTipo("<TEXTO>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<TEXTO> : Inicio texto");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);	

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<TEXTO>");
                token.setIndex(posicion);
                
                return new Symbol(simbolos.inicio, yychar, yyline, yytext()); 
			}             



<YYINITIAL>"<FIN-TEXTO>"	
            {
                posicion = Interfaz.auxContador++;                                
                //Generamos la entrada en la tabla de simbolos.
                tablaSimbolos simbolo=new tablaSimbolos();
                simbolo.setTipo("<FIN-TEXTO>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<FIN-TEXTO> : Fin texto");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);	

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<FIN-TEXTO>");
                token.setIndex(posicion);
                
                return new Symbol(simbolos.inicio, yychar, yyline, yytext()); 
			} 




<YYINITIAL>"<CAJA_TEXTO>"	
            {
                posicion = Interfaz.auxContador++;                                
                //Generamos la entrada en la tabla de simbolos.
                tablaSimbolos simbolo=new tablaSimbolos();
                simbolo.setTipo("<CAJA_TEXTO>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<CAJA_TEXTO> : Inicio caja de texto");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);	

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<CAJA_TEXTO>");
                token.setIndex(posicion);
                
                return new Symbol(simbolos.inicio, yychar, yyline, yytext()); 
			}             



<YYINITIAL>"<FIN-CAJA_TEXTO>"	
            {
                posicion = Interfaz.auxContador++;                                
                //Generamos la entrada en la tabla de simbolos.
                tablaSimbolos simbolo=new tablaSimbolos();
                simbolo.setTipo("<FIN-CAJA_TEXTO>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<FIN-CAJA_TEXTO> : Fin caja de texto");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);	

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<FIN-CAJA_TEXTO>");
                token.setIndex(posicion);
                
                return new Symbol(simbolos.inicio, yychar, yyline, yytext()); 
			} 



/*----------------Declaracion Imagen--------------------------*/
<YYINITIAL>"<IMAGEN"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<IMAGEN");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<IMAGEN : Inicio etiqueta imagen");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<IMAGEN");
                token.setIndex(posicion);

                yybegin(AUXIMAGEN);
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.auxcjs, yychar, yyline, yytext());

            }


/*----------------Declaracion CJS--------------------------*/
<YYINITIAL>"<CJS"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<CJS");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<CJS : Inicio etiqueta cjs");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<CJS");
                token.setIndex(posicion);

                yybegin(AUXCJS);
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.auxcjs, yychar, yyline, yytext());

            }

/*----------------Declaracion CCSS--------------------------*/
<YYINITIAL>"<CCSS"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<CCSS");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<CCSS : Inicio etiqueta CCSS");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<CCSS");
                token.setIndex(posicion);


                yybegin(AUXCCSS);
                
                //Nos movemos al estado auxiliar para declaracion cjs
                return new Symbol(simbolos.auxcjs, yychar, yyline, yytext());

            }            






/*----------------Declaracion CJS--------------------------*/
<AUXCJS>"ruta"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("ruta");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("ruta : Palabra reservada");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("ruta");
                token.setIndex(posicion);

                return new Symbol(simbolos.inicio, yychar, yyline, yytext());
            }  

<AUXCJS>"="
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("=");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("= : Asignacion");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("=");
                token.setIndex(posicion);

                return new Symbol(simbolos.inicio, yychar, yyline, yytext());
            } 

<AUXCJS>"archivocjs"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("ArchivoCJS");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("ArchivoCJS: Ruta archivo cjs");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("ArchivoCJS");
                token.setIndex(posicion);

                return new Symbol(simbolos.inicio, yychar, yyline, yytext());
            }

<AUXCJS>";"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo(";");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion(";: Cierre de declaracion etiqueta cjs");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId(";");
                token.setIndex(posicion);

                return new Symbol(simbolos.inicio, yychar, yyline, yytext());
            }  

<AUXCJS>">"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo(">");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion(">: Fin etiqueta inicio cjs");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId(">");
                token.setIndex(posicion);

                return new Symbol(simbolos.inicio, yychar, yyline, yytext());
            }

<AUXCJS>"<FIN-CJS>"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<FIN-CJS>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<FIN-CJS>: Fin etiqueta CJS");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<FIN-CJS>");
                token.setIndex(posicion);

                return new Symbol(simbolos.inicio, yychar, yyline, yytext());
                yybegin(YYINITIAL);
            }                                                                       






/*----------------Declaracion CCSS--------------------------*/
<AUXCCSS>"ruta"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("ruta");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("ruta : Palabra reservada");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("ruta");
                token.setIndex(posicion);

                return new Symbol(simbolos.inicio, yychar, yyline, yytext());
            }  

<AUXCCSS>"="
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("=");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("= : Asignacion");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("=");
                token.setIndex(posicion);

                return new Symbol(simbolos.inicio, yychar, yyline, yytext());
            } 

<AUXCCSS>"archivoccsss"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("ArchivoCCSS");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("ArchivoCCSS: Ruta archivo ccss");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("ArchivoCCSS");
                token.setIndex(posicion);
                return new Symbol(simbolos.inicio, yychar, yyline, yytext());
            }

<AUXCCSS>";"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo(";");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion(";: Cierre de declaracion etiqueta ccss");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId(";");
                token.setIndex(posicion);

                return new Symbol(simbolos.inicio, yychar, yyline, yytext());
            }  

<AUXCCSS>">"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo(">");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion(">: Fin etiqueta inicio ccss");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId(">");
                token.setIndex(posicion);

                return new Symbol(simbolos.inicio, yychar, yyline, yytext());
            }

<AUXCCSS>"<FIN-CCSS>"
            {
                posicion = Interfaz.auxContador++;
                //Generamos la entrada en la tabla de simbolos
                tablaSimbolos simbolo = new tablaSimbolos();
                simbolo.setTIpo("<FIN-CCSS>");
                simbolo.setLinea(yyline);
                simbolo.setColumna(yychar);
                simbolo.setDescripcion("<FIN-CCSS>: Fin etiqueta CCSS");
                simbolo.setIndex(posicion);
                Interfaz.tabla_simbolos.add(simbolo);

                //Guardamos el token en la lista de tokens
                token nuevo = new token();
                token.setId("<FIN-CCSS>");
                token.setIndex(posicion);

                return new Symbol(simbolos.inicio, yychar, yyline, yytext());
                yybegin(YYINITIAL);
            }   








<YYINITIAL>"<compi>"	{tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("<compi> : Inicio Documento  ");
			Interfaz.tabla_simbolos.add(simbolo);	
			return new Symbol(simbolos.inicio, yychar, yyline, yytext()); 
			}
<YYINITIAL>"</compi>"	{tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("</compi> : Fin Documento");
			Interfaz.tabla_simbolos.add(simbolo);	
			return new Symbol(simbolos.fin, yychar, yyline, yytext()); 
			}
<YYINITIAL>"<h>"	{tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("<h> : Inicio Cabecera");
			Interfaz.tabla_simbolos.add(simbolo);	
			return new Symbol(simbolos.abrircabecera, yychar, yyline, yytext()); 
			}
<YYINITIAL>"</h>"	{tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("</h> : Fin Cabecera");
			Interfaz.tabla_simbolos.add(simbolo);	
			return new Symbol(simbolos.cerrarcabecera, yychar, yyline, yytext()); 
			}
<YYINITIAL>"<t>"	{tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("<t> : Inicio Titulo de la pagina");
			Interfaz.tabla_simbolos.add(simbolo);	
			return new Symbol(simbolos.abrirtitulo, yychar, yyline, yytext()); 
			}
<YYINITIAL>"</t>"	{tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("</t> : Fin Titulo de la pagina");
			Interfaz.tabla_simbolos.add(simbolo);	
			return new Symbol(simbolos.cerrartitulo, yychar, yyline, yytext()); 
			}
<YYINITIAL>"<cuerpo>"	{tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("<cuerpo> : Inicio Cuerpo pagina");
			Interfaz.tabla_simbolos.add(simbolo);	
			return new Symbol(simbolos.abrircuerpo, yychar, yyline, yytext()); 
			}
<YYINITIAL>"</cuerpo>"	{tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("</t> : Fin Cuerpo pagina");
			Interfaz.tabla_simbolos.add(simbolo);	
			return new Symbol(simbolos.cerrarcuerpo, yychar, yyline, yytext()); 
			}
<YYINITIAL>"<esp>"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("<esp> : inicio espacio dentro de pagina");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.abrirespacio,yychar,yyline,yytext());
			}
<YYINITIAL>"</esp>"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("</esp> : Fin espacio dentro de pagina");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.cerrarespacio,yychar,yyline,yytext());
			}
<YYINITIAL>"<p>"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("<p> : Inicio parrafo");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.abrirparrafo,yychar,yyline,yytext());
			}
<YYINITIAL>"</p>"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("</p> : Fin parrafo");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.cerrarparrafo,yychar,yyline,yytext());
			}
<YYINITIAL>"<salto/>"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("<salto/> : Salto de linea");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.saltolinea,yychar,yyline,yytext());
			}
<YYINITIAL>"<tabla>"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("<tabla> : Incio Tabla");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.abrirtabla,yychar,yyline,yytext());
			}
<YYINITIAL>"</tabla>"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("</tabla> : Fin Tabla");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.cerrartabla,yychar,yyline,yytext());
			}
<YYINITIAL>"<ft>"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("<ft> : Inicio Fila");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.abrirfila,yychar,yyline,yytext());
			}
<YYINITIAL>"</ft>"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("</ft> : Fin Fila");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.cerrarfila,yychar,yyline,yytext());
			}
<YYINITIAL>"<ct>"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("<ct> : Inicio Columna Cabecera");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.abrircolumnacabecera,yychar,yyline,yytext());
			}
<YYINITIAL>"</ct>"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("</ct> : Fin Columna Cabecera");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.cerrarcolumnacabecera,yychar,yyline,yytext());
			}
<YYINITIAL>"<tt>"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("<tt> : Inicio Columna");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.abrircolumna,yychar,yyline,yytext());
			}
<YYINITIAL>"</tt>"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("</tt> : Fin Columna");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.cerrarcolumna,yychar,yyline,yytext());
			}
<YYINITIAL>{id}        {tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("ID");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(yytext());
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.id, yychar, yyline, yytext());
			}
<YYINITIAL>{simbolos1}        {tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Simbolo");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(yytext());
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.id, yychar, yyline, yytext());
			}
<YYINITIAL>{simbolos2}        {tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Simbolo");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(yytext());
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.id, yychar, yyline, yytext());
			}			
<YYINITIAL>{direccionWindows}  {
			tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Path windos");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(yytext());
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.urlw, yychar, yyline, yytext());
			}
<YYINITIAL>{direccionLinux}    {
			tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Path linux");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(yytext());
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.urll, yychar, yyline, yytext());
			}
<YYINITIAL>{digito}	{
			tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Numero");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(yytext());
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.numero, yychar, yyline, new Integer(yytext()));
			/*return new Symbol(simbolos.numero, new Integer(yytext()));*/
			}
<YYINITIAL>{decimal}	{
			tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Numero");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(yytext());
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.numero, yychar, yyline, new Integer(yytext());
			/*return new Symbol(simbolos.numero, new Integer(yytext());*/
			}

<YYINITIAL>{espacio}			{System.out.println("Salto de linea");}	
			
<YYINITIAL>"<//-" 		{
					yybegin(COMENTARIOHTML);
					System.out.println("Inicio Comentario comentario dentro de chtml");

			}
			
<YYINITIAL>"<?php"    {
					yybegin(PHP);
					System.out.println("Comienza lenguaje php");
					tablaSimbolos simbolo=new tablaSimbolos();
					simbolo.setTipo("Palabra Reservada");
					simbolo.setLinea(yyline);
					simbolo.setColumna(yychar);
					simbolo.setDescripcion(yytext());
					Interfaz.tabla_simbolos.add(simbolo);
					return new Symbol(simbolos.iniciophp, yychar, yyline, yytext());
			}

		
<PHP>"$"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Simbolo PHP");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("'$' : Definicion de Variable");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.definicionvariable,yychar,yyline,yytext());
			}
<PHP>"("	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Simbolo PHP");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("'(' : abrir parentesis");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.abrirparentesis,yychar,yyline,yytext());
			}
<PHP>")"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Simbolo PHP");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("')' : cerrar parentesis");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.cerrarparentesis,yychar,yyline,yytext());
			}
<PHP>{espacio}			{System.out.println("Espacio,salto de linea etc.");}
<PHP> "echo"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("'echo' funcion Imprimir");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.echo,yychar,yyline,yytext());
			}

<PHP>"="	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Simbolo PHP");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("'=' : Asignacion");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.asignacion,yychar,yyline,yytext());
			}
<PHP>{digito}	{
			tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Numero");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(yytext());
			Interfaz.tabla_simbolos.add(simbolo);
			/*return new Symbol(simbolos.numero, yychar, yyline, new Integer(yytext()).doubleValue());*/
			return new Symbol(simbolos.numero, new Integer(yytext());
			}
<PHP>{decimal}	{
			tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Numero");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(yytext());
			Interfaz.tabla_simbolos.add(simbolo);
			
			/*return new Symbol(simbolos.numero, yychar, yyline, new Integer(yytext()).doubleValue());*/
			
			 ArrayList<String> valores=new ArrayList();
			StringTokenizer tokens=new StringTokenizer(yytext(),"\n ,()+-*/;:\".#$%&!?¡[]{}^~|",true);
			while(tokens.hasMoreTokens()){
				valores.add(tokens.nextToken());
			}
			return new Symbol(simbolos.numero, new Integer(valores.get(0));
			
			}
<PHP>"."	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Simbolo PHP");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("'.' : punto/concatenacion");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.punto,yychar,yyline,yytext());
			}
<PHP>";"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Simbolo PHP");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("';' : Punto y coma");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.puntocoma,yychar,yyline,yytext());
			}
<PHP>"'"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Simbolo PHP");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("' : Comilla");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.comilla,yychar,yyline,yytext());
			}
<PHP>"true"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada PHP");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("true : Factor Booleano");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.verdadero,yychar,yyline,yytext());
			}
<PHP>"false"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada PHP");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("false : Factor Booleano");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.falso,yychar,yyline,yytext());
			}
<PHP>"*"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Simbolo Aritmetico");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("*");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.multiplicacion,yychar,yyline,yytext());
			}
<PHP>"-"    {tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Simbolo Aritmetico");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("-");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.resta,yychar,yyline,yytext());
			}
<PHP> "+"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Simbolo Aritmetico");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("+");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.suma,yychar,yyline,yytext());
			}
<PHP> "/"	{ tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Simbolo Aritmetico");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("/");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.division,yychar,yyline,yytext());
			}
<PHP> "{"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Simbolo");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("{");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.abrircorchetes,yychar,yyline,yytext());
			}
<PHP> "}"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Simbolo");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("}");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.cerrarcorchetes,yychar,yyline,yytext());
			}
<PHP>"<"			{ 
			tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Operador booleano");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("< : menor que");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.menorque,yychar,yyline,yytext());
			}
<PHP>	">"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Operador booleano");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("> : mayor que");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.mayorque,yychar,yyline,yytext());
			}
<PHP> "<="	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Operador booleano");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(">= : menor o igual que");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.menorigual,yychar,yyline,yytext());
			}
<PHP> ">="		{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Operador booleano");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(">= : mayor o igual que");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.mayorigual,yychar,yyline,yytext());
			}
<PHP> "!="	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Operador booleano");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("!= : distinto que");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.distinto,yychar,yyline,yytext());
			}
<PHP> "!"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Operador booleano");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("! : negacion");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.negacion,yychar,yyline,yytext());
			}
<PHP> "&&"  {tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Operador Logico");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(" '&&' : 'y'");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.y,yychar,yyline,yytext());
			}			
<PHP>  "||"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Operador Logico");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(" '||' : 'o'");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.or,yychar,yyline,yytext());
			}
<PHP> "if"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(" 'if' : Operador booleano");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.si,yychar,yyline,yytext());
			}
<PHP> "else"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(" 'else' : Operador booleano");
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.sino,yychar,yyline,yytext());
			}
<PHP>{id}   {tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("ID");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(yytext());
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.idVariable, yychar, yyline, yytext());
			}
<PHP>{simbolos1}   {tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("simbolo");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(yytext());
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.idVariable, yychar, yyline, yytext());
			}
<PHP> "?>"  {yybegin(YYINITIAL);
			System.out.println("Termina lenguaje php");
			tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(yytext());
			Interfaz.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.finphp, yychar, yyline, yytext());
			
			}
			



/*Comentarios de chtml*/
<COMENTARIOHTML>{espacio}{}            
<COMENTARIO>[^"*/"] {//System.out.println(yytext());}
<COMENTARIO> "-//>"	 {
                        System.out.println("Fin comentarios chtml");
						yybegin(YYINITIAL);	}





<COMENTARIO>{espacio} {}
<COMENTARIO>[^"*/"] {System.out.println(yytext());}
<COMENTARIO> "!>"	 {
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

