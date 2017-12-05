package uo.mp.vehicles.parcel;


import java.util.ArrayList;
import java.util.List;

import collections.Sorter;
import uo.mp.vehicles.vehicle.Vehicle;
import uo.mp.vehicles.vehicle.util.BrandComparator;


public class Fleet {
	private List<Vehicle> vehicles = new ArrayList<>();

	public List<Vehicle> getVehicledByBrand() {
		Sorter sorter=new Sorter(new BrandComparator());
		return sorter.sort(vehicles);
	}

	public List<Vehicle> getVehicledByYear() {
		return vehicles;
	}

	public void add(List<Vehicle> newVehicles) {
		if(newVehicles==null){
			throw new IllegalArgumentException("parametro incorrecto");
		}
		for(Vehicle v: newVehicles) {
			this.vehicles.add( v );
		}
	}

	public void add(Vehicle v) {
		if(v==null){
			throw new IllegalArgumentException("parametro incorrecto");
		}
		vehicles.add( v );
	}

	public List<Vehicle> getVehicles() {
		return new ArrayList<Vehicle>( vehicles );
	}

	public void remove(String plate) {
		if(plate==null || plate.equals("")){
			throw new IllegalArgumentException("parametro incorrecto");
		}
		
		int pos = searchByPlate( plate );
		if(pos==-1){
			throw new IllegalStateException("no se puede hacer");
		}
		vehicles.remove(pos);
	}

	private int searchByPlate(String plate) {
		for(int i = 0; i < vehicles.size(); i++) {
			Vehicle v = vehicles.get(i);
			if ( v.getPlate().equals( plate ) ) {
				return i;
			}
		}
		return -1;
	}
}
