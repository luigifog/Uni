

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


    
/**
 * Write a description of class flightSimulatorTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class flightSimulatorTest
{
   @Test
   public void testSimulator()
   {
    flightSimulator fsim=new flightSimulator();
    
    fsim.addPlane(new Plane(new Person(3),'A',50,0,0,1,1));
    fsim.addPlane(new Plane(new Person(3),'B',50,10,0,-1,1));
    fsim.addPlane(new Plane(new Person(3),'C',50,0,10,-1,-1));
    fsim.addPlane(new Plane(new Person(3),'D',50,10,10,-1,-1));
    
    fsim.paint();
    for(int i=1;i<=5;i++)
    {
        fsim.simulate();
    }
}
}
