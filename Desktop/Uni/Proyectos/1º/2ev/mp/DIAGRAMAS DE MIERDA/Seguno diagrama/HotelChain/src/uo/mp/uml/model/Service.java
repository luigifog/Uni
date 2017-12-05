package uo.mp.uml.model;

public class Service {

	private String name;
	private String description;
	private double basePrice;
	
	public Service(String name) {
		super();
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public String getName() {
		return name;
	}
	
	
}
