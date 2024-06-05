package com.nb.nanotificacion.views.utils;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;

public class CellRenderJTextArea  implements TableCellRenderer{

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		   
		   JTextArea cell = new JTextArea(value.toString());
		   JScrollPane scroll = new JScrollPane(cell);
		   scroll.setBorder(new EmptyBorder(0, 0, 0, 0));
		   if(isSelected) {
			   
			   cell.setBackground(table.getSelectionBackground());
		   }else {
			   cell.setBackground(row % 2 == 0 ? new Color(188,228,209) : Color.WHITE);
		   }
		  
		return scroll;
	}
	
	
	
	

}
