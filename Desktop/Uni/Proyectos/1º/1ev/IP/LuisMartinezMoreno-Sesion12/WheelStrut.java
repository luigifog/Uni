import java.util.ArrayList;
/**
 * Write a description of class WheelStrut here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WheelStrut

{
    public boolean deployed;

    private ArrayList<Wheel> wheels;//coleccion de ruedas del avion
    public final static int DEFAULT_WHEELS_NUMBER_OF_WHEELS=3;
    public static boolean DEPLOYED=true;
    public static int NORMAL_PRESSURE=1739;
    
    public WheelStrut()
    {
     setWheels(DEFAULT_WHEELS_NUMBER_OF_WHEELS);
     setDeployed(DEPLOYED);
    }
    
    /**
     * Constructor que recibe el numero de ruedas del puntal
     * @param numberOfWheels que tendra el puntal
     * 
     */   
    public WheelStrut(int numberOfWheels)
    {
        this();
        setWheels(numberOfWheels);
    }
    /**
     * crea un arraylist con las ruedas que se nos indique
     * 
     * @param numberOfWheels
    */
     private void setWheels(int numberOfWheels)
    {
        if (numberOfWheels<1 || numberOfWheels>20)//maximo 20 ruedas
            throw new RuntimeException("Numero de ruedas incorrecto");
        wheels=new ArrayList<Wheel>();
            
        for(int i=1;i<=numberOfWheels;i++)
        {
            Wheel wheel1=new Wheel(NORMAL_PRESSURE,NORMAL_PRESSURE);
            wheels.add(wheel1);
        }
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
     * metodo que devuelve el num de ruedas del puntal
     * @return num de ruedas del puntal
     */
    public int size()
    {
        return wheels.size();
    }
    
    /**
    *metodo que devuelve la rueda localizada en la posicion indicada como parametro
    *@param position
    *@return rueda del puntal de tipo Wheel
    */
    public Wheel getWheel(int index)
    {
        if(index<0 || index>= wheels.size())
            throw new RuntimeException("Error, no existe objeto en esta pos");
        return wheels.get(index);
    }
    
    /**
    * Method test
    * comprueba presion de las ruedas
    *
    * @return The return value
    */
    public boolean test()
    {
      for(Wheel wheelToTest : wheels)
       {
           if(wheelToTest.test()==false)
                return false;
       }
      return true;
    }
    /**
     * Method toString
     *
     * @return The return value
     */
    public String toString()
    {
        String data = "desplegado:" + getDeployed()+ "- Test: " + test();
        for(int i=0; i<wheels.size(); i++)
        {
        data=data + "["+ i + " : " + wheels.get(i).test() + "]";
    }
    return data;
    }
    /**
     * Method print
     *
     */
    public void print()
    {
        if (getDeployed())
            System.out.println("DEPLOYED");
        else
            System.out.println("RETRACTED");
        if (test())
            System.out.println("Test............ok");
        else
            System.out.println("Test...........FAIL");
        for(int i=0; i<wheels.size(); i++)
        {
            System.out.println("Rueda " +i);
//             Wheel wheelToPrint = wheels.get(i);
//             wheelToPrint.print();
//               Wheel stringOfTheWheel = wheelToPrint.toString();
//               int ageOfThePerson = person.getAge();

            wheels.get(i).print();
        }
      
        
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
