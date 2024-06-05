package com.nb.nanotificacion.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.nb.nanotificacion.models.core.Model;
import com.nb.nanotificacion.models.core.Result;

@Entity(name="opciones")
public class Opciones extends Model {

	@Column(name="llave",length=200)
	private String llave;
	@Column(name="valor",length=500)
	private String valor;
	
	
	
	
	public Opciones() {
		super();
	}
	
	

	public Opciones(String llave, String valor) {
		super();
		this.llave = llave;
		this.valor = valor;
	}



	public static Opciones findById(Long id) {
		return Opciones._findById(Opciones.class, id);
	}
	

	public static Result<Opciones> find(String qr,Object... values) {
	   
		
		try {
			return Opciones._find(Opciones.class,qr,values);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static Opciones deleteById(Long id) {
		return Opciones._deleteById(Opciones.class, id);
	}
	
	public static List<Opciones> findAll(){
		return Opciones._findAll(Opciones.class);
	}



	public String getLlave() {
		return llave;
	}



	public void setLlave(String llave) {
		this.llave = llave;
	}



	public String getValor() {
		return valor;
	}



	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
	
	
}
