package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.ConnectionFactory;
import Database.MySQLConnectionFactory;
import Model.Cycle;
import Model.Cycle;

public class CycleDaoImp implements CycleDao {
	
	private ConnectionFactory connectionFactory;
	
	
	public CycleDaoImp() {
		connectionFactory = new MySQLConnectionFactory();
	}

	
	
	@Override
	public void addCycleModel(Cycle cycle) {
		String sql = "INSERT INTO Cycles (model,licenseNumber,rentalPrice,isAvailable) VALUES (?,?,?,?)";
		try(Connection connection = connectionFactory.createConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cycle.getModel());
			preparedStatement.setString(2, cycle.getLicenseNumber());
			preparedStatement.setDouble(3, cycle.getRentalPrice());
			preparedStatement.setBoolean(4, cycle.isAvailable());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	@Override
	public Cycle getCycleModelByLicenseNumber(String number) {
		String sql = "SELECT * FROM Cycles WHERE licenseNumber = ?";
		Cycle cycle = null;
		try(Connection connection = connectionFactory.createConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, number);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				int id = resultSet.getInt("CycleID");
				String model = resultSet.getString("model");
				String licenseNumber = resultSet.getString("licenseNumber");
				double rentalPrice = resultSet.getDouble("rentalPrice");
				boolean isAvailable = resultSet.getBoolean("isAvailable");
				cycle = new Cycle(id,model, licenseNumber, rentalPrice,isAvailable);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cycle;
	}

	
	
	@Override
	public List<Cycle> getAllCycles() {
		String sql = "SELECT * FROM Cycles";
		List<Cycle> cycles = new ArrayList<Cycle>();
		try(Connection connection = connectionFactory.createConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt("CycleID");
				String model = resultSet.getString("model");
				String licenseNumber = resultSet.getString("licenseNumber");
				double rentalPrice = resultSet.getDouble("rentalPrice");
				boolean isAvailable = resultSet.getBoolean("isAvailable");
				cycles.add(new Cycle(id,model, licenseNumber, rentalPrice,isAvailable));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return cycles;
	}
	
	@Override
	public int getCycleCount() {
	    String sql = "SELECT COUNT(*) FROM CYCLES";
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


}
