
/**
 * Write a description of class BasculeBridge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BasculeBridge
{
    public int position;
    public final static int MIN_POSITION=0;
    public final static int MEDIUM_POSITION=30;
    public final static int MAX_POSITION=60;
    public BasculeBridge(int position)
    {
    setPosition(position);
    }
    private void setPosition(int newPosition)
    {
    position=newPosition;
    }
    
    public int getPosition()
    {
    return position;
    }
    public void raiseBridge(int ammountInc)
    {
    if (ammountInc>0)
    {
       if((getPosition()+ammountInc)<=MAX_POSITION)
            if ((getPosition()+ammountInc)>=MIN_POSITION)
            setPosition(getPosition()+ammountInc); 
    }
    }
    
    public void dropBridge(int ammountDec)
    {
    if (ammountDec>0)
    {
       if((getPosition()+ammountDec)<=MAX_POSITION)
            if ((getPosition()+ammountDec)>=MIN_POSITION)
            setPosition(getPosition()+ammountDec); 
    }
    }
    public void slope(int inclination)
    {
        if((getPosition()+inclination)<=MAX_POSITION)
            if ((getPosition()+inclination)>=MIN_POSITION)
            setPosition(getPosition()+inclination);
    }
}