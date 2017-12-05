package taller;

import java.io.PrintStream;

public abstract class Vehiculos {
	private String matricula;
	private boolean reparado=false;
	
	
	
	public Vehiculos(String mat, boolean reparado)
	{
		setMatricula(mat);
		setReparado(reparado);
		
	}
	public String getMatricula() {
		return matricula;
	}
	protected void setMatricula(String matricula) {
		if (matricula != null)
			this.matricula = matricula;
		else
			throw new RuntimeException("Parámetro incorrecto");
	
	}
	public boolean isReparado() {
		return reparado;
	}
	protected void setReparado(boolean reparado) {
		this.reparado = reparado;
	}
	
	public String toString()
	{
		String cad="";
		
		cad+= "Matricula: "+getMatricula();
		
		if(isReparado()==true)
		{
			cad+="Vehiculo ya reparado";
		}
		
		else
		{
			cad+="Vehiculo sin reparar";
		}
		return cad;
	}
	
	public abstract void reparar(PrintStream out);

	
	

}
