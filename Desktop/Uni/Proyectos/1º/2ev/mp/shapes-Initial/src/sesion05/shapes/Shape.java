package sesion05.shapes;

import java.io.PrintStream;

public abstract class Shape {

	private Color color;
	
	public Shape(Color color)
	{
		setColor(color);
	}
	
	public Color getColor() {
		return color;
	}
	private void setColor(Color color) {
		this.color = color;
	}

}
