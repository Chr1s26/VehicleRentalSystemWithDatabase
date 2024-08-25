package Dao;

import Model.Car;
import Model.Cycle;
import Model.Vehicle;

public class VehicleDaoImp implements VehicleDao {
	
	public static Vehicle[] vehicles = new Vehicle[1000];
	
	static {
		System.out.println("*****Preparing DB*********");
		 vehicles[Vehicle.getCount()-1] = new Cycle("Mountain Bike", "LIC123", 15.5,true);
	     vehicles[Vehicle.getCount()-1] = new Cycle("Road Bike", "LIC456", 18.0,true);
	     vehicles[Vehicle.getCount()-1] = new Cycle("Hybrid Bike", "LIC789", 16.75,true);
	     vehicles[Vehicle.getCount()-1] = new Cycle("Electric Bike", "LIC101", 25.0,true);
	     vehicles[Vehicle.getCount()-1] = new Cycle("Folding Bike", "LIC202", 20.0,true);
	     vehicles[Vehicle.getCount()-1] = new Car("Sedan", "CAR123", 50.0,true,4);
	     vehicles[Vehicle.getCount()-1] = new Car("SUV", "CAR456", 75.0,true,8);
	     vehicles[Vehicle.getCount()-1] = new Car("Convertible", "CAR789", 85.0,true,2);
	     vehicles[Vehicle.getCount()-1] = new Car("Hatchback", "CAR101", 40.0,true,4);
         vehicles[Vehicle.getCount()-1] = new Car("Coupe", "CAR202", 60.0,true,4);
	}
	
	@Override
	public void createVehicle(Vehicle vehicle) {
		vehicles[Vehicle.getCount()-1] = vehicle;
	}
	

	@Override
	public void deleteVehicleById(int id) {
		for(int i = 0; i < Vehicle.getCount(); i++) {
			if(vehicles[i].getId() == id) {
				
				for (int j = i; j < Vehicle.getCount() - 1; j++) {
                    vehicles[j] = vehicles[j + 1];}
				
				vehicles[i] = null;
				Vehicle.setCount(Vehicle.getCount()-1);
			}
		}
	}
	

	@Override
	public Vehicle[] getVehicleByType(String Type) {
		Vehicle[] tempVehicle = new Vehicle[Vehicle.getCount()];
		int index = 0;
		
		for(int i = 0; i < Vehicle.getCount(); i++) {
			if(vehicles[i] != null && vehicles[i].getType().equalsIgnoreCase(Type)) {
				tempVehicle[index++] = vehicles[i];
			}
		}
		if(index > 0) {
		Vehicle[] typeVehicles = new Vehicle[index];
		System.arraycopy(tempVehicle, 0, typeVehicles, 0, index);
		return typeVehicles;}
		else {
			return null;
		}
	}

	
	@Override
	public Vehicle searchVehicleById(int id) {
		for(int i = 0; i < Vehicle.getCount();i++) {
			if(vehicles[i].getId() == id) {
				return vehicles[i];
			}
		}
		return null;
	
	}
	
	

	

}
