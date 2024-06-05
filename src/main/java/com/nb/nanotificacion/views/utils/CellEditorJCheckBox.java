package com.nb.nanotificacion.views.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.AbstractCellEditor;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import org.quartz.SchedulerException;

import com.nb.nanotificacion.core.Core;

public class CellEditorJCheckBox extends AbstractCellEditor implements TableCellEditor{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JCheckBox chechBox;
	private JPanel panel;
	private Long id;
	
	public CellEditorJCheckBox() {
		super();
		this.chechBox = new JCheckBox();
		this.panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		 chechBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		 //ch.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		 panel.add(chechBox);
		
		 chechBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("Click: "+chechBox.isSelected());
				
				if(chechBox.isSelected()) {
					//System.out.println("Disparando stopEditing");
					stopCellEditing();
					try {
						//System.out.println("Todos los jobs: "+id);
						Core.getCore().getCoreJob().detenerNotificacion(id);
					} catch (SchedulerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                   
				}
				
				
				
			}
		});
		 
	}

//	@Override
//	public void addCellEditorListener(CellEditorListener l) {
//		// TODO Auto-generated method stub
//		System.out.println("CellEdtitorCheckBox->addCellEditorListener:  Aqui ");
//	}
//
//	@Override
//	public void cancelCellEditing() {
//		// TODO Auto-generated method stub
//		System.out.println("CellEdtitorCheckBox->cancelCellEditing:  Aqui ");
//	}

	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		//System.out.println("CellEditorCheckBox: Obteniendo getCellEitorValue");
		return chechBox.isSelected();
	}

//	@Override
//	public boolean isCellEditable(EventObject anEvent) {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public void removeCellEditorListener(CellEditorListener l) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public boolean shouldSelectCell(EventObject anEvent) {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean stopCellEditing() {
//		// TODO Auto-generated method stub
//		return true;
//	}

	@SuppressWarnings("unchecked")
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		 //Obteniendo el id de la notificacion
		//System.out.println("Fila: "+row);
		DefaultTableModel modelo = (DefaultTableModel)table.getModel();
		
		//notificacion = (Notificacion)modelo.getDataVector().get(row);
		
		
		//id = (Long)modelo.getDataVector().get(row);
		this.id = (Long)((Vector<Object>)modelo.getDataVector().get(row)).get(4);
		
		//System.out.println("--> "+((Vector<Object>)modelo.getDataVector().get(row)).get(4));
		 if(isSelected) {
			   panel.setBackground(table.getSelectionBackground());
			  
		   }else {
			   panel.setBackground(row % 2 == 0 ? new Color(188,228,209) : Color.WHITE);
		   }
//		 
		 
		 chechBox.setSelected(Boolean.parseBoolean(value.toString()));
		 chechBox.setOpaque(false);
		 
		 if((Boolean)value) {
			 chechBox.setEnabled(false);
		 }
		 
		 
		 //System.out.println("-----------------> ");
		 //System.out.println("Original: "+value);
		 //System.out.println("Check: "+chechBox.isSelected());
		 stopCellEditing();
		return panel;
	}

}
