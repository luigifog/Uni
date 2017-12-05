
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    public String name;
    public int number;
    
    public Player(String name, int newNumber)
    {
        setName(name);
        setNumber(newNumber);
    }
    
    public Player(int newNumber)
    {
        
        setNumber(newNumber);
    }
    private void setName(String newName)
    {
        name=newName;
    }
    
    public String getName()
    {
        return name;
    }
    
    private void setNumber(int newNumber)
    {
        number=newNumber;
    }
    
    public int getNumber()
    {
        return number;
    }
    
    public String toString()
    {
        return getName()+"-"+getNumber();
    }
}
