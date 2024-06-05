package com.nb.nanotificacion.views.utils;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TablaNotificacionesCellRender extends DefaultTableCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		//System.out.println("ROW: "+row+" = "+(row%2));
		setBackground(row % 2 == 0 ? new Color(188,228,209): Color.WHITE);
		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}
}
