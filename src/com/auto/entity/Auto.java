package com.auto.entity;

public class Auto {
	
	private int codigoAuto;
	private int stock;
	public String color;
	private String modelo;
	private String marca;
	private int numeroPuestos;
	private int precio;
	
	
	public Auto(int codigoAuto,String color, String modelo, String marca, int numeroPuestos, int stock, int precio) {
		this.codigoAuto = codigoAuto;
		this.color = color;
		this.stock = stock;
		this.modelo = modelo;
		this.marca = marca;
		this.numeroPuestos = numeroPuestos;
		this.precio = precio;

	}


	public Auto(String marca) {
		this.codigoAuto = marca;
		// TODO Auto-generated constructor stub
	}

//	public Auto(String color, String modelo, String marca, int numeroPuestos, int stock, int precio2) {
		// TODO Auto-generated constructor stub
//	}


	public int getCodigoAuto() {
		return codigoAuto;
	}


	public void setCodigoAuto(int codigoAuto) {
		this.codigoAuto = codigoAuto;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public int getNumeroPuestos() {
		return numeroPuestos;
	}
	
	public void setNumeroPuestos(int numeroPuestos) {
		this.numeroPuestos = numeroPuestos;
	}

	
	public int getstock() {
		return stock;
	}

	public void setstock(int stock) {
		this.stock = stock;
	}
	
	public int getprecio() {
		return precio;
	}

	public void setprecio(int precio) {
		this.precio = precio;
	}
	

	@Override
	public String toString() {
		return "Auto [codigoAuto=" + codigoAuto + ", color=" + color + ", modelo=" + modelo + ", marca=" + marca +", numeroPuestos="
				+ numeroPuestos + ", stock=" + stock+", precio=" + precio +"]";
	}
	
	

}
