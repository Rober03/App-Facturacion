/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.FacturaController;
import java.util.List;
import model.entities.Factura;
import model.persistencia.GenericDAO;
import model.persistencia.JDBC.FacturaDAOJDBC;

/**
 *
 * @author Rober03
 */
public class FacturaModelImpl extends AbstractModelImpl<FacturaController, Factura, String> implements FacturaModel{

	@Override
	GenericDAO getDAO() {
		return new FacturaDAOJDBC();
	}

	@Override
	public List<Factura> listByCliente(String pk) {
		return ((FacturaDAOJDBC)getDAO()).listByCliente(pk);
	}
	
}
