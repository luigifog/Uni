package sesion08.collections;

import java.util.Iterator;

public class IteratorArray implements Iterator {
	int actual=0;
	ArrayList array;
	
	public IteratorArray(ArrayList ar)
	{
		this.array=ar;
		actual=0;
	}
	
	@Override
	public boolean hasNext() {
		if(actual>array.size())
		{
			actual++;
			return true;
		}
		return false;
	}

	@Override
	public Object next() {
		
		return actual;
	}

}
