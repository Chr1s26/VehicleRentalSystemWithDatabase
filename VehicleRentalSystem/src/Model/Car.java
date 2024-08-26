package Model;

public class Car extends Vehicle {
	
	private int numOfSeats;
	
	public Car(String model, String licenseNumber, double rentalPrice,boolean isAvailable,int numOfSeats) {
		super(model, licenseNumber, rentalPrice,isAvailable);
		this.numOfSeats = numOfSeats;
	}
	
	public Car(int id,String model, String licenseNumber, double rentalPrice,boolean isAvailable,int numOfSeats) {
		super(id,model, licenseNumber, rentalPrice,isAvailable);
		this.numOfSeats = numOfSeats;
	}

	public int getNumOfSeats() {
		return numOfSeats;
	}

	@Override
	public String toString() {
		return "Car"+super.toString() +" numOfSeats=" + numOfSeats + "]";
	}

}
