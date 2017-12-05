package Queue;

import sesion08.collections.List;

public class ListQueue implements Queue {

	
	private List list;
	private final static int inicio=0;
	
	public ListQueue(List list) {
		this.list=list;
	}
	
	/**
	 * A�ade un objeto en la parte posterior (final) de la cola
	 * @param element El elemento a a�adir
	 */
	@Override
	public void enqueue(Object element) {
			checkNotNull(element);
			list.add(element);
	}

	

	/**
	 * Devuelve el objeto de la parte delantera (inicio) de la cola sin quitarlo
	 * @return El elemento de la parte delantera (inicio) de la cola
	 */
	@Override
	public Object peek() {
		if(list.isEmpty())
			throw new IllegalStateException("La pila esta vacia");
		return list.get(inicio);
	}

	/**
	 * Borra y devuelve un objeto de la parte delantera (inicio) de la cola
	 * @return El elemento borrado
	 */
	
	@Override
	public Object dequeue() {
		return list.remove(inicio);
	}

	/**
	 * Devuelve el n�mero de elementos de la cola
	 * @return El n�mero de elementos de la cola
	 */
	
	@Override
	public int size() {
		return list.size();
	}

	/**
	 * Indica si la cola est� vac�a o no
	 * @return true si la cola est� vac�a ; false en caso contrario.
	 */
	
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	
	/**
	 * 
	 * Comprueba que algo no esta en null
	 * @param element
	 */
	void checkNotNull(Object element)
	{
		if(element==null)
			throw new IllegalArgumentException("objeto null");
		
	}
}
