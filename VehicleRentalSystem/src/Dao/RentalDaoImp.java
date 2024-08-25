package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.ConnectionFactory;
import Database.MySQLConnectionFactory;
import Model.Rental;
import Model.Rental;

public class RentalDaoImp implements RentalDao {
	
	private ConnectionFactory connectionFactory;
	
	public RentalDaoImp() {
		this.connectionFactory = new MySQLConnectionFactory();
	}
	
	@Override
	public void create(Rental rental,String type) {
		if(type.equalsIgnoreCase("car")) {
		this.createCar(rental);}
		else {
		this.createCycle(rental);
		}
	}
	
	public void createCar(Rental rental) {
			String sql = "INSERT INTO carrentals (CarID,CustomerID,rentDays,totalPrice) VALUES (?,?,?,?)";
			try(Connection connection = connectionFactory.createConnection()) {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, rental.getCar().getCarid());
				preparedStatement.setInt(2, rental.getCustomer().getId());
				preparedStatement.setDouble(3, rental.getRentDays());
				preparedStatement.setDouble(4, rental.getTotalPrice());
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
	
	public void createCycle(Rental rental) {
		String sql = "INSERT INTO carrentals (CycleID,CustomerID,rentDays,totalPrice) VALUES (?,?,?,?)";
		try(Connection connection = connectionFactory.createConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, rental.getCycle().getCycleid());
			preparedStatement.setInt(2, rental.getCustomer().getId());
			preparedStatement.setDouble(3, rental.getRentDays());
			preparedStatement.setDouble(4, rental.getTotalPrice());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


//	@Override
//	public List<Rental> getAllRentals() {
//		String sql = "SELECT * FROM CARS";
//		List<Rental> vehicles = new ArrayList<Rental>();
//		try(Connection connection = connectionFactory.createConnection()){
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			while(resultSet.next()) {
//				double rentdays = resultSet.getDouble("rentdays");
//				double rentalPrice = resultSet.getDouble("rentalPrice");
//				vehicles.add(new Rental(model, licenseNumber, rentalPrice, numOfSeats));
//			}
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return vehicles;
//	}

	
}
