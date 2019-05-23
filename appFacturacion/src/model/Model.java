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

/**
 *
 * @author Rober03
 * @param <C>
 * @param <T>
 * @param <D>
 */
public interface Model <C extends Controller, T extends Entity, D extends Serializable> {
	void setController(C controller);
	C getController();
	
	void añadirEntidad(T entidad);
	void borrarEntidad(T entidad);
	void actualizarEntidad(T entidad);
	
	T obtenerEntidad(D pk);
	List<T> listarEndidad();
}
