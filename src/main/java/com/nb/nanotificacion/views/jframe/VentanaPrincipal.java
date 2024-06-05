package com.nb.nanotificacion.views.jframe;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenu;

import com.nb.nanotificacion.core.Core;
import com.nb.nanotificacion.views.panels.PanelPrincipal;
import javax.swing.border.EtchedBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class VentanaPrincipal extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private PanelPrincipal panelPrincipal;
	private JProgressBar progressBar;
	private JLabel lbLog;
	private JMenuItem mntmSalir;
	private JMenuItem mnAcerca;

	
	/**
	 * Create the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public VentanaPrincipal() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/com/nb/nanotificacion/resources/iconNaNo.png")));
		setTitle("NA Notificaci\u00F3n v1.1");
		setBackground(Color.WHITE);
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(740, 650));
		//setSize(650, 470);
		setLocationRelativeTo(null);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.menu.archivo", "Archivo"));
		mnArchivo.setMnemonic('a');
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.menu.archivo.salir", "Salir"));
		mntmSalir.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/com/nb/nanotificacion/resources/on-off_icon&16.png")));
		mnArchivo.add(mntmSalir);
		
		mntmSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int opt = JOptionPane.showConfirmDialog(Core.getCore().getVentanaPrincipal(),Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.menu.archivo.salir.option.1", "¿Deseas salir de Na Notificaciones?"));
				if(opt == 0) {
					System.exit(0);
				}
			}
		});
		
		JMenu mnConfiguracion = new JMenu(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.menu.configuracion", "Configuración"));
		menuBar.add(mnConfiguracion);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Proximamente");
		mnConfiguracion.add(mntmNewMenuItem);
		
		JMenu mnAyuda = new JMenu(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.menu.ayuda", "Ayuda"));
		mnAyuda.setMnemonic('h');
		menuBar.add(mnAyuda);
		
		mnAcerca = new JMenuItem(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.menu.ayuda.ayuda", "Acerca de NA Notificacion"));
		mnAcerca.addActionListener(this);
		mnAcerca.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/com/nb/nanotificacion/resources/faq-24.png")));
		mnAyuda.add(mnAcerca);
		
		panelPrincipal = new PanelPrincipal();
		panelPrincipal.setBackground(Color.WHITE);
		getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		lbLog = new JLabel("");
		lbLog.setForeground(new Color(128, 128, 128));
		lbLog.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lbLog);
		
		progressBar = new JProgressBar();
		panel.add(progressBar);
	}

	public PanelPrincipal getPanelPrincipal() {
		return panelPrincipal;
	}
	public JLabel getLbLog() {
		return lbLog;
	}
	public JProgressBar getProgressBar() {
		return progressBar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(mnAcerca)) {
			new Acerca(this);
		}
	}
}
