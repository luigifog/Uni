package laboratory10.stackqueue;

/**
 * <p>Title: Queue</p>
 * <p>Description: Interfaz queue.</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Escuela de Ingeniería Informática</p>
 * <p>Metodología de la Programación</p>
 * 
 * @author Profesores de Metodología de la Programación
 * @version 1.0
 */
public interface Queue {
	
	/**
	 * Añade un objeto en la parte posterior (final) de la cola
	 * @param element El elemento a añadir
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
	 * Devuelve el número de elementos de la cola
	 * @return El número de elementos de la cola
	 */
	public int size();
	
	/**
	 * Indica si la cola está vacía o no
	 * @return true si la cola está vacía ; false en caso contrario.
	 */
	public boolean isEmpty();
		
}
