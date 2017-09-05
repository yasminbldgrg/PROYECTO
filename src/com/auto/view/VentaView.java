package com.auto.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.auto.control.Conexion;
import com.auto.control.VentaCtrl;
import com.auto.entity.Venta;
import com.auto.view.ReadTypes;
import com.auto.view.Menu.MenusVenta;

public class VentaView {
	
	private Scanner scanner;
	private Venta Venta;
	private VentaCtrl VentaCtrl;
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public VentaView(Conexion conexion, Scanner scanner) {
	
		this.scanner = scanner;
		VentaCtrl = new  VentaCtrl(conexion);
		
	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insertar() {
		int codigoVenta;
		int codigoAuto;
		int cantidad;
		
        //códigoVenta = ReadTypes.leerEntero(scanner, "Ingrese el código: "); 
		codigoAuto = ReadTypes.leerEntero(scanner, "Ingrese el codigo del auto: ");
		cantidad = ReadTypes.leerEntero(scanner, "Ingrese la cantidad: ");

		Venta = new Venta(codigoAuto,cantidad);
		
		try {
			VentaCtrl.insert(Venta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {
		ArrayList<Venta> Ventas;

		try {
			Ventas = VentaCtrl.list();
			for (int i = 0; i < Ventas.size(); i++) {
				System.out.println(Ventas.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(int codigoVenta) {
		Venta= new Venta (codigoVenta);
		try {
			VentaCtrl.search(Venta);
			System.out.println(Venta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/

	public void actualizar() {
		int codigoVenta;
		
		codigoVenta = ReadTypes.leerEntero(scanner, "Ingrese el código de la Venta a modificar; ");
		Venta= new Venta(codigoVenta);
		//Venta.setNIT(NIT);
		try {
			VentaCtrl.search(Venta);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusVenta.menuModificar(scanner, Venta);

		try {
			VentaCtrl.update(Venta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}


}
