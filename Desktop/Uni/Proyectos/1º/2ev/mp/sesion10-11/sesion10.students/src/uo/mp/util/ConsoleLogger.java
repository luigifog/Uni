package uo.mp.util;

public class ConsoleLogger implements Logger {

	@Override
	public void log(String msg) {
		System.err.println( msg );
	}

}
