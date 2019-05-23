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
public interface Cliente extends Entity{

	String getDireccion();

	String getDni();

	String getNombre();

	void setDireccion(String direccion);

	void setDni(String dni);

	void setNombre(String nombre);

	String toString();
	
}
