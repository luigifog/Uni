package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Conecta4;

public class TestConecta4 {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPlay() {
		Conecta4 c4=new Conecta4();
		c4.rellenar();
		//caso 1 se pueden colocar en todas las columnas

			assertTrue(c4.play(1));
		//caso 2 no se puede colocar en ninguna columna
		for(int i=0;i<6;i++)
		{
			for(int j=0;j<7;j++)
			{
				c4.rellenarSum(i, j);
			}
		}
		assertFalse(c4.play(1));
			
		//caso 3 la columna que se pasa es menor que 0
		try
		{
			c4.play(-3);
			fail();
		}
		catch(RuntimeException i)
		{
			assertEquals("datos no correctos",i.getMessage());
		}
			//caso 4 la columna que se pasa es mayor que el limite
		try
		{
			c4.play(13);
			fail();
		}
		catch(RuntimeException i)
		{
			assertEquals("datos no correctos",i.getMessage());
		}
	}
	
	//PRUEBAS FINISHED
	@Test
	public void testFinished()
	{
		Conecta4 c4=new Conecta4();
		c4.rellenar();
		//Ganan los *
		for (int i=0;i<5;i++)
		{
			c4.rellenarAst(i,0);
		}
		assertTrue(c4.finished());
		//ganan los +
		for (int i=0;i<5;i++)
		{
			c4.rellenarSum(i, 0);;
		}
		assertTrue(c4.finished());
		//no gana nadie
		c4.rellenar();
		assertFalse(c4.finished());
		
	}
	public void testFinishedRow()
	{
		Conecta4 c4=new Conecta4();
		c4.rellenar();
		//Ganan los *
		for (int i=0;i<5;i++)
		{
			c4.rellenarAst(0,i);
		}
		assertTrue(c4.finished());
		//ganan los +
		for (int i=0;i<5;i++)
		{
			c4.rellenarSum(0,i);;
		}
		assertTrue(c4.finished());
		//no gana nadie
		c4.rellenar();
		assertFalse(c4.finished());
		
	}
	public void TestFinishedDiagonal()
	{
		Conecta4 c4=new Conecta4();
		c4.rellenar();
		//ganan los * en la diagonal principal
		for(int i=0;i<4;i++)
		{
			c4.rellenarSum(i,i);
		}
		for(int i=0;i<6;i++)
		{
			for (int j=0;j<7;j++)
			{
				assertTrue(c4.dpSum(i, j));
			}
		}
		//ganan la + en la diagonal principal
		for(int i=0;i<4;i++)
		{
			c4.rellenarAst(i,i);
		}
		for(int i=0;i<6;i++)
		{
			for (int j=0;j<7;j++)
			{
				assertTrue(c4.dpAst(i, j));
			}
		}
		//ganan los * en la otra direccion
		c4.rellenar();
		c4.rellenarAst(0, 6);
		c4.rellenarAst(1, 5);
		c4.rellenarAst(2, 4);
		c4.rellenarAst(3, 3);
		for(int i=0;i<6;i++)
		{
			for (int j=0;j<7;j++)
			{
				assertTrue(c4.dnAst(i, j));
			}
		}
		//ganan la + en la otra direccion
		c4.rellenar();
		c4.rellenarSum(0, 6);
		c4.rellenarSum(1, 5);
		c4.rellenarSum(2, 4);
		c4.rellenarSum(3, 3);
		for(int i=0;i<6;i++)
		{
			for (int j=0;j<7;j++)
			{
				assertTrue(c4.dnSum(i, j));
			}
		}
		//no gana nadie
		c4.rellenar();
		assertFalse(c4.isWinnerDiagonal());
	}
	public void testFinishedFull()
	{
		Conecta4 c4=new Conecta4();
		c4.rellenar();
		//todo vacio
		assertFalse(c4.fullBoard());
		//todo lleno de +
		for(int i=0;i<6;i++)
		{
			for (int j=0;j<7;j++)
			{
				c4.rellenarSum(i,j);
			}
		}
		assertTrue(c4.fullBoard());
		
		//todo lleno de *

		for(int i=0;i<6;i++)
		{
			for (int j=0;j<7;j++)
			{
				c4.rellenarAst(i,j);
			}
		}
		assertTrue(c4.fullBoard());
	}
	

}
