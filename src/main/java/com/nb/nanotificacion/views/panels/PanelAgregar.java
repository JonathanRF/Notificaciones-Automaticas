package com.nb.nanotificacion.views.panels;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;

import org.quartz.CronExpression;

import com.nb.nanotificacion.controllers.ControllerAgregar;
import com.nb.nanotificacion.core.Core;
import com.nb.nanotificacion.models.Notificacion;
import com.nb.nanotificacion.models.TiempoNotificacion;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAgregar extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JComboBox<TiempoNotificacion> cBPrioridadNoti;
	private JTextArea txAComentarios;
	private JTextField txTitulo;
	private JPanel panelNotificacion;
	private JTextField textFieldExpresion;
	private JTextField textFieldNombre;

	
	public PanelAgregar() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		panelNotificacion = new JPanel();
		panelNotificacion.setBackground(Color.WHITE);
		panelNotificacion.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(30, 144, 255), new Color(65, 105, 225)), "Notificaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		GridBagConstraints gbc_panelNotificacion = new GridBagConstraints();
		gbc_panelNotificacion.fill = GridBagConstraints.BOTH;
		gbc_panelNotificacion.gridx = 0;
		gbc_panelNotificacion.gridy = 0;
		add(panelNotificacion, gbc_panelNotificacion);
		GridBagLayout gbl_panelNotificacion = new GridBagLayout();
		gbl_panelNotificacion.columnWidths = new int[]{0, 0, 0};
		gbl_panelNotificacion.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panelNotificacion.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panelNotificacion.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panelNotificacion.setLayout(gbl_panelNotificacion);
		
		JLabel lblPeriodoNotificacion = new JLabel("Periodo de Notificaci\u00F3n");
		lblPeriodoNotificacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblPeriodoNotificacion = new GridBagConstraints();
		gbc_lblPeriodoNotificacion.anchor = GridBagConstraints.WEST;
		gbc_lblPeriodoNotificacion.insets = new Insets(2, 0, 0, 5);
		gbc_lblPeriodoNotificacion.gridx = 0;
		gbc_lblPeriodoNotificacion.gridy = 0;
		panelNotificacion.add(lblPeriodoNotificacion, gbc_lblPeriodoNotificacion);
		
		cBPrioridadNoti = new JComboBox<TiempoNotificacion>();
		
		
		GridBagConstraints gbc_cBPrioridadNoti = new GridBagConstraints();
		gbc_cBPrioridadNoti.insets = new Insets(0, 0, 5, 0);
		gbc_cBPrioridadNoti.fill = GridBagConstraints.HORIZONTAL;
		gbc_cBPrioridadNoti.gridx = 1;
		gbc_cBPrioridadNoti.gridy = 0;
		panelNotificacion.add(cBPrioridadNoti, gbc_cBPrioridadNoti);
		
		JLabel lblNotificacion = new JLabel("Titulo:");
		lblNotificacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNotificacion = new GridBagConstraints();
		gbc_lblNotificacion.anchor = GridBagConstraints.WEST;
		gbc_lblNotificacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblNotificacion.gridx = 0;
		gbc_lblNotificacion.gridy = 1;
		panelNotificacion.add(lblNotificacion, gbc_lblNotificacion);
		
		txTitulo = new JTextField();
		GridBagConstraints gbc_txTitulo = new GridBagConstraints();
		gbc_txTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_txTitulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txTitulo.gridx = 1;
		gbc_txTitulo.gridy = 1;
		panelNotificacion.add(txTitulo, gbc_txTitulo);
		txTitulo.setColumns(10);
		
		JLabel lblComentario = new JLabel("Comentario:");
		lblComentario.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblComentario = new GridBagConstraints();
		gbc_lblComentario.fill = GridBagConstraints.VERTICAL;
		gbc_lblComentario.anchor = GridBagConstraints.WEST;
		gbc_lblComentario.insets = new Insets(0, 0, 5, 5);
		gbc_lblComentario.gridx = 0;
		gbc_lblComentario.gridy = 2;
		panelNotificacion.add(lblComentario, gbc_lblComentario);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		panelNotificacion.add(scrollPane, gbc_scrollPane);
		
		txAComentarios = new JTextArea();
		txAComentarios.setWrapStyleWord(true);
		txAComentarios.setLineWrap(true);
		
		scrollPane.setViewportView(txAComentarios);
		
		JButton btnAgregar = new JButton("Agregar Notificaci\u00F3n");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Core.getCore().resetLog();
					TiempoNotificacion prioridad = (TiempoNotificacion)cBPrioridadNoti.getSelectedItem();
					//System.out.println("Elemento: "+prioridad.getId());
					if(prioridad.getId() == null) {
						//System.out.println("ES 0");
						Core.getCore().setError("Error: Selecciona una prioridad para la notificacion");
					}else {
						Notificacion nNoti = new Notificacion(txTitulo.getText().trim(), txAComentarios.getText().trim(), prioridad).save();
					    
						//Agregando nueva notificacion
						
//					     
//					     Core.getCore().getVentanaPrincipal().getPanelPrincipal().getPanelNotificaciones().getModelo().addRow(new Object[] {
//					    		 nNoti.getPrioridad().getNombre(),nNoti.getNombre(),nNoti.getComentarios(),false,nNoti.getId()
//					     });
					     
					     Core.getCore().getVentanaPrincipal().getPanelPrincipal().getPanelNotificacionesTarjetas().AddNotificacion(nNoti);
					     Core.getCore().getCoreJob().AddJob(nNoti);
					     JOptionPane.showMessageDialog(Core.getCore().getVentanaPrincipal(), "Se agrego la notificacion correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
					     cBPrioridadNoti.setSelectedIndex(0);
					     txAComentarios.setText("");
					     txTitulo.setText("");
					     //System.out.println("Elemento Guardado: "+nNoti.getId());
					     
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					JOptionPane.showMessageDialog(Core.getCore().getVentanaPrincipal(), "ER: "+e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}
		});
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.anchor = GridBagConstraints.EAST;
		gbc_btnAgregar.gridx = 1;
		gbc_btnAgregar.gridy = 4;
		panelNotificacion.add(btnAgregar, gbc_btnAgregar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(30, 144, 255), new Color(65, 105, 225)), "Periodo de Notificaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		panel_1.add(lblNombre, gbc_lblNombre);
		
		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridx = 1;
		gbc_textFieldNombre.gridy = 0;
		panel_1.add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblExpresionCron = new JLabel("Expresion cron");
		lblExpresionCron.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblExpresionCron = new GridBagConstraints();
		gbc_lblExpresionCron.anchor = GridBagConstraints.EAST;
		gbc_lblExpresionCron.insets = new Insets(0, 0, 5, 5);
		gbc_lblExpresionCron.gridx = 0;
		gbc_lblExpresionCron.gridy = 1;
		panel_1.add(lblExpresionCron, gbc_lblExpresionCron);
		
		textFieldExpresion = new JTextField();
		GridBagConstraints gbc_textFieldExpresion = new GridBagConstraints();
		gbc_textFieldExpresion.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldExpresion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldExpresion.gridx = 1;
		gbc_textFieldExpresion.gridy = 1;
		panel_1.add(textFieldExpresion, gbc_textFieldExpresion);
		textFieldExpresion.setColumns(10);
		
		JButton btnAgregarCron = new JButton("Agregar Cron");
		btnAgregarCron.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				if(!CronExpression.isValidExpression(textFieldExpresion.getText().trim())) {
					Core.getCore().resetLog();
					Core.getCore().setError("Expresion no valida, por favor verifica");
					JOptionPane.showMessageDialog(Core.getCore().getVentanaPrincipal(), "Expresion no valida, por favor verifica", "Error", JOptionPane.ERROR_MESSAGE);
					Core.getCore().resetLog();
					textFieldExpresion.requestFocus();
				}else {
					if(textFieldNombre.getText().trim().isEmpty()) {
						Core.getCore().resetLog();
						Core.getCore().setError("Ingresa un nombre");
						JOptionPane.showMessageDialog(Core.getCore().getVentanaPrincipal(), "Ingresa un nombre", "Error", JOptionPane.ERROR_MESSAGE);
						textFieldNombre.requestFocus();
						Core.getCore().resetLog();
					}else {
						//validando que no exista el mismo cron en la BD
				        TiempoNotificacion tiempo =  TiempoNotificacion.find("Select e from tiempo_notificacion e where e.nombre = '"+textFieldNombre.getText().trim()+"' AND e.cron = '"+textFieldExpresion.getText().trim()+"'");
				        if(tiempo != null) {
				        	JOptionPane.showMessageDialog(Core.getCore().getVentanaPrincipal(), "No se puede agregar \""+textFieldNombre.getText().trim()+"\" ya existe", "Error", JOptionPane.ERROR_MESSAGE);
				        }else {
				        	tiempo = new TiempoNotificacion(textFieldNombre.getText().trim(),textFieldExpresion.getText().trim());
				        	tiempo = tiempo.save();
				        	if(tiempo!=null) {
				        		cBPrioridadNoti.addItem(tiempo);
				        		textFieldNombre.setText("");
				        		textFieldExpresion.setText("");
				        		JOptionPane.showMessageDialog(Core.getCore().getVentanaPrincipal(), "Elemento agregado Correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
				        	}
				        }
				        //System.out.println(tiempo);
					}
				}
				
			}
		});
		GridBagConstraints gbc_btnAgregarCron = new GridBagConstraints();
		gbc_btnAgregarCron.anchor = GridBagConstraints.EAST;
		gbc_btnAgregarCron.gridx = 1;
		gbc_btnAgregarCron.gridy = 2;
		panel_1.add(btnAgregarCron, gbc_btnAgregarCron);
        cargaElementos();
	}
	
	
	public void cargaElementos() {
		//Obteniendo 
		//System.out.println("Cargando Elementos");
		for(TiempoNotificacion priori : ControllerAgregar.getPrioridad()) {
			//System.out.println(priori.getId());
			cBPrioridadNoti.addItem(priori);
		}
		
	}

}
