package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import Database.ConnectionFactory;
import Database.MySQLConnectionFactory;
import Model.Customer;

public class CustomerDaoImp implements CustomerDao {
	
	private ConnectionFactory connectionFactory;
	
	public CustomerDaoImp() {
		this.connectionFactory = new MySQLConnectionFactory();
	}
	
	@Override
	public void createCustomer(Customer customer) {
		String sql = "INSERT INTO CUSTOMERS (name) VALUES (?)";
		try(Connection connection = connectionFactory.createConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

	@Override
	public Customer findCustomerByName(String name) {
		String sql = "SELECT * FROM CUSTOMERS WHERE NAME = ?";
		Customer customer = null;
		try(Connection connection = connectionFactory.createConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			ResultSet result= preparedStatement.executeQuery();
			if(result.next()) {
				int custid = result.getInt("id");
				String custName = result.getString("name");
				customer = new Customer(custid,custName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public List<Customer> getAllCustomer(){
		String sql = "SELECT * FROM CUSTOMERS ";
		List<Customer> customers = new ArrayList<Customer>();
		try(Connection connection = connectionFactory.createConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet result= preparedStatement.executeQuery();
			while(result.next()) {
				int custid = result.getInt("id");
				String custName = result.getString("name");
				customers.add(new Customer(custid,custName));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

}
