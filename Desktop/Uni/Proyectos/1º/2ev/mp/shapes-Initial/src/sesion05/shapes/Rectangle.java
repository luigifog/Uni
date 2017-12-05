package sesion05.shapes;

import java.io.PrintStream;

/**
 * <p>Title: Rectángulo  </p>
 * <p>Description: Clase que modela un rectángulo</p>
 * <p>Copyright: Copyright (c) 2016/p>
 * <p>Escuela de Ingeniería Informática</p>
 * <p>Metodología de la Programación</p>
 * 
 * @author Profesores de Metodología de la programación
 * @version 1.0
 */



public class Rectangle extends Shape implements Drawable {

	private int posX;	
	private int posY; 	// Coordenadas de la esquina superior izquierda
	private int width;
	private int height; 
	
	public Rectangle(int posX,int posY,int width,int height,Color color)
	{
		super(color);
		setPosX(posX);
		setPosY(posY);
		setWidth(width);
		setHeight(height);

	}
	public int getPosX() {
		return posX;
	}
	private void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	private void setPosY(int posY) {
		this.posY = posY;
	}
	public int getWidth() {
		return width;
	}
	private void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	private void setHeight(int height) {
		this.height = height;
	}
	
 /**
  *Pinta un rectangulo 
  */
	public void draw(PrintStream out)
	{
		out.print("Dibujando el rectángulo: ");
		out.print("(" + getPosX() + ", " + getPosY() + ")");
		out.print(" - Anchura: " +  getWidth());
		out.println(" - Altura: " + getHeight());			
	}
}
