package greenHouse;

public class Electrician {
 
	private String name;
	
	private String surname;
	
	public Electrician(String name, String surname)
	{
		setName(name);
		setSurname(surname);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	private void setSurname(String surname) {
		this.surname = surname;
	}
	
	
	
	
}

