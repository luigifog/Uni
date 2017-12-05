package main;




public class CD extends Item {
	private final static int taxCD=2;
	private String artist;
	private int numberOfTracks;
	public CD(String theTitle, String theArtist, int tracks, int time,double price) {
		super(theTitle,time,price);
		if(theTitle==null||theArtist==null||tracks<=0||time<=0)
		{
			throw new RuntimeException("datos no correctos");
		}
		setArtist(theArtist);
		setNumberOfTracks(tracks);
	}

	protected void setArtist(String artist) {
		if(artist==null)
		{
			throw new RuntimeException("datos no correctos");
		}
		if (artist != null)
			this.artist = artist;
	}
	
	protected void setNumberOfTracks(int numberOfTracks) {
		if(numberOfTracks<=0)
		{
			throw new RuntimeException("datos no corectos");
		}
		if (numberOfTracks > 0)
			this.numberOfTracks = numberOfTracks;
	}

	public String getArtist() {
		return this.artist;
	}
	
	public int getNumberOfTracks() {
		return this.numberOfTracks;
	}
	
	public String getResponsable()
	{
		return getArtist();
	}
	
	public void setBasePrice()
	{
		price= (price+taxCD);
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
		cad+=getArtist();
		cad+=getNumberOfTracks();
		cad+=getComment();
		
		return cad;
	}
}