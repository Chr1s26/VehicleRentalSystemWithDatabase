package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Service.CarRegisterationService;
import Service.CarRentalService;
import Service.CustomerRegisterationService;
import Service.CycleRegisterationService;
import Service.CycleRentalService;
import Service.RentalService;
import Service.VehicleRegisterationService;
import Service.VehicleSaleReportService;

public class MainTest {

	public static void main(String[] args) throws IOException {
		
		CustomerRegisterationService customerService = new CustomerRegisterationService();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("----Welcome From Car and Motorcycle Rental System----");
		int number = 0;
		do {
			System.out.println("\n1.To register a customer");
			System.out.println("2.To register a car");
			System.out.println("3.To register a cycle");
			System.out.println("4.To rent Vehicle");
			System.out.println("5.To show Sale Report");
			System.out.println("6.Display Vehicle");
			System.out.println("7.Exit");
			number = Integer.parseInt(bufferedReader.readLine());
			
			switch (number) {
			case 1: customerService.createCustomer(); break;
			
			case 2: RegisterCar(); break;
			
			case 3 : RegisterCycle(); break;
			
			case 4: rentVehicles(); break;
			
			case 5: saleReport(); break;
			 
			case 6: showVehicle(); break;
				
			default:break;}
		}while(number != 7);
		
		System.out.println("Thank you for using the Car and Motorcycle Management System.GoodBye!");
	}
	
	public static void saleReport() throws IOException {
		VehicleSaleReportService vehicleSaleReportService = new CarRentalService();
		VehicleSaleReportService vehicleSaleReportService2 = new CycleRentalService();
		vehicleSaleReportService.displaySaleReport();
		vehicleSaleReportService2.displaySaleReport();
	}
	
	public static void rentVehicles() throws IOException {
		if(getType().equalsIgnoreCase("car")) {
			RentalService carRentalService = new CarRentalService();
			carRentalService.rentVehicle();
		}
		else {
			RentalService cycleRentalService = new CycleRentalService();
			cycleRentalService.rentVehicle();
		}
	}
	
	public static void RegisterCar() throws IOException {
		VehicleRegisterationService carRegisterationService = new CarRegisterationService();
		carRegisterationService.addVehicle();
	}
	
	public static void RegisterCycle() throws IOException {
		VehicleRegisterationService cycleRegisterationService = new CycleRegisterationService();
		cycleRegisterationService.addVehicle();
	}
	
	public static String getType() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the type that you want to rent");
		String type = bufferedReader.readLine();
		return type;
	}
	
	public static void showVehicle() throws IOException {
		RentalService rentalService;
		if(getType().equalsIgnoreCase("car")) {
		    rentalService = new CarRentalService();
			rentalService.DisplayVehicle();
		}
		else {
			rentalService = new CycleRentalService();
			rentalService.DisplayVehicle();
		}
	}


}
