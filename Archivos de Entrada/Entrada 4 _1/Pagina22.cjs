'/ 
	Mensaje de Bienvenida
/'
DimV menos_uno: -1;
si (menos_uno == -1){
	Mensaje("Se calificara la Pagina de Operaciones");
}
sino{
	IMPRIMIR("No funciono el mensaje");
}



dimv Arr_gen_num : {100, 95, 2, -9, 88, 25, 75, 2, 3, -2, 30, 68, 78, 101, 0, -2, 6, 8, 11, 33, 252, 103, 36, 49, -1, 69, 71, 192, 213, 0, 88, 96, 1, -100};
dimv Arr_lle_num {24};

dimv Arr_gen_cad : {"cas", "pp", "iii", "qqqq", "ffff", "vvv", "zzz", "aaa", "lll", "iii", "xxx", "hhhh", "sss", "uuu", "yyy", "eee", "dddd", "ooo", "fff", "cas"};
dimv Arr_lle_cad {24};
dimv recorrido : 0;

dimv recorrido : 0;
dimv posicion : 0;
limpiar_Arreglos();

funcion insertar(num, cad){
	si (posicion > 23){
		mensaje("Se lleno el arreglo - Limpie y vuelva a llenar");
	}
	sino {
		Arr_lle_num {posicion} : num;
		Arr_lle_cad {posicion} : cad;
		posicion++;
	}
}

funcion limpiar_Arreglos(){
	dimv i : 0;
	mientras(i < 25){
		Arr_lle_cad {i} : "--";
		Arr_lle_num {i} : 0;
		i++;
		si (i == 24){
			detener;
		}
	}
	Arr_gen_num : {100, 95, 2, -9, 88, 25, 75, 2, 3, -2, 30, 68, 78, 101, 0, -2, 6, 8, 11, 33, 252, 103, 36, 49, -1, 69, 71, 192, 213, 0, 88, 96, 1, -100};
	Arr_gen_cad : {"cas", "pp", "iii", "qqqq", "ffff", "vvv", "zzz", "aaa", "lll", "iii", "xxx", "hhhh", "sss", "uuu", "yyy", "eee", "dddd", "ooo", "fff", "cas"};
}

funcion sequentialSearch(element, array){
	dimv i;
  para (i : 0; i < array.conteo; ++ ){
    si (array {i} == element){
    	retornar i; 
    }
  }
  return (-1);
}

funcion binarySearch(array, item ){
  	dimv low : 0;
  	dimv high : array.conteo - 1;

	mientras(low <= high) {
		dimv middle : (low + high) / 2;
	    dimv guess : array {middle};

	  	recorrido ++;
	  	Imprimir("Recorrido " + recorrido);
	    
	    si(guess == item ){
	      	retornar middle;
	    }
	    si(guess > item){
	      	high : middle - 1;
	    } else {
	      	low : middle + 1;
	    }
	}
  	retornar (-1);
}

funcion burbuja(arreglo){
	dimv aux;
	dimv i;
    Para(i : 0; i < ( arreglo.Conteo - 1); ++){
    	dimv j;
	    PARA(j : 0; j < ( arreglo.conTEO - i); ++){
	        sI( arreglo {j} > arreglo {j + 1} ){
	            aux : arreglo {j};
	            arreglo {j} : arreglo {j + 1};
	            arreglo {j + 1} : aux;
	        }
	    }
	}
    retornar arreglo
}


funcion quicksort(primero,ultimo){
    dimv i : primero
    dimv j : ultimo
    dimv pivote : arreglo {(i + j) / 2};

	dimv aux;
    mientras(arreglo {i} < pivote){
    	i ++;        
    }
    mientras(arreglo {j} > pivote){
        j --;
    }

    si(i <= j){
        aux : arreglo {j};
        arreglo{j} : arreglo {i};
        arreglo{i} : aux;
        i++;
        j--;
    }
    mientras (i < j){
        mientras(arreglo {i} < pivote){
        	i ++;        
        }
        mientras(arreglo {j} > pivote){
            j --;
        }
        si(i <= j){
            aux : arreglo {j};
            arreglo{j} : arreglo {i};
            arreglo{i} : aux;
            i++;
            j--;
        }
    }
    si ( primero < j){
        quicksort( primero, j);
    }              
    si( ultimo > i){
        quicksort(i,ultimo);
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

DImv boton_3;
DImv boton_33;
DIMV boton_2;

funcion espuma(){
	dimv arr_1 : burbuja(Arr_gen_num.Conteo);
	dimv arr_2 : burbuja(Arr_gen_cad.Conteo);
	imprimir("======================== Arreglos Genericos ========================");
	imprimir(arr_1.aTexto());
	imprimir(arr_2.aTexto());


	dimv arr_1 : burbuja(Arr_lle_num.Conteo);
	dimv arr_2 : burbuja(Arr_lle_cad.Conteo);
	imprimir("======================== Arreglos Llenados ========================");
	imprimir(arr_1.aTexto());
	imprimir(arr_2.aTexto());

	imprimir("*******************************************************************");
}

funcion rapido(){
	quicksort(0, Arr_gen_num.Conteo);
	quicksort(0, Arr_gen_cad.Conteo);
	imprimir("======================== Arreglos Genericos ========================");
	imprimir(Arr_gen_num.aTexto());
	imprimir(Arr_gen_cad.aTexto());


	quicksort(0, Arr_lle_num.Conteo);
	quicksort(0, Arr_lle_cad.Conteo);
	imprimir("======================== Arreglos Llenados ========================");
	imprimir(Arr_lle_num.aTexto());
	imprimir(Arr_lle_cad.aTexto());

	imprimir("*******************************************************************");
}

funcion BusquedaBina(){
	imprimir("======================== BINARIA ========================");
	imprimir("======================== Arreglos Genericos ========================");
	imprimir("La busqueda Bina de 68 " + binarySearch(Arr_gen_num, 68));
	imprimir("La Busqueda bina de sss " + binarySearch(Arr_gen_cad, "sss"));


	binarySearch(0, Arr_lle_num.Conteo);
	binarySearch(0, Arr_lle_cad.Conteo);
	imprimir("======================== Arreglos Llenados ========================");
	imprimir("La busqueda Bina de 0 " + binarySearch(Arr_lle_num, 0));
	imprimir("La Busqueda bina de p " + binarySearch(Arr_lle_cad, "p"));
	imprimir("*******************************************************************");
}

funcion BusquedaLineal(){
	imprimir("======================== LINEAL ========================");
	imprimir("======================== Arreglos Genericos ========================");
	imprimir("La busqueda Bina de 68 " + sequentialSearch(68, Arr_gen_num, 68));
	imprimir("La Busqueda bina de sss " + sequentialSearch("sss", Arr_gen_cad));


	binarySearch(0, Arr_lle_num.Conteo);
	binarySearch(0, Arr_lle_cad.Conteo);
	imprimir("======================== Arreglos Llenados ========================");
	imprimir("La busqueda Bina de 0 " + sequentialSearch(0, Arr_lle_num));
	imprimir("La Busqueda bina de p " + sequentialSearch("p", Arr_lle_cad));
	imprimir("*******************************************************************");
}
Documento.Observador("listo", funcion(){ 
	Imprimir("================= Documento Cargo Completo ===================="); 

	boton_2 : Documento.Obtener("boton_2");
	boton_2.Observador("click", rapido());

	boton_3 : Documento.Obtener("boton_3");
	boton_3.Observador("click", BusquedaBina());

	boton_33 : Documento.Obtener("boton_33");
	boton_33.Observador("click", BusquedaLineal());


	boton_val1 : Documento.Obtener("boton_val1");
	boton_val1.Observador("click", insertar(-10, 'f'));
	
	boton_val2 : Documento.Obtener("boton_val2");
	boton_val2.Observador("click", insertar(-3, "c"));
	
	boton_val3 : Documento.Obtener("boton_val3");
	boton_val3.Observador("click", insertar(-1, "v"));
	
	boton_val4 : Documento.Obtener("boton_val4");
	boton_val4.Observador("click", insertar(0, "i"));


	boton_val5 : Documento.Obtener("boton_val5");
	boton_val5.Observador("click", insertar(7, "q"));
	
	boton_val6 : Documento.Obtener("boton_val6");
	boton_val6.Observador("click", insertar(11, "p"));
	
	boton_val7 : Documento.Obtener("boton_val7");
	boton_val7.Observador("click", insertar(17, "l"));
	
	boton_val8 : Documento.Obtener("boton_val8");
	boton_val8.Observador("click", insertar(19, "j"));

	
	boton_val9 : Documento.Obtener("boton_val9");
	boton_val9.Observador("click", insertar(23, "a"));
	
	boton_val10 : Documento.Obtener("boton_val10");
	boton_val10.Observador("click", insertar(35, "i"));
	
	boton_val11 : Documento.Obtener("boton_val11");
	boton_val11.Observador("click", insertar(42, "k"));
	
	boton_val12 : Documento.Obtener("boton_val12");
	boton_val12.Observador("click", insertar(55, "t"));

	
	boton_val13 : Documento.Obtener("boton_val13");
	boton_val13.Observador("click", insertar(68, "s"));
	
	boton_val14 : Documento.Obtener("boton_val14");
	boton_val14.Observador("click", insertar(72, "d"));
	
	boton_val15 : Documento.Obtener("boton_val15");
	boton_val15.Observador("click", insertar(76, "u"));
	
	boton_val16 : Documento.Obtener("boton_val16");
	boton_val16.Observador("click", insertar(82, "e"));

	
	boton_val17 : Documento.Obtener("boton_val17");
	boton_val17.Observador("click", insertar(88, "m"));
	
	boton_val18 : Documento.Obtener("boton_val18");
	boton_val18.Observador("click", insertar(90, "r"));
	
	boton_val19 : Documento.Obtener("boton_val19");
	boton_val19.Observador("click", insertar(93, "g"));
	
	boton_val20 : Documento.Obtener("boton_val20");
	boton_val20.Observador("click", insertar(100, "b"));
});

