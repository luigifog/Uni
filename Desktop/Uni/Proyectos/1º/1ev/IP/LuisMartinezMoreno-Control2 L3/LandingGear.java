
/**
 * Tren de aterrizaje para el avion, contiene palanca para 3 puntales;morro, izq y drch
 * Write a description of class LandingGear here.
 * 
 * @author (Luis Martinez) 
 * @version (a version number or a date)
 */
public class LandingGear
{
   private boolean lever;
   
   private WheelStrut nose;
   private WheelStrut left;
   private WheelStrut right;
   
   public final static boolean LEVER_UP=true;
   public final static boolean LEVER_DOWN=false;
   public final static boolean DEFAULT_LEVER=LEVER_DOWN;
   
   public LandingGear()
   {
       setLever(DEFAULT_LEVER);
       nose=new WheelStrut();
       //setNose(new WheelSTrut());
       left=new WheelStrut();
       right=new WheelStrut();
       
   }
   
   /**
    * Modifica el valor del atributo lever
    * 
    * @param lever, nuevo valor para lever, de tipo boolean
    * 
    */
   private void setLever( boolean newLever)
   {
       lever=newLever;
    }
    
    /**
    * Devuelve el valor del atributo lever
    * 
    * @return lever, nuevo valor para lever, de tipo boolean
    * 
    */
   public boolean getLever()
    {
        return lever;
    }
    
    /**
    * Modifica el valor del atributo nose
    * 
    * @param nose, nuevo valor para nose, de tipo wheelStrut
    * 
    */
   private void setNose( WheelStrut newNose)
   {
       nose=newNose;
    }
    
    /**
    * Devuelve el valor del atributo nose
    * 
    * @return nose, valor del puntal del morro, de tipo sheelStrut
    * 
    */
   public WheelStrut getNose()
    {
        return nose;
    }
    
    /**
    * Modifica el valor del atributo left
    * 
    * @param left, nuevo valor para left, de tipo wheelStrut
    * 
    */
   private void setLeft( WheelStrut newLeft)
   {
       left=newLeft;
    }
    
    /**
    * Devuelve el valor del atributo left
    * 
    * @return left, valor del puntal del left, de tipo wheelStrut
    * 
    */
   public WheelStrut getLeft()
    {
        return left;
    }
    
    /**
    * Modifica el valor del atributo nose
    * 
    * @param nose, nuevo valor para nose, de tipo boolean
    * 
    */
   private void setRight( WheelStrut newRight)
   {
       right=newRight;
    }
    
    /**
    * Devuelve el valor del atributo nose
    * 
    * @return nose, valor del puntal del morro, de tipo sheelStrut
    * 
    */
   public WheelStrut getRight()
    {
        return right;
    }
    
   /**
     *Mueve el tren de aterrizaje, lo que implica mover la palanca y desplegar los puntales
     * @param action true o false si la accion es UP o Down
     * 
     */
    public void moveLever(boolean action)
    {
        if(action==LEVER_UP)
        {
        setLever(LEVER_UP);
        nose.retracted();
        right.retracted();
        left.retracted();
       }
       
     if(action==LEVER_DOWN)
        {
        setLever(LEVER_DOWN);
        nose.deployed();
        right.deployed();
        left.deployed();
        
    }
}
}
