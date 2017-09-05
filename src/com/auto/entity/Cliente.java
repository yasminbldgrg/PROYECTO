package com.auto.entity;

public class Cliente {

	private int codigoCliente; //varchar entonces string
	private String nombre;

	
	public Cliente(int codigoCliente, String nombre) {
		this.codigoCliente = codigoCliente;
		this.nombre = nombre;

	}
	//crear otro constructor
	public Cliente(int codigoCliente){
		this.codigoCliente=codigoCliente;
	}

	public int getcodigoCliente() { //get y seters 
		return codigoCliente;
	}

	public void setcodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() { // al final el to string
		return "Cliente [codigoCliente=" + codigoCliente + ", nombre=" + nombre + "]";
	}
	

}
