package com.nb.nanotificacion.views.utils;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class CellRenderJCheckBox implements TableCellRenderer{

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		//setSelected(Boolean.parseBoolean(value.toString()));
		JPanel panel = new JPanel();
		
		
		
		 
//		 
		 if(isSelected) {

			   panel.setBackground(table.getSelectionBackground());
			  
		   }else {
			   panel.setBackground(row % 2 == 0 ? new Color(188,228,209) : Color.WHITE);
		   }
//		 
		 
		 JCheckBox ch = new JCheckBox();
		 ch.setSelected(Boolean.parseBoolean(value.toString()));
		 ch.setOpaque(false);
		 panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		 ch.setAlignmentX(Component.CENTER_ALIGNMENT);
		 //ch.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		 panel.add(ch);
		 ///System.out.println("CellRenderCheckBox->getTableCellRendererComponent: "+value);
		 if((Boolean)value) {
			 ch.setEnabled(false);
		 }
//		 
		
		return panel;
	}

}
