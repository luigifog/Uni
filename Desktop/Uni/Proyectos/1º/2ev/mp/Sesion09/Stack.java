package sesion10.stackqueue;

/**
 * <p>Title: Stack</p>
 * <p>Description: Interfaz stack.</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Computer Escuela de Ingenier�a Inform�tica</p>
 * <p>Metodolog�a de la programaci�n</p>
 * 
 * @author Profesores de Metodolog�a de la Programaci�n
 * @version 1.0
 */
public interface Stack {
	
	/**
	 * coloca (a�ade) un elemento en la parte superior de la pila
	 * @param element El objeto que se a�ade
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
	 * Devuelve el n�mero de elementos que hay en la pila
	 * @return El n�mero de elementos de la pila
	 */
	public int size();
	
	/**
	 * Indica si la pila est� vac�a o no
	 * @return true si la pila est� vac�a; false en caso contrario.
	 */
	public boolean isEmpty();
		
		
}
