package test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.CD;
import main.algorithm;


public class algorithmTest {
	private CD cd1;
	private CD cd2;
	private CD cd3;
	@Before
	public void setUp() throws Exception {
		cd1=new CD("Alive","Papa Roach",70,4,15.0);
		cd2=new CD("Come Together","Beatles",70,4,10.0);
		cd3 = new CD("Idestructible","Disturbed",40,9,1980.0);
	}

	@Test
	public void testSearch() {
		Object[]objetos={cd1,cd2,3,"Hola"};
		Object[]strings={"Luis","patata","Hola"};
		Object[]ints={10,20,30};
		Object[]cds={cd1,cd2,cd3};
	assertEquals(0,algorithm.search(objetos, cd1));
	assertEquals(2,algorithm.search(strings, "Hola"));
	assertEquals(1,algorithm.search(ints, 20));
	assertEquals(0,algorithm.search(cds, cd1));
	assertEquals(2,algorithm.search(cds, cd3));
	}

}
