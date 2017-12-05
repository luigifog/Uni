package uo.mp.vehicles.parcel;


import java.util.ArrayList;
import java.util.List;

import uo.mp.vehicles.vehicle.Vehicle;


public class Fleet {
	private List<Vehicle> vehicles = new ArrayList<>();

	public List<Vehicle> getVehicledByBrand() {
		return vehicles;
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

	public void add(Vehicle v) throws ApplicationException,IllegalArgumentException {
		if(v==null){
			throw new IllegalArgumentException("parametro incorrecto");
		}
		if(searchByPlate(v.getPlate())==-1){
			throw new ApplicationException("error de matricula");
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
