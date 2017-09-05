package com.auto.entity;

public class Proveedor {

	
	private int codigoProveedor; //varchar entonces string
	private String nombre;
	private String direccion;
	private int telefono;

	
	public Proveedor(int codigoProveedor, String nombre, String direccion, int telefono) {
		this.codigoProveedor = codigoProveedor;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;

	}


	public Proveedor(String nombre) {
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
	}
	
	public Proveedor(int codigoProveedor) {
		// TODO Auto-generated constructor stub
		this.codigoProveedor = codigoProveedor;
	}



	public int getCodigoProveedor() {
		return codigoProveedor;
	}


	public void setCodigoProveedor(int codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	@Override
	public String toString() {
		return "Proveedor [codigoProveedor=" + codigoProveedor + ", nombre=" + nombre + ", direccion=" + direccion
				+ ", telefono=" + telefono + "]";
	}
	
	
}
