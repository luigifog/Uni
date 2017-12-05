

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class FigureTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FigureTest
{
    /**
     * Default constructor for test class FigureTest
     */
    public FigureTest()
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
    public void figura_test()
    {
        //constructor de figura
        Figure figure1 = new Figure();
        //Movemos la figura a la izq
        figure1.move('L');
        assertEquals(-1, figure1.getXPos());
        //Movemos la figura a la drcha
        figure1.move('R');
        assertEquals(0, figure1.getXPos());
        //Movemos la figura a la drcha
        figure1.move('R');
        assertEquals(1, figure1.getXPos());
        //Movemos la figura hacia arriba
        figure1.move('U');
        assertEquals(1, figure1.getYPos());
        //Movemos la figura hacia abajo
        figure1.move('D');
        assertEquals(0, figure1.getYPos());
        //Movemos la figura hacia abajo
        figure1.move('D');
        assertEquals(-1, figure1.getYPos());
        //comprueo que el toString funciona correctamente
        assertEquals("null-(1,-1)", figure1.toString());
    }
}

