
/**
 * Write a description of class BasculeBridge here.
 * 
 * @author (Fernando Alvarez) 
 * @version (2016)
 */
public class BasculeBridge
{
    private int slope;
    
    public final static int MAX_SLOPE=60;
    public final static int MIN_SLOPE=0;
    

    /**
     * Constructor for objects of class BasculeBridge
     */
    public BasculeBridge()
    {
        setSlope(0);
    }

    
    /**
     * Creates a BasculeBridge object with a given slope
     *
     * @param slope The initial slope of the bridge
     */
    public BasculeBridge(int slope)
    {
        this();
        setSlope(slope);
    }
        

    private void setSlope(int slope)
    {
        if ((slope>=MIN_SLOPE) && (slope<=MAX_SLOPE))
            this.slope=slope;
    }
    
    public int getSlope()
    {
        return slope;
    }
    

    /**
     * Modifies the position of the bridge incrementing the current slope with the value passed as a parameter.
     *
     * @param increment A positive value that modifies the current bridge's slope
     */
    public void raiseBridge(int increment)
    {
        if (increment>0)
            setSlope(getSlope()+increment);
    }
    

    public void dropBridge(int decrement)
    {
        if (decrement>0)
            setSlope(getSlope()-decrement);
    }

 
}
