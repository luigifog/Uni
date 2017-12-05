
/**
 * Write a description of class Switch here.
 * Esta clase es un interruptor, el cual se activa(on) y en caso contrario estara (OFF)
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Switch
{
    public boolean activate;
    public final static boolean ON=true;
    public final static boolean OFF=false;
    
    /**
     * Method setActivate
     * Setter para activar el interruptor.
     *
     * @param newActivate A parameter
     */
    public void setActivate(boolean newActivate)
   {
    activate = newActivate;
   }
   /**
    * Method getActivate
    * Getter para activar el interruptor
    *
    * @return The return value
    */
   public boolean getActivate()
   {
       return activate;
    }
    /**
     * Method turnOn
     * Este método sirve para determinar cuando está activado el nterruptor
     *
     */
    public void turnOn()
    {
    setActivate(ON);
    }
    
    /**
     * Method turnOff
     * Este método sirve para determinar cuando no está activado el nterruptor
     *
     */
    public void turnOff()
    {
    setActivate (OFF);
    }
    /**
     * Method press
     * Este metodo devuelve un apagado si el interruptor esta encendido, y en caso contrario
     * enciende el interruptor, conmuta entre valores.
     *
     */
    public void press()
   {
       
       if (activate==true)
       turnOff();
       else 
       turnOn();
    }
    /**
     * Method toString
     * Este metodo devuelve un string en funcion de si esta encendido(ON) o apagado(OFF)
     *
     * @return The return value
     */
    public String toString()
    {
    if(activate==true)
    return "ON";
    else return "OFF";
    }
}
