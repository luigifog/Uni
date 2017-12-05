package uo.mp.vehicles;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;

import uo.mp.util.Console;
import uo.mp.vehicles.parcel.InvalidFormatException;
import uo.mp.vehicles.parcel.ParcelDeliveryCompany;
import uo.mp.vehicles.ui.Menu;
import uo.mp.vehicles.ui.VehicleBuilder;
import uo.mp.vehicles.vehicle.Vehicle;

public class Main {
	private static final int EXIT = 0;

	private ParcelDeliveryCompany company = new ParcelDeliveryCompany();
	
	public static void main(String[] args) throws  IOException  {
		new Main().run();
	}

	private void run()  {
		Menu menu = new Menu();
		int option = EXIT;
		do {
			menu.show();
			try {
				option = menu.readOption();
			} catch (InvalidFormatException e) {
				System.out.println(e.getMessage());
			}
			processOption(option);
		} while (option != EXIT);
		
		Console.println("Execution finished");
	}

	private void processOption(int option) {
		switch( option ) {
			case EXIT: return;
			case 1: loadFile(); break;
			case 2: addVehicle(); break;
			case 3: removeVehicle(); break;
			case 4: saveToFile(); break;
			case 5: importFromZip(); break;
			case 6: exportToZip(); break;
			case 7: showVehiclesByBrand(); break;
			case 8: showVehiclesByAge(); break;
			case 9: computeTotalFleetTaxes(); break;
		}
	}

	private void computeTotalFleetTaxes() {
		Console.printf("Total amount of taxes: %.2f\n", company.getTotalRoadTax());
	}

	private void showVehiclesByAge() {
		List<Vehicle> sorted = company.getVehiclesByYear();
		listVehicles( sorted );
	}

	private void showVehiclesByBrand() {
		List<Vehicle> sorted = company.getVehiclesByBrand();
		listVehicles( sorted );
	}

	private void exportToZip() {
		String fileName = Console.readString("output file name?");
			try {
				company.saveToZipFile( fileName );
			}
			catch (IOException e) {
				System.out.println(e.getMessage());
			}
	}

	private void importFromZip()  {
		String fileName = Console.readString("input zip file name?");
		try {
			company.loadZipFile( fileName );
		} 
		catch (InvalidFormatException | IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private void saveToFile() {
		String fileName = Console.readString("output file name?");
		try {
			company.saveToFile( fileName );
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private void removeVehicle() {
		String plate = Console.readString("plate number?");
		try{
		company.removeVehicle( plate );
		}
		catch(IllegalArgumentException |IllegalStateException e)
		{
			System.out.println(e.getMessage());
			}
		
	}

	private void addVehicle() {
		Vehicle v = null;
		try {
			v = new VehicleBuilder().build();
		} catch (InvalidFormatException e1) {
			System.out.println(e1.getMessage());
		}
		try{
		company.addVehicle( v );
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
	}

	private void loadFile() {
		String fileName = Console.readString("File name?");
		try {
			company.loadFile( fileName );
		} 
		catch (InvalidFormatException | IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private void listVehicles(List<Vehicle> vehicles) {
		Console.println("\nList of vehicles");
		Console.println("------------------");
		for (Vehicle v: vehicles) {
			System.out.println( v );
		}
	}
	//	private void handleFNF(FileNotFoundException e)
//	{
//		new ConsoleLogger().log("bnombre del fichero no se encuentra en el programa"+ e.getMessage());
//	}

}
