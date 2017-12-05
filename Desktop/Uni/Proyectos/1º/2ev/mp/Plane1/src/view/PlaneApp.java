package view;

import model.Person;
import model.Plane;

public class PlaneApp {

	public static void main(String[] args) {
		new PlaneApp().run();

	}

	public void run()
	{
		Person person1=new Person("Pepe",18);
		Plane plane1=new Plane(person1,'P',1000);
		System.out.println(plane1);
		plane1.fly();
		System.out.println(plane1);
	}
}
