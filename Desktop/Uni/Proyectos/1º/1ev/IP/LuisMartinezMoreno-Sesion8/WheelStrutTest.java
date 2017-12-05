

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
   @Test
   public void testConstructorWithParam()
   {
       //caso 1 creo un puntal con numero de ruedas correcto
       WheelStrut wheelStrut1= new WheelStrut(10);
       assertTrue(wheelStrut1.getDeployed());
       assertEquals(10, wheelStrut1.size());
       Wheel wheel1;
       for (int i=0; i<wheelStrut1.size(); i++)
       {
           wheel1=wheelStrut1.getWheel(i);
           assertEquals(WheelStrut.NORMAL_PRESSURE,wheel1.getPressure());
           assertEquals(WheelStrut.NORMAL_PRESSURE,wheel1.getMaxPressure());
       }
       //caso 2 creo puntal con numero de ruedas menor que  1(incorrecta)
       try{
        wheelStrut1=new WheelStrut(-10);
        fail();
       }
       catch(RuntimeException e)
       {
        assertEquals("Numero de ruedas incorrecto", e.getMessage());
        }
       //caso 3 creo puntal con un numero de ruedas mayopr que 20
       try{
        wheelStrut1=new WheelStrut(22);
        fail();
       }
       catch(RuntimeException e)
       {
        assertEquals("Numero de ruedas incorrecto", e.getMessage());
        }
       //caso 4 creo puntal con 1 rueda
       
       //caso5 creo puntal con 20 ruedas
   }
}

