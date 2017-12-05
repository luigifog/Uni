
/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon
{
    public String Name="g17";
    public int Ammunition=18;
    /**
     * Weapon Constructor
     *
     */
    public Weapon(){}
    
    /**
     * Weapon Constructor
     *
     * @param getName A parameter
     * @param Ammunition A parameter
     */
    public Weapon(String getName, int Ammunition)
    {
        Name="g17";
        Ammunition=18;
    }
    
    /**
     * Method setName
     *Setters para el nombre
     * @param newName A parameter
     */
    private void setName(String newName)
    {
        Name=newName;
    }
    
    /**
     * Method getName
     *Getter para el nombre
     * @return The return value
     */
    public String getName()
    {
        return Name;
    }
    
    /**
     * Method setAmmunition
     *Setters para la municion
     * @param newAmmunition A parameter
     */
    private void setAmmunition(int newAmmunition)
    {
        Ammunition=newAmmunition;
    }
    
    /**
     * Method getAmmunition
     *Getter para la ammo
     * @return The return value
     */
    public int getAmmunition()
    {
        return Ammunition;
    }
    
    /**
     * Method toString
     *
     * @return The return value
     */
    public String toString()
    {
        return getName()+"-"+getAmmunition();
    }
    
    /**
     * Method Shoot
     *Dispara e imprime el sonido bang
     */
    public void Shoot()
    {
        if (getAmmunition()>0)
        {
         System.out.println("BANG");
        setAmmunition(getAmmunition()-1);
        
        }
    
    
    }
}
