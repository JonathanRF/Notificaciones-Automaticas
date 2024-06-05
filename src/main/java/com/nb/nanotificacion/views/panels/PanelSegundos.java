package com.nb.nanotificacion.views.panels;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.border.MatteBorder;

import com.nb.nanotificacion.core.Core;

import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class PanelSegundos extends JPanel implements ActionListener {

	
	private static final long serialVersionUID = 1L;
	
	
	 private DecimalFormat decimalFormat;
	 private ButtonGroup optGroup ;
	 private JRadioButton RBCadaSegudo;
	 private List<JCheckBox> listaCheck;
	 private JPanel panel_4;
	 private JComboBox<String> JCBInicio;
	 private JComboBox<String> JCBFin;
	 private JComboBox<String> JCBInicioEntre;
	 private JComboBox<String> JCBFinEntre;
	 private JRadioButton RBInicioFin;
	 private JRadioButton RBEspecificaSegundos;
	 private JRadioButton RBIntervalo;

	public PanelSegundos(String keyIdioma) {
		decimalFormat = new DecimalFormat("00");
		optGroup = new ButtonGroup();
		
        GridBagLayout gbl_JPanelSegundos = new GridBagLayout();
   		gbl_JPanelSegundos.columnWidths = new int[]{0, 0};
   		gbl_JPanelSegundos.rowHeights = new int[]{0, 0, 0, 0, 0};
   		gbl_JPanelSegundos.columnWeights = new double[]{1.0, Double.MIN_VALUE};
   		gbl_JPanelSegundos.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
   		setLayout(gbl_JPanelSegundos);
   		
   		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(204, 204, 204)));
		panel.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.insets = new Insets(0, 0, 1, 0);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		
		RBCadaSegudo = new JRadioButton(Core.getCore().getIdioma().getProperty(keyIdioma+".text1", "Cada segundo"));
		RBCadaSegudo.setOpaque(false);
		RBCadaSegudo.addActionListener(this);
		panel.add(RBCadaSegudo);
		optGroup.add(RBCadaSegudo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(204, 204, 204)));
		panel_1.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.NORTH;
		gbc_panel_1.insets = new Insets(0, 0, 1, 0);
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		
		RBInicioFin = new JRadioButton(Core.getCore().getIdioma().getProperty(keyIdioma+".text2", "Cada"));
		RBInicioFin.setOpaque(false);
		RBInicioFin.addActionListener(this);
		optGroup.add(RBInicioFin);
		
		panel_1.add(RBInicioFin);
		
		JCBInicio = new JComboBox<>();
		JCBInicio.setEnabled(false);
		panel_1.add(JCBInicio);
		
		JLabel lblSegundos = new JLabel(Core.getCore().getIdioma().getProperty(keyIdioma+".text3", "segundo(s) iniciando en el segundo"));
		panel_1.add(lblSegundos);
		
		JCBFin = new JComboBox<>();
		JCBFin.setEnabled(false);
		panel_1.add(JCBFin);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(204, 204, 204)));
		panel_2.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 1, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		RBEspecificaSegundos = new JRadioButton(Core.getCore().getIdioma().getProperty(keyIdioma+".text4", "Especifica segundos (selecciona uno o muchos)"));
		RBEspecificaSegundos.setSelected(true);
		RBEspecificaSegundos.addActionListener(this);
		RBEspecificaSegundos.setOpaque(false);
		RBEspecificaSegundos.addActionListener(this);
		optGroup.add(RBEspecificaSegundos);
		GridBagConstraints gbc_RBEspecificaSegundos = new GridBagConstraints();
		gbc_RBEspecificaSegundos.anchor = GridBagConstraints.NORTHWEST;
		gbc_RBEspecificaSegundos.insets = new Insets(0, 5, 1, 0);
		gbc_RBEspecificaSegundos.gridx = 0;
		gbc_RBEspecificaSegundos.gridy = 0;
		panel_2.add(RBEspecificaSegundos, gbc_RBEspecificaSegundos);
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 1;
		panel_2.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 1));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.anchor = GridBagConstraints.SOUTH;
		gbc_panel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 3;
		add(panel_3, gbc_panel_3);
		
		
		RBIntervalo = new JRadioButton(Core.getCore().getIdioma().getProperty(keyIdioma+".text5", "Cada segundo entre segundo"));
		RBIntervalo.addActionListener(this);
		RBIntervalo.addActionListener(this);
		RBIntervalo.setOpaque(false);
		RBIntervalo.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		optGroup.add(RBIntervalo);
		panel_3.add(RBIntervalo);
		
		JCBInicioEntre = new JComboBox<>();
		JCBInicioEntre.setEnabled(false);
		panel_3.add(JCBInicioEntre);
		
		JLabel lblYSegundo = new JLabel(Core.getCore().getIdioma().getProperty(keyIdioma+".text6", "y segundo"));
		panel_3.add(lblYSegundo);
		
		JCBFinEntre = new JComboBox<>();
		JCBFinEntre.setEnabled(false);
		panel_3.add(JCBFinEntre);
		inicializaValores();
	}
	
	
	
	
	public void inicializaValores() {
		listaCheck = new ArrayList<>();
		for(int i=0; i<60; i++) {
			
			String ft = decimalFormat.format(new Double(i));
			JCheckBox chs0 = new JCheckBox(ft);
			if(i==0) {
				chs0.setSelected(true);
			}
			//chs0.setFont(new Font("Tahoma", Font.PLAIN, 15));
			chs0.setOpaque(false);
			panel_4.add(chs0);
			listaCheck.add(chs0);
			
			JCBInicio.addItem(decimalFormat.format(new Double(i+1)));
			JCBFin.addItem(ft);
			
			JCBInicioEntre.addItem(ft);
			JCBFinEntre.addItem(ft);
		}
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
	
	public String getStringCron() throws Exception{
		String st="";
		JRadioButton btnSelecionado = getOpcionSelecionada();
		if(btnSelecionado!=null) {
			if(btnSelecionado.equals(RBCadaSegudo)) {
				st="*";
			}
			else if(btnSelecionado.equals(RBInicioFin)) {
				//Obteniendo valor del primer Select
				Integer primerValor = new Integer(JCBInicio.getSelectedItem().toString());
				Integer segundoValor = new Integer(JCBFin.getSelectedItem().toString());
				st = segundoValor+"/"+primerValor;
			}else if(btnSelecionado.equals(RBEspecificaSegundos)) {
				boolean select = false;
				for(JCheckBox ch : listaCheck) {
				     	if(ch.isSelected()) {
				     		select = true;
				     		st+=","+ Integer.parseInt(ch.getText());
				     	}
				}
				st = st.length() >=1 ? st.substring(1, st.length()):st;
				if(!select) {
					st = "0";
				}
			}else if(btnSelecionado.equals(RBIntervalo)) {
				Integer primerValor = Integer.parseInt(JCBInicioEntre.getSelectedItem().toString());
				Integer segundoValor = Integer.parseInt(JCBFinEntre.getSelectedItem().toString());
				
				st+= primerValor+"-"+segundoValor;
			}
			
		}
		return st;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 if(e.getSource().equals(RBCadaSegudo)) {
		    	//Cuando se selecciona el Radio Button desactiva las demas opciones
		    	for(JCheckBox chk: listaCheck) {
		    		chk.setEnabled(false);
		    	}
		    	//bloqueado select
		    	JCBInicio.setEnabled(false);
		    	JCBFin.setEnabled(false);
		    	JCBInicioEntre.setEnabled(false);
		    	JCBFinEntre.setEnabled(false);
		    	
		    }else if(e.getSource().equals(RBInicioFin)) {
		    	JCBInicio.setEnabled(true);
		    	JCBFin.setEnabled(true);
		    	JCBInicioEntre.setEnabled(false);
		    	JCBFinEntre.setEnabled(false);
		    	for(JCheckBox chk: listaCheck) {
		    		chk.setEnabled(false);
		    	}
		    }
		    else if(e.getSource().equals(RBEspecificaSegundos)) {
		    	for(JCheckBox chk: listaCheck) {
		    		chk.setEnabled(true);
		    	}
		    	
		    	JCBInicio.setEnabled(false);
		    	JCBFin.setEnabled(false);
		    	JCBInicioEntre.setEnabled(false);
		    	JCBFinEntre.setEnabled(false);
		    	
		    	
		    }
		    else if( e.getSource().equals(RBIntervalo)) {
		    	JCBInicio.setEnabled(false);
		    	JCBFin.setEnabled(false);
		    	JCBInicioEntre.setEnabled(true);
		    	JCBFinEntre.setEnabled(true);
		    	for(JCheckBox chk: listaCheck) {
		    		chk.setEnabled(false);
		    	}
		    }
		    
	}

}
