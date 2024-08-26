package Model;

public class Vehicle {

	private int id;
	private String model;
	private String licenseNumber;
	private double rentalPrice;
	private String type;
	private boolean isAvailable = true;
	private static int count = 1;
	
	public Vehicle(String type,String model,String licenseNumber,double rentalPrice,boolean isAvailable) {
		this.type = type;
		this.model = model;
		this.licenseNumber = licenseNumber;
		this.rentalPrice = rentalPrice;
		this.isAvailable = true;
	}
	
	public Vehicle(String model,String licenseNumber,double rentalPrice) {
		this.model = model;
		this.licenseNumber = licenseNumber;
		this.rentalPrice = rentalPrice;
	}

	public static int getCount() {
		return count;
	}

	public int getId() {
		return id;
	}

	public static void setCount(int count) {
		Vehicle.count = count;
	}

	public String getType() {
		return type;
	}

	public String getModel() {
		return model;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public double getRentalPrice() {
		return rentalPrice;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return ", model=" + model + ", licenseNumber=" + licenseNumber + ", rentalPrice="
				+ rentalPrice ;
	}
	
	
	
}
