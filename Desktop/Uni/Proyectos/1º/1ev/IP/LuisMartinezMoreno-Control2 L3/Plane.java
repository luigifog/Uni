
/**
 * Write a description of class Plane here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plane
{
    
    public Person piloto;
    public String getPilotAsString;
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
    
    public double engineLever;
    public final static float MIN_LEVER=0;
    public final static float MAX_LEVER=5;
    public static final float MIN_REVOLUTIONS = 0;
    public static final float MAX_REVOLUTIONS = 45000;
    private Engine motor;
    public float revoluciones;
    private double revolutions;
    
    
    
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
        
    /**
     *Constructor con nuevo piloto, identificador del avion y cantidad de combustible 
     * 
     */
    public Plane(Person newPiloto, char newIdentifier, int newFuel)
    {
        piloto= new Person();
        identifier= newIdentifier;
        fuel=newFuel;
        motor=new Engine(0);
        engineLever=0;
    }
     
    /**
     * Plane Constructor
     *Limita la posicion de la palanca
     * @param setEngineLever A parameter
     */
    public Plane (double setEngineLever)
    {
        if(setEngineLever>=MIN_LEVER && setEngineLever <=MAX_LEVER)
        engineLever=setEngineLever;
        
    }
    
    /**
     * Method setMotor
     *Setter para el Engine motor
     * @param newMotor A parameter
     */
    private void setMotor(Engine newMotor)
    {
        motor =newMotor;
    }
    
    /**
     * Method getMotor
     *Getter para el Engine motor
     * @return The return value
     */
    public Engine getMotor()
    {
        return motor;
    }
    
    /**
     * Method getRevolutions
     *Getter para las revoluciones del motor
     * @return The return value
     */
    public Engine getRevolutions()
    {
        return motor;
    }
    
    /**
     * Method setRevolutions
     *Setter para las revoluciones del motor
     * @param newRevolutions A parameter
     */
    private void setRevolutions(double newRevolutions)
    {
        if (newRevolutions >= MIN_REVOLUTIONS && newRevolutions <= MAX_REVOLUTIONS)
            revolutions = newRevolutions;
    }
    
    /**
     * Method moveEngineLever
     *Si el valor de position esta dentro de los correctos, este metodo cambiara 
     *la posicion de la palanca(igual position)y las revoluciones(igual a la formula puesta en la pizarra)
     * @param position A parameter
     * @return The return value
     */
    public float moveEngineLever(float position)
    {
        if(position>=MIN_LEVER && position<=MAX_LEVER)
        {
          revoluciones=((position*MAX_REVOLUTIONS)/5);
          setEngineLever(position);
          revolutions=revoluciones;
          return revoluciones;
        }
        else
        {
            return -1;
        }
    
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
        
        else
        xPos=getXPos()+getXSpeed() ;
        yPos=getYPos()+getYSpeed();
        return true;
        }
        
        /**
         * Method setEngineLever
         *
         * @param newEngineLever A parameter
         */
        public void setEngineLever(double newEngineLever)
        {
            if(newEngineLever>=MIN_LEVER && newEngineLever<=MAX_LEVER)
            {
                engineLever=newEngineLever;
            }
        
        }
        
        /**
         * Method getEngineLever
         *
         * @return The return value
         */
        public double getEngineLever()
        {
            return engineLever;
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
