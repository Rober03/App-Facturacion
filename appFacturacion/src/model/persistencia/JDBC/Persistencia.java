/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.persistencia.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rober03
 */
public class Persistencia {

	private static String usr = "usuario";
	private static String pass = "clave";
	private static String url = "jdbc:mysql://localhost:3306/facturacion?serverTimezone=UTC";

	private static Connection instance = null;

	public static Connection createConnection() {
		if (instance == null) {
			try {
				instance = DriverManager.getConnection(url, usr, pass);
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return instance;
	}

	public static void closeConnection() {
		if (instance != null) {
			try {
				instance.close();
				instance= null;
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}
}
