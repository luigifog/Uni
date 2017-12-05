package simulacro;


public abstract class File {
	private String name;
	private String url;
	private int size;
	
	public File(String name, String url, int size)
	{
		setName(name);
		setUrl(url);
		setSize(size);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public String toString()
	{
		String cad="";
		{
			cad+="nombre: "+getName()+" tama�o: "+getSize()+ " url: "+getUrl();
		}
		return cad;
	}
	
	@Override
	public boolean equals(Object objeto)
	{
	File f=(File) objeto;	
		return getUrl().equals(f.getUrl());	
	}

	
}
