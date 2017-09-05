package com.auto.view;


import java.util.ArrayList;
import java.util.Scanner;

import com.auto.control.Conexion;
import com.auto.control.ProveedorCtrl;
import com.auto.entity.Proveedor;
import com.auto.view.Menu.MenusProveedor;

public class ProveedorView {
	
	private Scanner scanner;
	private Proveedor proveedor;
	private ProveedorCtrl proveedorCtrl;
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public ProveedorView(Conexion conexion, Scanner scanner) { // sirve para crear un cliente crl
	
		this.scanner = scanner; 
		proveedorCtrl = new  ProveedorCtrl(conexion);
		
	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insertar() {
		int codigoProveedor;
		String nombre;
		String direccion;
		int telefono;

		codigoProveedor = ReadTypes.leerEntero(scanner, "Ingrese el codigo del Proveedor: "); //resdtipes es una clase que hace para todo tipo de datos lee fecha enteros reales cadenas...
		nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre: ");
		direccion = ReadTypes.leerCadena(scanner, "Ingrese la direccion: ");
		telefono = ReadTypes.leerEntero(scanner, "Ingrese el telefono: ");
		
		proveedor = new Proveedor(codigoProveedor,nombre,direccion,telefono);
		
		try {
			proveedorCtrl.insert(proveedor);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {  //maneja la lista
		ArrayList<Proveedor> proveedores; // lista clientes

		try {
			proveedores = proveedorCtrl.list();
			for (int i = 0; i < proveedores.size(); i++) { 
				System.out.println(proveedores.get(i)); // devuelve cada cliente
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(int codigoProveedor) { // requiere un nid crea un cliente con ese nid y busca
		proveedor= new Proveedor (codigoProveedor);//este cliente no fue declarado por eso da error si buscamos
		try {
			proveedorCtrl.search(proveedor);
			System.out.println(proveedor);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/

	public void actualizar() {
		String nombre;
		
		nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre del cliente a modificar; ");
		proveedor= new Proveedor(nombre);
		try {
			proveedorCtrl.search(proveedor);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusProveedor.menuModificar(scanner, proveedor);

		try {
			proveedorCtrl.update(proveedor);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}


}
