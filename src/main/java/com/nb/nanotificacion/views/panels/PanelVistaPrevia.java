package com.nb.nanotificacion.views.panels;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.quartz.CronExpression;

import com.nb.nanotificacion.core.Core;
import com.nb.nanotificacion.views.panels.PanelDias.Cron;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class PanelVistaPrevia extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DefaultTableModel model;
	private JTextField textField;
	private JButton btnNewButton;
	private JTable table;
	private JTextField textField_1;
	private PanelAgregaNotificacion panelPrincipal;
	private String segundos;
	private String minutos; private String horas;
	private Cron dias;
	private String mes;
	private String an;

	/**
	 * Create the panel.
	 */
	public PanelVistaPrevia() {
		init();
	}
	
	public PanelVistaPrevia(PanelAgregaNotificacion panelPrincipal) {
		this.panelPrincipal = panelPrincipal;
		init();
	}
	public void init() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(2, 0, 1, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Expresi\u00F3n cron:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.EAST;
		gbc_panel_1.fill = GridBagConstraints.VERTICAL;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Iteraciones:");
		panel_1.add(lblNewLabel_1);
		
		textField_1 = new JTextField("20");
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textField_1.getText().trim().length()>=4) {
					e.consume();
				}
				
				
			}
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					try {
						getDatosDePanelPrincipal();
						calcula(segundos,minutos,horas,dias,mes,an);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
		        }
			}
		});
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(this);
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				calcula();
//			}
//		});
		panel_1.add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField.setBackground(new Color(176, 224, 230));
		textField.setEditable(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel(new Object[][] {
		},
		new String[] {
			"No.", "Siguiente Fecha"
		});
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		table.getColumnModel().getColumn(0).setMaxWidth(50);
	}
	public void calucla(String cron) {
try {
			
//			String segundos = panelPrincipal.getPanelSegundos().getStringCron();
//			String minutos = panelPrincipal.getPanelMinutos().getStringCron();
//			String horas = panelPrincipal.getPanelHoras().getStringCron();
//			Cron dias = panelPrincipal.getPanelDias().getCron();
//			String mes = panelPrincipal.getPanelMeses().getStringCron();
//			String an = panelPrincipal.getPanelAn().getStringCron();
			
			//String cron = segundos+" "+minutos+" "+horas+" "+dias.getDiaDelMes()+" "+mes+" "+dias.getDiaDeLaSemana()+" "+an;
			textField.setText(cron);
			//limpiando tabla
			for(int i=table.getRowCount()-1; i>=0; i--) {
				//System.out.println("Eliminando: "+i);
				model.removeRow(table.getRowCount()-1);
			}
			CronExpression exp = new CronExpression(cron);
			Calendar calendar = GregorianCalendar.getInstance();
			
			
			//System.out.println(calendar.getTime());
//			for(String lc : TimeZone.getAvailableIDs()) {
//				System.out.println(lc);
//			}
			Integer total = 20;
			if(textField_1.getText().trim().length() != 0) {
				try {
					total = Integer.parseInt(textField_1.getText().trim());
				} catch (Exception e2) {
					e2.printStackTrace();
					Core.getCore().setError("Error: "+e2.getMessage());
				}
			}
			Date dt = new Date();
			for(int i=1; i<=total;i++) {
				
				dt = exp.getNextValidTimeAfter(dt);
				calendar.setTime(dt);
				Integer day = calendar.get(Calendar.DAY_OF_WEEK);
				
				//System.out.println(dt);
				//System.out.println(calendar.get(Calendar.MONTH)+1);
				String fecha = ""+Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana."+day, new SimpleDateFormat("E").format(dt))+", "+calendar.get(Calendar.DAY_OF_MONTH)+" ";
				fecha+=Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.mes."+(calendar.get(Calendar.MONTH)+1),new SimpleDateFormat("MMMM").format(dt));
				fecha += " "+new SimpleDateFormat("HH").format(dt)+":"+new SimpleDateFormat("mm").format(dt)+":"+new SimpleDateFormat("ss").format(dt);
				fecha +=" "+new SimpleDateFormat("yyyy").format(dt);
				model.addRow(new Object[] {
					i,fecha
				});
				
			}
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void calcula(String segundos,String minutos,String horas,Cron dias,String mes,String an) {
		try {
			
//			String segundos = panelPrincipal.getPanelSegundos().getStringCron();
//			String minutos = panelPrincipal.getPanelMinutos().getStringCron();
//			String horas = panelPrincipal.getPanelHoras().getStringCron();
//			Cron dias = panelPrincipal.getPanelDias().getCron();
//			String mes = panelPrincipal.getPanelMeses().getStringCron();
//			String an = panelPrincipal.getPanelAn().getStringCron();
			
			String cron = segundos+" "+minutos+" "+horas+" "+dias.getDiaDelMes()+" "+mes+" "+dias.getDiaDeLaSemana()+" "+an;
			textField.setText(cron);
			//limpiando tabla
			for(int i=table.getRowCount()-1; i>=0; i--) {
				//System.out.println("Eliminando: "+i);
				model.removeRow(table.getRowCount()-1);
			}
			CronExpression exp = new CronExpression(cron);
			Calendar calendar = GregorianCalendar.getInstance();
			
			
			//System.out.println(calendar.getTime());
//			for(String lc : TimeZone.getAvailableIDs()) {
//				System.out.println(lc);
//			}
			Integer total = 20;
			if(textField_1.getText().trim().length() != 0) {
				try {
					total = Integer.parseInt(textField_1.getText().trim());
				} catch (Exception e2) {
					e2.printStackTrace();
					Core.getCore().setError("Error: "+e2.getMessage());
				}
			}
			Date dt = new Date();
			for(int i=1; i<=total;i++) {
				
				dt = exp.getNextValidTimeAfter(dt);
				calendar.setTime(dt);
				Integer day = calendar.get(Calendar.DAY_OF_WEEK);
				
				//System.out.println(dt);
				//System.out.println(calendar.get(Calendar.MONTH)+1);
				String fecha = ""+Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana."+day, new SimpleDateFormat("E").format(dt))+", "+calendar.get(Calendar.DAY_OF_MONTH)+" ";
				fecha+=Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.mes."+(calendar.get(Calendar.MONTH)+1),new SimpleDateFormat("MMMM").format(dt));
				fecha += " "+new SimpleDateFormat("HH").format(dt)+":"+new SimpleDateFormat("mm").format(dt)+":"+new SimpleDateFormat("ss").format(dt);
				fecha +=" "+new SimpleDateFormat("yyyy").format(dt);
				model.addRow(new Object[] {
					i,fecha
				});
				
			}
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	
	public void getDatosDePanelPrincipal() throws Exception {
		this.segundos = panelPrincipal.getPanelSegundos().getStringCron();
		this.minutos = panelPrincipal.getPanelMinutos().getStringCron();
		this.horas = panelPrincipal.getPanelHoras().getStringCron();
		this.dias = panelPrincipal.getPanelDias().getCron();
		this.mes = panelPrincipal.getPanelMeses().getStringCron();
		this.an = panelPrincipal.getPanelAn().getStringCron();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnNewButton)) {
			if(panelPrincipal!=null) {
//				String segundos = panelPrincipal.getPanelSegundos().getStringCron();
//				String minutos = panelPrincipal.getPanelMinutos().getStringCron();
//				String horas = panelPrincipal.getPanelHoras().getStringCron();
//				Cron dias = panelPrincipal.getPanelDias().getCron();
//				String mes = panelPrincipal.getPanelMeses().getStringCron();
//				String an = panelPrincipal.getPanelAn().getStringCron();
				
				try {
					getDatosDePanelPrincipal();
					calcula(this.segundos,this.minutos,this.horas,this.dias,this.mes,this.an);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else {
				calcula(this.segundos,this.minutos,this.horas,this.dias,this.mes,this.an);
			}
			
		}
		
	}
	
	

}
