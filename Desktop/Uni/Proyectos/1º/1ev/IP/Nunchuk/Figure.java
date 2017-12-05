
/**
 * Write a description of class Figure here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Figure
{
    public String name;
    public int xPos;
    public int yPos;
    
    public final static int X_LOWER_EDGE=0;
    public final static int Y_LOWER_EDGE=0;
    public final static int X_UPPER_EDGE=640;
    public final static int Y_UPPER_EDGE=320;
    public final static char LEFT='L';
    public final static char RIGHT='R';
    public final static char UP='U';
    public final static char DOWN ='D';
    public final static int STEP=10;
    /**
     * Figure Constructor
     *
     */
    public Figure()
    {}
    
    /**
     * Figure Constructor
     *
     * @param name A parameter
     */
    public Figure(String name)
    {
        name="Luis";
    }
    
    /**
     * Method setName
     *Setter para el nombre
     * @param newName A parameter
     */
    private void setName(String newName)
    {
        name=newName;
    }
    
    /**
     * Method getName
     *Getter para el nombre
     * @return The return value
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Method setYPos
     *
     * @param newYPos A parameter
     */
    private void setYPos(int newYPos)
    {
        yPos=newYPos;
    }
    
    /**
     * Method getYPos
     *
     * @return The return value
     */
    public int getYPos()
    {
        return yPos;
    }
    
    /**
     * Method setXPos
     *
     * @param newXPos A parameter
     */
    private void setXPos(int newXPos)
    {
        xPos=newXPos;
    }
    
    /**
     * Method getXPos
     *
     * @return The return value
     */
    public int getXPos()
    {
        return xPos;
    }
    
    /**
     * Method move
     *Mueve el personaje a izq, drcha arriba y abajo
     * @param action A parameter
     */
    public void move(char action)
    {
        if(action=='L')
            setXPos(xPos-1);
        if(action=='R')
            setXPos(xPos+1);
        if(action=='U')
            setYPos(yPos+1);
        if(action=='D')
            setYPos(yPos-1);
    }

    /**
     * Method toString
     *
     * @return The return value
     */
    public String toString()
    {
        return getName()+"-"+"("+getXPos()+","+getYPos()+")";
    }
}
