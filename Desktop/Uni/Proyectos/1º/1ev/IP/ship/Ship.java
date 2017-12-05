import java.util.Random;
/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship
{
    public final static int MIN_RES=10;
    public final static int MAX_RES=100;
    public String name;
    public boolean sumerg;
    public int resistance;
    
    public Ship()
    {
        Random r=new Random();
        setName("A");
        setSubmarine(r.nextBoolean());
        resistance=(r.nextInt(90)+10);
    }
    
    public Ship(int res,boolean sub,String name)
    {
        setRes(res);
        setSubmarine(sub);
        setName(name);
    }
    
    private void setName(String newName)
    {
        name=newName;
    }
    
    public String getName()
    {
        return name;
    }
    
    private void setRes(int res)
    {
        resistance=res;
    }
    
    public int getRes()
    {
        return resistance;
    }
    
    private void setSubmarine(boolean sumergible)
    {
        sumerg=sumergible;
    }
    
    public boolean getSubmarine()
    {
        return sumerg;
    }
}
