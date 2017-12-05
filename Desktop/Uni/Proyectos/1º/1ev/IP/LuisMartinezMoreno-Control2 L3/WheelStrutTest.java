

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WheelStrutTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class WheelStrutTest
{
    /**
     * Default constructor for test class WheelStrutTest
     */
    public WheelStrutTest()
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
    public void WheelStrut_test()
    {
        //true en el boolean de aterrizado
        WheelStrut wheelStr1 = new WheelStrut();
        wheelStr1.setDeployed(true);
        //false en el boolean de aterrizado
        assertEquals(true, wheelStr1.getDeployed());
        wheelStr1.setDeployed(false);
        //false en el boolean de aterrizado
        assertEquals(false, wheelStr1.getDeployed());
        assertEquals(true, wheelStr1.test());
    }
}

