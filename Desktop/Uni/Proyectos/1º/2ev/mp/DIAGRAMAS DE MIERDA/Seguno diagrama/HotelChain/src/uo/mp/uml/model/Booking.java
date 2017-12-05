package uo.mp.uml.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Booking {

	private String locator;
	private Date entryDate;
	private Date exitDate; 
	private String creditCardNumber;
	private double discount;
	private Date creationDate; 
	private BookingStatus status;

	private Customer customer;
	private List<BookedRoom> bookedRooms;
	private List<BookedService> bookedServices;
	
	public Booking(String locator, Date entryDate, Date exitDate) {
		super();
		this.locator = locator;
		this.entryDate = entryDate;
		this.exitDate = exitDate;
		this.creationDate = new Date();
		this.status = BookingStatus.PRE_BOOKED;
		
		this.bookedRooms = new ArrayList<>();
		this.bookedServices = new ArrayList<>();
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getExitDate() {
		return exitDate;
	}

	public void setExitDate(Date exitDate) {
		this.exitDate = exitDate;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}

	public String getLocator() {
		return locator;
	}

	/**
	 * Checks if this booking has some days in the range of dates
	 *  
	 * @param entry
	 * @param exit
	 * @return
	 */
	public boolean isInDateRange(Date entry, Date exit) {
		return (entry.after(entryDate) && entry.before(exitDate))
			|| (exit.after(entryDate) && exit.before(exitDate));
	}

	public void noShow() {
		status = BookingStatus.NO_SHOW;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public List<BookedRoom> getBookedRooms() {
		return new ArrayList<>( bookedRooms );
	}

	public void preCancel() {
		freeRooms();
		status = BookingStatus.PRE_CANCELLED;
	}

	/**
	 * Removes the BookedRooms attached to this Booking so that the room 
	 * is available again in this date range 
	 */
	private void freeRooms() {
		for(BookedRoom br: bookedRooms) {
			br.getRoom().removeBooked( br );
		}
		bookedRooms.clear();
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void confirm() {
		status = BookingStatus.CONFIRMED;
	}

	public void cancel() {
		freeRooms();
		status = BookingStatus.CANCELLED;
	}
	
	public void addRoom(BookedRoom br) {
		bookedRooms.add( br );
	}

	public void removeRoom(BookedRoom br) {
		bookedRooms.remove( br );
	}

	public void addService(BookedService bs) {
		bookedServices.add( bs );
	}

	public void removeService(BookedService bs) {
		bookedServices.remove( bs );
	}

}
