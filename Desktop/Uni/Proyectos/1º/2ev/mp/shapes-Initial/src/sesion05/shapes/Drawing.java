package sesion05.shapes;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * <p>Title: Dibujo</p>
 * <p>Description: Clase que contiene las figuras que ser�n dibujadas.</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Escuela de Ingenier�a Inform�tica</p>
 * <p>Metodolog�a de la Programaci�n</p>
 * 
 * @author Profesores de Metodolog�a de la programaci�n
 * @version 1.0
 */
public class Drawing {

	private ArrayList<Shape> shapes;
	
	public Drawing(){
		shapes = new ArrayList<Shape>();		
	}	
	

	public void add(Shape shape) {
		shapes.add(shape);
	}

	/**
	 * Muestra por consola los rect�ngulos como coordenadas de una esquina y la longitud de los lados
	 */
	public void draw(PrintStream out) {
		for(Shape shape: shapes) {
			shape.draw(out);
		}
			
		}
	}

