package com.auto.entity;

import java.util.Date;

public class Factura {
	private int numeroFactura;
	private double monto;
	private String NIT;
	private Date fecha;
	
	public Factura(int numeroFactura, double monto, String NIT, Date fecha) {
		this.numeroFactura = numeroFactura;
		this.monto = monto;
		this.NIT = NIT;
		this.fecha = fecha;

}

	public Factura(String NIT) {
		this.NIT = NIT;
		// TODO Auto-generated constructor stub
	}

	public Factura(int numeroFactura) {
		// TODO Auto-generated constructor stub
		this.numeroFactura = numeroFactura;
	}

	public int getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(int numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getNIT() {
		return NIT;
	}

	public void setNIT(String nIT) {
		NIT = nIT;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Factura [numeroFactura=" + numeroFactura + ", monto=" + monto + ", NIT=" + NIT + ", fecha=" + fecha
				+ "]";
	}
	
	
}
