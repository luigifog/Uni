package planeTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Person;
import model.SeatManager;

public class SeatManagerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testBookSeat() {
		SeatManager sm=new SeatManager();
		Person p1=new Person("a",17);
		//Se puede sentar sin problemas
		assertTrue(sm.bookSeat(p1,0,0));

		//No se puede sentar porque el sitio esta ocupado
		assertFalse(sm.bookSeat(p1,0,0));
		//se intenta sentar fuera de la matriz
		try
		{
			sm.bookSeat(p1,200,1);
			fail();
		}
		catch(RuntimeException i)
		{
			assertEquals("datos no validos",i.getMessage());
		}
		//se intenta sentar fuera de la matriz
		try
		{
			sm.bookSeat(p1,-200,1);
			fail();
		}
		catch(RuntimeException i)
		{
			assertEquals("datos no validos",i.getMessage());
		}
		//se intenta sentar fuera de la matriz
		try
		{
			sm.bookSeat(p1,2,221);
			fail();
		}
		catch(RuntimeException i)
		{
			assertEquals("datos no validos",i.getMessage());
		}
		//se intenta sentar fuera de la matriz
		try
		{
			sm.bookSeat(p1,2,-11);
			fail();
		}
		catch(RuntimeException i)
		{
			assertEquals("datos no validos",i.getMessage());
		}
		
	}

	@Test
	public void findPassengersByAgeTest()
	{
		SeatManager sm1=new SeatManager();
		SeatManager sm2=new SeatManager();
		SeatManager sm3=new SeatManager();
		SeatManager sm4=new SeatManager();
		Person p1=new Person("a",50);
		Person p2=new Person("b",5);
		
		//Todo lleno de gente en el rango
		for(int i=0; i<10;i++)
		{
			sm1.rellenar(p1, i, 0);
			sm1.rellenar(p1,i, 3);
		}
		assertEquals(20,sm1.findPassengerByAge(20, 70).size());
		//Todo sin gente en el rango
		
		for(int i=0; i<10;i++)
		{
			sm2.rellenar(p2, i, 0);
			sm2.rellenar(p2,i, 3);
		}
		assertEquals(0,sm2.findPassengerByAge(20, 70).size());
		//Gente mezclada
		
		for(int i=0; i<10;i++)
		{
			sm3.rellenar(p2, i, 0);
			sm3.rellenar(p2,i, 3);
		}
		
			sm3.rellenar(p1, 1, 0);
			sm3.rellenar(p1, 2, 0);
			sm3.rellenar(p1, 1, 3);
			sm3.rellenar(p1, 2, 3);
			assertEquals(4,sm3.findPassengerByAge(20, 70).size());
		//parametros incorrectos
			assertNull(sm4.findPassengerByAge(-1, 3));
			assertNull(sm4.findPassengerByAge(1, -3));
			assertNull(sm4.findPassengerByAge(1000, 3));
			assertNull(sm4.findPassengerByAge(1, 30000));
		}
	}
