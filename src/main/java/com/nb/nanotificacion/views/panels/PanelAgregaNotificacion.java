package com.nb.nanotificacion.views.panels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import java.awt.GridBagLayout;
import javax.swing.JTabbedPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.text.DecimalFormat;
//import java.util.List;

import javax.swing.JLabel;
//import javax.swing.ButtonGroup;
import javax.swing.JButton;
//import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.quartz.CronExpression;

import com.nb.nanotificacion.core.Core;
import com.nb.nanotificacion.models.Notificacion;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class PanelAgregaNotificacion extends JPanel implements ActionListener{

	
	private static final long serialVersionUID = 1L;
    private JTextField textField_1;
    private JButton BtnGuardar;
    private PanelSegundos panelSegundos;
    private PanelMinutos panelMinutos;
    private PanelHoras panelHoras;
    private PanelDias panelDias;
    private PanelMeses panelMeses;
    private PanelAn panelAn;
    private JTextField txfCron;
    private PanelVistaPrevia panelVistaPrevia;
    private JTextArea textArea;
	
	public PanelAgregaNotificacion() {
		//decimalFormat = new DecimalFormat("00");
		//optGroup = new ButtonGroup();
		setPreferredSize(new Dimension(550, 470));
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(30, 144, 255), new Color(65, 105, 225)), "Tiempo de Notificación", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.gridwidth = 3;
		gbc_tabbedPane.insets = new Insets(0, 0, 1, 0);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		add(tabbedPane, gbc_tabbedPane);
		
		panelSegundos = new PanelSegundos("com.nb.nanotificacion.views.panels.PanelSegundos");
		tabbedPane.addTab("Segundos", null, panelSegundos, null);
		
		panelMinutos = new PanelMinutos("com.nb.nanotificacion.views.panels.PanelMinutos");
		tabbedPane.addTab("Minutos", null, panelMinutos, null);
		
		panelHoras = new PanelHoras("com.nb.nanotificacion.views.panels.PanelHoras");
		tabbedPane.addTab("Horas", null, panelHoras, null);
		
		panelDias = new PanelDias("com.nb.nanotificacion.views.panels.PanelDias");
		tabbedPane.addTab("Dias", null, panelDias, null);
		
		panelMeses = new PanelMeses("com.nb.nanotificacion.views.panels.PanelMeses"); 
		tabbedPane.addTab("Mes", null, panelMeses, null);
		
		panelAn = new PanelAn("com.nb.nanotificacion.views.panels.PanelAn");
		tabbedPane.addTab("A\u00F1o", null, panelAn, null);
		
		panelVistaPrevia = new PanelVistaPrevia(this);
		tabbedPane.addTab("Vista Previa", null, panelVistaPrevia, null);
		
	
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(30, 144, 255), new Color(65, 105, 225)), "Notificaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.gridwidth = 3;
		gbc_panel_5.insets = new Insets(0, 0, 1, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 1;
		add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_5.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JLabel lblTitulo = new JLabel("Titulo");
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitulo.anchor = GridBagConstraints.WEST;
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		panel_5.add(lblTitulo, gbc_lblTitulo);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 0;
		panel_5.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblComentarios = new JLabel("Comentarios");
		GridBagConstraints gbc_lblComentarios = new GridBagConstraints();
		gbc_lblComentarios.anchor = GridBagConstraints.WEST;
		gbc_lblComentarios.insets = new Insets(0, 0, 5, 5);
		gbc_lblComentarios.gridx = 0;
		gbc_lblComentarios.gridy = 1;
		panel_5.add(lblComentarios, gbc_lblComentarios);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		panel_5.add(scrollPane, gbc_scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblExpresionCronn = new JLabel("Expresion Cronn");
		GridBagConstraints gbc_lblExpresionCronn = new GridBagConstraints();
		gbc_lblExpresionCronn.anchor = GridBagConstraints.WEST;
		gbc_lblExpresionCronn.insets = new Insets(0, 0, 0, 5);
		gbc_lblExpresionCronn.gridx = 0;
		gbc_lblExpresionCronn.gridy = 2;
		add(lblExpresionCronn, gbc_lblExpresionCronn);
		
		txfCron = new JTextField();
		txfCron.setBackground(new Color(176, 224, 230));
		txfCron.setEditable(false);
		GridBagConstraints gbc_txfCron = new GridBagConstraints();
		gbc_txfCron.insets = new Insets(0, 0, 0, 5);
		gbc_txfCron.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfCron.gridx = 1;
		gbc_txfCron.gridy = 2;
		add(txfCron, gbc_txfCron);
		txfCron.setColumns(10);
		
		BtnGuardar = new JButton("Agregar");
		BtnGuardar.addActionListener(this);
		GridBagConstraints gbc_BtnGuardar = new GridBagConstraints();
		gbc_BtnGuardar.gridx = 2;
		gbc_BtnGuardar.gridy = 2;
		add(BtnGuardar, gbc_BtnGuardar);
		
		
		inicializaValores();
		
	}
	
	public void inicializaValores() {
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	    if(e.getSource().equals(BtnGuardar)) {
	    	textField_1.setBackground(Color.white);
	    	textArea.setBackground(Color.WHITE);
	    	
	    	String cron = "";
			try {
				String segundos = panelSegundos.getStringCron();
				String minutos = panelMinutos.getStringCron();
				String horas = panelHoras.getStringCron();
				String mes = panelMeses.getStringCron();
				String an = panelAn.getStringCron();
				
				cron = segundos+" "+minutos+" "+horas+" "+panelDias.getCron().getDiaDelMes()+" "+mes+" "+panelDias.getCron().getDiaDeLaSemana()+ " "+an;
				txfCron.setText(cron);
				//System.out.println("-->"+cron);
				
				
				//CronExpression cr = new CronExpression(cron);
				//validando
				
				if(!CronExpression.isValidExpression(cron)) {
					Core.getCore().setError("La expresión cron no es valida");
				}else {
					if(textField_1.getText().trim().length()== 0) {
						Core.getCore().setErrorPanel("Necesitas ingresar un titulo de notificación", "Ocurrio un error");
						textField_1.requestFocus();
						textField_1.setText("");
						textField_1.setBackground(new Color(241, 148, 138));
						return;
					}else if(textArea.getText().trim().length()==0) {
						Core.getCore().setErrorPanel("Necesitas ingresar comentarios", "Ocurrio un error");
						textArea.requestFocus();
						textArea.setText("");
						textArea.setBackground(new Color(241, 148, 138));
						return;
					}
					
					//Agregando notificacion
					Notificacion not = new Notificacion(textField_1.getText().trim(), textArea.getText().trim(), cron);
					not = not.save();
					if(not == null) {
						 Core.getCore().setErrorPanel("No se pudo guardar la nueva notificacion, favor de intentarlo de nuevo", "Error:");
					}else {
					    
						Core.getCore().getVentanaPrincipal().getPanelPrincipal().getPanelNotificacionesTarjetas().AddNotificacion(not);
//						Core.getCore().getVentanaPrincipal().getPanelPrincipal().getPanelNotificaciones().getModelo().addRow(new Object[] {
//					    		 "Notificación personalizada",textField_1.getText().trim(),textArea.getText(),false,not.getId()
//					     });
					     
					     Core.getCore().getCoreJob().AddJob(not);
					 	textField_1.setText("");
						textField_1.requestFocus();
						textArea.setText("");
						
					}
				}
//				Date dt = new Date();
//				for(int i=0; i<10;i++) {
//					dt = cr.getNextValidTimeAfter(dt);
//					System.out.println(dt);
//				}
//				
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	
	    }
	    
	   
	}

	public PanelSegundos getPanelSegundos() {
		return panelSegundos;
	}

	public void setPanelSegundos(PanelSegundos panelSegundos) {
		this.panelSegundos = panelSegundos;
	}

	public PanelMinutos getPanelMinutos() {
		return panelMinutos;
	}

	public void setPanelMinutos(PanelMinutos panelMinutos) {
		this.panelMinutos = panelMinutos;
	}

	public PanelHoras getPanelHoras() {
		return panelHoras;
	}

	public void setPanelHoras(PanelHoras panelHoras) {
		this.panelHoras = panelHoras;
	}

	public PanelDias getPanelDias() {
		return panelDias;
	}

	public void setPanelDias(PanelDias panelDias) {
		this.panelDias = panelDias;
	}

	public PanelMeses getPanelMeses() {
		return panelMeses;
	}

	public void setPanelMeses(PanelMeses panelMeses) {
		this.panelMeses = panelMeses;
	}

	public PanelAn getPanelAn() {
		return panelAn;
	}

	public void setPanelAn(PanelAn panelAn) {
		this.panelAn = panelAn;
	}
    
	
}
