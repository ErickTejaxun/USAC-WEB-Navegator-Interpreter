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

%state COMENTARIO,PHP
%%

[\n] { yychar=0;}

<YYINITIAL>"<compi>"	{tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("<compi> : Inicio Documento  ");
			Menu.tabla_simbolos.add(simbolo);	
			return new Symbol(simbolos.inicio, yychar, yyline, yytext()); 
			}
<YYINITIAL>"</compi>"	{tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("</compi> : Fin Documento");
			Menu.tabla_simbolos.add(simbolo);	
			return new Symbol(simbolos.fin, yychar, yyline, yytext()); 
			}
<YYINITIAL>"<h>"	{tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("<h> : Inicio Cabecera");
			Menu.tabla_simbolos.add(simbolo);	
			return new Symbol(simbolos.abrircabecera, yychar, yyline, yytext()); 
			}
<YYINITIAL>"</h>"	{tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("</h> : Fin Cabecera");
			Menu.tabla_simbolos.add(simbolo);	
			return new Symbol(simbolos.cerrarcabecera, yychar, yyline, yytext()); 
			}
<YYINITIAL>"<t>"	{tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("<t> : Inicio Titulo de la pagina");
			Menu.tabla_simbolos.add(simbolo);	
			return new Symbol(simbolos.abrirtitulo, yychar, yyline, yytext()); 
			}
<YYINITIAL>"</t>"	{tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("</t> : Fin Titulo de la pagina");
			Menu.tabla_simbolos.add(simbolo);	
			return new Symbol(simbolos.cerrartitulo, yychar, yyline, yytext()); 
			}
<YYINITIAL>"<cuerpo>"	{tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("<cuerpo> : Inicio Cuerpo pagina");
			Menu.tabla_simbolos.add(simbolo);	
			return new Symbol(simbolos.abrircuerpo, yychar, yyline, yytext()); 
			}
<YYINITIAL>"</cuerpo>"	{tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("</t> : Fin Cuerpo pagina");
			Menu.tabla_simbolos.add(simbolo);	
			return new Symbol(simbolos.cerrarcuerpo, yychar, yyline, yytext()); 
			}
<YYINITIAL>"<esp>"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("<esp> : inicio espacio dentro de pagina");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.abrirespacio,yychar,yyline,yytext());
			}
<YYINITIAL>"</esp>"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("</esp> : Fin espacio dentro de pagina");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.cerrarespacio,yychar,yyline,yytext());
			}
<YYINITIAL>"<p>"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("<p> : Inicio parrafo");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.abrirparrafo,yychar,yyline,yytext());
			}
<YYINITIAL>"</p>"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("</p> : Fin parrafo");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.cerrarparrafo,yychar,yyline,yytext());
			}
<YYINITIAL>"<salto/>"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("<salto/> : Salto de linea");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.saltolinea,yychar,yyline,yytext());
			}
<YYINITIAL>"<tabla>"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("<tabla> : Incio Tabla");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.abrirtabla,yychar,yyline,yytext());
			}
<YYINITIAL>"</tabla>"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("</tabla> : Fin Tabla");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.cerrartabla,yychar,yyline,yytext());
			}
<YYINITIAL>"<ft>"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("<ft> : Inicio Fila");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.abrirfila,yychar,yyline,yytext());
			}
<YYINITIAL>"</ft>"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("</ft> : Fin Fila");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.cerrarfila,yychar,yyline,yytext());
			}
<YYINITIAL>"<ct>"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("<ct> : Inicio Columna Cabecera");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.abrircolumnacabecera,yychar,yyline,yytext());
			}
<YYINITIAL>"</ct>"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("</ct> : Fin Columna Cabecera");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.cerrarcolumnacabecera,yychar,yyline,yytext());
			}
<YYINITIAL>"<tt>"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("<tt> : Inicio Columna");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.abrircolumna,yychar,yyline,yytext());
			}
<YYINITIAL>"</tt>"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada HTML");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("</tt> : Fin Columna");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.cerrarcolumna,yychar,yyline,yytext());
			}
<YYINITIAL>{id}        {tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("ID");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(yytext());
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.id, yychar, yyline, yytext());
			}
<YYINITIAL>{simbolos1}        {tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Simbolo");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(yytext());
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.id, yychar, yyline, yytext());
			}
<YYINITIAL>{simbolos2}        {tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Simbolo");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(yytext());
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.id, yychar, yyline, yytext());
			}			
<YYINITIAL>{direccionWindows}  {
			tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Path windos");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(yytext());
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.urlw, yychar, yyline, yytext());
			}
<YYINITIAL>{direccionLinux}    {
			tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Path linux");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(yytext());
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.urll, yychar, yyline, yytext());
			}
<YYINITIAL>{digito}	{
			tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Numero");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(yytext());
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.numero, yychar, yyline, new Integer(yytext()));
			/*return new Symbol(simbolos.numero, new Integer(yytext()));*/
			}
<YYINITIAL>{decimal}	{
			tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Numero");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(yytext());
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.numero, yychar, yyline, new Integer(yytext());
			/*return new Symbol(simbolos.numero, new Integer(yytext());*/
			}

<YYINITIAL>{espacio}			{System.out.println("Salto de linea");}	
			
<YYINITIAL>"<!" 		{
					yybegin(COMENTARIO);
					System.out.println("Inicio Comentario");

			}
			
<YYINITIAL>"<?php"    {
					yybegin(PHP);
					System.out.println("Comienza lenguaje php");
					tablaSimbolos simbolo=new tablaSimbolos();
					simbolo.setTipo("Palabra Reservada");
					simbolo.setLinea(yyline);
					simbolo.setColumna(yychar);
					simbolo.setDescripcion(yytext());
					Menu.tabla_simbolos.add(simbolo);
					return new Symbol(simbolos.iniciophp, yychar, yyline, yytext());
			}

		
<PHP>"$"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Simbolo PHP");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("'$' : Definicion de Variable");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.definicionvariable,yychar,yyline,yytext());
			}
<PHP>"("	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Simbolo PHP");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("'(' : abrir parentesis");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.abrirparentesis,yychar,yyline,yytext());
			}
<PHP>")"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Simbolo PHP");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("')' : cerrar parentesis");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.cerrarparentesis,yychar,yyline,yytext());
			}
<PHP>{espacio}			{System.out.println("Espacio,salto de linea etc.");}
<PHP> "echo"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("'echo' funcion Imprimir");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.echo,yychar,yyline,yytext());
			}

<PHP>"="	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Simbolo PHP");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("'=' : Asignacion");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.asignacion,yychar,yyline,yytext());
			}
<PHP>{digito}	{
			tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Numero");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(yytext());
			Menu.tabla_simbolos.add(simbolo);
			/*return new Symbol(simbolos.numero, yychar, yyline, new Integer(yytext()).doubleValue());*/
			return new Symbol(simbolos.numero, new Integer(yytext());
			}
<PHP>{decimal}	{
			tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Numero");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(yytext());
			Menu.tabla_simbolos.add(simbolo);
			
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
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.punto,yychar,yyline,yytext());
			}
<PHP>";"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Simbolo PHP");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("';' : Punto y coma");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.puntocoma,yychar,yyline,yytext());
			}
<PHP>"'"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Simbolo PHP");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("' : Comilla");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.comilla,yychar,yyline,yytext());
			}
<PHP>"true"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada PHP");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("true : Factor Booleano");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.verdadero,yychar,yyline,yytext());
			}
<PHP>"false"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada PHP");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("false : Factor Booleano");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.falso,yychar,yyline,yytext());
			}
<PHP>"*"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Simbolo Aritmetico");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("*");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.multiplicacion,yychar,yyline,yytext());
			}
<PHP>"-"    {tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Simbolo Aritmetico");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("-");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.resta,yychar,yyline,yytext());
			}
<PHP> "+"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Simbolo Aritmetico");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("+");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.suma,yychar,yyline,yytext());
			}
<PHP> "/"	{ tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Simbolo Aritmetico");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("/");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.division,yychar,yyline,yytext());
			}
<PHP> "{"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Simbolo");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("{");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.abrircorchetes,yychar,yyline,yytext());
			}
<PHP> "}"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Simbolo");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("}");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.cerrarcorchetes,yychar,yyline,yytext());
			}
<PHP>"<"			{ 
			tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Operador booleano");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("< : menor que");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.menorque,yychar,yyline,yytext());
			}
<PHP>	">"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Operador booleano");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("> : mayor que");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.mayorque,yychar,yyline,yytext());
			}
<PHP> "<="	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Operador booleano");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(">= : menor o igual que");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.menorigual,yychar,yyline,yytext());
			}
<PHP> ">="		{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Operador booleano");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(">= : mayor o igual que");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.mayorigual,yychar,yyline,yytext());
			}
<PHP> "!="	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Operador booleano");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("!= : distinto que");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.distinto,yychar,yyline,yytext());
			}
<PHP> "!"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Operador booleano");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion("! : negacion");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.negacion,yychar,yyline,yytext());
			}
<PHP> "&&"  {tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Operador Logico");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(" '&&' : 'y'");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.y,yychar,yyline,yytext());
			}			
<PHP>  "||"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Operador Logico");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(" '||' : 'o'");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.or,yychar,yyline,yytext());
			}
<PHP> "if"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(" 'if' : Operador booleano");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.si,yychar,yyline,yytext());
			}
<PHP> "else"	{tablaSimbolos simbolo = new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(" 'else' : Operador booleano");
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.sino,yychar,yyline,yytext());
			}
<PHP>{id}   {tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("ID");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(yytext());
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.idVariable, yychar, yyline, yytext());
			}
<PHP>{simbolos1}   {tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("simbolo");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(yytext());
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.idVariable, yychar, yyline, yytext());
			}
<PHP> "?>"  {yybegin(YYINITIAL);
			System.out.println("Termina lenguaje php");
			tablaSimbolos simbolo=new tablaSimbolos();
			simbolo.setTipo("Palabra Reservada");
			simbolo.setLinea(yyline);
			simbolo.setColumna(yychar);
			simbolo.setDescripcion(yytext());
			Menu.tabla_simbolos.add(simbolo);
			return new Symbol(simbolos.finphp, yychar, yyline, yytext());
			
			}
			
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

