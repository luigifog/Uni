

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
    public void preuba_metodo_fly()
    {
        //Sin combustible
        Plane plane2 = new Plane();
        assertEquals(false, plane2.fly());
        //con combustible
        plane2.setFuel(1);
        assertEquals(true, plane2.fly());
        //cambiando la velocidad y la posicion
        plane2.setXPos(8);
        plane2.setYPos(8);
        plane2.setYPos(1);
        plane2.setXSpeed(1);
        plane2.setYSpeed(1);
        assertEquals(true, plane2.fly());
    }

    @Test
    public void moveEngineLeverTest()
    {
        Plane plane3 = new Plane(0);
        //minimo valor aceptado
        assertEquals(0.0, plane3.moveEngineLever(0), 0.1);
        assertEquals(0.0, plane3.getEngineLever(), 0.1);
        //valor intermedio de los aceptados
        assertEquals(27000.0, plane3.moveEngineLever(3), 0.1);
        assertEquals(3.0, plane3.getEngineLever(), 0.1);
        //valor maximo de los aceptados
        assertEquals(45000, plane3.moveEngineLever(5), 0.1);
        assertEquals(5.0, plane3.getEngineLever(), 0.1);
        //valor por debajo de los aceptados
        assertEquals(-1.0, plane3.moveEngineLever(-3), 0.1);
        assertEquals(null, plane3.getRevolutions());
        //valor por encima de los aceptados
        assertEquals(-1.0, plane3.moveEngineLever(7), 0.1);
        assertEquals(5.0, plane3.getEngineLever(), 0.1);
    }

    @Test
    public void SetEngineLeverTest()
    {
        Plane plane1 = new Plane();
        //Por debajo de los valores permitidos
        plane1.setEngineLever(-1);
        assertEquals(0.0, plane1.getEngineLever(), 0.1);
        //minimo de los valores permitidos
        plane1.setEngineLever(0);
        assertEquals(0.0, plane1.getEngineLever(), 0.1);
        //valor dentro del rango de los permitidos
        plane1.setEngineLever(2);
        assertEquals(2.0, plane1.getEngineLever(), 0.1);
        //maximo valor de los permitdos
        plane1.setEngineLever(5);
        assertEquals(5.0, plane1.getEngineLever(), 0.1);
        //valor por debajo de los permitidos, para ver que se conserva el valor antes puesta
        plane1.setEngineLever(-4);
        assertEquals(5.0, plane1.getEngineLever(), 0.1);
        //valor por encima de los permitidos
        plane1.setEngineLever(8);
        assertEquals(5.0, plane1.getEngineLever(), 0.1);
    }
    
}





