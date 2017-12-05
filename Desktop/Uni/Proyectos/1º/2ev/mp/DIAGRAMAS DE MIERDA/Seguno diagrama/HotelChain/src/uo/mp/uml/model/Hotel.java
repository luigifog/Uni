package uo.mp.uml.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hotel {
	
	private String name;
	private String street;
	private String city;
	private String zipCode;
	private Double lat;
	private Double lon;
	private String phone;
	private String webSite;
	
	private List<Room> rooms = new ArrayList<>();
	private List<Service> services = new ArrayList<>();
	
	public Hotel(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public Double getLat() {
		return lat;
	}

	public Double getLon() {
		return lon;
	}

	public String getPhone() {
		return phone;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	/**
	 * Returns a list of rooms available for that range of dates and with the
	 * needed capacity
	 * 
	 * @param entryDate
	 * @param exitDate
	 * @param pax
	 * @return
	 */
	public List<Room> getAvailableRoomsFor(Date entryDate,
			Date exitDate, int pax) {
		
		List<Room> res = new ArrayList<>();
		for(Room r: rooms) {
			if ( r.getCapacity() < pax ) continue;  // continue --> check the next
			
			if ( r.isAvailable( entryDate, exitDate ) ) {
				res.add( r );
			}
		}
		return res;
	}

	public List<Room> getRooms() {
		return new ArrayList<>( rooms );
	}

	public List<Service> getServices() {
		return new ArrayList<>( services );
	}
	
	public void addRoom(Room room) {
		rooms.add( room );
	}
	
	public void removeRoom(Room room) {
		rooms.remove( room );
	}
}
