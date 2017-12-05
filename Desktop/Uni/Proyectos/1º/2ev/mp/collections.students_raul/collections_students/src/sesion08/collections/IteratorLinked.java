package sesion08.collections;

import java.util.Iterator;

public class IteratorLinked implements Iterator {
	Node actual=null;
	Node head=null;
	
	public IteratorLinked(Node head)
	{
		this.head=head;
		actual=head;
	}
	@Override
	public boolean hasNext() {
		if(actual.next!=null)
		{
			actual=actual.next;
			return true;
		}
		else
		{
			return false;
		}
	}
		

	@Override
	public Object next() {
		
		return actual.info;
	}

}
