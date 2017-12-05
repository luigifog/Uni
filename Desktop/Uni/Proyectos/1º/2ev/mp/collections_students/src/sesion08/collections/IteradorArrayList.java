package sesion08.collections;

import java.util.Iterator;

public class IteradorArrayList implements Iterator<Object> {


	ArrayList lista=null;
	int pos =-1;
	public IteradorArrayList(ArrayList lista){
		this.lista=lista;
		
	}
		public boolean hasNext(){
			if(pos==-1)
			{
				pos=0;
				return true;
			}
			else
			{
				if(pos<lista.size())
				{
					pos++;
					return true;
				}
					return false;
			}
		}
		
		@Override
		public Object next(){
			return lista.get(pos);
		}
		
//		public Iterator<Object> iterator(){
//		return new IteradorLinkedList(head);
//	}
		
		@Override
		public void remove()
		{
			if(lista.size()>0)
			{
				lista.remove(pos);
			}
		}
}

