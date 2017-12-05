
/**
 * Write a description of class ControlPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControlPanel
{
    private Lamp bombilla;
    private Switch interruptor;
    private Heater calefaccion;
    private Potentiometer potenciometro;
    
    public ControlPanel()
    {
      bombilla=new Lamp();
      interruptor= new Switch();
      calefaccion=new Heater();
      potenciometro= new Potentiometer();
    
    }
   /**
    * Method setBombilla, setter para la bombilla
    *
    * @param newBombilla A parameter
    */
   private void setBombilla(Lamp newBombilla)
   {
    bombilla=newBombilla;
    }
    
    /**
     * Method setInterruptor, setter para el interruptor
     * 
     * @param newInterruptor
     */
    private void setInterruptor(Switch newInterruptor)
    {
    interruptor=newInterruptor;
    }
    private void setCalefaccion(Heater newCalefaccion)
    {
    calefaccion=newCalefaccion;
    }
    private void setPotenciometro(Potentiometer newPotenciometro)
   {
    potenciometro=newPotenciometro;
    } 
    public Potentiometer getMovePosition()
    {
    return potenciometro;
    }
    public Heater getHeat()
    {
    return calefaccion;
    }
    /**
     * Method getTurnLamp, activa o desactiva la bombilla
     *
     * @return The return value
     */
    public Lamp getTurnLamp()
    {
    return bombilla;
    }
    
    /**
     * Method getActivate, activa o desactiva el interruptor
     *
     * @return The return value
     */
    public Switch getActivate()
    {
    return interruptor;
    }
    /**
     * Method print
     * Imprime el estado del panel, diciendo si esta o no activado el interruptor
     * y la bombilla
     *
     */
    public void print()
    {
    System.out.println("=========== Estado del PANEL ============");
    System.out.println("Interruptor: "+getActivate());
    System.out.println("Bombilla: "+getTurnLamp());
    System.out.println("Calefaccion: "+getHeat());
    System.out.println("Potenciometro: "+getMovePosition());
    }

    /**
      * Method press
      * Este metodo simula que se esta presionando un interruptor que enciende o apaga la luz
      * en funcion del estado en el que estaba esta previamente
      *
      * @return The return value
   */public void press()
    {
      interruptor.press();
      if(interruptor.toString()=="ON")
        bombilla.turnOn();
        else
        bombilla.turnOff();
    
    }
    public void movePotentiometer()
    {
        calefaccion.getHeat();
        potenciometro.put0();
        potenciometro.put10();
        
        if(calefaccion.getHeat()==10)
        potenciometro.put0();
        else if(calefaccion.getHeat()==27)
        potenciometro.put10();
        
        
    }
    
    //     /**
  //      * Method switchTester
  //      * Metodo que cambia en funcion de si esta activado el interruptor(devuelve"ON")
  //      * o no (devuelve"OFF")
  //      *
  //      * @return The return value
  //      */
  //     public boolean switchTester()
  //     {
  //     if (Switch.activate==ON)
  //     return "ON";
  //     else return "OFF";
  //     }
  //     /**
  //      * Method lampTester
  //      * Metodo que cambia en funcion de si esta activada la bombilla(devuelve"ON")
  //      * o no (devuelve"OFF")
  //      *
  //      * @return The return value
  //      */
  //     public boolean lampTester()
  //     {
  //     if (Lamp.getTurnLamp()==true)
  //     return"ENCENDIDA";
  //     else return "APAGADA";
  //     }
  //     /**
  //      * Method press
  //      * Este metodo simula que se esta presionando un interruptor que enciende o apaga la luz
  //      * en funcion del estado en el que estaba esta previamente
  //      *
  //      * @return The return value
  //      */
  //     public boolean pres()
  //     {
  //     if (activate.getActivate()==ON)
  //     activate.getActivate()==false && turn.getTurnLamp()==false;
  //     else turn.getTurnLamp()==true;
  //     }
 }

