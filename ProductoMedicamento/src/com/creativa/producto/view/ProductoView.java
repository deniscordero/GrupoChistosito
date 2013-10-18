package com.creativa.producto.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import com.creativa.producto.dao.ProductoDAO;
import com.creativa.producto.datasourse.DataSourceFactory;
import com.creativa.producto.view.table.model.ProductoTableModel;


public class ProductoView extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTable table;
	
	public ProductoView() {
		
		table = new JTable(new ProductoTableModel(
				new ProductoDAO(DataSourceFactory.dataSource)));
		//JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		setLayout(new BorderLayout());
		add(table.getTableHeader(), BorderLayout.PAGE_START);
		add(table, BorderLayout.CENTER);
	}
	
    private static void createAndShowGUI() {
 
        //Create and set up the window.
        JFrame frame = new JFrame("Table Model Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        ProductoView newContentPane = new ProductoView();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }
}