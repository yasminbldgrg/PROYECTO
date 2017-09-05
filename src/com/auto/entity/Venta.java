package com.auto.entity;

public class Venta {

	
	private int codigoVenta;
	 private int codigoAuto;
	 private int cantidad;
	 
	 public Venta(int codigoVenta, int codigoAuto, int cantidad) {
			this.codigoVenta = codigoVenta;
			this.codigoAuto = codigoAuto;
			this.cantidad = cantidad;

		}

	public Venta(int codigoVenta) {
		// TODO Auto-generated constructor stub
		this.codigoVenta=codigoVenta;
	}

	public Venta(int codigoAuto, int cantidad) {
		// TODO Auto-generated constructor stub
		this.codigoAuto = codigoAuto;
		this.cantidad = cantidad;
	}

	public int getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
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
		return "Venta [codigoVenta=" + codigoVenta + ", codigoAuto=" + codigoAuto + ", cantidad=" + cantidad + "]";
	}
	 
	 
}
