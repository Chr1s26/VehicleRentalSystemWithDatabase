package Dao;

import java.util.List;

import Model.Car;
import Model.Customer;

public interface CarDao {

	void addCarModel(Car car);
	Car getCarModelByLicenseNumber(String name);
	List<Car> getAllCars();
	int getCarCount();

}
