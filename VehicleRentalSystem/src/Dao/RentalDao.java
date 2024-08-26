package Dao;

import java.util.List;

import Model.Rental;

public interface RentalDao {

	void rentVehicle(Rental rental);
	int getCarRentalCount();
	int getCycleRentalCount();
	List<Rental> getAllCarRentals();
	List<Rental> getAllCycleRentals();

}
