package uo.mp.vehicles.vehicle.util;


import java.util.LinkedList;
import java.util.List;

import uo.mp.util.ConsoleLogger;
import uo.mp.util.Logger;
import uo.mp.vehicles.file.InvalidFormatException;
import uo.mp.vehicles.vehicle.Car;
import uo.mp.vehicles.vehicle.Motorbike;
import uo.mp.vehicles.vehicle.Truck;
import uo.mp.vehicles.vehicle.Vehicle;

public class VehicleParser {
	private Logger logger = new ConsoleLogger();

	public List<Vehicle> parse(List<String> lines) throws InvalidFormatException {
		//throw new NotYetImplementedException();
		List<Vehicle>res=new LinkedList<>();
		for (int ln = 0; ln < lines.size(); ln++) {
			String line=lines.get(ln);
			Vehicle v=parseLine(line);
			res.add(v);
		}
		return res; 
	}
	private Vehicle parseLine(String line) throws InvalidFormatException{
		String[]parts=line.split("\t");
		Vehicle v= createVehicle(parts);
		return v;
	}
	private Vehicle createVehicle(String[] parts) throws InvalidFormatException {
		String type=parts[0];
		Vehicle v=null;
		if(type.equals("car")){
			v= createNewCar(parts);
		}
		else if(type.equals("motorbike")){
			v= createNewMotorbike(parts);
		}
		else if(type.equals("truck")){
			v= createNewTruck(parts);
		}
		else{
			throw new InvalidFormatException(type +"no es un tipo valido");
		}
		return v;
	}
	private Vehicle createNewTruck(String[] parts) throws InvalidFormatException {
		String plate=parts[1];
		int cc=toInteger(parts[2]);
		int horsepower=toInteger(parts[3]);
		int years=toInteger(parts[4]);
		String brand=parts[5];
		int numberOfAxles=toInteger(parts[6]);
		int tare=toInteger(parts[7]);
		return new Truck(plate,cc,horsepower,years,brand,numberOfAxles,tare);
	}
	private Vehicle createNewMotorbike(String[] parts) throws InvalidFormatException {
		String plate=parts[1];
		int cc=toInteger(parts[2]);
		int horsepower=toInteger(parts[3]);
		int years=toInteger(parts[4]);
		String brand=parts[5];
		return new Motorbike(plate,cc,horsepower,years,brand);
	}
	private Vehicle createNewCar(String[] parts) throws InvalidFormatException {
		String plate=parts[1];
		int cc=toInteger(parts[2]);
		int hp=toInteger(parts[3]);
		int years=toInteger(parts[4]);
		String brand=parts[5];
		return new Car(plate,cc,hp,years,brand);
	}
	private int toInteger(String string) throws InvalidFormatException{
		try{
			return Integer.parseInt(string);
		}
		catch(NumberFormatException e){
			throw new InvalidFormatException(e.getMessage());
		}
	}
}
