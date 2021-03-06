package greenHouse;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * <p>Title: GreenHouse</p>
 * <p>Description: Clase que simula un invernadero</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Escuela de Ingenier�a Inform�tica</p>
 * <p>Metodolog�a de la Programaci�n</p>
 * 
 * @author Profesores de Metodolog�a de la Programaci�n
 * @version 1.0
 */
public class Greenhouse {
	
	private final static byte MAX_TEMPERATURE = 22;
	private final static byte MIN_TEMPERATURE = 19;

	private ArrayList<Sensor> sensors = new ArrayList<Sensor>();
	private ArrayList<Door> doors = new ArrayList<Door>();

	public void add(Sensor sensor) {
		sensors.add(sensor);
	}

	public void add(Door door) {
		doors.add(door);
	}

	
	
	/**
	 * Simula el trabajo de un operador que abre o cierra las puertas teniendo en cuenta la temperatura
	 * 
	 */
	public void operatorLooksThru(PrintStream out) {
		out.println("****OPERADOR****");
		checkTemperature(out);
	}
	
		
		/*
		 * Fuera hace fr�o, por lo que la apertura de las puertas siempre implica enfriar el interior.
		 * 
		 * Cuando getAverageTemperature() es mayor que MAX_TEMPERATURE) 
				�	Deber�an abrirse algunas puertas para bajar la temperatura (si es posible)
				�	Cada grado de diferencia (getAverageTemperature()-MAX_TEMPERATURE)) implica la apertura del 10% de las puertas (si es posible)
				�	Devolver un mensaje que indique cu�ntas puertas est�n a punto de abrirse (si es posible)
				
		 * Cuando getAverageTemperature() es menor que MIN_TEMPERATURE 
				�	Deber�an cerrarse algunas puertas para aumentar la temperatura (si es posible)
				�	Cada grado de diferencia (MIN_TEMPERATURE-getAverageTemperature()) implica el cierre del 10% de las puertas (si es posible)
				�	Devolver un mensaje que indique cu�ntas puertas est�n a punto de cerrarse (si es posible)
				
		 * En caso contrario, se devolver� un mensaje  que indique simplemente la temperatura media.
		 */
	private void checkTemperature(PrintStream out){
		StringBuilder sb= new StringBuilder();
	   double averageTemperature = getAverageTemperature();
		   if (averageTemperature > MAX_TEMPERATURE) {
			    	int difference=(int) (averageTemperature - MAX_TEMPERATURE);
			    	int doorsToOpen=(int) (doors.size()*0.1*difference);
			    	int openedDoors=openDoors(doorsToOpen,out);
//			    	out.println("Se deben abirir"+ doorsToOpen + "puertas");
//			    	out.print("Se han abierto " + openedDoors+ " Puertas");
			    	sb.append("Se deben abirr ").append(doorsToOpen).append(" puertas");
			    	sb.append("Se han abierto").append(openedDoors).append( " puertas");
			    	out.println(sb);    // esto del final se pone siempre
		    }
		   else if (averageTemperature < MIN_TEMPERATURE) {
			    	//Completar in da jaus
			      
		    }
		   else System.out.printf("La temperature %f es correcta.\n", averageTemperature);
   }

		private int openDoors(int doorsToOpen,PrintStream out)
		{
			int doorsToReturn=doorsToOpen;
			for(int i=0;i<doors.size();i++)
			{
				while(doorsToOpen>0)
				{
					if(doors.get(i).isOpened()==false)
					{
						doors.get(i).open(out);
					}
					doorsToOpen-=1;
					
				}
			}
			if(doorsToOpen==0)
			{
				return doorsToReturn;
			}
			return doorsToOpen;
		}
	
	
	/**
	 * Calcula la temperatura media del invernadero
	 * 
	 * @return La temperatura media del invernadero
	 */
	private double getAverageTemperature() {
		double addition = 0;
		for(Sensor sensor: sensors)
			addition += sensor.getTemperature();
		return addition / sensors.size();
	}
	
	public ArrayList<ElectronicDevice> getDevices()
	{
		ArrayList<ElectronicDevice> list= new ArrayList<ElectronicDevice>();
		for(Sensor sensor:sensors)
		{
			list.add(sensor);
		}
		for(Door door:doors)
		{
			if(door instanceof AutDoor)
				list.add(door);
		}
	}
}
