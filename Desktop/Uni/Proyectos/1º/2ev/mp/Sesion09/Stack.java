package sesion10.stackqueue;

/**
 * <p>Title: Stack</p>
 * <p>Description: Interfaz stack.</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Computer Escuela de Ingeniería Informática</p>
 * <p>Metodología de la programación</p>
 * 
 * @author Profesores de Metodología de la Programación
 * @version 1.0
 */
public interface Stack {
	
	/**
	 * coloca (añade) un elemento en la parte superior de la pila
	 * @param element El objeto que se añade
	 */
	public void push(Object element);
	
	/**
	 * Devuelve el objeto del tope de de la pila sin borrarlo
	 * @return El objeto del tope de la pila
	 */
	public Object peek();
	
	/**
	 * Borra y devuelve el objeto del tope de la pila
	 * @return El objeto borrado de la pila
	 */
	public Object pop();
	
	/**
	 * Devuelve el número de elementos que hay en la pila
	 * @return El número de elementos de la pila
	 */
	public int size();
	
	/**
	 * Indica si la pila está vacía o no
	 * @return true si la pila está vacía; false en caso contrario.
	 */
	public boolean isEmpty();
		
		
}
