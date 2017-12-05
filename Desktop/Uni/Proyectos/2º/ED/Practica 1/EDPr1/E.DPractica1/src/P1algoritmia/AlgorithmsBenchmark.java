package P1algoritmia;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

public class AlgorithmsBenchmark {

	//test basico que ejcuta un metodo
	public void test0 (String output) {
		FileWriter file = null;
		PrintWriter pw;

		try
		{
			file = new FileWriter(output);
			pw = new PrintWriter(file);

			pw.println("1; 10");
			pw.println("2; 20");
			pw.println("3; 30");
			pw.println("4; 40");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null)
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		} 
	}
	//test que ejecuta el metodo una serie de veces
	public void test1 (String output, int StartN, int EndN) {
		Algorithms alg=new Algorithms();
		FileWriter file = null;
		PrintWriter pw;
		try {
			file = new FileWriter(output);
			pw = new PrintWriter(file);
			
			long tInicial=0, tFinal=0;
	
			for(int n=StartN; n<EndN;n++)
			{
				tInicial = System.currentTimeMillis();
				alg.linear(n); // n varía desde StartN hasta EndN
				tFinal = System.currentTimeMillis();
				pw.println(n+";" +(tFinal-tInicial));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null)
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		} 
	}
		
	
	// como el 3, pero ejecutando times veces cada prueba del algoritmo con 
	public void testFinal (String output, int StartN, int EndN, int times, String nombreClase, String nombreMetodo)
	{
		Algorithms alg=new Algorithms();
		FileWriter file = null;
		PrintWriter pw;
		try {
			file = new FileWriter(output);
			pw = new PrintWriter(file);
			
			for (int workLoad = StartN; workLoad < EndN; workLoad++) {
				for(int time = 0; time < times;time++) {
			pw.println(testAlgorithm(nombreClase, nombreMetodo,times ));
			
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null)
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		} 
	}
	
	//test que calcula el tiempo que tarda en ejecutarse el método indicado, de la clase indicada, con el parámetro n

	public long testAlgorithm(String className, String methodName, int n) {
		long tInicial=0, tFinal=0;

		Class<?> cl;
		try {
			cl = Class.forName(className);
			Object o = cl.newInstance();
			Method m = cl.getMethod(methodName, int.class); 

			tInicial = System.currentTimeMillis();
			m.invoke(o, n);
			tFinal = System.currentTimeMillis();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return tFinal-tInicial;
	}
	
	
//	public void test3 (String output, int StartN, int EndN, String nombreClase, String nombreMetodo) {
//		Algorithms alg=new Algorithms();
//		FileWriter file = null;
//		PrintWriter pw;
//		Class<?> cl;
//		try {
//			file = new FileWriter(output);
//			pw = new PrintWriter(file);
//			
//			long tInicial=0, tFinal=0;
//	
//			for(int n=StartN; n<EndN;n++)
//			{
//				
//				cl = Class.forName(nombreClase);
//				Object o = cl.newInstance();
//				Method m = cl.getMethod(nombreMetodo, int.class); 
//				tInicial = System.currentTimeMillis();
//				m.invoke(o, n);
//				tFinal = System.currentTimeMillis();
//				pw.println(n+";" +(tFinal-tInicial));
//			}
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (file != null)
//				try {
//					file.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//		} 
//	}
	
	}






