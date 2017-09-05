package com.auto.view.Menu;

import java.util.Scanner;

import com.auto.control.ClienteCtrl;
import com.auto.control.Conexion;
import com.auto.entity.Cliente;
import com.auto.view.ClienteView;
import com.auto.view.ReadTypes;
import com.auto.view.VentaView;

public class MenusCliente {
	
	
	
	public static int menu(Scanner scanner){
		
		int opcion;
		
		while (true) {
			try {
				// ingrsar todos los valores que tiene proveedor
				System.out.println("Ingrese una opcion: menu Cliente ");
				System.out.println("------------------- ");
				System.out.println("1. Ingrese una Venta" );
				System.out.println("2. busqueda cliente  a travez del codigo" );
				System.out.println("3. Listar clientes" );
				System.out.println("4. actualizar cliente" );
				System.out.println("5. Insertar cliente " );
				System.out.println("0. Salir");
				System.out.println();
				opcion = scanner.nextInt();
				scanner.nextLine();
				
				if(opcion >=0 && opcion <=6) {
					return opcion;
				}
			} catch (java.util.InputMismatchException e){
				
			}
		}
	}
	
	
	
	public static void subMenu(Scanner scanner,Conexion conexion) throws Throwable {
		boolean salir = false;
		ClienteView clienteView = new ClienteView(conexion, scanner);
		VentaView ventaView = new VentaView(conexion,scanner);
		
		while(!salir){
			switch(menu(scanner)){
			case 0:
				salir=true;
				break;
			case 1:
				int codigoCliente = ReadTypes.leerEntero(scanner, "ingrese codigo Cliente: ");
				Cliente cliente = new Cliente(codigoCliente);
				ClienteCtrl clienteCtrl = new ClienteCtrl(conexion);
				clienteCtrl.search1(cliente);
				if(cliente.getNombre() != null){
					ventaView.insertar();
					MenusDetalleVenta.subMenu(conexion, scanner);
					salir=true;
					break;
				}
				else{
					System.out.println("El cliente no esta registrado ");
					break;
				}
			case 2:
			  int codigoCliente2 = ReadTypes.leerEntero(scanner, "Ingrese codigo a buscar: ");
			 clienteView.buscar(codigoCliente2);
				break;
			case 3:
				clienteView.listar();
				break;
			case 4:
				clienteView.actualizar();
				break;
			case 5:
				clienteView.insertar();
				break;
				
			}
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
				System.out.println("1. Actualizar Nombre");
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
	public static void menuModificar(Scanner scanner, Cliente cliente) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Nombre anterior: ");
				System.out.println(cliente.getNombre());
				String nombre = ReadTypes.leerCadena(scanner, "Ingrese el nuevo valor de nombre: ");
				cliente.setNombre(nombre);
				break;
			}
		}
	}

}
