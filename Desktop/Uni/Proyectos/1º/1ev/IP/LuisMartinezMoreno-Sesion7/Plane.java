
/**
 * Write a description of class Plane here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plane
{
    
    public Person piloto;
    public String pilotAsString;
    public char identifier;
    public int fuel;
    public boolean fly;
    public int xPos ;
    public int yPos;
    public int xSpeed;
    public int ySpeed;
    public final static int MAX_X =10;
    public final static int MAX_Y =10;
    public final static int MAX_VEL_X =1;
    public final static int MIN_VEL_X =-1;
    public final static int MAX_VEL_Y =1;
    public final static int MIN_VEL_Y =-1;
    

    /**
         * Plane Constructor
         *
         */
        public Plane()
        {
          piloto = new Person();
          identifier = 'A';
          fuel = 0;
    
        }
        
    public Plane(Person newPiloto, char newIdentifier, int newFuel){
        piloto= newPiloto;
        identifier= newIdentifier;
        fuel=newFuel;
    }
     
    /**
     * Metodo que dependiendo del combustible varia la posicion del avion
     * 
     */public boolean fly()
    { 
        if (getFuel() ==0 )
        {
            fuel=(getFuel()-1);return false;
        }
        {
        if(getXPos()==0||getXPos()==MAX_X)
        {xPos=getXPos();
        }
        else
        xPos=getXPos()+getXSpeed() ;
        yPos=getYPos()+getYSpeed();
        return true;
        }
    }
    
    /**
     * Method setYPos
     *
     * @param newYPos A parameter
     */
    public void setYPos(int newYPos)
    {
        if (newYPos >=0 && newYPos <= MAX_Y)
            yPos= newYPos;

    }
    
    /**
     * Method setPilot
     * setter para piloto
     *
     * @param newPiloto A parameter
     */
    public void setPilot(Person newPiloto)
    {
        piloto= newPiloto;
    }
    
    /**
     * Method getPiloto
     * getter para el piloto
     *
     * @return The return value
     */
    public Person getPiloto()
    {
        return piloto;
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
    public void setXPos(int newXPos)
    {
        if ((newXPos >=0 && newXPos <= MAX_X))
            xPos =newXPos;

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
     * Method accelerate
     * Aumenta la velocidad en x y en y simultaneamente si se cumplen los valores 
     *
     * @param newXSpeed A parameter
     * @param newYSpeed A parameter
     */
    public void accelerate(int newXSpeed, int newYSpeed)
    {
        if (newYSpeed == MIN_VEL_Y || newYSpeed ==0 || newYSpeed == MAX_VEL_Y) 
            ySpeed =newYSpeed;
        if (newXSpeed == MIN_VEL_X || newXSpeed==0 || newXSpeed == MAX_VEL_X  
        )
            xSpeed =newXSpeed;

    }

    /**
     * Method setXSpeed
     *
     * @param newXSpeed A parameter
     */
    public void setXSpeed( int newXSpeed)
    {
        if (newXSpeed == MIN_VEL_X || newXSpeed==0 || newXSpeed == MAX_VEL_X)
            xSpeed = newXSpeed;

    }

    /**
     * Method getXSpeed
     *
     * @return The return value
     */
    public int getXSpeed()

    {
        return xSpeed;
    } 

    /**
     * Method setYSpeed
     *
     * @param newYSpeed A parameter
     */
    public void setYSpeed( int newYSpeed)
    {
        if (newYSpeed == MIN_VEL_Y || newYSpeed ==0 || newYSpeed == MAX_VEL_Y)
            ySpeed = newYSpeed;

    }

    /**
     * Method getYSpeed
     *
     * @return The return value
     */
    public int getYSpeed()

    {
        return ySpeed;
    } 

    /**
     * Method setIdentifier
     *
     * @param newIdentifier A parameter
     */
    public void setIdentifier(char newIdentifier)
    {
        identifier = newIdentifier;
    }

    /**
     * Method getIdentifier
     *
     * @return The return value
     */
    public char getIdentifier()
    {
        return identifier;
    }

    /**
     * Method setFuel
     *
     * @param newFuel A parameter
     */
    public void setFuel (int newFuel)
    {
        fuel = newFuel;
    }

    /**
     * Method getFuel
     *
     * @return The return value
     */
    public int getFuel()
    {
        return fuel;
    }

    /**
     * Method toString
     *
     * @return The return value
     */
    public String toString ()
    {
        return getIdentifier()+"-"+getFuel()+"-"+getPilotoAsString()+"-"
        +"("+getXPos()+","+getYPos()+")"+"-"+"("+getXSpeed()+","+getYSpeed()+")";
    }
    //     public String setPilotAsString(String pilotAsString)
    //     {
    //         if( pilotAsString != null)
    //         return piloto.getHashCode();
    //         
    //         if (pilotAsString == null)
    //         return "NO PILOT";
    //         
    //         return pilotAsString;
    //     }
    
    /**
     * Method getPilotoAsString
     * devuelve el metodo getHashCode con todos los datos dl piloto si este esta presente y si no,
     * devuelve "NO PILO
     *
     * @return The return value
     */
    public String getPilotoAsString()
    {
         if(piloto!=null){
            return piloto.getHashCode();
        }else{
            return "NO PILOT";
        }
    }
    
}
