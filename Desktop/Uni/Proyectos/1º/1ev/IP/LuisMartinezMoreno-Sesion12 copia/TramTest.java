

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TramTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TramTest
{
    @Test
    public void seatPersonTest()
    {
        //caso1 que haya una persona ocupando el sitio
        Tram tram=new Tram();
        SeatManager sm1=new SeatManager(4,5);
        Person person1 =new Person(3);
        Person person2=new Person(20);
        sm1.bookSeat(person1,2,3);
        assertFalse(tram.seatPerson(2,3,person2));
        
        //caso2 que el sitio estuviese libre
        sm1.release(2,3);
        assertTrue(tram.seatPerson(2,3,person2));
        
        //caso3 que no exista persona
        person1=null;
        assertFalse(tram.seatPerson(4,3,person1));
    }
}
