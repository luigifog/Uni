package main;

import sesion3_dome_inicial.CD;
import sesion3_dome_inicial.DVD;
import sesion3_dome_inicial.Database;
import sesion3_dome_inicial.Platform;
import sesion3_dome_inicial.VideoGame;

public class DatabaseApp {

	public static void main(String[] args) {
		DatabaseApp d=new DatabaseApp();
		d.run();
	}
	private void run()
	{
		CD cd1=new CD("Come Together","Beatles",70,4,7.6);
		CD cd2=new CD("Nevermind","Nirvana",12,75,7.6);
		CD cd3=new CD("To be loved","Papa Roach",13,90,7.6);
		DVD dvd1=new DVD("La guerra de las Galaxias","George Lucas",125,7.6);
		DVD dvd2=new DVD("American Pie","Paul Weitz",96,7.6);
		DVD dvd3=new DVD("Project X","Nourizadeh Nima",94,7.6);
		VideoGame vg1=new VideoGame("Battlefield","EA",false,3,null,7.6);
		VideoGame vg2=new VideoGame("Minecraft","Notch",true,4,Platform.PlayStation,7.6);
		VideoGame vg3=new VideoGame("Call of duty","IW",true,15,Platform.Nintendo,7.6);
		Database data=new Database();
		data.add(cd1);
		data.add(cd2);
		data.add(cd3);
		data.add(dvd1);
		data.add(dvd2);
		data.add(dvd3);
		data.add(vg1);
		data.add(vg2);
		data.add(vg3);
		System.out.print(data.numberOfItemsOwned());
		data.list(System.out);
	}

}
