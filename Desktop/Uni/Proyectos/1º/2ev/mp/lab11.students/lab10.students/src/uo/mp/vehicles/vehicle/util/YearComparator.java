package uo.mp.vehicles.vehicle.util;

import java.util.Comparator;
import uo.mp.vehicles.vehicle.Vehicle;

public class YearComparator implements Comparator<Vehicle> {

	@Override
	public int compare(Vehicle o1, Vehicle o2) {
		return o1.getYears()-o2.getYears();
	}

}