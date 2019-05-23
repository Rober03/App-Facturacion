/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

/**
 *
 * @author Rober03
 */
public interface Factura extends Entity{

	Cliente getCliente();

	String getId();

	double getImporte();

	void setCliente(Cliente cliente);

	void setId(String id);

	void setImporte(double importe);

	String toString();
	
}
