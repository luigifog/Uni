package simulacro;

import java.io.PrintStream;

public class Audio extends File implements Multimedia{
public static enum AudioFormat{ MP3, WMA }
	
	private String author;
	private AudioFormat format;
	private boolean parado=false;
	
	public Audio(String name, String url, int size,String author, AudioFormat format) {

		super(name,url,size);
		setAuthor(author);
		setFormat(format);
		}

	public String getAuthor() {
		return author;
	}
	
	public boolean isParado() {
		return parado;
	}

	private void setParado(boolean parado) {
		this.parado = parado;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public AudioFormat getFormat() {
		return format;
	}

	public void setFormat(AudioFormat format) {
		this.format = format;
	}
	
	public void stop(PrintStream out)
	{
		if(isParado()==false)
		{
			setParado(true);
			out.print("audio parado");
		}
	}
	
	public void play(PrintStream out)
	{
		if(isParado()==true)
		{
			setParado(false);
			out.print("audio reproduciendose");
		}
	}
	
	
	
	
	
	

}
