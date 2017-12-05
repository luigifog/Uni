package simulacro;

import simulacro.Audio.AudioFormat;
import simulacro.Image.ImageFormat;
import simulacro.Video.VideoFormat;



public class Application {

	public static void main(String[] args) {
		// creamos un servidor web
		WebServer webServer = new WebServer("server","esaurlquenomese",6000);		
		
		// a�adimos un fichero de cada tipo

		webServer.fileToAdd(new Image("Logo.png", "http://www.mp.org/content/logo.png", 120,"Web Site Logo",ImageFormat.PNG));
		webServer.fileToAdd(new Video("Intro.avi", "http://www.mp.org/content/intro.avi", 20048,"Presentation",VideoFormat.AVI));
		webServer.fileToAdd(new Audio("Sound.mp3", "http://www.mp.org/content/sound.mp3", 10256,"Soundtrack",AudioFormat.MP3));
		
		// 1.	Listado de los ficheros disponibles
		System.out.println("Web Server Files");
		webServer.listFiles(System.out);
		System.out.println("");
		
		// 2.	Tama�o total de los ficheros almacenados en el servidor
		
		System.out.println("Web Server Size");
		System.out.println(webServer.size() + " bytes");
		System.out.println("");
		
		// 3.	Listado de los ficheros multimedia (Video y audio - reproducibles)
		System.out.println("Web Server Playable Files");
		webServer.listPlayableFilms(System.out);
		System.out.println("");
		
		// 4.	Buscar una archivo por su direcci�n URL
		System.out.println("Finding file by url: http://www.mp.org/index.html");
		File file = webServer.findByUrl("http://www.mp.org/index.html");
		System.out.println("Found file: " + file);
		System.out.println("");
		
		// 7.	Reproducir un contenido multimedia a partir de su direcci�n URL
		System.out.println("Playing file at url: http://www.mp.org/index.html");
		webServer.play("http://www.mp.org/index.html",System.out);		
		System.out.println("");
		
		System.out.println("Playing file at url: http://www.mp.org/content/intro.avi");
		webServer.play("http://www.mp.org/content/intro.avi",System.out);		
		System.out.println("");		
	}

}
