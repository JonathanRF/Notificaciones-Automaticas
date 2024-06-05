package com.nb.nanotificacion.core;

import java.awt.Color;

import javax.swing.JOptionPane;

import com.nb.nanotificacion.views.jframe.VentanaNotificacion;
import com.nb.nanotificacion.views.jframe.VentanaPrincipal;

public class Core {
	private VentanaPrincipal ventanaPrincipal;
	private VentanaNotificacion notificacion;
	private Ln idioma;
	private CoreJob coreJob;
	private static Core singleton;
	
	private Core(VentanaNotificacion ventanaNotificacion) {
		this.notificacion = ventanaNotificacion;
	}
	private Core(VentanaPrincipal ventanaPrincipal,VentanaNotificacion notificacion) {
		this.ventanaPrincipal = ventanaPrincipal;
		this.notificacion = notificacion;
	}
	
	public static Core instanciaCore() {
		if(singleton == null) {
			singleton = new Core(new VentanaNotificacion());
			
		}else {
			System.err.println("No se puede reinstanciar el objeto");
		}
		
		return singleton;
	}
	
	public static Core instanciaCore(VentanaPrincipal ventanaPrincipal) {
		if(singleton == null) {
			
			singleton = new Core(ventanaPrincipal,new VentanaNotificacion());
		}else {
			System.err.println("No se puede reinstanciar el objeto");
		}
		
		return singleton;
	}
	
	public static Core getCore() {
		return singleton;
	}
	
	public void resetLog() {
		singleton.ventanaPrincipal.getLbLog().setForeground(new Color(128, 128, 128));
		singleton.ventanaPrincipal.getLbLog().setText("");
	}
	
	public void setErrorPanel(String error) {
		setErrorPanel(error, "Ocurrio un error");
	}
	public void setErrorPanel(String error,String titulo) {
		JOptionPane.showMessageDialog(ventanaPrincipal, error, titulo, JOptionPane.ERROR_MESSAGE);
	}
    
	public void setError(String error) {
		resetLog();
		singleton.ventanaPrincipal.getLbLog().setForeground(new Color(220, 20, 60));
		singleton.ventanaPrincipal.getLbLog().setText(error);
		
	}
	public void setInfo(String info) {
		resetLog();
		singleton.ventanaPrincipal.getLbLog().setForeground(new Color(128, 128, 128));
		singleton.ventanaPrincipal.getLbLog().setText(info);
		
	}
	
	
	public CoreJob getCoreJob() {
		return coreJob;
	}

	public void setCoreJob(CoreJob coreJob) {
		this.coreJob = coreJob;
	}

	public VentanaPrincipal getVentanaPrincipal() {
		return ventanaPrincipal;
	}

	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public VentanaNotificacion getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(VentanaNotificacion notificacion) {
		this.notificacion = notificacion;
	}

	public Ln getIdioma() {
		return idioma;
	}

	public void setIdioma(Ln idioma) {
		this.idioma = idioma;
	}
	
    
	
	
 
}
