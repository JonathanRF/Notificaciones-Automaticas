package com.nb.nanotificacion.views.panels;

import javax.swing.JPanel;
import java.awt.Color;
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
import com.nb.nanotificacion.views.utils.TablaNotificacionesCellRender;
import com.nb.nanotificacion.views.utils.TableModelNotificaciones;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@Deprecated
public class PanelNotificaciones extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable tablaNotificaciones;
	private TableModelNotificaciones modelo;
	private JButton btnHideWindow;
	private JButton btnDeleteNotificacion;
	private JButton btnShowNotificacion;

	
	public PanelNotificaciones() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		tablaNotificaciones = new JTable();
		tablaNotificaciones.getTableHeader().setReorderingAllowed(false);
		tablaNotificaciones.setSelectionBackground(new Color(100,193,149));
		tablaNotificaciones.setOpaque(false);
		
		String columns[] = {
				Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.views.panels.PanelNotificaciones.text1", "Perido de notificaci?n"),
				Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.views.panels.PanelNotificaciones.text2", "Titulo"),
				Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.views.panels.PanelNotificaciones.text3", "Comentario"),
				Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.views.panels.PanelNotificaciones.text4", "Realizado"),
				"id"
		};
		modelo = new TableModelNotificaciones(new Object[][] {
			
		},
		new String[] {//com.nb.nanotificacion.views.panels.PanelNotificaciones.text3=
				columns[0].length() == 0 ? "Perido de notificaci?n" :columns[0].trim(),
				columns[1].length() == 0 ? "Titulo" :columns[1].trim(),
				columns[2].length() == 0 ? "Comentario" :columns[2].trim(),
				columns[3].length() == 0 ? "Realizado" :columns[3].trim(),
				columns[4].length() == 0 ? "id" :columns[4].trim(),
			
		});
		
		tablaNotificaciones.setModel(modelo);
		//scrollPane = new JScrollPane(new PanelNotificacionesTarjetas());
		scrollPane = new JScrollPane(tablaNotificaciones);
		scrollPane.setOpaque(false);
		add(scrollPane, BorderLayout.CENTER);
		//add(new PanelNotificacionesTarjetas());
		tablaNotificaciones.removeColumn(tablaNotificaciones.getColumn("id"));
		
		tablaNotificaciones.setDefaultRenderer(Object.class, new TablaNotificacionesCellRender());
		//tablaNotificaciones.setDefaultRenderer(CellRenderJTextArea.class, new CellRenderJTextArea());
		tablaNotificaciones.setRowHeight(140);
		
		tablaNotificaciones.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				btnDeleteNotificacion.setEnabled(true);
				
			}
		});
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		add(toolBar, BorderLayout.NORTH);
		
		btnShowNotificacion = new JButton("");
		btnShowNotificacion.setFocusable(false);
		btnShowNotificacion.setMnemonic('n');
		btnShowNotificacion.setToolTipText(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.views.panels.PanelNotificaciones.alt1", "Mostrar notificaciones"));
		btnShowNotificacion.setIcon(new ImageIcon(PanelNotificaciones.class.getResource("/com/nb/nanotificacion/resources/about-24.png")));
		btnShowNotificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Core.getCore().getNotificacion().showNotificacion();
			}
		});
		toolBar.add(btnShowNotificacion);
		
		btnHideWindow = new JButton("");
		btnHideWindow.setFocusable(false);
		btnHideWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Core.getCore().getVentanaPrincipal().setVisible(false);
				TrayNotificacion.getTrayNotificacion().getMinimizar().setLabel(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.views.panels.PanelNotificaciones.text5", "Restaurar ventana"));
				
			}
		});
		btnHideWindow.setToolTipText(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.views.panels.PanelNotificaciones.alt2", "Minimizar aplicaci?n a la barra de notificaciones"));
		btnHideWindow.setMnemonic('m');
		btnHideWindow.setIcon(new ImageIcon(PanelNotificaciones.class.getResource("/com/nb/nanotificacion/resources/invisible_light_icon&24.png")));
		toolBar.add(btnHideWindow);
		toolBar.addSeparator();
		
		btnDeleteNotificacion = new JButton("");
		btnDeleteNotificacion.setFocusable(false);
		
		btnDeleteNotificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					if(modelo.getDataVector().size() == 0) {
						btnDeleteNotificacion.setEnabled(false);
						return;
					}
					Long id = (Long)modelo.getValueAt(tablaNotificaciones.getSelectedRow(), 4);
					//System.out.println("Eliminando: "+id);
					Notificacion not = Notificacion.findById(id);
					//JOptionPane.showMessageDialog(Core.getCore().getVentanaPrincipal(), "Deseas eliminar la notificacion\n\""+not.getNombre()+"\"", "Confirma eliminacion", JOptionPane.OK_CANCEL_OPTION);
					//JOptionPane.showMessageDialog(Core.getCore().getVentanaPrincipal(), "AASDASD");
					int opt = JOptionPane.showConfirmDialog(Core.getCore().getVentanaPrincipal(),Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.views.panels.PanelNotificaciones.text6", "?Deseas eliminar la notificacion: ")+ "\n\""+not.getNombre()+"\" ?");
					if(opt == 0) {
						Core.getCore().resetLog();
						Core.getCore().setInfo("Deteniendo Job");
						Core.getCore().getCoreJob().detenerNotificacion(not.getId());
						Core.getCore().setInfo("Eliminando de la tatabla");
						modelo.removeRow(tablaNotificaciones.getSelectedRow());
						Core.getCore().setInfo("Eliminando de la BD");
						not.delete();
						Core.getCore().resetLog();
					}
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(Core.getCore().getVentanaPrincipal(), "Ocurrio un error:\n"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
				
			}
		});
		btnDeleteNotificacion.setEnabled(false);
		btnDeleteNotificacion.setToolTipText(Core.getCore().getIdioma().getProperty("com.nb.nanotificacion.views.panels.PanelNotificaciones.alt3", "Eliminar Notificaci?n"));
		btnDeleteNotificacion.setIcon(new ImageIcon(PanelNotificaciones.class.getResource("/com/nb/nanotificacion/resources/delete_row-24.png")));
		toolBar.add(btnDeleteNotificacion);
		
		//modificando tama?o de columnas
		
	    tablaNotificaciones.getColumn(tablaNotificaciones.getColumnName(3)).setMinWidth(65);
	    tablaNotificaciones.getColumn(tablaNotificaciones.getColumnName(3)).setMaxWidth(65);
	   
	    
		
	    tablaNotificaciones.getColumn(tablaNotificaciones.getColumnName(2)).setCellRenderer(new CellRenderJTextArea());
	    tablaNotificaciones.getColumn(tablaNotificaciones.getColumnName(2)).setCellEditor(new CellTableEditorTextArea());
	    tablaNotificaciones.getColumn(tablaNotificaciones.getColumnName(3)).setCellRenderer(new CellRenderJCheckBox());
	    tablaNotificaciones.getColumn(tablaNotificaciones.getColumnName(3)).setCellEditor(new CellEditorJCheckBox());
	   
	    cargaDatosIniciales();
	    
	}
	
	
	public void cargaDatosIniciales() {
		//cargando notificaciones
		for(Notificacion not: ControllerPanelNotificaciones.getAllNotificaciones()) {
			if(not!=null) {
				Object row[] = {"","","",false,not.getId()};
				if(not.getPrioridad()!=null) {
					row[0]=not.getPrioridad().getNombre();
					row[1]=not.getNombre();
					row[2]=not.getComentarios();
					row[3]=false;
					row[4]=not.getId();
				}else {
					if(not.getCron()!=null) {
						row[0]="Notificaci?n Personalizada";
						row[1]=not.getNombre();
						row[2]=not.getComentarios();
						row[3]=false;
						row[4]=not.getId();
					}
				}
				modelo.addRow(row);
			}
		
		}
	}

	public JTable getTablaNotificaciones() {
		return tablaNotificaciones;
	}


	public TableModelNotificaciones getModelo() {
		return modelo;
	}


	public void setModelo(TableModelNotificaciones modelo) {
		this.modelo = modelo;
	}
	
	
}