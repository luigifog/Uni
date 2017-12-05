
/**
 * Write a description of class Bus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bus
{public boolean driverPresent;
 public int availableSeats;
 private final static int MAXNUMBEROFSEATS =60;
 private final static int MINNUMBEROFSEATS  =0;
 private final static boolean DRIVERONBUS= true;
 private final static boolean DRIVEROUTBUS=false;
 
 /**
  *Este metodo modifica el atributo de si está o no el conductor
  *
  *@param de tipo de tipo boolean
  */
 public void setDriverPresent (boolean newDriver)
 {
     driverPresent = newDriver;
 }
 /**
  * Este método retorna el valor de si esta o no el conductor
  * 
  * @param de tipo boolean
  */
 public boolean getDriverPresent()
 {
     return driverPresent;
 }
   public Bus ()
   {
       getDriverPresent();
       getAvailableSeats();
    }
 /**
  * Este metodo modifica el numero de sillas, limitandolo a un maximo de 60 y un minimo de 0.
  * 
  * @param de tipo int
  */
 public void setAvailableSeats(int newNumberOfSeats)
 {
     if (newNumberOfSeats>= MINNUMBEROFSEATS)
   {
    if(newNumberOfSeats<=MAXNUMBEROFSEATS)
    availableSeats = newNumberOfSeats;
   }
 }

 /**
  * Este metodo devuelve el valor cambiado en el metodo setter
  * 
  * @param de tipo int
  */
 public int getAvailableSeats()
 {
     return availableSeats;
 }
 
 /**
  * Este metodo establece un bus con una características ya preestablecidas
  * 
  * @param es un constructor
  */
 public Bus(String newBus)
 {
     setDriverPresent ( DRIVERONBUS);
     setAvailableSeats ( MAXNUMBEROFSEATS);
 }
 
 /**
  * Este metodo vuelve el valor driverPresnt a true, por lo que el conductor estara en el bus
  * 
  * 
  */
 public void sitDriver()
 {
   driverPresent = true ; 
 }
  /**
  * Este metodo sirve para meter pasajeros y que se vaya disminuyendo el numero de asientos libres
  * 
  * @param de tipo int
  */
 public boolean getOn(int availableSeats)
 {
  setAvailableSeats(availableSeats);
   if( driverPresent =true && availableSeats> 0)
    setAvailableSeats(getAvailableSeats()-availableSeats);
  return true; }
 public String toString()
 {
    if (driverPresent == true) return "ON DUTY"; else return "OUT OF SERVICE" + "-"+ availableSeats;
 }
}
