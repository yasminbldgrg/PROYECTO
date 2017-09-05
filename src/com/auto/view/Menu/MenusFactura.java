package com.auto.view.Menu;

import java.util.Scanner;

import com.auto.entity.Factura;
import com.auto.view.ReadTypes;

public class MenusFactura {

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public static int opcionesModificar(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Actualizar NIT");
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
	public static void menuModificar(Scanner scanner, Factura factura) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("NIT anterior: ");
				System.out.println(factura.getNIT());
				String NIT = ReadTypes.leerCadena(scanner, "Ingrese el nuevo NIT: ");
				factura.setNIT(NIT);
				break;
			}
		}
	}
}
