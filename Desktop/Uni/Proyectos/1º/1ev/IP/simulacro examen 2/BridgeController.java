
/**
 * Write a description of class BridgeController here.
 * 
 * @author (Fernando Alvarez) 
 * @version (2016)
 */
public class BridgeController
{
    private int lever;
    private boolean clutch;
    private BasculeBridge bridge;

    public final static boolean NO_PRESS=false;
    public final static boolean PRESS=true;
    
    public final static int MIN_INCLINATION=0;
    public final static int MEDIUM_INCLINATION=30;
    public final static int MAX_INCLINATION=60;
    public BridgeController()
    {
        setClutch(NO_PRESS);
        setLever(MIN_INCLINATION);
        setBridge( bridge);
    }
    
    public BridgeController(int lever)
    {
        this();
        setClutch(NO_PRESS);
        setLever(lever);
        setBridge(bridge);
    }

    private void setLever(int newLever)
    {
        if (newLever>=0 || newLever<=3) 
        lever=newLever;
    }
    
    public int getLever()
    {
        return lever;
    }
    
    private void setClutch(boolean clutch)
    {
        this.clutch=clutch;
    }
    
    public boolean getClutch()
    {
        return clutch;
    }
    
    private void setBridge(BasculeBridge bridge)
    {
        this.bridge=bridge;
    }
    
    public BasculeBridge getBridge()
    {
        return bridge;
    }
    
    public void changeClutch(boolean press)
    {
        if (press=true)
        setClutch(NO_PRESS);
        else 
        setClutch(PRESS);
    }
    

    public void changeLever(int lever){
        int inclinacion=0;
        if((clutch==true)&&(lever==MIN_INCLINATION || lever==MEDIUM_INCLINATION || lever==MAX_INCLINATION))
        {if(inclinacion>0)
            bridge.raiseBridge(inclinacion);
    
        if(inclinacion<0)
            bridge.dropBridge(-inclinacion);
        }
    }
}
