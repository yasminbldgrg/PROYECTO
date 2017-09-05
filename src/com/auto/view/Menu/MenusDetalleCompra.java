package com.auto.view.Menu;

import java.util.Scanner;

import com.auto.entity.DetalleCompra;
import com.auto.view.ReadTypes;

public class MenusDetalleCompra {

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public static int opcionesModificar(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Actualizar Numero Contrato");
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
	public static void menuModificar(Scanner scanner, DetalleCompra detalleCompra) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Numero contrato anterior: ");
				System.out.println(detalleCompra.getNumeroContrato());
				int numeroContrato = ReadTypes.leerEntero(scanner, "Ingrese el nuevo valor del numero Contrato: ");
				detalleCompra.setNumeroContrato(numeroContrato);
				break;
			}
		}
	}
}
