package Service;

import java.io.IOException;

import Dao.CarDaoImp;
import Model.Car;
import Model.Vehicle;

public class CarRegisterationService extends VehicleRegisterationService{

private CarDaoImp carDaoImp;
	
	public CarRegisterationService() {
		carDaoImp = new CarDaoImp();
	}
		
	
	@Override
	public void getTypeInfo(String model,String number,double price) throws IOException {
		System.out.println("Enter the number of seats : ");
		int seats = Integer.parseInt(bufferedReader.readLine());
		Car car = new Car(model,number,price, seats);
		carDaoImp.addCarModel(car);
		}
	
}
