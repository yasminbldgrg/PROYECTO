package com.auto.view.Menu;

import java.util.Scanner;

import com.auto.control.Conexion;
import com.auto.entity.DetalleVenta;
import com.auto.view.CompraView;
import com.auto.view.ProveedorView;
import com.auto.view.ReadTypes;

public class MenusDetalleVenta {

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public static int opcionesModificar(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Actualizar numero Contrato");
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
	public static void menuModificar(Scanner scanner, DetalleVenta detalleVenta) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Numero contrato anterior: ");
				System.out.println(detalleVenta.getNumeroContrato());
				int numeroContrato = ReadTypes.leerEntero(scanner, "Ingrese el nuevo valor de numero Contrato: ");
				detalleVenta.setNumeroContrato(numeroContrato);
				break;
			}
		}
	}

	public static int menu(Scanner scanner){
		
		int opcion;
		
		while (true) {
			try {
				// ingrsar todos los valores que tiene proveedor
				System.out.println("Ingrese una opcion: menu detalleventa");
				opcion = scanner.nextInt();
				scanner.nextLine();
				
				if(opcion >=0 && opcion <=6) {
					return opcion;
				}
			} catch (java.util.InputMismatchException e){
				
			}
		}
	}
	public static void subMenu(Conexion conexion, Scanner scanner) {
		throws Throwable {
			
			boolean salir = false;
			
			//VentaView ventaView = new VentaView(conexion, scanner);
			//AutoView autoView = new AutoView(conexion, scanner);
			
			while(!salir){
				switch(menu(scanner)){
				case 0: 
					salir = true;
				break;
				case 1:
					String a="";
				}
			}
		}
	}
}