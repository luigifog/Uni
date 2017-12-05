package taller;

import static org.junit.Assert.*;

import org.junit.Test;

import taller.Moto.Tamaño;

public class MotoTest {

	private Moto moto1;
	private Moto moto2;
	@Test
	public void test() {
		moto1=new Moto("ugy423",false);
		moto2=new Moto("ugaay423",false);
		moto1.setTamaño(Tamaño.Pequeña);
		moto2.setTamaño(Tamaño.Grande);
		assertEquals(moto1.generateBill(),250+0,1);
		assertEquals(moto2.generateBill(),500+0,1);

	}

}
