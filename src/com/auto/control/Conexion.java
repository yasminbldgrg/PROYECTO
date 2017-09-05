package com.auto.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

	private Connection conn = null;
	private PreparedStatement sentencia = null;
	private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver"; // 
	
	// Indicamos nuestra base de datos, para el ejemplo: tienda
	private static final String DB_URL = "jdbc:mariadb://localhost/auto"; //127.0.0_192.168.7.161 tienda como se llama la base de datos

	/**********************************************************************************************************************
	 * CONSTRUCTOR
	 ***********************************************************************************************************************/

	public Conexion() {

		// Database credentials
		String USER = "root"; 
		String PASS = "";
		try {
			// Paso 2: Registrar JDBC driver
			Class.forName(JDBC_DRIVER);

			// Paso 3: Abrir la coneccion
			System.out.println("Conectando a la base de datos...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS); // br url donde sta la base de datos
		} catch (SQLException se) { // manejo de excepciones
			// Errores de JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Otras excepciones
			e.printStackTrace();
		}

	}

	/**********************************************************************************************************************
	 * CONSULTA SQL
	 ***********************************************************************************************************************/

	public void SQL(String sql) throws Throwable { // consulta sicuol
		sentencia = conn.prepareStatement(sql);
	}

	/**********************************************************************************************************************
	 * RESULTADO DE LA CONSULTA SELECT
	 ***********************************************************************************************************************/

	public ResultSet resultSet() throws Throwable {
		return sentencia.executeQuery();
	}

	/**********************************************************************************************************************
	 * CREATE UPDATE AND DELETE
	 ***********************************************************************************************************************/

	public int CUD() throws Throwable {
		return sentencia.executeUpdate();

	}

	/**********************************************************************************************************************
	 * CERRAR CONEXION
	 ***********************************************************************************************************************/

	public void close() throws SQLException {
		if (sentencia != null) {
			sentencia.close();
		}

		if (conn != null) {
			conn.close();
		}
	}

	/**********************************************************************************************************************
	 * SENTENCIA PARA EJECUCIÓN
	 ***********************************************************************************************************************/

	public PreparedStatement preparedStatement() {
		return sentencia;
	}

}
