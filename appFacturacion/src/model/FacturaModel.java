/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.FacturaController;
import java.util.List;
import model.entities.Factura;

/**
 *
 * @author Rober03
 */
public interface FacturaModel extends Model<FacturaController, Factura, String>{
	List<Factura> listByCliente(String pk);
}
