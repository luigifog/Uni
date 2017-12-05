//package p2Grafos;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//public class GraphTest {
//	public final static double inf=Double.POSITIVE_INFINITY;
//
//	@Test
//	public void testExistNode() {
//		//creamos la matriz vacia
//		Graph<Integer> gr=new Graph<Integer>(3);
//		assertEquals(0,gr.devuelveNumNodes());
//		//añadimos nodo
//		gr.addNode(1);
//		assertEquals(1,gr.devuelveNumNodes());
//		//caso1, favorable
//		assertTrue(gr.existNode(1));
//		//caso 2, no existe nodo
//		assertFalse(gr.existNode(3));
//	}
//	
//	@Test
//	public void testExistEdge() {
//		//creamos la matriz vacia
//		Graph<Integer> gr=new Graph<Integer>(5);
//		//añadimos nodos y una arista
//		gr.addNode(1);
//		gr.addNode(3);
//		gr.addNode(2);
//		gr.addEdge(1, 3, 3);
//		//caso1, favorable
//		assertTrue(gr.existEdge(1, 3));
//		//caso2, no existe el nodo source
//		assertFalse(gr.existEdge(4, 3));
//		//caso3, no existe el nodo target
//		assertFalse(gr.existEdge(1, 5));
//		//caso 4, no existe ninguno de los nodos
//		assertFalse(gr.existEdge(15, 5));
//		//caso 5, no hya arista entre esos nodos
//		assertFalse(gr.existEdge(1, 2));
//	}
//
//	@Test
//	public void testAddNode() {
//		//creamos la matriz
//		Graph<Integer> gr=new Graph<Integer>(3);
//		assertEquals(0,gr.devuelveNumNodes());
//		//añadimos un nodo
//		gr.addNode(1);
//		assertEquals(1,gr.devuelveNumNodes());
//		//intentamos añadir un nodo ya exsitente
//		assertEquals(-1,gr.addNode(1));
//		assertEquals(1,gr.devuelveNumNodes());
//		//intentamos añadir un nodo que se salga de la matriz
//		assertEquals(0,gr.addNode(20));
//		assertEquals(2,gr.devuelveNumNodes());
//		//a�ado otro nodo para llenar la matriz
//		assertEquals(0,gr.addNode(2));
//		//compruebo que no se puede sobrepasar el vector nodes
//		assertEquals(-1,gr.addNode(4));
//		
//		//entiendo que el caso favorable funciona correctamente, pues ya he añadido en varios test un nodo
//	}
//	
//	@Test
//	public void testAddEdge()
//	{
//		//creamos la matriz vacia
//		Graph<Integer> gr=new Graph<Integer>(5);
//		//añadimos nodos y una arista
//		gr.addNode(1);
//		gr.addNode(3);
//		gr.addNode(2);
//		gr.addEdge(1, 3, 3);
//		//caso 1, añadimos un edge ya existente
//		assertEquals(-1,gr.addEdge(1, 3, 2));
//		//caso 2, añadimos un edge con peso negativo
//		assertEquals(-1,gr.addEdge(2, 3, -2));
//		//caso 3, añadimos un edge con peso 0
//		assertEquals(-1,gr.addEdge(2, 3, 0));
//		//caso 4, añadimos un edge ya existente y de peso negativo	
//		assertEquals(-1,gr.addEdge(1, 3, -2));
//		//caso 5, añadimos un edge con los parametros incorrectos
//		assertEquals(-1,gr.addEdge(-1, 3, 2));
//		
//	}
//	@Test
//	public void testRemoveNode()
//	{
//		//creamos la matriz vacia
//				Graph<Integer> gr=new Graph<Integer>(5);
//		//añadimos nodos y una arista
//				gr.addNode(1);
//				gr.addNode(3);
//				gr.addNode(2);
//				gr.addEdge(1, 3, 3);
//				assertTrue(gr.existNode(1));
//		//caso1, favorable
//				assertEquals(0,gr.removeNode(1));
//				assertEquals(2,gr.devuelveNumNodes());
//				assertFalse(gr.existNode(1));
//		//caso2, se intenta borrar de nuevo el nodo ya borrado
//				assertEquals(-1,gr.removeNode(1));
//				assertEquals(2,gr.devuelveNumNodes());
//				assertFalse(gr.existNode(1));
//		//caso3, no existe el nodo a borrar
//				assertEquals(-1,gr.removeNode(6));
//	}
//	@Test
//	public void testRemoveEdge()
//	{
//		//creamos la matriz vacia
//		Graph<Integer> gr=new Graph<Integer>(5);
//		//añadimos nodos y una arista
//			gr.addNode(1);
//			gr.addNode(3);
//			gr.addNode(2);
//			gr.addEdge(1, 3, 3);
//			assertTrue(gr.existEdge(1, 3));
//		//caso1, favorable
//			assertEquals(0,gr.removeEdge(1, 3));
//			assertFalse(gr.existEdge(1, 3));
//		//caso2, se intenta borrar de nuevo la arsita anterior
//			assertEquals(-1,gr.removeEdge(1, 3));
//		//caso3, no existe la arista a borrar
//			assertEquals(-1,gr.removeEdge(2, 3));
//	}
//	/**
//	 * Test para dijsktra, con el grafo identico al del ejercicio
//	 */
//	@Test
//	public void testDjsktra()
//	{
//		//creo el grafo
//		Graph<Integer> gr=new Graph<Integer>(6);
//		//a�ado nodos
//		gr.addNode(0);
//		gr.addNode(1);
//		gr.addNode(2);
//		gr.addNode(3);
//		gr.addNode(4);
//		gr.addNode(5);
//		
//		//a�ado las aristas
//		gr.addEdge(0, 1, 11);
//		gr.addEdge(0, 5, 5);
//		gr.addEdge(0, 3, 13);
//		gr.addEdge(1, 4, 9);
//		gr.addEdge(2, 1, 1);
//		gr.addEdge(2, 3, 2);
//		gr.addEdge(3, 4, 3);
//		gr.addEdge(4, 2, 12);
//		gr.addEdge(5, 1, 4);
//		gr.addEdge(5, 4, 54);
//		//creo arrays, con os resultados que deberian dar desde cada nodo de comienzo
//		double []dij0= {0,9,28,13,16,5};
//		double []dij1= {inf,0,21,23,9,inf};
//		double []dij2= {inf,1,0,2,5,inf};
//		double []dij3= {inf,16,15,0,3,inf};
//		double []dij4= {inf,13,12,14,0,inf};
//		double []dij5= {inf,4,25,27,13,0};
//		//guardo en arrays los resultados de ejecutar el metodo creado
//		double[]pr0=gr.dijkstra(0);
//		double[]pr1=gr.dijkstra(1);
//		double[]pr2=gr.dijkstra(2);
//		double[]pr3=gr.dijkstra(3);
//		double[]pr4=gr.dijkstra(4);
//		double[]pr5=gr.dijkstra(5);
//		//comparo los arrays
//		for(int i=0;i<dij0.length;i++)
//		{
//			assertEquals(dij0[i],pr0[i],0);
//			assertEquals(dij1[i],pr1[i],0);
//			assertEquals(dij2[i],pr2[i],0);
//			assertEquals(dij3[i],pr3[i],0);
//			assertEquals(dij4[i],pr4[i],0);
//			assertEquals(dij5[i],pr5[i],0);
//		}
//
//		System.out.println(gr.toString());
//		
//	}
//	
//	/**
//	 * Test para dijsktra, con el grafo identico al del ejercicio salvo por una arista del 4 al 0 de peso 10
//	 */
//	@Test
//	public void testDjsktraMod()
//	{
//		//creo el grafo
//		Graph<Integer> gr=new Graph<Integer>(6);
//		//a�ado nodos
//		gr.addNode(0);
//		gr.addNode(1);
//		gr.addNode(2);
//		gr.addNode(3);
//		gr.addNode(4);
//		gr.addNode(5);
//		
//		//a�ado las aristas
//		gr.addEdge(0, 1, 11);
//		gr.addEdge(0, 5, 5);
//		gr.addEdge(0, 3, 13);
//		gr.addEdge(1, 4, 9);
//		gr.addEdge(2, 1, 1);
//		gr.addEdge(2, 3, 2);
//		gr.addEdge(3, 4, 3);
//		gr.addEdge(4, 2, 12);
//		gr.addEdge(4, 0, 10);
//		gr.addEdge(5, 1, 4);
//		gr.addEdge(5, 4, 54);
//		//creo arrays, con os resultados que deberian dar desde cada nodo de comienzo
//		
//		double []dij0= {0,9,28,13,16,5};
//		double []dij1= {19,0,21,23,9,24};
//		double []dij2= {15,1,0,2,5,20};
//		double []dij3= {13,16,15,0,3,18};
//		double []dij4= {10,13,12,14,0,15};
//		double []dij5= {23,4,25,27,13,0};
//		//guardo en arrays los resultados de ejecutar el metodo creado
//		double[]pr0=gr.dijkstra(0);
//		double[]pr1=gr.dijkstra(1);
//		double[]pr2=gr.dijkstra(2);
//		double[]pr3=gr.dijkstra(3);
//		double[]pr4=gr.dijkstra(4);
//		double[]pr5=gr.dijkstra(5);
//		assertEquals(-1,gr.dijkstra(30)[0],0);
//		//comparo los arrays
//		for(int i=0;i<dij0.length;i++)
//		{
//			assertEquals(dij0[i],pr0[i],0);
//			assertEquals(dij1[i],pr1[i],0);
//			assertEquals(dij2[i],pr2[i],0);
//			assertEquals(dij3[i],pr3[i],0);
//			assertEquals(dij4[i],pr4[i],0);
//			assertEquals(dij5[i],pr5[i],0);
//		}	
//	}
	/*
	 * debe devolver infinito y la arista a a�adir no tiene peso 10
	 */
	package p2Grafos; 
	  
	import static org.junit.Assert.*; 
	  
	import org.junit.Test; 
	  
	import evalNestor.EvalGraph; 
	  
	public class GraphTest { 
	    private static final boolean T = true; 
	    private static final boolean F = false;  
	    private static final double Inf = Double.POSITIVE_INFINITY; 
	  
	    @Test 
	    public void testAddNode() { 
	        EvalGraph<Character> g=new EvalGraph<Character>(0); 
	        for (char c='A';c<(char)('z'+1); c++) { 
	            assertEquals("A�adiendo nodo: "+c+" ",-1,g.addNode(c)); 
	        } 
	        assertEquals(-1,g.addNode(null)); 
	  
	        g=new EvalGraph<Character>(1); 
	        assertEquals(-1,g.addNode(null)); 
	         
	        g=new EvalGraph<Character>(10); 
	        for (char c='A';c<(char)('z'+1); c++) { 
	            if (c<'A'+10){ 
	                assertEquals("A�adiendo nodo: "+c+" ",0,g.addNode(c)); 
	                assertEquals("A�adiendo nodo: "+c+" ",-1,g.addNode(c)); 
	            } 
	            else 
	                assertEquals("A�adiendo nodo: "+c+" ",-1,g.addNode(c)); 
	  
	        } 
//	        System.out.println(g.toString()); 
	  
	        g=new EvalGraph<Character>(100); 
	        for (char c='0';c<(char)('0'+100); c++) { 
	            if (c<'0'+100){ 
	                assertEquals("A�adiendo nodo: "+c+" ",0,g.addNode(c)); 
	                assertEquals("A�adiendo nodo: "+c+" ",-1,g.addNode(c)); 
	            } 
	            else 
	                assertEquals("A�adiendo nodo: "+c+" ",-1,g.addNode(c)); 
	  
	        } 
//	        System.out.println(g.toString()); 
	  
	    } 
	  
	    @Test 
	    public void testDijkstra() { 
	        EvalGraph<Integer> g=new EvalGraph<Integer>(100, 
	                new Integer[]{0,1,2,3,4,5,6,7,8,9}, 
	                new boolean[][]{ 
	            {T,T,T,T,T,T,T,T,T,T}, 
	            {T,T,T,T,T,T,T,T,T,T}, 
	            {T,T,T,T,T,T,T,T,T,T}, 
	            {T,T,T,T,T,T,T,T,T,T}, 
	            {T,T,T,T,T,T,T,T,T,T}, 
	            {T,T,T,T,T,T,T,T,T,T}, 
	            {T,T,T,T,T,T,T,T,T,T}, 
	            {T,T,T,T,T,T,T,T,T,T}, 
	            {T,T,T,T,T,T,T,T,T,T}, 
	            {T,T,T,T,T,T,T,T,T,T}}, 
	                new double[][]{ 
	                {1,1,1,1,1,1,1,1,1,1}, 
	                {1,1,1,1,1,1,1,1,1,1}, 
	                {1,1,1,1,1,1,1,1,1,1}, 
	                {1,1,1,1,1,1,1,1,1,1}, 
	                {1,1,1,1,1,1,1,1,1,1}, 
	                {1,1,1,1,1,1,1,1,1,1}, 
	                {1,1,1,1,1,1,1,1,1,1}, 
	                {1,1,1,1,1,1,1,1,1,1}, 
	                {1,1,1,1,1,1,1,1,1,1}, 
	                {1,1,1,1,1,1,1,1,1,1}}, 
	                null,null); 
	         
	        double[][] resultado = new double[][]{ 
	            {0,1,1,1,1,1,1,1,1,1}, 
	            {1,0,1,1,1,1,1,1,1,1}, 
	            {1,1,0,1,1,1,1,1,1,1}, 
	            {1,1,1,0,1,1,1,1,1,1}, 
	            {1,1,1,1,0,1,1,1,1,1}, 
	            {1,1,1,1,1,0,1,1,1,1}, 
	            {1,1,1,1,1,1,0,1,1,1}, 
	            {1,1,1,1,1,1,1,0,1,1}, 
	            {1,1,1,1,1,1,1,1,0,1}, 
	            {1,1,1,1,1,1,1,1,1,0}}; 
	             
	        for (int i=0;i<10;i++) 
	            assertArrayEquals("Origen en nodo: "+i+" ",resultado[i],g.dijkstra(i),0.001); 
	  
	        g=new EvalGraph<Integer>(100, 
	                new Integer[]{0,1,2,3,4,5,6,7,8,9}, 
	                new boolean[][]{ 
	            {T,T,F,F,F,F,F,F,F,F}, 
	            {F,T,T,T,T,T,T,T,T,T}, 
	            {F,T,T,T,T,T,T,T,T,T}, 
	            {F,T,T,T,T,T,T,T,T,T}, 
	            {F,T,T,T,T,T,T,T,T,T}, 
	            {F,T,T,T,T,T,T,T,T,T}, 
	            {F,T,T,T,T,T,T,T,T,T}, 
	            {F,T,T,T,T,T,T,T,T,T}, 
	            {F,T,T,T,T,T,T,T,T,T}, 
	            {F,T,T,T,T,T,T,T,T,T}}, 
	                new double[][]{ 
	                {2,1,1,1,1,1,1,1,1,1}, 
	                {2,2,1,1,1,1,1,1,1,1}, 
	                {1,1,2,1,1,1,1,1,1,1}, 
	                {1,1,1,2,1,1,1,1,1,1}, 
	                {1,1,1,1,2,1,1,1,1,1}, 
	                {1,1,1,1,1,2,1,1,1,1}, 
	                {1,1,1,1,1,1,2,1,1,1}, 
	                {1,1,1,1,1,1,1,2,1,1}, 
	                {1,1,1,1,1,1,1,1,2,1}, 
	                {1,1,1,1,1,1,1,1,1,2}}, 
	                null,null); 
	        resultado = new double[][]{ 
	            {0,1,2,2,2,2,2,2,2,2}, 
	            {Inf,0,1,1,1,1,1,1,1,1}, 
	            {Inf,1,0,1,1,1,1,1,1,1}, 
	            {Inf,1,1,0,1,1,1,1,1,1}, 
	            {Inf,1,1,1,0,1,1,1,1,1}, 
	            {Inf,1,1,1,1,0,1,1,1,1}, 
	            {Inf,1,1,1,1,1,0,1,1,1}, 
	            {Inf,1,1,1,1,1,1,0,1,1}, 
	            {Inf,1,1,1,1,1,1,1,0,1}, 
	            {Inf,1,1,1,1,1,1,1,1,0}}; 
	             
	        for (int i=0;i<10;i++) 
	            assertArrayEquals("Origen en nodo: "+i+" ",resultado[i],g.dijkstra(i),0.001); 
	  
	        g=new EvalGraph<Integer>(100, 
	                new Integer[]{0,1,2,3,4,5,6,7,8,9}, 
	                new boolean[][]{ 
	            {T,T,F,F,F,F,F,F,F,F}, 
	            {F,T,T,T,T,T,T,T,T,T}, 
	            {F,T,T,T,T,T,T,T,T,T}, 
	            {F,T,T,T,T,T,T,T,T,T}, 
	            {F,T,T,T,T,T,T,T,T,T}, 
	            {F,T,T,T,T,T,T,T,T,T}, 
	            {F,T,T,T,T,T,T,T,T,T}, 
	            {F,T,T,T,T,T,T,T,T,T}, 
	            {F,T,T,T,T,T,T,T,T,T}, 
	            {T,T,T,T,T,T,T,T,T,T}}, 
	                new double[][]{ 
	                {2,1,1,1,1,1,1,1,1,1}, 
	                {2,2,1,1,1,1,1,1,1,1}, 
	                {1,1,2,1,1,1,1,1,1,1}, 
	                {1,1,1,2,1,1,1,1,1,1}, 
	                {1,1,1,1,2,1,1,1,1,1}, 
	                {1,1,1,1,1,2,1,1,1,1}, 
	                {1,1,1,1,1,1,2,1,1,1}, 
	                {1,1,1,1,1,1,1,2,1,1}, 
	                {1,1,1,1,1,1,1,1,2,1}, 
	                {1,1,1,1,1,1,1,1,1,2}}, 
	                null,null); 
	        resultado = new double[][]{ 
	            {0,1,2,2,2,2,2,2,2,2}, 
	            {2,0,1,1,1,1,1,1,1,1}, 
	            {2,1,0,1,1,1,1,1,1,1}, 
	            {2,1,1,0,1,1,1,1,1,1}, 
	            {2,1,1,1,0,1,1,1,1,1}, 
	            {2,1,1,1,1,0,1,1,1,1}, 
	            {2,1,1,1,1,1,0,1,1,1}, 
	            {2,1,1,1,1,1,1,0,1,1}, 
	            {2,1,1,1,1,1,1,1,0,1}, 
	            {1,1,1,1,1,1,1,1,1,0}}; 
	             
	        for (int i=0;i<10;i++) 
	            assertArrayEquals("Origen en nodo: "+i+" ",resultado[i],g.dijkstra(i),0.001); 
	    } 
	     
	    @Test 
	    public void testRemoveNode(){ 
	        EvalGraph<String> g=new EvalGraph<String>(5, 
	                new String[]{"cero","uno","dos","tres","cuatro"}, 
	                new boolean[][]{ 
	            {T,F,F,F,F}, 
	            {T,T,F,F,F}, 
	            {T,T,T,F,F}, 
	            {T,T,T,T,F}, 
	            {T,T,T,T,T}}, 
	                new double[][]{ 
	                {1,0,0,0,0,0}, 
	                {2,1,0,0,0,0}, 
	                {3,4,1,0,0,0}, 
	                {5,6,7,1,0,0}, 
	                {8,9,10,11,1}}, 
	                null,null); 
	  
	        assertEquals(0,g.removeNode("cero")); 
	        assertEquals("VECTOR NODOS\ncuatro\tuno\tdos\ttres\t\n\nMATRIZ ARISTAS\nT\tT\tT\tT\t\nF\tT\tF\tF\t\nF\tT\tT\tF\t\nF\tT\tT\tT\t\n\nMATRIZ PESOS\n1\t9\t10\t11\t\n-\t1\t-\t-\t\n-\t4\t1\t-\t\n-\t6\t7\t1\t\n" 
	                , g.toString()); 
	        assertEquals(-1,g.removeNode("cero")); 
	         
	        assertEquals(0,g.removeNode("tres")); 
	        assertEquals("VECTOR NODOS\ncuatro\tuno\tdos\t\n\nMATRIZ ARISTAS\nT\tT\tT\t\nF\tT\tF\t\nF\tT\tT\t\n\nMATRIZ PESOS\n1\t9\t10\t\n-\t1\t-\t\n-\t4\t1\t\n" 
	                , g.toString()); 
	        assertEquals(-1,g.removeNode("tres")); 
	         
	        assertEquals(0,g.removeNode("uno")); 
	        assertEquals("VECTOR NODOS\ncuatro\tdos\t\n\nMATRIZ ARISTAS\nT\tT\t\nF\tT\t\n\nMATRIZ PESOS\n1\t10\t\n-\t1\t\n" 
	                , g.toString()); 
	        assertEquals(-1,g.removeNode("uno")); 
	         
	        assertEquals(0,g.removeNode("dos")); 
	        assertEquals("VECTOR NODOS\ncuatro\t\n\nMATRIZ ARISTAS\nT\t\n\nMATRIZ PESOS\n1\t\n" 
	                , g.toString()); 
	        assertEquals(-1,g.removeNode("dos")); 
	  
	        assertEquals(0,g.removeNode("cuatro")); 
	        assertEquals("VECTOR NODOS\n\n\nMATRIZ ARISTAS\n\nMATRIZ PESOS\n" 
	                , g.toString()); 
	        assertEquals(-1,g.removeNode("cuatro")); 
	    } 
	} 
	 
