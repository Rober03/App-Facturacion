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
import model.entities.ClienteImpl;
import model.entities.Factura;
import model.entities.FacturaImpl;
import model.persistencia.FacturaDAO;

/**
 *
 * @author Rober03
 */
public class FacturaDAOJDBC implements FacturaDAO {

	@Override
	public void create(Factura factura) {
		String sql = "INSERT INTO facturas values ('" + factura.getId() + "','" + factura.getCliente().getDni() + "','" + factura.getImporte() + "')";

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
	public Factura read(String pk) {
		String sql = "SELECT * FROM vfacturas WHERE identificador='" + pk + "'";
		Factura c = null;

		try {
			Statement stm = Persistencia.createConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				c = new FacturaImpl(rs.getString("identificador"), new ClienteImpl(rs.getString("dni"), rs.getString("nombre"), rs.getString("direccion")), Double.parseDouble(rs.getString("importe")));
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
	public void update(Factura factura) {
		String sql = "UPDATE facturas SET id_cliente='" + factura.getCliente().getDni() + "', importe='" + factura.getImporte() + "' WHERE identificador='" + factura.getId() + "'";
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
	public void delete(Factura factura) {
		String sql = "DELETE FROM facturas WHERE identificador='" + factura.getId()+ "'";
		try {
			Statement stm = Persistencia.createConnection().createStatement();
			stm.execute(sql);
			stm.close();
		} catch (SQLException e) {
			System.out.println("Error: método delete");
			e.printStackTrace();
		} finally {
			Persistencia.closeConnection();
		}
	}

	@Override
	public List<Factura> list() {
		String sql = "SELECT * FROM vfacturas";
		List<Factura> f = new ArrayList<>();

		try {
			Statement stm = Persistencia.createConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				f.add(new FacturaImpl(rs.getString("identificador"), new ClienteImpl(rs.getString("dni"), rs.getString("nombre"), rs.getString("direccion")), Double.parseDouble(rs.getString("importe"))));
			}
			stm.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("Error: método list");
			e.printStackTrace();
		} finally {
			Persistencia.closeConnection();
		}
		return f;
	}

	@Override
	public List<Factura> listByCliente(String pk) {
		String sql = "SELECT * FROM vfacturas WHERE dni='"+pk+"'";
		List<Factura> f = new ArrayList<>();

		try {
			Statement stm = Persistencia.createConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				f.add(new FacturaImpl(rs.getString("identificador"), new ClienteImpl(rs.getString("dni"), rs.getString("nombre"), rs.getString("direccion")), Double.parseDouble(rs.getString("importe"))));
			}
			stm.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("Error: método list");
			e.printStackTrace();
		} finally {
			Persistencia.closeConnection();
		}
		return f;
	}

}
