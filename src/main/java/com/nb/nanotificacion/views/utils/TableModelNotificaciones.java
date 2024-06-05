package com.nb.nanotificacion.views.utils;

import javax.swing.table.DefaultTableModel;


public class TableModelNotificaciones extends DefaultTableModel{
     
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TableModelNotificaciones(Object[][] filas,Object[] columnas) {
		// TODO Auto-generated constructor stub
		super(filas,columnas);
	}
	
	
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		
//		
//		if(columnIndex == 3) {
//			return Boolean.class;
//		}
		
		return super.getColumnClass(columnIndex);
	}
	
	
	
}
