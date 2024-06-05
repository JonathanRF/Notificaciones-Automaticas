package com.nb.nanotificacion.views.panels;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import java.awt.Color;

import javax.swing.border.EmptyBorder;

import com.nb.nanotificacion.core.Core;

import javax.swing.Icon;

public class PanelPrincipal extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane;
	private PanelNotificaciones panelNotificaciones;
	private PanelAgregaNotificacion panelAgregaNotificacion;
	private PanelNotificacionesTarjetas panelNotificacionesTarjetas;

	/**
	 * Create the panel.
	 */
	public PanelPrincipal() {
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		add(tabbedPane, BorderLayout.CENTER);

		// tabbedPane.addChangeListener(new ChangeListener() {
		//
		// @Override
		// public void stateChanged(ChangeEvent e) {
		// // TODO Auto-generated method stub
		// System.out.println(e.getSource());
		// }
		// });

		panelNotificaciones = new PanelNotificaciones();
		panelNotificaciones.setBackground(Color.WHITE);
//		tabbedPane.addTab(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.views.panels.PanelPrincipal.text1", "Notificaciones"), null,
//				panelNotificaciones, null);
		
		panelNotificacionesTarjetas = new PanelNotificacionesTarjetas();
		tabbedPane.addTab(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.views.panels.PanelPrincipal.text1", "Notificaciones"), null,
				panelNotificacionesTarjetas, null);

		PanelAgregar panelAgregar = new PanelAgregar();
		panelAgregar.setBackground(Color.WHITE);
		tabbedPane.addTab(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.views.panels.PanelPrincipal.text2",
				"Agregar notificaciones predefinidas"), null, panelAgregar, null);

		panelAgregaNotificacion = new PanelAgregaNotificacion();
		tabbedPane.addTab(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.views.panels.PanelPrincipal.text3",
				"Agregar notificaciones personalizadas"), (Icon) null, panelAgregaNotificacion, null);

	}

	public PanelNotificaciones getPanelNotificaciones() {
		return panelNotificaciones;
	}

	public PanelNotificacionesTarjetas getPanelNotificacionesTarjetas() {
		return panelNotificacionesTarjetas;
	}

	
	
	
}
