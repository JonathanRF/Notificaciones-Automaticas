package com.nb.nanotificacion.core;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class Ln extends Properties{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String url;
	
	
	
	
	public Ln(String url) {
		super();
		this.url = url;
		
	}

	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
		
		
	}
	
	
	
	public Properties loadProperties() throws FileNotFoundException, IOException {
		return loadProperties(url);
	}
	
	public Properties loadProperties(String url) throws FileNotFoundException, IOException {
		load(new FileReader(url));
		return this;
	}
	
	public void inicializaIdiomaEspa() throws IOException {
		
	
		
			//System.out.println("Inicializando Idioma español");
			//System.out.println("en: "+this.url);
			try {
				//Copiando archivo de propiedades
				
				InputStream ps = Ln.class.getResource("/com/nb/nanotificacion/resources/idiomas/esp.properties").openStream();
				FileOutputStream destino = new FileOutputStream(this.url);
				int c;
				while( (c = ps.read() )!=-1) {
					//System.out.println(c);
					destino.write(c);
				}
				destino.close();
				load(ps);
				ps.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		
	}
	
	
	
}
