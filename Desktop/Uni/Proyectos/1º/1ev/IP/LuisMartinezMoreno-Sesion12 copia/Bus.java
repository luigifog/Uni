import java.util.ArrayList;
/**
 * Write a description of class Bus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bus
{
 
 public boolean driverPresent;
 public int availableSeats;
 private final static int MAXNUMBEROFSEATS =60;
 private final static int MINNUMBEROFSEATS  =0;
 private final static boolean DRIVERONBUS= true;
 private final static boolean DRIVEROUTBUS=false;
 
 private final static int MIN_NUMBER_OF_ROWS=5;
 private final static int MAX_NUMBER_OF_ROWS=15;
 private final static int COLUMNS=4;
 private Person[][] bus; 
 private int rows;
 
 /**
  *Este metodo modifica el atributo de si está o no el conductor
  *
  *@param de tipo de tipo boolean
  */
 public void setDriverPresent (boolean newDriver)
 {
     driverPresent = newDriver;
 }
 
 public Bus()
 {
     getDriverPresent();
     getAvailableSeats();
     bus=new Person[MIN_NUMBER_OF_ROWS][COLUMNS];
 }
 
 public Bus(int numberOfRows)
 {
     if(numberOfRows<MIN_NUMBER_OF_ROWS)
     {
         numberOfRows=MIN_NUMBER_OF_ROWS;
     }
     if(numberOfRows>MAX_NUMBER_OF_ROWS)
     {
        numberOfRows=MAX_NUMBER_OF_ROWS;
     }
     bus=new Person[numberOfRows][COLUMNS];
 }
 
 public boolean sentarPersona(Person person,int row, int column)
 {
     if(person==null|| column<0||column>COLUMNS-1||row<0||row>=bus.length)
            throw new RuntimeException("datos no correctos");
     if(bus[row][column]==null)
     {
         bus[row][column]=person;
         return true;
     }
     else
     { return false;}
 }
 
 public Person seekPerson(int row, int column)
 {
     if(bus[row][column]!=null)
     {
         return bus[row][column];
     }
     else
     {
         return null; 
     }
 }
 
 public int NumerosMenoresSentadosEnVentanilla()
 {
     int cont=0;
     for(int i =0; i<=bus.length;i++)
     {
         if(bus[i][0].getAge()<18)
         {
             cont++;
         }
         if(bus[i][3].getAge()<18)
         {
             cont++;
         }
     }
     return cont;
 }
 
 public ArrayList<Person> personasEnPrimeraLinea()
 {
     ArrayList<Person> passengers=new ArrayList<Person>();
     for(int j=0;j<=COLUMNS;j++)
     {
         if(bus[0][j]!=null)
         {
             passengers.add(bus[0][j]);
         }
     }
     return passengers;
 }
 
 private void setNumerOfRows(int numberOfRows)
 {
     if(numberOfRows<MIN_NUMBER_OF_ROWS)
     {
         numberOfRows=MIN_NUMBER_OF_ROWS;
     }
     
     if(numberOfRows>MAX_NUMBER_OF_ROWS)
     {
        numberOfRows=MAX_NUMBER_OF_ROWS;
     }
 }
 
 public void print(int row, int column)
 { 
     System.out.println("("+row+","+column+")"+ seekPerson(row,column).getName()+"("+seekPerson(row,column).getAge()+")");
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
