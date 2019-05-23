/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import model.entities.Cliente;

/**
 *
 * @author Rober03
 */
public class TableAndComboModelCliente implements TableModel, ComboBoxModel {

	private List<Cliente> clientes = new ArrayList<>();
	private List<TableModelListener> tableListeners = new ArrayList<>();
	private List<ListDataListener> dataListeners = new ArrayList<>();

	private static TableAndComboModelCliente instance;

	private TableAndComboModelCliente() {
	}

	public static TableAndComboModelCliente getInstance() {
		if (instance == null) {
			instance = new TableAndComboModelCliente();
		}
		return instance;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes.clear();
		this.clientes.addAll(clientes);
		fireContentsChanged();
	}

	public void fireContentsChanged() {
		fireContentsChangeTableModel();
		fireContentsChangeData();
	}

	//Table Model Methods
	@Override
	public int getRowCount() {
		return clientes.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int i) {
		switch (i) {
			case 0:
				return "DNI";
			case 1:
				return "Nombre";
			case 2:
				return "Dirección";
			default:
				return null;
		}
	}

	@Override
	public Class<?> getColumnClass(int i) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int i, int i1) {
		return false;
	}

	@Override
	public Object getValueAt(int i, int i1) {
		Cliente c = clientes.get(i);
		switch (i1) {
			case 0:
				return c.getDni();
			case 1:
				return c.getNombre();
			case 2:
				return c.getDireccion();
			default:
				return null;
		}
	}

	@Override
	public void setValueAt(Object o, int i, int i1) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void addTableModelListener(TableModelListener tl) {
		tableListeners.add(tl);
	}

	@Override
	public void removeTableModelListener(TableModelListener tl) {
		tableListeners.remove(tl);
	}

	protected void fireContentsChangeTableModel() {
		TableModelEvent e = new TableModelEvent(this, 0, clientes.size() - 1, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		tableListeners.forEach((t) -> {
			t.tableChanged(e);
		});
	}

	//ComboBox Model Methods
	private Cliente selectCliente = null;

	@Override
    public void setSelectedItem(Object anItem) {
        if (anItem != null) {
            selectCliente = (Cliente) anItem;
            fireContentsChangeData();
        }
    }
	@Override
	public Object getSelectedItem() {
		return selectCliente;
	}

	@Override
	public int getSize() {
		return clientes.size();
	}

	@Override
	public Object getElementAt(int i) {
		return clientes.get(i);
	}

	@Override
	public void addListDataListener(ListDataListener ll) {
		dataListeners.add(ll);
	}

	@Override
	public void removeListDataListener(ListDataListener ll) {
		dataListeners.remove(ll);
	}

	protected void fireContentsChangeData() {
		ListDataEvent e = new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, clientes.size());
		dataListeners.forEach((t) -> {
			t.contentsChanged(e);
		});
	}
}
