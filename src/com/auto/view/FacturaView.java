package com.auto.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.auto.control.Conexion;
import com.auto.control.FacturaCtrl;
import com.auto.entity.Factura;
import com.auto.view.Menu.MenusFactura;

public class FacturaView {

	private Scanner scanner;
	private Factura factura;
	private FacturaCtrl facturaCtrl;
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public FacturaView(Conexion conexion, Scanner scanner) { // sirve para crear un cliente crl
	
		this.scanner = scanner; 
		facturaCtrl = new  FacturaCtrl(conexion);
		
	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insertar() {
		int numeroFactura;
		double monto;
		String NIT;
		Date fecha;

		numeroFactura = ReadTypes.leerEntero(scanner, "Ingrese el numero de la factura: ");
		monto = ReadTypes.leerReal(scanner, "Ingrese el monto de la factura: ");
		NIT = ReadTypes.leerCadena(scanner, "Ingrese el NIT: "); //resdtipes es una clase que hace para todo tipo de datos lee fecha enteros reales cadenas...
		fecha = new Date();
		
		factura = new Factura(numeroFactura,monto,NIT,fecha);
		
		try {
			facturaCtrl.insert(factura);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {  //maneja la lista
		ArrayList<Factura> facturas; // lista clientes

		try {
			facturas = facturaCtrl.list();
			for (int i = 0; i < facturas.size(); i++) { 
				System.out.println(facturas.get(i)); // devuelve cada cliente
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(int numeroFactura) { // requiere un nid crea un cliente con ese nid y busca
		factura= new Factura(numeroFactura);//este cliente no fue declarado por eso da error si buscamos
		try {
			facturaCtrl.search(factura);
			System.out.println(factura);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/

	public void actualizar() {
		String NIT;
		
		NIT = ReadTypes.leerCadena(scanner, "Ingrese el NIT del cliente a modificar; ");
		factura= new Factura(NIT);
		try {
			facturaCtrl.search(factura);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusFactura.menuModificar(scanner, factura);

		try {
			facturaCtrl.update(factura);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

}
