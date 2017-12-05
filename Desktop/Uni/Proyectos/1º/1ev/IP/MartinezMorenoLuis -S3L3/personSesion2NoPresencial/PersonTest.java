

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
        assertEquals(, person2.getAge());
        person2.setAge(2);
        assertEquals(16, person2.getCriticalAge());
        person2.setAge(18);
        assertEquals(47, person2.getCriticalAge());
        person2.setAge(30);
        assertEquals(35, person2.getCriticalAge());
        person2.setAge(65);
        assertEquals(0, person2.getCriticalAge());
        person2.setAge(88);
        assertEquals(23, person2.getCriticalAge());
        assertEquals(88-LUIS-4-MARTINEZ_8, person2.getHashCode());
    }
}

