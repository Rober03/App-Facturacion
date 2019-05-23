/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import model.entities.Factura;

/**
 *
 * @author Rober03
 */
public class TableModelFactura implements TableModel {

	private List<Factura> facturas = new ArrayList<>();
	private List<TableModelListener> listeners = new ArrayList<>();
	
	public void setFacturas(List<Factura> facturas){
		this.facturas.clear();
		this.facturas.addAll(facturas);
		fireContentsChangeTableModel();
	}

	//Table Model Methods
	@Override
	public int getRowCount() {
		return facturas.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int i) {
		switch (i) {
			case 0:
				return "Identificador";
			case 1:
				return "Cliente";
			case 2:
				return "Importe";
			default:
				return null;
		}
	}

	@Override
	public Class<?> getColumnClass(int i) {
		switch (i) {
			case 0:
				return String.class;
			case 1:
				return String.class;
			case 2:
				return Double.class;
			default:
				return null;
		}
	}

	@Override
	public boolean isCellEditable(int i, int i1) {
		return false;
	}

	@Override
	public Object getValueAt(int i, int i1) {
		Factura f= facturas.get(i);
		switch (i1) {
			case 0:
				return f.getId();
			case 1:
				return f.getCliente().getNombre();
			case 2:
				return f.getImporte();
			default:
				return null;
		}
	}
	
	public Object getRow(int i){
		return facturas.get(i);
	}

	@Override
	public void setValueAt(Object o, int i, int i1) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void addTableModelListener(TableModelListener tl) {
		listeners.add(tl);
	}

	@Override
	public void removeTableModelListener(TableModelListener tl) {
		listeners.remove(tl);
	}
	
	protected void fireContentsChangeTableModel(){
		TableModelEvent e= new TableModelEvent(this, 0, facturas.size(), TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		listeners.forEach((t) -> {
			t.tableChanged(e);
		});
	}

}
