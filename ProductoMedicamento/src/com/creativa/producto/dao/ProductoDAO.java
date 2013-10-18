package com.creativa.producto.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.creativa.producto.beans.*;


public class ProductoDAO extends BaseDAO{

	public ProductoDAO(DataSource ds) {
		super(ds);
		
	}
	
	public void insert(Producto producto) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		StringBuilder sql = new StringBuilder();
		int pos = 1;
		sql.append(" INSERT ")
		   .append(" INTO PRODUCTO_GRUPO_CHISTOSITO ")
		   .append("   ( ")
		   .append("     CODIGO_PRODUCTO, ")//1
		   .append("     NOMBRE_PRODUCTO, ")//2
		   .append("     PRECIO_PRODUCTO, ")//3
		   .append("     CANTIDAD_PRODUCTO ")//7
		   .append("   ) ")
		   .append("   VALUES ")
		   .append("   ( ")
		   .append("     ?, ")//1
		   .append("     ?, ")//2
		   .append("     ?, ")//3
		   .append("     ? ")//4
		   .append("   ) ");
//		sql.append(" INSERT ")
//		   .append(" INTO PRODUCTO ")
//		   .append("   ( ")
//		   .append("     CODIGO_PRODUCTO, ")
//		   .append("     NOMBRE_PRODUCTO, ")
//		   .append("     PRECIO_PRODUCTO, ")
//		   .append("     CANTIDAD_PRODUCTO, ")
//		   .append("   ) ")
//		   .append("   VALUES ")
//		   .append("   ( ")
//		   .append("     ?, ")//1
//		   .append("     ?, ")//2
//		   .append("     ?, ")//3
//		   .append("     ?, ")//4
//		   .append("   ) ");
		try {
			con = getConnection();
			ps = con.prepareStatement(sql.toString());
			if(producto.getCodigoProducto() == null) {
				ps.setNull(pos++, Types.VARCHAR);
			} else {
				ps.setString(pos++, producto.getCodigoProducto());
			}
			if(producto.getNombreProducto() == null) {
				ps.setNull(pos++, Types.VARCHAR);
			} else {
				ps.setString(pos++, producto.getNombreProducto());
			}
			if(producto.getPrecioProducto() == null) {
				ps.setNull(pos++, Types.NUMERIC);
			} else {
				ps.setDouble(pos++, producto.getPrecioProducto());
			}
			if(producto.getCantidadProducto()== null) {
				ps.setNull(pos++, Types.INTEGER);
			} else {
				ps.setInt(pos++, producto.getCantidadProducto());
			}
			
			ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			if(ps != null) {
				ps.close();
			}
			if(con != null) {
				con.close();
			}
		}
	}

	public void update(Producto producto) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		StringBuilder sql = new StringBuilder();
		int pos = 1;
		sql.append(" UPDATE PRODUCTO ")
		   .append("    SET NOMBRE_PRODUCTO = ? ")
		   .append("      , PRECIO_PRODUCTO = ? ")
		   .append("      , CANTIDAD_PRODUCTO =? ")
		   .append("  WHERE CODIGO_PRODUCTO  = ? ");
		try {
			con = getConnection();
			ps = con.prepareStatement(sql.toString());
			if(producto.getNombreProducto() == null) {
				ps.setNull(pos++, Types.VARCHAR);
			} else {
				ps.setString(pos++, producto.getNombreProducto());
			}
			if(producto.getPrecioProducto() == null) {
				ps.setNull(pos++, Types.VARCHAR);
			} else {
				ps.setDouble(pos++, producto.getPrecioProducto());
			}
			if(producto.getCantidadProducto() == null) {
				ps.setNull(pos++, Types.VARCHAR);
			} else {
				ps.setInt(pos++, producto.getCantidadProducto());
			}
			
			
			ps.setString(pos++, producto.getCodigoProducto());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			if(ps != null) {
				ps.close();
			}
			if(con != null) {
				con.close();
			}
		}
	}
	
	public void delete(String key) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		StringBuilder sql = new StringBuilder();
		int pos = 1;
		sql.append(" DELETE FROM PRODUCTO ")
		   .append("  WHERE CODIGO_PRODUCTO  = ? ");
		try {
			con = getConnection();
			ps = con.prepareStatement(sql.toString());
			ps.setString(pos++, key);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			if(ps != null) {
				ps.close();
			}
			if(con != null) {
				con.close();
			}
		}
	}
	
	public List<Producto> findAll(int first, int size) throws SQLException {
		List<Producto> l = new ArrayList<Producto>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select * ")
		   .append(" from ( ")
		   .append("      select rownum row_num, sub.* ")
		   .append("       from ( ")
		   .append("             select * from producto order by codigo_producto desc ")
		   .append("            ) sub ")
		   .append("       where rownum <= ? ")
		   .append("   ) ")
		   .append("   where row_num > ? ");
		try {
			con = getConnection();
			ps = con.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE
					,ResultSet.CONCUR_UPDATABLE);
			ps.setFetchSize(size);
			ps.setMaxRows(size);
			ps.setInt(1, ((size*first) + size));
			ps.setInt(2, size*first);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				l.add(new Producto(rs.getString("CODIGO_PRODUCTO")
						, rs.getString("NOMBRE_PRODUCTO")
						, rs.getDouble("PRECIO_PRODUCTO")
						, rs.getInt("CANTIDAD_PRODUCTO")));
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(con != null) {
				con.close();
			}
		}
		return l;
	}

	
	
}
