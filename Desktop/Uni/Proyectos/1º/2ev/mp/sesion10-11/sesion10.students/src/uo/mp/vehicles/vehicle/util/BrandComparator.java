/**
 * 
 */
package uo.mp.vehicles.vehicle.util;

import java.util.Comparator;

import uo.mp.vehicles.vehicle.Vehicle;

/**
 * @author UO257180
 *
 */
public class BrandComparator implements Comparator<Vehicle> {

	@Override
	public int compare(Vehicle arg0, Vehicle arg1) {
		assertParameters(arg0,arg1);
		if( arg0.getBrand().compareTo(arg1.getBrand())==0)
			return arg0.getYears() - arg1.getYears();
		
		else
			return arg0.getBrand().compareTo(arg1.getBrand());
	}

	private void assertParameters(Vehicle v1, Vehicle v2)
	{
		if(v1==null || v2==null)
		{
			throw new IllegalArgumentException("Algun vehiculo null"); 
		}
	}
	
}
