package com.auto.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.auto.entity.Compra;

public class CompraCtrl implements Control<Compra>{  // implementa los metodos de control para cliente a interfase insert search delete update
	
	private Conexion conexion; // unico atributo
	
	public CompraCtrl (Conexion conexion) { //constructor de la clase conexion se ocupa de conectar java con la base de datos y es una interfase de datos 
		this.conexion = conexion;             
	}

	/*
	 * *****************************************************************************
	 * List
	 ******************************************************************************/
	public ArrayList<Compra> list() throws Throwable { //arraylist es una estructura de tipo arreglo con tamaño indefinido es una estructura dinamica
		ArrayList<Compra> compras = new ArrayList<Compra>();//devolver una lista cliente
		ResultSet rs; //donde se guardan los resultados de nuestra consulta
		int codigoCompra;
		int codigoAuto;
		int cantidad;

		conexion.SQL("Select * from compra"); // metemos la consulta

		rs = conexion.resultSet(); // guarda el resultado de la consulta y devuelve todo lo de la consulta

		while (rs.next()) { // while para que vaya recoriendo y nos devuelva todos los elementos del rs 
			codigoCompra = rs.getInt("codigoCompra");
			codigoAuto = rs.getInt("codigoAuto");
			cantidad = rs.getInt("cantidad");
			compras.add(new Compra(codigoCompra, codigoAuto, cantidad)); // añade cliente nuevo 
		}

		return compras;

	}

	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	public void insert1(Compra compra) throws Throwable {

		conexion.SQL("Insert into compra(codigoCompra,codigoAuto,cantidad) VALUES(?,?,?)");//?? son parametros esta esperando dos parametros
		conexion.preparedStatement().setInt(1, compra.getCodigoCompra()); // set tipo de datos
		conexion.preparedStatement().setInt(2, compra.getCodigoAuto());
		conexion.preparedStatement().setInt(3, compra.getCantidad());
		conexion.CUD();

	}

	/*
	 * *****************************************************************************
	 * Search
	 ******************************************************************************/

	public void search1(Compra compra) throws Throwable { // recibe el cliente y va buscar la clave del cliente y devulve el nombre a ese cliente y lo cierra

		ResultSet rs;

		conexion.SQL("Select * from compra where codigoCliente=?");
		conexion.preparedStatement().setInt(1, compra.getCodigoCompra());
		rs = conexion.resultSet();

		while (rs.next()) {

			compra.setCodigoAuto(rs.getInt("CodigoAuto"));
			compra.setCantidad(rs.getInt("Cantidad"));
		}

		rs.close();

	}

	/*
	 * *****************************************************************************
	 * Update
	 ******************************************************************************/

	public void update1(Compra compra) throws Throwable { // modifica datos del cliente con el nit
		
		int codigoCompra;
		int codigoAuto;
		int cantidad;
		if (compra != null) {
			codigoCompra = compra.getCodigoCompra();
			codigoAuto = compra.getCodigoAuto();
			cantidad = compra.getCantidad();

			conexion.SQL("Update compra set codigoAuto = ?,cantidad = ? where codigoCompra=?");
			conexion.preparedStatement().setInt(1, codigoAuto);
			conexion.preparedStatement().setInt(2, cantidad);
			conexion.preparedStatement().setInt(2, codigoCompra);
			conexion.CUD();
		}
	}

	@Override
	public void insert(Compra entity) throws Throwable {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void search(Compra entity) throws Throwable {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Compra entity) throws Throwable {
		// TODO Auto-generated method stub
		
	}

}
