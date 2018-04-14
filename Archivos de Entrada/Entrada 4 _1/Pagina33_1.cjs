
dimv Vector_minus : {
			"a", "b", "c", "d", "e", 
			"f", "g", "h", "i", "j", 
			"k", "l", "ll", "m", "n", 
			"o", "p", "q", "r", "s", 
			"t", "u", "v", "w", "x", 
			"y", "z" };


dimv Vector_mayus: {
			"A", "B", "C", "D", "E", 
			"F", "G", "H", "I", "J", 
			"K", "L", "L", "M", "N", 
			"O", "P", "Q", "R", "S", 
			"T", "U", "V", "W", "X", 
			"Y", "Z" };

dimv Vector_num : {
			1, 2, 3, 4, 5, 
			6, 7, 8, 9, 0, 
			"+", "-", "*", "/", "_", 
			"{", "}", ".", ">", "<", 
			";", ":", "=", "%", " ", 
			"(", ")" };

funcion Para_Anidado(numero){
	dimv a;
	para (a : 0; a < numero; ++){
		dimv b;
		para (b: 0; b < a; ++){
			dimv c;
			para (c : 0; c < b; ++){
				dimv d;
				para (d : 0; d < c; ++){
					dimv e;
					para (e : 0; e < d; ++){
						dimv ax : e;
						si(e+1 == d){
							mientras(e > 0){
								imprimir (" EW: " + e);
								si (e == 1){
									imprimir (" Salio en 1 *********-----******");
								}
								e--;
							}
						}
						e : ax;
						imprimir (" E: " + e);
					}
					imprimir (" D: " + d);
				}
				imprimir (" C: " + c);
			}
			imprimir (" B: " + b);
		}
		imprimir (" A: " + a);
	}
}

dimv casos; 
dimv estados;
dimv tipo : 0;
dimv pagina : 1;
dimv vectorGrafo {30};
dimv vectortipo {30};
dimv posicion : 0;


funcion Anidado(){
	Para_Anidado(vectorGrafo{0});
}


funcion limpiar_Arreglos(){
	posicion : 0;
	dimv i;
	para (i : 0; i < 30; ++){
		vectorGrafo {i} : 0;
		vectortipo {i} : 0;
	}
}

funcion CambioPagina(){
	selecciona (pagina){
		caso 1:
			pagina : 2;
			detener;
		caso 2:
			pagina : 3;
			DETERNER;
		caso 3:
			pagina : 1;
			detener;
	}
}

funcion LLenar(numero, tipo){
	si (posicion == 30){
		mensaje ("NO hay mas espacio en el vector");
		retornar;
	}
	vectortipo {posicion} : tipo;
	vectorGrafo {posicion} : numero;
}


dimv Cadena : "";
funcion Grafo(){
	dimv pos_2 : 0;
	while(1 == 1){
		Selecciona (pos_2){
			caso 0:
				si (vectortipo{pos_2} == 1){
					Cadena : Cadena + Vector_num{vectorGrafo {pos_2}};
					pos_2 ++;
					detener;
				}
				sino {
					si (vectortipo{pos_2} != 2){
						Cadena : Cadena + Vector_minus{vectorGrafo {pos_2}};
						pos_2 ++;
						detener;
					}
					si (vectortipo{pos_2} == 2){
						Cadena : Cadena + Vector_mayus{vectorGrafo {pos_2}};
						pos_2 ++;
						detener;
					}
					sino {
						imprimir ("no encontro el numero");
					}
				}
			caso 1:
				si (vectortipo{pos_2} == 1){
					Cadena : Cadena + Vector_num{vectorGrafo {pos_2}};
					pos_2 ++;
					detener;
				}
				sino {
					si (vectortipo{pos_2} != 2){
						Cadena : Cadena + Vector_minus{vectorGrafo {pos_2}};
						pos_2 ++;
						detener;
					}
					si (vectortipo{pos_2} == 2){
						Cadena : Cadena + Vector_mayus{vectorGrafo {pos_2}};
						pos_2 ++;
						detener;
					}
					sino {
						imprimir ("no encontro el numero");
					}
				}
			caso 2:
				si (vectortipo{pos_2} == 1){
					Cadena : Cadena + Vector_num{vectorGrafo {pos_2}};
					pos_2 ++;
					detener;
				}
				sino {
					si (vectortipo{pos_2} != 2){
						Cadena : Cadena + Vector_minus{vectorGrafo {pos_2}};
						pos_2 ++;
						detener;
					}
					si (vectortipo{pos_2} == 2){
						Cadena : Cadena + Vector_mayus{vectorGrafo {pos_2}};
						pos_2 ++;
						detener;
					}
					sino {
						imprimir ("no encontro el numero");
					}
				}
			caso 3:
				si (vectortipo{pos_2} == 1){
					Cadena : Cadena + Vector_num{vectorGrafo {pos_2}};
					pos_2 ++;
					detener;
				}
				sino {
					si (vectortipo{pos_2} != 2){
						Cadena : Cadena + Vector_minus{vectorGrafo {pos_2}};
						pos_2 ++;
						detener;
					}
					si (vectortipo{pos_2} == 2){
						Cadena : Cadena + Vector_mayus{vectorGrafo {pos_2}};
						pos_2 ++;
						detener;
					}
					sino {
						imprimir ("no encontro el numero");
					}
				}
			caso 4:
				si (vectortipo{pos_2} == 1){
					Cadena : Cadena + Vector_num{vectorGrafo {pos_2}};
					pos_2 ++;
					detener;
				}
				sino {
					si (vectortipo{pos_2} != 2){
						Cadena : Cadena + Vector_minus{vectorGrafo {pos_2}};
						pos_2 ++;
						detener;
					}
					si (vectortipo{pos_2} == 2){
						Cadena : Cadena + Vector_mayus{vectorGrafo {pos_2}};
						pos_2 ++;
						detener;
					}
					sino {
						imprimir ("no encontro el numero");
					}
				}
			caso 5:
				si (vectortipo{pos_2} == 1){
					Cadena : Cadena + Vector_num{vectorGrafo {pos_2}};
					pos_2 ++;
					detener;
				}
				sino {
					si (vectortipo{pos_2} != 2){
						Cadena : Cadena + Vector_minus{vectorGrafo {pos_2}};
						pos_2 ++;
						detener;
					}
					si (vectortipo{pos_2} == 2){
						Cadena : Cadena + Vector_mayus{vectorGrafo {pos_2}};
						pos_2 ++;
						detener;
					}
					sino {
						imprimir ("no encontro el numero");
					}
				}
			caso 6:
				si (vectortipo{pos_2} == 1){
					Cadena : Cadena + Vector_num{vectorGrafo {pos_2}};
					pos_2 ++;
					detener;
				}
				sino {
					si (vectortipo{pos_2} != 2){
						Cadena : Cadena + Vector_minus{vectorGrafo {pos_2}};
						pos_2 ++;
						detener;
					}
					si (vectortipo{pos_2} == 2){
						Cadena : Cadena + Vector_mayus{vectorGrafo {pos_2}};
						pos_2 ++;
						detener;
					}
					sino {
						imprimir ("no encontro el numero");
					}
				}
			caso 7:
				si (vectortipo{pos_2} == 1){
					Cadena : Cadena + Vector_num{vectorGrafo {pos_2}};
					pos_2 ++;
					detener;
				}
				sino {
					si (vectortipo{pos_2} != 2){
						Cadena : Cadena + Vector_minus{vectorGrafo {pos_2}};
						pos_2 ++;
						detener;
					}
					si (vectortipo{pos_2} == 2){
						Cadena : Cadena + Vector_mayus{vectorGrafo {pos_2}};
						pos_2 ++;
						detener;
					}
					sino {
						imprimir ("no encontro el numero");
					}
				}
			caso 8:
				si (vectortipo{pos_2} == 1){
					Cadena : Cadena + Vector_num{vectorGrafo {pos_2}};
					pos_2 ++;
					detener;
				}
				sino {
					si (vectortipo{pos_2} != 2){
						Cadena : Cadena + Vector_minus{vectorGrafo {pos_2}};
						pos_2 ++;
						detener;
					}
					si (vectortipo{pos_2} == 2){
						Cadena : Cadena + Vector_mayus{vectorGrafo {pos_2}};
						pos_2 ++;
						detener;
					}
					sino {
						imprimir ("no encontro el numero");
					}
				}
			caso 9:
				si (vectortipo{pos_2} == 1){
					Cadena : Cadena + Vector_num{vectorGrafo {pos_2}};
					pos_2 ++;
					detener;
				}
				sino {
					si (vectortipo{pos_2} != 2){
						Cadena : Cadena + Vector_minus{vectorGrafo {pos_2}};
						pos_2 ++;
						detener;
					}
					si (vectortipo{pos_2} == 2){
						Cadena : Cadena + Vector_mayus{vectorGrafo {pos_2}};
						pos_2 ++;
						detener;
					}
					sino {
						imprimir ("no encontro el numero");
					}
				}
			caso 10:
				si (vectortipo{pos_2} == 1){
					Cadena : Cadena + Vector_num{vectorGrafo {pos_2}};
					pos_2 ++;
					detener;
				}
				sino {
					si (vectortipo{pos_2} != 2){
						Cadena : Cadena + Vector_minus{vectorGrafo {pos_2}};
						pos_2 ++;
						detener;
					}
					si (vectortipo{pos_2} == 2){
						Cadena : Cadena + Vector_mayus{vectorGrafo {pos_2}};
						pos_2 ++;
						detener;
					}
					sino {
						imprimir ("no encontro el numero");
					}
				}
			caso 11:
				pos_2 : Agregado();
				detener;
			caso 12:
				pos_2 : Agregado();
				detener;
			caso 13:
				pos_2 : Agregado();
				detener;
			caso 14:
				pos_2 : Agregado();
				detener;
			caso 15:
				pos_2 : Agregado();
				detener;
			caso 16:
				pos_2 : Agregado();
				detener;
			caso 17:
				pos_2 : Agregado();
				detener;
			caso 18:
				pos_2 : Agregado();
				detener;
			caso 19:
				pos_2 : Agregado();
				detener;
			caso 20:
				pos_2 : Agregado();
				detener;
			caso 21:
				pos_2 : Agregado();
				detener;
			caso 22:
				pos_2 : Agregado();
				detener;
			caso 23:
				pos_2 : Agregado();
				detener;
			caso 24:
				pos_2 : Agregado();
				detener;
			caso 25:
				pos_2 : Agregado();
				detener;
			caso 26:
				pos_2 : Agregado();
				detener;
			Defecto:
				pos_2 : Agregado();
				retornar;
		}
	}
}

funcion Agregado(){
	si (vectortipo{pos_2} == 1){
		Cadena : Cadena + Vector_num{vectorGrafo {pos_2}};
		pos_2 ++;
		retornar pos_2;
	}
	sino {
		si (vectortipo{pos_2} != 2){
			Cadena : Cadena + Vector_minus{vectorGrafo {pos_2}};
			pos_2 ++;
			retornar pos_2;
		}
		Cadena : Cadena + Vector_mayus{vectorGrafo {pos_2}};
		pos_2 ++;
		imprimir ("no encontro el numero");
		retornar pos_2;
	}
}

dimv cadena2 : "";
funcion SalidaVector(){
	dimv i;
	para (i : 0; i < 30; ++){
		si (vectortipo{i} == 1){
			cadena2 : cadena2 + Vector_num {i};
		}
		si (vectortipo{i} == 2){
			cadena2 : cadena2 + Vector_minus {i};
		}
		si (vectortipo{i} == 3){
			cadena2 : cadena2 + Vector_mayus {i};
		}
	}
}


Dimv boton_val1;
Dimv boton_val2;
Dimv boton_val3;
Dimv boton_val4;
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
Dimv boton_val17;
Dimv boton_val18;
Dimv boton_val19;
Dimv boton_val20;
Dimv boton_val21;
Dimv boton_val22;
Dimv boton_val23;
Dimv boton_val24;
Dimv boton_val25;
Dimv boton_val26;

Dimv boton_Grafo;

Documento.Observador("listo", funcion(){ 
	Imprimir("================= Documento Cargo Completo ===================="); 

	boton_Grafo : Documento.Obtener("boton_1");
	boton_Grafo.Observador("click", Grafo());



	boton_val1 : Documento.Obtener("boton_val1");
	boton_val1.Observador("click", LLenar(1, pagina));
	
	boton_val2 : Documento.Obtener("boton_val2");
	boton_val2.Observador("click", LLenar(2, pagina));
	
	boton_val3 : Documento.Obtener("boton_val3");
	boton_val3.Observador("click", LLenar(3, pagina));
	
	boton_val4 : Documento.Obtener("boton_val4");
	boton_val4.Observador("click", LLenar(4, pagina));


	boton_val5 : Documento.Obtener("boton_val5");
	boton_val5.Observador("click", LLenar(5, pagina));
	
	boton_val6 : Documento.Obtener("boton_val6");
	boton_val6.Observador("click", LLenar(6, pagina));
	
	boton_val7 : Documento.Obtener("boton_val7");
	boton_val7.Observador("click", LLenar(7, pagina));
	
	boton_val8 : Documento.Obtener("boton_val8");
	boton_val8.Observador("click", LLenar(8, pagina));

	
	boton_val9 : Documento.Obtener("boton_val9");
	boton_val9.Observador("click", LLenar(9, pagina));
	
	boton_val10 : Documento.Obtener("boton_val10");
	boton_val10.Observador("click", LLenar(10, pagina));
	
	boton_val11 : Documento.Obtener("boton_val11");
	boton_val11.Observador("click", LLenar(11, pagina));
	
	boton_val12 : Documento.Obtener("boton_val12");
	boton_val12.Observador("click", LLenar(12, pagina));

	
	boton_val13 : Documento.Obtener("boton_val13");
	boton_val13.Observador("click", LLenar(13, pagina));
	
	boton_val14 : Documento.Obtener("boton_val14");
	boton_val14.Observador("click", LLenar(14, pagina));
	
	boton_val15 : Documento.Obtener("boton_val15");
	boton_val15.Observador("click", LLenar(15, pagina));
	
	boton_val16 : Documento.Obtener("boton_val16");
	boton_val16.Observador("click", LLenar(16, pagina));

	
	boton_val17 : Documento.Obtener("boton_val17");
	boton_val17.Observador("click", LLenar(17, pagina));
	
	boton_val18 : Documento.Obtener("boton_val18");
	boton_val18.Observador("click", LLenar(18, pagina));
	
	boton_val19 : Documento.Obtener("boton_val19");
	boton_val19.Observador("click", LLenar(19, pagina));
	
	boton_val20 : Documento.Obtener("boton_val20");
	boton_val20.Observador("click", LLenar(20, pagina));

	boton_val20 : Documento.Obtener("boton_val21");
	boton_val20.Observador("click", LLenar(21, pagina));

	boton_val20 : Documento.Obtener("boton_val22");
	boton_val20.Observador("click", LLenar(22, pagina));

	boton_val20 : Documento.Obtener("boton_val23");
	boton_val20.Observador("click", LLenar(23, pagina));

	boton_val20 : Documento.Obtener("boton_val24");
	boton_val20.Observador("click", LLenar(24, pagina));

	boton_val20 : Documento.Obtener("boton_val25");
	boton_val20.Observador("click", LLenar(25, pagina));

	boton_val20 : Documento.Obtener("boton_val26");
	boton_val20.Observador("click", LLenar(26, pagina));

});

