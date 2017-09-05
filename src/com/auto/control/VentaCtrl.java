package com.auto.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.auto.control.Conexion;
import com.auto.control.Control;
import com.auto.entity.Venta;

public class VentaCtrl implements Control<Venta> {

private Conexion conexion;
	
	public VentaCtrl (Conexion conexion) {
		this.conexion = conexion;
	}

	/*
	 * *****************************************************************************
	 * List
	 ******************************************************************************/
	public ArrayList<Venta> list() throws Throwable {
		ArrayList<Venta> Ventas = new ArrayList<Venta>();
		ResultSet rs;
		int codigoVenta;
		int codigoAuto;
		int cantidad;

		conexion.SQL("Select * from Venta");

		rs = conexion.resultSet();

		while (rs.next()) {
			codigoVenta = rs.getInt("codigo");
			codigoAuto = rs.getInt("codigo Auto");
			cantidad = rs.getInt("cantidad");
			Ventas.add(new Venta(codigoVenta,codigoAuto, cantidad));
		}

		return Ventas;

	}

	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	public void insert(Venta Venta) throws Throwable {

		conexion.SQL("Insert into Venta(codigoVenta,codigoAuto,cantidad) VALUES(?,?,?)");
		//conexion.preparedStatement().setInt(1, Venta.getCódigoVenta());
        // set tipo de datos
		conexion.preparedStatement().setInt(1, Venta.getCodigoAuto());
		conexion.preparedStatement().setInt(2, Venta.getCantidad());
		conexion.CUD();

	}

	/*
	 * *****************************************************************************
	 * Search
	 ******************************************************************************/

	public void search1(Venta venta) throws Throwable { // recibe el cliente y va buscar la clave del cliente y devulve el nombre a ese cliente y lo cierra

		ResultSet rs;

		conexion.SQL("Select * from compra where codigoCliente=?");
		conexion.preparedStatement().setInt(1, venta.getCodigoVenta());
		rs = conexion.resultSet();

		while (rs.next()) {

			venta.setCodigoAuto(rs.getInt("CodigoAuto"));
			venta.setCantidad(rs.getInt("Cantidad"));
		}

		rs.close();

	}

	/*
	 * *****************************************************************************
	 * Update
	 ******************************************************************************/

	public void update(Venta Venta) throws Throwable {
		int codigoVenta;
		int codigoAuto;
		int cantidad;
		if (Venta != null) {
			codigoVenta = Venta.getCodigoVenta();
			codigoAuto = Venta.getCodigoAuto();
			cantidad = Venta.getCantidad();

			conexion.SQL("Update Venta set cantidad = ?, codigoAuto = ? where códigoVenta=?");
			conexion.preparedStatement().setInt(1, cantidad);
			conexion.preparedStatement().setInt(2, codigoAuto);
			conexion.preparedStatement().setInt(3, codigoVenta);
			conexion.CUD();
		}
	}

	@Override
	public void search(Venta entity) throws Throwable {
		// TODO Auto-generated method stub
		
	}

	
}
