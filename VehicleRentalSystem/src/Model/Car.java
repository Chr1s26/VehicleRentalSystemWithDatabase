package Model;

public class Car extends Vehicle {
	
	private int numOfSeats;
	private int Carid;
	
	public Car(String model, String licenseNumber, double rentalPrice,boolean isAvailable,int numOfSeats) {
		super("car",model, licenseNumber, rentalPrice,isAvailable);
		this.numOfSeats = numOfSeats;
	}
	
	public Car(int id,String model, String licenseNumber, double rentalPrice,int numOfSeats) {
		super(model, licenseNumber, rentalPrice);
		this.numOfSeats = numOfSeats;
		this.Carid = id;
	}
	
	public Car(String model, String licenseNumber, double rentalPrice,int numOfSeats) {
		super(model, licenseNumber, rentalPrice);
		this.numOfSeats = numOfSeats;
	}

	public int getNumOfSeats() {
		return numOfSeats;
	}

	public int getCarid() {
		return Carid;
	}

	public void setCarid(int carid) {
		Carid = carid;
	}

	@Override
	public String toString() {
		return "Car [ id = "+this.Carid+super.toString() +" numOfSeats=" + numOfSeats + "]";
	}

}
