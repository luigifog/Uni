
/**
 * Write a description of class Heater here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heater
{
    public int heat;
    public final static int MAX_HEAT=27;
    public final static int MIN_HEAT=10;
    
    private void setHeat(int heat)
    {
        this.heat=heat;
    }
    
    public int getHeat()
    {
        return heat;
    }
    
    public void changeTemperature(int heat)
    {
        if (heat>=MIN_HEAT)
        {
            if(heat<= MAX_HEAT)
            this.heat=heat;
    
        }
    }
    public String toString()
    {
        return ""+getHeat();
    }
    //añadir toString
}
