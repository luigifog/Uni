

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class NunchukTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NunchukTest
{
    /**
     * Default constructor for test class NunchukTest
     */
    public NunchukTest()
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
    public void nunchuk_test()
    {
        Nunchuk nunchuk2 = new Nunchuk();
        
    }

    @Test
    public void e()
    {
        //constructor de un nunchuk
        Nunchuk nunchuk1 = new Nunchuk();
        //se mueve hacia la izq
        nunchuk1.advance('L');
        //compruebo los datos correctos
        nunchuk1.print();
        //se mueve hacia la drcha
        nunchuk1.advance('R');
        //compruebo los datos correctos
        nunchuk1.print();
        //se mueve hacia arriba
        nunchuk1.advance('U');
        //compruebo los datos correctos
        nunchuk1.print();
        //se mueve hacia abajo
        nunchuk1.advance('D');
        //compruebo los datos correctos
        nunchuk1.print();
        //se mueve hacia arriba pero con el metodo que se avanzan dos pasos
        nunchuk1.middleAdvance('U');
        //compruebo los datos correctos
        nunchuk1.print();
        //se mueve hacia la drcha pero con el metodo que se avanzan dos pasos
        nunchuk1.middleAdvance('R');
        //compruebo los datos correctos
        nunchuk1.print();
        //se mueve hacia la izq pero con el metodo que se avanzan dos pasos
        nunchuk1.middleAdvance('L');
        //compruebo los datos correctos
        nunchuk1.print();
        //se mueve hacia abajo pero con el metodo que se avanzan cinco pasos
        nunchuk1.muchAdvance('D');
        //compruebo los datos correctos
        nunchuk1.print();
    }
}


