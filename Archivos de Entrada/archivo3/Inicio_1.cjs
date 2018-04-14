'/ Declaracion de Variables - para objectos/'

dimv imagen_val_1 	;
dimv imagen_val_2	;
dimv imagen_val_3	;
dimv imagen_val_4	;
dimv imagen_val_5	;
dimv imagen_val_6	;
dimv imagen_val_7	;
dimv imagen_val_8	;
dimv imagen_val_9	;
dimv imagen_val_10	;
dimv imagen_val_11	;
dimv imagen_val_12	;
dimv imagen_val_13	;
dimv imagen_val_14	;
dimv imagen_val_15	;
dimv imagen_val_16	;
dimv imagen_val_17	;
dimv imagen_val_18	;
dimv imagen_val_19	;
dimv imagen_val_20	;
dimv imagen_val_21	;
dimv imagen_val_22	;
dimv imagen_val_23	;
dimv imagen_val_24	;
dimv imagen_val_25	;
dimv imagen_val_26	;
dimv imagen_val_27	;
dimv imagen_val_28	;

dimv imagen_id : "imagen_id";
dimv ruta_imagen : "C:\Archivos de Entrada\archivo3\producto\imagen";
funcion CambioImagen(numero)
{
	Documento.Obtener(imagen_id).setElemento("ruta", ruta_imagen + numero + ".png");
}

Documento.Observador("listo", funcion1(){ 
	imagen_val_1 : Documento.Obtener("imagen_val1");
	imagen_val_2 : Documento.Obtener("imagen_val2");
	imagen_val_3 : Documento.Obtener("imagen_val3");
	imagen_val_4 : Documento.Obtener("imagen_val4");
	imagen_val_5 : Documento.Obtener("imagen_val5");
	imagen_val_6 : Documento.Obtener("imagen_val6");
	imagen_val_7 : Documento.Obtener("imagen_val7");
	imagen_val_8 : Documento.Obtener("imagen_val8");
	imagen_val_9 : Documento.Obtener("imagen_val9");
	imagen_val_10 : Documento.Obtener("imagen_val10");
	imagen_val_11 : Documento.Obtener("imagen_val11");
	imagen_val_12 : Documento.Obtener("imagen_val12");
	imagen_val_13 : Documento.Obtener("imagen_val13");
	imagen_val_14 : Documento.Obtener("imagen_val14");
	imagen_val_15 : Documento.Obtener("imagen_val15");
	imagen_val_16 : Documento.Obtener("imagen_val16");
	imagen_val_17 : Documento.Obtener("imagen_val17");
	imagen_val_18 : Documento.Obtener("imagen_val18");
	imagen_val_19 : Documento.Obtener("imagen_val19");
	imagen_val_20 : Documento.Obtener("imagen_val20");
	imagen_val_21 : Documento.Obtener("imagen_val21");
	imagen_val_22 : Documento.Obtener("imagen_val22");
	imagen_val_23 : Documento.Obtener("imagen_val23");
	imagen_val_24 : Documento.Obtener("imagen_val24");
	imagen_val_25 : Documento.Obtener("imagen_val25");
	imagen_val_26 : Documento.Obtener("imagen_val26");
	imagen_val_27 : Documento.Obtener("imagen_val27");
	imagen_val_28 : Documento.Obtener("imagen_val28");

	imagen_val_1.Observador("click", 	CambioImagen(1) );
	imagen_val_2.Observador("click", 	CambioImagen(2) );
	imagen_val_3.Observador("click", 	CambioImagen(3) );
	imagen_val_4	.	Observador("click", 	CambioImagen(4) );
	imagen_val_5	.	Observador("click", 	CambioImagen(5) );
	imagen_val_6	.	Observador("click", 	CambioImagen(6) );
	imagen_val_7	.	Observador("click", 	CambioImagen(7) );
	imagen_val_8	.	Observador("click", 	CambioImagen(8) );
	imagen_val_9	.	Observador("click", 	CambioImagen(9) );
	imagen_val_10	.	Observador("click", 	CambioImagen(10) );
	imagen_val_11	.	Observador("click", 	CambioImagen(11) );
	imagen_val_12	.	Observador("click", 	CambioImagen(12) );
	imagen_val_13	.	Observador("click", 	CambioImagen(13) );
	imagen_val_14	.	Observador("click", 	CambioImagen(14) );
	imagen_val_15	.	Observador("click", 	CambioImagen(15) );
	imagen_val_16	.	Observador("click", 	CambioImagen(16) );
	imagen_val_17	.	Observador("click", 	CambioImagen(17) );
	imagen_val_18	.	Observador("click", 	CambioImagen(18) );
	imagen_val_19	.	Observador("click", 	CambioImagen(19) );
	imagen_val_20	.	Observador("click", 	CambioImagen(20) );
	imagen_val_21	.	Observador("click", 	CambioImagen(21) );
	imagen_val_22	.	Observador("click", 	CambioImagen(22) );
	imagen_val_23	.	Observador("click", 	CambioImagen(23) );
	imagen_val_24	.	Observador("click", 	CambioImagen(24) );
	imagen_val_25	.	Observador("click", 	CambioImagen(25) );
	imagen_val_26	.	Observador("click", 	CambioImagen(26) );
	imagen_val_27	.	Observador("click", 	CambioImagen(27) );
	imagen_val_28	.	Observador("click", 	CambioImagen(28) );
});

