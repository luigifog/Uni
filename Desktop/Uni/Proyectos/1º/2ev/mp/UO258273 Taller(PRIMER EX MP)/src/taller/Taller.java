package taller;

import java.io.PrintStream;
import java.util.ArrayList;

public class Taller {
	private ArrayList<Vehiculos> vehiculos;
	
	public Taller()
	{
		vehiculos=new ArrayList<Vehiculos>();
	}
	 public void add(Vehiculos vehiToAdd)
	 {
		 vehiculos.add(vehiToAdd);
	 }
	
	 public void brokenVehicles(PrintStream out)
	 {
		 for(int i=0;i<vehiculos.size();i++)
		 {
			 if(vehiculos.get(i).isReparado()==false)
			 {
				 out.println(vehiculos.get(i).getMatricula());
			 }
		 }
	 }
	 
	 
	 public void encerando()
	 {
		 for(int i=0;i<vehiculos.size();i++)
		 {
			 if(vehiculos.get(i).isReparado()==true)
			 {
				 if(vehiculos.get(i) instanceof Encerar)
				 {
					 ((Encerar) vehiculos.get(i)).encerar();
				 }
			 }
		 }
	 }

	 
	 
	 public boolean equals(String matricula)
	 {
			if(matricula==null)
			{
				throw new RuntimeException("parametro incorrecto");
			}
		 for(int i=0;i<vehiculos.size();i++)
		 {
			 if(vehiculos.get(i).getMatricula().equals(matricula))
			 {
				 return true;
			 }
		 }
		 return false;
		}
	 
	public void reparar(String matricula,PrintStream out)
	{
		if(matricula==null)
		{
			throw new RuntimeException("parametro incorrecto");
		}
		 for(int i=0;i<vehiculos.size();i++)
		 {
			 if(equals(matricula)==true)
			 {
				 if(vehiculos.get(i).isReparado()==false)
				 {
					 vehiculos.get(i).reparar(out);
				 }
				 else
				 {
					 throw new RuntimeException("parametro incorrecto");
				 }
				}
 
			 else
			 {
				 throw new RuntimeException("parametro incorrecto");
			 }
		 }
		 
	}
	
	public boolean comprobarReparacion(String mat)
	{
		if(mat==null)
		{
			throw new RuntimeException("parametro incorrecto");
		}
		
		for(int i=0;i<vehiculos.size();i++)
		 {
			 if(equals(mat)==true)
			 {
				 if(vehiculos.get(i).isReparado()==true)
				 {
					 return true;
				 }
			 }
		 }
				 
		
		return false;
	}
}
