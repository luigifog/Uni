package uo.mp.uml.model;

import java.util.Date;

public class BookedRoom {
	
	private Room room;
	private Booking booking;
	
	private double discount;
	private int occupancy;
	
	public BookedRoom(Room room, Booking booking) {
		super();
		this.room = room;
		this.booking = booking;
		room.addBooked( this );
		booking.addRoom( this );
	}

	public BookedRoom(Room room, Booking booking, double discount,
			int occupancy) {
		this( room, booking );
		this.discount = discount;
		this.occupancy = occupancy;
	}

	public Room getRoom() {
		return room;
	}

	public Booking getBooking() {
		return booking;
	}

	public double getDiscount() {
		return discount;
	}

	public int getOccupancy() {
		return occupancy;
	}

	/**
	 * Check whether the booking for the room has some days in the range of dates
	 * 
	 * @param entryDate
	 * @param exitDate
	 * @return
	 */
	public boolean isInDateRange(Date entryDate, Date exitDate) {
		return booking.isInDateRange( entryDate, exitDate );
	}
	
	
}
