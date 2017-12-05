package simulacro;


public class Image extends File {
	
	public static enum ImageFormat{	PNG, JPEG, GIF }
	
	private String description;
	private ImageFormat format;
	
	public Image(String name, String url, int size, String description, ImageFormat format) {
		super(name,url,size);
		setDescription(description);
		setFormat(format);
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ImageFormat getFormat() {
		return format;
	}
	public void setFormat(ImageFormat format) {
		this.format = format;
	}

	public String toString()
	{
		return super.toString()+"formato: "+getFormat()+"descripcion: "+getDescription();
	}
	

}
