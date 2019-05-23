/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.List;
import model.FacturaModel;
import model.entities.Cliente;
import model.entities.Factura;
import model.entities.FacturaImpl;
import view.factura.FacturaView;

/**
 *
 * @author Rober03
 */
public class FacturaControllerImpl extends AbstractControllerImpl<FacturaView, FacturaModel, Serializable> implements FacturaController{

	@Override
	Factura getEntidad(List<Serializable> datos) {
		return new FacturaImpl((String)datos.get(0), (Cliente)datos.get(1), Double.parseDouble((String)datos.get(2)));
	}

	@Override
	Factura getEntidad(Serializable pk) {
		return new FacturaImpl((String)pk);
	}
	
}
