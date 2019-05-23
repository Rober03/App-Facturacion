/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import model.Model;

/**
 *
 * @author Rober03
 * @param <C>
 * @param <M>
 */
public abstract class AbstractViewImpl<C extends Controller, M extends Model> extends javax.swing.JPanel implements View<C, M> {

	private M model;
	private C controller;

	@Override
	public void setModel(M model) {
		this.model = model;
	}

	@Override
	public M getModel() {
		return model;
	}

	@Override
	public void setController(C controller) {
		this.controller = controller;
	}

	@Override
	public C getController() {
		return controller;
	}

	@Override
	public void dataModelChange() {
		refresh();
	}

	protected abstract void refresh();

	@Override
	public void display() {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				setVisible(true);
				refresh();
			}
		});
	}

}
