package com.nb.nanotificacion.models.core;

import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 
 * @author Jonathan Ramos Fragoso
 * 
 *
 */

@MappedSuperclass
public class Model extends MotorModel{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
	@SuppressWarnings("unchecked")
	public <T extends MotorModel> T save() {
		try {
			Object obj = this;
			EntityManager em = EM.getEm();
			em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();
		    return (T)obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void delete() {
		try {
			EntityManager em = EM.getEm();
			em.getTransaction().begin();
			Object res = null;
			if(getId() == null || getId() == 0l) {
				res = _findById(this.getClass(),this.getId());
			}else {
				res = this;
			}
			
			em.remove(res);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
