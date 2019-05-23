/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.List;
import model.ClienteModel;
import model.entities.Cliente;
import model.entities.ClienteImpl;
import view.cliente.ClienteView;

/**
 *
 * @author Rober03
 */
public class ClienteControllerImpl extends AbstractControllerImpl<ClienteView, ClienteModel, Serializable> implements ClienteController{

	@Override
	Cliente getEntidad(List<Serializable> datos) {
		return new ClienteImpl((String)datos.get(0), (String)datos.get(1),(String)datos.get(2));
	}

	@Override
	Cliente getEntidad(Serializable pk) {
		return new ClienteImpl((String)pk);
	}
	
}
