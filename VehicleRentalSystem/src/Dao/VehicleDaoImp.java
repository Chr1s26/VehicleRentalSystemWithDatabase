package Dao;

import Model.Car;
import Model.Cycle;
import Model.Vehicle;

public class VehicleDaoImp implements VehicleDao {
	
	private CarDao carDao;
	private CycleDao cycleDao;
	
	public VehicleDaoImp() {
		carDao = new CarDaoImp();
		cycleDao = new CycleDaoImp();
	}
	
	@Override
	public void createVehicle(Vehicle vehicle) {
	    if(vehicle instanceof Car) {
	        Car car = (Car) vehicle;
	        carDao.addCarModel(car);
	    }
	    else if (vehicle instanceof Cycle) {
	    	Cycle cycle = (Cycle) vehicle;
	    	cycleDao.addCycleModel(cycle);
	    }
	}

	

}
