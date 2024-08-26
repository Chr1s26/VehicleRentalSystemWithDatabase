package Service;

import java.io.IOException;

import Dao.CarDaoImp;
import Dao.CycleDao;
import Dao.CycleDaoImp;
import Model.Cycle;

public class CycleRegisterationService extends VehicleRegisterationService {
	
private CycleDaoImp cycleDaoImp;
	
	public CycleRegisterationService() {
		cycleDaoImp = new CycleDaoImp();
	}

	@Override
	public void getTypeInfo(String model, String number, double price) throws IOException {
		Cycle cycle = new Cycle(model, number, price);
		cycleDaoImp.addCycleModel(cycle);
	}

	

}
