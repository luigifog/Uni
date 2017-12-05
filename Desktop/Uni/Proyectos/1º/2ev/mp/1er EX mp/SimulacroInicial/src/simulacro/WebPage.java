package simulacro;

public class WebPage extends File{

	private String content;
	public WebPage(String name, String url, int size, String content) {
		super(name,url,size);
		setContent(content);
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String toString()
	{
		return super.toString()+"Contenido: "+getContent();
	}
	

}
