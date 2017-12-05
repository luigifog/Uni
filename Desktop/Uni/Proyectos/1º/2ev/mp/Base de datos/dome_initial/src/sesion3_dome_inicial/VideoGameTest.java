package sesion3_dome_inicial;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class VideoGameTest {

	private VideoGame vg;
	private VideoGame vg2;
	@Before
	public void setUp()
	{
		vg = new VideoGame("Battlefield","EA",false,3,null,75.99);
		vg2=new VideoGame("Red dead redemption","RockStar",true,5,Platform.Nintendo,47.2);
	}
	
	@Test
	public void setPlatformTest() {
		
		//caso 1 no tiene plataforma
		assertNull(vg.getP());
		//XBox
		vg.setP(Platform.Xbox);
		assertEquals(Platform.Xbox,vg.getP());
		//PlayStation
		vg.setP(Platform.PlayStation);
		assertEquals(Platform.PlayStation,vg.getP());
		//Nintendo
		vg.setP(Platform.Nintendo);
		assertEquals(Platform.Nintendo,vg.getP());
	}
	@Test
	public void setAuthorTest()
	{
		//Caso 1, hay autor
		assertEquals("EA",vg.getAuthor());
		//caso 2 no hay autor
		vg.setAuthor(null);
		assertNull(vg.getAuthor());
	}
	@Test
	public void setPlayers()
	{
		//caso1 hay jugadores
		assertEquals(3,vg.getPlayers());
		//caso2 hay 0 jugadores
		try
		{
			vg.setPlayers(0);
		}
		catch(RuntimeException e)
		{
			assertEquals("datos no correctos",e.getMessage());
		}
		//caso 3 hay -3 jugadores
		try
		{
			vg.setPlayers(-3);
		}
		catch(RuntimeException e)
		{
			assertEquals("datos no correctos",e.getMessage());
		}
		//caso 4 compruebo que sigue habiendo el mismo num de jugadores que antes
		assertEquals(3,vg.getPlayers());
	}
	@Test
	public void testToString()
	{
		assertEquals(vg.toString(),"Battlefield (0 mins)"+"\n"+"EA");
		assertEquals(vg2.toString(),"Red dead redemption (0 mins)"+"\n"+"RockStar");
	}
}
