

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SeatManagerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SeatManagerTest
{
   @Test
   public void testBookSeat()
   {
       //caso1 resreva en asiento vacio
       SeatManager sm1=new SeatManager(4,5); //matriz con 9 filas y 6 columnas
       Person person1 =new Person();
       assertTrue(sm1.bookSeat(person1,2,3));
       assertEquals(person1,sm1.getPerson(2,3));
       
       //caso 2 reserva en asiento ocupado
       Person person2=new Person();
       assertFalse(sm1.bookSeat(person2,2,3));
       assertEquals(person1,sm1.getPerson(2,3));
       
       //caso 3 asiento con persona null
       try{sm1.bookSeat(null,2,3);
           fail();
        }
        catch( RuntimeException e)
        {
            assertEquals("Parametro incorrecto",e.getMessage());
       //caso 4 hacemos reserva en fila fuera de limites(menor que lim inf)
       //caso 5 hacemos reserva en fila mayor que el limite superior
       //caso 6 hacemos reserva en columna que limite inf
       //caso 7 reserva en columna mayor que limite sup
   }
}
  
/**
 * The test class SeatManagerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SeatManagerTareaSesion11Test
{
    



/**
 * prueba del método que devuelve el número de asientos libres que hay en una determinada fila del avión
 */
@Test
public void testNumberOfFreeSeats()
{
    // caso 1 todos los asientos están libres
    SeatManager seatManager1 = new SeatManager(4,5);
   for(int i=0;i<9;i++)
    assertEquals(6,seatManager1.numberOfFreeSeats(i));
    
    // caso 2 algunos están ocupados por ejemplo los 4 primeros de la fila 0
    for (int j=0; j< 4; j++ )
        seatManager1.bookSeat(new Person(),0,j);
    assertEquals(2, seatManager1.numberOfFreeSeats(0));    
    // caso 3 todos están ocupados
    for (int i=0; i < seatManager1.getFirstRows() + seatManager1.getStandardRows(); i++)   // lleno la matriz
        for (int j=0; j< 6; j++ )
            seatManager1.bookSeat(new Person(),i,j);
            
    for (int i=0; i < seatManager1.getFirstRows() + seatManager1.getStandardRows();i++)  // comprueba en todas las filas
         assertEquals(0, seatManager1.numberOfFreeSeats(i)); 
         
    // caso 4 fila de entrada incorrecta < 0
    try{
        seatManager1.numberOfFreeSeats(-3);
        fail();
    }
    catch (RuntimeException e)
    {
        assertEquals("Número de fila incorrecta",e.getMessage());
    }   
    
      // caso 5 fila de entrada incorrecta > máximo
    try{
        seatManager1.numberOfFreeSeats(seatManager1.getFirstRows()+seatManager1.getStandardRows());
        fail();
    }
    catch (RuntimeException e)
    {
        assertEquals("Número de fila incorrecta",e.getMessage());
    }
}




@Test
public void testReleaseSeat()
{
    // caso 1 libero una persona sentada
    SeatManager seatManager1 = new SeatManager(5,5);
    Person person1 = new Person();
    seatManager1.bookSeat(person1,2,2);
    assertEquals(person1,seatManager1.releaseSeat(2,2));
    
    // caso 2 libero un asiento que no tiene persona
     assertEquals(null,seatManager1.releaseSeat(2,2));
    
    // caso 2 libero una fila incorrecta
     try{
        seatManager1.releaseSeat(12,3);
        fail();
    }
    catch (RuntimeException e)
    {
        assertEquals("Parámetros incorrectos",e.getMessage());
    }
    
    
    // caso 3 libero una columna incorrecta
    try{
        seatManager1.releaseSeat(2,333);
        fail();
    }
    catch (RuntimeException e)
    {
        assertEquals("Parámetros incorrectos",e.getMessage());
    }
    
    
}


/**
 * test oldestPassenger
 */
@Test
public void testOldestPasenger()
{
    // caso 1 no hay pasajeros debe devolver null
     SeatManager seatManager1 = new SeatManager(5,5);
     assertNull(seatManager1.oldestPassenger());
     
    
    // caso 2 el pasajero más viejo es el primero de varios
    seatManager1.bookSeat(new Person (80), 0,0);
    seatManager1.bookSeat(new Person (40), 1,2);
    seatManager1.bookSeat(new Person (20), 3,4);
    seatManager1.bookSeat(new Person (18), 6,3);
    
    Person oldest = seatManager1.oldestPassenger();
    
    assertEquals(80,oldest.getAge());
    
    // caso 3 el pasajero más viejo es el último
    seatManager1 = new SeatManager(5,5);
    seatManager1.bookSeat(new Person (80), 9,5);
    seatManager1.bookSeat(new Person (40), 1,2);
    seatManager1.bookSeat(new Person (20), 3,4);
    seatManager1.bookSeat(new Person (18), 6,3);
    
     oldest = seatManager1.oldestPassenger();
    
    assertEquals(80,oldest.getAge());
    
    // caso 4 hay varios pasajeros igual de viejos (devuelve el primero)
    
    seatManager1 = new SeatManager(5,5);
    seatManager1.bookSeat(new Person (80), 9,5);
    seatManager1.bookSeat(new Person (80), 1,2);
    seatManager1.bookSeat(new Person (80), 3,4);
    seatManager1.bookSeat(new Person (80), 0,0);
    
    seatManager1.bookSeat(new Person (40), 2,2);
    
     oldest = seatManager1.oldestPassenger();
    
    assertEquals(80,oldest.getAge());
    assertEquals(oldest,seatManager1.getSeats()[0][0]);
}
}}
