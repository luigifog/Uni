package sesion08.collections;

/**
 * <p>Title: List</p>
 * <p>Description: Interface que representa una secuencia de elemntos (una colección) donde el mismo elemento puede estar estar repetido.</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Escuela de Ingeniería Informática </p>
 * <p>Metodología de la Programación</p>
 * 
 * @author Profesores de Metodología de la Programación
 * @version 1.0
 */

public interface List extends Collection {
	
	/**
	 * Inserta el elemento en la posición indicada por indexpen la lista.
	 * Desplaza el elemento actualmente en esa posición (si existe) y los elementos posteriores
     * a la derecha (añade uno a sus índices). 
	 * @param index Posicion donde se desea insertar el elemento
	 * @param element elemento que se inserta 
	 * @throws IllegalArgumentException si el elemento es null
     * @throws IndexOutOfBoundsException si index está fuera del rango
     *         ({@code index < 0 || index > size()})
	 */
	void add(int index, Object element);

	/**
	 * Elimina el elemento que se encuentra en la posición indicada por index de la lista
	 * Desplaza los elementos posteriores a la izquierda (resta uno a sus índices). 
	 * Returns el elemento que fue eliminado de la lista. 
	 * @param index índice del elemento que se desea eliminar
	 * @return El elemento que se encontraba previamente en la posición indicada
	 * @throws IndexOutOfBoundsException si index está fuera del rango
     *         ({@code index < 0 || index >= size()})
	 */
	Object remove(int index);
	
	/**
	 * Devuelve el índice de la primera aparición del elemento en la lista, 
	 * o -1 si la lista no contiene el elemento. 
	 * @param o elemento a buscar
	 * @return el índice de la primara aparición del elemento en la lista, o -1 si la lista no contiene el elemento
	 */
	int indexOf(Object o);

	/**
	 * Devuelve el elemento que se encuentra en la posición index de la lista. 
	 * @param index índice del elemento a recuperar
	 * @return El elemento que se encuentra en la posición indicada de la lista
	 * @throws IndexOutOfBoundsException si index está fuera del rango
     *         ({@code index < 0 || index >= size()}) 
	 */
	Object get(int index);
	
	/**
	 * Reemplaza el elemento de la posición index en la lista con el elemento especificado
	 * @param index índice del elemento a reemplazar
	 * @param element elemento a almacenar en la posición indicada
	 * @return El elemento que se encontraba previamente en la posición index
	 * @throws IndexOutOfBoundsException si index está fuera del rango
     *         ({@code index < 0 || index > size()})
	 */
	Object set(int index, Object element);
	
	 /**
     * Compara el objeto especificado con los elementos de la lista.  Devuelve
     * {@code true} si y solo si el objeto especificado es también una lista, ambas listas tienen
     * el mismo tamaño, y todos los correspondientes pares de elementos de las dos listas 
     * son  <i>equal</i>. 
     *
     * @param o el objeto a ser comparado con la lista
     * @return {@code true} si el objeto especificado es igual a la lista
     */
    boolean equals(Object o);

    /**
     * Devuelve el valor hash code para esta lista. El hash code de la lista es el resultado de la 
     * del siguiente cálculo:
     * <pre>
     *  int hashCode = 1;
     *  for (Object e : list)
     *      hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
     * </pre>
     * Esto asegura que {@code list1.equals(list2)} implica que
     * {@code list1.hashCode() == list2.hashCode()} 
     *
     *
     * @return el valor hash code para esta lista
     */
    int hashCode();	

}
