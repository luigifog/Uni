package taller;

import static org.junit.Assert.*;

import org.junit.Test;

public class CamionTest {
	private Camion cam1;


	@Test
	public void test() {
		cam1=new Camion("UO258273",false,200);
		assertEquals(cam1.generateBill(),(20000)+0,1);

	}

}
