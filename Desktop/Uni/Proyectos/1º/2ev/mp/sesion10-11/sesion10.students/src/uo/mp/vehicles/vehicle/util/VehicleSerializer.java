package uo.mp.vehicles.vehicle.util;


import java.util.LinkedList;
import java.util.List;

import uo.mp.vehicles.vehicle.Vehicle;

public class VehicleSerializer {

	public List<String> serialize(List<Vehicle> vehicles) {
		List<String> res = new LinkedList<>();
		for(Vehicle v: vehicles) {
			res.add( serialize( v )  );
		}
		return res;
	}

	private String serialize(Vehicle v) {
		return v.serialize();
	}

}
