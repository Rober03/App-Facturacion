/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ClienteController;
import model.entities.Cliente;
import model.persistencia.GenericDAO;
import model.persistencia.JDBC.ClienteDAOJDBC;

/**
 *
 * @author Rober03
 */
public class ClienteModelImpl extends AbstractModelImpl<ClienteController, Cliente, String> implements ClienteModel{

	@Override
	GenericDAO getDAO() {
		return new ClienteDAOJDBC();
	}
}
