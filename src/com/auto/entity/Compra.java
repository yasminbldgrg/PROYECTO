package com.auto.entity;

public class Compra {
	
	 private int codigoCompra;
	 private int codigoAuto;
	 private int cantidad;
	 
	 public Compra(int codigoCompra, int codigoAuto, int cantidad) {
			this.codigoCompra = codigoCompra;
			this.codigoAuto = codigoAuto;
			this.cantidad = cantidad;

		}
	 
	 

	public Compra(int codigoCompra) {
		this.codigoCompra = codigoCompra;
		// TODO Auto-generated constructor stub
	}



	public int getCodigoCompra() {
		return codigoCompra;
	}

	public void setCodigoCompra(int codigoCompra) {
		this.codigoCompra = codigoCompra;
	}

	public int getCodigoAuto() {
		return codigoAuto;
	}

	public void setCodigoAuto(int codigoAuto) {
		this.codigoAuto = codigoAuto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Compra [codigoCompra=" + codigoCompra + ", codigoAuto=" + codigoAuto + ", cantidad=" + cantidad + "]";
	}
	 
	 

}
