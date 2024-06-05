package com.nb.nanotificacion.views.panels;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import java.awt.Insets;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import com.nb.nanotificacion.views.jframe.VentanaNotificacion;
import com.nb.nanotificacion.views.utils.Colors;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class PanelNotificacionVentana extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titulo;
    private String tipo;
    private String comentarios;
    private JTextArea textAreaComentarios;
    private JButton btnClose;
    private VentanaNotificacion ventana;
    private final PanelNotificacionVentana This;
    private JLabel lblTitulo;
	/**
	 * Create the panel.
	 */
    public PanelNotificacionVentana(String tipo,String titulo,String comentarios,VentanaNotificacion ventana) {
    	this.titulo = titulo;
    	this.comentarios = comentarios;
    	this.ventana = ventana;
    	this.tipo = tipo;
    	This = this;
    	init();
    	textAreaComentarios.setText(this.comentarios);
    	textAreaComentarios.setEditable(false);
    	//textAreaComentarios.addMouseListener(this);
    	lblTitulo.setText(this.tipo);
    	
    }
    
	public PanelNotificacionVentana() {
		titulo = "Comentarios";
		This = this;
		init();
	}
	
	public void init() {
		//addMouseListener(this);
		setBorder(new TitledBorder(null, titulo, TitledBorder.LEADING, TitledBorder.TOP, null, Colors.getRandomColor()));
		setPreferredSize(new Dimension(0, 250)); 
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{50, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		btnClose = new JButton("");
		btnClose.setToolTipText("Eliminar Notificacion");
		btnClose.setBorderPainted(false);
		btnClose.setFocusPainted(false);
		btnClose.setPreferredSize(new Dimension(27, 27));
		btnClose.setIcon(new ImageIcon(PanelNotificacionVentana.class.getResource("/com/nb/nanotificacion/resources/ok-24.png")));
		btnClose.setFocusable(false);
		
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runnable run = new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						setBackground(Colors.getRandomColor());
						for(int i=0; i<getWidth()/17; i++) {
							setBounds(getX()+17, getY()+17, getWidth(), getHeight());
							try {
								Thread.sleep(17);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						ventana.getPanelPricipal().remove(This);
						ventana.repaint();
						ventana.validate();
					}
				};
				
				new Thread(run).start();
				//ventana.getPanelPricipal().remove(This);
				//ventana.repaint();
				//ventana.revalidate();
			}
		});
		
		lblTitulo = new JLabel("");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 13));
		lblTitulo.setFocusable(false);
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		add(lblTitulo, gbc_lblTitulo);
		
		
		GridBagConstraints gbc_btnClose = new GridBagConstraints();
		gbc_btnClose.anchor = GridBagConstraints.EAST;
		gbc_btnClose.insets = new Insets(0, 0, 5, 0);
		gbc_btnClose.gridx = 1;
		gbc_btnClose.gridy = 0;
		add(btnClose, gbc_btnClose);
		
		JLabel lblNewLabel = new JLabel("Comentarios:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFocusable(false);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		
		textAreaComentarios = new JTextArea();
		textAreaComentarios.setWrapStyleWord(true);
		textAreaComentarios.setLineWrap(true);
		textAreaComentarios.setFocusable(false);
		textAreaComentarios.setFont(new Font("Arial", Font.PLAIN, 16));
		scrollPane.setViewportView(textAreaComentarios);
	}

	public JButton getBtnClose() {
		return btnClose;
	}


}
