package com.auto.view.Menu;

import java.util.Scanner;

import com.auto.control.Conexion;

public class Principal {
	
	public static int menu(Scanner scanner,Conexion conexion) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion:  Menu Principal");
				System.out.println("------------------- ");
				System.out.println("1. Ingrese la Compra" );
				System.out.println("2. Ingrese la Venta" );
				System.out.println("0. Salir");
				System.out.println();

				opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion >= 0 && opcion <= 3) {
					return opcion;
				}

			} catch (java.util.InputMismatchException e) {
				System.out.println("Ingrese solo valores numéricos");
				System.out.println();
				scanner.nextLine();
			}
		}
	}

	public static void subMenu(Scanner scanner,Conexion conexion) throws Throwable {
		boolean salir = false;
		MenusProveedor menusproveedor= new MenusProveedor();
		MenusCliente menuscliente = new MenusCliente();
		while (!salir) {
			switch (menu(scanner,conexion)) {
			case 0:
				salir = true;
				break;
			case 1:
				//System.out.println("caso1");
				menusproveedor.subMenu(scanner, conexion);
				break;
			case 2:
				//System.out.println("caso2");
				menuscliente.subMenu(scanner,conexion);
				break;
			}
		}
	}

}
