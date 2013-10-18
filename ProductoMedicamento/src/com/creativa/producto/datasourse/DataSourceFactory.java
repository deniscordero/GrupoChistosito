package com.creativa.producto.datasourse;

import java.sql.SQLException;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

public class DataSourceFactory {
	public static DataSource dataSource;
	
	static{
		OracleDataSource oracleDataSource;
		try {
			oracleDataSource = new OracleDataSource();
			oracleDataSource.setDriverType("thin");
			oracleDataSource.setServerName("localhost");
			oracleDataSource.setPortNumber(1521);
			oracleDataSource.setDatabaseName("xe");
			oracleDataSource.setUser("curso01");
			oracleDataSource.setPassword("curso01");
			dataSource = oracleDataSource;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}