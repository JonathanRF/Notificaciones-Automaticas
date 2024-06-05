package com.nb.nanotificacion.views.panels;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.nb.nanotificacion.controllers.ControllerPanelNotificaciones;
import com.nb.nanotificacion.core.Core;
import com.nb.nanotificacion.models.Notificacion;
import com.nb.nanotificacion.views.jframe.TrayNotificacion;
import com.nb.nanotificacion.views.utils.CellEditorJCheckBox;
import com.nb.nanotificacion.views.utils.CellRenderJCheckBox;
import com.nb.nanotificacion.views.utils.CellRenderJTextArea;
import com.nb.nanotificacion.views.utils.CellTableEditorTextArea;
import com.nb.nanotificacion.views.utils.Colors;
import com.nb.nanotificacion.views.utils.TablaNotificacionesCellRender;
import com.nb.nanotificacion.views.utils.TableModelNotificaciones;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.quartz.CronExpression;
import org.quartz.SchedulerException;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.ScrollPaneConstants;


/**
 * @author XO4C404
 *
 */
public class PanelNotificacionesTarjetas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JScrollPane scrollPane;
	
	
	

	public PanelNotificacionesTarjetas() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.anchor = GridBagConstraints.NORTHWEST;
		gbc_toolBar.insets = new Insets(0, 0, 5, 0);
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 0;
		add(toolBar, gbc_toolBar);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setMnemonic('n');
		btnNewButton.setToolTipText(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.views.panels.PanelNotificaciones.alt1", "Mostrar notificaciones"));
		btnNewButton.setIcon(new ImageIcon(PanelNotificacionesTarjetas.class.getResource("/com/nb/nanotificacion/resources/about-24.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Core.getCore().getNotificacion().showNotificacion();
			}
		});
		
		
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		
		//btnNewButton_1.setIcon(new ImageIcon(PanelNotificacionesTarjetas.class.getResource("/com/nb/nanotificacion/resources/invisible_light_icon&24.png")));
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Core.getCore().getVentanaPrincipal().setVisible(false);
				TrayNotificacion.getTrayNotificacion().getMinimizar().setLabel(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.views.panels.PanelNotificaciones.text5", "Restaurar ventana"));
				
			}
		});
		btnNewButton_1.setToolTipText(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.views.panels.PanelNotificaciones.alt2", "Minimizar aplicaci?n a la barra de notificaciones"));
		btnNewButton_1.setMnemonic('m');
		btnNewButton_1.setIcon(new ImageIcon(PanelNotificacionesTarjetas.class.getResource("/com/nb/nanotificacion/resources/invisible_light_icon&24.png")));
		
		
		
		toolBar.add(btnNewButton_1);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

	    loadNotificaciones();
	}
	
public void loadNotificaciones() {
	
	
	
	
	List<Notificacion> notificaciones = Notificacion.findAll();
	
	for(Notificacion not: notificaciones) {
		
		AddNotificacion(not);
	
	}
}

	public void AddNotificacion(Notificacion not) {

		// TODO Auto-generated method stub
		try {
			String cron = "";
			if (not.getCron() != null) {
				cron = not.getCron();
			} else if (not.getPrioridad() != null) {
				cron = not.getPrioridad().getCron();
			}
			PanelTarjeta pan = new PanelTarjeta(not.getId(), not.getNombre(), not.getComentarios(), cron);
			panel.add(pan);
			scrollPane.repaint();
			scrollPane.validate();
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
				pan.getTextAreaEjecuciones().append(i + ") " + fecha + "\n");

			}

			// agregando evento de eliminar
			pan.getBtnEliminar().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Integer opt = JOptionPane.showConfirmDialog(Core.getCore().getVentanaPrincipal(), "¿Deseas Elimiar la notificación?");
					if (opt == 0) {

						Notificacion not = Notificacion.findById(pan.getId());
						if (not != null) {
							if (not.getId() >= 0) {

								try {
									not.delete();
									Core.getCore().getCoreJob().detenerNotificacion(not.getId());
									panel.remove(pan);
									scrollPane.repaint();
									scrollPane.validate();
								} catch (SchedulerException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}

					}

				}
			});
			pan.getBtnOkNotificacion().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//System.out.println(pan.getId());
					try {
						Core.getCore().getCoreJob().detenerNotificacion(pan.getId());
						pan.getBtnOkNotificacion().setEnabled(false);
					} catch (SchedulerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});

			pan.getBtnAplicarCambios().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						Notificacion not = Notificacion.findById(pan.getId());
						//System.out.println("OK");
						if (not == null) {
							throw new Exception("No se pudo encontrar la notificacion con id: ["+pan.getId()+"]");
						}else {
							//Obteniendo los textos
							not.setNombre(pan.getTxTitulo().getText().trim());
							not.setComentarios(pan.getTxComentarios().getText().trim());
							//Validando CronNuevo
							if(!CronExpression.isValidExpression(pan.getTxCron().getText().trim())) {
								throw new Exception("El cron:["+pan.getTxCron().getText().trim()+"] no es valido");
							}
							not.setCron(pan.getTxCron().getText().trim());
						    //eliminando prioridad
							not.setPrioridad(null);
							not = not.save();
							//Cambiando valores graficos
							//System.out.println("Cron: -->"+not.getCron());
							//System.out.println("Prioridad"+not.getPrioridad());
							pan.update(not.getNombre(), not.getComentarios(), not.getCron(),not);
							
						}
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(Core.getCore().getVentanaPrincipal(), e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						e2.printStackTrace();
						
					}
					
					
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
public static void main(String[] args) {
		JFrame frame = new JFrame("Test");
		frame.setSize(700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PanelNotificacionesTarjetas pan = new PanelNotificacionesTarjetas();
		frame.getContentPane().add(pan);
		frame.setVisible(true);
	}



	
}