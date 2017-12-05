
/**
 * Gestor de reservas de asientos en el avion
 * 
 * @author (LUis) 
 * @version (1.0)
 */
public class SeatManager
{
   
    
    public final static int MIN_FIRST=3;
    public final static int MIN_STANDARD=4;
    
    public final static int DEFAULT_FIRST= MIN_FIRST;
    public final static int DEFAULT_STANDARD= MIN_STANDARD;
    public final static int COLUMNS=6;
    
    
   private Person[][] seats;        //Matriz que representa los asientos del avion
   private int firstRows;
   private int standardRows;
   /**
    * Constructor con parametros, filas en primera y estandar
    * @param filas en primera tipo int
    * @param filas en turista tipo int
    */
   public SeatManager()
   {
       setFirstRows(DEFAULT_FIRST);
       setStandardRows(DEFAULT_STANDARD);
       seats=new Person [getFirstRows()+getStandardRows()][COLUMNS];
    }
    
   public SeatManager(int first,int standard)
   {
       this();
       setFirstRows(first);
       setStandardRows(standard);
       if(getFirstRows()== first && getStandardRows()==standard)
       seats=new Person[getFirstRows()+getStandardRows()][COLUMNS];
   }
   
   public Person[][] getSeats()
   {
       return seats[][];
    }
   
   /**
    * Metodo que modifica el valor de Standard
    * 
    * @param numero de filas de turista de tipo int
    * 
    */
   private void setStandardRows(int standard)
   {
       if(standard>= MIN_STANDARD)
        throw new RuntimeException("Filas menores que el minimo");
        this.standardRows=standard;
   }
   
   /**
    * Metodo que modifica el valor de First
    * 
    * @param numero de filas de turista de tipo int
    * 
    */
   private void setFirstRows(int first)
   {
       if(first>= MIN_FIRST)
        throw new RuntimeException("Filas menores que el minimo");
        this.firstRows=first;
   }
   public Person getFirstPassenger()
   {
    for (int i=0;i<getFirstRows()+getStandardRows();i++)
    for(int j=0;j<COLUMNS;j++)
    
        {
            if(seats[i][j]!=null)
            {
                Person person1=seats[i][j];
                person1.getAge();
            }
        }
    return null;
    }
   
   /**
    * Metodo que te devuelve al personaje de mas edad
    * 
    */
   public Person oldestPassenger()
   {
       Person oldest=getFirstPassenger();
       if(oldest==null|| oldest.getAge()<0||oldest.getAge()>120)
            throw new RuntimeException("datos no correctos");
       for (int i=0;i<getFirstRows()+getStandardRows();i++)
       for(int j=0;j<COLUMNS;j++)
       
       
       if(seats[i][j].getAge()>getFirstPassenger().getAge())
            oldest=seats[i][j];
       return oldest;
   }
   
//    /**
//     * En la fila elegida como parametro, nos dice los asientos que estan libres
//     * 
//     * @param row, la fila elegida, de tipo int
//     */
//    public Person numberOfFreeSeats(int row)
//    {
//        if(row>=seats.getFirstRows()+getStandardRows()|| row<0)
//         throw new RuntimeException("no hay sitios en esa posición");
//         int libres=0;
//             for(int i=0;i<seats.lenght();i++)
//            {
//             if(Person[row][i]==null)
//                 libres=libres+1;
//             system.out.println(libres);
//             }
//   }
   
   /**
    * @return devuelve el numero de filas en primera
    * 
    */
   public int getFirstRows()
   {
       return firstRows;
    }
    
    /**
    * @return devuelve el numero de filas en Standard
    * 
    */
   public int getStandardRows()
   {
       return standardRows;
    }
    
    /**
     * Metodo que reserva un asientop de fila 
     * y columna recibida como parameaaetro a la persona recibida como parametro
     * 
     * @Param person, persona que hace la reserva de tipo person, tipo Person
     * @Param columna, columna de reserva, tipo int
     * @paramm fila de reserva,tipo int
     * 
     * @return true si se ha hecho la reserva, y false si no se ha podido hacer
     */
    public boolean bookSeat(Person person,  int column, int row)
    {
        if(person==null|| column<0||column>COLUMNS-1||row<0||row>=seats.length)
            throw new RuntimeException("datos no correctos");
            if(seats[row][column]==null)
            {
                seats[row][column]=person;
                return true;
            }
            else
            return false;
    }
    
    /**
     * libera el asiento cuya fila y columna recibe como parametro
     * 
     * @param fila, fila a liberar
     * @param columna a liberar
     * 
     * @return persona que deja el asiento o null si no habia ninguna persona
     * 
     */
    public void release(int row, int column)
    {
        if( column<0||column>COLUMNS-1||row<0||row>=seats.length)
            throw new RuntimeException("datos no correctos");
            if(seats[row][column]!=null)
            {
                Person person=seats[row][column];
                seats[row][column]=null;
                 
            }
            
        
    }
    
    public Person getPerson(int row, int column)
    {
        return seats[row][column];
    }
}
