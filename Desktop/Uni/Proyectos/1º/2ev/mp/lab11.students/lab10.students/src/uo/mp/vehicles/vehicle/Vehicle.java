package uo.mp.vehicles.vehicle;

public abstract class Vehicle {
	private String plate;
	private int cc;
	private int horsepower;
	private int years;
	private String brand;

	public Vehicle(String plate, int cc, int horsepower, int years, String brand) {
		super();
		this.plate = plate;
		this.cc = cc;
		this.horsepower = horsepower;
		this.years = years;
		this.brand = brand;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((plate == null) ? 0 : plate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (plate == null) {
			if (other.plate != null)
				return false;
		} else if (!plate.equals(other.plate))
			return false;
		return true;
	}

	public String getPlate() {
		return plate;
	}

	public int getCc() {
		return cc;
	}

	public int getHorsepower() {
		return horsepower;
	}

	public int getYears() {
		return years;
	}

	public String getBrand() {
		return brand;
	}

	public abstract double getRoadTax();

	public abstract String serialize();

	public int compareTo(Vehicle v) {
		assertNotNull(v);
		return this.getPlate().compareTo(v.getPlate());
	}
	public void assertNotNull(Vehicle v){
		if(v==null)
			throw new IllegalArgumentException("vehiculo nulo");
	}

}
