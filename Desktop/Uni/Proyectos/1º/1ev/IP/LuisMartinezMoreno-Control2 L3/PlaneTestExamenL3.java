

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
public class PlaneTestExamenL3
{
      
  
    /**
     * Pruebas constructor con parámetro la palanca
     */
    @Test
    public void testConstructorWithPalancaPosicionIntermedia()
    {
        // caso 1 la palanca está en posición intermedia
        Plane plane1 = new Plane(3);
        
        assertEquals(3, plane1.getEngineLever(),0.1);
        assertNotNull(plane1.getMotor());
        assertEquals(27000,plane1.getMotor().getRevolutions(),0.1);
        
//         assertnotNull(plane1.getPilot());
//         assertEquals(Plane.DEFAULT_IDENTIFIER,plane1.getIdentifier());
//         assertEquals(Plane.DEFAULT_FUEL, plane1.getFuel());
//         assertEquals(0,plane1.getXPos());
//         assertEquals(0,plane1.getYPos());
//         assertEquals(1,plane1.setXSpeed());
//         assertEquals(1,plane1.getXSpeed());
  }
        @Test
         public void testConstructorWithPalancaPosicionMinima()
         {
        // caso 2 palanca en posición mínima
        Plane plane1 = new Plane(0);
        assertEquals(0, plane1.getEngineLever(),0.1);
        assertNotNull(plane1.getMotor());
        assertEquals(0,plane1.getMotor().getRevolutions(),0.1);
        }
        
         @Test
         public void testConstructorWithPalancaPosicionMaxima()
         {
        // caso 3 palanca en posición máxima
        Plane plane1 = new Plane(5);
        assertEquals(5, plane1.getEngineLever(),0.1);
        assertNotNull(plane1.getMotor());
        assertEquals(45000,plane1.getMotor().getRevolutions(),0.1);
    }
        
        @Test
        public void testConstructorWithPalancaDebajoLimiteInferior()
    {
        // caso 4 palanca debajo del límite inferior
        Plane plane1 = new Plane(-1);
        assertEquals(0, plane1.getEngineLever(),0.1);
        assertNotNull(plane1.getMotor());
        assertEquals(0,plane1.getMotor().getRevolutions(),0.1);
    }
     @Test
     public void testConstructorWithPalancaEncimaLimiteSuperior()
    {
        
        // caso 5 palanca encima de límite superior
        Plane plane1 = new Plane(10);
        assertEquals(0, plane1.getEngineLever(),0.1);
        assertNotNull(plane1.getMotor());
        assertEquals(0,plane1.getMotor().getRevolutions(),0.1);
    
    }
    
    @Test
    public void testMoveEngineLeverEstandoMinimoMueveIntermedia ()
    {
        // caso 1 estando en mínimo se mueve a posición intermedia
           
        Plane plane1 = new Plane();
        
        assertEquals(18000, plane1.moveEngineLever(2),0.1);
        assertEquals(2,plane1.getEngineLever(),0.1);
        assertEquals(18000, plane1.getMotor().getRevolutions(),0.1);
    }
    
    @Test
    public void testMoveEngineLeverEstandoMinimoMueveLimite ()
    {
        
        // caso 3 estando en 0 se mueve a posición límite 
        Plane  plane1 = new Plane();
        
        assertEquals(45000, plane1.moveEngineLever(5),0.1);
        assertEquals(5,plane1.getEngineLever(),0.1);
        assertEquals(45000, plane1.getMotor().getRevolutions(),0.1);
    }
    @Test
    public void testMoveEngineLeverEstandoIntermediaMueveSuperior ()
    {
        
        // caso 4 estando en posición intermedia se mueve a otra superior
        Plane  plane1 = new Plane(2);
        
        assertEquals(36000, plane1.moveEngineLever(4),0.1);
        assertEquals(4,plane1.getEngineLever(),0.1);
        assertEquals(36000, plane1.getMotor().getRevolutions(),0.1);
    }
    @Test
    public void testMoveEngineLeverEstandoIntermeidaMueveInferior ()
    {
        
        // caso 5 estando en posición intermedia se mueve a otra inferior
        Plane  plane1 = new Plane(4);
        
        assertEquals(9000, plane1.moveEngineLever(1),0.1);
        assertEquals(1,plane1.getEngineLever(),0.1);
        assertEquals(9000, plane1.getMotor().getRevolutions(),0.1);
    }
    @Test
    public void testMoveEngineLeverEstandoLimiteSuperiorMueveLimiteInferior ()
    {
        
        // caso 6 estando en límite superior se mueve a límite inferior
        Plane  plane1 = new Plane(5);
        
        assertEquals(0, plane1.moveEngineLever(0),0.1);
        assertEquals(0,plane1.getEngineLever(),0.1);
        assertEquals(0, plane1.getMotor().getRevolutions(),0.1);
        
    }
    @Test
    public void testMoveEngineLeverEstandoIntermediaMueveIncorrectaArriba ()
    {
        // caso 7 estando en posicón intermedia se mueve a posición incorrecta por arriba
        Plane  plane1 = new Plane(3);
        
        assertEquals(-1, plane1.moveEngineLever(6),0.1);
        assertEquals(3,plane1.getEngineLever(),0.1);
        assertEquals(27000, plane1.getMotor().getRevolutions(),0.1);
    }
        
    @Test
    public void testMoveEngineLeverEstandoIntermediaMueveIncorrectaAbajo ()
    {
        // caso 7 estando en posicón intermedia se mueve a posición incorrecta por abajo
        Plane  plane1 = new Plane(3);
        
        assertEquals(-1, plane1.moveEngineLever(-6),0.1);
        assertEquals(3,plane1.getEngineLever(),0.1);
        assertEquals(27000, plane1.getMotor().getRevolutions(),0.1);
    }
}
