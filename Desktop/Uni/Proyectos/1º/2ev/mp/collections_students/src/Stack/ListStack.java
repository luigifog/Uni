package Stack;

import sesion08.collections.List;

public class ListStack implements Stack{

	private final static int TOP=0;
	private List list;
	
	public ListStack(List list) {
		this.list=list;
	}

	public void push(Object element) {
		checkNotNull(element);
		list.add(TOP,element);
		
	}

	@Override
	public Object peek() {
		if(list.isEmpty())
			throw new IllegalStateException("La pila esta vacia");
		return list.get(TOP);
	}

	@Override
	public Object pop() {
		return list.remove(TOP);
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	void checkNotNull(Object element)
	{
		if(element==null)
			throw new IllegalArgumentException("objeto null");
		
	}
}