funcion aceptarnotificaciones(){
	Mensaje("Felicidades a aceptado notificaciones, revise su correo proximante");
}

funcion infomazda()
{
	Mensaje("Rojo Platinado, perfecto para la noche");	
}

funcion infoMB(){
	Mensaje("Rapido y con mucho estilo");
}

funcion infotoyota(){
	Mensaje("Para sentirse protegido, no hay nada como mi toyota");
}


Dimv correlativo : 1;

funcion Enviar()
{
	Mensaje("Mensaje NO." + correlativo +" enviado correctamente");
}

funcion activarConexion(){
	dimv i;
	para (i:0;i<101;++){
		si(i%10==0)
		{
			Mensaje("Cargando " + i+"%");	
		}
	}
	Enviar();
	aceptarnotificaciones();
	correlativo : correlativo + 1;
}