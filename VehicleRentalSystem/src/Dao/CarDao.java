package Dao;

import java.util.List;

import Model.Car;
import Model.Customer;

public interface CarDao {

	void addCarModel(Car car);
	Car getCarModelByLicenseNumber(String name);
//	void deleteCarModelByLicenseNumber(String license);
	List<Car> getAllCars();

}
