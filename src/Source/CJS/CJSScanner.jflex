package Source.CHTML;
import java_cup.runtime.*;
import java.util.ArrayList;
import java.io.PrintWriter;
import Principal.Interfaz.*;
import Principal.Errores;
import Principal.Interfaz;
import Principal.tablaSimbolos;
import Source.CHTML.nodoChtml;

//import static olc1_proyecto1.Menu.path;
parser code
{:
	public String cadena="";
    public static ArrayList<tablaSimbolos> tablaSimbolos_ = new ArrayList();	
	public static ArrayList<Errores> erroresSintacticos = new ArrayList();
	public static nodoChtml raizChtml ;

	public static String ConvertirObjectToString(Object Obj)
	 {
		String Str="";
		if(Obj!=null)
		{
			Str = Obj.toString();
		}
		return Str;
	}

	public static void agregarRaiz(nodoChtml encabezado, nodoChtml cuerpo)
	{
		raizChtml = new nodoChtml("DOCUMENTO");
		raizChtml.setValue("DOCUMENTO");
		raizChtml.setTipo("DOCUMENTO");				
		raizChtml.add(encabezado);
		raizChtml.add(cuerpo);
	}
	public static void erroresSintacticos(Symbol s)
	{
		System.out.println("Error de sintaxis. Linea: " + (s.right + 1) +
		" Columna: " + s.left + ". Texto: \"" + s.value + "\"");
		Errores errores_sintacticos=new Errores();
		errores_sintacticos.setTipo("Sintactico");
		errores_sintacticos.setLinea(s.right+1);
		errores_sintacticos.setColumna(s.left);
		errores_sintacticos.setDescripcion(ConvertirObjectToString(s.value));
		//sintactico.listaSintactico.add(errores_sintacticos);
		erroresSintacticos.add(errores_sintacticos);
	}

:}


/*Terminlaes :v :v y más :v pro++ Gamer pro+, rank pro+ , primer nivel, nivel mundial, por tu salud.*/
terminal String menorQue, mayorQue, inicioChtml, finChtml, inicioEncabezado,inicioCjs,ruta,asignacion,pathComillas,puntoComa;
terminal String finCjs,inicioCcss,finCcss,finEncabezado,inicioCuerpo, finCuerpo, fondo, rgb, id, inicioTitulo, finTitulo, cadena,
inicioPanel,idCcss,grupo,alto,ancho,alineado,valorAlineado,finPanel, inicioTexto, finTexto,finImagen, inicioImagen,metodo, click, path,
inicioBoton,finBoton, inicioEnlace, finEnlace, inicioTabla, finTabla, inicioCelda, finCelda, inicioCeldaCabecera, finCeldaCabecera,
inicioFila, finFila, inicioCajaArea, finCajaArea, finCaja, inicioSpinner, finSpinner, inicioCaja, inicioCajaOpciones, finCajaOpciones,inicioOpcion, finOpcion, valor,salto;
/*terminal Integer numero;
terminal Integer decimal;
terminal String idVariable;*/


/*Producciones :v :v y mas :v*/
non terminal nodoChtml CHTML,ENCABEZADO,DEFINICIONARCHIVOS,CUERPO, ESTILOCUERPO, TITULO,  LISTAARCHIVOS, DEFCCSS, DEFCJS,DEFARCHIVO,CONTENIDOENCABEZADO,
INICIOCHTML, FINCHTML, INICIOENCABEZADO,FINENCABEZADO,PANEL,ELEMENTO, ELEMENTOS, ELEMENTOS1,CONTENIDOCUERPO,ELEMENTOSCUERPO,ELEMENTOSCUERPO1,ATRIBUTOS,
ATRIBUTOS1,ELEMENTOC,TEXTO,CONTENIDOCUERPO1, IMAGEN,EI,EI1,CLICK,RUTA,BOTON, ENLACE,AE,AE1,
TABLA, LISTAFILA, FILA, LISTACELDA, CELDA, CELDAC, CONTENIDOCELDA,CADENA,TEXTOA,CAJATEXTO, SPINNER,CAJAOPCIONES , LISTAOPCIONES, OPCION, ELEMENTOOPCION,
ELEMENTOSCAJA,ELEMENTOSOPCION,VALOR,ELEMENTOSCAJA1,ELEMENTOSOPCION1, SALTO;


/*
precedence left suma;
precedence left resta;
precedence left multiplicacion;
precedence left division;*/

/*Aquí comienza las producciones de la gramatica.*/
start with CHTML;


/*1. Documento completo-----------ENCABEZADO CUERPO ---------------------------------------------------------------------------------------------------------------------*/
CHTML::= INICIOCHTML:iz  ENCABEZADO:encabezado CUERPO:cuerpo FINCHTML:der {:
										agregarRaiz(encabezado, cuerpo);
										:};
										//if(der!=null){Interfaz.raizChtml.add(der);}:};


INICIOCHTML::= menorQue:r1 inicioChtml:r2 mayorQue:r3 {: 
												nodoChtml nuevo = new nodoChtml("INICIOCHTML");												
												nuevo.add(new nodoChtml("menorQue"));
												nuevo.add(new nodoChtml("inicioChtml"));
												nuevo.add(new nodoChtml("mayorQue"));
												RESULT=nuevo;:};			
FINCHTML::= menorQue:r1 finChtml:r2 mayorQue:r3 {: 
												nodoChtml nuevo = new nodoChtml("FINCHTML");
												nuevo.add(new nodoChtml("menorQue"));
												nuevo.add(new nodoChtml("finChtml"));
												nuevo.add(new nodoChtml("mayorQue"));
												RESULT=nuevo;:};	


/*2. Encabezado --------------------------------------------------------------------------------------------------------------------------------*/
ENCABEZADO::=  INICIOENCABEZADO:iz CONTENIDOENCABEZADO:cen FINENCABEZADO:der  
												{: 
												RESULT=cen;:};

INICIOENCABEZADO::= menorQue inicioEncabezado mayorQue {: 
												nodoChtml nuevo = new nodoChtml("INICIOENCABEZADO");												
												nuevo.add(new nodoChtml("menorQue"));
												nuevo.add(new nodoChtml("inicioEncabezado"));
												nuevo.add(new nodoChtml("mayorQue"));
												RESULT=nuevo;:};

FINENCABEZADO::= menorQue finEncabezado mayorQue {: 
												nodoChtml nuevo = new nodoChtml("FINENCABEZADO");												
												nuevo.add(new nodoChtml("menorQue"));
												nuevo.add(new nodoChtml("finEncabezado"));
												nuevo.add(new nodoChtml("mayorQue"));
												RESULT=nuevo;:};


/*2.1 Contenido encabezado-----------------------*/

CONTENIDOENCABEZADO::= LISTAARCHIVOS:iz TITULO:der {:
										nodoChtml nuevo = new nodoChtml("ENCABEZADO");																							
										nuevo.add(iz);							
										nuevo.add(der);																								
										RESULT=nuevo;
										:};
					


LISTAARCHIVOS::= LISTAARCHIVOS:iz DEFARCHIVO:der{:
												iz.add(der);
												RESULT=iz;
												:}
				| {:RESULT= new nodoChtml("LISTAARCHIVOS");:};

DEFARCHIVO::= DEFCJS:r
				{:						
				RESULT=r;
				:}
			|DEFCCSS:r 
				{:				
				RESULT=r;
				:};
							

DEFCJS::= menorQue inicioCjs ruta asignacion pathComillas:path puntoComa mayorQue menorQue finCjs mayorQue  
												{: 
												nodoChtml nuevo = new nodoChtml(path);																																		
												nuevo.setTipo("path");
												RESULT=nuevo;
												:};
DEFCCSS::= menorQue inicioCcss ruta asignacion pathComillas:path puntoComa mayorQue menorQue finCcss mayorQue
												{: 
												nodoChtml nuevo = new nodoChtml(path);																																		
												nuevo.setTipo("path");
												RESULT=nuevo;
												:};	
												
																							
TITULO ::= menorQue inicioTitulo mayorQue cadena:valCadena menorQue finTitulo mayorQue{: 
												nodoChtml nuevo = new nodoChtml("TITULO");												
												nuevo.add(new nodoChtml(valCadena));																							
												RESULT=nuevo;
												:};	

/*3. Cuerpo ---------------------------------------------------------------------------------------------------------------------------------------------*/
CUERPO ::= menorQue inicioCuerpo  ESTILOCUERPO:estilo mayorQue CONTENIDOCUERPO:contenido menorQue finCuerpo mayorQue
												{: 
												nodoChtml nuevo = new nodoChtml("CUERPO");												
												nuevo.add(estilo);
												nuevo.add(contenido);
												estilo.setValue("CUERPO");
												estilo.addLista(contenido);
												RESULT=estilo;
												:}
		|menorQue inicioCuerpo  ESTILOCUERPO:estilo mayorQue  menorQue finCuerpo mayorQue
												{: 
												nodoChtml nuevo = new nodoChtml("CUERPO");
												nuevo.add(estilo);	
												estilo.setValue("CUERPO");
												RESULT=estilo;											
												:}
		|	menorQue inicioCuerpo mayorQue CONTENIDOCUERPO:contenido  menorQue finCuerpo mayorQue
												{: 
												nodoChtml nuevo = new nodoChtml("CUERPO");
												nuevo.add(contenido);
												contenido.setValue("CUERPO");
												RESULT=contenido;
												:}															
		|	menorQue inicioCuerpo mayorQue  menorQue finCuerpo mayorQue
												{: 
												nodoChtml nuevo = new nodoChtml("CUERPO");												
												RESULT=nuevo;
												:};

ESTILOCUERPO::=  fondo asignacion rgb:color puntoComa{: 
												nodoChtml nodo = new nodoChtml("CUERPO");												
												nodoChtml nuevo = new nodoChtml("ELEMENTO");
												nuevo.add(new nodoChtml("color"));
												nuevo.add(new nodoChtml(color));
												nodo.add(nuevo);
												RESULT=nodo;
												:}
				| fondo asignacion id:color puntoComa {: 
												nodoChtml nodo = new nodoChtml("CUERPO");
												nodoChtml nuevo = new nodoChtml("ELEMENTO");
												nuevo.add(new nodoChtml("color"));
												nuevo.add(new nodoChtml(color));
												nodo.add(nuevo);
												RESULT=nodo;
												:}; 

/*TODOS LOS ELEMENTOS QUE PUEDEN VENIR DENTRO DEL CUERPO O DENTRO DE UN PANEL :V :V Y MÁS :V*/
CONTENIDOCUERPO::= CONTENIDOCUERPO:cuerpo PANEL:panel
							{: 
							cuerpo.add(panel);																																													
							RESULT=cuerpo;
							:}
				| CONTENIDOCUERPO:cuerpo TEXTO:texto
							{: 											
							cuerpo.add(texto);																																																		
							RESULT=cuerpo;
							:}
				| CONTENIDOCUERPO:cuerpo IMAGEN:imagen
							{: 
							cuerpo.add(imagen);																																													
							RESULT=cuerpo;
							:}	
				| CONTENIDOCUERPO:cuerpo BOTON:b
							{: 	
							cuerpo.add(b);																																												
							RESULT=cuerpo;
							:}
				| CONTENIDOCUERPO:cuerpo ENLACE:b
							{: 											
							cuerpo.add(b);																																																				
							RESULT=cuerpo;
							:}	
				| CONTENIDOCUERPO:cuerpo TABLA:b
							{: 	
							cuerpo.add(b);																																												
							RESULT=cuerpo;
							:}	

				| CONTENIDOCUERPO:cuerpo TEXTOA:b
							{: 
							cuerpo.add(b);																																												
							RESULT=cuerpo;
							:}
				| CONTENIDOCUERPO:cuerpo CAJATEXTO:b
							{: 
							cuerpo.add(b);																																												
							RESULT=cuerpo;
							:}
				| CONTENIDOCUERPO:cuerpo SPINNER:b
							{: 
							cuerpo.add(b);																																												
							RESULT=cuerpo;
							:}		
				| CONTENIDOCUERPO:cuerpo CAJAOPCIONES:b
							{: 
							cuerpo.add(b);																																												
							RESULT=cuerpo;
							:}	

				| CONTENIDOCUERPO:cuerpo SALTO:b
							{: 
							cuerpo.add(b);																																												
							RESULT=cuerpo;
							:}																																																											
				| PANEL:panel
							{: 
							nodoChtml nuevo = new nodoChtml("CONTENIDO");																			
							nuevo.add(panel);																																													
							RESULT=nuevo;
							:}
											
				| TEXTO:texto{: 
							nodoChtml nuevo = new nodoChtml("CONTENIDO");												
							nuevo.add(texto);																																																				
							RESULT=nuevo;
							:}
				|IMAGEN:texto{: 
							nodoChtml nuevo = new nodoChtml("CONTENIDO");												
							nuevo.add(texto);																																																				
							RESULT=nuevo;
							:}
				| BOTON:t	{: 
							nodoChtml nuevo = new nodoChtml("CONTENIDO");												
							nuevo.add(t);																																																				
							RESULT=nuevo;
							:}
				|ENLACE:t {:	
							nodoChtml nuevo = new nodoChtml("CONTENIDO");						 																																																															
							nuevo.add(t);
							RESULT=nuevo;
							:}
				|TABLA:t{: 
							nodoChtml nuevo = new nodoChtml("CONTENIDO");												
							nuevo.add(t);																																																				
							RESULT=nuevo;
							:}
				|TEXTOA:t {: 
							nodoChtml nuevo = new nodoChtml("CONTENIDO");												
							nuevo.add(t);																																																				
							RESULT=nuevo;
							:}
				|CAJATEXTO:t {: 
							nodoChtml nuevo = new nodoChtml("CONTENIDO");												
							nuevo.add(t);																																																				
							RESULT=nuevo;
							:}
				|SPINNER:t {: 
							nodoChtml nuevo = new nodoChtml("CONTENIDO");												
							nuevo.add(t);																																																				
							RESULT=nuevo;
							:}
				| CAJAOPCIONES:t {: 
							nodoChtml nuevo = new nodoChtml("CONTENIDO");												
							nuevo.add(t);																																																				
							RESULT=nuevo;
							:} 
				| SALTO:t {: 
							nodoChtml nuevo = new nodoChtml("CONTENIDO");												
							nuevo.add(t);																																																				
							RESULT=nuevo;
							:};
				

/*3.1-----------------------panel----------------------*/												

PANEL::= menorQue inicioPanel  ELEMENTOS:elementos mayorQue CONTENIDOCUERPO:contenido menorQue finPanel mayorQue
												{: 
												elementos.setValue("PANEL");																								
												elementos.addLista(contenido);																																														
												RESULT=elementos;
												:}
		|menorQue inicioPanel  ELEMENTOS:elementos mayorQue  menorQue finPanel mayorQue
												{: 
												elementos.setValue("PANEL");																								
												//elementos.add(contenido);																																														
												RESULT=elementos;
												:}
 		| menorQue inicioPanel  mayorQue CONTENIDOCUERPO:contenido menorQue finPanel mayorQue
												{: 
												nodoChtml nuevo = new nodoChtml("PANEL");																							
												nuevo.addLista(contenido);																																													
												RESULT=nuevo;
												:}
		|menorQue inicioPanel mayorQue  menorQue finPanel mayorQue
												{: 
												nodoChtml nuevo = new nodoChtml("PANEL");																																																									
												RESULT=nuevo;
												:}												
												;

ELEMENTOS::= ELEMENTOS1:r{:					
						RESULT= r;
						:};

ELEMENTOS1::= ELEMENTOS1:iz ELEMENTO:der 
							{:					
							iz.add(der);
							RESULT= iz;
							:}
			| ELEMENTO:r	{:
							nodoChtml nuevo = new nodoChtml("ELEMENTO");
							nuevo.add(r);							
							RESULT= nuevo;
							:};

ELEMENTO::= idCcss asignacion id:id puntoComa 	{: 
											nodoChtml nuevo = new nodoChtml("ELEMENTO");
											nuevo.add(new nodoChtml("ID"));
											nuevo.add(new nodoChtml(id));
											RESULT=nuevo;
											:}
		|   grupo asignacion id:id puntoComa	{: 
											nodoChtml nuevo = new nodoChtml("ELEMENTO");												
											nuevo.add(new nodoChtml("GRUPO"));
											nuevo.add(new nodoChtml(id));
											RESULT=nuevo;
											:}
		|   alto asignacion id:id puntoComa{: 
										nodoChtml nuevo = new nodoChtml("ELEMENTO");												
										nuevo.add( new nodoChtml("ALTO"));
										nuevo.add(new nodoChtml(id));																																												
										RESULT=nuevo;
										:} 	
		|   ancho asignacion id:id puntoComa{: 
										nodoChtml nuevo = new nodoChtml("ELEMENTO");												
										nuevo.add(new nodoChtml("ANCHO"));
										nuevo.add(new nodoChtml(id));																																												
										RESULT=nuevo;
										:} 			
		|   alineado asignacion valorAlineado:id puntoComa
										{: 
										nodoChtml nuevo = new nodoChtml("ELEMENTO");												
										nuevo.add(new nodoChtml("ALINEADO"));
										nuevo.add(new nodoChtml(id));																																												
										RESULT=nuevo;
										:};

										
TEXTO::= menorQue inicioTexto ELEMENTOS:elementos mayorQue cadena:cad menorQue finTexto mayorQue
										{: 	
										elementos.setValue("TEXTO");	
										nodoChtml nuevo = new nodoChtml("ELEMENTO");																														
										nuevo.add(new nodoChtml("CADENA"));
										nuevo.add(new nodoChtml(cad));
										elementos.add(nuevo);	
										RESULT=elementos;
										:} 											
		| menorQue inicioTexto  mayorQue cadena:cad menorQue finTexto mayorQue
										{: 
										nodoChtml nuevo = new nodoChtml("TEXTO");	
										nodoChtml aux = new nodoChtml("ELEMENTO");
										aux.add(new nodoChtml("CADENA"));
										aux.add(new nodoChtml(cad));
										nuevo.add(aux);										
										RESULT=nuevo;
										:};

IMAGEN::= menorQue inicioImagen  mayorQue path:ruta menorQue finImagen mayorQue{: 
										nodoChtml nuevo = new nodoChtml("IMAGEN");
										nodoChtml aux = new nodoChtml("ELEMENTO");												
										aux.add(new nodoChtml("RUTA"));
										aux.add(new nodoChtml(ruta));
										nuevo.add(aux);																																													
										RESULT=nuevo;
										:} 
		| menorQue inicioImagen mayorQue  menorQue finImagen mayorQue{: 
										nodoChtml nuevo = new nodoChtml("IMAGEN");												
										RESULT=nuevo;
										:} 
 		| menorQue inicioImagen EI:e mayorQue path:ruta menorQue finImagen mayorQue{: 
										e.setValue("IMAGEN");
										nodoChtml aux = new nodoChtml("ELEMENTO");												
										aux.add(new nodoChtml("RUTA"));
										aux.add(new nodoChtml(ruta));
										e.add(aux);																																																																	
										RESULT=e;
										:} 
		| menorQue inicioImagen EI:e  mayorQue  menorQue finImagen mayorQue{: 
										e.setValue("IMAGEN");																						
										RESULT=e;
										:};	


/*------------------------------------------------INICIO ENLACE---------------------------------------------------*/
ENLACE::= menorQue inicioEnlace AE:ae mayorQue cadena:cad menorQue finEnlace mayorQue
										{: 	
										ae.setValue("ENLACE");
										nodoChtml nuevo = new nodoChtml("ELEMENTO");																															
										nuevo.add(new nodoChtml("CADENA"));										
										nuevo.add(new nodoChtml(cad));
										ae.add(nuevo);
										//nuevo.add(new nodoChtml("cadena", new nodoChtml(cad)));																																																							
										RESULT=ae;
										:}
		| menorQue inicioEnlace  mayorQue cadena:cad menorQue finEnlace mayorQue
										{: 																																																																																																											
										nodoChtml nuevo = new nodoChtml("ENLACE");
										nodoChtml aux = new nodoChtml("ELEMENTO");																															
										aux.add(new nodoChtml("CADENA"));										
										aux.add(new nodoChtml(cad));																																
										nuevo.add(nuevo);																																																							
										RESULT=nuevo;
										:};
AE::= AE1:r{:RESULT=r;:};

AE1::= 	AE1:a ELEMENTO:r
						{:
						a.add(r);
						RESULT=a;
						:}
		|  AE1:a RUTA:r
						{:
						a.add(r);			
						RESULT=a;
						:}
		| ELEMENTO:r{:
					nodoChtml nuevo = new nodoChtml("ELEMENTOS");
					nuevo.add(r);
					RESULT=nuevo;:}		
		| RUTA:r{:
				nodoChtml nuevo = new nodoChtml("ELEMENTOS");
				nuevo.add(r);
				RESULT=nuevo;:}; 

/*------------------------------------------------FIN ENLACE--------------------------------------------------------*/

BOTON::= menorQue inicioBoton ATRIBUTOS:atrib mayorQue cadena:cad menorQue finBoton mayorQue
										{:
										atrib.setValue("BOTON"); 
										nodoChtml nuevo = new nodoChtml("ELEMENTO");																					
										nuevo.add(new nodoChtml("CADENA"));
										nuevo.add(new nodoChtml(cad));
										atrib.add(nuevo);										
										RESULT=atrib;
										:}
		|menorQue inicioBoton  mayorQue cadena:cad menorQue finBoton mayorQue
										{: 
										nodoChtml nuevo = new nodoChtml("BOTON");												
										nuevo.add(new nodoChtml(cad));
										nodoChtml aux = new nodoChtml("ELEMENTO");																					
										aux.add(new nodoChtml("CADENA"));
										aux.add(new nodoChtml(cad));	
										nuevo.add(aux);																																																						
										RESULT=nuevo;
										:};


ATRIBUTOS::=  ATRIBUTOS1:e{:RESULT=e;:};

ATRIBUTOS1::= ATRIBUTOS1:atributos CLICK:c{:			
								atributos.add(c);			
								RESULT=atributos;:}
			| ATRIBUTOS1:atributos RUTA:c{:															
								atributos.add(c);			
								RESULT=atributos;:}
			| ATRIBUTOS1:atributos ELEMENTO:c{:		
								atributos.add(c);			
								RESULT=atributos;:}
			| CLICK:e{:
						nodoChtml nuevo = new nodoChtml("BOTON");
						nuevo.add(e);
						RESULT=nuevo;:}
			| RUTA:e{:
						nodoChtml nuevo = new nodoChtml("BOTON");
						nuevo.add(e);
						RESULT=nuevo;:}			
			| ELEMENTO:e{:
						nodoChtml nuevo = new nodoChtml("BOTON");
						nuevo.add(e);
						RESULT=nuevo;:};

EI::= EI1:e{:RESULT=e;:};

EI1::= EI1:e CLICK:r {:														
			e.add(r);
			RESULT=e;:}
	|  EI1:e RUTA:r {:
			e.add(r);
			RESULT=e;:}
	|  EI1:e ELEMENTO:r {:
			e.add(r);
			RESULT=e;:}			
	| CLICK:click {:
			nodoChtml nuevo = new nodoChtml("ELEMENTOS");												
			nuevo.add(click);
			RESULT=nuevo;:}
	| RUTA:r {:
			nodoChtml nuevo = new nodoChtml("ELEMENTOS");												
			nuevo.add(r);
			RESULT=nuevo;:}
	| ELEMENTO:elemento {:
			nodoChtml nuevo = new nodoChtml("ELEMENTOS");												
			nuevo.add(elemento);
			RESULT=nuevo;:};


CLICK::= click asignacion metodo:met puntoComa{:
										nodoChtml nuevo = new nodoChtml("ELEMENTO");
										nuevo.add(new nodoChtml("CLICK"));																							
										nuevo.add(new nodoChtml(met));																																																							
										RESULT=nuevo;
										:};

RUTA::= ruta asignacion pathComillas:path puntoComa
										{:																								
										nodoChtml nuevo = new nodoChtml("ELEMENTO");
										nuevo.add(new nodoChtml("RUTA"));
										nuevo.add(new nodoChtml(path));
										RESULT=nuevo;																																													
										:};



/*TABLA-------------------------------------------------------------------------------*/

TABLA::= menorQue inicioTabla ELEMENTOS:e mayorQue LISTAFILA:contenido menorQue finTabla mayorQue
										{:
										e.setValue("TABLA");											
										e.addLista(contenido);
										RESULT=e;
										:}
		| menorQue inicioTabla mayorQue LISTAFILA:contenido menorQue finTabla mayorQue
										{:
										contenido.setValue("TABLA");																															
										RESULT=contenido;
										:};

LISTAFILA::= LISTAFILA:lista FILA:fila 										
								{:																				
								lista.addLista(fila);	
								RESULT=lista;
								:}
			| FILA:f {:RESULT=f;:};

FILA::=   menorQue inicioFila mayorQue LISTACELDA:celdas  menorQue finFila mayorQue									
										{:		
										nodoChtml nuevo = new nodoChtml("FILA");
										nuevo.add(celdas);
										RESULT=nuevo;
										:}	
		| menorQue inicioFila ELEMENTOS:elementos mayorQue LISTACELDA:celdas menorQue finFila mayorQue										
										{:
										//nodoChtml nuevo = new nodoChtml("FILA");	
										elementos.setValue("FILA");
										elementos.addLista(celdas);																												
										RESULT=elementos;
										:};

LISTACELDA::=LISTACELDA:l CELDA:c
					{:					
					l.add(c);										
					RESULT= l;:}		
			| LISTACELDA:l CELDAC:c
					{:									
					l.add(c);					
					RESULT= l;:}			
			| CELDA:c
					{:	
					nodoChtml nuevo = new nodoChtml("FILA");
					nuevo.add(c);									
					RESULT= nuevo;:}			
			| CELDAC:c
					{:	
					nodoChtml nuevo = new nodoChtml("FILA");
					nuevo.add(c);									
					RESULT= nuevo;:};

CELDA::= menorQue inicioCelda mayorQue CONTENIDOCELDA:contenido menorQue finCelda mayorQue
										{:																															 
										contenido.setValue("CELDA");																												
										RESULT=contenido;
										:}
		| menorQue inicioCelda ELEMENTOS:elementos mayorQue CONTENIDOCELDA:contenido  menorQue finCelda mayorQue
										{:		
										elementos.setValue("CELDA");																																																	
										elementos.addLista(contenido);																																						
										RESULT=elementos;
										:};

CELDAC::= menorQue inicioCeldaCabecera mayorQue CONTENIDOCELDA:contenido  menorQue finCeldaCabecera mayorQue
										{:																															
										contenido.setValue("CELDAC");																												
										RESULT=contenido;
										:}
		| menorQue inicioCeldaCabecera  ELEMENTOS:elementos mayorQue CONTENIDOCELDA:contenido menorQue finCeldaCabecera mayorQue
										{:		
										elementos.setValue("CELDAC");																																																	
										elementos.addLista(contenido);																																						
										RESULT=elementos;
										:};

CONTENIDOCELDA::= CONTENIDOCELDA:l IMAGEN:b
								{:
								l.add(b);						
								RESULT= l;:}
				| CONTENIDOCELDA:l CADENA:b 
								{:
								l.add(b);						
								RESULT= l;:}			
				|CONTENIDOCELDA:l  BOTON:b
								{:
								l.add(b);						
								RESULT= l;
								:}
				| IMAGEN:imagen 		
						{:
						nodoChtml nuevo = new nodoChtml("LISTA");
						nuevo.add(imagen);
						RESULT= nuevo;
						:}
				| BOTON:boton 
						{:
						nodoChtml nuevo = new nodoChtml("LISTA");
						nuevo.add(boton);
						RESULT= nuevo;
						:}
				| CADENA:cad 	
						{:
						nodoChtml nuevo = new nodoChtml("LISTA");						
						nuevo.add(cad);
						RESULT= nuevo;
						:};


CADENA::= cadena:cad  {:
						nodoChtml nuevo = new nodoChtml("ELEMENTO");
						nuevo.add(new nodoChtml("CADENA"));
						nuevo.add(new nodoChtml(cad));
						RESULT= nuevo;:};


TEXTOA::= menorQue inicioCajaArea ELEMENTOS:elementos mayorQue cadena:cad menorQue finCajaArea mayorQue
						{:
						nodoChtml nuevo = new nodoChtml("ELEMENTO");
						nuevo.add(new nodoChtml("CADENA"));
						nuevo.add(new nodoChtml(cad));
						elementos.add(nuevo);
						elementos.setValue("TEXTOA");
						RESULT= elementos;
						:}
		| menorQue inicioCajaArea mayorQue cadena:cad menorQue finCajaArea mayorQue
						{:
						nodoChtml nuevo = new nodoChtml("TEXTOA");
						nodoChtml aux = new nodoChtml("ELEMENTO");						
						aux.add(new nodoChtml("CADENA"));
						aux.add(new nodoChtml(cad));
						nuevo.add(aux);
						RESULT= nuevo;
						:};


CAJATEXTO::= menorQue inicioCaja ELEMENTOS:elementos mayorQue cadena:cad menorQue finCaja mayorQue
						{:
						nodoChtml nuevo = new nodoChtml("ELEMENTO");
						nuevo.add(new nodoChtml("CADENA"));
						nuevo.add(new nodoChtml(cad));
						elementos.add(nuevo);
						elementos.setValue("CAJATEXTO");
						RESULT= elementos;
						:}
		| menorQue inicioCaja mayorQue cadena:cad menorQue finCaja mayorQue
						{:
						nodoChtml nuevo = new nodoChtml("CAJATEXTO");
						nodoChtml aux = new nodoChtml("ELEMENTO");						
						aux.add(new nodoChtml("CADENA"));
						aux.add(new nodoChtml(cad));
						nuevo.add(aux);
						RESULT= nuevo;
						:};		


SPINNER::= menorQue inicioSpinner ELEMENTOS:elementos mayorQue cadena:cad menorQue finSpinner mayorQue
						{:
						nodoChtml nuevo = new nodoChtml("ELEMENTO");
						nuevo.add(new nodoChtml("ENTERO"));
						nuevo.add(new nodoChtml(cad));
						elementos.add(nuevo);
						elementos.setValue("SPINNER");
						RESULT= elementos;
						:}
		| menorQue inicioSpinner mayorQue cadena:cad menorQue finSpinner mayorQue
						{:
						nodoChtml nuevo = new nodoChtml("SPINNER");
						nodoChtml aux = new nodoChtml("ELEMENTO");						
						aux.add(new nodoChtml("ENTERO"));
						aux.add(new nodoChtml(cad));
						nuevo.add(aux);
						RESULT= nuevo;
						:};											





CAJAOPCIONES::= menorQue inicioCajaOpciones ELEMENTOSCAJA:elementos mayorQue LISTAOPCIONES:listaOpciones menorQue finCajaOpciones mayorQue
								{:
								elementos.setValue("CAJAOPCIONES");
								elementos.addLista(listaOpciones);
								RESULT = elementos;																					
								:}

				| menorQue inicioCajaOpciones mayorQue LISTAOPCIONES:listaOpciones menorQue finCajaOpciones mayorQue
								{:
								nodoChtml nuevo = new nodoChtml("LISTAOPCIONES");
								listaOpciones.setValue("");
								RESULT = listaOpciones;														
								:};



ELEMENTOSCAJA::=  ELEMENTOSCAJA1:e{:RESULT=e;:};

ELEMENTOSCAJA1::= ELEMENTOSCAJA1:atributos CLICK:c{:			
								atributos.add(c);			
								RESULT=atributos;:}
			| ELEMENTOSCAJA1:atributos ELEMENTO:c{:		
								atributos.add(c);			
								RESULT=atributos;:}
			| CLICK:e{:
						nodoChtml nuevo = new nodoChtml("CAJAOPCIONES");
						nuevo.add(e);
						RESULT=nuevo;:}			
			| ELEMENTO:e{:
						nodoChtml nuevo = new nodoChtml("CAJAOPCIONES");
						nuevo.add(e);
						RESULT=nuevo;:};



LISTAOPCIONES::= LISTAOPCIONES:lista OPCION:opcion
									{:
									lista.setValue("OPCION");
									lista.add(opcion);
									RESULT= lista;									
									:}
				| OPCION:opcion {:
								nodoChtml nuevo = new nodoChtml("OPCION");
								nuevo.add(opcion);
								RESULT = nuevo;
								:};







OPCION::= menorQue inicioOpcion ELEMENTOSOPCION:elementos mayorQue cadena:cad menorQue finOpcion mayorQue
									{:
									nodoChtml nuevo = new nodoChtml("ELEMENTO");
									nuevo.add(new nodoChtml("CADENA"));
									nuevo.add(new nodoChtml(cad));
									elementos.add(nuevo);
									RESULT= elementos;									
									:}				
		|    menorQue inicioOpcion mayorQue cadena:cad menorQue finOpcion mayorQue
									{:
									nodoChtml nuevo = new nodoChtml("OPCION");
									nodoChtml aux = new nodoChtml("ELEMENTO");									
									aux.add(new nodoChtml("CADENA"));
									aux.add(new nodoChtml(cad));
									nuevo.add(aux);
									RESULT= nuevo;																		
									:};


ELEMENTOSOPCION::= ELEMENTOSOPCION:atributos VALOR:c
								{:			
								atributos.add(c);			
								RESULT=atributos;
								:}
			| ELEMENTOSOPCION:atributos ELEMENTO:c
								{:		
								atributos.add(c);			
								RESULT=atributos;
								:}
			| VALOR:e{:
						nodoChtml nuevo = new nodoChtml("OPCION");
						nuevo.add(e);
						RESULT=nuevo;:}			
			| ELEMENTO:e{:
						nodoChtml nuevo = new nodoChtml("OPCION");
						nuevo.add(e);
						RESULT=nuevo;:};

VALOR::=  valor asignacion id:id puntoComa
										{: 
										nodoChtml nuevo = new nodoChtml("ELEMENTO");												
										nuevo.add(new nodoChtml("VALOR"));
										nuevo.add(new nodoChtml(id));																																												
										RESULT=nuevo;
										:}		
		|  valor asignacion cadena:id puntoComa
										{: 
										nodoChtml nuevo = new nodoChtml("ELEMENTO");												
										nuevo.add(new nodoChtml("VALOR"));
										nuevo.add(new nodoChtml(id));																																												
										RESULT=nuevo;
										:};															


SALTO::= menorQue salto mayorQue{:
								nodoChtml nuevo = new nodoChtml("SALTO");
								RESULT= nuevo;
								:};
