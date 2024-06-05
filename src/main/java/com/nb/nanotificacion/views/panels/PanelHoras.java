package com.nb.nanotificacion.views.panels;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.border.MatteBorder;

import com.nb.nanotificacion.core.Core;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class PanelHoras extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel_minutos;
	private ButtonGroup optGroup ;
	 private DecimalFormat decimalFormat;
	 private List<JCheckBox> listaCheck;
	 private JComboBox<String> comboBox;
	 private JComboBox<String> comboBox_1;
	 private JComboBox<String> comboBox_2;
	 private JComboBox<String> comboBox_3;
	 private JRadioButton rdb;
	 private JRadioButton rdb2;
	 private JRadioButton rdb3;
	 private JRadioButton rdb1;
	 

	/**
	 * Create the panel.
	 */
	public PanelHoras(String keyIdioma) {
		decimalFormat = new DecimalFormat("00");
		optGroup = new ButtonGroup();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(204, 204, 204)));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.insets = new Insets(0, 0, 1, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		rdb = new JRadioButton(Core.getCore().getIdioma().getProperty(keyIdioma+".text1", "Cada hora"));
		rdb.setOpaque(false);
		rdb.addActionListener(this);
		optGroup.add(rdb);
		panel.add(rdb);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(204, 204, 204)));
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.NORTH;
		gbc_panel_1.insets = new Insets(0, 0, 1, 0);
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		
		rdb1 = new JRadioButton(Core.getCore().getIdioma().getProperty(keyIdioma+".text2", "Cada"));
		rdb1.setOpaque(false);
		rdb1.addActionListener(this);
		optGroup.add(rdb1);
		panel_1.add(rdb1);
		
		comboBox = new JComboBox<String>();
		comboBox.setEnabled(false);
		panel_1.add(comboBox);
		
		JLabel lblCadaHoras = new JLabel(Core.getCore().getIdioma().getProperty(keyIdioma+".text3", "hora(s) iniciando en la hora"));
		panel_1.add(lblCadaHoras);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setEnabled(false);
		panel_1.add(comboBox_1);
		
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
		
		rdb2 = new JRadioButton(Core.getCore().getIdioma().getProperty(keyIdioma+".text4", "Especifica la hora (selecciona una o varias)"));
		rdb2.setSelected(true);
		rdb2.setOpaque(false);
		rdb2.addActionListener(this);
		GridBagConstraints gbc_rdb2 = new GridBagConstraints();
		gbc_rdb2.insets = new Insets(0, 0, 2, 0);
		gbc_rdb2.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdb2.gridx = 0;
		gbc_rdb2.gridy = 0;
		panel_2.add(rdb2, gbc_rdb2);
		optGroup.add(rdb2);
		panel_minutos = new JPanel();
		panel_minutos.setBackground(Color.WHITE);
		FlowLayout flowLayout_2 = (FlowLayout) panel_minutos.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_minutos = new GridBagConstraints();
		gbc_panel_minutos.fill = GridBagConstraints.BOTH;
		gbc_panel_minutos.gridx = 0;
		gbc_panel_minutos.gridy = 1;
		panel_2.add(panel_minutos, gbc_panel_minutos);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(204, 204, 204)));
		panel_3.setBackground(Color.WHITE);
		FlowLayout flowLayout_3 = (FlowLayout) panel_3.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.anchor = GridBagConstraints.SOUTH;
		gbc_panel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 3;
		add(panel_3, gbc_panel_3);
		
		rdb3 = new JRadioButton(Core.getCore().getIdioma().getProperty(keyIdioma+".text5", "Cada hora entre la hora"));
		rdb3.setOpaque(false);
		rdb3.addActionListener(this);
		panel_3.add(rdb3);
		optGroup.add(rdb3);
		comboBox_2 = new JComboBox<String>();
		comboBox_2.setEnabled(false);
		panel_3.add(comboBox_2);
		
		JLabel lblYHora = new JLabel(Core.getCore().getIdioma().getProperty(keyIdioma+".text6", "y la hora"));
		panel_3.add(lblYHora);
		
		comboBox_3 = new JComboBox<String>();
		comboBox_3.setEnabled(false);
		panel_3.add(comboBox_3);
		inicializarValores();
	}
	
	public void inicializarValores() {
		listaCheck = new ArrayList<>();
		for (int i = 0; i <= 23; i++) {
			JCheckBox jc = new JCheckBox(decimalFormat.format(new Double(""+i)));
			jc.setOpaque(false);
			if(i == 0) {
				jc.setSelected(true);
			}
			panel_minutos.add(jc);
			listaCheck.add(jc);
		}
		
		for(int i=0; i<=23; i++) {
			comboBox.addItem((i+1)+"");
			comboBox_1.addItem(decimalFormat.format(new Double(i)));
			comboBox_2.addItem(decimalFormat.format(new Double(i)));
			comboBox_3.addItem(decimalFormat.format(new Double(i)));
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
			if(btnSelecionado.equals(rdb)) {
				st="*";
			}
			else if(btnSelecionado.equals(rdb1)) {
				//Obteniendo valor del primer Select
				Integer primerValor = new Integer(comboBox.getSelectedItem().toString());
				Integer segundoValor = new Integer(comboBox_1.getSelectedItem().toString());
				st = segundoValor+"/"+primerValor;
			}else if(btnSelecionado.equals(rdb2)) {
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
			}else if(btnSelecionado.equals(rdb3)) {
				Integer primerValor = Integer.parseInt(comboBox_2.getSelectedItem().toString());
				Integer segundoValor = Integer.parseInt(comboBox_3.getSelectedItem().toString());
				
				st+= primerValor+"-"+segundoValor;
			}
			
		}
		return st;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(rdb)) {
			for(JCheckBox chk: listaCheck) {
	    		chk.setEnabled(false);
	    	}
			comboBox.setEnabled(false);
			comboBox_1.setEnabled(false);
			comboBox_2.setEnabled(false);
			comboBox_3.setEnabled(false);
			
		}else if(e.getSource().equals(rdb1)) {
			
			for(JCheckBox chk: listaCheck) {
	    		chk.setEnabled(false);
	    	}
			comboBox.setEnabled(true);
			comboBox_1.setEnabled(true);
			comboBox_2.setEnabled(false);
			comboBox_3.setEnabled(false);
		}else if(e.getSource().equals(rdb2)) {
			
			for(JCheckBox chk: listaCheck) {
	    		chk.setEnabled(true);
	    	}
			comboBox.setEnabled(false);
			comboBox_1.setEnabled(false);
			comboBox_2.setEnabled(false);
			comboBox_3.setEnabled(false);
		}else if(e.getSource().equals(rdb3)) {
			
			for(JCheckBox chk: listaCheck) {
	    		chk.setEnabled(false);
	    	}
			comboBox.setEnabled(false);
			comboBox_1.setEnabled(false);
			comboBox_2.setEnabled(true);
			comboBox_3.setEnabled(true);
		}
	}

}
