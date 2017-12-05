import java.util.ArrayList;
/**
 * Write a description of class Team here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Team
{
    private String nombreDeLaLista;
    private ArrayList<Player> team;
    private ArrayList<Player> impares;
    public Team(String name)
    {
        nombreDeLaLista=name;
        team=new ArrayList<Player>();
    }
    
    public void add(Player playerToAdd)
    {
        if ( playerToAdd == null)
            throw new RuntimeException("Jugador null");
        team.add(playerToAdd);
    }
    
    
    /**
     * Método que mete un jugador recibido como parámetro en la posición recibida como parámetro
     * @param index posición en la que se añade al jugador, de tipo int
     * @param jugador a añadir, de tipo Player
     */
    public void add(int index, Player playerToAdd)
    {
        if ( playerToAdd == null || index<0 || index >= team.size())
            throw new RuntimeException("Jugador null");
        team.add(index, playerToAdd);
    }
    
    /**
     * Método que devuelva el jugador cuyo número de camiseta sea el que recibe como paráetro
     * 
     */
    public Player seekPlayer(int number)
    {
        if (number <0 || number >= team.size())
            throw new RuntimeException("no existe jugador en la posicion solicitada");
            
        return team.get(number);
        
    }
    
    
    /**
     * Elimina el jugador cuyo número de camiseta se recibe como parámetro
     * 
     */
    public void removePlayer(int numero)
    {
        Player playerToRemove = seekPlayer(numero);
        team.remove(playerToRemove);
        // team.remove(seekPlayer(numero));
        
        if(numero>=0 && numero<team.size())
        {
            team.remove(numero);
        }
        else{}
    }
    
    /**
     * Recoge en una lista todos los jugadores cuyo número de camiseta sea impar
     * @return lista de jugadores impares
     */
    public void trainPlayers(int numero)
    {
      impares=new ArrayList<Player> ();
      for (int i=0; i < team.size() ; i++)
        {
        while(numero%2!=0)
        { 
            Player jugador1=new Player(numero);
            impares.add(jugador1);
       }
      }
    }
    
    public void seeContacts()
    {
             System.out.println(team);
     
    }
}
