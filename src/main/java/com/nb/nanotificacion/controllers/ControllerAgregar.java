package com.nb.nanotificacion.controllers;

import java.util.List;

import com.nb.nanotificacion.models.TiempoNotificacion;

public class ControllerAgregar {
	
	
	public static  List<TiempoNotificacion> getPrioridad(){
		
		List<TiempoNotificacion> notificaciones = TiempoNotificacion.findAll();
	
		notificaciones.add(0, new TiempoNotificacion(0L, "", "",true));
		
		return notificaciones;
	}

}
