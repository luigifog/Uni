package uo.mp.util;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import uo.mp.vehicles.file.InvalidFormatException;

public class Console {
	
	private static PrintStream out = System.out;
	private static InputStream in = System.in;
	
	private static Scanner keyboard = new Scanner( in );

	public static void setOut(PrintStream out) {
		Console.out = out;
	}

	public static void setIn(InputStream in) {
		Console.in = in;
		keyboard = new Scanner( Console.in );
	}

	public static String readString(String msg) {
		out.println( msg + ": ");
		return keyboard.next();
	}

	public static int readInteger(String msg) throws InvalidFormatException{
		int n=0;
		out.println( msg + ": ");
		try {
			 n=keyboard.nextInt();
			 }
		catch (InputMismatchException e) {
			throw new InvalidFormatException(e.getMessage());
		}
		return n;
	}

	public static void println(String msg) {
		out.println( msg );
	}

	public static void printf(String fmt, Object... params) {
		out.printf( fmt, params );
	}

}
