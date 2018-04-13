DimV menos_uno: -1;
Dimv recursivo : "False";
Dimv salida : 0;
Dimv Operacion: 0;



si (menos_uno == -1){
	Mensaje("Se calificara la Pagina de Operaciones");
}
sino{
	IMPRIMIR("No funciono el mensaje");
}

funcion cambio_recursivo(){		
	recursivo : !(recursivo);
}

funcion factorial_recursivo(num)
{
    si (num < 0) { 
    	Retornar -1;
    }
    sino { 
    	si (num == 0) {
	        retornar 1;
	    }
	    sino {
	        retornar (num * factorial_recursivo(num - 1));
	    }
    }
}

funcion factorial_no_recursivo(num)
{
    si (num < 0) {
        retornar -1;
    }
    sino{
    	si (num == 0) {
	        retornar 1;
	    }
    }

    dimv tmp : num;
    MIENTRAS (num-- > 2) {
        tmp : tmp * num;
    }
    RETORNAR tmp;
}

funcion fibonacci_no_recursivo(num){
  dimv a : 1;
  diMV b : 0;
  DIMV tmp;

  mientras (num >= 0){
    tmp : a;
    a : a + b;
    b : tmp;
    num--;
  }
  RETORNAR b;
}

funcion fibonacci_recursivo(num) {
  si (num <= 1){
  	retornar 1;
  }
  retORnar fibonacci_recursivo(num - 1) + fibonacci_recursivo(num - 2);
}

Dimv boton_cambio;

Documento.Observador("listo", funcion(){ 
	Imprimir("================= Documento Cargo Completo ===================="); 
	boton_cambio : Documento.Obtener("boton_cambio");
	boton_cambio.Observador("click", cambio_recursivo());
});

funcion Operacion1(){
	
	operacion : -1;
}

funcion Operacion2(){
	operacion : 1;
}

funcion Operar(num, correcto){
	
	dimv tipo : " nada";
	si (operacion == -1){ '/se opera factorial /'
		si (recursivo == "False"){
			salida : factorial_no_recursivo(num);
			tipo : " NO Recursivo";
		}
		si (recursivo == "True"){
			salida : factorial_recursivo(num);
			tipo : " Recursivo";
		}
		sino{
			salida : 0;
		}
		imprIMir("El Factorial Operado de " + num + " : " + salida + tipo);
		imprIMir("El Factorial Correcto de " + num + ": " + correcto + tipo);
	}
	si (operacion == 1){ '/se opera fibonacci /'
		si (recursivo == "False"){
			salida : fibonacci_no_recursivo(num);
			tipo : " NO Recursivo";
		}
		si (recursivo == "True"){
			salida : fibonacci_recursivo(num);
			tipo : " Recursivo";
		}
		sino{
			salida : 0;
		}
		imprIMir("El Factorial Operado de " + num + " : " + salida + tipo);
		imprIMir("El Factorial Correcto de " + num + ": " + correcto + tipo);
	}sino
	{
		imprIMir("No se eligio operacion Correcta");
	}
}




funcion Boton_6(){
	si (operacion == -1){
		Operar(6, 720);
	}
	si (operacion == 1){
		Operar(6, 13);
	}
	sino{
		imprIMir("No se eligio operacion Correcta");
	}
	operacion : 0;
}

funcion Boton_5(){
	
	si (operacion == -1){
		Operar(5, 120);
	}
	si (operacion == 1){
		Operar(5, 8);
	}
	sino{
		imprIMir("No se eligio operacion Correcta");
	}
	operacion : 0;
}

funcion Boton_7(){
	si (operacion == -1){
		Operar(7, 5040);
	}
	si (operacion == 1){
		Operar(7, 21);
	}
	sino{
		imprIMir("No se eligio operacion Correcta");
	}
	operacion : 0;
}

funcion Boton_8(){
	si (operacion == -1){
		Operar(8, 40320);
	}
	si (operacion == 1){
		Operar(8, 34);
	}
	sino{
		imprIMir("No se eligio operacion Correcta");
	}
	operacion : 0;
}

funcion Boton_9(){
	si (operacion == -1){
		Operar(9, 362880);
	}
	si (operacion == 1){
		Operar(9, 55);
	}
	sino{
		imprIMir("No se eligio operacion Correcta");
	}
	operacion : 0;
}

funcion Boton_10(){
	si (operacion == -1){
		Operar(10, 3628800);
	}
	si (operacion == 1){
		Operar(10, 89);
	}
	sino{
		imprIMir("No se eligio operacion Correcta");
	}
	operacion : 0;
}

funcion Boton_11(){
	si (operacion == -1){
		Operar(11, 39916800);
	}
	si (operacion == 1){
		Operar(11, 144);
	}
	sino{
		imprIMir("No se eligio operacion Correcta");
	}
	operacion : 0;
}

funcion Boton_12(){
	si (operacion == -1){
		Operar(12, 479001600);
	}
	si (operacion == 1){
		Operar(12, 233);
	}
	sino{
		imprIMir("No se eligio operacion Correcta");
	}
	operacion : 0;
}

funcion Boton_13(){
	si (operacion == -1){
		Operar(13, 6227020800);
	}
	si (operacion == 1){
		Operar(13, 377);
	}
	sino{
		imprIMir("No se eligio operacion Correcta");
	}
	operacion : 0;
}

funcion Boton_14(){
	si (operacion == -1){
		Operar(14, 87178291200);
	}
	si (operacion == 1){
		Operar(14, 610);
	}
	sino{
		imprIMir("No se eligio operacion Correcta");
	}
	operacion : 0;
}

funcion Boton_15(){
	si (operacion == -1){
		Operar(15, 1307674368000);
	}
	si (operacion == 1){
		Operar(15, 987);
	}
	sino{
		imprIMir("No se eligio operacion Correcta");
	}
	operacion : 0;
}

funcion Boton_16(){
	si (operacion == -1){
		Operar(16, 20922789888000);
	}
	si (operacion == 1){
		Operar(16, 1597);
	}
	sino{
		imprIMir("No se eligio operacion Correcta");
	}
	operacion : 0;
}





Dimv boton_val5;
Dimv boton_val6;
Dimv boton_val7;
Dimv boton_val8;
Dimv boton_val9;
Dimv boton_val10;
Dimv boton_val11;
Dimv boton_val12;
Dimv boton_val13;
Dimv boton_val14;
Dimv boton_val15;
Dimv boton_val16;

Documento.Observador("listo", funcion(){ 
	Imprimir("================= Documento Cargo Completo ===================="); 

	boton_val5 : Documento.Obtener("boton_operacion_5");
	boton_val5.Observador("click", Boton_5());

	boton_val6 : Documento.Obtener("boton_operacion_6");
	boton_val6.Observador("click", Boton_6());
	
	boton_val7 : Documento.Obtener("boton_operacion_7");
	boton_val7.Observador("click", Boton_7());
	
	boton_val8 : Documento.Obtener("boton_operacion_8");
	boton_val8.Observador("click", Boton_8());

	
	boton_val9 : Documento.Obtener("boton_operacion_9");
	boton_val9.Observador("click", Boton_9());
	
	boton_val10 : Documento.Obtener("boton_operacion_10");
	boton_val10.Observador("click", Boton_10());
	
	boton_val11 : Documento.Obtener("boton_operacion_11");
	boton_val11.Observador("click", Boton_11());
	
	boton_val12 : Documento.Obtener("boton_operacion_12");
	boton_val12.Observador("click", Boton_12());

	
	boton_val13 : Documento.Obtener("boton_operacion_13");
	boton_val13.Observador("click", Boton_13());
	
	boton_val14 : Documento.Obtener("boton_operacion_14");
	boton_val14.Observador("click", Boton_14());
	
	boton_val15 : Documento.Obtener("boton_operacion_15");
	boton_val15.Observador("click", Boton_15());
	
	boton_val16 : Documento.Obtener("boton_operacion_16");
	boton_val16.Observador("click", Boton_16());

});




