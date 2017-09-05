package com.auto.view;


import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.auto.control.CompraCtrl;
import com.auto.control.Conexion;
import com.auto.entity.Compra;
import com.auto.view.Menu.MenusCompra;

public class CompraView {
	
	private Scanner scanner;
	private Compra compra;
	private CompraCtrl compraCtrl;
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public CompraView(Conexion conexion, Scanner scanner) {
	
		this.scanner = scanner;
		compraCtrl = new  CompraCtrl(conexion);
		
	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insert() {
		int codigoCompra;
		int codigoAuto;
		int cantidad;

        codigoCompra = ReadTypes.leerEntero(scanner, "Ingrese el código de Compra: "); 
		codigoAuto = ReadTypes.leerEntero(scanner, "Ingrese el codigo Auto: ");
		cantidad = ReadTypes.leerEntero(scanner, "Ingrese la cantidad: ");

		compra = new Compra(cantidad, codigoAuto,codigoCompra);
		
		try {
			compraCtrl.insert(compra);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {
		ArrayList<Compra> Compras;

		try {
			Compras = compraCtrl.list();
			for (int i = 0; i < Compras.size(); i++) {
				System.out.println(Compras.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(int codigoCompra) {
		compra= new Compra(codigoCompra);
		try {
			compraCtrl.search(compra);
			System.out.println(compra);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/

	public void actualizar() {
		int codigoCompra;
		
		codigoCompra = ReadTypes.leerEntero(scanner, "Ingrese el código de la Compra a modificar; ");
		compra= new Compra(codigoCompra);
		//Venta.setNIT(NIT);
		try {
			compraCtrl.search(compra);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusCompra.menuModificar(scanner, compra);

		try {
			compraCtrl.update(compra);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}


}
