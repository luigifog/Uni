package taller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import taller.Coche.Problema;

public class TallerTest {
	private Taller taller;
	private Camion cam1;
	private Camion cam2;
 	private Coche coche1;
 	private Coche coche2;
	private Moto moto1;
	private Moto moto2;

	@Before
	public void setUp()
	{
		taller=new Taller();
		cam1=new Camion("UO258273",false,500);
		cam2=new Camion("ih423hkk",true,672685);
		coche1=new Coche("h2bk343",false);
		coche2=new Coche("hv42bu234",true);
		moto1=new Moto("ugy423",false);
		moto2=new Moto("gbyi354byuk",true);

	
	}
	
	
	@Test
	public void RepararTest() {
		taller.add(cam1);
		taller.add(cam2);
		taller.add(coche1);
		taller.add(coche2);
		taller.add(moto1);
		taller.add(moto2);
		
		//Se repara sin problemas un camion
		taller.reparar("UO258273", null);
		assertTrue(taller.comprobarReparacion("UO258273"));
		//Se repara sin problemas un coche
		taller.reparar("h2bk343", null);
		assertTrue(taller.comprobarReparacion("h2bk343"));
		//Se repara sin problemas una moto
		taller.reparar("ugy423", null);
		assertTrue(taller.comprobarReparacion("ugy423"));
		//el vehiculo ya esta reparado
		
		try
		{
			taller.reparar("ih423hkk", null);
		}
		catch(RuntimeException e)
		{
			assertEquals(("parametro incorrecto"),e.getMessage());
		}
		

		//la matricula no existe
		
		try
		{
			taller.reparar("ihhkk", null);
		}
		catch(RuntimeException e)
		{
			assertEquals(("parametro incorrecto"),e.getMessage());
		}
		//no hay matricula
		try
		{
			taller.reparar(null, null);
		}
		catch(RuntimeException e)
		{
			assertEquals(("parametro incorrecto"),e.getMessage());
		}
	}

}
