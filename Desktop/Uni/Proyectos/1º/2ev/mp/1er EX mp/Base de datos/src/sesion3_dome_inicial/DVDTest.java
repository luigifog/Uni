package sesion3_dome_inicial;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DVDTest {

	private DVD dvd;
	private DVD dvd2;
	
	@Before
	public void setUp()
	{
		dvd = new DVD("La guerra de las Galaxias","George Lucas",125,13.9);
		dvd2=new DVD("taxi Driver","Scorsese",139,20.0);
	}

	@Test
	public void testSetTitle() {
		
		// caso 1 introduzco un nombre correcto
		dvd.setTitle("Stars Wars");
		assertEquals("Stars Wars",dvd.getTitle());
		// caso 2 introduzco null
		dvd.setTitle(null);
		assertEquals("Stars Wars",dvd.getTitle());
	}
	
	@Test(expected=RuntimeException.class)
	public void testSetDirector() {
	
		// caso 1 introduzco un nombre correcto
		dvd.setDirector("Jorge Lucas");
		assertEquals("Jorge Lucas",dvd.getDirector());
		// caso 2 introduzco null
		dvd.setDirector(null);
		assertEquals("Jorge Lucas",dvd.getDirector());
	}
	
	@Test(expected=RuntimeException.class)
	public void testSetPlayingTime() {
		
		// caso 1 introduzco un tiempo correcto (positivo)
		dvd.setPlayingTime(126);
		assertEquals(126,dvd.getPlayingTime());
		// caso 2 introduzco tiempo negativo
		dvd.setPlayingTime(-1);
		assertEquals(126,dvd.getPlayingTime());
	}
	
	@Test
	public void testSetOwn() {
	
		// caso 1 estando en false paso a true
		dvd.setOwn(true);
		assertEquals(true,dvd.getOwn());
		// caso 2 estando en true paso a false
		dvd.setOwn(false);
		assertEquals(false,dvd.getOwn());
	}
	@Test(expected=RuntimeException.class)
	public void testSetComment() {
		
		// caso 1 introduzco un comentario correcto
		dvd.setComment("Excelente");
		assertEquals("Excelente",dvd.getComment());
		// caso 2 introduzco null
		dvd.setComment(null);
		assertEquals("Excelente",dvd.getComment());
	}
	@Test
	public void testToString()
	{
		assertEquals(dvd.toString(),"La guerra de las Galaxias (125 mins)"+"\n"+"George Lucas");
		assertEquals(dvd2.toString(),"taxi Driver (139 mins)"+"\n"+"Scorsese");
	}

}
