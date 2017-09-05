package com.auto.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.auto.control.Conexion;
import com.auto.control.Control;
import com.auto.entity.Auto;


public class AutoCtrl implements Control<Auto>{  // implementa los metodos de control para cliente a interfase insert search delete update
	
	private Conexion conexion; // unico atributo
	
	public AutoCtrl (Conexion conexion) { //constructor de la clase conexion se ocupa de conectar java con la base de datos y es una interfase de datos 
		this.conexion = conexion;             
	}

	/*
	 * *****************************************************************************
	 * List
	 ******************************************************************************/
	public ArrayList<Auto> list() throws Throwable { //arraylist es una estructura de tipo arreglo con tamaño indefinido es una estructura dinamica
		ArrayList<Auto> Autos = new ArrayList<Auto>();//devolver una lista cliente
		ResultSet rs;//donde se guardan los resultados de nuestra consulta
		
		int codigoAuto;
		String color;
		String modelo;
		String marca;
		int numeroPuestos;
		int stock;
		int precio;

		conexion.SQL("Select * from auto"); // metemos la consulta

		rs = conexion.resultSet(); // guarda el resultado de la consulta y devuelve todo lo de la consulta

		while (rs.next()) { // while para que vaya recoriendo y nos devuelva todos los elementos del rs 
		
			codigoAuto = rs.getInt("codigoAuto");
			color = rs.getString("color");
			modelo = rs.getString("modelo");
			marca = rs.getString("marca");
			numeroPuestos = rs.getInt("numeroPuestos");
			stock = rs.getInt("Stock");
			precio = rs.getInt("precio");
			Autos.add(new Auto(codigoAuto,color, modelo,marca, numeroPuestos,stock,precio)); // añade auto nuevo 
		}

		return Autos;

	}

	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	public void insert(Auto auto) throws Throwable {

		conexion.SQL("Insert into auto(color,modelo,marca,numeroPuestos,stock,precio) VALUES(?,?,?,?,?,?)");//?? son parametros esta esperando dos parametros
		conexion.preparedStatement().setString(1, auto.getColor());
		conexion.preparedStatement().setString(2, auto.getModelo());
		conexion.preparedStatement().setString(3, auto.getMarca());
		conexion.preparedStatement().setInt(4, auto.getNumeroPuestos());
		conexion.preparedStatement().setInt(5, auto.getstock());
		conexion.preparedStatement().setInt(6, auto.getprecio());
		
		conexion.CUD();

	}

	/*
	 * *****************************************************************************
	 * Search
	 ******************************************************************************/

	public void search1(Auto auto) throws Throwable { // recibe el cliente y va buscar la clave del cliente y devulve el nombre a ese cliente y lo cierra

		ResultSet rs;

		conexion.SQL("Select * from auto where modelo=?");
		conexion.preparedStatement().setString(1, auto.getModelo());
		rs = conexion.resultSet();

		while (rs.next()) {

			auto.setCodigoAuto(rs.getInt("codigoAuto");
			auto.setColor(rs.getString("color"));
			auto.se
		}

		rs.close();

	}

	/*
	 * *****************************************************************************
	 * Update
	 ******************************************************************************/

	public void update1(Auto auto) throws Throwable { // modifica datos del cliente con el nit
		int codigoAuto;
		String color;
		String modelo;
		String marca;
		int numeroPuestos;
		int stock;
		int precio;
		if (auto != null) {
			codigoAuto = auto.getCodigoAuto();
			color = auto.getColor();
			modelo = auto.getModelo();
			marca = auto.getMarca();
			numeroPuestos = auto.getNumeroPuestos();
			stock = auto.getstock();
			precio = auto.getprecio();

			conexion.SQL("Update cliente set color = ?, modelo =?, marca=?, numeroPuestos =?,, stock =?, precio=?, where codigoAuto=?");
			conexion.preparedStatement().setString(1, color);
			conexion.preparedStatement().setString(2, modelo);
			conexion.preparedStatement().setString(3, marca);
			conexion.preparedStatement().setInt(4, numeroPuestos);
			conexion.preparedStatement().setInt(5, stock);
			conexion.preparedStatement().setInt(6, precio);
			conexion.preparedStatement().setInt(7, codigoAuto);
			
			conexion.CUD();
		}
	}

	@Override
	public void search(Auto entity) throws Throwable {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Auto entity) throws Throwable {
		// TODO Auto-generated method stub
		
	}

}

