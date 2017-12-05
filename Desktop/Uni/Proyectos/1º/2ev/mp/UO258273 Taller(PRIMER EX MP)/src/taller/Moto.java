package taller;

import java.io.PrintStream;

public class Moto extends Vehiculos implements Encerar{
	public static enum Tama�o {Grande, Peque�a}
	private final static int TARIFA_BASE=1000;
	
	private  Tama�o tama�o;
	
	
	public Moto(String mat, boolean reparado)
	{
		super(mat,reparado);
	}

	public Tama�o getTama�o() {
		return tama�o;
	}

	public void setTama�o(Tama�o tama�o) {
		this.tama�o = tama�o;
	}
	
		
	public String toString(){
		String cad=super.toString();

		if (getTama�o() == Tama�o.Grande)
			cad += " Tama�o: Grande";
		else
			cad += " Tama�o: Peque�o";
	
		return cad;
	}
	
	public String encerar()
	{
		return("Enecerando moto" + getMatricula());
	}
	
	public double generateBill()
	{
		double tarifa;
		if(getTama�o()==Tama�o.Grande)
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
