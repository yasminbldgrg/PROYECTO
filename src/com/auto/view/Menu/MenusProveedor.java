package com.auto.view.Menu;

import java.util.Scanner;

import com.auto.control.ClienteCtrl;
import com.auto.control.Conexion;
import com.auto.control.ProveedorCtrl;
import com.auto.entity.Cliente;
import com.auto.entity.Proveedor;
import com.auto.view.ClienteView;
import com.auto.view.CompraView;
import com.auto.view.ProveedorView;
import com.auto.view.ReadTypes;
import com.auto.view.VentaView;

public class MenusProveedor {
	
	
public static int menu(Scanner scanner){
		
		int opcion;
		
		while (true) {
			try {
				// ingresar todos los valores que tiene proveedor
				System.out.println("Ingrese una opcion: menu Proveedor ");
				System.out.println("------------------- ");
				System.out.println("1. busqueda proveedor a travez del codigo" );
				System.out.println("2. Ingrese la Compra" );
				System.out.println("3. Listar proveedores" );
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
		ProveedorView proveedorView = new ProveedorView(conexion, scanner);
		CompraView compraView = new CompraView(conexion, scanner);
		
		while(!salir){
			switch(menu(scanner)){
			case 0:
				salir=true;
				break;
			case 1:
				int codigoProveedor = ReadTypes.leerEntero(scanner, "ingrese codigo Proveedor: ");
				Proveedor proveedor = new Proveedor(codigoProveedor);
				ProveedorCtrl proveedorCtrl = new ProveedorCtrl(conexion);
				proveedorCtrl.search(proveedor);
				if(proveedor.getNombre() != null){
					//ventaView.buscar(codigoCliente);
					//MenusDetalleVenta.subMenu(conexion, scanner);
					salir=true;
					break;
				}
				else{
					System.out.println("El cliente no esta registrado ");
					break;
				}
			case 2:
				int codigoProveedor1 = ReadTypes.leerEntero(scanner, "Ingrese codigo a buscar: ");
				proveedorView.buscar(codigoProveedor1);
				break;
			case 3:
				proveedorView.listar();
				break;
			case 4:
				proveedorView.actualizar();
				break;
			case 5:
				proveedorView.insertar();
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
	public static void menuModificar(Scanner scanner, Proveedor proveedor) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Nombre anterior: ");
				System.out.println(proveedor.getNombre());
				String nombre = ReadTypes.leerCadena(scanner, "Ingrese el nuevo valor de nombre: ");
				proveedor.setNombre(nombre);
				break;
			}
		}
	}

}
