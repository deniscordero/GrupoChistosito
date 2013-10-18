package com.creativa.producto;
import com.creativa.producto.beans.Producto;
import com.creativa.producto.reader.ProductoReadearFile;
import com.creativa.producto.reader.SimpleReaderFile;


public class Main {
	
	public static void main(String[] args) {
		String path = "C:\\Users\\Public\\Documents\\productos.txt";
		SimpleReaderFile file = new SimpleReaderFile(path);
		file.readFile();
		
		ProductoReadearFile prod = new ProductoReadearFile(path);
		
		
		System.out.println("Alumno: Denis Wilfredo Mejia Cordero");
		System.out.println("###################### + Producto + " +
				"######################");
		
		prod.readFile();
		for (Producto producto : prod.getProducto()) {
			
			System.out.println(producto.getCodigoProducto()  + " "+  
					producto.getNombreProducto()+ " 					"+ 
			producto.getPrecioProducto()
					+ " " +producto.getCantidadProducto());
	
			
			
		}
	}

}
