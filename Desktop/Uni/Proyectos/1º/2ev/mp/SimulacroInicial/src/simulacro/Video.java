package simulacro;

import java.io.PrintStream;

public class Video extends File implements Multimedia {
public static enum VideoFormat{	AVI, MPEG4,	DIVX }
	
	private String title;
	private VideoFormat format;
	private boolean parado=false;
	
	public Video(String name, String url, int size, String title, VideoFormat format) {
		super(name,url,size);
		setTitle(title);
		setFormat(format);
	}

	public String getTitle() {
		return title;
	}

	public boolean isParado() {
		return parado;
	}

	public void setParado(boolean parado) {
		this.parado = parado;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public VideoFormat getFormat() {
		return format;
	}

	public void setFormat(VideoFormat format) {
		this.format = format;
	}
	
	public void stop(PrintStream out)
	{
		if(isParado()==false)
		{
			setParado(true);
			out.print("video parado");
		}
	}
	
	public void play(PrintStream out)
	{
		if(isParado()==true)
		{
			setParado(false);
			out.print("video reproduciendose");
		}
	}
	
	

}
