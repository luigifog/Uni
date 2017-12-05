

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SwitchTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SwitchTest
{
    /**
     * Default constructor for test class SwitchTest
     */
    public SwitchTest()
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
    public void switch_test()
    {
        Switch switch2 = new Switch();
        switch2.press();
        assertEquals(true, switch2.getActivate());
        switch2.press();
        assertEquals(false, switch2.getActivate());
        switch2.turnOn();
        assertEquals(true, switch2.getActivate());
        switch2.turnOff();
        assertEquals(false, switch2.getActivate());
        switch2.setActivate(true);
        assertEquals(true, switch2.getActivate());
        switch2.setActivate(false);
        assertEquals(false, switch2.getActivate());
    }
}

