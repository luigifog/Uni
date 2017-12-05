import java.util.ArrayList;
import java.util.Random;
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
    * Constructor sin parametros
    */
   public SeatManager()
   {
       setFirstRows(DEFAULT_FIRST);
       setStandardRows(DEFAULT_STANDARD);
       seats=new Person [getFirstRows()+getStandardRows()][COLUMNS];
    }
   /**
    * Constructor con parametros, filas en primera y estandar
    * @param filas en primera tipo int
    * @param columnas en turista tipo int
    */ 
   public SeatManager(int first,int standard)
   {
       this();
       setFirstRows(first);
       setStandardRows(standard);
       if(getFirstRows()== first && getStandardRows()==standard)
            seats=new Person[getFirstRows()+getStandardRows()][COLUMNS];
   }
   
   /**
    * Metodo que modifica el valor de Standard
    * 
    * @param numero de filas de turista de tipo int
    * 
    */
   private void setStandardRows(int standard)
   {
       if(standard< MIN_STANDARD)
        throw new RuntimeException("Filas de standard menores que el minimo");
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
       if(first< MIN_FIRST)
        throw new RuntimeException("Filas de primera menores que el minimo");
        this.firstRows=first;
   }
   
   /**
    * devuelve el primer sitio libre de la matriz
    */
   public Person getFirstPassenger()
   {
    for (int i=0;i<getFirstRows()+getStandardRows();i++)
    for(int j=0;j<COLUMNS;j++)
    
        {
            if(seats[i][j]!=null)
            {
                return seats[i][j];
                
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
       for (int i=0;i<getFirstRows()+getStandardRows();i++){
       for(int j=0;j<COLUMNS;j++)
        {
       
           if(seats[i][j].getAge()>oldest.getAge())
           {
                oldest=seats[i][j];
                
           }
        }
        }
       return oldest;
   }
   
   public void print()
   {
    System.out.println("0 1 2 3 4 5");
    for (int i=0;i<getFirstRows()+getStandardRows();i++){
        System.out.println(i + " ");
       for(int j=0;j<COLUMNS;j++)
       {
            if(seats[i][j].getAge()<120 && seats[i][j].getAge()>18)
                System.out.print ("X");
            else if(seats[i][j].getAge()<18 &&seats[i][j].getAge()>0)
                System.out.print ("C");
            else
                System.out.print ("?");
            }
            System.out.println(" ");
    }
   }
   
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
    public boolean bookSeat(Person person, int row,int column)
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
            if(seats[row][column]==null)
                throw new RuntimeException("la fila ya estaba vacia");
            if(seats[row][column]!=null)
            {
                Person person=seats[row][column];
                seats[row][column]=null;
                 
            }
            
        
    }
    /**
     * Devuelve a la persona en la fila y columna indicada como parametro
     * 
     * @param row, fila indicada, de tipo int
     * @param column, columna indicada de tipo int
     */
    
    public Person getPerson(int row, int column)
    {
        return seats[row][column];
    }
    /**
     * @return lista de niños que va en el avion, de tipo ArrayList
     */
    public ArrayList<Person> childrenPassenger()
    {
        ArrayList<Person> children=new ArrayList<Person>();
        for (int i=0;i<seats.length;i++)
            for(int j=0;j<seats[i].length;j++)
                if(seats[i][j]!=null && seats[i][j].getAge()<18)
                    children.add(seats[i][j]);
        return children;
    }
    
    /**
     * Devuelve una lista de todos los niños que se llame como el parametro recibido
     * 
     * @param nombre del pasajero, tipo String
     * @return todos los que se llaman asi y son menores de edad
     */
    public ArrayList<Person> childrenNamePassenger(String name)
    {
        if (name==null)
            throw new RuntimeException("Nombre incorrecto");
            
       ArrayList<Person> childrenName=new ArrayList<Person> ();
       for(int i=0;i<seats.length;i++)
            for(int j=0;j<seats[i].length;j++)
                if(seats[i][j]!=null
                && seats[i][j].getAge()<18 && seats[i][j].getName().equals(name))
                childrenName.add(seats[i][j]);
       return childrenName;
                
    }
    
    /**
     * Metodo que busca en un array que recibe como parametro en un array
     * de personas que recibe como parametro
     * 
     * @param lista de personas, de tipo Person[]
     * @param nombre de persona a buscar, de tipo String
     * @return lista de`personas con el nombre indicado , de tipo ArrayList
     */
    public ArrayList<Person> seekPeople(Person[] list, String name)
        {
            checkParameters(list,name);
            ArrayList<Person>listToReturn = new ArrayList<Person>();
    
        for(Person personToTest:list)
        {
            if(personToTest.getName().equals(name))
        
            return listToReturn;
        }
        return listToReturn;
    }
  
    private void checkParameters(Person[] list,String name)
    {
        if (name==null)
            throw new RuntimeException("Nombre incorrecto");
        if(list==null)
                throw new RuntimeException("lista incorrect");
        for(int i=0;i<list.length;i++)
            if(list[i]==null)
                throw new RuntimeException("algun elemento de la lista es null");
    }
    /**
     * Devuelve el numero de sitios libre en la fila seleccionada como parametro
     * 
     * @param row, fila indicada, de tipo int
     */
    
    public int numberOfFreeSeats(int row)
    {
        if(row<0||row>getFirstRows()+getStandardRows())
            throw new RuntimeException("Número de fila incorrecta");
        int cont=0;
        for(int j=0;j<seats[0].length;j++)
            if(seats[row][j]==null)
                cont++;
        return cont;        
    }
    
    public int getNumPax(byte area)
    {
        int cont=0;
        if(area<0|| area>2)
            throw new RuntimeException("el area esta comprendida entre 0 y 2");
        if(area==1)
        {
            for(int i=0;i<firstRows;i++)
                {
                    for(int j=0;j<COLUMNS;j++){
                    if(seats[i][j]!=null)
                    cont++;
                }
                }
            }
        else if(area==2)
        {
            for(int i=firstRows;i<seats.length;i++)
                {
                    for(int j=0;j<COLUMNS;j++)
                    {
                    if(seats[i][j]!=null)
                    cont++;
                    }
                }
            }
         else if(area==0)
         {
             for (int i=0;i<seats.length;i++)
             {
                 for(int j=0;j<COLUMNS;j++)
                 {
                     if(seats[i][j]!=null)
                     cont++;
                    }
                }
            }
            return cont;
                     
    
    }
    
    public int getNumPaxBySection(int row1,int column1,int row2, int column2)
    {
        int cont=0;
        if(row1<0||row1>seats.length||row2<0||row2>seats.length||column1<0||column1>COLUMNS||column2<0||column2>COLUMNS)
            throw new RuntimeException("hay algun parametro no valido");
        for(int i=row1;i<row2;i++)
        {
            for (int j=column1;j<column2;j++)
            {
                if(seats[i][j]!=null)
                cont++;
            }
        }
        return cont;
    }
    
    public void loadPax(int paxNumber)
    {
        if(paxNumber<0||paxNumber>seats.length*seats[0].length)
            throw new RuntimeException("parametro incorrecto");
        for(int i=0;i<seats.length;i++)
        {
            for(int j=0;j<COLUMNS;j++)
            {
                if(seats[i][j]==null)
                paxNumber=paxNumber-1;
            }
        }
    }
    
    public void loadPassengers(int paxNumber)
    {
        Random r= new Random();
        int libres=0;
        for(int i=0;i<seats.length;i++)
            {
                libres+=numberOfFreeSeats(i);
            }
        if(paxNumber>libres)
            throw new RuntimeException("no hay tantos asientos libres");
        int cont=0;
        int f=0;
        int c=0;
        while(cont<paxNumber)
        {
            for(int m=0;m<COLUMNS;m++){
            f=r.nextInt(seats.length);
            c=r.nextInt(seats[m].length);
            if(seats[f][c]==null){
               Person p=new Person();
               seats[f][c]=p;
               cont++;
        
            }
          }
       }
    }
    /**
     * @return numero de dultos en ventanilla
     */
    public int adultsInWindow()
    {
        int numAdultos=0;
        for(int i=0;i<seats.length;i++)
            if(seats[i][0]!=null && seats[i][0].getAge()>=18||seats[i][5]!=null&&seats[i][5].getAge()>=18)
                numAdultos++;
        return numAdultos;           
    }
    
    /**
     * Busca en la matriz todas las personas cuyo nombre se pase como parametro
     * @param person1 nopmbre de la primera persona a buscar de tipo String
     * @param person2 nombre de la segunda
     * @param person3 nombre de la tercera
     * 
     * @return lista con las personasdel avion cuyo nombre coincida con alguno de los parametros
     */
    public ArrayList<Person> seekPeople(String person1,String person2, String person3)
    {
        if(person1==null||person2==null||person3==null)
            throw new RuntimeException("persona no valida");
        ArrayList<Person> listPerson=new ArrayList<Person>();
        for(int i=0;i<seats.length;i++)
        {
            for(int j=0;j<seats[i].length;j++)
            {
                if(seats[i][j].getName().equals(person1)||seats[i][j].getName().equals(person2)||seats[i][j].getName().equals(person3))
                listPerson.add(seats[i][j]);
            }
        }
            return listPerson;
    }
}