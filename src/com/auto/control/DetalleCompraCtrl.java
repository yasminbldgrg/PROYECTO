package com.auto.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.auto.entity.DetalleCompra;

public class DetalleCompraCtrl  implements Control<DetalleCompra>{  // implementa los metodos de control para detalleVenta a interfase insert search delete update
	
	private Conexion conexion; // unico atributo
	
	public DetalleCompraCtrl (Conexion conexion) { //constructor de la clase conexion se ocupa de conectar java con la base de datos y es una interfase de datos 
		this.conexion = conexion;             
	}

	/*
	 * *****************************************************************************
	 * List
	 ******************************************************************************/
	public ArrayList<DetalleCompra> list() throws Throwable { //arraylist es una estructura de tipo arreglo con tamaño indefinido es una estructura dinamica
		ArrayList<DetalleCompra> detalleCompras = new ArrayList<DetalleCompra>();//devolver una lista DetalleVenta
		ResultSet rs;
		int codigoDetalleCompra;
		int numeroContrato;
		int codigoAuto;
		int cantidad;

		conexion.SQL("Select * from detalleCompra"); // metemos la consulta

		rs = conexion.resultSet(); // guarda el resultado de la consulta y devuelve todo lo de la consulta

		while (rs.next()) { // while para que vaya recoriendo y nos devuelva todos los elementos del rs 
			codigoDetalleCompra = rs.getInt("codigoDetalleCompra");
			numeroContrato = rs.getInt("numeroContrato");
			codigoAuto = rs.getInt("cantidad");
			cantidad = rs.getInt("codigoAuto");
			
			detalleCompras.add(new DetalleCompra(codigoDetalleCompra, numeroContrato, cantidad, codigoAuto)); // añade DetalleVenta nuevo 
		}

		return detalleCompras;

	}

	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	public void insert1(DetalleCompra detalleCompra) throws Throwable {

		conexion.SQL("Insert into detalleVenta(código, códigoProducto, cantidad, códigoVenta) VALUES(?,?,?,?)");//?? son parametros esta esperando 4 parametros
		conexion.preparedStatement().setInt(1, detalleCompra.getCodigoDetalleCompra()); // set tipo de datos
		conexion.preparedStatement().setInt(2, detalleCompra.getNumeroContrato());
		conexion.preparedStatement().setInt(3, detalleCompra.getCodigoAuto());
		conexion.preparedStatement().setInt(4, detalleCompra.getCantidad());
		conexion.CUD();

	}

	/*
	 * *****************************************************************************
	 * Search
	 ******************************************************************************/

	public void search1(DetalleCompra detalleCompra) throws Throwable { // recibe el cliente y va buscar la clave del cliente y devulve el nombre a ese cliente y lo cierra

		ResultSet rs;

		conexion.SQL("Select * from detalleCompra where Codigo Detalle Compra=?");
		conexion.preparedStatement().setInt(1, detalleCompra.getCodigoDetalleCompra());
		rs = conexion.resultSet();

		while (rs.next()) {

			detalleCompra.setNumeroContrato(rs.getInt("numero contrato"));
			detalleCompra.setCodigoAuto(rs.getInt("codigo auto"));
			detalleCompra.setCantidad(rs.getInt("Cantidad"));
		}

		rs.close();

	}

	/*
	 * *****************************************************************************
	 * Update
	 ******************************************************************************/

	public void update1(DetalleCompra detalleCompra) throws Throwable { // modifica datos del cliente con el nid
		int codigoDetalleCompra;
		int numeroContrato;
		int codigoAuto;
		int cantidad;
		
		if (detalleCompra != null) {
			codigoDetalleCompra = detalleCompra.getCodigoDetalleCompra();
			numeroContrato = detalleCompra.getNumeroContrato();
			codigoAuto = detalleCompra.getCodigoAuto();
			cantidad= detalleCompra.getCantidad();
			
			

			conexion.SQL("Update cliente set numeroContrato = ?, codigoAuto = ?, cantidad = ? where codigoDetalleCompra=?");
			conexion.preparedStatement().setInt(1, numeroContrato);
			conexion.preparedStatement().setInt(2, codigoAuto);
			conexion.preparedStatement().setInt(3, cantidad);
			conexion.preparedStatement().setInt(4, codigoDetalleCompra);
			conexion.CUD();
		}
	}

	@Override
	public void insert(DetalleCompra entity) throws Throwable {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void search(DetalleCompra entity) throws Throwable {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(DetalleCompra entity) throws Throwable {
		// TODO Auto-generated method stub
		
	}

}
