package com.auto.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.auto.control.Conexion;
import com.auto.control.DetalleCompraCtrl;
import com.auto.entity.DetalleCompra;
import com.auto.view.Menu.MenusDetalleCompra;

public class DetalleCompraView {
	
	private Scanner scanner;
	private DetalleCompra detalleCompra;
	private DetalleCompraCtrl detalleCompraCtrl;
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public DetalleCompraView(Conexion conexion, Scanner scanner) { // sirve para crear un cliente crl
	
		this.scanner = scanner; 
		detalleCompraCtrl = new  DetalleCompraCtrl(conexion);
		
	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insertar() {
		int codigoDetalleCompra;
		int numeroContrato;
		int codigoAuto;
		int cantidad;

		codigoDetalleCompra = ReadTypes.leerEntero(scanner, "Ingrese un codigoDetalleCompra: ");
		numeroContrato = ReadTypes.leerEntero(scanner, "Ingrese un numeroContrato: ");
		codigoAuto = ReadTypes.leerEntero(scanner, "Ingrese un codigoAuto: ");
		cantidad = ReadTypes.leerEntero(scanner, "Ingrese una cantidad: ");
		 //readtipes es una clase que hace para todo tipo de datos lee fecha enteros reales cadenas...
		
		
		detalleCompra = new DetalleCompra(codigoDetalleCompra,numeroContrato,codigoAuto,cantidad);
		
		try {
			detalleCompraCtrl.insert(detalleCompra);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {  //maneja la lista
		ArrayList<DetalleCompra> detalleCompra; // lista clientes

		try {
			detalleCompra = detalleCompraCtrl.list();
			for (int i = 0; i < detalleCompra.size(); i++) { 
				System.out.println(detalleCompra.get(i)); // devuelve cada cliente
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(int numeroContrato) { // requiere un nid crea un cliente con ese nid y busca
		detalleCompra= new DetalleCompra (numeroContrato);//este cliente no fue declarado por eso da error si buscamos
		try {
			detalleCompraCtrl.search(detalleCompra);
			System.out.println(detalleCompra);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/

	public void actualizar() {
		int numeroContrato;
		
		numeroContrato = ReadTypes.leerEntero(scanner, "Ingrese el numero de Contrato para actualizar; ");
		detalleCompra= new DetalleCompra(numeroContrato);
		try {
			detalleCompraCtrl.search(detalleCompra);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusDetalleCompra.menuModificar(scanner, detalleCompra);

		try {
			detalleCompraCtrl.update(detalleCompra);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}


}
