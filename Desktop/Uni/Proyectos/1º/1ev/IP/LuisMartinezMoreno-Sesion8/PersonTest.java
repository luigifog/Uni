

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PersonTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PersonTest
{
    /**
     * Default constructor for test class PersonTest
     */
    public PersonTest()
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
    public void PersonTest()
    {
        Person person2 = new Person();

        person2.setAge(2);
        assertEquals(16, person2.getCriticalAge());
        person2.setAge(18);
        assertEquals(47, person2.getCriticalAge());
        person2.setAge(30);
        assertEquals(35, person2.getCriticalAge());
        person2.setAge(65);
        assertEquals(0, person2.getCriticalAge());
        person2.setAge(88);
        
    }

    @Test
    public void futureTest()
    {
        Person person1 = new Person();
        //probando numeros negativos
        //el primer negativo dio el resultado esperado
        assertEquals(-1, person1.goToTheFuture(-4));
        //el segundo negativo dio el resultado esperado
        assertEquals(-1, person1.goToTheFuture(-1));
        //el tercer negativo  dio el resultado esperado
        assertEquals(-1, person1.goToTheFuture(200));
        // dio el resultado esperado
        assertEquals(2017, person1.goToTheFuture(1));
       // dio el resultado esperado
        assertEquals(2086, person1.goToTheFuture(70));
    }
}





