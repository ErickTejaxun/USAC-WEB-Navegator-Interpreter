package Analizadores.CCSS;

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

%% //inicio de opciones
   

%class AnalizadorLexico


%line
%column    
%unicode
%char
%cup
%ignorecase
%state COMENTARIO
%state MULTILINEA
%state CADENA

%{  

    String text = "";


    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }	 

%}   


%init{

%init}



grupo = "grupo"
cor1 = "["
cor2 = "]"
asig = ":="
puntocoma = ";"    
sumar = "+"    
resta = "-"    
multi = "*"    
divi = "/"    
alineado="alineado"
tamelemento="tamelemento"
centrado= "centrado"
izquierda="izquierda"
derecha="derecha"
justificado = "justificado"
texto = "texto"
formato = "formato"
mayuscula = "mayuscula"
minuscula = "minuscula"
negrilla = "negrilla"
cursiva = "cursiva"
capitalt = "capital-t"
letrax = "letra"
tamtex = "tamtex"
fondoelemento = "fondoelemento"
autoredimension = "autoredimension"
horizontal = "horizontal"
vertical = "vertical"
coma =","
verdadero= "true"
falso = "false"
visible = "visible"
borde = "borde"
opaco = "opaque"
colortext = "colortext"
ide = "id"
par1 = "("
par2 = ")"
comilla = "\""




comment_multi = "/*"
comment_multi2 = "*/"
comment_una = "//"
numero = [0-9]
letra = [a-zA-Z]
Salto = \r|\n|\r\n|\f
Espacio     = {Salto} | [ \t\f]|" "
entero  =             {numero} | {numero} {numero}+
decimal =     [0-9]+ "." [0-9]+
id =                    [a-zA-Z][a-zA-Z0-9_-]*



%% //fin de opciones


<YYINITIAL>
{
    {cor1}               { return new Symbol(sym.COR1,yyline,yycolumn,yytext()); }
    {cor2}               { return new Symbol(sym.COR2,yyline,yycolumn,yytext()); }
    {asig}               { return new Symbol(sym.IGUAL,yyline,yycolumn,yytext()); }
    {puntocoma}          { return new Symbol(sym.PUNTOCOMA,yyline,yycolumn,yytext()); }
    sumar}              { return new Symbol(sym.SUMA,yyline,yycolumn,yytext()); }
    {resta}              { return new Symbol(sym.RESTA,yyline,yycolumn,yytext()); }
    {multi}              { return new Symbol(sym.MULTI,yyline,yycolumn,yytext()); }
    {divi}               { return new Symbol(sym.DIVI,yyline,yycolumn,yytext()); }
    {alineado}           { return new Symbol(sym.ALINEADO,yyline,yycolumn,yytext()); }
    {centrado}           { return new Symbol(sym.CENTRADO,yyline,yycolumn,yytext()); }
    {izquierda}          { return new Symbol(sym.IZQUIERDA,yyline,yycolumn,yytext()); }
    {derecha}            { return new Symbol(sym.DERECHA,yyline,yycolumn,yytext()); }
    {justificado}        { return new Symbol(sym.JUSTIFICADO,yyline,yycolumn,yytext()); }
    {texto}              { return new Symbol(sym.TEXTO,yyline,yycolumn,yytext()); }
    {formato}            { return new Symbol(sym.FORMATO,yyline,yycolumn,yytext()); }
    {mayuscula}          { return new Symbol(sym.MAYUSCULA,yyline,yycolumn,yytext()); }
    {minuscula}          { return new Symbol(sym.MINUSCULA,yyline,yycolumn,yytext()); }
    {negrilla}           { return new Symbol(sym.NEGRILLA,yyline,yycolumn,yytext()); }
    {cursiva}            { return new Symbol(sym.CURSIVA,yyline,yycolumn,yytext()); }
    {capitalt}           { return new Symbol(sym.CAPITALT,yyline,yycolumn,yytext()); }
    {letrax}              { return new Symbol(sym.LETRA,yyline,yycolumn,yytext()); }
    {tamtex}             { return new Symbol(sym.TAMTEX,yyline,yycolumn,yytext()); }
    {fondoelemento}      { return new Symbol(sym.FONDOELEMENTO,yyline,yycolumn,yytext()); }
    {autoredimension}    { return new Symbol(sym.AUTOREDIMENSION,yyline,yycolumn,yytext()); }
    {horizontal}         { return new Symbol(sym.HORIZONTAL,yyline,yycolumn,yytext()); }
    {vertical}           { return new Symbol(sym.VERTICAL,yyline,yycolumn,yytext()); }
    {coma}               { return new Symbol(sym.COMA,yyline,yycolumn,yytext()); }
    {verdadero}          { return new Symbol(sym.VERDADERO,yyline,yycolumn,yytext()); }
    {falso}              { return new Symbol(sym.FALSO,yyline,yycolumn,yytext()); }
    {visible}            { return new Symbol(sym.VISIBLE,yyline,yycolumn,yytext()); }
    {borde}              { return new Symbol(sym.BORDE,yyline,yycolumn,yytext()); }
    {opaco}              { return new Symbol(sym.OPACO,yyline,yycolumn,yytext()); }
    {colortext}          { return new Symbol(sym.COLORTEXT,yyline,yycolumn,yytext()); }
    {tamelemento}        { return new Symbol(sym.TAMELEMENTO,yyline,yycolumn,yytext()); }
    {grupo}              { return new Symbol(sym.GRUPO,yyline,yycolumn,yytext()); }
    {ide}                { return new Symbol(sym.ID,yyline,yycolumn,yytext()); }
    {par1}               { return new Symbol(sym.PAR1,yyline,yycolumn,yytext()); }
    {par2}               { return new Symbol(sym.PAR2,yyline,yycolumn,yytext()); }
    {id}                 { return new Symbol(sym.IDENTIFIER,yyline,yycolumn,yytext()); }
    {entero}             { return new Symbol(sym.ENTERO,yyline,yycolumn,yytext()); }
    {decimal}            { return new Symbol(sym.DECIMAL,yyline,yycolumn,yytext()); }
    {Espacio}            {     }
    {comilla}            { yybegin(CADENA);  text = ""; }
    {comment_una}        { yybegin(MULTILINEA); text = "";  }
    {comment_multi}      {  yybegin(COMENTARIO);  text = "";   }

}
<CADENA>{comilla}               {   yybegin(YYINITIAL);  
                                    //System.out.println(text);
                                    return new Symbol(sym.CADENA,yyline,yycolumn,text);  
                                }
<CADENA>[^]                      {  text = text + yytext(); }

<MULTILINEA>
{           {Salto}            { yybegin(YYINITIAL); System.out.println("comentario: "+text);  }
            [^]                 {  text = text + yytext(); }
}

<COMENTARIO>{
    {comment_multi2}    {  yybegin(YYINITIAL); System.out.println("comentario: "+text);  }
    [^]                 {  text = text + yytext(); }
}

[^]                  {System.out.println("caracter no reconocido "+yytext()+" "+yystate());}


 
