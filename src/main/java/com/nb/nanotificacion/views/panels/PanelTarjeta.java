package com.nb.nanotificacion.views.panels;

import javax.swing.JPanel;

import com.nb.nanotificacion.core.Core;
import com.nb.nanotificacion.models.Notificacion;
import com.nb.nanotificacion.views.utils.Colors;

import javax.swing.border.EmptyBorder;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import org.quartz.CronExpression;

import javax.swing.border.BevelBorder;

public class PanelTarjeta extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	//private Colores color;
	private Color colorMarco;
	private Color colorEditado;
	private Color colorCron;
	private JTextField txTitulo;
	private JTextArea txComentarios;
	private JButton btnEdit;
	private JTextField txCron;
	
	private Long id;
	private Boolean editando;
	private String titulo;
	private String comentarios;
	private String cron;
	private JTextArea textAreaEjecuciones;
	private JButton btnEliminar; 
	private JButton btnOkNotificacion;
	
	private String tituloDefualt;
	private String comentarioDefault;
	private String cronDefualt;
	private JButton btnAplicarCambios;
	
	public PanelTarjeta(Long id,String titulo,String comentarios,String cron) {
		this.id = id;
		this.editando = false;
		this.titulo = titulo;
		this.comentarios = comentarios;
		this.cron = cron;
		
		this.tituloDefualt = titulo;
		this.comentarioDefault = comentarios;
		this.cronDefualt = cron;
		//this.color = Colors.getColorMaterial();
		//setSize(new Dimension(500, 500));
		setPreferredSize(new Dimension(500, 400));
		//setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Actividad 1", TitledBorder.CENTER, TitledBorder.TOP, null, Color.RED));
		this.colorMarco = Colors.getRandomColor();
		this.colorEditado = new Color(255, 225, 155);
		this.colorCron = new Color(145,255,128);
		//setBorder(new CompoundBorder(new EmptyBorder(4, 1, 1, 1), new LineBorder(this.colorMarco, 2, true)));
		setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, this.colorMarco, null, this.colorMarco, null), titulo, TitledBorder.CENTER, TitledBorder.TOP, null, this.colorMarco));
		//setBackground(color.getColorPrincipal()); 
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel_2 = new JPanel();
		//panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), titulo, TitledBorder.CENTER, TitledBorder.TOP, null, this.colorMarco));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		btnEdit = new JButton("");
		btnEdit.setToolTipText(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.views.panels.PanelTarjeta.text3", "Editar tarea"));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(editando == false) {
					btnEdit.setIcon(new ImageIcon(PanelTarjeta.class.getResource("/com/nb/nanotificacion/resources/cancel-24.png")));
					btnEdit.setToolTipText(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.views.panels.PanelTarjeta.text4", "Cancelar edición"));
					btnAplicarCambios.setVisible(true);
					btnOkNotificacion.setEnabled(false);
					btnEliminar.setEnabled(false);
					txTitulo.setBackground(colorEditado);
					txTitulo.setEditable(true);
					txComentarios.setBackground(colorEditado);
					txComentarios.setEditable(true);
					txCron.setBackground(colorEditado);
					txCron.setEditable(true);
					editando = true;
				}else {
					btnEdit.setIcon(new ImageIcon(PanelTarjeta.class.getResource("/com/nb/nanotificacion/resources/survey-24.png")));
					btnEdit.setToolTipText(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.views.panels.PanelTarjeta.text3", "Editar tarea"));
					btnAplicarCambios.setVisible(false);
					btnOkNotificacion.setEnabled(true);
					btnEliminar.setEnabled(true);
					txTitulo.setBackground(Color.white);
					txTitulo.setText(tituloDefualt);
					txTitulo.setEditable(false);
					txComentarios.setBackground(Color.white);
					txComentarios.setText(comentarioDefault);
					txComentarios.setEditable(false);
					txCron.setBackground(Color.white);
					txCron.setEditable(false);
					txCron.setText(cronDefualt);
					editando = false;
				}
			}
		});
		
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.insets = new Insets(0, 0, 0, 5);
		gbc_btnEdit.anchor = GridBagConstraints.EAST;
		gbc_btnEdit.gridx = 0;
		gbc_btnEdit.gridy = 0;
		panel_2.add(btnEdit, gbc_btnEdit);
		btnEdit.setIcon(new ImageIcon(PanelTarjeta.class.getResource("/com/nb/nanotificacion/resources/survey-24.png")));
		btnEdit.setBorderPainted(false);
		btnEdit.setFocusPainted(false);
		btnEdit.setPreferredSize(new Dimension(27, 27));
		
		btnAplicarCambios = new JButton("");
		btnAplicarCambios.setToolTipText(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.views.panels.PanelTarjeta.text5", "Aplicar cambios"));
		
		btnAplicarCambios.setIcon(new ImageIcon(PanelTarjeta.class.getResource("/com/nb/nanotificacion/resources/synchronize-24.png")));
		btnAplicarCambios.setBorderPainted(false);
		btnAplicarCambios.setFocusPainted(false);
		btnAplicarCambios.setPreferredSize(new Dimension(27, 27));
		btnAplicarCambios.setVisible(false);
		GridBagConstraints gbc_btnAplicarCambios = new GridBagConstraints();
		gbc_btnAplicarCambios.insets = new Insets(0, 0, 0, 5);
		gbc_btnAplicarCambios.gridx = 1;
		gbc_btnAplicarCambios.gridy = 0;
		panel_2.add(btnAplicarCambios, gbc_btnAplicarCambios);
		
		btnOkNotificacion = new JButton("");
		btnOkNotificacion.setToolTipText(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.views.panels.PanelTarjeta.text1", "Notificación realizada"));
		
		btnOkNotificacion.setBorderPainted(false);
		btnOkNotificacion.setFocusPainted(false);
		btnOkNotificacion.setPreferredSize(new Dimension(27, 27));
		btnOkNotificacion.setIcon(new ImageIcon(PanelTarjeta.class.getResource("/com/nb/nanotificacion/resources/ok-24.png")));
		GridBagConstraints gbc_btnOkNotificacion = new GridBagConstraints();
		gbc_btnOkNotificacion.insets = new Insets(0, 0, 0, 5);
		gbc_btnOkNotificacion.anchor = GridBagConstraints.EAST;
		gbc_btnOkNotificacion.gridx = 2;
		gbc_btnOkNotificacion.gridy = 0;
		panel_2.add(btnOkNotificacion, gbc_btnOkNotificacion);
		
		btnEliminar = new JButton("");
		btnEliminar.setToolTipText(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.views.panels.PanelTarjeta.text2", "Eliminar tarea"));
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.gridx = 3;
		gbc_btnEliminar.gridy = 0;
		panel_2.add(btnEliminar, gbc_btnEliminar);
		
		btnEliminar.setBorderPainted(false);
		btnEliminar.setFocusPainted(false);
		btnEliminar.setPreferredSize(new Dimension(27, 27));
		btnEliminar.setIcon(new ImageIcon(PanelTarjeta.class.getResource("/com/nb/nanotificacion/resources/full_trash-24.png")));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.insets = new Insets(7, 0, 5, 0);
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Titulo: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		//lblNewLabel.setForeground(color.getTextoPrimario());
		lblNewLabel.setOpaque(false);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		txTitulo = new JTextField(this.titulo);
		txTitulo.setBackground(Color.WHITE);
		txTitulo.setEditable(false);
		
		//textField.setBackground(color.getColorSecundario());
		//textField.setForeground(color.getTextoSecundario());
		GridBagConstraints gbc_txTitulo = new GridBagConstraints();
		gbc_txTitulo.insets = new Insets(0, 0, 0, 2);
		gbc_txTitulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txTitulo.gridx = 1;
		gbc_txTitulo.gridy = 0;
		panel.add(txTitulo, gbc_txTitulo);
		txTitulo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Comentarios:");
		//lblNewLabel_1.setForeground(color.getTextoPrimario());
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(1, 0, 0, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(1, 0, 0, 2);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);
		
		txComentarios = new JTextArea(this.comentarios);
		txComentarios.setWrapStyleWord(true);
		txComentarios.setLineWrap(true);
		//textArea.setEnabled(false);
		txComentarios.setEditable(false);
		//textArea.setForeground(color.getTextoSecundario());
		//textArea.setBackground(color.getColorSecundario());
//		textArea.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				System.out.println("Click: "+e.getClickCount());
//				if(e.getClickCount()==2) {
//					textArea.setEditable(true);
//					textArea.setEnabled(true);
//				}
//			}
//			
//		});
		scrollPane.setViewportView(txComentarios);
		
		JPanel panel_1 = new JPanel();
		//panel_1.setBackground(color.getColorPrincipal());
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.weighty = 0.3;
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 0, 0, 2);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 4;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblExpresinCron = new JLabel("Expresi\u00F3n Cron");
		//lblExpresinCron.setForeground(color.getTextoPrimario());
		GridBagConstraints gbc_lblExpresinCron = new GridBagConstraints();
		gbc_lblExpresinCron.insets = new Insets(0, 0, 5, 5);
		gbc_lblExpresinCron.anchor = GridBagConstraints.WEST;
		gbc_lblExpresinCron.gridx = 0;
		gbc_lblExpresinCron.gridy = 0;
		panel_1.add(lblExpresinCron, gbc_lblExpresinCron);
		
		txCron = new JTextField(this.cron);
		txCron.setBackground(Color.WHITE);
		txCron.setEditable(false);
		//textField_1.setBackground(color.getColorSecundario());
		//textField_1.setForeground(color.getTextoSecundario());
		GridBagConstraints gbc_txCron = new GridBagConstraints();
		gbc_txCron.insets = new Insets(1, 0, 0, 0);
		gbc_txCron.fill = GridBagConstraints.HORIZONTAL;
		gbc_txCron.gridx = 1;
		gbc_txCron.gridy = 0;
		panel_1.add(txCron, gbc_txCron);
		txCron.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Siguientes ejecuciones: ");
		//lblNewLabel_2.setForeground(color.getTextoPrimario());
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.insets = new Insets(1, 0, 2, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 2;
		panel_1.add(scrollPane_1, gbc_scrollPane_1);
		
		textAreaEjecuciones = new JTextArea();
		textAreaEjecuciones.setEditable(false);
		textAreaEjecuciones.setBorder(null);
		//textAreaEjecuciones.setBackground(color.getColorPrincipal());
		scrollPane_1.setViewportView(textAreaEjecuciones);
		
	}
	

	
	public void update(String titulo,String comentarios,String cron,Notificacion notificacion) throws Exception,InterruptedException,ParseException {
		this.titulo = titulo;
		this.comentarios = comentarios;
		this.cron = cron;
		this.tituloDefualt = titulo;
		this.comentarioDefault = comentarios;
		this.cronDefualt = cron;
		((TitledBorder)getBorder()).setTitle(this.titulo);
		
		btnEdit.setIcon(new ImageIcon(PanelTarjeta.class.getResource("/com/nb/nanotificacion/resources/survey-24.png")));
		btnEdit.setToolTipText(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.views.panels.PanelTarjeta.text3", "Editar tarea"));
		btnAplicarCambios.setVisible(false);
		btnOkNotificacion.setEnabled(true);
		btnEliminar.setEnabled(true);
		txTitulo.setBackground(Color.white);
		
		txTitulo.setEditable(false);
		txComentarios.setBackground(Color.white);
		txComentarios.setEditable(false);
		txCron.setBackground(Color.white);
		txCron.setEditable(false);
		editando = false;
		//Actualizando siguientes ejecuciones
		Runnable run = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					textAreaEjecuciones.setText("");
					textAreaEjecuciones.setBackground(colorCron);
					CronExpression exp = new CronExpression(cron);
					Calendar calendar = GregorianCalendar.getInstance();
					Date dt = new Date();
					for (int i = 1; i <= 100; i++) {
						dt = exp.getNextValidTimeAfter(dt);
						calendar.setTime(dt);
						Integer day = calendar.get(Calendar.DAY_OF_WEEK);

						// System.out.println(dt);
						// System.out.println(calendar.get(Calendar.MONTH)+1);
						String fecha = ""
								+ Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.semana." + day, new SimpleDateFormat("E").format(dt))
								+ ", " + calendar.get(Calendar.DAY_OF_MONTH) + " ";
						fecha += Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.sistema.mes." + (calendar.get(Calendar.MONTH) + 1),
								new SimpleDateFormat("MMMM").format(dt));
						fecha += " " + new SimpleDateFormat("HH").format(dt) + ":" + new SimpleDateFormat("mm").format(dt) + ":"
								+ new SimpleDateFormat("ss").format(dt);
						fecha += " " + new SimpleDateFormat("yyyy").format(dt);
						textAreaEjecuciones.append(i + ") " + fecha + "\n");
						textAreaEjecuciones.setCaretPosition(textAreaEjecuciones.getDocument().getLength());
						Thread.sleep(100);
					}
					textAreaEjecuciones.setBackground(Color.WHITE);
					
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		new Thread(run).start();
		
		//eliminando tarea del Job
		Core.getCore().getCoreJob().detenerNotificacion(getId());
		Core.getCore().getCoreJob().AddJob(notificacion);
		repaint();
		validate();
	}

	public JTextArea getTextAreaEjecuciones() {
		return textAreaEjecuciones;
	}

	public void setTextAreaEjecuciones(JTextArea textAreaEjecuciones) {
		this.textAreaEjecuciones = textAreaEjecuciones;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public JButton getBtnOkNotificacion() {
		return btnOkNotificacion;
	}
	
	public JButton getBtnAplicarCambios() {
		return btnAplicarCambios;
	}
	public JTextField getTxTitulo() {
		return txTitulo;
	}
	
	public JTextField getTxCron() {
		return txCron;
	}
	public JTextArea getTxComentarios() {
		return txComentarios;
	}

	public String getTituloDefualt() {
		return tituloDefualt;
	}

	public void setTituloDefualt(String tituloDefualt) {
		this.tituloDefualt = tituloDefualt;
	}

	public String getComentarioDefault() {
		return comentarioDefault;
	}

	public void setComentarioDefault(String comentarioDefault) {
		this.comentarioDefault = comentarioDefault;
	}

	public String getCronDefualt() {
		return cronDefualt;
	}

	public void setCronDefualt(String cronDefualt) {
		this.cronDefualt = cronDefualt;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}
	
	
	
	
}
