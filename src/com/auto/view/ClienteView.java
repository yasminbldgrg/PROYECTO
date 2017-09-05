package com.auto.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.auto.control.ClienteCtrl;
import com.auto.control.Conexion;
import com.auto.entity.Cliente;
import com.auto.view.Menu.MenusCliente;


public class ClienteView {
	
	private Scanner scanner;
	private Cliente cliente;
	private ClienteCtrl clienteCtrl;
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public ClienteView(Conexion conexion, Scanner scanner) { // sirve para crear un cliente crl
	
		this.scanner = scanner; 
		clienteCtrl = new  ClienteCtrl(conexion);
		
	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insertar() {
		int codigoCliente;
		String nombre;

		codigoCliente = ReadTypes.leerEntero(scanner, " Ingrese el codigo Cliente: "); //resdtipes es una clase que hace para todo tipo de datos lee fecha enteros reales cadenas...
		nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre: ");
		
		cliente = new Cliente(codigoCliente,nombre);
		
		try {
			clienteCtrl.insert(cliente);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {  //maneja la lista
		ArrayList<Cliente> clientes; // lista clientes

		try {
			clientes = clienteCtrl.list();
			for (int i = 0; i < clientes.size(); i++) { 
				System.out.println(clientes.get(i)); // devuelve cada cliente
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(int codigoCliente) { // requiere un nid crea un cliente con ese nid y busca
		cliente= new Cliente (codigoCliente);//este cliente no fue declarado por eso da error si buscamos
		try {
			clienteCtrl.search1(cliente);
			System.out.println(cliente);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/

	public void actualizar() {
		int codigoCliente;
		
		codigoCliente = ReadTypes.leerEntero(scanner, "Ingrese el codigo del Cliente a modificar; ");
		cliente= new Cliente(codigoCliente);
		try {
			clienteCtrl.search(cliente);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusCliente.menuModificar(scanner, cliente);

		try {
			clienteCtrl.update(cliente);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}


}
