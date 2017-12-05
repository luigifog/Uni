package taller;

import java.io.PrintStream;

public class Moto extends Vehiculos implements Encerar{
	public static enum Tamaño {Grande, Pequeña}
	private final static int TARIFA_BASE=1000;
	
	private  Tamaño tamaño;
	
	
	public Moto(String mat, boolean reparado)
	{
		super(mat,reparado);
	}

	public Tamaño getTamaño() {
		return tamaño;
	}

	public void setTamaño(Tamaño tamaño) {
		this.tamaño = tamaño;
	}
	
		
	public String toString(){
		String cad=super.toString();

		if (getTamaño() == Tamaño.Grande)
			cad += " Tamaño: Grande";
		else
			cad += " Tamaño: Pequeño";
	
		return cad;
	}
	
	public String encerar()
	{
		return("Enecerando moto" + getMatricula());
	}
	
	public double generateBill()
	{
		double tarifa;
		if(getTamaño()==Tamaño.Grande)
		{
			tarifa=TARIFA_BASE*0.5;
		}
		else
		{
			tarifa=TARIFA_BASE*0.25;
		}
		
		return tarifa;
	}
	
	public void reparar(PrintStream out)
	{
		setReparado(true);
		out.println("Factura: "+generateBill());
	}
	
}
