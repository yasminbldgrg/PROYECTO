package com.auto.view.Menu;

import java.util.Scanner;

import com.auto.control.AutoCtrl;
import com.auto.control.ClienteCtrl;
import com.auto.control.Conexion;
import com.auto.entity.Auto;
import com.auto.entity.Cliente;
import com.auto.view.AutoView;
import com.auto.view.ClienteView;
import com.auto.view.CompraView;
import com.auto.view.ReadTypes;
import com.auto.view.VentaView;


public class MenusAuto {
	
	
	
public static int menu(Scanner scanner){
		
		int opcion;
		
		while (true) {
			try {
				// ingrsar todos los valores que tiene proveedor
				System.out.println("Ingrese una opcion: menu Cliente ");
				System.out.println("------------------- ");
				System.out.println("1. busqueda Auto con su Marca" );
				System.out.println("2. Ingrese la Venta" );
				System.out.println("3. Listar cientes" );
				System.out.println("4. actualizar" );
				System.out.println("5. Insertar " );
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
	AutoView autoView = new AutoView(conexion, scanner);
	VentaView ventaView = new VentaView(conexion,scanner);
	CompraView compraView = new CompraView(conexion, scanner);
	
	while(!salir){
		switch(menu(scanner)){
		case 0:
			salir=true;
			break;
		case 1:
			String marca = ReadTypes.leerCadena(scanner, "ingrese marca del auto");
			Auto auto = new Auto(marca);
			AutoCtrl autoCtrl = new AutoCtrl(conexion);
			autoCtrl.search1(auto);
			if(auto.getstock() != null){
				//ventaView.buscar(codigoCliente);
				//MenusDetalleVenta.subMenu(conexion, scanner);
				salir=true;
				break;
			}
			else{
				System.out.println("El auto no esta registrado ");
				break;
			}
		case 2:
		//	int codigoCliente = ReadTypes.leerEntero(scanner, "Ingrese codigo a buscar: ");
			//clienteView.buscar(codigoCliente);
			break;
		case 3:
			autoView.listar();
			break;
		case 4:
			autoView.actualizar();
			break;
		case 5:
            autoView.insertar();
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
				System.out.println("1. Actualizar CodigoAuto");
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
	public static void menuModificar(Scanner scanner, Auto auto) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Nombre anterior: ");
				System.out.println(auto.getCodigoAuto());
				int codigoAuto = com.auto.view.ReadTypes.leerEntero(scanner, "Ingrese el nuevo valor de codigo Auto: ");
				auto.setCodigoAuto(codigoAuto);
				break;
			}
		}
	}

}
