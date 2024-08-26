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

public class CarDaoImp implements CarDao{
	
	private ConnectionFactory connectionFactory;
	
	public CarDaoImp() {
		this.connectionFactory = new MySQLConnectionFactory();
	}

	@Override
	public void addCarModel(Car car) {
		String sql = "INSERT INTO CARS (model,licenseNumber,rentalPrice,numOfSeats,isAvaliable) VALUES (?,?,?,?,?)";
		try(Connection connection = connectionFactory.createConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, car.getModel());
			preparedStatement.setString(2, car.getLicenseNumber());
			preparedStatement.setDouble(3, car.getRentalPrice());
			preparedStatement.setInt(4, car.getNumOfSeats());
			preparedStatement.setBoolean(5, car.isAvailable());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public Car getCarModelByLicenseNumber(String number) {
		String sql = "SELECT * FROM CARS WHERE licenseNumber = ?";
		Car car = null;
		try(Connection connection = connectionFactory.createConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, number);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				int id = resultSet.getInt("CarID");
				String model = resultSet.getString("model");
				String licenseNumber = resultSet.getString("licenseNumber");
				double rentalPrice = resultSet.getDouble("rentalPrice");
				int numOfSeats = resultSet.getInt("numOfSeats");
				boolean isAvailable = resultSet.getBoolean("isAvaliable");
				car = new Car(id,model, licenseNumber, rentalPrice,isAvailable,numOfSeats);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return car;
	}

	@Override
	public List<Car> getAllCars(){
		String sql = "SELECT * FROM CARS";
		List<Car> cars = new ArrayList<Car>();
		try(Connection connection = connectionFactory.createConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt("CarID");
				String model = resultSet.getString("model");
				String licenseNumber = resultSet.getString("licenseNumber");
				double rentalPrice = resultSet.getDouble("rentalPrice");
				int numOfSeats = resultSet.getInt("numOfSeats");
				boolean isAvailable = resultSet.getBoolean("isAvaliable");
				cars.add(new Car(id,model, licenseNumber, rentalPrice,isAvailable ,numOfSeats));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return cars;
	}
	
	@Override
	public int getCarCount() {
	    String sql = "SELECT COUNT(*) FROM CARS";
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

	

//	@Override
//	public void deleteCarModelByLicenseNumber(String license) {
//		
//		 for (int i = 0; i < Car.getCarCount(); i++) {
//	            if (cars[i] != null && cars[i].getLicenseNo().equalsIgnoreCase(license)) {
//	            	
//	                for (int j = i; j < Car.getCarCount() - 1; j++) {
//	                    cars[j] = cars[j + 1];}
//	                
//	                cars[Car.getCarCount() - 1] = null; 
//	                Car.setCarCount(Car.getCarCount() - 1);
//	                Rental.setCarRentalCount(Rental.getCarRentalCount()+1);
//	                break;}}
//	}
	
	


}
