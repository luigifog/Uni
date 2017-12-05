
/**
 * Write a description of class WheelStrut here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WheelStrut
{
    public boolean deployed;
    public Wheel leftWheel;
    public Wheel rightWheel;
    
    public static boolean DEPLOYED=true;
    
    public static int NORMAL_PRESSURE=1739;
    
   public WheelStrut()
    {
      leftWheel= new Wheel(NORMAL_PRESSURE,NORMAL_PRESSURE);
      rightWheel=new Wheel(NORMAL_PRESSURE,NORMAL_PRESSURE);
    }
    
    /**
     * Method setLeftWheel
     * setter para la rueda izq
     *
     * @param newLeftWheel A parameter
     */
    private void setLeftWheel(Wheel newLeftWheel)
   {
    this.leftWheel=leftWheel;
   }
   
   
   /**
     * Method setLeftWheel
     * getter para la rueda izq
     *
     * @param newLeftWheel A parameter
     */
    public Wheel getLeftWheel()
    {
    return leftWheel;
    }
    
    /**
     * Method setLeftWheel
     * setter para la rueda drcha
     *
     * @param newLeftWheel A parameter
     */
    private void setRightWheel(Wheel newRightWheel)
   {
    this.rightWheel=leftWheel;
   }
   
    /**
     * Method setLeftWheel
     * getter para la rueda drcha
     *
     * @param newLeftWheel A parameter
     */
    public Wheel getRightWheel()
    {
    return rightWheel;
    }
    
    /**
     * Method setDeployed
     * aterriza el avion o despega
     *
     * @param deployed A parameter
     */
    public void setDeployed(boolean deployed)
    {
      this.deployed=deployed;
    }
    
    /**
     * Method setDeployed
     * aterriza el avion o despega
     *
     * @param deployed A parameter
     */ 
    public boolean getDeployed()
    {
    return deployed;
    }
    /**
    * Method test
    * comprueba presion de las ruedas
    *
    * @return The return value
    */
    public boolean test()
    {
      if(leftWheel.test()==true)
        {if (rightWheel.test()==true)
        return true;}
        else return false;
        return test();
    }
    /**
     * Method toString
     *
     * @return The return value
     */
    public String toString()
    {
        return "Deployed: true"+ "-" +"Test: "+test()+" [L: "+leftWheel.test()+"]"+" [R: "+rightWheel.test()+" ]"; 
    }
    /**
     * Method print
     *
     */
    public void print()
    {
        System.out.println(getDeployed()+"\n"+
        "Test............"+test()+"\n"+
        "LEFT Wheel"+"\n"+
        leftWheel.test()+"\n"+
        "RIGHT Wheel"+"\n"+
        rightWheel.test());
        
    }
    /**
     *Despliega el puntal poniendo el atributo deployed a DEPLOYED 
     * 
     */
    public void deployed()
    {
        setDeployed(DEPLOYED);
    }
    /**
     *Despliega el puntal poniendo el atributo deployed a DEPLOYED 
     * 
     */
    public void retracted()
    {
        setDeployed(! DEPLOYED);
    }
}
