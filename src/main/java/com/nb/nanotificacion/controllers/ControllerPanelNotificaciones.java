package com.nb.nanotificacion.controllers;

import java.util.List;

import com.nb.nanotificacion.models.Notificacion;

public class ControllerPanelNotificaciones {

	public static List<Notificacion> getAllNotificaciones(){
		List<Notificacion> not = Notificacion.findAll();
		//List<Notificacion> not = new ArrayList<>();
		return not;
	}
	
}
