package uo.mp.uml.service.online;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import uo.mp.uml.data.HotelRepository;
import uo.mp.uml.model.Hotel;
import uo.mp.uml.model.Room;

public class CheckAvailability {

	private Date entryDate;
	private Date exitDate;
	private int pax;
	private String city;

	public CheckAvailability(String city, Date entryDate, Date exitDate, int pax) {
		this.city = city;
		this.entryDate = entryDate;
		this.exitDate = exitDate;
		this.pax = pax;
	}

	public List<Room> execute() {
		List<Room> rooms = new ArrayList<>();
		List<Hotel> hotels = HotelRepository.findByCity( city );
		for(Hotel h: hotels) {
			rooms.addAll( h.getAvailableRoomsFor(entryDate, exitDate, pax) );
		}
		return rooms;
	}

}
