package com.auto.entity;

public class DetalleVenta {

	private int codigoDetalleVenta;
	private int numeroContrato;
	private int codigoAuto;
	private int cantidad;
	private int codigoVenta;
	
	public DetalleVenta(int codigoDetalleVenta, int numeroContrato, int codigoAuto, int cantidad, int codigoVenta) {
		this.codigoDetalleVenta = codigoDetalleVenta;
		this.numeroContrato = numeroContrato;
		this.codigoAuto = codigoAuto;
		this.cantidad = cantidad;
		this.codigoVenta = codigoVenta;

	}

	public DetalleVenta(int numeroContrato) {
		// TODO Auto-generated constructor stub
		this.numeroContrato = numeroContrato;
	}

	public DetalleVenta(int codigoAuto, int cantidad, int codigoVenta) {
		// TODO Auto-generated constructor stub
		this.codigoAuto = codigoAuto;
		this.cantidad = cantidad;
		this.codigoVenta = codigoVenta;
	}

	public int getCodigoDetalleVenta() {
		return codigoDetalleVenta;
	}

	public void setCodigoDetalleVenta(int codigoDetalleVenta) {
		this.codigoDetalleVenta = codigoDetalleVenta;
	}

	public int getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(int numeroContrato) {
		this.numeroContrato = numeroContrato;
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
	
	public int getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

	@Override
	public String toString() {
		return "DetalleVenta [codigoDetalleVenta=" + codigoDetalleVenta + ", numeroContrato=" + numeroContrato
				+ ", codigoAuto=" + codigoAuto + ", cantidad=" + cantidad + ", codigoVenta=" + codigoVenta + "]";
	}

	
	
	
}
