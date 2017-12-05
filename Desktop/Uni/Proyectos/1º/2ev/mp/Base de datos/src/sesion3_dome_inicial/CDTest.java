package sesion3_dome_inicial;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CDTest {
	private CD cd;
	private CD cd2;
	@Before
	public void setUp()
	{
		cd = new CD("Come Together","Beatles",70,4,10.0);
		cd2 = new CD("Idestructible","Disturbed",40,9,1980.0);
	}

	@Test
	public void testSetTitle() {
		
		// caso 1 introduzco un nombre correcto
		cd.setTitle("Yellow Submarine");
		assertEquals("Yellow Submarine",cd.getTitle());
		// caso 2 introduzco null
		cd.setTitle(null);
		assertEquals("Yellow Submarine",cd.getTitle());
	}

	@Test
	public void testSetOwn() {
		
		// caso 1 estando en false paso a true
		cd.setOwn(true);
		assertEquals(true,cd.getOwn());
		// caso 2 estando en true paso a false
		cd.setOwn(false);
		assertEquals(false,cd.getOwn());
	}

	@Test(expected=RuntimeException.class)
	public void testSetArtist() {
		
		// caso 1 introduzco un nombre correcto
		cd.setArtist("John Lennon");
		assertEquals("John Lennon",cd.getArtist());
		// caso 2 introduzco null
		cd.setArtist(null);
		assertEquals("John Lennon",cd.getArtist());
	}

	@Test(expected=RuntimeException.class)
	public void testSetNumberOfTracks() {
		
		// caso 1 introduzco un n�mero de pistas correcto
		cd.setNumberOfTracks(50);
		assertEquals(50,cd.getNumberOfTracks());
		// caso 2 introduzco pistas negativas
		cd.setNumberOfTracks(-10);
		assertEquals(50,cd.getNumberOfTracks());
	}

	@Test(expected=RuntimeException.class)
	public void testSetPlayingTime() {
		
		// caso 1 introduzco un tiempo correcto (positivo)
		cd.setPlayingTime(10);
		assertEquals(10,cd.getPlayingTime());
		// caso 2 introduzco tiempo negativo
		cd.setPlayingTime(-1);
		assertEquals(10,cd.getPlayingTime());
	}

	@Test(expected=RuntimeException.class)
	public void testSetComment() {
		
		// caso 1 introduzco un comentario correcto
		cd.setComment("Excelente");
		assertEquals("Excelente",cd.getComment());
		// caso 2 introduzco null
		cd.setComment(null);
		assertEquals("Excelente",cd.getComment());
	}
	@Test
	public void testToString()
	{
		assertEquals(cd.toString(),"Come Together (4 mins)" +"\n"+"Beatles70");
		assertEquals(cd2.toString(),"Idestructible (9 mins)"+"\n"+"Disturbed40");
	}
}
