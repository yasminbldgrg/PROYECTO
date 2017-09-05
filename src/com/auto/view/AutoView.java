package com.auto.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.auto.view.ReadTypes;
import com.auto.control.AutoCtrl;
import com.auto.control.Conexion;
import com.auto.entity.Auto;
import com.auto.view.Menu.MenusAuto;



public class AutoView {
	
	private Scanner scanner;
	private Auto auto;
	private AutoCtrl autoCtrl;
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public AutoView(Conexion conexion, Scanner scanner) { // sirve para crear un cliente crl
	
		this.scanner = scanner; 
		autoCtrl = new  AutoCtrl(conexion);
		
	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insertar() {
		//int codigoAuto;
		String color;
		String modelo;
		String marca;
		int numeroPuestos;
		int stock;
		int precio;
		//codigoAuto = ReadTypes.leerEntero(scanner, "Ingrese el codigo Auto: ");
		
		color = ReadTypes.leerCadena(scanner, "Ingrese el color: ");
		modelo =ReadTypes.leerCadena(scanner, "Ingrese el modelo: ");
		marca =ReadTypes.leerCadena(scanner, "Ingrese la marca: ");
		numeroPuestos = ReadTypes.leerEntero(scanner, "Ingrese el numero de puestos: ");
		stock = ReadTypes.leerEntero(scanner, "Ingrese el stock: ");
		precio = ReadTypes.leerEntero(scanner, "Ingrese el precio: ");
		
		auto = new Auto(0, color, modelo, marca, numeroPuestos,stock,precio);
		
		try {
			autoCtrl.insert(auto);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {  //maneja la lista
		ArrayList<Auto> autos; // lista clientes

		try {
			autos = autoCtrl.list();
			for (int i = 0; i < autos.size(); i++) { 
				System.out.println(autos.get(i)); // devuelve cada cliente
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(int codigoAuto) { // requiere un nid crea un cliente con ese nid y busca
		auto= new Auto(codigoAuto);//este cliente no fue declarado por eso da error si buscamos
		try {
			autoCtrl.search(auto);
			System.out.println(auto);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/

	public void actualizar() {
		int codigoAuto;
		
		codigoAuto = ReadTypes.leerEntero(scanner, "Ingrese el codigoAuto del auto a modificar; ");
		auto= new Auto(codigoAuto);
		try {
			autoCtrl.search(auto);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusAuto.menuModificar(scanner, auto);

		try {
			autoCtrl.update(auto);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}


}
