package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.ConnectionFactory;
import Database.MySQLConnectionFactory;
import Model.Car;
import Model.Rental;
import Model.Rental;

public class RentalDaoImp implements RentalDao {
	
	private ConnectionFactory connectionFactory;
	
	public RentalDaoImp() {
		this.connectionFactory = new MySQLConnectionFactory();
	}
	
	
	@Override
	public void rentVehicle(Rental rental) {
		this.createVehicle(rental);
	}
	
	
	public void createVehicle(Rental rental) {
		String sql = "";
		if(rental.getVehicle() instanceof Car) {
			 sql = "INSERT INTO carrentals (CarID,CustomerID,rentDays,totalPrice) VALUES (?,?,?,?)";}
		else {
			 sql = "INSERT INTO carrentals (CycleID,CustomerID,rentDays,totalPrice) VALUES (?,?,?,?)";
		}
			try(Connection connection = connectionFactory.createConnection()) {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, rental.getVehicle().getId());
				preparedStatement.setInt(2, rental.getCustomer().getId());
				preparedStatement.setDouble(3, rental.getRentDays());
				preparedStatement.setDouble(4, rental.getTotalPrice());
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
	
	
	@Override
	public int getCarRentalCount() {
	    String sql = "SELECT COUNT(*) FROM CARRENTALS";
	    int carCount = 0;

	    try (Connection connection = connectionFactory.createConnection()) {
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	        if (resultSet.next()) {
	            carCount = resultSet.getInt(1);  
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return carCount;
	}
	
	
	@Override
	public int getCycleRentalCount() {
	    String sql = "SELECT COUNT(*) FROM CYCLERENTALS";
	    int cycleCount = 0;

	    try (Connection connection = connectionFactory.createConnection()) {
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	        if (resultSet.next()) {
	            cycleCount = resultSet.getInt(1);  
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return cycleCount;
	}


	@Override
	public List<Rental> getAllCarRentals() {
		String sql = "SELECT * FROM CARRENTALS";
		List<Rental> rentals = new ArrayList<Rental>();
		try(Connection connection = connectionFactory.createConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				double rentdays = resultSet.getDouble("rentdays");
				double rentalPrice = resultSet.getDouble("totalPrice");
				rentals.add(new Rental(rentdays, rentalPrice));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rentals;
	}
	
	
	
	@Override
	public List<Rental> getAllCycleRentals() {
		String sql = "SELECT * FROM CYCLERENTALS";
		List<Rental> rentals = new ArrayList<Rental>();
		try(Connection connection = connectionFactory.createConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				double rentdays = resultSet.getDouble("rentdays");
				double rentalPrice = resultSet.getDouble("totalPrice");
				rentals.add(new Rental(rentdays, rentalPrice));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rentals;
	}

	
}
