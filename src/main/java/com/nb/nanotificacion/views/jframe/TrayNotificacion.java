package com.nb.nanotificacion.views.jframe;

import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.nb.nanotificacion.core.Core;


public class TrayNotificacion {
	
	private static TrayNotificacion trayNotificacion;
	private TrayIcon tray ;
	private PopupMenu menu;
	private MenuItem salir;
	private MenuItem minimizar;
	private MenuItem mostrarNoti;

	private TrayNotificacion() throws Exception{
		if(tray == null) {
			if(!SystemTray.isSupported()) {
				throw new Exception("El sistema Tray no esta soportado por el S.O");
			}
			//Image img = Toolkit.getDefaultToolkit().getImage("/com/nb/nanotificacion/resources/fondo NA Notificacion.png");
			tray = new TrayIcon(Toolkit.getDefaultToolkit().getImage(TrayNotificacion.class.getResource("/com/nb/nanotificacion/resources/iconNaNo.png")),"NA Notificaciones");
			tray.setImageAutoSize(true);
			SystemTray tr = SystemTray.getSystemTray();
			//tray.setImageAutoSize(true);
			menu = new PopupMenu();
		
			salir = new MenuItem("Salir");
			
			minimizar = new MenuItem("Minimizar a bandeja");
		    mostrarNoti = new MenuItem("Mostrar Notificaciones");
		    menu.add(mostrarNoti);
		    menu.addSeparator();
			menu.add(minimizar);
			menu.addSeparator();
			menu.add(salir);
			
			tray.setPopupMenu(menu);
			
			mostrarNoti.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Core.getCore().getNotificacion().showNotificacion();
				}
			});
			minimizar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					if(Core.getCore().getVentanaPrincipal().isVisible()) {
						minimizar.setLabel("Restaurar ventana");
						
						Core.getCore().getVentanaPrincipal().setExtendedState(JFrame.MAXIMIZED_BOTH);
						Core.getCore().getVentanaPrincipal().setVisible(false);
					}else {
						minimizar.setLabel("Minimizar a bandeja");
						Core.getCore().getVentanaPrincipal().setVisible(true);
						
					}
				}
			});
			
			salir.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.exit(0);
				}
			});
			
			
			
			
			tr.add(tray);
			
			tray.displayMessage("NA Notificaciones", "Iniciando Sistema de Notificacion", TrayIcon.MessageType.INFO);
			
			
			
		}else {
			System.err.println("Warn: el tray ya esta inicializado");
		}
	}
	
	
	public static void initTray() throws Exception {
		if(trayNotificacion == null) {
			trayNotificacion = new TrayNotificacion();
		}
		
		
		
		
		
	}
	
	public static TrayNotificacion getTrayNotificacion() {
		if(trayNotificacion == null) {
			System.err.println("Error, no se ha inicializado el Sistema Tray ");
			return null;
		}
		
		return trayNotificacion;
	}


	public TrayIcon getTray() {
		return tray;
	}


	public void setTray(TrayIcon tray) {
		this.tray = tray;
	}


	public PopupMenu getMenu() {
		return menu;
	}


	public void setMenu(PopupMenu menu) {
		this.menu = menu;
	}


	public MenuItem getSalir() {
		return salir;
	}


	public void setSalir(MenuItem salir) {
		this.salir = salir;
	}


	public MenuItem getMinimizar() {
		return minimizar;
	}


	public void setMinimizar(MenuItem minimizar) {
		this.minimizar = minimizar;
	}


	public MenuItem getMostrarNoti() {
		return mostrarNoti;
	}


	public void setMostrarNoti(MenuItem mostrarNoti) {
		this.mostrarNoti = mostrarNoti;
	}
	
	
}
