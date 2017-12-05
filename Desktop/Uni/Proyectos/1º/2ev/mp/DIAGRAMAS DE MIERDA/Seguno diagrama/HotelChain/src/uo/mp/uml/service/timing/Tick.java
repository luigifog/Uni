package uo.mp.uml.service.timing;

import java.util.Date;
import java.util.List;

import alb.util.date.DateUtil;
import uo.mp.uml.data.BookingRepository;
import uo.mp.uml.model.BookedRoom;
import uo.mp.uml.model.Booking;
import uo.mp.uml.model.Room;

public class Tick {

	public void execute() {
		Date now = new Date();
		
		clearStalePreBookings( now );
		precancelUnconfirmedBookings( now );
		markNoShownBookings( now );
		
	}

	/**
	 * Marks as NO_SHOW all the bookings whose entryDate is after the next day
	 * to the entry date at 00:00
	 * @param refDate
	 */
	private void markNoShownBookings(Date refDate) {
		Date refDateAt00 = DateUtil.trunc( refDate ); // refDate at 00:00
		Date noShownDate = DateUtil.addDays( refDateAt00, 1 );
		
		List<Booking> noShown = BookingRepository.findConfirmed();
		for(Booking b: noShown) {
			if ( b.getEntryDate().after( noShownDate )) {
				b.noShow();
			}
		}
	}

	/**
	 * Marks as PRE_CANCELLED all booking whose entry date is less then 2 days 
	 * from reference date 
	 * @param refDate
	 */
	private void precancelUnconfirmedBookings(Date refDate) {
		Date preCancelTime = DateUtil.addDays(refDate, 2);
		
		List<Booking> noShown = BookingRepository.findConfirmed();
		for(Booking b: noShown) {
			if ( b.getEntryDate().before( preCancelTime )) {
				b.preCancel();
			}
		}
	}

	/**
	 * Frees up all the PRE_BOOKED bookings 
	 * @param refDate
	 */
	private void clearStalePreBookings(Date refDate) {
		Date preCancelTime = DateUtil.addMinutes(refDate, 10);
		
		List<Booking> preBooked = BookingRepository.findPreBooked();
		for(Booking b: preBooked) {
			if ( b.getCreationDate().before( preCancelTime )) {
				deleteBooking( b );
			}
		}
	}

	private void deleteBooking(Booking b) {
		for(BookedRoom br: b.getBookedRooms() ) {
			Room r = br.getRoom();
			r.removeBooked( br );
		}
		BookingRepository.delete( b );
	}

}
