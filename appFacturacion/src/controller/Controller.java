/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.List;
import model.Model;
import view.View;

/**
 *
 * @author Rober03
 * @param <V>
 * @param <M>
 * @param <D>
 */
public interface Controller <V extends View, M extends Model, D extends Serializable> {
	
	void start();
	void setup(List<V> views, M model);
	
	void setModel(M model);
	M getModel();
	void addView(V view);
	void removeView(V view);
	
	void añadirEntidadGesture(List<D> datos);
	void borrarEntidadGesture(D pk);
	void actualizarEntidadGesture(List<D> datos);
	
	void fireDataModelChange();
}
