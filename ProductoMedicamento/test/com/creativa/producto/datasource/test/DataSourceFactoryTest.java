package com.creativa.producto.datasource.test;


import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

import com.creativa.producto.datasourse.DataSourceFactory;

public class DataSourceFactoryTest {

	@Test
	public void testDs() {
		DataSource ds = DataSourceFactory.dataSource;
		assertNotNull(ds);
	}
	
	@Test
	public void testConnection() throws SQLException{
		DataSource ds = DataSourceFactory.dataSource;
		assertNotNull(ds);
		Connection con = ds.getConnection();
		assertNotNull(con.isClosed());
		con.close();
		assertTrue(con.isClosed());
		
	}

}
