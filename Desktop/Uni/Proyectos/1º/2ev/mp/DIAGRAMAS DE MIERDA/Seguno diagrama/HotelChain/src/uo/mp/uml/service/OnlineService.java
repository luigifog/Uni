package uo.mp.uml.service;

import java.util.Date;
import java.util.List;

import uo.mp.uml.model.Customer;
import uo.mp.uml.model.Room;
import uo.mp.uml.service.online.BookRoom;
import uo.mp.uml.service.online.CancelBooking;
import uo.mp.uml.service.online.CheckAvailability;
import uo.mp.uml.service.online.PreBookRoom;

public class OnlineService {

	List<Room> checkAvailavilityFor(String city, Date entry, Date exit, int pax) {
		return new CheckAvailability(city, entry, exit, pax).execute();
	}
	
	String preBookRoom(Customer customer, Room room, Date entry, Date exit, int pax) {
		return new PreBookRoom(customer, room, entry, exit, pax).execute();
	}

	boolean bookRoom(String locator) {
		return new BookRoom( locator ).execute();
	}
	
	boolean cancelBooking(String locator) {
		return new CancelBooking( locator ).execute();
	}
	
}
