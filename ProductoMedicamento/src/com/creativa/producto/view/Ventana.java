package com.creativa.producto.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import com.creativa.producto.dao.ProductoDAO;
import com.creativa.producto.datasourse.DataSourceFactory;
import com.creativa.producto.reader.ProductoReadearFile;
import com.creativa.producto.reader.SimpleReaderFile;

public class Ventana extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	String path = "C:\\Users\\Public\\Documents\\productos.txt";
	SimpleReaderFile file = new SimpleReaderFile(path);
	ProductoReadearFile prod = new ProductoReadearFile(path);
	ProductoDAO productoDao = new ProductoDAO(DataSourceFactory.dataSource);

	private JButton boton1;
	private JButton boton2;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;

	public Ventana() {
		super("Proyecto Final");
		this.setSize(270, 250);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);	
	}
	
	public void definirVentata(){
		this.setLayout(new FlowLayout());
		label1 = new JLabel("Alumno: Denis Wilfredo Mejia Cordero");	
		label2 = new JLabel("Alumno: Pedro Navarrate");
		label3 =  new JLabel("                                     " +
				"                                     " +
				"");
		label4 =  new JLabel("Leer archivo y guardarlo en " +
				"la base de datos");
		label5 =  new JLabel("Borrar todos los datos de la Tabla ");
		label6 =  new JLabel("Guarde el archivo en la siguiente ubicacion:");
		label7 = new JLabel("C:\\Users\\Public\\Documents\\productos.txt ");
		boton1 = new JButton("Eejecutar");
		boton2 = new JButton("Borrar");
		
		this.add(label1);
		this.add(label2);
		this.add(label3);
		this.add(label4);
		this.add(boton1);
		this.add(label5);
		this.add(boton2);
		this.add(label6);
		this.add(label7);
		boton1.addActionListener(this);
		boton2.addActionListener(this);		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boton1 ) {
			file.readFile();
			prod.leerGuardar();
			ProductoView.createAndShowGUI();
		}if (e.getSource() == boton2){
			try {
				productoDao.delete();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
}
