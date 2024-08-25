package Service;

import java.io.IOException;
import java.util.List;

import Dao.CycleDao;
import Dao.CycleDaoImp;
import Dao.RentalDao;
import Dao.RentalDaoImp;
import Model.Cycle;
import Model.Cycle;
import Model.Rental;
import Model.Vehicle;

public class CycleRentalService extends RentalService  implements VehicleSaleReportService {

private RentalDao rentalDao;
private CycleDao cycleDao;
	
	public CycleRentalService() {
		rentalDao = new RentalDaoImp();
		cycleDao = new CycleDaoImp();
	}

	@Override
	public void DisplayVehicle() {
		System.out.println("Avaliable Cycles : ");
		List<Cycle> cycles = cycleDao.getAllCycles();
		for(Cycle CycleArray : cycles) {
			System.out.println(CycleArray);
		}
	}

	@Override
	public void selectVehicle() throws IOException {
		System.out.println("Select the vehicle by LicenseNumber : ");
		String number = bufferedReader.readLine();
		Cycle cycle = cycleDao.getCycleModelByLicenseNumber(number);
		if(cycle.isAvailable()) {
		cycle.setAvailable(false);
		this.getRental().setCycle(cycle);
		}else {
			System.out.println("This vehicle is not available please choose again");
			this.selectVehicle();
		}
	}
	
	@Override
	public void calculatetotalPrice() {
		double total = this.getRental().getCycle().getRentalPrice() * this.getRental().getRentDays();
		this.getRental().setTotalPrice(total);
	}

}
