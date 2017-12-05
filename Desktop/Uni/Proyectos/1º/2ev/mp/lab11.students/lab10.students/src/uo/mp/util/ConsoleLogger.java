package uo.mp.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ConsoleLogger implements Logger {

	@Override
	public void log(String msg) {
		try {
			PrintWriter salida=new PrintWriter(new FileWriter("log.txt",true));
			salida.write(msg);
			salida.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
