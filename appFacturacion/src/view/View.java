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
public interface View <C extends Controller, M extends Model>{
	
	void setModel(M model);
	M getModel();
	void setController(C controller);
	C getController();
	
	void dataModelChange();
	void display();
}
