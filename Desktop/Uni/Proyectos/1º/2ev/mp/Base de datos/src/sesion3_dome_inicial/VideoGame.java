package sesion3_dome_inicial;

import java.io.PrintStream;

public class VideoGame extends Item {

	private String author;
	private int players;
	private Platform p;

	public VideoGame(String title, String author, boolean gotIt, int players, Platform p,double price) {
		super(title, 0,price);
		setAuthor(author);
		setPlayers(players);
		this.p = p;
	}

	public Platform getP() {
		return p;
	}

	public void setP(Platform p) {
		this.p = p;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setPlayers(int newPlayers) {
		if (newPlayers <= 0) {
			throw new RuntimeException("datos no correctos");
		}
		players = newPlayers;
	}

	public int getPlayers() {
		return players;
	}

	public String getResponsable() {
		return author;
	}

	public int getPlayingTime() {
		return 0;
	}

	public void print(PrintStream out) {
		out.print("VideoGame: " + getTitle() + "(" + getPlayers() + " jugadores");
		if (getOwn()) {
			out.println("*");
		} else {
			out.println();
		}
		out.println(" " + getAuthor());
		out.println(" " + getComment());
	}
	public void setBasePrice()
	{
		price=(price+(price*0.1));
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
		cad+=getAuthor();
		cad+=getComment();
		
		return cad;
	}
	
	public boolean borrowable()
	{
		return false;
	}
}
