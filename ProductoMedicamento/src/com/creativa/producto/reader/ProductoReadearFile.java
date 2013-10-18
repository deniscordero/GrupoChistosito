package com.creativa.producto.reader;

import com.creativa.producto.beans.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoReadearFile extends SimpleReaderFile{

	private List<Producto> producto;
	
	public ProductoReadearFile(String path) {
		super(path);
		producto = new ArrayList<Producto>();
	}
	
	
	@Override
	public void readFile() {
		super.readFile();
		producto = new ArrayList<Producto>();
		for (String linea : getLineas()) {
			String[] datos = linea.split(";");
			producto.add(new Producto(datos[0], datos[1], 
					Double.parseDouble(datos[2]), Integer.parseInt(datos[3])));
		}
	}
	
	public List<Producto> getProducto() {
		return this.producto;
	}
	

}
