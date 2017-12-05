package sesion08.collections;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArrayListTest {
private List list;

@Before
public void setUp()
{
	list = new ArrayList();
}
	

@Test 
public void testAddObject(){
	//caso 1:a�ado un objeto
	Object o=new Object();
	list.add(o);
	assertEquals(1, list.size());
	//caso 2:a�ado un objeto null
	try{
	list.add(null);
	}
	catch(Exception e){
		assertEquals("parametros incorrectos", e.getMessage());
	}
}
@Test
public void testContains(){
	//caso1:busco un objeto
	Object a=new Object();
	list.add(a);
	assertEquals(true,list.contains(a));
	//caso 2:busco un null
			try{
				list.remove(null);
				}
				catch(Exception e){
					assertEquals("parametros incorrectos", e.getMessage());
				}
}
@Test
public void testRemoveObject(){
	//caso 1:borro un objeto
	Object a=new Object();
	list.add(a);
	assertEquals(true,list.remove(a));
	assertEquals(0, list.size());
	//caso 2:borro un null
	try{
		list.remove(null);
		}
		catch(Exception e){
			assertEquals("parametros incorrectos", e.getMessage());
		}
}
@Test
public void testSize(){
	//caso1:no hay elementos
	assertEquals(0,list.size());
	//caso2:a�ado un elemento
	Object a=new Object();
	list.add(a);
	assertEquals(1,list.size());
	//caso3:a�ado otro elemento
	Object o=new Object();
	list.add(o);
	assertEquals(2,list.size());		
}
@Test
public void testIsEmpty(){
	//caso1:no hay nada
	assertEquals(true,list.isEmpty());
	//caso2:a�ado un objeto
	Object o=new Object();
	list.add(o);
	assertEquals(false,list.isEmpty());
}
@Test
public void testClear(){
	//caso1:no hay nada
}
@Test
public void testAddIndex(){
	//caso1:a�ado 1 objetos
	Object o=new Object();
	list.add(0, o);
	assertEquals(1,list.size());
	//caso2:a�ado en pos invalida
	Object e=new Object();
	try{
		list.add(4,e);
		fail();
	}
	catch(Exception ex){
		assertEquals("parametros incorrectos",ex.getMessage());
	}
	//caso3:pos invalida inferior
	Object t=new Object();
	try{
		list.add(-1,t);
		fail();
	}
	catch(Exception ex){
		assertEquals("parametros incorrectos",ex.getMessage());
	}
}


}
