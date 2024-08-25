package Model;

public class Cycle extends Vehicle {
	
	private int Cycleid;

	public Cycle(String model, String licenseNumber, double rentalPrice,boolean isAvailable) {
		super("cycle",model, licenseNumber, rentalPrice,isAvailable);
		
	}
	
	public Cycle(int id,String model, String licenseNumber, double rentalPrice) {
		super(model, licenseNumber, rentalPrice);
		this.Cycleid = id;
	}
	
	public Cycle(String model, String licenseNumber, double rentalPrice) {
		super(model, licenseNumber, rentalPrice);
	}

	public int getCycleid() {
		return Cycleid;
	}

	public void setCycleid(int cycleid) {
		Cycleid = cycleid;
	}

	@Override
	public String toString() {
		return "Cycle [ id = "+this.Cycleid+super.toString() + "]";
	}

	

}
