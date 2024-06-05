package com.nb.nanotificacion.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.nb.nanotificacion.models.core.Model;
import com.nb.nanotificacion.models.core.Result;

@Entity(name="notificacion")
public class Notificacion extends Model{
	
    @Column(length=300)
	private String nombre;
    @Column(length=5000)
	private String comentarios;
	@ManyToOne(optional=false)
	private TiempoNotificacion tiempoNotificacion;
	private String cron;
	
	public Notificacion() {}
	
	public Notificacion(String nombre, String comentarios, TiempoNotificacion tiempoNotificacion) {
		super();
		this.nombre = nombre;
		this.comentarios = comentarios;
		this.tiempoNotificacion = tiempoNotificacion;
		//this.prioridad = prioridad;
	}
	public Notificacion(String nombre, String comentarios, String cron) {
		super();
		this.nombre = nombre;
		this.comentarios = comentarios;
		this.cron = cron;
		//this.prioridad = prioridad;
	
	}
	
	public static Notificacion findById(Long id) {
		return Notificacion._findById(Notificacion.class, id);
	}
	
	public static Notificacion deleteById(Long id) {
		return Notificacion._deleteById(Notificacion.class, id);
	}
	
	public static List<Notificacion> findAll(){
		return Notificacion._findAll(Notificacion.class);
	}
	
	public static Notificacion find(String jpql) {
		return _find(Notificacion.class, jpql);
	}
	

	public static Result<Notificacion> find(String qr,Object... values) {
	   
		
		try {
			return Notificacion._find(Notificacion.class,qr,values);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	





	

	

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public TiempoNotificacion getPrioridad() {
		return tiempoNotificacion;
	}

	public void setPrioridad(TiempoNotificacion prioridad) {
		this.tiempoNotificacion = prioridad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

    
	

	

	
    
	
	


}
