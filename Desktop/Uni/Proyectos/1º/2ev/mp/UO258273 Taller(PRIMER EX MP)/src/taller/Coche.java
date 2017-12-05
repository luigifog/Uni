package taller;

import java.io.PrintStream;


public class Coche extends Vehiculos implements Encerar{
	public static final int MINIMA_POTENCIA = 800;    // cilindrada
	public static enum Problema {Motor,Frenos,Chapa}
	private final static int TARIFA_BASE=1000;
	
	private int potencia;
	private Problema problema;


	public Coche(String mat, boolean reparado)
	{
		super(mat,reparado);

	}

	
	/**
	 * Devuelve el tipo de problema del coche
	 * 
	 * @return Valor del tipo Problema
	 */
	protected Problema getProblema() {
		return problema;
	}

	/**
	 * Coloca el problema del coche
	 * 
	 * 
	 */
	public void setProblema(Problema tipo) {
		this.problema = tipo;	
	}

	/**
	 * Devuelve la potencia del coche
	 * @return int valor de la potencia 
	 */
	public int getPotencia(){
		return potencia;
	}
	
	/**
	 * Coloca la potencia al  coche
	 * @param int potencia del coche 
	 */
	public void setPotencia(int potencia){
		if (potencia > MINIMA_POTENCIA)
			this.potencia = potencia;
		else
			throw new RuntimeException("Parámetro incorrecto");
	}

	public String toString()
	{
		String cad=super.toString();
		cad+="Potencia: "+getPotencia();
		if(getProblema()==Problema.Motor)
		{
			cad+="Problema en el motor";
		}
		
		if(getProblema()==Problema.Frenos)
		{
			cad+="Problema en el frenos";
		}
		
		if(getProblema()==Problema.Chapa)
		{
			cad+="Problema en el chapa";
		}
		
		return cad;
	}
	
	public String encerar()
	{
		return("Enecerando coche" + getMatricula());
	}
	
	public double generateBill()
	{
		int tarifa;
		int incremento;
		if(getProblema()==Problema.Chapa)
		{
			incremento=200;
		}
		
		if(getProblema()==Problema.Motor)
		{
			incremento=1000;
		}
		
		if(getProblema()==Problema.Frenos)
		{
			incremento=500;
		}
		else
		{
			incremento=0;
		}
		tarifa=TARIFA_BASE+incremento;
		return tarifa;
	}
	
	public void reparar(PrintStream out)
	{
		setReparado(true);
		out.println("Factura: "+generateBill());
	}
	

	
}
