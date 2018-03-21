package Analizadores;
import java_cup.runtime.Symbol;
import java.util.ArrayList;
import javax.swing.*;
import Web.*;

%%

%init{ 
    yyline = 1; 
    yychar = 1; 
%init} 
%{
public String comentario = "";
%}

%class lexicoCCSS
%cupsym symCCSS
%cup    
%char
%column
%full
%line
%ignorecase
%public
%unicode


BLANCOS=[ \r\t]+
DIGITO=[0-9]+
NUMERO=[0-9]+("."[  |0-9]+)?
CARACTER =[a-zA-Z]
CADENA= "\""[^\"]*"\""
ID= ({CARACTER})+({CARACTER}|{NUMERO}|"_")*


LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace = {LineTerminator} | [ \t\f]

comentVariasLineas = "/*" [^*] ~"*/" | "/*" "*"+ "/"

comentUnaLinea = "//" {InputCharacter}* {LineTerminator} //comentarios que seran de una sola linea
comentario = "/**" {contenidoComentario} "*"+ "/"
contenidoComentario = ( [^*] | \*+ [^*/] )* /*comentario de varias
lineas*/

coment = {comentVariasLineas} | {comentUnaLinea} | {comentario}

%% 
//tokens
"["                      {return new Symbol(symCCSS.COR_IZQ, yycolumn, yyline, yytext()); }
"]"                      {return new Symbol(symCCSS.COR_DER, yycolumn, yyline, yytext());}
"("                      {return new Symbol(symCCSS.PAR_IZQ, yycolumn, yyline, yytext());}
":="                     {return new Symbol(symCCSS.IGUAL, yycolumn, yyline, yytext());}
","                      {return new Symbol(symCCSS.COMA, yycolumn, yyline, yytext());}
"+"                      {return new Symbol(symCCSS.MAS, yycolumn, yyline, yytext());}
"-"                      {return new Symbol(symCCSS.MENOS, yycolumn, yyline, yytext());}
"*"                      {return new Symbol(symCCSS.POR, yycolumn, yyline, yytext());}
")"                      {return new Symbol(symCCSS.PAR_DER, yycolumn, yyline, yytext());}
";"                      {return new Symbol(symCCSS.PUNTO_COMA, yycolumn, yyline, yytext());}
"/"                      {return new Symbol(symCCSS.DIV, yycolumn, yyline, yytext());}


//palabras reservadas
"negrilla"               {return new Symbol(symCCSS.negrilla, yycolumn, yyline, yytext());}
"cursiva"                {return new Symbol(symCCSS.cursiva, yycolumn, yyline, yytext());}
"mayuscula"              {return new Symbol(symCCSS.mayuscula, yycolumn, yyline, yytext());}
"minuscula"              {return new Symbol(symCCSS.minuscula, yycolumn, yyline, yytext());}
"capital-t"              {return new Symbol(symCCSS.capital, yycolumn, yyline, yytext());}
"true"                   {return new Symbol(symCCSS.TRUE, yycolumn, yyline, yytext());}
"false"                  {return new Symbol(symCCSS.FALSE, yycolumn, yyline, yytext());}
"autoredimension"        {return new Symbol(symCCSS.autoredimension, yycolumn, yyline, yytext());}
"visible"                {return new Symbol(symCCSS.visible, yycolumn, yyline, yytext());}
"borde"                  {return new Symbol(symCCSS.borde, yycolumn, yyline, yytext());}
"opaque"                 {return new Symbol(symCCSS.opaque, yycolumn, yyline, yytext());}
"colortext"              {return new Symbol(symCCSS.colorText, yycolumn, yyline, yytext());}
"id"                     {return new Symbol(symCCSS.idToken, yycolumn, yyline, yytext());}
"alineado"               {return new Symbol(symCCSS.alineado, yycolumn, yyline, yytext());}
"texto"                  {return new Symbol(symCCSS.texto, yycolumn, yyline, yytext());}
"formato"                {return new Symbol(symCCSS.formato, yycolumn, yyline, yytext());}
"letra"                  {return new Symbol(symCCSS.letra, yycolumn, yyline, yytext());}
"tamtex"                 {return new Symbol(symCCSS.tamTex, yycolumn, yyline, yytext());}
"fondoelemento"          {return new Symbol(symCCSS.fondoElemento, yycolumn, yyline, yytext());}
"grupo"                  {return new Symbol(symCCSS.grupo, yycolumn, yyline, yytext());}
"horizontal"             {return new Symbol(symCCSS.horizontal, yycolumn, yyline, yytext());}
"vertical"               {return new Symbol(symCCSS.vertical, yycolumn, yyline, yytext());}
"izquierda"              {return new Symbol(symCCSS.izquierda, yycolumn, yyline, yytext());}
"derecha"                {return new Symbol(symCCSS.derecha, yycolumn, yyline, yytext());}
"centrado"               {return new Symbol(symCCSS.centrado, yycolumn, yyline, yytext());}
"justificado"            {return new Symbol(symCCSS.justificado, yycolumn, yyline, yytext());}

    
{ID}                     {return new Symbol(symCCSS.ID, yycolumn, yyline, yytext());}
{NUMERO}                 {return new Symbol(symCCSS.NUMERO, yycolumn, yyline, yytext());}
{CADENA}                 {return new Symbol(symCCSS.CADENA, yycolumn, yyline, yytext());}
{WhiteSpace}             {/*Se ignoran*/}
{coment}                 {/*Se ignoran*/}
    
.                        {Web.listaError.agregarError("Error Lexico",yytext(), yyline , yycolumn);}
