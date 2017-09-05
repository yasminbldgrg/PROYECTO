package com.auto.control;


import java.sql.ResultSet;
import java.util.ArrayList;

import com.auto.entity.DetalleVenta;

public class DetalleVentaCtrl  implements Control<DetalleVenta>{  // implementa los metodos de control para detalleVenta a interfase insert search delete update
	
	private Conexion conexion; // unico atributo
	
	public DetalleVentaCtrl (Conexion conexion) { //constructor de la clase conexion se ocupa de conectar java con la base de datos y es una interfase de datos 
		this.conexion = conexion;             
	}

	/*
	 * *****************************************************************************
	 * List
	 ******************************************************************************/
	public ArrayList<DetalleVenta> list() throws Throwable { //arraylist es una estructura de tipo arreglo con tamaño indefinido es una estructura dinamica
		ArrayList<DetalleVenta> detalleVentas = new ArrayList<DetalleVenta>();//devolver una lista DetalleVenta
		ResultSet rs; //donde se guardan los resultados de nuestra consulta
		int codigoDetalleVenta;
		int numeroContrato;
		int codigoAuto;
		int cantidad;
		conexion.SQL("Select * from detalleCompra"); // metemos la consulta

		rs = conexion.resultSet(); // guarda el resultado de la consulta y devuelve todo lo de la consulta

		while (rs.next()) { // while para que vaya recoriendo y nos devuelva todos los elementos del rs 
			codigoDetalleVenta = rs.getInt("codigoDetalleVenta");
			numeroContrato = rs.getInt("numeroContrato");
			codigoAuto = rs.getInt("cantidad");
			cantidad = rs.getInt("codigoAuto");
			
			detalleVentas.add(new DetalleVenta(codigoDetalleVenta, numeroContrato, codigoAuto,cantidad)); // añade DetalleVenta nuevo 
		}

		return detalleVentas;

	}

	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	public void insert1(DetalleVenta detalleVenta) throws Throwable {

		conexion.SQL("Insert into detalleVenta(código, códigoProducto, cantidad, códigoVenta) VALUES(?,?,?,?)");//?? son parametros esta esperando 4 parametros
		conexion.preparedStatement().setInt(1, detalleVenta.getCodigoDetalleVenta()); // set tipo de datos
		conexion.preparedStatement().setInt(2, detalleVenta.getNumeroContrato());
		conexion.preparedStatement().setInt(3, detalleVenta.getCodigoAuto());
		conexion.preparedStatement().setInt(4, detalleVenta.getCantidad());
		conexion.CUD();

	}

	/*
	 * *****************************************************************************
	 * Search
	 ******************************************************************************/

	public void search1(DetalleVenta detalleVenta) throws Throwable { // recibe el cliente y va buscar la clave del cliente y devulve el nombre a ese cliente y lo cierra

		ResultSet rs;

		conexion.SQL("Select * from detalleCompra where Codigo Detalle Compra=?");
		conexion.preparedStatement().setInt(1, detalleVenta.getCodigoDetalleVenta());
		rs = conexion.resultSet();

		while (rs.next()) {

			detalleVenta.setNumeroContrato(rs.getInt("numero contrato"));
			detalleVenta.setCodigoAuto(rs.getInt("codigo auto"));
			detalleVenta.setCantidad(rs.getInt("Cantidad"));
		}

		rs.close();

	}

	/*
	 * *****************************************************************************
	 * Update
	 ******************************************************************************/

	public void update1(DetalleVenta detalleVenta) throws Throwable { // modifica datos del cliente con el nid
		int codigoDetalleVenta;
		int numeroContrato;
		int codigoAuto;
		int cantidad;
		
		if (detalleVenta != null) {
			codigoDetalleVenta = detalleVenta.getCodigoDetalleVenta();
			numeroContrato = detalleVenta.getNumeroContrato();
			codigoAuto = detalleVenta.getCodigoAuto();
			cantidad= detalleVenta.getCantidad();
			
			

			conexion.SQL("Update cliente set numeroContrato = ?, codigoAuto = ?, cantidad = ? where codigoDetalleVenta=?");
			conexion.preparedStatement().setInt(1, numeroContrato);
			conexion.preparedStatement().setInt(2, codigoAuto);
			conexion.preparedStatement().setInt(3, cantidad);
			conexion.preparedStatement().setInt(4, codigoDetalleVenta);
			conexion.CUD();
		}
	}

	@Override
	public void insert(DetalleVenta entity) throws Throwable {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void search(DetalleVenta entity) throws Throwable {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(DetalleVenta entity) throws Throwable {
		// TODO Auto-generated method stub
		
	}
}
