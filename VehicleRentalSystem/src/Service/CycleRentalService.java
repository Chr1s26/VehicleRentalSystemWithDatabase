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
		}}

	
	@Override
	public void selectVehicle() throws IOException {
		System.out.println("Select the vehicle by LicenseNumber : ");
		String number = bufferedReader.readLine();
		Vehicle cycle = cycleDao.getCycleModelByLicenseNumber(number);
		if(cycle.isAvailable()) {
		cycle.setAvailable(false);
		this.getRental().setVehicle(cycle);
		}else {
			System.out.println("This vehicle is not available please choose again");
			this.selectVehicle();
		}}
	
	
	@Override
	public void calculatetotalPrice() {
		double total = this.getRental().getVehicle().getRentalPrice() * this.getRental().getRentDays();
		this.getRental().setTotalPrice(total);
	}

	
	@Override
	public void displaySaleReport() throws IOException {
		System.out.printf("\nCycleRented : %d",rentalDao.getCycleRentalCount());
		System.out.printf("\nTotalCycleCounts : %d",cycleDao.getCycleCount());
		System.out.printf("\nRevenue from Cycles %.2f",totalCycleRevenue());
	}
	
	
	
	public double totalCycleRevenue() {
		double total = 0;
		List<Rental> rentalModel = rentalDao.getAllCycleRentals();
		for(Rental rental : rentalModel) {
				total += rental.getTotalPrice();}
		return total;}

}
