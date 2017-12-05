package greenHouse;

import java.io.PrintStream;

public class AutDoor extends Door implements ElectronicDevices{
	public void open(PrintStream out){
		if (!isOpened()) {
			out.println ("  La puerta automatica se abre ");
			setOpened(true);
		}
	}
	
	public void close(PrintStream out){
		if (isOpened()) {
			out.println ("  La puerta automatica se cierra ");
			setOpened(false);
		}
	}

	@Override
	public void check(PrintStream out) {
		out.println("Chequeando puerta aut");
		
	}

}
