package com.nb.nanotificacion.views.utils;

import java.awt.Component;
import java.util.EventObject;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;

public class CellTableEditorTextArea extends JScrollPane implements TableCellEditor {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scroll;
    private JTextArea textArea;
    
    
    public CellTableEditorTextArea() {
		// TODO Auto-generated constructor stub
    	this.textArea = new JTextArea();
    	textArea.setEditable(false);
    	this.scroll = new JScrollPane(textArea);
    	scroll.setBorder(new EmptyBorder(0, 0, 0, 0));
    	//scroll.setBorder(new LineBorder(new Color(255, 0, 0), 1, true));
    	scroll.setInheritsPopupMenu(true);
	}
	@Override
	public void addCellEditorListener(CellEditorListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelCellEditing() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCellEditable(EventObject anEvent) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void removeCellEditorListener(CellEditorListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean shouldSelectCell(EventObject anEvent) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean stopCellEditing() {
		// TODO Auto-generated method stub
		//this.removeAll();
		return true;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		this.textArea.setText(value.toString());
		return scroll;
	}

}
