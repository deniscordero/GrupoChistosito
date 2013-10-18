package com.creativa.producto;
import java.sql.SQLException;

import com.creativa.producto.beans.Producto;
import com.creativa.producto.dao.ProductoDAO;
import com.creativa.producto.reader.ProductoReadearFile;
import com.creativa.producto.reader.SimpleReaderFile;
import com.creativa.producto.view.ProductoView;


public class Main {
	
	public static void main(String[] args){
		String path = "C:\\Users\\Public\\Documents\\productos.txt";
		SimpleReaderFile file = new SimpleReaderFile(path);
		file.readFile();
		ProductoReadearFile prod = new ProductoReadearFile(path);
		
		ProductoView view = new ProductoView();

		prod.guardar();
		
		view.createAndShowGUI();
		


		
	}

}
