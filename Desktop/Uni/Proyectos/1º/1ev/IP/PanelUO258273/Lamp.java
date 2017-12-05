

/**
 * Esta clase representa a una bombilla, la cual puede tener valores
 * booleanos de encendido(ON) y apagado(OFF)
 * 
 * @author (UO258273) 
 * @version (1.0)
 */
public class Lamp
{
   public boolean turn;
   public final static boolean LAMP_ON=true;
   public final static boolean LAMP_OFF=false;
   public void setTurnLamp(boolean newTurn)
   {
    turn =newTurn;
    }
   /**
    * Method getTurnLamp 
    * getter para la encender o apagar la bombilla
    *
    * @return The return value
    */
   public boolean getTurnLamp()
   {
    return turn;
    }
    public void turnOn()
    {
    setTurnLamp(LAMP_ON);
    }
    public void turnOff()
    {
    setTurnLamp(LAMP_OFF);
    }
    /**
     * Method toString
     *Devuelve un string, si la bombilla esta apagada devuelve un OFF
     *en caso contrario devuelve un ON
     * @return The return value
     */
    public String toString()
    {
    if (turn == true)
    return "ENCENDIDA";
    else return "APAGADA";
    
   }
}