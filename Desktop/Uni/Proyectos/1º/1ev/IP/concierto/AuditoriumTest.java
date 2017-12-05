

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AuditoriumTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AuditoriumTest

{

   

    

   @Test

   public void testSeekConcert()

   {

    // caso 1 buscar un concierto que existe el primero

      Auditorium auditorium = new Auditorium();

        // creo una lista de conciertos

        for (int i=1; i <= 10 ; i++)

        {

            String concertName = "concert" + i;

            Date date = new Date(2010,i,i);

            double price = 20 + i;

            auditorium.addConcert(concertName, date, price);

        }

        assertNotNull(auditorium.seekConcert("concert1"));

    

    // caso 2 buscar último concierto

      assertNotNull(auditorium.seekConcert("concert10"));

    

    

    // caso 3 buscar concierto intermedio

      assertNotNull(auditorium.seekConcert("concert4"));

    

    // caso 4 buscar concierto que no existe

      assertNull(auditorium.seekConcert("concert25"));

   

    // caso 5 buscar en lista vacía

     auditorium = new Auditorium();

     assertNull(auditorium.seekConcert("concert25"));

    }



    

  

    @Test

    public void testAddConcert()

    {

        // caso 1 añadir conciertos no repetidos (añado 10)

        Auditorium auditorium = new Auditorium();

        

        for (int i=1; i <= 10 ; i++)

        {

            String concertName = "concert" + i;

            Date date = new Date(i,i,2010);

            double price = 20 ;

            auditorium.addConcert(concertName, date, price);    

        } 

       

        assertEquals(10, auditorium.getNumberOfConcerts());

        for (int i=1; i <= 10 ; i++)

        {

            assertNotNull(auditorium.seekConcert("concert" + i));

        }

            

        

        // caso 2 añado un concierto de fecha repetida

        String concertName = "concert11";

        Date date = new Date(10,10,2010);   // concierto 10 tiene esta misma fecha

        double price = 99;

        

        auditorium.addConcert(concertName, date, price);

        // compruebo que no se ha añadido

        assertEquals(10, auditorium.getNumberOfConcerts());

        assertNull(auditorium.seekConcert("concert11"));

        

        

        // caso 3 añado un concierto con parámetro nombre incorrecto incorrectos

        try{

            auditorium.addConcert(null, date , 25 );

            fail();

        }

        catch (RuntimeException e)

        {

            assertEquals("Parámetro para addConcert incorrecto", e.getMessage());

        }

        

        // caso 4 añado concierto con parámetro fecha incorrecta

        try{

            auditorium.addConcert("concert20",null  , 25 );

            fail();

        }

        catch (RuntimeException e)

        {

            assertEquals("Parámetro para addConcert incorrecto", e.getMessage());

        }

        

        // caso 5 añado concierto con parámetro precio incorrecto

        try{

            auditorium.addConcert("concert20", date , -25 );

            fail();

        }

        catch (RuntimeException e)

        {

            assertEquals("Parámetro para addConcert incorrecto", e.getMessage());

        }

        

    }

    

    @Test

    public void testRemoveConcerts()

    {

     

      Auditorium auditorium = new Auditorium();

        // creo una lista de 10 conciertos todos del año 2010 y uno de otro año

        for (int i=1; i <= 10 ; i++)

        {

            String concertName = "concert" + i;

            Date date = new Date(i,i,2010);

            double price = 20 + i;

            auditorium.addConcert(concertName, date, price);

        }

        auditorium.addConcert("concert11", new Date(23,11,2016),30);

        

        // caso 1 elimino  congresos de un año que no existe

        auditorium.removeConcerts(2015);

        assertEquals(11,auditorium.getNumberOfConcerts());

        

        

        

        // caso 3 doy como parámetro un año que no está en el rango

        try{

            auditorium.removeConcerts(-20);

            fail();

        }catch (RuntimeException e)

        {

                assertEquals("Año incorrecto",e.getMessage());

        }

         

         // caso 2 elimino congresos de un año que existe

        auditorium.removeConcerts(2010);

        assertEquals(1,auditorium.getNumberOfConcerts());

    }

   

}