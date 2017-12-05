package taller;

import static org.junit.Assert.*;

import org.junit.Test;

import taller.Moto.Tama�o;

public class MotoTest {

	private Moto moto1;
	private Moto moto2;
	@Test
	public void test() {
		moto1=new Moto("ugy423",false);
		moto2=new Moto("ugaay423",false);
		moto1.setTama�o(Tama�o.Peque�a);
		moto2.setTama�o(Tama�o.Grande);
		assertEquals(moto1.generateBill(),250+0,1);
		assertEquals(moto2.generateBill(),500+0,1);

	}

}
