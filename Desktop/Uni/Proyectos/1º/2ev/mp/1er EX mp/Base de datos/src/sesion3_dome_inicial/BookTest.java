package sesion3_dome_inicial;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BookTest {

	public Book b1;
	public Book b2;
	@Before
	public void setUp() throws Exception {
	b1=new Book("Harry Potter","JK","85434-9214124","Anaya");
	b2=new Book("no  me gusta leer","yo","8888888-888","nadie");
	}

	@Test
	public void setAuthorTest() {
			b1.setAuthor("Pepe");
			assertEquals("Pepe",b1.getAuthor());
	}
	@Test
	public void prestarTest()
	{
		b1.setPrestado(false);
		b1.prestar();
		assertTrue(b1.isPrestado());
	}
	@Test
	public void devolverTest()
	{
		b1.setPrestado(false);
		b1.prestar();
		b1.devolver();
		assertFalse(b1.isPrestado());
	}

}
