package uo.mp.vehicles.ui;

import java.util.InputMismatchException;

import uo.mp.util.Console;
import uo.mp.vehicles.parcel.InvalidFormatException;
import uo.mp.vehicles.vehicle.Car;
import uo.mp.vehicles.vehicle.Motorbike;
import uo.mp.vehicles.vehicle.Truck;
import uo.mp.vehicles.vehicle.Vehicle;
import uo.mp.vehicles.vehicle.util.VehicleParser;

public class VehicleBuilder {

	public Vehicle build() throws  InvalidFormatException {
		String type = Console.readString("Type of vehicle? (car | truck | moto)");
		switch( type ) {
			case "car": return buildCar();
			case "truck": return buildTruck();
			case "moto": return buildMoto();
		}
		return null;
	}

	private Vehicle buildMoto() throws InvalidFormatException {
		String plate = askForPlate();
		int cc = askForCC();
		int hp = askForHp();
		int years = askForYears();
		String brand = askForBrand();

		return new Motorbike(plate, cc, hp, years, brand);
	}

	private Vehicle buildTruck() throws InvalidFormatException {
		String plate = askForPlate();
		int cc = askForCC();
		int hp = askForHp();
		int years = askForYears();
		String brand = askForBrand();
		int axles = askForAxles();
		int tare = askForTare();

		return new Truck(plate, cc, hp, years, brand, axles, tare);
	}

	private Vehicle buildCar() throws IllegalArgumentException, InvalidFormatException{
		String plate = askForPlate();
		int cc = askForCC();
		int hp = askForHp();
		int years = askForYears();
		String brand = askForBrand();

		return new Car(plate, cc, hp, years, brand);
	}

	private String askForBrand() {
		return askForString("Brand?");
	}

	private int askForYears() throws InvalidFormatException {
		return askForAnInteger("Age in years?");
	}

	private int askForHp() throws InvalidFormatException {
		return askForAnInteger("Horse power?");
	}

	private int askForCC() throws InvalidFormatException {
		return askForAnInteger("Cubic centimeters?");
	}

	private String askForPlate() {
		return askForString("Plate number?");
	}

	private int askForTare() throws InvalidFormatException {
		return askForAnInteger("Tare?");
	}

	private int askForAxles() throws InvalidFormatException {
		return askForAnInteger("Number of axles?");
	}

	private int askForAnInteger(String prompt)throws InvalidFormatException {
		return Console.readInteger( prompt );
	}

	private String askForString(String prompt) {
		return Console.readString( prompt );
	}

}
