package sesion05.shapes;

/**
 * <p>Title: Aplicación</p>
 * <p>Description: Clase para ejecutar la aplicación.</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Escuela de Ingeniería Informática</p>
 * <p>Metodología de la Programación</p>
 * 
 * @author  Profesores de Metodología de la programación
 * @version 1.0
 */
public class Application {
	
	/**
	 * Método principal para la ejecución del programa
	 * 
	 * @param args No son usados
	 */
	public static void main(String[] args) {
		new Application().run();
	}
	
	/**
	 * Ejecuta la aplicación
	 */
	public void run (){
		Drawing drawing = new Drawing();
		
		Rectangle rectantle1 = new Rectangle(1,2,3,6,Color.Amarillo);
		drawing.add(rectantle1);
		
		Rectangle rectangle2 = new Rectangle(3,4,7,8,Color.Verde);
		drawing.add(rectangle2);
		
		Circle circle1= new Circle(new int[3],10,Color.Verde);
		drawing.add(circle1);
		drawing.draw(System.out);
	}

}

//crear la clase triangulo
//4 atributos: point1 int [],point2,point3, con sus set y get y draw