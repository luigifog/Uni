package uo.mp.uml.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Room {
	
	private int floor;
	private int door;
	private int capacity;
	private double basePrice;
	
	private List<BookedRoom> bookedRooms;
	
	public Room(int floor, int door) {
		super();
		this.floor = floor;
		this.door = door;
		this.bookedRooms = new ArrayList<>();
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public int getFloor() {
		return floor;
	}

	public int getDoor() {
		return door;
	}

	/**
	 * A room is available in a range of dates if it has none BookedRoom object
	 * in that range
	 * 
	 * @param entryDate
	 * @param exitDate
	 * @return
	 */
	public boolean isAvailable(Date entryDate, Date exitDate) {
		for(BookedRoom br: bookedRooms) {
			if ( br.isInDateRange( entryDate, exitDate )) {
				return false;
			}
		}
		return true;
	}

	public void removeBooked(BookedRoom br) {
		bookedRooms.remove( br );
	}

	public void addBooked(BookedRoom br) {
		bookedRooms.add( br );
	}

}
