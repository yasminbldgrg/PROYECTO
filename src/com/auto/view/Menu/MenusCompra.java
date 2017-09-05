package com.auto.view.Menu;

import java.util.Scanner;

import com.auto.control.CompraCtrl;
import com.auto.entity.Compra;
import com.auto.view.ReadTypes;

public class MenusCompra {
	
	
	private static void subMenuCompra(Scanner scanner, Compra compra){
		int codigoCompra;
		int codigoAuto;
		int cantidad;
		CompraCtrl (Conexion conexion);
		//Scanner scanner;
		//Compra compra;
		
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
	public static int opcionesModificar(Scanner scanner) {

		int opcion;

		while (true) { 
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Actualizar cantidad");
				System.out.println("0. Salir");
				System.out.println();

				opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion >= 0 && opcion <= 4) {
					return opcion;
				}

			} catch (java.util.InputMismatchException e) {
				System.out.println("Ingrese solo valores numéricos");
				System.out.println();
				scanner.nextLine();
			}
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public static void menuModificar(Scanner scanner, Compra compra) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("compra anterior: ");
				System.out.println(compra.getCantidad());
				int cantidad = ReadTypes.leerEntero(scanner, "Ingrese el nuevo valor de la cantidad: ");
				compra.setCantidad(cantidad);
				break;
			}
		}
	}

}
