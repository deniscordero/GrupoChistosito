package com.creativa.producto.reader;

import com.creativa.producto.beans.Producto;
import com.creativa.producto.dao.ProductoDAO;
import com.creativa.producto.datasourse.DataSourceFactory;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductoReadearFile extends SimpleReaderFile{

	private List<Producto> producto;
	
	public ProductoReadearFile(String path) {
		super(path);
		producto = new ArrayList<Producto>();
	}
	
	
	//@Override
	public void guardar()  {
		super.readFile();
		ProductoDAO productoDao = new ProductoDAO(DataSourceFactory.dataSource);
		Producto producto = new Producto();		
		//producto = new ArrayList<Producto>();
		for (String linea : getLineas()) {
		String[] datos = linea.split(";");							
			producto.setCodigoProducto(datos[0]);
			producto.setNombreProducto(datos[1]);
			producto.setPrecioProducto(Double.parseDouble(datos[2]));
			producto.setCantidadProducto(Integer.parseInt(datos[3]));
			try {
				productoDao.insert(producto);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
	}
	
	
	
	
	public List<Producto> getProducto() {
		return this.producto;
	}
	

}
