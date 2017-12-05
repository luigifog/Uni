package sesion08.collections;


/**
 * <p>Title: Collection</p>
 * <p>Description: Interfaz que representa una colecci�n de elementos.</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Escuela de Ingenier�a Inform�tica </p>
 * <p>Metodolog�a de la Programaci�n</p>
 * 
 * @author Profesores de Metodolog�a de la Programaci�n
 * @version 1.0
 */

public interface Collection {
	
	
	/**
     * Devuelve {@code true} si la colecci�n contiene el elemento especificado
     * M�s formalmente, devuelve {@code true} si y solo si esta colecci�n 
     * contiene al menos un elemento tal que 
     * {@code (o == null ? e == null : o.equals(e))}. 
     * 
     * @param o elemento a comprobar si est� en la colecci�n
     * @return {@code true} si esta colecci�n contienen el elemento especificado
     */
    boolean contains(Object o);
    
    /**
	 * Devuelve el n�mero de elementos que hay en la colecci�n
	 * @return El n�mero de elementos de la colecci�n
	 */
	int size();
	
		
	/**
	 *  Indica si la colecci�n contiene o no elementos
	 * @return Devuelve {@code true} si la colecci�n no contiene elementos {@code false} en caso contrario
	 */
	boolean isEmpty();

	/**
	 * A�ade al final de la lista el elemento especificado 
	 * @param element el elemento que se a�ade a la colecci�n
	 * @throws IllegalArgumentException si el elemento es null y no se puede a�adir a la colecci�n
	 */
	void add(Object element);

	/**
	 * Elimina el elemento de la colecci�n que coincida con el par�metro 
	 * Devuelve el elemento que fue eliminado de la colecci�n 
	 * @param element el elemento que se quiere borrar
	 * @return El elemento de la collecci�n. Null si no se encuentra en la colecci�n
	 */
	Object remove(Object element);
	
	
	/**
     * Elimina todos los elementos de la colecci�n.
     * La colecci�n estar� vac�a despu�s de esta operaci�n.
     *
     */
    void clear();
	
	/**
	 * Devuelve la representaci�n textual de la colecci�n. Esto es:
	 * "[el1, el2, ..., eln]" donde eli es la representaci�n textual de su i-th elemento  
	 * @return un string con la representaci�n textual de la colecci�n
	 */
	String toString();
	
	public IteratorLinked iterator();
	
	
	
	
	
	
	
	
	
	
	
	
}
