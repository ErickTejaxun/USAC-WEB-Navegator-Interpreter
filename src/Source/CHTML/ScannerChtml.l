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
%{
    public static ArrayList<Errores> listaErrores=new ArrayList();	
    public static ArrayList<tablaSimbolos> tablaSimbolos_ = new ArrayList();
	public static String urlAuxliar="";
	public static Boolean fin=false;
	public static String txt_temporal="";
	public static int linea=0;
	public static int columna=0;



    public static int flagInicio = 0;
    public String cadena = "";
    public String estado="";
    public boolean flagCadena = false;

    public void addError(int linea, int columna, String valor)
    {
        Errores errorLexico=new Errores("Lexico",linea, columna, valor);
        listaErrores.add(errorLexico);
    }

    public static void addChtml(String tipo, int linea, int columna, String descripcion, String valor)
    {                
        tipo = tipo.toLowerCase();
        valor = valor.toLowerCase();
        Interfaz.auxContador++;                                
        //Generamos la entrada en la tabla de simbolos.
        tablaSimbolos simbolo=new tablaSimbolos();
        simbolo.setTipo(tipo);
        simbolo.setLinea(linea);
        simbolo.setColumna(columna);
        simbolo.setDescripcion(descripcion);
        simbolo.setIndex(Interfaz.auxContador);
        simbolo.setValor(valor);                 
        tablaSimbolos_.add(simbolo);	            
    }    
    

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
rgb  = ("#"{id}| "#"{digito} | "#"{digito}{id})
direccionWindows= ("\"" ({letra}":"("\\"({id})+)+"."{id}) "\"")
direccionLinux=(("/"{linea}+))+

path = ({letra}":"("\\"({id})+)+"."{id})


idComillas = ("\""{id}"\""|"\""{digito}"\""|"\""{decimal}"\"") 
rgbComillas = ("\""{rgb}"\"")
valorAlineado = ("\"izquierda\""|"\"derecha\""|"\"centrado\"")

metodo = {id}"()"


%state COMENTARIO, CADENA
%%



[\n] { yychar=0;}




<YYINITIAL>
{

    
    {espacio}
    {System.out.println("Salto de linea");}	


    /*----------  < ----------------*/
    "<//-"	
    {   
        estado="YYINITIAL";
        yybegin(COMENTARIO);
    }


    /*----------  < ----------------*/
    "<"	
    {
        addChtml("menorQue",yyline,yychar,"< : Menor que",yytext()); 
        return new Symbol(simbolos.menorQue, yychar, yyline, yytext()); 
    }

    /*----------  > ----------------*/
    ">"	
    {	
        if(flagInicio!=0){yybegin(CADENA);}
        addChtml("mayorQue",yyline,yychar,"> : Mayor que",yytext());        
        return new Symbol(simbolos.mayorQue, yychar, yyline, yytext()); 
    }    

    /*----------1. CHTML----------------*/
    "CHTML"	
    {	
        addChtml("inicioChtml",yyline,yychar,"CHTML : Inicio Documento",yytext());
        return new Symbol(simbolos.inicioChtml, yychar, yyline, yytext()); 
    }


    "FIN-CHTML"	
    {
        addChtml("finChtml",yyline,yychar,"FIN-CHTML : Fin Documento",yytext());
        return new Symbol(simbolos.finChtml, yychar, yyline, yytext()); 
    }

    "encabezado"
    {        
        addChtml("inicioEncabezado",yyline,yychar,"encabezado : Inicio encabezado",yytext());        	        
        return new Symbol(simbolos.inicioEncabezado, yychar, yyline, yytext());        
    } 

    "cuerpo"
    {          
        addChtml("cuerpo",yyline,yychar,"cuerpo : Inicio cuerpo",yytext());      	        
        return new Symbol(simbolos.inicioCuerpo, yychar, yyline, yytext());        
    } 

    "fin-cuerpo"
    {        
        addChtml("fin-cuerpo",yyline,yychar,"fin-cuerpo : Fin cuerpo",yytext());        	        
        return new Symbol(simbolos.finCuerpo, yychar, yyline, yytext());        
    }  


    "panel"
    {
        addChtml("inicioPanel",yyline,yychar,"panel: Declaracion panel",yytext());       
        return new Symbol(simbolos.inicioPanel, yychar, yyline, yytext());                
    } 

    "fin-panel"
    {
        addChtml("finPanel",yyline,yychar,"fin-panel: Cierre panel",yytext());                     
        return new Symbol(simbolos.finPanel, yychar, yyline, yytext());                
    }  


    "texto"
    {             
        addChtml("texto",yyline,yychar,"texto: Inicio texto",yytext());     
        return new Symbol(simbolos.inicioTexto, yychar, yyline, yytext());                
    } 

    "fin-texto"
    { 
        addChtml("fin-texto",yyline,yychar,"fin-texto: Fin texto",yytext());                                   
        return new Symbol(simbolos.finTexto, yychar, yyline, yytext());                
    }   

    "imagen"
    { 
        addChtml("imagen",yyline,yychar,"imagen: Inicio imagen",yytext());                                 
        return new Symbol(simbolos.inicioImagen, yychar, yyline, yytext());                
    }  

    "boton"
    {   
        addChtml("boton",yyline,yychar,"boton: Inicio boton",yytext());                                
        return new Symbol(simbolos.inicioBoton, yychar, yyline, yytext());               
    } 

    "fin-boton"
    {  
        addChtml("fin-boton",yyline,yychar,"fin-boton: Fin boton",yytext());                              
        return new Symbol(simbolos.finBoton, yychar, yyline, yytext());                
    }   


    "enlace"
    {   
        addChtml("enlace",yyline,yychar,"enlace: Inicio enlace",yytext());                             
        return new Symbol(simbolos.inicioEnlace, yychar, yyline, yytext());                
    } 

    "fin-enlace"
    {
        addChtml("fin-enlace",yyline,yychar,"fin-enlace: Fin enlace",yytext());                                  
        return new Symbol(simbolos.finEnlace, yychar, yyline, yytext());                
    }     
    
    "tabla"
    {                
        addChtml("tabla",yyline,yychar,"tabla: Inicio tabla",yytext());                      
        return new Symbol(simbolos.inicioTabla, yychar, yyline, yytext());                
    } 

    "texto_a"
    {
        addChtml("inicioCajaArea",yyline,yychar,"inicioCajaArea: Inicio caja area de texto",yytext());                                
        return new Symbol(simbolos.inicioCajaArea, yychar, yyline, yytext());                
    }   


    "fin-texto_a"
    {
        addChtml("finCajaArea",yyline,yychar,"finCajaArea: Fin caja area de texto",yytext());                                           
        return new Symbol(simbolos.finCajaArea, yychar, yyline, yytext());            
    }    


    "caja_texto"
    {   
        addChtml("inicioCaja",yyline,yychar,"caja_texto: Inico caja texto",yytext());                                       
        return new Symbol(simbolos.inicioCaja, yychar, yyline, yytext());                
    }   


    "fin-caja_texto"
    {   
        addChtml("finCaja",yyline,yychar,"fin-caja_texto: Fin caja texto",yytext());                                            
        return new Symbol(simbolos.finCaja, yychar, yyline, yytext());                
    }    

    "spinner"
    {   
        addChtml("inicioSpinner",yyline,yychar,"spinner: Inico Spinner",yytext());                                        
        return new Symbol(simbolos.inicioSpinner, yychar, yyline, yytext());                
    }   

    "fin-spinner"
    {   
        addChtml("finSpinner",yyline,yychar,"fin-spinner: Fin Spinner",yytext());                                              
        return new Symbol(simbolos.finSpinner, yychar, yyline, yytext());                
    }          

    "caja"
    {   
        addChtml("inicioCajaOpciones",yyline,yychar,"caja: Inico Caja opciones",yytext());                                       
        return new Symbol(simbolos.inicioCajaOpciones, yychar, yyline, yytext());                
    }   

    "fin-caja"
    {   
        addChtml("finCajaOpciones",yyline,yychar,"fin-caja: Fin caja Opciones",yytext());                                              
        return new Symbol(simbolos.finCajaOpciones, yychar, yyline, yytext());                
    }


    "opcion"
    {   
        addChtml("inicioOpcion",yyline,yychar,"Opcion: Inico Opcion",yytext());                                      
        return new Symbol(simbolos.inicioOpcion, yychar, yyline, yytext());                
    }   

    "fin-opcion"
    {   
        addChtml("finOpcion",yyline,yychar,"fin-opcion: Fin Opcion",yytext());                                              
        return new Symbol(simbolos.finOpcion, yychar, yyline, yytext());                
    }  

    "salto-fin"
    {   
        addChtml("salto",yyline,yychar,"salto: salto :v",yytext());                                              
        return new Symbol(simbolos.salto, yychar, yyline, yytext());                
    }       
                           
    "id"
    {
        addChtml("idCcss",yyline,yychar,"Identificador grupo ccss",yytext());                 
        return new Symbol(simbolos.idCcss, yychar, yyline, yytext());
    }

    "grupo"
    {
        addChtml("grupo",yyline,yychar,"grupo : grupo ccss",yytext());                     
        return new Symbol(simbolos.grupo, yychar, yyline, yytext());
    } 

    "alto"
    {
        addChtml("alto",yyline,yychar,"alto : Altura objeto",yytext());                   
        return new Symbol(simbolos.alto, yychar, yyline, yytext());
    }     

    "ancho"
    {
        addChtml("ancho",yyline,yychar,"ancho : Anchura objeto",yytext());                       
        return new Symbol(simbolos.ancho, yychar, yyline, yytext());
    } 

    "alineado"
    {
        addChtml("alineado",yyline,yychar,"alineado : Alineación objeto",yytext());                   
        return new Symbol(simbolos.alineado, yychar, yyline, yytext());
    }  
      
    "="
    {        
        addChtml("asignacion",yyline,yychar,"= : Asignacion",yytext());                     
        return new Symbol(simbolos.asignacion, yychar, yyline, yytext());
    } 

    {direccionWindows}
    {        
        addChtml("path",yyline,yychar,"path : direccion archivo",yytext()); 
        return new Symbol(simbolos.pathComillas, yychar, yyline, yytext());
    }    

    {valorAlineado}
    {
        addChtml("valorAlineado",yyline,yychar,"valorAlineado : Alineación",yytext());                     
        return new Symbol(simbolos.valorAlineado, yychar, yyline, yytext());
    }         



    {idComillas}
    {        
        addChtml("id",yyline,yychar,"id: Posible nombre de color.",yytext()); 
        return new Symbol(simbolos.id, yychar, yyline, yytext());
    } 



    ";"
    {        
        addChtml("puntoComa",yyline,yychar,"; : Punto coma",yytext());             
        return new Symbol(simbolos.puntoComa, yychar, yyline, yytext());
    } 


    "CLICK"
    {        
        Interfaz.addChtml("click",yyline,yychar,"click : evento",yytext());            
        return new Symbol(simbolos.click, yychar, yyline, yytext());
    }   

    {metodo}
    {        
        Interfaz.addChtml("metodo",yyline,yychar, yytext() +" : llamada a metodo",yytext());            
        return new Symbol(simbolos.metodo, yychar, yyline, yytext());
    }           
                
    ">"	
    {    	
        Interfaz.addChtml("mayorQue",yyline,yychar, yytext() +"> : Mayor que",yytext());                
        return new Symbol(simbolos.mayorQue, yychar, yyline, yytext()); 
    } 

    "CLICK"
    {        
        addChtml("click",yyline,yychar,"click : evento",yytext());            
        return new Symbol(simbolos.click, yychar, yyline, yytext());
    }   


    "ruta"
    {
        addChtml("ruta",yyline,yychar,"ruta : Declaración ruta archivo",yytext());
        return new Symbol(simbolos.ruta, yychar, yyline, yytext());
    } 

    {espacio}
    {

    }
}



<CADENA>
{

    [^]
    {  
        if(!yytext().equals("<"))
        {
            if(yytext().equals("\n"))
            {
                cadena  = cadena + "\\n";
            }
            else
            {
                cadena  = cadena + yytext();            
            }            
        }
        else 
        {
            yybegin(YYINITIAL);
            //flagCadena=true;            
            yypushback(1);
            addChtml("cadena",yyline,yychar,"Cadena : cadena de texto",yytext()); 	                
            return new Symbol(simbolos.cadena, yychar, yyline, cadena); 
        }                       
    }  
}

<COMENTARIO>
{
    [^"*/"]
    {}
    
    "-//>"
    {
        yybegin(YYINITIAL);        
    }
 
}
.			{
			System.out.println("Caracter ilegal: " + yytext()+" Linea : "+yyline +" Columna: "+yychar); 
			addError(yyline , yychar, yytext());
			}			
