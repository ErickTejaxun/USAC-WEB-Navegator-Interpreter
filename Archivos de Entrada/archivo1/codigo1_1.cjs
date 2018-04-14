DimV Valor1 : "";
DimV Valor2 : "";
DimV Resultado : "";
DimV Contador : 0;
DimV ContadorPunto : 0;
DimV ValorPunto: 0;
DimV turno : 0;
DimV textoCalcular : "";
DimV operadorAnterior : "";
DimV resultadoValor;
DimV btn_formato;

resultadoValor : Documento.Obtener("r_resultado_opera");


Documento.Observador("listo", funcion(){

	Documento.Obtener("cuerpo").setElemento("fondoelemento", "pink");
	Mensaje("Se cambio el color a Rosado ");

});

resultadoValor.Observador("modificado",funcion(){
	si (Resultado < 0){
		Mensaje("El resultado es negativo");
	}
});

btn_formato : Documento.Obtener("btn_formato");

btn_formato.Observador("Clic", funcion(){
	Dimv Panel1 : Documento.Obtener("panel_datos");
	Dimv Panel2 : Documento.Obtener("panel_operaciones");
	
	Panel1.setelemento("FondoElemento","RED");
	Panel2.setelemento("gruPO","f_p_titulo");

});

funcion operacion_datos(){
	mensaje("No hago nado");
	cambiar_Textos("no hago nada");
}

funcion vetor1(){
	verVector(1);
}

funcion vetor2(){
	verVector(2);
}

funcion vetor3(){
	verVector(3);
}

funcion vetor4(){
	verVector(4);
}

funcion verVector(tipo){

	Dimv i;
	Dimv Cadena : "Vector: ";
	
	Dimv miVector{6}; ': getVector(tipo);
	Dimv numeros : { 10 , 200 , 80 , 90 , 100 , 120 };
	Dimv nombres : {"Pedro", "Julia" , "Johana" , "Luis" , "Alejandra" , "Michael" };
	DimV Fechas : { "01/01/2010" , "01/01/2011" , "01/01/2012" , "01/01/2013" , "01/01/2014" };
	DimV FechaHORA : { "31/12/2009 23:59:59" , "31/12/2010 23:59:59", "31/12/2011 23:59:59"};
	
	si(tipo==1){
		miVector: { 10 , 200 , 80 , 90 , 100 , 120 };
	}
	si(tipo==2){
		miVector: {"Pedro", "Julia" , "Johana" , "Luis" , "Alejandra" , "Michael" };
	}
	si(tipo ==3){
		miVector:{ "01/01/2010" , "01/01/2011" , "01/01/2012" , "01/01/2013" , "01/01/2014" };
	}
	si(tipo ==3){
		miVector: { "31/12/2009 23:59:59" , "31/12/2010 23:59:59", "31/12/2011 23:59:59"};
	}

	
	i : miVector.Conteo - 1;
	
	imprimir(miVector.aTexto());
	
	Mientras( i >= 0){
		Cadena : Cadena + miVector{i};
		i--;
	} 
	
	cambiar_Textos(Cadena);
	
}

funcion cambiar_Textos(valorTExto){
	DimV Txt_TEMP;
	Txt_TEMP : Documento.Obtener("r_opcion");
	mensaje(valorTExto);
	
	
	Txt_TEMP : Documento.Obtener("r_nombre");
	mensaje(valorTExto);
	
	Txt_TEMP : Documento.Obtener("r_resultado");
	mensaje(valorTExto);
	
	Txt_TEMP : Documento.Obtener("r_comentario");
	mensaje(valorTExto);
	
	Txt_TEMP : Documento.Obtener("r_nota_1");
	mensaje(valorTExto);
	
	Txt_TEMP : Documento.Obtener("r_nota_2");
	mensaje(valorTExto);
}

funcion getVector(tipo){

	Dimv numeros : { 10 , 200 , 80 , 90 , 100 , 120 };
	Dimv nombres : {"Pedro", "Julia" , "Johana" , "Luis" , "Alejandra" , "Michael" };
	DimV Fechas : { "01/01/2010" , "01/01/2011" , "01/01/2012" , "01/01/2013" , "01/01/2014" };
	DimV FechaHORA : { "31/12/2009 23:59:59" , "31/12/2010 23:59:59", "31/12/2011 23:59:59"};
	
	si(tipo==1){
		retornar numeros;
	}
	si(tipo==2){
		retornar nombres;
	}
	si(tipo ==3){
		retornar Fechas;
	}
	si(tipo ==3){
		retornar FechaHORA;
	}
}

funcion operar1(){
	operador(1,1);
}

funcion operar2(){
	operador(1,2);
}

funcion operar3(){
	operador(1,3);
}

funcion operar4(){
	operador(1,4);
}

funcion operar5(){
	operador(1,5);
}

funcion operar6(){
	operador(1,6);
}

funcion operar7(){
	operador(1,7);
}

funcion operar8(){
	operador(1,8);
}

funcion operar9(){
	operador(1,9);
}

funcion operar0(){
	operador(1,0);
}

funcion operarpunto(){
	operador(1,".");
}

funcion operarmas(){
	operador(2,"+");
}

funcion operarmenos(){
	operador(2,"-");
}

funcion operarpor(){
	operador(2,"*");
}

funcion operardiv(){
	operador(2,"/");
}

funcion operarLimpiar(){
	operador(2,"Limpiar");
}

funcion operarigual(){
	operador(2,"igual");
}

funcion operador(tipo,valor){

	textoCalcular : textoCalcular + valor;

	si(tipo==1){
		darValor(valor);
	}
	
	si(tipo==2){
		operar(valor);
	}
		
}

funcion darValor(valor){
	
	si(valor == "."){
		ContadorPunto++;
		contador : 1;
	}
	
	si(ContadorPunto == 0){
		Selecciona ( turno ){
			Caso 0 :
				si(contador == 0){
					Valor1 : valor;
					contador++;
				}
				sino{
					Valor1 : (Valor1 * 10 * contador) + valor;
					contador++;
				}
				detener;
			Caso 1 :
				si(contador == 0){
					Valor2 : valor;
					contador++;
				}
				sino{
					Valor2 : (Valor2 * 10 * contador) + valor;
					contador++;
				}
				detener;
			Defecto :				
				mensaje("Error no es posible operar");
				detener;
		}
	}
	sino{
		si(ContadorPunto==1){
			Selecciona ( turno ){
				Caso 0 :
					si(contador == 1){
						ValorPunto : valor / 10;
						Valor1 : Valor1 + valorPunto;
						contador++;
					}
					sino{
						ValorPunto : valor / ( 10 * contador);
						Valor1 : Valor1 + valorPunto;
						contador++;
					}
					detener;
				Caso 1 :
					si(contador == 1){
						ValorPunto : valor / 10;
						Valor2 : Valor1 + valorPunto;
						contador++;
					}
					sino{
						ValorPunto : valor / ( 10 * contador);
						Valor2 : Valor1 + valorPunto;
						contador++;
					}
					detener;
				Defecto:					
					mensaje("Error no es posible operar");
					detener;
			}
		}
		sino{			
			mensaje("Error no es posible operar mas de un punto");
		}
	}
	
}

funcion operar(operador){

	si ( valor1 != "" && valor2 == "") {
		operadorAnterior : operador;
	}
	
	si ( valor1 != "" && valor2 != ""){
		Selecciona (operadorAnterior){
			
			Caso "+":
				Resultado : Valor1 + Valor2;
				Valor1 : Resultado;
				operadorAnterior : operador;				
				mensaje(Resultado);
				detener;
			Caso "-":
				Resultado : Valor1 - Valor2;
				Valor1 : Resultado;
				operadorAnterior : operador;
				mensaje(Resultado);
				detener;
			Caso "*":
				Resultado : Valor1 * Valor2;
				Valor1 : Resultado;
				operadorAnterior : operador;
				mensaje(Resultado);
				detener;
			Caso "/":
				Resultado : Valor1 / Valor2;
				Valor1 : Resultado;
				operadorAnterior : operador;
				mensaje(Resultado);
				detener;
			Caso "Limpiar":
				Valor1 : "";
				Valor2 : "";
				Resultado : "";
				Contador : 0;
				ContadorPunto : 0;
				ValorPunto: 0;
				turno : 0;
				textoCalcular : "";
				operadorAnterior : "";
				detener;
				mensaje(" ");
			Caso "igual":
				mensaje(Resultado);
				Valor1 : "";
				Valor2 : "";
				Resultado : "";
				Contador : 0;
				ContadorPunto : 0;
				ValorPunto: 0;
				turno : 0;
				textoCalcular : "";
				operadorAnterior : "";
				detener;
		}
	}
	Sino{
		Valor1 : "";
		Valor2 : "";
		Resultado : "";
		Contador : 0;
		ContadorPunto : 0;
		ValorPunto: 0;
		turno : 0;
		textoCalcular : " ";
		operadorAnterior : " ";
		mensaje("No es posible operar sin operandos");
	}
}
