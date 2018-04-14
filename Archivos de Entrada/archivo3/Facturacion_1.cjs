dimv Vproducto{200};

dimv sub_total : 0.0;
dimv MVproducto{24};
dimv MVPproducto{24};
dimv Cproducto {24}; 
dimv precioprod {24}; 

dimv cliente_producto {24};
Iniciar();

funcion Iniciar(){
	'dimv i;
	para(i : 0; i < 24; ++){
		Cproducto {i} : 0;
		MVproducto {i} : 0;
		MVPproducto {i} : 0;
		cliente_producto {i} : 0;
		precioprod {i} : 0;
	}

	para(j : 0; j < 200; ++){
		Vproducto {j} : 0;
	}
	sub_total : 0;
}

funcion Producto_MasVendido_MVP(uno){
	dimv aux;
	'dimv i;
	Para(i : 0; i < ( uno.Conteo - 1); ++){
		dimv j;
	    PARA(j : 0; j < ( uno.conTEO - i); ++){
	        sI( uno {j} > uno {j + 1} ){
	            aux : uno {j};
	            uno {j} : uno {j + 1};
	            uno {j + 1} : aux;
	        }
	    }
	}
	retornar uno;
}

funcion Agregar(numero, pago){
	MVproducto{numero - 1}: MVproducto{numero - 1} + 1;
	MVPproducto{numero - 1}: MVPproducto{numero - 1} + pago;
	precioprod{numero - 1}: pago;
}

funcion Generar_Factura(){
	Imprimir("Cantidad		Producto 		Precio 			Sub-Total 		");
	'dimv i;
	para (i : 0; i < 24; ++){
		si(MVproducto{i} > 0){
			Imprimir(MVproducto + "		Producto " + i + "		" + precioprod + "		" + (MVproducto * MVPproducto) + "		");
		}
	}
	dimv total : 0;

	para (j : 0; j < 24; ++){
		total : total + (MVproducto{j} * MVPproducto{j});
	}
	Imprimir("Total ---------------------------------------|" + total);
	mensaje("El total del producto  -----------------------|" + total);
}

funcion Subtota_Cantidad(){
	Imprimir("Cantidad		Producto");
	'dimv i;
	para (i : 0; i < 24; ++){
		si(MVproducto{i} > 0){
			Imprimir(MVproducto + "		Producto " + i);
		}
	}
}
funcion Subtota_Precio(){
	Imprimir("Producto			Sub-Total 		");
	'dimv i;
	para (i : 0; i < 24; ++){
		si(MVproducto{i} > 0){
			Imprimir("Producto " + i + "		" + (MVproducto{0} * MVPproducto{0}) + "		");
		}
	}
}

funcion Mas_Vendido(){
	'dimv uno = MVproducto;
	dimv aux;
	'dimv i;
	Para(i : 0; i < ( MVproducto.Conteo - 1); ++){
		'dimv j;
	    PARA(j : 0; j < ( MVproducto.conTEO - i); ++){
	        sI( MVproducto {j} > MVproducto {j + 1} ){
	            aux : MVproducto {j};
	            MVproducto {j} : MVproducto {j + 1};
	            MVproducto {j + 1} : aux;
	        }
	    }
	}

	'dimv mas : Producto_MasVendido_MVP(MVproducto{0});
	'dimv i : 0;
	para (i : 0; i < 24; ++){
		si(MVproducto{i}  == uno{0}){
			detener;
		}
	}

	Imprimir("El Mas vendido producto " + i +"  -----------------------|" + mas{0});
	mensaje("El Mas vendido producto " + i +"  -----------------------|" + mas{0});
}


funcion Mas_Vendido_Precio(){
	dimv mas : Producto_MasVendido_MVP(MVPproducto);
	'dimv i : 0;
	para (i : 0; i < 24; ++){
		si(MVPproducto{i}  == mas{0}){
			detener;
		}
	}

	Imprimir("El Mas vendido producto Precio " + i +"  -----------------------|" + mas{0});
	mensaje("El Mas vendido producto Precio " + i +"  -----------------------|" + mas{0});
}


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
dimv imagen_val_29	;
dimv imagen_val_30	;
dimv imagen_val_31	;
dimv imagen_val_32	;

Documento.Observador("listo", funcion(){ 
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
	imagen_val_29 : Documento.Obtener("imagen_val29");
	imagen_val_30 : Documento.Obtener("imagen_val30");
	imagen_val_31 : Documento.Obtener("imagen_val31");
	imagen_val_32 : Documento.Obtener("imagen_val32");
	imagen_val_1	.	Observador("click", 	Agregar(1, 280.34091	 ));
	imagen_val_2	.	Observador("click", 	Agregar(2, 376.92501	 ));
	imagen_val_3	.	Observador("click", 	Agregar(3, 326.60076	 ));
	imagen_val_4	.	Observador("click", 	Agregar(4, 279.46966	 ));
	imagen_val_5	.	Observador("click", 	Agregar(5, 611.29364	 ));
	imagen_val_6	.	Observador("click", 	Agregar(6, 207.46584	 ));
	imagen_val_7	.	Observador("click", 	Agregar(7, 502.80511	 ));
	imagen_val_8	.	Observador("click", 	Agregar(8, 529.40028	 ));
	imagen_val_9	.	Observador("click", 	Agregar(9, 767.35706	 ));
	imagen_val_10	.	Observador("click", 	Agregar(10, 436.49233	 ));
	imagen_val_11	.	Observador("click", 	Agregar(11, 295.29121	 ));
	imagen_val_12	.	Observador("click", 	Agregar(12, 120.49290	 ));
	imagen_val_13	.	Observador("click", 	Agregar(13, 735.98830	 ));
	imagen_val_14	.	Observador("click", 	Agregar(14, 314.68643	 ));
	imagen_val_15	.	Observador("click", 	Agregar(15, 564.06235	 ));
	imagen_val_16	.	Observador("click", 	Agregar(16, 455.67376	 ));
	imagen_val_17	.	Observador("click", 	Agregar(17, 412.72437	 ));
	imagen_val_18	.	Observador("click", 	Agregar(18, 291.81490	 ));
	imagen_val_19	.	Observador("click", 	Agregar(19, 129.01259	 ));
	imagen_val_20	.	Observador("click", 	Agregar(20, 969.11180	 ));
	imagen_val_21	.	Observador("click", 	Agregar(21, 563.56718	 ));
	imagen_val_22	.	Observador("click", 	Agregar(22, 208.72156	 ));
	imagen_val_23	.	Observador("click", 	Agregar(23, 429.82646	 ));
	imagen_val_24	.	Observador("click", 	Agregar(24, 464.76238	 ));
	imagen_val_25	.	Observador("click", 	Agregar(25, 464.75710	 ));
	imagen_val_26	.	Observador("click", 	Agregar(26, 97.24169	 ));
	imagen_val_27	.	Observador("click", 	Agregar(27, 234.43768	 ));
	imagen_val_28	.	Observador("click", 	Agregar(28, 599.83597	 ));
	imagen_val_29	.	Observador("click", 	Agregar(29, 99.52232	 ));
	imagen_val_30	.	Observador("click", 	Agregar(30, 946.69027	 ));
	imagen_val_31	.	Observador("click", 	Agregar(31, 804.86916	 ));
	imagen_val_32	.	Observador("click", 	Agregar(32, 478.23704	 ));


});


