package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.model.Client;
import com.util.DbConnect;

public class ClientRecordsServices {
	
	private static Connection connection ;
	private PreparedStatement preStatement ;
	

	
	public void addClient(Client client) {
		try {
			connection = DbConnect.getDBConnection();
			String addClient ="insert into client (clientId,fname,lname,company,nic,contact,email,address) values (?,?,?, ?, ?, ?, ?, ?)"; 
			
			preStatement = connection.prepareStatement(addClient);
			
			preStatement.setString(1, client.getClientId());
			preStatement.setString(2, client.getFirstName());
			preStatement.setString(3, client.getLastName());
			preStatement.setString(4, client.getCompanyName());
			preStatement.setString(5, client.getNicNo());
			preStatement.setString(6, client.getContactNo());
			preStatement.setString(7, client.getEmailAddress());
			preStatement.setString(8, client.getClientAddress());
			
			preStatement.executeUpdate() ;
			JOptionPane.showMessageDialog(null, "Record Inserted Sucessfully....");
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

	
	
	public void updateClient(String clientID, Client client) {
		try {
			
			connection = DbConnect.getDBConnection();
			String updateClient = "UPDATE ordermanagement.client SET  fname = '"+client.getFirstName()+"', lname = '"+client.getLastName()+"', company = '"+client.getCompanyName()+"', nic = '"+client.getNicNo()+"', contact = '"+client.getContactNo()+"', email = '"+client.getEmailAddress()+"', address = '"+client.getClientAddress()+"' WHERE (clientId = '"+clientID+"')";
	
			
			preStatement = connection.prepareStatement(updateClient);
			
			preStatement.executeUpdate() ;
			JOptionPane.showMessageDialog(null, "Record no: "+clientID+" Updated Sucessfully....");
			
		}catch(SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			
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


	
	public void removeCLient(String clientID) {
		try {
			connection = DbConnect.getDBConnection();
			
			String deleteClient = "delete from client where client.clientId = ?";
			
			preStatement = connection.prepareStatement(deleteClient);
			
			preStatement.setString(1, clientID);
			preStatement.executeUpdate() ;
			JOptionPane.showMessageDialog(null, "Record no: "+clientID+" Removed Sucessfully....");
			
		}catch(SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			
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
	
	
	
	
	
}
