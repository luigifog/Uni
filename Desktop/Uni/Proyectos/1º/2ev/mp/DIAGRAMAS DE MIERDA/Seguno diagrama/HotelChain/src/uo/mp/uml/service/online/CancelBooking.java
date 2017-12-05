package uo.mp.uml.service.online;

import uo.mp.uml.data.BookingRepository;
import uo.mp.uml.model.Booking;

public class CancelBooking {

	private String locator;

	public CancelBooking(String locator) {
		this.locator = locator;
	}

	public boolean execute() {
		Booking booking = BookingRepository.findByLocator(locator);
		if (booking == null) {
			return false;
		}
		
		booking.cancel();
		BookingRepository.update( booking );
		return true;
	}

}
