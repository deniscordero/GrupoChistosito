package com.creativa.producto.beans;

public class Producto {
	
	private String codigoProducto;
	private String nombreProducto;
	private String cantidadProducto;
	private String precioProducto;
	
	public Producto() {}
	
		
	public Producto(String codigoProducto, String nombreProducto,
			String precioProducto, String cantidadProducto) {
		super();
		this.codigoProducto = codigoProducto;
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
		this.cantidadProducto = cantidadProducto;
		
	}





	public String getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getCantidadProducto() {
		return cantidadProducto;
	}
	public void setCantidadProducto(String cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}
	public String getPrecioProducto() {
		return precioProducto;
	}
	public void setPrecioProducto(String precioProducto) {
		this.precioProducto = precioProducto;
	}
	
	

}
