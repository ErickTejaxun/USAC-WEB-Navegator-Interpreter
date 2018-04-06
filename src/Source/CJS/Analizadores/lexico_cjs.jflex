
/*------------  1ra Area: Codigo de Usuario ---------*/
//------> Paquetes,importaciones
package Analizadores;
import java_cup.runtime.*;
import java.util.LinkedList;

/*------------  2da Area: Opciones y Declaraciones ---------*/
%%
%{
    //----> Codigo de usuario en sintaxis java
    public static LinkedList<Terror> TablaEL = new LinkedList<Terror>(); 
%}

//-------> Directivas
%public 
%class lexico_cjs
%cupsym Symcjs
%cup
%char
%column
%ignorecase
%line
%unicode
%full

//------> Expresiones Regulares

digito  =   [0-9]+
letra   =   [a-zA-Z]

id      =   {letra} ({letra} | {digito} | "_" )*
numero  =   {digito}("."{digito}+)?    

/* comments */
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace = {LineTerminator} | [ \t\f]

coment = {comentVariasLineas} | {comentUnaLinea} | {comentario}
comentUnaLinea = "'"{InputCharacter}* {LineTerminator} //comentarios que seran de una sola linea ('este es un ejemplo)
comentVariasLineas = "'/" [^*] ~"/'" | "'/" "/"+ "/'"
comentario = "'/" {contenidoComentario} "/"+ "/'"
contenidoComentario = ( [^*] | \'+ [^'/] )* /*coincide con cualquier coincidencia de cualquier caracter  excepto un * o cualquier numero de * seguido por un personaje que no es /
lineas*/



fecha = "'"([0-2][0-9]|3[0-1])(\/)(0[1-9]|1[0-2])\2(\{DIGITO}{4})"'"  
fechahora = "'"([0-2][0-9]|3[0-1])(\/|-)(0[1-9]|1[0-2])\2(\{DIGITO}{4})(\s)([0-1][0-9]|2[0-3])(:)([0-5][0-9])(:)([0-5][0-9]) "'" 
cadena  =   "\""[^\"]*"\""
//------> Estados

%%

/*------------  3raa Area: Reglas Lexicas ---------*/
<YYINITIAL>{
//-----> Simbolos
 ";"         { System.out.println("Reconocio "+yytext()+" puntoycoma"); return new Symbol(Symcjs.pcoma, yycolumn, yyline, yytext()); }
 ":"         { System.out.println("Reconocio "+yytext()+" dospuntos"); return new Symbol(Symcjs.dpuntos, yycolumn, yyline, yytext()); }
 ","         { System.out.println("Reconocio "+yytext()+" comma"); return new Symbol(Symcjs.comma, yycolumn, yyline, yytext()); }
 "."         { System.out.println("Reconocio "+yytext()+" punto"); return new Symbol(Symcjs.punto, yycolumn, yyline, yytext()); }
 "+"         { System.out.println("Reconocio "+yytext()+" mas"); return new Symbol(Symcjs.mas, yycolumn, yyline, yytext()); }
 "-"         { System.out.println("Reconocio "+yytext()+" menos"); return new Symbol(Symcjs.menos, yycolumn, yyline, yytext()); }
 "*"         { System.out.println("Reconocio "+yytext()+" por"); return new Symbol(Symcjs.por, yycolumn, yyline, yytext()); }
 "/"         { System.out.println("Reconocio "+yytext()+" div"); return new Symbol(Symcjs.div, yycolumn, yyline, yytext()); }
 "^"         { System.out.println("Reconocio "+yytext()+" potencia"); return new Symbol(Symcjs.potencia, yycolumn, yyline, yytext()); }
 "%"         { System.out.println("Reconocio "+yytext()+" modulo"); return new Symbol(Symcjs.modulo, yycolumn, yyline, yytext()); }
 "("         { System.out.println("Reconocio "+yytext()+" para"); return new Symbol(Symcjs.para, yycolumn, yyline, yytext()); }
 ")"         { System.out.println("Reconocio "+yytext()+" parc"); return new Symbol(Symcjs.parc, yycolumn, yyline, yytext()); }
 "{"         { System.out.println("Reconocio "+yytext()+" allaves"); return new Symbol(Symcjs.allav, yycolumn, yyline, yytext()); }
 "}"         { System.out.println("Reconocio "+yytext()+" cllaves"); return new Symbol(Symcjs.cllav, yycolumn, yyline, yytext()); }
 "++"        { System.out.println("Reconocio "+yytext()+" incremento"); return new Symbol(Symcjs.inc, yycolumn, yyline, yytext()); }
 "--"        { System.out.println("Reconocio "+yytext()+" decremento"); return new Symbol(Symcjs.dec, yycolumn, yyline, yytext()); }
 "=="        { System.out.println("Reconocio "+yytext()+" igualigual"); return new Symbol(Symcjs.igualigual, yycolumn, yyline, yytext()); }
 "!="        { System.out.println("Reconocio "+yytext()+" diferente"); return new Symbol(Symcjs.diferente, yycolumn, yyline, yytext()); }
 "<"         { System.out.println("Reconocio "+yytext()+" menorq"); return new Symbol(Symcjs.menorq, yycolumn, yyline, yytext()); }
 ">"         { System.out.println("Reconocio "+yytext()+" mayorq"); return new Symbol(Symcjs.mayorq, yycolumn, yyline, yytext()); }
 "<="        { System.out.println("Reconocio "+yytext()+" menorigual"); return new Symbol(Symcjs.menorigual, yycolumn, yyline, yytext()); }
 ">="        { System.out.println("Reconocio "+yytext()+" mayorigual"); return new Symbol(Symcjs.mayorigual, yycolumn, yyline, yytext()); }
 "&&"        { System.out.println("Reconocio "+yytext()+" land"); return new Symbol(Symcjs.land, yycolumn, yyline, yytext()); }
 "||"        { System.out.println("Reconocio "+yytext()+" lor"); return new Symbol(Symcjs.lor, yycolumn, yyline, yytext()); }
 "!"         { System.out.println("Reconocio "+yytext()+" lnot"); return new Symbol(Symcjs.lnot, yycolumn, yyline, yytext()); }


 "dimv"         { System.out.println("Reconocio "+yytext()+" dimv"); return new Symbol(Symcjs.dimv, yycolumn, yyline, yytext()); }
 "true"         { System.out.println("Reconocio "+yytext()+" true"); return new Symbol(Symcjs.verdadero, yycolumn, yyline, yytext()); }
 "false"        { System.out.println("Reconocio "+yytext()+" false"); return new Symbol(Symcjs.falso, yycolumn, yyline, yytext()); }
 "conteo"       { System.out.println("Reconocio "+yytext()+" conteo"); return new Symbol(Symcjs.conteo, yycolumn, yyline, yytext()); }
 "atexto"       { System.out.println("Reconocio "+yytext()+" atexto"); return new Symbol(Symcjs.atexto, yycolumn, yyline, yytext()); }
 "si"           { System.out.println("Reconocio "+yytext()+" si"); return new Symbol(Symcjs.si, yycolumn, yyline, yytext()); }
 "sino"         { System.out.println("Reconocio "+yytext()+" sino"); return new Symbol(Symcjs.sino, yycolumn, yyline, yytext()); }
 "selecciona"   { System.out.println("Reconocio "+yytext()+" selecciona"); return new Symbol(Symcjs.selecciona, yycolumn, yyline, yytext()); }
 "caso"         { System.out.println("Reconocio "+yytext()+" caso"); return new Symbol(Symcjs.caso, yycolumn, yyline, yytext()); }
 "defecto"      { System.out.println("Reconocio "+yytext()+" defecto"); return new Symbol(Symcjs.defecto, yycolumn, yyline, yytext()); }
 "para"         { System.out.println("Reconocio "+yytext()+" para"); return new Symbol(Symcjs.spara, yycolumn, yyline, yytext()); }
 "mientras"     { System.out.println("Reconocio "+yytext()+" mientras"); return new Symbol(Symcjs.mientras, yycolumn, yyline, yytext()); }
 "detener"      { System.out.println("Reconocio "+yytext()+" detener"); return new Symbol(Symcjs.detener, yycolumn, yyline, yytext()); }
 "imprimir"     { System.out.println("Reconocio "+yytext()+" imprimir"); return new Symbol(Symcjs.imprimir, yycolumn, yyline, yytext()); }
 "funcion"      { System.out.println("Reconocio "+yytext()+" funcion"); return new Symbol(Symcjs.funcion, yycolumn, yyline, yytext()); }
 "retornar"     { System.out.println("Reconocio "+yytext()+" retornar"); return new Symbol(Symcjs.retornar, yycolumn, yyline, yytext()); }
 "mensaje"      { System.out.println("Reconocio "+yytext()+" mensaje"); return new Symbol(Symcjs.mensaje, yycolumn, yyline, yytext()); }
 "documento"    { System.out.println("Reconocio "+yytext()+" documento"); return new Symbol(Symcjs.documento, yycolumn, yyline, yytext()); }
 "obtener"      { System.out.println("Reconocio "+yytext()+" obtener"); return new Symbol(Symcjs.obtener, yycolumn, yyline, yytext()); }
 "setelemento"  { System.out.println("Reconocio "+yytext()+" setelemento"); return new Symbol(Symcjs.setelemento, yycolumn, yyline, yytext()); }
 "observador"   { System.out.println("Reconocio "+yytext()+" observador"); return new Symbol(Symcjs.observador, yycolumn, yyline, yytext());}


 {id}        { System.out.println("Reconocio "+yytext()+" identificador"); return new Symbol(Symcjs.id, yycolumn, yyline, yytext()); }
 {cadena}    { System.out.println("Reconocio "+yytext()+" cadena"); return new Symbol(Symcjs.cadena, yycolumn, yyline, yytext()); }
 {numero}    { System.out.println("Reconocio "+yytext()+" num"); return new Symbol(Symcjs.num, yycolumn, yyline, yytext()); }
 {fecha}     { System.out.println("Reconocio "+yytext()+" fecha"); return new Symbol(Symcjs.fecha, yycolumn, yyline, yytext()); }
 {fechahora} { System.out.println("Reconocio "+yytext()+" fechahora"); return new Symbol(Symcjs.fechah, yycolumn, yyline, yytext()); }


//-------> Simbolos ER

//------> Espacios



{WhiteSpace}    {/* ignore white space. */ }
{coment}                 {/*Se ignoran*/}




//------> Errores Lexicos
.                       { System.out.println("Error Lexico"+yytext()+" Linea "+yyline+" Columna "+yycolumn);
                          Terror datos = new Terror(yytext(),yyline,yycolumn,"Error Lexico","Simbolo no existe en el lenguaje");
                          TablaEL.add(datos);}

}
