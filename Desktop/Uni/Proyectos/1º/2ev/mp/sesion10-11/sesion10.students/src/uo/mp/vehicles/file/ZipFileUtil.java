package uo.mp.vehicles.file;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;



public class ZipFileUtil {

	public List<String> loadFile(String inFileName) throws IOException {
		List<String> res = new LinkedList<>();
		/*
		res.add("car	1234ABC	307	110	5	Ford-Focus");
		res.add("motorbike	2345BCD	48	50	2	Honda"); 
		res.add("truck	3456CDE	1900	310	4	Pegaso	2	9500"); 
		res.add("car	4567DEF	307	140	3	Mercedes");
		res.add("motorbike	5678EFG	50	75	1	Yamaha"); 
		res.add("car	6789FGH	80	206	1	Renault-Twingo");
		res.add("motorbike	7890GHI	48	80	4	Suzuki");
		res.add("truck	8901HIJ	1300	150	7	Iveco	1	3500");*/

		BufferedReader entrada=new BufferedReader(new InputStreamReader(new FileInputStream(inFileName)));
		while(entrada.ready()){
			String linea=entrada.readLine();
			res.add(linea);
		}
		entrada.close();
	
		return res;
	}

	public void saveToFile(String outZippedFileName, List<String> lines) throws IOException {
		// TODO Auto-generated method stub
		BufferedWriter salida=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outZippedFileName)));
		for(String s:lines){
			salida.write(s);
		}
		salida.close();
		//throw new NotYetImplementedException();
	}

}
