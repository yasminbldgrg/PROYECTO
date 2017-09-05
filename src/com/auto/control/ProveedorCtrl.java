package com.auto.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.auto.entity.Proveedor;

public class ProveedorCtrl implements Control<Proveedor>{  // implementa los metodos de control para cliente a interfase insert search delete update
		
		private Conexion conexion; // unico atributo
		
		public ProveedorCtrl (Conexion conexion) { //constructor de la clase conexion se ocupa de conectar java con la base de datos y es una interfase de datos 
			this.conexion = conexion;             
		}

		/*
		 * *****************************************************************************
		 * List
		 ******************************************************************************/
		public ArrayList<Proveedor> list() throws Throwable { //arraylist es una estructura de tipo arreglo con tamaño indefinido es una estructura dinamica
			ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();//devolver una lista cliente
			ResultSet rs; //donde se guardan los resultados de nuestra consulta
			int codigoProveedor;
			String nombre;
			String direccion;
			int telefono;

			conexion.SQL("Select * from proveedor"); // metemos la consulta

			rs = conexion.resultSet(); // guarda el resultado de la consulta y devuelve todo lo de la consulta

			while (rs.next()) { // while para que vaya recoriendo y nos devuelva todos los elementos del rs 
				codigoProveedor = rs.getInt("codigoProveedor");
				nombre = rs.getString("nombre");
				direccion = rs.getString("direccion");
				telefono = rs.getInt("telefono");
				proveedores.add(new Proveedor(codigoProveedor, nombre, direccion, telefono)); // añade cliente nuevo 
			}

			return proveedores;

		}

		/*
		 * *****************************************************************************
		 * Insert
		 ******************************************************************************/
		public void insert(Proveedor proveedor) throws Throwable {

			conexion.SQL("Insert into proveedor(codigoProveedor,nombre,direccion, telefono) VALUES(?,?,?,?)");//?? son parametros esta esperando dos parametros
			conexion.preparedStatement().setInt(1, proveedor.getCodigoProveedor()); // set tipo de datos
			conexion.preparedStatement().setString(2, proveedor.getNombre());
			conexion.preparedStatement().setString(3, proveedor.getDireccion());
			conexion.preparedStatement().setInt(4, proveedor.getTelefono());
			conexion.CUD();

		}

		/*
		 * *****************************************************************************
		 * Search
		 ******************************************************************************/

		public void search(Proveedor proveedor) throws Throwable { // recibe el cliente y va buscar la clave del cliente y devulve el nombre a ese cliente y lo cierra

			ResultSet rs;

			conexion.SQL("Select * from cliente where codigoProveedor=?");
			conexion.preparedStatement().setInt(1, proveedor.getCodigoProveedor());
			rs = conexion.resultSet();

			while (rs.next()) {

				proveedor.setNombre(rs.getString("nombre"));
			}

			rs.close();

		}

		/*
		 * *****************************************************************************
		 * Update
		 ******************************************************************************/

		public void update1(Proveedor proveedor) throws Throwable { // modifica datos del cliente con el nit
			int codigoProveedor; //varchar entonces string
			String nombre;
			String direccion;
			int telefono;
			if (proveedor != null) {
				codigoProveedor = proveedor.getCodigoProveedor();
				nombre = proveedor.getNombre();
				direccion = proveedor.getDireccion();
				telefono = proveedor.getTelefono();

				conexion.SQL("Update cliente set nombre = ?,direccion = ?,telefono= ? where codigoProveedor=?");
				conexion.preparedStatement().setString(1, nombre);
				conexion.preparedStatement().setString(2, direccion);
				conexion.preparedStatement().setInt(3, telefono);
				conexion.preparedStatement().setInt(4, codigoProveedor);
				conexion.CUD();
			}
		}

		@Override
		public void update(Proveedor proveedor) throws Throwable {
			// TODO Auto-generated method stub
			
		}
}
