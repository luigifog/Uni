package simulacro;

import java.io.PrintStream;
import java.util.ArrayList;

public class WebServer {

	private ArrayList <File>files;
	
	public WebServer(String name,String url,int byteSize)
	{

	}
	
	public void fileToAdd(File file)
	{
		if(file==null)
		{
			throw new RuntimeException("no existe el archivo a añadir");
		}
		files.add(file);
	}
	
	
	public File listFiles()
	{
		for(int i=0;i<files.size();i++)
		{
			return files.get(i);
		}
		return null;
	}
	
	public int size() 
	{
		int cont=0;
		for(int i=0;i<files.size();i++)
		{
			cont +=files.get(i).getSize();
		}
		return cont;
	}
	
	public void listPlayableFilms(PrintStream out)
	{
		for(int i=0;i<files.size();i++)
		{
			if(((Multimedia) files.get(i)).isParado()==true||((Multimedia) files.get(i)).isParado()==false)
			{
				out.println(files.get(i));
			}
		}
	}

		public File findByUrl(String url)
		{
			for(int i=0;i<files.size();i++)
			{
				if(files.get(i).getUrl()==url)
				{
					return files.get(i);
				}
			}
			return null;
		}

	public void play(String url, PrintStream out)
	{
		if(((Multimedia) findByUrl(url)).isParado()==true);
			((Multimedia) findByUrl(url)).play(out);
		
	}

	
}

