
  package com.auto.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.auto.control.AutoCtrl;
import com.auto.control.Conexion;
import com.auto.control.DetalleVentaCtrl;
import com.auto.control.VentaCtrl;
import com.auto.entity.Auto;
import com.auto.entity.DetalleVenta;
import com.auto.entity.Venta;
import com.auto.view.Menu.MenusDetalleVenta;
public class DetalleVentaView {
	
	private Scanner scanner;
	private DetalleVenta detalleventa;
	private DetalleVentaCtrl detalleVentaCtrl;
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public DetalleVentaView(Conexion conexion, Scanner scanner) { // sirve para crear un cliente crl
	
		this.scanner = scanner; 
		detalleVentaCtrl = new  DetalleVentaCtrl(conexion);
		
	}
	
	
	public void insertar(int codigoAuto, int cantidad) throws Throwable {
		int codigoVenta;
		
		Auto auto = new Auto(codigoAuto);
		
		DetalleVentaView detalleVentaView = new DetalleVentaView(conexion, scanner);
		codigoVenta = detalleVentaView.getLastCodigo();
		
		AutoCtrl autoCtrl = new AutoCtrl(conexion);
		autoCtrl.search(auto);
		Venta venta = new Venta(codigoVenta);
		
		if(auto.getstock() < cantidad){
			System.out.println("No existen suficientes autos para la venta, existen "+ auto.getstock()+" "+ auto.getMarca() +" ");
			}
		else {detalleventa = new DetalleVenta(codigoAuto,cantidad,codigoVenta);
		AutoCtrl autoCtrl2 = new autoCtrl(conexion);
		autoCtrl2.search(auto);
		VentaCtrl ventaCtrl2 = new VentaCtrl(conexion);
		VentaCtrl2.search(venta);
		Cliente cliente = new Cliente(venta.getCodigoAuto());
		ClienteCtrl ClienteCtrl2 = new ClienteCtrl(conexion);
		
		
		}
	}
	private int getLastCodigo() {
		// TODO Auto-generated method stub
		return 0;
	}


	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insertar() {
		int codigoDetalleVenta;
		int numeroContrato;
		int codigoAuto;
		int cantidad;
		int codigoVenta;

		codigoDetalleVenta = ReadTypes.leerEntero(scanner, "Ingrese un codigoDetalleVenta: ");
		numeroContrato = ReadTypes.leerEntero(scanner, "Ingrese un numeroContrato: ");
		cantidad = ReadTypes.leerEntero(scanner, "Ingrese un código: ");
		codigoAuto = ReadTypes.leerEntero(scanner, "Ingrese un codigoAuto: ");
		codigoVenta = ReadTypes.leerEntero(scanner, "Ingrese un codigoVenta: ");
		 //readtipes es una clase que hace para todo tipo de datos lee fecha enteros reales cadenas...
		
		
		detalleventa = new DetalleVenta(codigoDetalleVenta,numeroContrato,cantidad,codigoAuto,codigoVenta);
		
		try {
			detalleVentaCtrl.insert(detalleventa);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {  //maneja la lista
		ArrayList<DetalleVenta> detalleVenta; // lista clientes

		try {
			detalleVenta = detalleVentaCtrl.list();
			for (int i = 0; i < detalleVenta.size(); i++) { 
				System.out.println(detalleVenta.get(i)); // devuelve cada cliente
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(int numeroContrato) { // requiere un nid crea un cliente con ese nid y busca
		detalleventa= new DetalleVenta (numeroContrato);//este cliente no fue declarado por eso da error si buscamos
		try {
			detalleVentaCtrl.search(detalleventa);
			System.out.println(detalleventa);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/

	public void actualizar() {
		int numeroContrato;
		
		numeroContrato = ReadTypes.leerEntero(scanner, "Ingrese el numero de contrato a modificar; ");
		detalleventa= new DetalleVenta(numeroContrato);
		try {
			detalleVentaCtrl.search(detalleventa);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusDetalleVenta.menuModificar(scanner, detalleventa);

		try {
			detalleVentaCtrl.update(detalleventa);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}


}
