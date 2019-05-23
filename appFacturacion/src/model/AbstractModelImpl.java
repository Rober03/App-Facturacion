/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Controller;
import java.io.Serializable;
import java.util.List;
import model.entities.Entity;
import model.persistencia.GenericDAO;

/**
 *
 * @author Rober03
 * @param <C>
 * @param <E>
 * @param <D>
 */
public abstract class AbstractModelImpl <C extends Controller, E extends Entity, D extends Serializable> implements Model<C, E, D>{
	private C controller;
	
	
	@Override
	public void setController(C controller) {
		this.controller= controller;
	}

	@Override
	public C getController() {
		return controller;
	}

	@Override
	public void añadirEntidad(E entidad) {
		getDAO().create(entidad);
		controller.fireDataModelChange();
	}

	@Override
	public void borrarEntidad(E entidad) {
		getDAO().delete(entidad);
		controller.fireDataModelChange();
	}

	@Override
	public void actualizarEntidad(E entidad) {
		getDAO().update(entidad);
		controller.fireDataModelChange();
	}

	@Override
	public E obtenerEntidad(D pk) {
		return (E)getDAO().read(pk);
	}

	@Override
	public List<E> listarEndidad() {
		return getDAO().list();
	}
	
	abstract GenericDAO getDAO();
}
