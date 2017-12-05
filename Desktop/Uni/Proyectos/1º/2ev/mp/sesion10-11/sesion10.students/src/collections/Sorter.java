package collections;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import uo.mp.vehicles.vehicle.Vehicle;

public class Sorter {
    private Comparator<Vehicle> comparator;
    
    public Sorter(Comparator<Vehicle> comparator) {
            this.comparator = comparator;
    }

   
    public List<Vehicle> sort(List<Vehicle> list) {
            List<Vehicle> res = new LinkedList<Vehicle>();
            for(Vehicle obj: list) {
                    int pos = findPositionFor( obj, res );
                    res.add(pos, obj);
            }
            return res;
    }

    private int findPositionFor(Vehicle newObj, List<Vehicle> list) {
            int i = 0;
            for(Vehicle inListObject: list) {
            	    if (comparator != null){
            	    	if (comparator.compare(newObj, inListObject) <= 0) {
                            return i;
            	    	}
            	    	
            	    } else if (newObj.compareTo(inListObject) <=0 ){
            	    	return i;
            	    }
            	    i++;
            	    }
            return i;
    }

}
