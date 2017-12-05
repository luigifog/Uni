package sesion3_dome_inicial;

import java.io.PrintStream;

public class DVD extends Item  {
	private String director;
	public DVD(String theTitle, String theDirector, int time,double price) {
		super(theTitle,time,price);
		if(theTitle==null||theDirector==null||time<=0)
		{
			throw new RuntimeException("datos no correctos");
		}
		setDirector(theDirector);
	}

	protected void setDirector(String director) {
		if (director != null)
			this.director = director;
		else
		{
			throw new RuntimeException("datos no correctos");
		}
	}

	public String getDirector() {
		return this.director;
	}
	
	public void print(PrintStream out) {
		out.println("DVD: " + getTitle() + " (" + getPlayingTime() + " mins)");
		if (getOwn()) {
			out.println("*");
		} else {
			out.println();
		}
		out.println(" " + getDirector());
		out.println(" " + getComment());
	}
	public  String getResponsable()
	{
		return getDirector();
	}
	public void setBasePrice()
	{
		
	}
	
	public String toString() 
	{
		String cad="";
		cad+=super.getTitle() + " (" + getPlayingTime() + " mins)";
		if (getOwn()) {
			cad+="*";
		} else {
			cad+="\n";
		}
		cad+=getDirector();
		cad+=getComment();
		
		return cad;
	}
	
	public boolean borrowable()
	{
		return false;
	}
}
