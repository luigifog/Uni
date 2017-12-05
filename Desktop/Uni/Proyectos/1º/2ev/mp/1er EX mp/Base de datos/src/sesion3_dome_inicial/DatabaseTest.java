package sesion3_dome_inicial;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DatabaseTest {
	private Database database;
	private CD cd;
	private DVD dvd;
	private VideoGame vg;
	private Book b1;
	private Book b2;

	@Before
	public void setUp()
	{
		database=new Database();
		cd=new CD("Alive","Papa Roach",70,4,15.0);
		dvd=new DVD("StarWars","George Lucas",130,12.5);
		vg=new VideoGame("Battlefield","EA",false,3,Platform.PlayStation,15.9);
		b1=new Book("Harry Potter","JK","85434-9214124","Anaya");
		b2=new Book("no  me gusta leer","yo","8888888-888","nadie");
		
	}
	@Test
	public void numberOfItemsOwned() {
		//caso 1 lista vacia
		assertEquals(0,database.numberOfItemsOwned());
		
		//caso 2 existen items pero ninguno tiene propietario
		database.add(cd);
		database.add(dvd);
		database.add(vg);
		database.add(b1);
		database.add(b2);
		assertEquals(0,database.numberOfItemsOwned());
		
		//caso 3 existem items y alguno tiene propietario
		cd.setOwn(true);
		vg.setOwn(true);
		b1.setOwn(true);
		assertEquals(3,database.numberOfItemsOwned());
		
	}

}
