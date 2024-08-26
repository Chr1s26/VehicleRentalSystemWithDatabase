package Service;

import java.io.IOException;

import Dao.CarDaoImp;
import Dao.CycleDao;
import Dao.CycleDaoImp;
import Model.Cycle;
import Model.Vehicle;

public class CycleRegisterationService extends VehicleRegisterationService {
	
private CycleDaoImp cycleDaoImp;
	
	public CycleRegisterationService() {
		cycleDaoImp = new CycleDaoImp();
	}

	@Override
	public Vehicle getTypeInfo(String model, String number, double price) throws IOException {
		Vehicle cycle = new Cycle(model, number, price, true);
		return cycle;
	}

	

}
