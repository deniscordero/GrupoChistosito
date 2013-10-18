package com.creativa.producto.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;


import com.creativa.producto.datasourse.DataSourceFactory;
import com.creativa.dummy.data.generator.IntegerDummyGenerator;
import com.creativa.dummy.data.generator.StringDummyGenerator;

import com.creativa.producto.beans.Producto;

public class ProductoDAOTest {

	private ProductoDAO productoDAO;
	@Before
	public void setUp() throws Exception {
		productoDAO = new ProductoDAO(
				DataSourceFactory.dataSource);
	}

	@Test
	public void test() throws SQLException {
		Producto producto = new Producto();
		producto.setCodigoProducto("ABDCF1");
		producto.setNombreProducto("Aspirina");
		producto.setPrecioProducto(32.00);
		producto.setCantidadProducto(12);
		productoDAO.insert(producto);
		assertTrue(true);
		
		
		
	}

}
