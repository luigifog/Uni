package uo.mp.uml.service.online;

import java.util.Date;

import uo.mp.uml.data.BookingRepository;
import uo.mp.uml.model.BookedRoom;
import uo.mp.uml.model.Booking;
import uo.mp.uml.model.Customer;
import uo.mp.uml.model.Room;

public class PreBookRoom {

	private Customer customer;
	private Room room;
	private Date entry;
	private Date exit;
	private int pax;

	public PreBookRoom(Customer customer, Room room, Date entry, Date exit, int pax) {
		this.customer = customer;
		this.room = room;
		this.entry = entry;
		this.exit = exit;
		this.pax = pax;
	}

	public String execute() {
		if ( ! room.isAvailable(entry, exit) ) {
			return null;
		}
		if ( room.getCapacity() < pax ) {
			return null;
		}
		
		String locator = BookingRepository.newLocator();
		Booking booking = new Booking( locator, entry, exit );
		booking.setCustomer( customer );
		
		BookedRoom br = new BookedRoom( room, booking );
		
		BookingRepository.save( br );
		BookingRepository.save( booking  );
		
		return locator;
	}

}
