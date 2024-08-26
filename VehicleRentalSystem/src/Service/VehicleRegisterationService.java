package Service;

import java.io.IOException;

import Dao.VehicleDao;
import Dao.VehicleDaoImp;
import Model.Vehicle;

public abstract class VehicleRegisterationService extends BaseService {
	
	private VehicleDao vehicleDao;
	
	public VehicleRegisterationService() {
		vehicleDao = new VehicleDaoImp();
	}

	public void addVehicle() throws IOException {
		System.out.println("Enter the model : ");
		String model = bufferedReader.readLine();
		System.out.println("Enter the license Number : ");
		String number = bufferedReader.readLine();
		System.out.println("Enter the price Per day : ");
		double price = Double.parseDouble(bufferedReader.readLine());
		Vehicle vehicle = this.getTypeInfo(model, number,price);
		vehicleDao.createVehicle(vehicle);
		}
	
	public abstract Vehicle getTypeInfo(String model,String number,double price) throws IOException;

}
