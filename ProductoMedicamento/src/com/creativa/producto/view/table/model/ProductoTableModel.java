package com.creativa.producto.view.table.model;


import java.sql.SQLException;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import com.creativa.producto.beans.Producto;
import com.creativa.producto.dao.ProductoDAO;



public class ProductoTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ProductoDAO dao;
	
	private List<Producto> productos;
	
	private String[] columnsName = {"Nombre Producto", "Cantidad Producto", "Precio Producto"};
	
	public ProductoTableModel(ProductoDAO dao) {
		super();
		this.dao = dao;
		try {
		productos = this.dao.findAll(0,10);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String getColumnName(int column) {
		return columnsName[column];
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return 10;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object r = null;
		Producto c = productos.get(rowIndex);
		switch (columnIndex) {
		case 0:
			r = c.getNombreProducto();
			break;
		case 1:
			r = c.getPrecioProducto();
			break;
		case 2:
			r = c.getCantidadProducto();
			break;
		default:
			break;
		}
		return r;
	}
	
		

}
