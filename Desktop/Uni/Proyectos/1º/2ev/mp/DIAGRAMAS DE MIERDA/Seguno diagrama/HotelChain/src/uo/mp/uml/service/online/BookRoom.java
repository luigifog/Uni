package uo.mp.uml.service.online;

import uo.mp.uml.data.BookingRepository;
import uo.mp.uml.model.Booking;

public class BookRoom {

	private String locator;

	public BookRoom(String locator) {
		this.locator = locator;
	}

	public boolean execute() {
		Booking booking = BookingRepository.findByLocator(locator);
		if (booking == null) {
			return false;
		}
		
		booking.confirm();
		BookingRepository.update( booking );
		return true;
	}

}
