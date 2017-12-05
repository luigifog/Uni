package taller;

import java.io.PrintStream;



public class Camion extends Vehiculos {
	private int tonelaje;
	private final static int TARIFA_BASE=1000;


	public Camion(String mat, boolean reparado, int tonelaje)
	{
		super(mat,reparado);
		setTonelaje(tonelaje);
	}
	
	

	public int getTonelaje() {
		return tonelaje;
	}

	public void setTonelaje(int tonelaje) {
		this.tonelaje = tonelaje;
	}
	
	public String toString()
	{
		String cad=super.toString();
		
		cad+="Tonelaje: "+getTonelaje();
		
		
		return cad;
	}
	
	public double generateBill()
	{
		int factura;
		factura=TARIFA_BASE*(getTonelaje()/10);
		return factura;
	}
	
	public void reparar(PrintStream out)
	{
		setReparado(true);
		out.println("Factura: "+generateBill());
	}
	


}
