package main;

public abstract class Item {

	private String title;
	private int playingTime;
	private boolean gotIt;
	private String comment;
	protected double price;

	public Item() {
		super();
	}
	public Item(String theTitle, int time,double price)
	{
		if(theTitle==null||time<0)
		{
			throw new RuntimeException("datos no correctos");
		}
		setTitle(theTitle);
		setPlayingTime(time);
		setOwn(false);
		setComment("");
	}

	protected void setTitle(String title) {
		if (title != null)
			this.title = title;
	}
	
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		if(price<=10000)
		{
			this.price=price;
		}
	}
	
	public abstract void setBasePrice();
	
	protected void setOwn(boolean ownIt) {
		gotIt = ownIt;
	}

	protected void setPlayingTime(int playingTime) {
		if (playingTime >= 0)
			this.playingTime = playingTime;
		else
		{
			throw new RuntimeException("datos no correctos");
		}
	}

	protected void setComment(String comment) {
		if (comment != null)
			this.comment = comment;
		else
		{
			throw new RuntimeException("datos no correctos");
		}
	}

	public String getComment() {
		return comment;
	}

	public boolean getOwn() {
		return gotIt;
	}

	public String getTitle() {
		return this.title;
	}

	public int getPlayingTime() {
		return this.playingTime;
	}
	public abstract String toString();

	public abstract String getResponsable();
	

}