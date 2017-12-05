package uo.mp.uml.model;

/**
 * Represents a service booked in a Booking 
 * @author alb
 *
 */
public class BookedService {

	private Service service;
	private Booking booking;
	
	private int quantity;
	private double discount;
	
	public BookedService(Service service, Booking booking, int quantity,
			double discount) {
		super();
		this.service = service;
		this.booking = booking;
		this.quantity = quantity;
		this.discount = discount;
	}

	public Service getService() {
		return service;
	}

	public Booking getBooking() {
		return booking;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getDiscount() {
		return discount;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	
}
