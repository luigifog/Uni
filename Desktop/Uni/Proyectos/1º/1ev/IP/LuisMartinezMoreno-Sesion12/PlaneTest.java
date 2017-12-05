

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PlaneTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PlaneTest
{
    /**
     * Default constructor for test class PlaneTest
     */
    public PlaneTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }


    @Test
    public void PlaneTest()
    {
        Plane plane1 = new Plane();
     //ambos valores correctos
        plane1.accelerate(-1, -1);
        assertEquals(-1, plane1.getXSpeed());
        assertEquals(-1, plane1.getYSpeed());
        //un valor correcto
        plane1.accelerate(-2, 0);
        assertEquals(-1, plane1.getXSpeed());
        assertEquals(0, plane1.getYSpeed());
        //ambos valores correctos
        plane1.accelerate(0, 0);
        assertEquals(0, plane1.getXSpeed());
        assertEquals(0, plane1.getYSpeed());
        //un valor correcto
        plane1.accelerate(0, -2);
        assertEquals(0, plane1.getXSpeed());
        assertEquals(0, plane1.getYSpeed());
        //ambos valores correctos
        plane1.accelerate(-1, -1);
        assertEquals(-1, plane1.getXSpeed());
        assertEquals(-1, plane1.getYSpeed());
        //un valor correcto
        plane1.accelerate(-5, -1);
        assertEquals(-1, plane1.getXSpeed());
        assertEquals(-1, plane1.getYSpeed());
        //un valor correcto
        plane1.accelerate(-1, -5);
        assertEquals(-1, plane1.getXSpeed());
        assertEquals(-1, plane1.getYSpeed());
    }

    @Test
    public void prueba_metodo_fly()
    {
        //Sin combustible
        Plane plane2 = new Plane();
        assertEquals(false, plane2.fly());
        //con combustible
        plane2.setFuel(60);
        assertEquals(true, plane2.fly());
        //cambiando la velocidad y la posicion
        plane2.setXPos(8);
        plane2.setYPos(8);
        plane2.setXSpeed(1);
        plane2.setYSpeed(1);
        assertTrue(plane2.fly());
    }
}



