package Model;

public class Cycle extends Vehicle {

	
	public Cycle(String model, String licenseNumber, double rentalPrice,boolean isAvailable) {
		super(model, licenseNumber, rentalPrice,isAvailable);
		}
	
	public Cycle(int id,String model, String licenseNumber, double rentalPrice,boolean isAvailable) {
		super(id,model, licenseNumber, rentalPrice,isAvailable);
	}

	@Override
	public String toString() {
		return "Cycle"+super.toString() + "]";
	}

	

}
