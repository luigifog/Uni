package simulacro;

import java.io.PrintStream;
import java.util.ArrayList;

public class WebServer {

	private ArrayList <File>files;
	
	public WebServer(String name,String url,int byteSize)
	{
		files=new ArrayList<File>();
	}
	
	public void fileToAdd(File file)
	{
		files.add(file);
	}
	
	
	public void listFiles(PrintStream out)
	{
		for(int i=0;i<files.size();i++)
		{
			out.println(files.get(i).toString());
		}
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
			if(files.get(i) instanceof Multimedia)
			{
				if(((Multimedia) files.get(i)).isParado()==true||((Multimedia) files.get(i)).isParado()==false)
				{
					out.println(files.get(i));
				}
			}
		}
	}

		public File findByUrl(String url)
		{
			for(int i=0;i<files.size();i++)
			{
				if(files.get(i).getUrl().equals(url))
				{
					return files.get(i);
				}
			}
			return null;
		}
	
	public void play(String url, PrintStream out)
	{
		File f=findByUrl(url);
		if(f instanceof Multimedia)
		{
			Multimedia m=(Multimedia) f;
			if(m.isParado()==false)
			{
				m.play(out);
			}
		}
		
		
	}
	

	
}

