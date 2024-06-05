package com.nb.nanotificacion.views.panels;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.border.MatteBorder;

import com.nb.nanotificacion.core.Core;

import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Color;

public class PanelMeses extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ButtonGroup optGroup ;
	 private List<JCheckBox> listaCheck;
	private JRadioButton rdb1;
	private JRadioButton rdb2;
	private JComboBox<Integer> comboBox;
	private JComboBox<String> comboBox_1;
	private JRadioButton rdb3;
	private JRadioButton rdb4;
	private JComboBox<String> comboBox_2;
	private JComboBox<String> comboBox_3;
	private JPanel panel_4;

	/**
	 * Create the panel.
	 */
	public PanelMeses(String keyIdioma) {
		setBackground(Color.WHITE);
		optGroup = new ButtonGroup();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(204, 204, 204)));
		panel.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.insets = new Insets(0, 0, 1, 0);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		rdb1 = new JRadioButton(Core.getCore().getIdioma().getProperty(keyIdioma+".text1", "Cada mes"));
		rdb1.setSelected(true);
		rdb1.setOpaque(false);
		panel.add(rdb1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(204, 204, 204)));
		panel_1.setBackground(Color.WHITE);
		FlowLayout flowLayout_2 = (FlowLayout) panel_1.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.NORTH;
		gbc_panel_1.insets = new Insets(0, 0, 1, 0);
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		
		rdb2 = new JRadioButton(Core.getCore().getIdioma().getProperty(keyIdioma+".text2", "Cada"));
		rdb2.setOpaque(false);
		panel_1.add(rdb2);
		
		comboBox = new JComboBox<>();
		comboBox.setEnabled(false);
		panel_1.add(comboBox);
		
		JLabel lblNewLabel = new JLabel(Core.getCore().getIdioma().getProperty(keyIdioma+".text3", "mes(es) iniciando en "));
		panel_1.add(lblNewLabel);
		
		comboBox_1 = new JComboBox<>();
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
		gbl_panel_2.columnWidths = new int[]{0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		rdb3 = new JRadioButton(Core.getCore().getIdioma().getProperty(keyIdioma+".text4", "Específica el mes (selecciona uno o más)"));
		rdb3.setOpaque(false);
		GridBagConstraints gbc_rdb3 = new GridBagConstraints();
		gbc_rdb3.insets = new Insets(0, 5, 5, 5);
		gbc_rdb3.anchor = GridBagConstraints.WEST;
		gbc_rdb3.gridx = 0;
		gbc_rdb3.gridy = 0;
		panel_2.add(rdb3, gbc_rdb3);
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		FlowLayout flowLayout_3 = (FlowLayout) panel_4.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridwidth = 2;
		gbc_panel_4.insets = new Insets(0, 0, 0, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 1;
		panel_2.add(panel_4, gbc_panel_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(204, 204, 204)));
		panel_3.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.anchor = GridBagConstraints.SOUTH;
		gbc_panel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 3;
		add(panel_3, gbc_panel_3);
		
		rdb4 = new JRadioButton(Core.getCore().getIdioma().getProperty(keyIdioma+".text5", "Cada mes entre"));
		rdb4.setOpaque(false);
		panel_3.add(rdb4);
		
		comboBox_2 = new JComboBox<String>();
		comboBox_2.setEnabled(false);
		panel_3.add(comboBox_2);
		
		JLabel lblNewLabel_1 = new JLabel(Core.getCore().getIdioma().getProperty(keyIdioma+".text6", " y "));
		panel_3.add(lblNewLabel_1);
		
		comboBox_3 = new JComboBox<String>();
		comboBox_3.setEnabled(false);
		panel_3.add(comboBox_3);
		
		optGroup.add(rdb1);
		optGroup.add(rdb2);
		optGroup.add(rdb3);
		optGroup.add(rdb4);
		
		rdb1.addActionListener(this);
		rdb2.addActionListener(this);
		rdb3.addActionListener(this);
		rdb4.addActionListener(this);
		initValores();
	}
	
	public void initValores() {
		listaCheck = new ArrayList<>();
		String meses[] = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio",
						  "Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
		for(int i=1; i<=12; i++) {
			JCheckBox jc = new JCheckBox(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.mes."+i, meses[(i-1)]));
			jc.setOpaque(false);
			jc.setEnabled(false);
			panel_4.add(jc);
			listaCheck.add(jc);
			
			comboBox.addItem(i);
			comboBox_1.addItem(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.mes."+i, meses[(i-1)]));
			comboBox_2.addItem(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.mes."+i, meses[(i-1)]));
			comboBox_3.addItem(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.mes."+i, meses[(i-1)]));
		}
		
	
	}
	
	public void bloqueaElementos() {
		for(JCheckBox jc : listaCheck) {
			jc.setEnabled(false);
		}
		
		comboBox.setEnabled(false);
		comboBox_1.setEnabled(false);
		comboBox_2.setEnabled(false);
		comboBox_3.setEnabled(false);
		
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
			if(btnSelecionado.equals(rdb1)) {
				st="*";
			}else if(btnSelecionado.equals(rdb2)) {
				Integer primerValor = (comboBox_1.getSelectedIndex()+1);
				Integer segundoValor = (comboBox.getSelectedIndex()+1);
				st = primerValor+"/"+segundoValor;
			}
			else if(btnSelecionado.equals(rdb3)) {
				boolean select = false;
				String mes[] = {
						"JAN","FEB","MAR","APR","MAY","JUN",
						"JUL","AUG","SEP","OCT","NOV","DEC"
				};
				for(int i=0; i<listaCheck.size();i++) {
					JCheckBox jc = listaCheck.get(i);
					if(jc.isSelected()) {
						select = true;
						st+=","+ mes[i];
					}
				}
				st = st.length() >=1 ? st.substring(1, st.length()):st;
				if(!select) {
					st = "1";
				}
			}else if(btnSelecionado.equals(rdb4)) {
				Integer segundoValor = (comboBox_2.getSelectedIndex()+1);
				Integer primerValor = (comboBox_3.getSelectedIndex()+1);
				st = primerValor+"-"+segundoValor;
			}
		}else {
			st="*";
		}
		return st;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(rdb1)) {
			bloqueaElementos();
		}else if(e.getSource().equals(rdb2)) {
			bloqueaElementos();
			comboBox.setEnabled(true);
		    comboBox_1.setEnabled(true);
		}else if(e.getSource().equals(rdb3)) {
			bloqueaElementos();
			for(JCheckBox jc : listaCheck) {
				jc.setEnabled(true);
			}
		}else if(e.getSource().equals(rdb4)) {
			bloqueaElementos();
			comboBox_2.setEnabled(true);
			comboBox_3.setEnabled(true);
		}
	}

}
