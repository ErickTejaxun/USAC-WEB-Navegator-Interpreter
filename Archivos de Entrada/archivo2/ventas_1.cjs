funcion aceptarnotificaciones()
{
	Mensaje("Felicidades a aceptado notificaciones, revise su correo proximante");
}

funcion infomazda(){
	Mensaje("Rojo Platinado, perfecto para la noche");	
}

funcion infoMB(){
	Mensaje("Rapido y con mucho estilo");
}

funcion infotoyota(){
	Mensaje("Para sentirse protegido, no hay nada como mi toyota");
}


Dimv correlativo : 1;
funcion Enviar(){
	Mensaje("Mensaje NO." + correlativo +" enviado correctamente");
}

funcion activarConexion(){
	Mensaje("si estoy");
	dimv j:0;
	para (j:0;j<101;++)
	{
		si(j%10==0)
		{
			Mensaje("Cargando--" + j+"%");	
		}
	}
	Enviar();
	aceptarnotificaciones();
	correlativo : correlativo + 1;
}




dimv totalcarros : 5;
dimv contadorcarro:0;
dimv monto:0;
dimv vectorPrecios{5};
'Esta variable debe marcar error cada vez que se usa
dimv carrosdisponibles :0 ;
dimv montodisponible;

funcion monto1(){
	montodisponible: 250000;  

	Mensaje("Tiene disponible " + montodisponible);
}

funcion monto2(){
	montodisponible:400000;Mensaje("Tiene disponible " + montodisponible);
}


funcion validarprecio(disponible)
{
	si(disponible < montodisponible && disponible>=0 )
	{				
		retornar "true";				
	}sino
	{
		retornar "false";
	}
}

funcion validartotalAutos(disponible){
	si(disponible < totalcarros && disponible>=0)
	{
		
		retornar "true";

	}sino{
		retornar "false";
	}
}

funcion buy_mazda(){
	dimv precio : 25000;
	
	si (validarprecio(montodisponible - 25000) == "true" && validartotalAutos(totalcarros - 1)== "true"){
		montodisponible : montodisponible -25000;		
		totalcarros : totalcarros -1 ;
		vectorPrecios{contadorcarro}: precio;
		contadorcarro : contadorcarro + 1 ;
		carrosdisponibles : carrosdisponibles + 1;
		monto : monto + precio;
		mensaje(montodisponible);
		Mensaje("Compraste un Mazda");
	}sino{
	Mensaje("Unicamente le quedan Q"+ montodisponible);
	}

}
funcion buy_toyota(){
	dimv precio : 39000;
	si (validarprecio(montodisponible - precio)== "true" && validartotalAutos(totalcarros - 1)== "true"){
		montodisponible : montodisponible -precio;
		totalcarros : totalcarros -1 ;
		vectorPrecios{contadorcarro}: precio;
		contadorcarro : contadorcarro + 1 ;
		carrosdisponibles : carrosdisponibles + 1;
		monto : monto + precio;
		mensaje(montodisponible);
		Mensaje("Compraste un Toyota");
	}sino{
	Mensaje("Unicamente le quedan Q"+ montodisponible);
	}
	
}
funcion buy_ford(){
	dimv precio : 55000;
	si (validarprecio(montodisponible - precio)=="true" && validartotalAutos(totalcarros - 1)=="true"){
		montodisponible : montodisponible -precio;
		totalcarros : totalcarros -1 ;
		vectorPrecios{contadorcarro}: precio;
		contadorcarro : contadorcarro + 1 ;
		carrosdisponibles : carrosdisponibles + 1;
		monto : monto + precio;
		mensaje(montodisponible);
		Mensaje("Compraste un Ford");
	}sino{
	Mensaje("Unicamente le quedan Q"+montodisponible);
	}
	
}
funcion btn_meches(){
	dimv precio : 54000;
	si (validarprecio(montodisponible - precio)== "true" && validartotalAutos(totalcarros - 1)== "true"){
		montodisponible : montodisponible -precio;
		totalcarros : totalcarros -1 ;
		vectorPrecios{contadorcarro}: precio;
		contadorcarro : contadorcarro + 1 ;
		carrosdisponibles : carrosdisponibles + 1;
		monto : monto + precio;
		mensaje(montodisponible);
		Mensaje("Compraste un Mercedez");
	}sino{
	Mensaje("Unicamente le quedan Q"+ montodisponible);
	}
}

funcion ordenarburbuja(){
	dimv i;
	dimv j;
	dimv aux;
	para(i : 0; i< vectorPrecios.conteo();++)
	{
        para(j :0;j<vectorPrecios.conteo() - 1;++)
        {
            si(vectorPrecios{j} > vectorPrecios{j+1})
            {
                 aux : vectorPrecios{j};
                 vectorPrecios{j} : vectorPrecios{j+1};
                 vectorPrecios{j+1} :aux;
            }
        }
    }
    imprimir(vectorPrecios.atexto());
    mensaje(vectorPrecios.atexto());
}
