package com.interfaces;

import java.awt.EventQueue;
import com.model.Client;
import com.model.Order;
import com.mysql.cj.xdevapi.Table;
import com.service.*;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.StringCharacterIterator;
import java.time.Month;
import java.time.Year;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import com.util.DbConnect;

import net.proteanit.sql.DbUtils;

import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.apache.taglibs.standard.lang.jstl.AndOperator;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JSplitPane;


public class MainOrderInterface {
	
	private int refreshValue;	
	private static Connection connection ;
	private static Statement statement ;
	private PreparedStatement preStatement ;
	
	private JFrame frame;
	private JTextField emailAddress;
	private JTextField contactNumber;
	private JTextField nicNo;
	private JTextField companyName;
	private JTextField lastName;
	private JTextField firstName;
	private JTextField clientID;
	private JTextField address;
	private JTextField txtOrderID;
	private JTextField textField_8;
	private JTextField quantity1;
	private JTextField textField_11;
	private JTextField Location;
	private JTextField Remark;
	private JTable table;
	private JTextField textField;
	
	//Object Declaration
	
	Client client = new Client();
	Order order = new Order();
	ClientRecordsServices clientRecordsServices = new ClientRecordsServices();
	OrderRecordsServices orderRecordsServices = new OrderRecordsServices();
	JDateChooser orderDate = new JDateChooser();
	
	//Object Declaration
	
	
	private void viewAllOrders() {
		try {
			String selectClient = "select * from order";
			connection = DbConnect.getDBConnection();
			preStatement = connection.prepareStatement(selectClient);
			ResultSet resultSet = preStatement.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(resultSet));
		} catch (Exception e) {
			
		}
	}
	
	public void viewAllClients() {
		try {
			String selectClient = "select * from customer";
			connection = DbConnect.getDBConnection();
			preStatement = connection.prepareStatement(selectClient);
			ResultSet resultSet = preStatement.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(resultSet));
		} catch (Exception e) {
			
		}
	}
	
	
	private void textSetClient() {

		client.setClientId(clientID.getText());
		client.setFirstName(firstName.getText());
		client.setLastName(lastName.getText());
		client.setCompanyName(companyName.getText());
		client.setNicNo(nicNo.getText());
		client.setContactNo(contactNumber.getText());
		client.setEmailAddress(emailAddress.getText());
		client.setClientAddress(address.getText());
	}
	
	private void textSetOrder() {
		JComboBox comboBox = null;
		Object orderDate = null;
		
		order.setOrderID(txtOrderID.getText());
		order.setProductType(comboBox.getSelectedItem().toString());
		
		order.setOrderDate(orderDate.toString());
		
	}
	
	
	
	private void tableSelectItemClient() {
		JOptionPane.showMessageDialog(null, "CLient Only");
		int rowNumber = table.getSelectedRow();
		     clientID.setText(table.getValueAt(rowNumber, 0).toString());
		    firstName.setText(table.getValueAt(rowNumber, 1).toString());
		     lastName.setText(table.getValueAt(rowNumber, 2).toString());
		  companyName.setText(table.getValueAt(rowNumber, 3).toString());
		        nicNo.setText(table.getValueAt(rowNumber, 4).toString());
		contactNumber.setText(table.getValueAt(rowNumber, 5).toString());
		 emailAddress.setText(table.getValueAt(rowNumber, 6).toString());
		      address.setText(table.getValueAt(rowNumber, 7).toString());
	}
	
	private void tableSelectItemOrder() {
		JOptionPane.showMessageDialog(null, "Order Only");
		int rowNumber = table.getSelectedRow();
		
		   clientID.setText(table.getValueAt(rowNumber, 0).toString());
		  firstName.setText(table.getValueAt(rowNumber, 1).toString());
		   lastName.setText(table.getValueAt(rowNumber, 2).toString());
		companyName.setText(table.getValueAt(rowNumber, 3).toString());
		      nicNo.setText(table.getValueAt(rowNumber, 4).toString());
	  contactNumber.setText(table.getValueAt(rowNumber, 5).toString());
	   emailAddress.setText(table.getValueAt(rowNumber, 6).toString());
		    address.setText(table.getValueAt(rowNumber, 7).toString());
	}
	
	private void allOrderItems() {
		JOptionPane.showMessageDialog(null, "Both");
		int rowNumber = table.getSelectedRow();
		   clientID.setText(table.getValueAt(rowNumber, 0).toString());
		  firstName.setText(table.getValueAt(rowNumber, 1).toString());
		   lastName.setText(table.getValueAt(rowNumber, 2).toString());
		companyName.setText(table.getValueAt(rowNumber, 3).toString());
		      nicNo.setText(table.getValueAt(rowNumber, 4).toString());
	  contactNumber.setText(table.getValueAt(rowNumber, 5).toString());
	   emailAddress.setText(table.getValueAt(rowNumber, 6).toString());
		    address.setText(table.getValueAt(rowNumber, 7).toString());
	}
	
	
	
	
	/**
	 * Launch the application.
	 * @throws SQLException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	
	
	
	
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		DbConnect dbConnect  = new DbConnect();
		dbConnect.getDBConnection();
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainOrderInterface window = new MainOrderInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainOrderInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 786, 622);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		emailAddress = new JTextField();
		emailAddress.setColumns(10);
		emailAddress.setBounds(143, 208, 216, 20);
		frame.getContentPane().add(emailAddress);
		
		JLabel label = new JLabel("Email");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(10, 204, 86, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Contact No");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(10, 180, 94, 14);
		frame.getContentPane().add(label_1);
		
		contactNumber = new JTextField();
		contactNumber.setColumns(10);
		contactNumber.setBounds(143, 183, 216, 20);
		frame.getContentPane().add(contactNumber);
		
		nicNo = new JTextField();
		nicNo.setColumns(10);
		nicNo.setBounds(143, 158, 216, 20);
		frame.getContentPane().add(nicNo);
		
		JLabel label_2 = new JLabel("NIC No");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(10, 158, 71, 14);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Company Name");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(10, 133, 113, 14);
		frame.getContentPane().add(label_3);
		
		companyName = new JTextField();
		companyName.setText("None");
		companyName.setColumns(10);
		companyName.setBounds(143, 133, 216, 20);
		frame.getContentPane().add(companyName);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(143, 108, 216, 20);
		frame.getContentPane().add(lastName);
		
		JLabel label_4 = new JLabel("Last Name");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_4.setBounds(10, 108, 86, 14);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("First Name");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBounds(10, 83, 86, 14);
		frame.getContentPane().add(label_5);
		
		firstName = new JTextField();
		firstName.setColumns(10);
		firstName.setBounds(143, 83, 216, 20);
		frame.getContentPane().add(firstName);
		
		clientID = new JTextField();
		clientID.setColumns(10);
		clientID.setBounds(143, 58, 216, 20);
		frame.getContentPane().add(clientID);
		
		JLabel label_6 = new JLabel("Client ID");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_6.setBounds(10, 58, 86, 14);
		frame.getContentPane().add(label_6);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(143, 233, 216, 20);
		frame.getContentPane().add(address);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddress.setBounds(10, 229, 86, 14);
		frame.getContentPane().add(lblAddress);
		
		JButton btnNewButton_1 = new JButton("Update Client");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshValue = 2;
				textSetClient();
				clientRecordsServices.updateClient(clientID.getText(), client);
				viewAllClients();
		
			}
		});
		btnNewButton_1.setBounds(10, 344, 113, 23);
		frame.getContentPane().add(btnNewButton_1);
		//s
		JButton btnSearchClient = new JButton("Search Client");
		btnSearchClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (clientID.getText().equals("") && firstName.getText().equals("") && lastName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter 'ClientID','First Name' or 'Last Name' to proceed the search...");
				} else if (firstName.getText().equals("") && lastName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Client ID onlly");
					table.setModel(DbUtils.resultSetToTableModel(clientRecordsServices.searchByID(clientID.getText())));
				} else if (clientID.getText().equals("") && lastName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "First Name Only");
					table.setModel(DbUtils.resultSetToTableModel(clientRecordsServices.searchByFName(firstName.getText())));
				} else if (clientID.getText().equals("") && firstName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Last Name Only");
					table.setModel(DbUtils.resultSetToTableModel(clientRecordsServices.searchByLName(lastName.getText())));
				} else {
					JOptionPane.showMessageDialog(null, "Use Only One Field to search");
					clientID.setText("");
					firstName.setText("");
					lastName.setText("");
				}
				refreshValue = 3;
				textSetClient();	
				
				
			}
		});
		btnSearchClient.setBounds(129, 344, 113, 23);
		frame.getContentPane().add(btnSearchClient);
		
		txtOrderID = new JTextField();
		txtOrderID.setColumns(10);
		txtOrderID.setBounds(550, 58, 209, 20);
		frame.getContentPane().add(txtOrderID);
		
		JLabel lblOrderId = new JLabel("Order ID");
		lblOrderId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOrderId.setBounds(417, 58, 86, 14);
		frame.getContentPane().add(lblOrderId);
		
		JLabel lblOrderType = new JLabel("Product Type");
		lblOrderType.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOrderType.setBounds(417, 83, 86, 14);
		frame.getContentPane().add(lblOrderType);
		
		JLabel lblOrderDate = new JLabel("Order Date");
		lblOrderDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOrderDate.setBounds(417, 108, 86, 14);
		frame.getContentPane().add(lblOrderDate);
		
		JLabel lblDayOfNeed = new JLabel("Day Of Need");
		lblDayOfNeed.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDayOfNeed.setBounds(417, 133, 113, 14);
		frame.getContentPane().add(lblDayOfNeed);
		
		JLabel lblDayOfComplete = new JLabel("Day Of Complete");
		lblDayOfComplete.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDayOfComplete.setBounds(417, 158, 113, 14);
		frame.getContentPane().add(lblDayOfComplete);
		
		JLabel lblSuperviserId = new JLabel("Superviser ID");
		lblSuperviserId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSuperviserId.setBounds(417, 210, 94, 14);
		frame.getContentPane().add(lblSuperviserId);
		
		JButton btnNewButton_2 = new JButton("Place Order");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshValue = 6;
				textSetClient();
				clientRecordsServices.addClient(client);
				orderRecordsServices.addOrder(order, client);
			}
		});
		btnNewButton_2.setBackground(Color.GREEN);
		btnNewButton_2.setBounds(417, 376, 342, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Update Order");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshValue = 7;
			}
		});
		btnNewButton_3.setBounds(417, 344, 113, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Search Order");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshValue = 8;
				System.out.println(orderDate.getDate());
			}
		});
		btnNewButton_4.setBounds(532, 344, 113, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JComboBox cmbSuperID = new JComboBox();
		cmbSuperID.setBounds(550, 209, 209, 20);
		frame.getContentPane().add(cmbSuperID);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setEditable(true);
		comboBox_2.setBounds(143, 8, 101, 22);
		frame.getContentPane().add(comboBox_2);
		
		JLabel lblProductType = new JLabel("Product Type");
		lblProductType.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblProductType.setBounds(10, 11, 86, 14);
		frame.getContentPane().add(lblProductType);
		orderDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Hiii");
			}
		});
		orderDate.setDateFormatString("MM ,DD,YY");
		
		
		orderDate.setBounds(550, 108, 209, 20);
		frame.getContentPane().add(orderDate);
		
		JDateChooser dayOfNeed = new JDateChooser();
		dayOfNeed.setBounds(550, 133, 209, 20);
		frame.getContentPane().add(dayOfNeed);
		
		JDateChooser dayOfComplete = new JDateChooser();
		dayOfComplete.setBounds(550, 158, 209, 20);
		frame.getContentPane().add(dayOfComplete);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(322, 9, 113, 20);
		frame.getContentPane().add(textField_8);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAmount.setBounds(262, 11, 86, 14);
		frame.getContentPane().add(lblAmount);
		
		JLabel lblAmount_1 = new JLabel("Quantity");
		lblAmount_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAmount_1.setBounds(417, 185, 113, 14);
		frame.getContentPane().add(lblAmount_1);
		
		quantity1 = new JTextField();
		quantity1.setColumns(10);
		quantity1.setBounds(550, 183, 209, 20);
		frame.getContentPane().add(quantity1);
		
		JLabel lblAvailability = new JLabel("Availability");
		lblAvailability.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAvailability.setBounds(458, 11, 86, 14);
		frame.getContentPane().add(lblAvailability);
		
		textField_11 = new JTextField();
		textField_11.setEnabled(false);
		textField_11.setColumns(10);
		textField_11.setBounds(542, 11, 94, 20);
		frame.getContentPane().add(textField_11);
		
		JButton btnQuichSearch = new JButton("Quick Search");
		btnQuichSearch.setBounds(646, 9, 113, 21);
		frame.getContentPane().add(btnQuichSearch);
		
		JLabel lblTransportType = new JLabel("Transport Type");
		lblTransportType.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTransportType.setBounds(417, 235, 113, 14);
		frame.getContentPane().add(lblTransportType);
		
		JComboBox cmpTransport = new JComboBox();
		cmpTransport.setBounds(550, 233, 209, 20);
		frame.getContentPane().add(cmpTransport);
		
		JLabel lblRemark = new JLabel("Location");
		lblRemark.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRemark.setBounds(417, 286, 113, 14);
		frame.getContentPane().add(lblRemark);
		
		Location = new JTextField();
		Location.setColumns(10);
		Location.setBounds(550, 283, 209, 20);
		frame.getContentPane().add(Location);
		
		JButton btnNewButton = new JButton("Add Client");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				refreshValue = 1;
				textSetClient();	
				clientRecordsServices.addClient(client);
				viewAllClients();

			}
		});
		btnNewButton.setBounds(10, 376, 349, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnViewAllOrders = new JButton("All Orders");
		btnViewAllOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshValue = 5;
				viewAllOrders();
			}
		});
		btnViewAllOrders.setBounds(646, 439, 114, 23);
		frame.getContentPane().add(btnViewAllOrders);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (refreshValue > 5) {
					JOptionPane.showMessageDialog(null, "Order Refresh");
					
				} else if(refreshValue == 5) {
					JOptionPane.showMessageDialog(null, "Both refresh");
				}else {
					JOptionPane.showMessageDialog(null, "Client refresh");
				}
			}
		});
		btnRefresh.setBounds(646, 411, 114, 23);
		frame.getContentPane().add(btnRefresh);
		
		JButton btnRemoveClient = new JButton("Remove Client");
		btnRemoveClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshValue = 4;
				clientRecordsServices.removeCLient(clientID.getText());
				viewAllClients();
			}

		});
		btnRemoveClient.setBounds(246, 344, 113, 23);
		frame.getContentPane().add(btnRemoveClient);
		
		JButton btnNewButton_5 = new JButton("Remove Order");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshValue = 9;
			}
		});
		btnNewButton_5.setBounds(646, 344, 113, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		Remark = new JTextField();
		Remark.setColumns(10);
		Remark.setBounds(550, 309, 209, 20);
		frame.getContentPane().add(Remark);
		
		JLabel label_7 = new JLabel("Remark");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_7.setBounds(417, 312, 113, 14);
		frame.getContentPane().add(label_7);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblColor.setBounds(417, 260, 113, 14);
		frame.getContentPane().add(lblColor);
		
		JComboBox cmbColor = new JComboBox();
		cmbColor.setBounds(550, 258, 209, 20);
		frame.getContentPane().add(cmbColor);
		
		JButton btnNewButton_6 = new JButton("Report Generate");
		btnNewButton_6.setBounds(646, 530, 113, 42);
		frame.getContentPane().add(btnNewButton_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 411, 626, 161);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JComboBox cmbProductType = new JComboBox();
		cmbProductType.setBounds(550, 83, 137, 20);
		frame.getContentPane().add(cmbProductType);
		
		textField = new JTextField();
		textField.setBounds(697, 81, 62, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{comboBox_2, textField_8, frame.getContentPane(), emailAddress, label, label_1, contactNumber, nicNo, label_2, label_3, companyName, lastName, label_4, label_5, firstName, clientID, label_6, address, btnQuichSearch, lblAddress, btnNewButton_1, btnSearchClient, txtOrderID, lblOrderId, lblOrderType, lblOrderDate, lblDayOfNeed, lblDayOfComplete, lblSuperviserId, btnNewButton_2, btnNewButton_3, btnNewButton_4, cmbSuperID, lblProductType, orderDate, orderDate.getCalendarButton(), dayOfNeed, dayOfNeed.getCalendarButton(), dayOfComplete, dayOfComplete.getCalendarButton(), lblAmount, lblAmount_1, quantity1, lblAvailability, lblTransportType, cmpTransport, lblRemark, Location, btnNewButton, btnViewAllOrders, btnRefresh, btnRemoveClient, btnNewButton_5, Remark, label_7, lblColor, cmbColor, btnNewButton_6}));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (refreshValue > 5) {
					tableSelectItemOrder();
					
				} else if(refreshValue == 5) {
					allOrderItems();
				}else {
					tableSelectItemClient();
				}
				
			}
		});
	}
}
