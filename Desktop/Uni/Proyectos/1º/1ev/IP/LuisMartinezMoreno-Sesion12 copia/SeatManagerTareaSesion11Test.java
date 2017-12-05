

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
public class SeatManagerTareaSesion11Test
{
    /**
     * prueba del método que devuelve el número de asientos libres que hay en una determinada fila del avión
     */
    @Test
    public void testNumberOfFreeSeats()
    {
        // caso 1 todos los asientos están libres
        SeatManager seatManager1 = new SeatManager(5,5);
       for(int i=0;i<9;i++)
        assertEquals(6,seatManager1.numberOfFreeSeats(i));
        
        // caso 2 algunos están ocupados, por ejemplo los 4 primeros de la fila 0
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
            seatManager1.numberOfFreeSeats(99);
            fail();
        }
        catch (RuntimeException e)
        {
            assertEquals("Número de fila incorrecta",e.getMessage());
        }
    }
    
    @Test
    public void testRelease()
    {
        // caso 1 libero una persona sentada
        SeatManager seatManager1 = new SeatManager(5,5);
        Person person1 = new Person();
        seatManager1.bookSeat(person1,2,2);
        assertEquals(5,seatManager1.numberOfFreeSeats(2));
        seatManager1.release(2,2);
        assertEquals(6,seatManager1.numberOfFreeSeats(2));
        
        
        
        // caso 2 libero un asiento que no tiene persona
        try
        { 
            seatManager1.release(2,2);
            fail();
       }
       catch(RuntimeException e)
       {
            assertEquals("la fila ya estaba vacia",e.getMessage());
       }
        
        // caso 2 libero una fila incorrecta
         try{
            seatManager1.release(12,3);
            fail();
        }
        catch (RuntimeException e)
        {
            assertEquals("datos no correctos",e.getMessage());
        }
        
        
        // caso 3 libero una columna incorrecta
        try{
            seatManager1.release(2,333);
            fail();
        }
        catch (RuntimeException e)
        {
            assertEquals("datos no correctos",e.getMessage());
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
         try{
             seatManager1.oldestPassenger();
             fail();
            }
         catch(RuntimeException e)
         {
             assertEquals("datos no correctos",e.getMessage());
         }
         
         
        
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
        
    }
    
    @Test
    public void testChildrenPassenger()
    {
        //caso 1 Avion vacio, no hay pasajeros
        SeatManager seatManager1=new SeatManager(5,5);
        assertEquals(0,seatManager1.childrenPassenger().size());
        //caso 2 hay solo una persona y es un niño
        seatManager1.bookSeat(new Person(4),0,2);
        assertEquals(1,seatManager1.childrenPassenger().size());
        //caso 3 avion lleno, con niños y adultos
        
        //caso 4 avion lleno y no hay niños
    }
    
    @Test
    public void testAdultsInWindow()
    {
        SeatManager seatManager1=new SeatManager(5,5);
        //caso 1 todo lleno de adultos en la ventanilla
        for(int i=0;i<seatManager1.getFirstRows() + seatManager1.getStandardRows();i++)
       {
        seatManager1.bookSeat(new Person(20),i,0);
        seatManager1.bookSeat(new Person(20),i,5);
       } 
       assertEquals(20,seatManager1.adultsInWindow());
       
       
       //caso 2 ningun adulto, todo niños en ventanilla
       for(int i=0;i<seatManager1.getFirstRows() + seatManager1.getStandardRows();i++)
       {
        seatManager1.bookSeat(new Person(2),i,0);
        seatManager1.bookSeat(new Person(2),i,5);
        assertEquals(0,seatManager1.adultsInWindow());
       }
       
       //caso 3 nadie en las ventanillas
       for(int i=0;i<seatManager1.getFirstRows() + seatManager1.getStandardRows();i++)
       {
        seatManager1.bookSeat(null,i,0);
        seatManager1.bookSeat(null,i,5);
        assertEquals(0,seatManager1.adultsInWindow());
       }
       
       //caso 4 adultos, menores y espacios vacios
       seatManager1.bookSeat(new Person(20),0,0);
       seatManager1.bookSeat(new Person(2),1,5);
       seatManager1.bookSeat(new Person(20),3,0);
       seatManager1.bookSeat(new Person(2),3,5);
       seatManager1.bookSeat(new Person(20),5,0);
       seatManager1.bookSeat(new Person(2),7,5);
       seatManager1.bookSeat(new Person(20),8,0);
       seatManager1.bookSeat(new Person(2),4,5);
        
       assertEquals(4,seatManager1.adultsInWindow());
       //caso 5 adultos en una fila de ventanillas, y en la otra niños
       for(int i=0;i<seatManager1.getFirstRows() + seatManager1.getStandardRows();i++)
       {
        seatManager1.bookSeat(new Person(20),i,0);
        seatManager1.bookSeat(new Person(2),i,5);
        assertEquals(10,seatManager1.adultsInWindow());
       }
       
       
    }


}


