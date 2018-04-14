dimv 	boton_val1	;
dimv 	boton_val2	;
dimv 	boton_val3	;
dimv 	boton_val4	;
dimv 	boton_val5	;
dimv 	boton_val6	;
dimv 	boton_val7	;
dimv 	boton_val8	;
dimv 	boton_val9	;
dimv 	boton_val10	;
dimv 	boton_val11	;
dimv 	boton_val12	;
dimv 	boton_val13	;
dimv 	boton_val14	;
dimv 	boton_val15	;
dimv 	boton_val16	;
dimv 	boton_val17	;
dimv 	boton_val18	;
dimv 	boton_val19	;
dimv 	boton_val20	;

Documento.Observador("listo", funcion1(){
	boton_val1	 : 	Documento.Obtener("boton_val1");
	boton_val2	 : 	Documento.Obtener("boton_val2");
	boton_val3	 : 	Documento.Obtener("boton_val3");
	boton_val4	 : 	Documento.Obtener("boton_val4");
	boton_val5	 : 	Documento.Obtener("boton_val5");
	boton_val6	 : 	Documento.Obtener("boton_val6");
	boton_val7	 : 	Documento.Obtener("boton_val7");
	boton_val8	 : 	Documento.Obtener("boton_val8");
	boton_val9	 : 	Documento.Obtener("boton_val9");
	boton_val10	 : 	Documento.Obtener("boton_val10");
	boton_val11	 : 	Documento.Obtener("boton_val11");
	boton_val12	 : 	Documento.Obtener("boton_val12");
	boton_val13	 : 	Documento.Obtener("boton_val13");
	boton_val14	 : 	Documento.Obtener("boton_val14");
	boton_val15	 : 	Documento.Obtener("boton_val15");
	boton_val16	 : 	Documento.Obtener("boton_val16");
	boton_val17	 : 	Documento.Obtener("boton_val17");
	boton_val18	 : 	Documento.Obtener("boton_val18");
	boton_val19	 : 	Documento.Obtener("boton_val19");
	boton_val20	 : 	Documento.Obtener("boton_val20");

	boton_val1	.	Observador("click", 	CambioGrupo(1	,1	 ));
	boton_val2	.	Observador("click", 	CambioGrupo(2	,2	 ));
	boton_val3	.	Observador("click", 	CambioGrupo(3	,3	 ));
	boton_val4	.	Observador("click", 	CambioGrupo(4	,4	 ));
	boton_val5	.	Observador("click", 	CambioGrupo(5	,5	 ));
	boton_val6	.	Observador("click", 	CambioGrupo(6	,6	 ));
	boton_val7	.	Observador("click", 	CambioGrupo(7	,7	 ));
	boton_val8	.	Observador("click", 	CambioGrupo(8	,8	 ));
	boton_val9	.	Observador("click", 	CambioGrupo(9	,9	 ));
	boton_val10	.	Observador("click", 	CambioGrupo(10	,10	 ));
	boton_val11	.	Observador("click", 	CambioGrupo(11	,11	 ));
	boton_val12	.	Observador("click", 	CambioGrupo(12	,12	 ));
	boton_val13	.	Observador("click", 	CambioGrupo(13	,13	 ));
	boton_val14	.	Observador("click", 	CambioGrupo(14	,14	 ));
	boton_val15	.	Observador("click", 	CambioGrupo(15	,15	 ));
	boton_val16	.	Observador("click", 	CambioGrupo(16	,16	 ));
	boton_val17	.	Observador("click", 	CambioGrupo(17	,17	 ));
	boton_val18	.	Observador("click", 	CambioGrupo(18	,18	 ));
	boton_val19	.	Observador("click", 	CambioGrupo(19	,19	 ));
	boton_val20	.	Observador("click", 	CambioGrupo(20	,20	 ));

}); 
@

funcion CambioGrupo(numero, boton)
{
	si(numero <= 10 && boton <= 10){
		Documento.Obtener("usuario"). setElemento ("grupo", "boton_val" + numero);		
	}
	sino{
		Documento.Obtener("mensaje"). setElemento ("grupo", "boton_val" + numero);	
	}

	dimv ruta_imagen : "C:\Archivos de Entrada\archivo3\producto\imagen";
	selecciona(numero){
		caso 1:
			Documento.Obtener("imagen_id"). setElemento ("ruta", ruta_imagen + numero + ".PNG");
			detener;
		caso 2:
			Documento.Obtener("imagen_id"). setElemento ("ruta", ruta_imagen + numero + ".PNG");
			detener;
		caso 3:
			Documento.Obtener("imagen_id"). setElemento ("ruta", ruta_imagen + numero + ".PNG");
			detener;
		caso 4:
			Documento.Obtener("imagen_id"). setElemento ("ruta", ruta_imagen + numero + ".PNG");
			detener;
		caso 5:
			Documento.Obtener("imagen_id"). setElemento ("ruta", ruta_imagen + numero + ".PNG");
			detener;
		caso 6:
			Documento.Obtener("imagen_id"). setElemento ("ruta", ruta_imagen + numero + ".PNG");
			detener;
		caso 7:
			Documento.Obtener("imagen_id"). setElemento ("ruta", ruta_imagen + numero + ".PNG");
			detener;
		caso 8:
			Documento.Obtener("imagen_id"). setElemento ("ruta", ruta_imagen + numero + ".PNG");
			detener;
		caso 9:
			Documento.Obtener("imagen_id"). setElemento ("ruta", ruta_imagen + numero + ".PNG");
			detener;
		caso 10:
			Documento.Obtener("imagen_id"). setElemento ("ruta", ruta_imagen + numero + ".PNG");
			detener;
	}
}

dimv oculto : "True";
funcion Ocultar(){	
	si(oculto == "True"){
		oculto : "False";
		Documento.Obtener("oculto"). setElemento ("grupo", "no_ocultar");	
		Documento.Obtener("usuario"). setElemento ("grupo", "no_ocultar");	
		Documento.Obtener("mensaje"). setElemento ("grupo", "no_ocultar");	
	}
	sino {
		oculto : "True";
		Documento.Obtener("oculto"). setElemento ("grupo", "ocultar");	
		Documento.Obtener("usuario"). setElemento ("grupo", "ocultar");	
		Documento.Obtener("mensaje"). setElemento ("grupo", "ocultar");	
	}
	
}

funcion Mensajes(){
	Mensaje("Saludos .....");
}