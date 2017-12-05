
/**
 * Write a description of class BridgeControler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BridgeControler
{
    public int lever;
    public boolean clutch;
    public BasculeBridge bridge;
    public int inclination;
    public boolean press;
    
    public final static boolean NO_PRESS=false;
    public final static boolean PRESS=true;
    
    public final static int MIN_INCLINATION=0;
    public final static int MEDIUM_INCLINATION=30;
    public final static int MAX_INCLINATION=60;
    
    public BridgeControler()
    {
        clutch=NO_PRESS;
        lever=MIN_INCLINATION;
    
    }
    public BridgeControler(int inclination)
    {
    if (inclination==MIN_INCLINATION){
        setLever(MIN_INCLINATION);
        setClutch(NO_PRESS);
        //         bridge= new BasculeBridge();
    }
    else if(inclination==MEDIUM_INCLINATION){
        setLever(MEDIUM_INCLINATION);
        setClutch(NO_PRESS);
        //         BasculeBridge bridge= new BasculeBridge();
    }
     else if(inclination==MAX_INCLINATION){
        setLever(MAX_INCLINATION);
        setClutch(NO_PRESS);
        //         BasculeBridge bridge= new BasculeBridge();
    }
    }
    
    
    private void setClutch(boolean newPress)
    {
        press=newPress;
    
    }
    
    public boolean getClutch()
    {
        return press;
    
    }
    
    public void raiseBridge()
    {
        setInclination(inclination+1);
    }
    
    public void dropBridge()
    {
        setInclination(inclination-1);
    }
    
    public void changeClutch(boolean press)
    {
        if (press=true)
        setClutch(NO_PRESS);
        else if (press =false)
        setClutch(PRESS);
    }
    
    
    
    
    
    
    
    
    
    public void setLever(int newInclination)
    {
        inclination=newInclination;
    }
    
    public int getLever()
    {
        return inclination; 
    }
    
    private void setInclination(int newInclination)
    {
        inclination=newInclination;
    }
   
    public int getInclination()
    {
        return inclination;
         
       
    }
    //     private void lever(int inclination)
    //     {
    //         getInclination();
    //     
    //     
    //     }
    }
