package Model;

public class Rental {

	private Car car;
	private Cycle cycle;
	private Customer customer;
	private double rentDays;
	private int rentalId;
	private double totalPrice;
	private static int rentCount = 0;
	
	public Rental(Car car,Customer customer,double rentDays,double totalPrice) {
		this.car = car;
		this.customer = customer;
		this.rentDays = rentDays;
		this.totalPrice = totalPrice;
	}
	
	public Rental(Cycle cycle,Customer customer,double rentDays,double totalPrice) {
		this.cycle = cycle;
		this.customer = customer;
		this.rentDays = rentDays;
		this.totalPrice = totalPrice;
	}

	
	public Rental() {
		rentCount++;
		this.rentalId = rentCount;
	}

	public static int getRentCount() {
		return rentCount;
	}

	public static void setRentCount(int rentCount) {
		Rental.rentCount = rentCount;
	}

	public int getRentalId() {
		return rentalId;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setRentDays(double rentDays) {
		this.rentDays = rentDays;
	}

	public double getRentDays() {
		return rentDays;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Customer getCustomer() {
		return customer;
	}


	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Cycle getCycle() {
		return cycle;
	}

	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}

}
