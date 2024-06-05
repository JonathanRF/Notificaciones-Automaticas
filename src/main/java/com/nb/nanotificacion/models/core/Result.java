package com.nb.nanotificacion.models.core;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;


/**
 * 
 * @author Jonathan Ramos Fragoso
 *
 * @param <T>
 */
public class Result<T> extends MotorModel{
	
	List<T> results;
	Query query;

	public Result(Query query) {
		super();
		this.query = query;
		
	}
    
	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}
	
	@SuppressWarnings({ "unchecked", "hiding" })
	public <T extends MotorModel> List<T> all(){
		
		List<T> result = new ArrayList<>();
		if(query!=null) {
			if(!query.getResultList().isEmpty()) {
				return (List<T>) query.getResultList();
			}else {
				return result;
			}
		}
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public T first() {
		if(query!= null) {
			if(query.getResultList()!=null) {
				if(!query.getResultList().isEmpty()) {
					return (T) query.getResultList().get(0);
				}
			}
		}
		return null;
	}
	
	
	
}
