package uo.mp.vehicles.vehicle;

public class Truck extends Vehicle {
	private int numberOfAxles;
	private int tare;
	
	public Truck(String plate, int cc, int horsepower, int years, 
			String brand, int numberOfAxles, int tare) {
		super(plate, cc, horsepower, years, brand);
		this.numberOfAxles = numberOfAxles;
		this.tare = tare;
	}

	public int getNumberOfAxles() {
		return numberOfAxles;
	}

	public int getTare() {
		return tare;
	}

	@Override
	public String toString() {
		return "Truck [getPlate()=" + getPlate() 
				+ ", getCc()=" + getCc() 
				+ ", getHorsepower()=" + getHorsepower()
				+ ", getYears()=" + getYears() 
				+ ", getBrand()=" + getBrand() 
				+ ", getNumberOfAxles()=" + getNumberOfAxles() 
				+ ", getTare()=" + getTare() 
			+ "]";
	}

	@Override
	public double getRoadTax() {
		return 100 + numberOfAxles * 10 + getYears() * 20 + getCc() / 6;
	}

	@Override
	public String serialize() {
		//throw new NotYetImplementedException();
		String cad="";
		cad+="Car\t"+getPlate()+"\t"+getCc()+"\t"+getHorsepower()+"\t"+getYears()+"\t"+getBrand()+"\t"+getNumberOfAxles()+"\t"+getTare();
		return cad;
	}

}
