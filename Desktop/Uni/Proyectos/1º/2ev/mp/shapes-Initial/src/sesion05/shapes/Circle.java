package sesion05.shapes;

import java.io.PrintStream;

public class Circle extends Shape implements Drawable {
	private int[]centre;
	private int radium;
	public Circle(int[]centre, int radium,Color color)
	{
		super(color);
		setCentre(centre);
		setRadium(radium);
	}
	
	public int[] getCentre() {
		return centre;
	}
	private void setCentre(int[] centre) {
		this.centre = centre;
	}
	public int getRadium() {
		return radium;
	}
	private void setRadium(int radium) {
		this.radium = radium;
	}
	public void draw(PrintStream out)
	{
		out.print("Pintando Circulo: Centro(" +getCentre()[0]+","+centre[1]+")");
		out.println("Radio: " +getRadium());
	}
}
