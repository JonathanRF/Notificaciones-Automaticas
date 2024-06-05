package com.nb.nanotificacion.views.jframe;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.nb.nanotificacion.core.Ln;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

public class Acerca extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea textArea;

	

	/**
	 * Create the dialog.
	 */
	public Acerca(JFrame frame) {
		super(frame,true);
		setTitle("Acerca de");
		 
		 
		getContentPane().setLayout(new BorderLayout());
		//contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Acerca.class.getResource("/com/nb/nanotificacion/resources/iconNaNo.png")));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
			gbc_lblNewLabel.gridheight = 3;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JLabel lblNaNotificacionesV = new JLabel("NA Notificaciones V1.1");
			GridBagConstraints gbc_lblNaNotificacionesV = new GridBagConstraints();
			gbc_lblNaNotificacionesV.anchor = GridBagConstraints.WEST;
			gbc_lblNaNotificacionesV.insets = new Insets(0, 0, 5, 0);
			gbc_lblNaNotificacionesV.gridx = 1;
			gbc_lblNaNotificacionesV.gridy = 0;
			contentPanel.add(lblNaNotificacionesV, gbc_lblNaNotificacionesV);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setPreferredSize(new Dimension(500, 300));
			scrollPane.setBorder(null);
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.gridheight = 2;
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 1;
			gbc_scrollPane.gridy = 1;
			contentPanel.add(scrollPane, gbc_scrollPane);
			{
				textArea = new JTextArea();
				textArea.setForeground(Color.GRAY);
				textArea.setEditable(false);
				scrollPane.setViewportView(textArea);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		init();
		pack();
		setLocationRelativeTo(frame);
		setVisible(true);
		
	}
	
	
	public void init() {
		
		Runnable run = new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println("Iniciando");
					InputStream ps = Ln.class.getResource("/com/nb/nanotificacion/resources/licencia/licencia.txt").openStream();
				    BufferedReader br = new BufferedReader(new InputStreamReader(ps));
				    String linea = null;
				    while((linea = br.readLine())!=null) {
				    	textArea.append(linea+"\n");
				    }
				    br.close();
				    ps.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		
		new Thread(run).start();
		
		
	}

}
