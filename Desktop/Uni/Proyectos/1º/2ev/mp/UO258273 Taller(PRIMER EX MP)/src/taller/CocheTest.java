package taller;

import static org.junit.Assert.*;

import org.junit.Test;

import taller.Coche.Problema;

public class CocheTest {
	private Coche coche1;


	
	@Test
	public void test() {
	
		coche1=new Coche("h2bk343",false);

		coche1.setProblema(Problema.Motor);

		assertEquals(coche1.generateBill(),1000+0,1);

		
	}

}
