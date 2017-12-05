package sesion05.shapes;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * <p>Title: Dibujo</p>
 * <p>Description: Clase que contiene las figuras que serán dibujadas.</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Escuela de Ingeniería Informática</p>
 * <p>Metodología de la Programación</p>
 * 
 * @author Profesores de Metodología de la programación
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
	 * Muestra por consola los rectángulos como coordenadas de una esquina y la longitud de los lados
	 */
	public void draw(PrintStream out) {
		for(Shape shape: shapes) {
			shape.draw(out);
		}
			
		}
	}

