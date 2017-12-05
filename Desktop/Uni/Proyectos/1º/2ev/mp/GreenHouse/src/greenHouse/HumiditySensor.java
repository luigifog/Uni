package greenHouse;

import java.io.PrintStream;
import java.util.Random;

public class HumiditySensor implements Checkable{
	public int getHumidity() {
		// n�mero aleatorio [45-55]
		return new Random(System.currentTimeMillis()).nextInt(11)+45;
		
	}
	
	public void check(PrintStream out) {
		out.println("Comprobando sensor");
	}
}
