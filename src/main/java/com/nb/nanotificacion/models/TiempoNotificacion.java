package com.nb.nanotificacion.models;

import java.util.List;

import javax.persistence.Entity;

import com.nb.nanotificacion.models.core.Model;

@Entity(name="tiempo_notificacion")
public class TiempoNotificacion extends Model{
	
	
	private String nombre;
	private String cron;
	
	 
	
	public TiempoNotificacion() {
		super();
		
	}
	
	

	public TiempoNotificacion(String nombre, String cron) {
		super();
		this.nombre = nombre;
		this.cron = cron;
	}



	public TiempoNotificacion(Long id, String nombre, String cron,Boolean visible) {
		this.nombre = nombre;
		this.cron = cron;
	}
	
	
	
	public static List<TiempoNotificacion> findAll(){
		
		return TiempoNotificacion._findAll(TiempoNotificacion.class);
	}
	
	public static TiempoNotificacion find(String jpql) {
		return _find(TiempoNotificacion.class, jpql);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nombre;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}



	
	
	
	

}
