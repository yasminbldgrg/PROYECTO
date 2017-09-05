package com.auto.entity;

public class DetalleCompra {
	
	private int codigoDetalleCompra;
	private int numeroContrato;
	private int codigoAuto;
	private int cantidad;
	
	public DetalleCompra(int codigoDetalleCompra, int numeroContrato, int codigoAuto, int cantidad) {
		this.codigoDetalleCompra = codigoDetalleCompra;
		this.numeroContrato = numeroContrato;
		this.codigoAuto = codigoAuto;
		this.cantidad = cantidad;

	}

	public DetalleCompra(int numeroContrato) {
		// TODO Auto-generated constructor stub
		this.numeroContrato = numeroContrato;
	}

	public int getCodigoDetalleCompra() {
		return codigoDetalleCompra;
	}

	public void setCodigoDetalleCompra(int codigoDetalleCompra) {
		this.codigoDetalleCompra = codigoDetalleCompra;
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

	@Override
	public String toString() {
		return "DetalleCompra [codigoDetalleCompra=" + codigoDetalleCompra + ", numeroContrato=" + numeroContrato
				+ ", codigoAuto=" + codigoAuto + ", cantidad=" + cantidad + "]";
	}
	
	

}
