

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BoardTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BoardTest
{
    @Test
    public void testPlaceShip()
    {
        Ship ship=new Ship();
        Ship ship1=new Ship();
        Board board=new Board(5,5);
        //se coloca el barco
        assertTrue(board.placeShip(ship,1));
        //no hay barco
        try
        {
            board.placeShip(null,1);
        }
        catch(RuntimeException e)
        {
            assertEquals("datos no correctos",e.getMessage());
        }
        
        //la fila es mayor que el tamaño
        try
        {
            board.placeShip(ship,99);
        }
        catch(RuntimeException e)
        {
            assertEquals("datos no correctos",e.getMessage());
        }
        
        //ya hay un barco en la posicion en la misma fila
        assertTrue(board.placeShip(ship1,0));
        
        for(int i=0;i<5;i++)
        {
            board.placeShip(ship,i);
        
        }
        
        //toda la fila ocupada
        board.rellenar();
        assertFalse(board.placeShip(ship1,0));
    }
    
    @Test
    public void testBomb()
    {
        Ship shipSub=new  Ship(100,true,"A");
        Ship ship=new Ship(50,false,"B");
        Board board=new Board(5,5);
        //se destruye el barco con potencia igual a resistencia
        board.placeShip(ship,0);
        assertTrue(board.bombShip(0,0,50));
        //se destruye el barco con potencia mayor a resistencia
        board.placeShip(ship,0);
        assertTrue(board.bombShip(0,0,500));
        
        //no hay barco en la posicion
        assertFalse(board.bombShip(1,1,30));
        
        //el barco es submarino
        board.placeShip(shipSub,0);
        assertFalse(board.bombShip(0,0,2));
        
        //la resistencia del barco es mayor
        board.placeShip(ship,1);
        assertFalse(board.bombShip(1,0,2));
    }
}
