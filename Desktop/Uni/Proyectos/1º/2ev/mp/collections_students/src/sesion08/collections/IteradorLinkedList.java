package sesion08.collections;

import java.util.Iterator;

public class IteradorLinkedList implements Iterator<Object> {

	LinkedList lista=null;
	Node actual=null;
	
	
	public IteradorLinkedList(LinkedList lista){
		this.lista=lista;
		actual=null;
	}
		public boolean hasNext(){
			if(actual==null)
			{
				actual=lista.getNode(0);
				return true;
			}
			else
			if(actual.next!=null){
				actual=actual.next;
				return true;
			}
			return false;
		}
		@Override
		public Object next(){
			return actual.element;
		}
		
		public void remove()
		{
			if(lista.size()>0)
			{
				lista.remove(actual);
			}
		}
}
