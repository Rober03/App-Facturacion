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
public class ClienteImpl implements Cliente{
	private String nombre;
	private String dni;
	private String direccion;
	
	public ClienteImpl(String dni){
		setDni(dni);
	}
	
	public ClienteImpl(String dni, String nombre, String direccion){
		this(dni);
		setNombre(nombre);
		setDireccion(direccion);
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String getDni() {
		return dni;
	}

	@Override
	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String getDireccion() {
		return direccion;
	}

	@Override
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClienteImpl other = (ClienteImpl) obj;
        if ((this.dni == null) ? (other.dni != null) : !this.dni.equals(other.dni)) {
            return false;
        }
        return true;
    }

    public String toString(){
        return getNombre();
    }
	
	
	
}
