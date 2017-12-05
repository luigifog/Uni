

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BasculeBridgeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BasculeBridgeTest
{
    /**
     * Default constructor for test class BasculeBridgeTest
     */
    public BasculeBridgeTest()
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
    public void slopeTest()
    {
        //se crea un objeto BasuleBridge
        BasculeBridge basculeB1 = new BasculeBridge(30);
        // con el valor 0 de inclinacion,el minimo aceptado
        basculeB1.slope(-30);
        assertEquals(0, basculeB1.getPosition());
        //con un valor demtro del rango
        basculeB1.slope(50);
        assertEquals(50, basculeB1.getPosition());
        //con el valor limite por arriba
        basculeB1.slope(10);
        assertEquals(60, basculeB1.getPosition());
        //valor por encima del limite
        basculeB1.slope(10);
        assertEquals(60, basculeB1.getPosition());
        //valor por debajo del limite minimo
        basculeB1.slope(-100);
        assertEquals(60, basculeB1.getPosition());
    }
}

