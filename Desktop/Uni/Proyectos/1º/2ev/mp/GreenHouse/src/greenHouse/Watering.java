package greenHouse;

import java.io.PrintStream;

public class Watering {
	private boolean activate;

	public boolean isActivate() {
		return activate;
	}

	private void setActivate(boolean activate) {
		this.activate = activate;
	}
	
	
	public void watering(PrintStream out)
	{
		if(!isActivate())
		{
			out.print("Se activa el sistema de regado");
			setActivate(true);
		}
	}
	
	public void disWatering(PrintStream out)
	{
		if(isActivate())
		{
			out.print("Se desactiva el sistema de regado");
			setActivate(false);
		}
	}
	
//	public void activateIrrigation(Enum <Humidity> humi)
//	{
//		if(humi==Humidity.low)
//		{
//			
//		}
//		
//		if(humi==Humidity.medium)
//		{
//			
//		}
//		
//		if(humi==Humidity.high)
//		{
//			
//		}
//		if(humi==Humidity.off)
//		{
//			
//		}
//		
//	}
}
