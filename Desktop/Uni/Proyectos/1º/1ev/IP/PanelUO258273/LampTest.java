

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LampTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LampTest
{
    /**
     * Default constructor for test class LampTest
     */
    public LampTest()
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
    public void lamp_test()
    {
        Lamp lamp2 = new Lamp();
        lamp2.setTurnLamp(true);
        assertEquals(true, lamp2.getTurnLamp());
        lamp2.setTurnLamp(false);
        assertEquals(false, lamp2.getTurnLamp());
        lamp2.turnOn();
        assertEquals(true, lamp2.getTurnLamp());
        lamp2.turnOff();
        assertEquals(false, lamp2.getTurnLamp());
    }
}

