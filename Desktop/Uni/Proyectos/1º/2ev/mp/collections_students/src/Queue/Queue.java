package Queue;

/**
 * <p>Title: Queue</p>
 * <p>Description: Interfaz queue.</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Escuela de Ingenier�a Inform�tica</p>
 * <p>Metodolog�a de la Programaci�n</p>
 * 
 * @author Profesores de Metodolog�a de la Programaci�n
 * @version 1.0
 */
public interface Queue {
	
	/**
	 * A�ade un objeto en la parte posterior (final) de la cola
	 * @param element El elemento a a�adir
	 */
	public void enqueue(Object element);
	
	/**
	 * Devuelve el objeto de la parte delantera (inicio) de la cola sin quitarlo
	 * @return El elemento de la parte delantera (inicio) de la cola
	 */
	public Object peek();
	
	/**
	 * Borra y devuelve un objeto de la parte delantera (inicio) de la cola
	 * @return El elemento borrado
	 */
	public Object dequeue();
	
	/**
	 * Devuelve el n�mero de elementos de la cola
	 * @return El n�mero de elementos de la cola
	 */
	public int size();
	
	/**
	 * Indica si la cola est� vac�a o no
	 * @return true si la cola est� vac�a ; false en caso contrario.
	 */
	public boolean isEmpty();
		
}
