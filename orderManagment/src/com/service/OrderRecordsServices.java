package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.model.*;
import com.util.DbConnect;


public class OrderRecordsServices {
	
	private static Connection connection ;
	private PreparedStatement preStatement ;
	
	
	
	
	public void addOrder(Order order, Client client) {
		try {
			connection = DbConnect.getDBConnection();
			String addClient ="insert into orders (clientID, orderID, productType, orderDate, dayOfNeed, quantity, superviserID, color, transportType, location, remark) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
			
			preStatement = connection.prepareStatement(addClient);
			
			preStatement.setString(1, client.getClientId());
			preStatement.setString(2, order.getOrderID());
			preStatement.setString(3, order.getProductType());
			preStatement.setString(4, order.getOrderDate());
			preStatement.setString(5, order.getDayOfNeed());
			preStatement.setString(6, order.getQuantity());
			preStatement.setString(7, order.getSuperviserID());
			preStatement.setString(8, order.getColor());
			preStatement.setString(9, order.getTransportType());
			preStatement.setString(10, order.getLocation());
			preStatement.setString(11, order.getRemark());
			
			preStatement.executeUpdate() ;
			JOptionPane.showMessageDialog(null, "Order Inserted Sucessfully....");
			connection.commit();
			
		} catch(SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			JOptionPane.showMessageDialog(null, "Error....");
		}finally {
			try {
				if (preStatement != null) {
					
					preStatement.close();
				}
				if(connection != null) {
					
					connection.close();
				}
			}catch(SQLException e) {
				
			}
		}
	}
	
	public  void updateOrder(String orderID, Order order) {
		
	}
	
	public void removeOrder(String orderID) {
		
	}
	
	
}
