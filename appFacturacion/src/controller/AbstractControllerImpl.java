/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Model;
import model.entities.Entity;
import view.View;

/**
 *
 * @author Rober03
 * @param <M>
 * @param <V>
 * @param <D>
 */
public abstract class AbstractControllerImpl<V extends View, M extends Model, D extends Serializable> implements Controller<V, M, D> {

	private List<V> views = new ArrayList<>();
	private M model;

	public void start() {
		for (V view : views) {
			view.display();
		}
	}

	public void setup(List<V> views, M model) {
		model.setController(this);
		this.setModel(model);
		
		for (V view : views) {
			view.setController(this);
			view.setModel(model);
			addView(view);
		}
	}

	public void setModel(M model) {
		this.model = model;
	}

	public M getModel() {
		return model;
	}

	public void addView(V view) {
		views.add(view);
	}

	public void removeView(V view) {
		views.remove(view);
	}

	public void añadirEntidadGesture(List<D> datos){
		model.añadirEntidad(getEntidad(datos));
	}

	public void borrarEntidadGesture(D pk){
		model.borrarEntidad(getEntidad(pk));
	}

	public void actualizarEntidadGesture(List<D> datos){
		model.actualizarEntidad(getEntidad(datos));
	}

	public void fireDataModelChange() {
		for (V view : views) {
			view.dataModelChange();
		}
	}
	
	abstract Entity getEntidad(List<D> datos);
	abstract Entity getEntidad(D pk);
	

}
