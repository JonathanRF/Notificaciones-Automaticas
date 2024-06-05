package com.nb.nanotificacion.views.panels;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;

import com.nb.nanotificacion.core.Core;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JCheckBox;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class PanelDias extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private DecimalFormat decimalFormat;
	 private ButtonGroup optGroup ;
	 private List<JCheckBox> listaCheck;
	 private JRadioButton rdb2;
	 private JRadioButton rdb1;
	 private JComboBox<Integer> comboBox;
	 private JComboBox<String> comboBox_1;
	 private JComboBox<Integer> comboBox_2;
	 private JComboBox<String> comboBox_3;
	 private JRadioButton rdb4;
	 private JCheckBox chckbx1;
	 private JCheckBox chckbx3;
	 private JCheckBox chckbx4;
	 private JCheckBox chckbx5;
	 private JCheckBox chckbx6;
	 private JCheckBox chckbx7;
	 private JRadioButton rdb5;
	 private JRadioButton rdb6;
	 private JRadioButton rdb7;
	 private JRadioButton rdb9;
	 private JComboBox<Integer> comboBox_5;
	 private JRadioButton rdb10;
	 private JRadioButton rdb11;
	 private JComboBox<String> comboBox_7;
	 private JComboBox<String> comboBox_8;
	 private JRadioButton rdb3;
	 private JRadioButton rdb8;
	 private JPanel panel_13;
	 private JComboBox<String> comboBox_4;
	 private JComboBox<String> comboBox_6;
	 private JCheckBox chckbx2;
	 private JPanel panel_12;

	/**
	 * Create the panel.
	 */
	public PanelDias(String keyIdioma) {
		optGroup = new ButtonGroup();
		decimalFormat = new DecimalFormat("00");
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(204, 204, 204)));
		panel_1.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.NORTH;
		gbc_panel_1.insets = new Insets(0, 0, 1, 0);
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		
		rdb1 = new JRadioButton(Core.getCore().getIdioma().getProperty(keyIdioma+".text1", "Cada día"));
		
		rdb1.setSelected(true);
		rdb1.setOpaque(false);
		optGroup.add(rdb1);
		panel_1.add(rdb1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(204, 204, 204)));
		panel_2.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.anchor = GridBagConstraints.NORTH;
		gbc_panel_2.insets = new Insets(0, 0, 1, 0);
		gbc_panel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		panel.add(panel_2, gbc_panel_2);
		
		rdb2 = new JRadioButton(Core.getCore().getIdioma().getProperty(keyIdioma+".text2", "Cada"));
		
		rdb2.setOpaque(false);
		optGroup.add(rdb2);
		panel_2.add(rdb2);
		
		comboBox = new JComboBox<>();
		comboBox.setEnabled(false);
		panel_2.add(comboBox);
		
		JLabel lblNewLabel = new JLabel(Core.getCore().getIdioma().getProperty(keyIdioma+".text3", "día(s) iniciando en "));
		panel_2.add(lblNewLabel);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setEnabled(false);
		panel_2.add(comboBox_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(204, 204, 204)));
		panel_3.setBackground(Color.WHITE);
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 1, 0);
		gbc_panel_3.anchor = GridBagConstraints.NORTH;
		gbc_panel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 2;
		panel.add(panel_3, gbc_panel_3);
		
		rdb3 = new JRadioButton(Core.getCore().getIdioma().getProperty(keyIdioma+".text4", "Cada "));
		rdb3.setOpaque(false);
		panel_3.add(rdb3);
		
		comboBox_2 = new JComboBox<>();
		comboBox_2.setEnabled(false);
		panel_3.add(comboBox_2);
		
		JLabel lblNewLabel_1 = new JLabel(Core.getCore().getIdioma().getProperty(keyIdioma+".text5", "día(s) iniciando en el "));
		panel_3.add(lblNewLabel_1);
		
		comboBox_3 = new JComboBox<>();
		comboBox_3.setEnabled(false);
		panel_3.add(comboBox_3);
		
		JLabel lblNewLabel_2 = new JLabel(Core.getCore().getIdioma().getProperty(keyIdioma+".text6", " de el mes"));
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(204, 204, 204)));
		panel_4.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.anchor = GridBagConstraints.NORTH;
		gbc_panel_4.insets = new Insets(0, 0, 1, 0);
		gbc_panel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 3;
		panel.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		rdb4 = new JRadioButton(Core.getCore().getIdioma().getProperty(keyIdioma+".text7", "Específica el día de la semana (selecciona uno o varios)"));
		rdb4.setOpaque(false);
		GridBagConstraints gbc_rdb4 = new GridBagConstraints();
		gbc_rdb4.anchor = GridBagConstraints.WEST;
		gbc_rdb4.insets = new Insets(0, 5, 5, 5);
		gbc_rdb4.gridx = 0;
		gbc_rdb4.gridy = 0;
		panel_4.add(rdb4, gbc_rdb4);
		
		panel_12 = new JPanel();
		panel_12.setBackground(Color.WHITE);
		FlowLayout fl_panel_12 = (FlowLayout) panel_12.getLayout();
		fl_panel_12.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_12 = new GridBagConstraints();
		gbc_panel_12.gridwidth = 2;
		gbc_panel_12.insets = new Insets(0, 0, 0, 5);
		gbc_panel_12.fill = GridBagConstraints.BOTH;
		gbc_panel_12.gridx = 0;
		gbc_panel_12.gridy = 1;
		panel_4.add(panel_12, gbc_panel_12);
		
		chckbx1 = new JCheckBox(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.1", "Domingo"));
		chckbx1.setEnabled(false);
		chckbx1.setOpaque(false);
		panel_12.add(chckbx1);
		
		chckbx2 = new JCheckBox(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.2", "Lunes"));
		chckbx2.setEnabled(false);
		chckbx2.setOpaque(false);
		panel_12.add(chckbx2);
		
		chckbx3 = new JCheckBox(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.3", "Martes"));
		chckbx3.setEnabled(false);
		chckbx3.setOpaque(false);
		panel_12.add(chckbx3);
		
		chckbx4 = new JCheckBox(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.4", "Miércoles"));
		chckbx4.setEnabled(false);
		chckbx4.setOpaque(false);
		panel_12.add(chckbx4);
		
		chckbx5 = new JCheckBox(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.5", "Jueves"));
		chckbx5.setEnabled(false);
		chckbx5.setOpaque(false);
		panel_12.add(chckbx5);
		
		chckbx6 = new JCheckBox(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.6", "Viernes"));
		chckbx6.setEnabled(false);
		chckbx6.setOpaque(false);
		panel_12.add(chckbx6);
		
		chckbx7 = new JCheckBox(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.7", "Sábado"));
		chckbx7.setEnabled(false);
		chckbx7.setOpaque(false);
		panel_12.add(chckbx7);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(204, 204, 204)));
		panel_5.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 1, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 4;
		panel.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0, 0};
		gbl_panel_5.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		rdb5 = new JRadioButton(Core.getCore().getIdioma().getProperty(keyIdioma+".text8", "Especifica el día del mes (selecciona uno o varios)"));
		rdb5.setOpaque(false);
		GridBagConstraints gbc_rdb5 = new GridBagConstraints();
		gbc_rdb5.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdb5.insets = new Insets(0, 0, 5, 0);
		gbc_rdb5.gridx = 0;
		gbc_rdb5.gridy = 0;
		panel_5.add(rdb5, gbc_rdb5);
		
		panel_13 = new JPanel();
		panel_13.setBackground(Color.WHITE);
		
		FlowLayout fl_panel_13 = (FlowLayout) panel_13.getLayout();
		fl_panel_13.setAlignment(FlowLayout.LEFT);
		panel_13.setPreferredSize(new Dimension(400, 100));
		GridBagConstraints gbc_panel_13 = new GridBagConstraints();
		gbc_panel_13.fill = GridBagConstraints.BOTH;
		gbc_panel_13.gridx = 0;
		gbc_panel_13.gridy = 1;
		panel_5.add(panel_13, gbc_panel_13);
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(204, 204, 204)));
		panel_6.setBackground(Color.WHITE);
		FlowLayout flowLayout_3 = (FlowLayout) panel_6.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 1, 0);
		gbc_panel_6.anchor = GridBagConstraints.SOUTH;
		gbc_panel_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 5;
		panel.add(panel_6, gbc_panel_6);
		
		rdb6 = new JRadioButton(Core.getCore().getIdioma().getProperty(keyIdioma+".text9", "El último día del el mes"));
		rdb6.setOpaque(false);
		panel_6.add(rdb6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(204, 204, 204)));
		panel_7.setBackground(Color.WHITE);
		FlowLayout flowLayout_4 = (FlowLayout) panel_7.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 1, 0);
		gbc_panel_7.anchor = GridBagConstraints.SOUTH;
		gbc_panel_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 6;
		panel.add(panel_7, gbc_panel_7);
		
		rdb7 = new JRadioButton(Core.getCore().getIdioma().getProperty(keyIdioma+".text10", "La última semana del mes"));
		rdb7.setOpaque(false);
		panel_7.add(rdb7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel_8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(204, 204, 204)));
		FlowLayout flowLayout_5 = (FlowLayout) panel_8.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 1, 0);
		gbc_panel_8.anchor = GridBagConstraints.SOUTH;
		gbc_panel_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 7;
		panel.add(panel_8, gbc_panel_8);
		
		rdb8 = new JRadioButton(Core.getCore().getIdioma().getProperty(keyIdioma+".text11", "En el último "));
		rdb8.setOpaque(false);
		panel_8.add(rdb8);
		
		comboBox_4 = new JComboBox<>();
		comboBox_4.setEnabled(false);
		panel_8.add(comboBox_4);
		
		JLabel lblNewLabel_3 = new JLabel(Core.getCore().getIdioma().getProperty(keyIdioma+".text12", " de el mes"));
		panel_8.add(lblNewLabel_3);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		panel_9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(204, 204, 204)));
		FlowLayout flowLayout_6 = (FlowLayout) panel_9.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.anchor = GridBagConstraints.SOUTH;
		gbc_panel_9.insets = new Insets(0, 0, 1, 0);
		gbc_panel_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_9.gridx = 0;
		gbc_panel_9.gridy = 8;
		panel.add(panel_9, gbc_panel_9);
		
		rdb9 = new JRadioButton(Core.getCore().getIdioma().getProperty(keyIdioma+".text13", ""));
		rdb9.setOpaque(false);
		panel_9.add(rdb9);
		
		comboBox_5 = new JComboBox<>();
		comboBox_5.setEnabled(false);
		panel_9.add(comboBox_5);
		
		JLabel lblNewLabel_4 = new JLabel(Core.getCore().getIdioma().getProperty(keyIdioma+".text14", "día(s) antes del fin del mes"));
		panel_9.add(lblNewLabel_4);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(204, 204, 204)));
		panel_10.setBackground(Color.WHITE);
		FlowLayout flowLayout_7 = (FlowLayout) panel_10.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.insets = new Insets(0, 0, 1, 0);
		gbc_panel_10.anchor = GridBagConstraints.SOUTH;
		gbc_panel_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_10.gridx = 0;
		gbc_panel_10.gridy = 9;
		panel.add(panel_10, gbc_panel_10);
		
		rdb10 = new JRadioButton(Core.getCore().getIdioma().getProperty(keyIdioma+".text15", "Día de la semana más cercano (de lunes a viernes) del "));
		rdb10.setOpaque(false);
		panel_10.add(rdb10);
		
		comboBox_6 = new JComboBox<>();
		comboBox_6.setEnabled(false);
		panel_10.add(comboBox_6);
		
		JLabel lblNewLabel_5 = new JLabel(Core.getCore().getIdioma().getProperty(keyIdioma+".text16", " del mes"));
		panel_10.add(lblNewLabel_5);


		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(204, 204, 204)));
		panel_11.setBackground(Color.WHITE);
		FlowLayout flowLayout_8 = (FlowLayout) panel_11.getLayout();
		flowLayout_8.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.anchor = GridBagConstraints.SOUTH;
		gbc_panel_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_11.gridx = 0;
		gbc_panel_11.gridy = 10;
		panel.add(panel_11, gbc_panel_11);
		
		rdb11 = new JRadioButton(Core.getCore().getIdioma().getProperty(keyIdioma+".text17", "En el "));
		rdb11.setOpaque(false);
		panel_11.add(rdb11);
		
		comboBox_7 = new JComboBox<>();
		comboBox_7.setEnabled(false);
		panel_11.add(comboBox_7);
		
		comboBox_8 = new JComboBox<>();
		comboBox_8.setEnabled(false);
		panel_11.add(comboBox_8);
		
		JLabel lblNewLabel_6 = new JLabel(Core.getCore().getIdioma().getProperty(keyIdioma+".text18", " del mes"));
		panel_11.add(lblNewLabel_6);
		
		optGroup.add(rdb3);
		optGroup.add(rdb4);
		optGroup.add(rdb5);
		optGroup.add(rdb6);
		optGroup.add(rdb7);
		optGroup.add(rdb8);
		optGroup.add(rdb9);
		optGroup.add(rdb10);
		optGroup.add(rdb11);
		
		rdb1.addActionListener(this);
		rdb2.addActionListener(this);
		rdb3.addActionListener(this);
		rdb4.addActionListener(this);
		rdb5.addActionListener(this);
		rdb6.addActionListener(this);
		rdb7.addActionListener(this);
		rdb8.addActionListener(this);
		rdb9.addActionListener(this);
		rdb10.addActionListener(this);
		rdb11.addActionListener(this);
		initValores();
	}
	
	public void initValores() {
		listaCheck = new ArrayList<>();
		for(int i=1; i<=31; i++) {
			try {
				JCheckBox jc = new JCheckBox(decimalFormat.format(new Double(""+i)));
				jc.setOpaque(false);
				jc.setEnabled(false);
				listaCheck.add(jc);
				panel_13.add(jc);
			} catch (Exception e) {
				// TODO: handle exception
				
			}
			
		}
		//Agregar elementos a ComboBox
		try {
			//
			for(int i=1; i<=31;i++) {
				comboBox_3.addItem(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.ordinal."+i, i+".º"));
				comboBox_6.addItem(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.ordinal."+i, i+".º"));
				comboBox_2.addItem(i);
				comboBox_5.addItem(i);
				if(i<=5) {
					comboBox_7.addItem(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.ordinal."+i, i+".º"));
				}
				if(i<=7) {
					comboBox.addItem(i);
				}
			}
			
			comboBox_1.addItem(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.1", "Domingo"));
			comboBox_1.addItem(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.2", "Lunes"));
			comboBox_1.addItem(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.3", "Martes"));
			comboBox_1.addItem(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.4", "Miércoles"));
			comboBox_1.addItem(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.5", "Jueves"));
			comboBox_1.addItem(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.6", "Viernes"));
			comboBox_1.addItem(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.7", "Sábado"));
			
			comboBox_4.addItem(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.1", "Domingo"));
			comboBox_4.addItem(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.2", "Lunes"));
			comboBox_4.addItem(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.3", "Martes"));
			comboBox_4.addItem(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.4", "Miércoles"));
			comboBox_4.addItem(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.5", "Jueves"));
			comboBox_4.addItem(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.6", "Viernes"));
			comboBox_4.addItem(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.7", "Sábado"));
			
			comboBox_8.addItem(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.1", "Domingo"));
			comboBox_8.addItem(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.2", "Lunes"));
			comboBox_8.addItem(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.3", "Martes"));
			comboBox_8.addItem(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.4", "Miércoles"));
			comboBox_8.addItem(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.5", "Jueves"));
			comboBox_8.addItem(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.6", "Viernes"));
			comboBox_8.addItem(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana.7", "Sábado"));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public void bloquearElementos() {
		for(JCheckBox cb: listaCheck) {
			cb.setEnabled(false);
		}
		comboBox.setEnabled(false);
		comboBox_1.setEnabled(false);
		comboBox_2.setEnabled(false);
		comboBox_3.setEnabled(false);
		comboBox_4.setEnabled(false);
		comboBox_5.setEnabled(false);
		comboBox_6.setEnabled(false);
		comboBox_7.setEnabled(false);
		comboBox_8.setEnabled(false);
		
		chckbx1.setEnabled(false);
		chckbx2.setEnabled(false);
		chckbx3.setEnabled(false);
		chckbx4.setEnabled(false);
		chckbx5.setEnabled(false);
		chckbx6.setEnabled(false);
		chckbx7.setEnabled(false);
	}
	
	public JRadioButton getOpcionSelecionada() {
		for (Enumeration<AbstractButton> buttons = optGroup.getElements(); buttons.hasMoreElements();) {
			JRadioButton rd = (JRadioButton) buttons.nextElement();
            if (rd.isSelected()) {
                return rd;
            }
        }
		
		return null;
	}
	
	public Cron getCron() throws Exception{
		Cron cron = new Cron();
		cron.setDiaDelMes("?");
		cron.setDiaDeLaSemana("*");
		JRadioButton btnSelecionado = getOpcionSelecionada();
		if(btnSelecionado!=null) {
			if(btnSelecionado.equals(rdb2)) {
				cron.setDiaDelMes("?");
				Integer primerValor = new Integer((Integer)comboBox.getSelectedItem());
				Integer segundoValor = comboBox_1.getSelectedIndex()+1;
			
				cron.setDiaDeLaSemana(segundoValor+"/"+primerValor);
			}else if(btnSelecionado.equals(rdb3)) {
				cron.diaDeLaSemana = "?";
				Integer primerValor = new Integer((Integer)comboBox_2.getSelectedItem());
				Integer segundoValor = comboBox_3.getSelectedIndex()+1;
				cron.diaDelMes = segundoValor+"/"+primerValor;
			}else if(btnSelecionado.equals(rdb4)) {
				
				cron.diaDelMes="?";
				cron.diaDeLaSemana="";
				boolean select = false;
				System.out.println("Total: "+panel_12.getComponentCount());
				int index = 0;
				int index2 = 0;
				String[] dias = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
				for(Component ch : panel_12.getComponents()) {
					try {
						JCheckBox chb = (JCheckBox)ch;
						if(chb.isSelected()) {
							select = true;
							if(index2==0) {
								cron.diaDeLaSemana=dias[index];
								index2++;
							}else {
								cron.diaDeLaSemana+=","+dias[index];
							}
						}
						index++;
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
				}
				if(!select) {
					cron.diaDeLaSemana="SUN";
				}

			}else if(btnSelecionado.equals(rdb5)) {
				cron.diaDeLaSemana = "?";
				cron.diaDelMes="";
				boolean select = false;
				for(JCheckBox ch : listaCheck) {
			     	if(ch.isSelected()) {
			     		select = true;
			     		cron.diaDelMes+=","+ Integer.parseInt(ch.getText());
			     	}
			}
				
				cron.diaDelMes = cron.diaDelMes.length() >=1 ? cron.diaDelMes.substring(1, cron.diaDelMes.length()):cron.diaDelMes;
				if(!select) {
					cron.diaDelMes = "1";
				}
			}else if(btnSelecionado.equals(rdb6)) {
				cron.diaDeLaSemana = "?";
				cron.diaDelMes = "L";
			}else if(btnSelecionado.equals(rdb7)) {
				cron.diaDeLaSemana = "?";
				cron.diaDelMes = "LW";
			}else if(btnSelecionado.equals(rdb8)) {
				cron.diaDelMes = "?";
				cron.diaDeLaSemana = (comboBox_4.getSelectedIndex()+1)+"L";
			}else if(btnSelecionado.equals(rdb9)) {
				cron.diaDeLaSemana = "?";
				cron.diaDelMes = "L-"+(comboBox_5.getSelectedIndex()+1);
			}else if(btnSelecionado.equals(rdb10)) {
				cron.diaDeLaSemana = "?";
				cron.diaDelMes = (comboBox_6.getSelectedIndex()+1)+"W";
			}else if(btnSelecionado.equals(rdb11)) {
				cron.diaDelMes = "?";
				
				cron.diaDeLaSemana = (comboBox_8.getSelectedIndex()+1)+"#"+(comboBox_7.getSelectedIndex()+1);
			}
		}
		
		
		return cron;
	}

	@Override
	public void actionPerformed(ActionEvent com) {
		// TODO Auto-generated method stub
		if(com.getSource().equals(rdb1)) {
			bloquearElementos();
		}else if(com.getSource().equals(rdb2)) {
			bloquearElementos();
			comboBox.setEnabled(true);
			comboBox_1.setEnabled(true);
		}else if(com.getSource().equals(rdb3)) {
			bloquearElementos();
			comboBox_2.setEnabled(true);
			comboBox_3.setEnabled(true);
		}else if(com.getSource().equals(rdb5)) {
			bloquearElementos();
			for(JCheckBox cb: listaCheck) {
				cb.setEnabled(true);
			}
		}else if(com.getSource().equals(rdb4)) {
			bloquearElementos();
			chckbx1.setEnabled(true);
			chckbx2.setEnabled(true);
			chckbx3.setEnabled(true);
			chckbx4.setEnabled(true);
			chckbx5.setEnabled(true);
			chckbx6.setEnabled(true);
			chckbx7.setEnabled(true);
		}else if(com.getSource().equals(rdb6)) {
			bloquearElementos();
		}else if(com.getSource().equals(rdb7)) {
			bloquearElementos();
		}else if(com.getSource().equals(rdb8)) {
			bloquearElementos();
			comboBox_4.setEnabled(true);
		}else if(com.getSource().equals(rdb9)) {
			bloquearElementos();
			comboBox_5.setEnabled(true);
		}else if(com.getSource().equals(rdb10)) {
			bloquearElementos();
			comboBox_6.setEnabled(true);
		}else if(com.getSource().equals(rdb11)) {
			bloquearElementos();
			comboBox_7.setEnabled(true);
			comboBox_8.setEnabled(true);
		}
	}
	
	public class Cron{
		private String diaDelMes;
		private String diaDeLaSemana;
		public String getDiaDelMes() {
			return diaDelMes;
		}
		public void setDiaDelMes(String diaDelMes) {
			this.diaDelMes = diaDelMes;
		}
		public String getDiaDeLaSemana() {
			return diaDeLaSemana;
		}
		public void setDiaDeLaSemana(String diaDeLaSemana) {
			this.diaDeLaSemana = diaDeLaSemana;
		}
		
		
	}

}
