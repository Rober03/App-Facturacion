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
public class FacturaImpl implements Factura {
	private String id;
	private Cliente cliente;
	private double importe;
	
	public FacturaImpl(String id){
		setId(id);
	}
	
	public FacturaImpl(String id, Cliente cliente, double importe){
		this(id);
		setCliente(cliente);
		setImporte(importe);
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public Cliente getCliente() {
		return cliente;
	}

	@Override
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public double getImporte() {
		return importe;
	}

	@Override
	public void setImporte(double importe) {
		this.importe = importe;
	}

	@Override
	public String toString() {
		return '{' + "id=" + id + ", cliente=" + cliente + ", importe=" + importe + '}';
	}

}
