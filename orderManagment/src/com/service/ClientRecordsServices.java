package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import com.interfaces.MainOrderInterface;
import com.model.Client;
import com.util.DbConnect;

import net.proteanit.sql.DbUtils;

public class ClientRecordsServices {
	
	private static Connection connection ;
	private PreparedStatement preStatement ;


	
	public void addClient(Client client) {
		try {
			connection = DbConnect.getDBConnection();
			String addClient ="insert into customer (clientID,FName,LName,companyName,NICNo,ContactNo,Email,Address) values (?,?,?, ?, ?, ?, ?, ?)"; 
			
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
			String updateClient = "UPDATE unic.customer SET  FName = '"+client.getFirstName()+"', LName = '"+client.getLastName()+"', companyName = '"+client.getCompanyName()+"', NICNo = '"+client.getNicNo()+"', ContactNo = '"+client.getContactNo()+"', Email = '"+client.getEmailAddress()+"', Address = '"+client.getClientAddress()+"' WHERE (clientID = '"+clientID+"')";
	
			
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
			
			String deleteClient = "delete from customer where customer.clientID = ?";
			
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
	
	public ResultSet searchByID(String clientID) {
		try {
			String selectClient = "SELECT clientID,FName,LName,companyName,NICNo,ContactNo,Email,Address FROM unic.customer where clientID = '"+clientID+"';";
			connection = DbConnect.getDBConnection();
			preStatement = connection.prepareStatement(selectClient);
			ResultSet resultSet = preStatement.executeQuery();
			return resultSet;
		} catch (Exception e) {
			return null;
		}
				
	}
	
	public ResultSet searchByFName(String firstName) {
		try {
			String selectClient = "SELECT clientID,FName,LName,companyName,NICNo,ContactNo,Email,Address FROM unic.customer where FName = '"+firstName+"';";
			connection = DbConnect.getDBConnection();
			preStatement = connection.prepareStatement(selectClient);
			ResultSet resultSet = preStatement.executeQuery();
			return resultSet;
		} catch (Exception e) {
			return null;
		}
				
	}
	
	public ResultSet searchByLName(String lastName) {
		try {
			String selectClient = "SELECT clientID,FName,LName,companyName,NICNo,ContactNo,Email,Address FROM unic.customer where LName = '"+lastName+"';";
			connection = DbConnect.getDBConnection();
			preStatement = connection.prepareStatement(selectClient);
			ResultSet resultSet = preStatement.executeQuery();
			return resultSet;
		} catch (Exception e) {
			return null;
		}
				
	}
		
	
}
