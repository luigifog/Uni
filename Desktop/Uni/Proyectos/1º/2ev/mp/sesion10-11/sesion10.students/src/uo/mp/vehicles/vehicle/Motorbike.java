package uo.mp.vehicles.vehicle;

public class Motorbike extends Vehicle {

	public Motorbike(String plate, int cc, int horsepower, int years, String brand) {
		super(plate, cc, horsepower, years, brand);
	}

	@Override
	public double getRoadTax() {
		return 30 + getCc() * 0.5 + 10 * getYears();
	}

	@Override
	public String toString() {
		return "Motorbike [getPlate()=" + getPlate() 
				+ ", getCc()=" + getCc() 
				+ ", getHorsepower()=" + getHorsepower()
				+ ", getYears()=" + getYears() 
				+ ", getBrand()=" + getBrand() 
			+ "]";
	}
	
	@Override
	public String serialize() {
		//throw new NotYetImplementedException();
		String cad="";
		cad+="Car\t"+getPlate()+"\t"+getCc()+"\t"+getHorsepower()+"\t"+getYears()+"\t"+getBrand();
		return cad;
	}


}
