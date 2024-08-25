package Service;

import java.io.IOException;

import Model.Vehicle;

public abstract class VehicleRegisterationService extends BaseService {

	public void addVehicle() throws IOException {
		System.out.println("Enter the model : ");
		String model = bufferedReader.readLine();
		System.out.println("Enter the license Number : ");
		String number = bufferedReader.readLine();
		System.out.println("Enter the price Per day : ");
		double price = Double.parseDouble(bufferedReader.readLine());
		this.getTypeInfo(model, number,price);
		}
	
	public abstract void getTypeInfo(String model,String number,double price) throws IOException;

}
