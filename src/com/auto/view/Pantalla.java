package com.auto.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.auto.control.Conexion;
import com.auto.view.ClienteView;
import com.auto.view.VentaView;
import com.auto.view.Menu.Principal;

public class Pantalla {

	
	private static int codigoVenta;

	public static void main(String[] args) throws Throwable {
		Scanner scanner = new Scanner(System.in);
		Conexion conexion = new Conexion();
		AutoView autoView = new AutoView(conexion, scanner);
		ClienteView clienteView = new ClienteView(conexion,scanner);
		VentaView ventaView = new VentaView(conexion,scanner);
		Principal principal = new Principal();
		principal.subMenu(scanner, conexion);
		//clienteView.buscar(123);
		
/*		for (int i = 1; i < 3; i++) {
			ClienteView.insertar(conexion, scanner);
		}*/
		
		//autoView.insertar();
		//autoView.listar();
		//ventaView.insert();
		//ventaView.buscar("147");
		
		//clienteView.listar();
		
		//clienteView.buscar("123");
		
		//clienteView.actualizar();
		
		//clienteView.listar();
		
		
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println( e.getSQLState());
		}
		
		
		scanner.close();
		
		
		
	}

}
