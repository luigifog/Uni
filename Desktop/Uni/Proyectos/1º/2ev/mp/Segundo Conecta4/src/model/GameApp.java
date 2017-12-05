package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/** <p>T�tulo:  Clase principal </p>
* <p>Descripci�n: Conecta-4 es un juego para dos jugadores en el que se gana al alinear 4 fichas del mismo
*    color en una fila, una columna o en diagonal</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Empresa: Escuela de Ingenier�a Inform�tica - Universidad de Oviedo </p>
* @author  Candi
* @version 1.0
*/

public class GameApp {
    private Conecta4 game;
    
    public static void main(String[] args) {
        new GameApp().run();
    }
    
    
    public void run() {
    
    	game=new Conecta4();
       
        do {
            System.out.println("Vamos a jugar a Conecta-4\n");
            System.out.println(game.toString()); // se muestra el tableto por consola
            int column;
            boolean result;
            do {
                System.out.println("Turno del jugador " + game.getCurrentPlayer());
                do {
                	System.out.println("�En qu� columna quieres poner la ficha (0-6)?");
                	column = readInteger();
                } while ((column < 0) || (column > 6));
                result = game.play(column);
                if (!result)
                	System.out.println("Imposible colocar la ficha en esa columna, prueba otra vez.");
            } while (!result);
        } while (!game.finished());

        System.out.println(game.toString());

        char winner=game.winner();
        if (winner!=Conecta4.HUECO) // No hay ganador
        	System.out.println("Gan� el jugador "+winner);
        else
        	System.out.println("La partida termina en tablas.");
    }

   
    
    /**
	 * Lee un entero de la entrada estandar (normalmente el teclado).
	 * 
	 * @return El numero entero tecleado por el usuario.
	 */
	private int readInteger() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int num = 0;

		try {
			num = Integer.parseInt(br.readLine());
		} catch (Exception e) {
			System.out.println("�Error de entrada de datos!");
			System.exit(0);
		}

		return num;
	}
}
