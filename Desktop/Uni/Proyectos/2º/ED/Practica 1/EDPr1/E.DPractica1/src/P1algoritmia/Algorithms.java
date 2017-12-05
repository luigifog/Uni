package P1algoritmia;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Algorithms {

	private static final long SLEEP_TIME = 5;
//Funcion que manda esperar al ordenador un tiempo SLEEP_TIME
	public static void doNothing() {
		try {
			Thread.sleep(SLEEP_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

//Funcion linear de espera al ordenador
	public void linear (int n) {
   for (int i= 0; i< n; i++) {
	   doNothing();
	   	}
   }
	//Funcion cuadratica de espera al ordenador
	public void cuadratica(int n)
	{
		 for (int i = 0; i < n; i++){
			 for (int j = 0; j < n; j++){
		            doNothing();
			 }
		 }
	}
	//Funcion cubica de espera al ordenador
	public void cubica(int n) {
	    for (int i = 0; i < n; i++)
	    {
	    	for (int j = 0; j < n; j++)
	    	{
	            for (int k = 0; k < n; k++)
	            {
	                doNothing();
	            }
	        }
	    }
	}
//Funcion recursiva para hallar cualquien factorial
	public long factorial(int n)
	{
		if(n==0)
		{
			return 1;
		}
		else {
			return n*factorial(n-1);
		}
	}
	//Funcion recursiva para hallar cualquien potencia
	public long pow2Iter (int n) {
		long r=2;
		if(n==0)
		{
			return 1;
		}
		for(int i=0;i<=n;i++)
		{
			r=r*r;
		}
		return r;
		}

	//Funcion recursiva para hallar potencias
	public long pow2Rec(int n){
		if (n == 0)
	        return 1;
	    else
	        return (2 * pow2Rec(n-1));
	}
	//Funcion recursiva para hallar potencias
	public long pow2Rec2(int n){
		 if (n == 0)
		        return 1;
		    else if (n == 1)
		    {
		        return 2;
		    }
		    else
		    {
		    	return (pow2Rec(n-1)+pow2Rec2(n));
		    }
	}
	//Funcion recursiva para hallar potencias
	public long pow2Rec3(int n) {
			    if (n == 0)
			        return 1;
			    else if (n%2 == 0)
			        return (pow2Rec3(n/2)*pow2Rec3(n/2));
			    else
			        return (2*pow2Rec3(n/2)*pow2Rec3(n/2));
			}
	
	public long pow2Rec4(int n) {
		long a = 0;
		if (n == 0)
			return 1;
		a = pow2Rec4(n/2);
		if (n % 2 == 0)
			return (a*a);
		else
			return (2*a*a);
			}
	}

	

