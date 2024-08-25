package Service;

import java.io.IOException;
import java.util.List;

import Dao.CarDao;
import Dao.CarDaoImp;
import Dao.RentalDao;
import Dao.RentalDaoImp;
import Model.Car;
import Model.Rental;
import Model.Vehicle;

public class CarRentalService extends RentalService implements VehicleSaleReportService {
	
private RentalDao rentalDao;
private CarDao carDao;
	
	public CarRentalService() {
		rentalDao = new RentalDaoImp();
		carDao = new CarDaoImp();
	}

	@Override
	public void DisplayVehicle() {
		System.out.println("Avaliable Cars : ");
		List<Car> cars = carDao.getAllCars();
		for(Car carArray : cars) {
			System.out.println(carArray);
		}
	}



	@Override
	public void selectVehicle() throws IOException {
		System.out.println("Select the vehicle by LicenseNumber : ");
		String number = bufferedReader.readLine();
		Car car = carDao.getCarModelByLicenseNumber(number);
		if(car.isAvailable()) {
		car.setAvailable(false);
		this.getRental().setCar(car);
		}else {
			System.out.println("This vehicle is not available please choose again");
			this.selectVehicle();
		}
	}

	@Override
	public void calculatetotalPrice() {
		double total = this.getRental().getCar().getRentalPrice() * this.getRental().getRentDays();
		this.getRental().setTotalPrice(total);
	}

	
	}


