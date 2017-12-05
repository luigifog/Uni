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
	
	private final static byte MAX_HUM=55;
	private final static byte MIN_HUM=45;

	private ArrayList<TemperatureSensor> tsensors = new ArrayList<TemperatureSensor>();
	private ArrayList<HumiditySensor> hsensors = new ArrayList<HumiditySensor>();
	private ArrayList<Door> doors = new ArrayList<Door>();

	public void add(TemperatureSensor sensor) {
		tsensors.add(sensor);
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
		checkHumidity(out);
	}
	
		
	/*
	 * Fuera hace frÌo, por lo que la apertura de las puertas siempre implica enfriar el interior.
	 * 
	 * Cuando getAverageTemperature() es mayor que MAX_TEMPERATURE) 
			ï	DeberÌan abrirse algunas puertas para bajar la temperatura (si es posible)
			ï	Cada grado de diferencia (getAverageTemperature()-MAX_TEMPERATURE)) implica la apertura del 10% de las puertas (si es posible)
			ï	Devolver un mensaje que indique cu·ntas puertas est·n a punto de abrirse (si es posible)
			
	 * Cuando getAverageTemperature() es menor que MIN_TEMPERATURE 
			ï	DeberÌan cerrarse algunas puertas para aumentar la temperatura (si es posible)
			ï	Cada grado de diferencia (MIN_TEMPERATURE-getAverageTemperature()) implica el cierre del 10% de las puertas (si es posible)
			ï	Devolver un mensaje que indique cu·ntas puertas est·n a punto de cerrarse (si es posible)
			
	 * En caso contrario, se devolver· un mensaje  que indique simplemente la temperatura media.
	 */
private void checkTemperature(PrintStream out){
	StringBuilder sb= new StringBuilder();
   double averageTemperature = getAverageTemperature();
	   if (averageTemperature > MAX_TEMPERATURE) {
		    	int difference=(int) (averageTemperature - MAX_TEMPERATURE);
		    	int doorsToOpen=(int) (doors.size()*0.1*difference);
		    	int openedDoors=openDoors(doorsToOpen,out);
//		    	out.println("Se deben abirir"+ doorsToOpen + "puertas");
//		    	out.print("Se han abierto " + openedDoors+ " Puertas");
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
		public void checkHumidity(PrintStream out)
		{
			double ttper=hsensors.size()*0.33;
			double ssper=hsensors.size()*0.66;
			Watering wat=new Watering();
			//humedad por debajo del minimo en 20 uds
			if(getAverageHumidity()<MIN_HUM-20)
			{
				for(int i=0;i<hsensors.size();i++)
				{
					wat.watering(out);
					out.print("High level");
				}
			}
			//Humedad por debajo del minimo pero no tanto
			else if(getAverageHumidity()<MIN_HUM)
			{
				for(double i=0;i<ssper;i++)
				{
					wat.watering(out);
					out.print("Medium level");
				}
			}
			//humedad por encima del maximo 20 uds
			else if(getAverageHumidity()<MAX_HUM+20)
			{
				for(int i=0;i<hsensors.size();i++)
				{
					wat.disWatering(out);
					out.print("off level");
				}
			}
			
			//humedad un poco por encima del maximo
			else if(getAverageHumidity()<MAX_HUM)
			{
				for(double i=0;i<ttper;i++)
				{
					wat.watering(out);
					out.print("Low level");
				}
			}
		}
	
	/**
	 * Calcula la temperatura media del invernadero
	 * 
	 * @return La temperatura media del invernadero
	 */
	private double getAverageTemperature() {
		double additions=0;
		for(TemperatureSensor sensor: tsensors)
			additions += sensor.getTemperature();
		return additions / tsensors.size();
	}
	
	private double getAverageHumidity() {
		double addition = 0;
		for(HumiditySensor sensor: hsensors)
			addition += sensor.getHumidity();
		return addition / hsensors.size();
	}
}
