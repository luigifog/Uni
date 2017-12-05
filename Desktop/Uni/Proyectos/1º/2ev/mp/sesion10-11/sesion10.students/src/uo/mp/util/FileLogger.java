package uo.mp.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import uo.mp.util.Logger;

public class FileLogger implements Logger {
	private static final String LOG_FILE = "lab11.log";
	private static final boolean APPEND = true;
	
	private PrintStream out; 
	
	public FileLogger() {
		try {
			out = new PrintStream( new FileOutputStream( LOG_FILE, APPEND ));
		} catch (FileNotFoundException e) {
			out = System.err;
			log("El fichero " + LOG_FILE + " no se puede abrir. System.err se usa en su lugar.");
		}
	}

	public void close() {
		if ( out != System.err ) out.close();
	}

	public void log(String msg) {
		out.println( msg );
	}

}
