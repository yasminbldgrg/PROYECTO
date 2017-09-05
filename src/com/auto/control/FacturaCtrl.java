package com.auto.control;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.auto.entity.Factura;

public class FacturaCtrl implements Control<Factura>{  // implementa los metodos de control para cliente a interfase insert search delete update
	
	private Conexion conexion; // unico atributo
	
	public FacturaCtrl (Conexion conexion) { //constructor de la clase conexion se ocupa de conectar java con la base de datos y es una interfase de datos 
		this.conexion = conexion;             
	}

	/*
	 * *****************************************************************************
	 * List
	 ******************************************************************************/
	public ArrayList<Factura> list1() throws Throwable { //arraylist es una estructura de tipo arreglo con tamaño indefinido es una estructura dinamica
		ArrayList<Factura> facturas = new ArrayList<Factura>();//devolver una lista cliente
		ResultSet rs; //donde se guardan los resultados de nuestra consulta
		int numeroFactura;
		double monto;
		String NIT;
		Date fecha;

		conexion.SQL("Select * from cliente"); // metemos la consulta

		rs = conexion.resultSet(); // guarda el resultado de la consulta y devuelve todo lo de la consulta

		while (rs.next()) { // while para que vaya recoriendo y nos devuelva todos los elementos del rs 
			numeroFactura = rs.getInt("numeroFactura");
			monto = rs.getDouble("monto");
			NIT = rs.getString("NIT");
			fecha = rs.getDate("fecha");
			facturas.add(new Factura(numeroFactura, monto, NIT, fecha)); // añade cliente nuevo 
		}

		return facturas;

	}

	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	public void insert1(Factura factura) throws Throwable {

		conexion.SQL("Insert into cliente(numeroFctura,monto,NIT,fecha) VALUES(?,?,?,?)");//?? son parametros esta esperando dos parametros
		conexion.preparedStatement().setInt(1, factura.getNumeroFactura()); // set tipo de datos
		conexion.preparedStatement().setDouble(2, factura.getMonto());
		conexion.preparedStatement().setString(3, factura.getNIT());
		conexion.preparedStatement().setDate(4, new java.sql.Date( factura.getFecha().getTime()));
		conexion.CUD();

	}

	/*
	 * *****************************************************************************
	 * Search
	 ******************************************************************************/

	public void search1(Factura factura) throws Throwable { // recibe el cliente y va buscar la clave del cliente y devulve el nombre a ese cliente y lo cierra

		ResultSet rs;

		conexion.SQL("Select * from cliente where codigoCliente=?");
		conexion.preparedStatement().setInt(1, factura.getNumeroFactura());
		rs = conexion.resultSet();

		while (rs.next()) {

			factura.setNumeroFactura(rs.getInt("NumeroFactura"));
		}

		rs.close();

	}

	/*
	 * *****************************************************************************
	 * Update
	 ******************************************************************************/

	public void update1(Factura factura) throws Throwable { // modifica datos del cliente con el nit
		int numeroFactura;
		double monto;
		String NIT;
		Date fecha;
		if (factura != null) {
			numeroFactura = factura.getNumeroFactura();
			monto = factura.getMonto();
			NIT = factura.getNIT();
			fecha = factura.getFecha();

			conexion.SQL("Update cliente set nombre = ? where codigoCliente=?");
			conexion.preparedStatement().setDouble(2, factura.getMonto());
			conexion.preparedStatement().setString(3, factura.getNIT());
			conexion.preparedStatement().setDate(4, new java.sql.Date( factura.getFecha().getTime()));
			conexion.preparedStatement().setInt(1, factura.getNumeroFactura());
			conexion.CUD();
		}
	}

	@Override
	public ArrayList<Factura> list() throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Factura entity) throws Throwable {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void search(Factura entity) throws Throwable {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Factura entity) throws Throwable {
		// TODO Auto-generated method stub
		
	}


}
