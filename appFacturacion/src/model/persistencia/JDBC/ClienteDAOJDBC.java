/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.persistencia.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.entities.Cliente;
import model.entities.ClienteImpl;
import model.persistencia.ClienteDAO;

/**
 *
 * @author Rober03
 */
public class ClienteDAOJDBC implements ClienteDAO {

	@Override
	public void create(Cliente cliente) {
		String sql = "INSERT INTO clientes values ('" + cliente.getDni() + "','" + cliente.getNombre() + "','" + cliente.getDireccion() + "')";

		try {
			Statement stm = Persistencia.createConnection().createStatement();
			stm.execute(sql);
			stm.close();
		} catch (SQLException e) {
			System.out.println("Error: método create");
			e.printStackTrace();
		} finally {
			Persistencia.closeConnection();
		}
	}

	@Override
	public Cliente read(String pk) {
		String sql = "SELECT * FROM clientes WHERE dni='" + pk + "'";
		Cliente c = null;

		try {
			Statement stm = Persistencia.createConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				c = new ClienteImpl(rs.getString("dni"), rs.getString("nombre"), rs.getString("direccion"));
			}
			stm.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("Error: método read");
			e.printStackTrace();
		} finally {
			Persistencia.closeConnection();
		}
		return c;
	}

	@Override
	public void update(Cliente cliente) {
		String sql = "UPDATE clientes SET nombre='" + cliente.getNombre() + "', direccion='" + cliente.getDireccion() + "' WHERE dni='" + cliente.getDni() + "'";
		try {
			Statement stm = Persistencia.createConnection().createStatement();
			stm.execute(sql);
			stm.close();
		} catch (SQLException e) {
			System.out.println("Error: método update");
			e.printStackTrace();
		} finally {
			Persistencia.closeConnection();
		}
	}

	@Override
	public void delete(Cliente cliente) {
		String sql = "DELETE FROM clientes WHERE dni='" + cliente.getDni()+"'";
		try {
			Statement stm = Persistencia.createConnection().createStatement();
			stm.execute(sql);
			stm.close();
		} catch (SQLException e) {
			System.out.println("Error: método delete");
			e.printStackTrace();
		}finally{
			Persistencia.closeConnection();
		}
	}

	@Override
	public List<Cliente> list() {
		String sql = "SELECT * FROM clientes";
		List<Cliente> listaCliente = new ArrayList<Cliente>();

		try {
			Statement stm = Persistencia.createConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				listaCliente.add(new ClienteImpl(rs.getString("dni"), rs.getString("nombre"), rs.getString("direccion")));
			}
			stm.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("Error: método list");
			e.printStackTrace();
		} finally {
			Persistencia.closeConnection();
		}

		return listaCliente;
	}

}
