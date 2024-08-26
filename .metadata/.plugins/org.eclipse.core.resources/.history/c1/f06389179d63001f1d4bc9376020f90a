package Service;

import java.io.IOException;

import Dao.CustomerDao;
import Dao.CustomerDaoImp;
import Model.Customer;

public class CustomerRegisterationService extends BaseService {

	   private final CustomerDao customerDao;

	    public CustomerRegisterationService() {
	        this.customerDao = new CustomerDaoImp();
	    }

	    public void createCustomer() throws IOException {
	        do {
	            Customer customer = getCustomerInfo();
	            customerDao.createCustomer(customer);
	        } while (wantsToAddAnotherCustomer());
	    }

	    private Customer getCustomerInfo() throws IOException {
	        System.out.print("Enter Customer Name: ");
	        String name = bufferedReader.readLine();
	        return new Customer(name);
	    }

	    private boolean wantsToAddAnotherCustomer() throws IOException {
	        System.out.print("Want to add another customer? (yes/no): ");
	        String response = bufferedReader.readLine();
	        return response.equalsIgnoreCase("yes");
	    }

}
