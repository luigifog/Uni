package uo.mp.vehicles.file;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class FileUtil {

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
		if(inFileName==null){
			throw new IllegalArgumentException("fichero no valido");
		}
		if(inFileName.length()==0){
			throw new IllegalArgumentException("fichero no valido");
		}
		BufferedReader entrada=new BufferedReader(new FileReader(inFileName));
		while(entrada.ready()){
			String linea=entrada.readLine();
			res.add(linea);
		}
		entrada.close();
		
		return res;
	}

	public void saveToFile(String outFileName, List<String> lines) throws IOException {
		BufferedWriter salida=new BufferedWriter(new FileWriter(outFileName));
		for(String s:lines){
			salida.write(s);
		}
		salida.close();
		//throw new NotYetImplementedException();
	}
	}


