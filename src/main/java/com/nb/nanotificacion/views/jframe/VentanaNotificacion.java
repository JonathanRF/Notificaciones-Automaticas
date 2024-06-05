package com.nb.nanotificacion.views.jframe;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.nb.nanotificacion.models.Notificacion;
import com.nb.nanotificacion.views.panels.PanelNotificacionVentana;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.JToggleButton;

public class VentanaNotificacion extends JDialog implements ChangeListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private Rectangle rect;
	private Integer x,y,width,height;
	private JPanel panelHead;
	private JScrollPane scrollPane;
	private JPanel panelPricipal;
	private JPanel panelCentral;
	private JButton btnOk;
	private JLabel lblNewLabel;
	private Thread hiloHideFrame;
	private Boolean mouseIsFront;
	private JToggleButton tgButtonAutoHide;
	private boolean ocultando =false;
	private SimpleDateFormat format;
	private JButton btnNewButton;

	public VentanaNotificacion() {
		mouseIsFront = false;
		//addMouseListener(this);
		format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		setFocusableWindowState(false);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setUndecorated(true);
		Toolkit.getDefaultToolkit();
		setVisible(false);
		setFocusable(false);
		rect = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//x = (rect.width -(rect.width /4));
		//y = (rect.height) ;
		x = (rect.width -(rect.width)/4);
		y = (rect.height- (rect.height/2)) ;
		
		width =  (rect.width /4);
		height =  (rect.height/2);
		
		setBounds(x,y ,width,height);
		//System.out.println("--> "+getHeight());
		//setBounds(rect);
		contentPane = new JPanel();
		//contentPane.addMouseListener(this);
		setBackground(new Color(0, 0, 0,0));
		//setOpacity(0.6f);
		setAlwaysOnTop(true);
		//showNotificacion();
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panelHead = new JPanel();
		panelHead.setBackground(new Color(230, 243, 255));
		contentPane.add(panelHead, BorderLayout.NORTH);
		GridBagLayout gbl_panelHead = new GridBagLayout();
		gbl_panelHead.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panelHead.rowHeights = new int[]{0, 0};
		gbl_panelHead.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelHead.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelHead.setLayout(gbl_panelHead);
		
		btnOk = new JButton("");
		btnOk.setToolTipText("Ocultar notificaciones");
		btnOk.setPreferredSize(new Dimension(28, 28));
		btnOk.setIcon(new ImageIcon(VentanaNotificacion.class.getResource("/com/nb/nanotificacion/resources/internal-24.png")));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				hideNotificacion();
			}
		});
		
		lblNewLabel = new JLabel("NA Notificaciones");
		lblNewLabel.setForeground(new Color(51, 153, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panelHead.add(lblNewLabel, gbc_lblNewLabel);
		
		tgButtonAutoHide = new JToggleButton("");
		tgButtonAutoHide.setPreferredSize(new Dimension(28, 28));
		tgButtonAutoHide.setToolTipText("las notificaciones se ocultan automaticamente");
		tgButtonAutoHide.setIcon(new ImageIcon(VentanaNotificacion.class.getResource("/com/nb/nanotificacion/resources/feed_in-24.png")));
		tgButtonAutoHide.addChangeListener(this);
		
		btnNewButton = new JButton("");
		btnNewButton.setToolTipText("Eliminar todas las notificaciones");
		btnNewButton.setPreferredSize(new Dimension(28, 28));
		btnNewButton.setIcon(new ImageIcon(VentanaNotificacion.class.getResource("/com/nb/nanotificacion/resources/full_trash-24.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPricipal.removeAll();
				panelPricipal.repaint();
		    	panelPricipal.validate();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		panelHead.add(btnNewButton, gbc_btnNewButton);
		GridBagConstraints gbc_tgButtonAutoHide = new GridBagConstraints();
		gbc_tgButtonAutoHide.insets = new Insets(0, 0, 0, 5);
		gbc_tgButtonAutoHide.gridx = 2;
		gbc_tgButtonAutoHide.gridy = 0;
		panelHead.add(tgButtonAutoHide, gbc_tgButtonAutoHide);
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.anchor = GridBagConstraints.EAST;
		gbc_btnOk.gridx = 3;
		gbc_btnOk.gridy = 0;
		panelHead.add(btnOk, gbc_btnOk);
		
		panelCentral = new JPanel();
		panelCentral.setBackground(Color.WHITE);
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		//scrollPane.addMouseListener(this);
		panelCentral.add(scrollPane, BorderLayout.CENTER);
		
		
		panelPricipal = new JPanel();
		panelPricipal.setBackground(Color.WHITE);
		//scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(panelPricipal);
		panelPricipal.setLayout(new BoxLayout(panelPricipal, BoxLayout.Y_AXIS));
		
		//initCoreHide();
	}
	

	
	
	public  void hideNotificacion() {
		Runnable run = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=9; i>=0; i--) {
					Float f = new Float("0."+i);
					//System.out.println(f);
					setOpacity(f);
					try {
						Thread.sleep(40);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				setBounds(x, y, width, height);
				setOpacity(1.0f);
				setVisible(false);
				ocultando = false;
				//showNotificacion();
			}
		};
		//System.out.println("Iniciando HideNotificacion");
		if(isVisible()) {
			new Thread(run).start();
		}
		
		
	}
	
	private synchronized void autoHide(final Long sec) {
		ocultando = true;
		Runnable run = new Runnable() {
			
			@Override
			public void run() {
				try {
					if(!isVisible()) {
						return;
					}
					
					
					Thread.sleep( (sec)*1000);
					//Evaluando si el boton de bloqueo esta activado
					if(tgButtonAutoHide.isSelected()) {
						autoHide(sec);
						return;
					}
					//System.out.println("id :"+this.hashCode());
					if(mouseIsFront) {
						return;
					}
					
					hideNotificacion();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		};
		
		if(isVisible()) {
			
		        	this.hiloHideFrame = new Thread(run);
					this.hiloHideFrame.start();
		}
		
		
	}
	
	public synchronized void showNotificacion() {
		
		
		
		if(!ocultando) {
			setVisible(true);
			autoHide(10L);	
		}
			
		
	}
	
    public void addNotificacion(Notificacion notificacion) {
    	if(notificacion!=null) {
    		panelPricipal.add(new PanelNotificacionVentana(notificacion.getPrioridad().getNombre(), notificacion.getNombre(), notificacion.getComentarios(), this),0);
    		panelPricipal.repaint();
        	panelPricipal.validate();
    		showNotificacion();
    	}
    }
    
    public void addNotificacion(final String tipo,final String titulo,final String comentarios) {
    	//Verificando cuantas notificacioes existen
    	
    	Runnable run = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					PanelNotificacionVentana not = new PanelNotificacionVentana(tipo, titulo+" "+format.format(new Date()), comentarios, getThis());
			    	panelPricipal.add(not,0);
			    	panelPricipal.repaint();
			    	panelPricipal.validate();
					showNotificacion();
				} catch (Exception e) {
					// TODO: handle exception
				}
			
			}
		};
		
		new Thread(run).start();
    	
    }

	public JPanel getPanelPricipal() {
		return panelPricipal;
	}
	
	public VentanaNotificacion getThis() {
		return this;
	}
	


	public Boolean getMouseIsFront() {
		return mouseIsFront;
	}


	public void setMouseIsFront(Boolean mouseIsFront) {
		this.mouseIsFront = mouseIsFront;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
        if(tgButtonAutoHide.isSelected()) {
        	tgButtonAutoHide.setIcon(new ImageIcon(VentanaNotificacion.class.getResource("/com/nb/nanotificacion/resources/do_not_insert-24.png")));
        	tgButtonAutoHide.setToolTipText("las notificaciones no se ocultan automaticamente");
        }else {
        	tgButtonAutoHide.setIcon(new ImageIcon(VentanaNotificacion.class.getResource("/com/nb/nanotificacion/resources/feed_in-24.png")));
        	tgButtonAutoHide.setToolTipText("las notificaciones se ocultan automaticamente");
        }
	}
	



}
