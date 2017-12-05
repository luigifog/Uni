package sesion08.collections;

import java.util.Iterator;

public class IteradorArrayList implements Iterator<Object> {


	Node head;
	Node actual;
	public IteradorArrayList(Node head){
		this.head=head;
		actual=head;
	}
		public boolean hasNext(){
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
		public Iterator<Object> iterator(){
			return new IteradorLinkedList(head);
		}
}
