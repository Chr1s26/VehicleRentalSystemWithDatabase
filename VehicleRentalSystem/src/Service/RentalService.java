package Service;

import java.io.IOException;
import java.util.List;

import Dao.CustomerDao;
import Dao.CustomerDaoImp;
import Dao.RentalDao;
import Dao.RentalDaoImp;
import Dao.VehicleDao;
import Dao.VehicleDaoImp;
import Model.Customer;
import Model.Rental;
import Model.Vehicle;

public abstract class RentalService extends BaseService {
	
	private VehicleDao vehicleDao;
	private CustomerDao customerDao;
	private RentalDao rentalDao;
	private Rental rental;
	   
	public RentalService() {
		vehicleDao = new VehicleDaoImp();
		customerDao = new CustomerDaoImp();
		rentalDao = new RentalDaoImp();
	}

	public void rentVehicle(String type) throws IOException {
		rental = new Rental();
		this.displayCustomer();
		this.selectCustomer();
		this.DisplayVehicle();
		this.selectVehicle();
		this.selectRentInfo();
		
		this.rentalDao.create(rental,type);
		System.out.println("do you want to rent another vehicle");
		
		String flag = bufferedReader.readLine();
			if(flag.equalsIgnoreCase("Yes")) {
				this.rentVehicle(type);
			}
		}
		
	public void displayCustomer() {
		List<Customer> customers = customerDao.getAllCustomer();
		for(Customer customer: customers) {
			System.out.println(customer);}
		}
	
	
	public void selectCustomer() throws IOException {
		System.out.println("Enter the customer name : ");
		String name = bufferedReader.readLine();
		Customer customer = this.customerDao.findCustomerByName(name);
		
		 if (customer != null) {
		        this.rental.setCustomer(customer);
		    } else {
		        System.out.println("Customer not found.");
		        this.selectCustomer();
		    }
	}
	
	public abstract void DisplayVehicle();
	
	public abstract void selectVehicle () throws IOException;
	
	public void selectRentInfo() throws IOException{
		System.out.println("Enter the number of days you want to rent");
		double rentdays = Double.parseDouble(bufferedReader.readLine());
		this.rental.setRentDays(rentdays);
		this.calculatetotalPrice();
	}
	
	public abstract void calculatetotalPrice();

	public Rental getRental() {
		return rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}

}
