package uo.mp.vehicles.parcel;


import java.io.IOException;
import java.util.List;

import uo.mp.vehicles.file.FileUtil;
import uo.mp.vehicles.file.InvalidFormatException;
import uo.mp.vehicles.file.ZipFileUtil;
import uo.mp.vehicles.vehicle.Vehicle;
import uo.mp.vehicles.vehicle.util.VehicleParser;
import uo.mp.vehicles.vehicle.util.VehicleSerializer;

public class ParcelDeliveryCompany {
	private Fleet fleet = new Fleet();

	public List<Vehicle> getVehiclesByBrand() {
		return fleet.getVehicledByBrand();
	}

	public List<Vehicle> getVehiclesByYear() {
		return fleet.getVehicledByYear();
	}

	public void loadFile(String inFileName) throws InvalidFormatException, IOException,IllegalArgumentException {
		List<String> lines = new FileUtil().loadFile( inFileName );
		List<Vehicle> vehicles = new VehicleParser().parse( lines );
		fleet.add( vehicles );
	}

	public void loadZipFile(String inZippedFileName) throws InvalidFormatException, IOException {
		List<String> lines = new ZipFileUtil().loadFile( inZippedFileName );
		List<Vehicle> vehicles = new VehicleParser().parse( lines );
		fleet.add( vehicles );
	}

	public void saveToFile(String outFileName) throws IOException {
		List<Vehicle> vehicles = fleet.getVehicledByYear();
		List<String> lines = new VehicleSerializer().serialize( vehicles );
		new FileUtil().saveToFile( outFileName, lines );
	}

	public void saveToZipFile(String outZippedFileName) throws IOException {
		List<Vehicle> vehicles = fleet.getVehicledByYear();
		List<String> lines = new VehicleSerializer().serialize( vehicles );
		new ZipFileUtil().saveToFile( outZippedFileName, lines );
	}

	public double getTotalRoadTax() {
		double total = 0.0;
		List<Vehicle> vehicles = fleet.getVehicles();
		for(int i = 0; i < vehicles.size(); i++) {
			Vehicle v = (Vehicle) vehicles.get(i); 
			total += v.getRoadTax();
		}
		return total;
	}

	public List<Vehicle> getVehicles() {
		return fleet.getVehicles();
	}

	public void removeVehicle(String plate) {
		fleet.remove( plate );
	}

	public void addVehicle(Vehicle v) throws ApplicationException {
		fleet.add( v );
	}

}
