package com.nb.nanotificacion.models.core;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EM {
	
	private static EntityManager em;
	
	private EM() {
		
	}
	
	public static void initManager(String... urlBD) {
		System.out.println("Inicializando en: "+urlBD);
		if(em == null || !em.isOpen()) {
			
			if(urlBD == null || urlBD.length == 0) {
				EntityManagerFactory enFactory = Persistence.createEntityManagerFactory("NaNotificacionesFinal");
				em = enFactory.createEntityManager();
			}else {
				HashMap<String,String> map = new HashMap<>();
				map.put("javax.persistence.jdbc.url", "jdbc:h2:"+urlBD[0]+";AUTO_SERVER=TRUE;AUTO_SERVER_PORT=9853;MVCC=true");
				EntityManagerFactory enFactory = Persistence.createEntityManagerFactory("NaNotificacionesFinal",map);
				em = enFactory.createEntityManager();
			}
			
			
		}
	}
	
	public static EntityManager getEm() {
		if(em == null || !em.isOpen()) {
			System.err.println("el \"EntityManager\" No esta inicializado, favor de inicializarlo con EM.initManager(String urlBD)");
			return null;
		}
		  
		
		return em;
	}

}
