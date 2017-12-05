import java.util.ArrayList;
import java.util.HashSet;
/**
 * Write a description of class Tram here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tram
{
    public static final int MIN_ROWS = 5;  //número mínimo de filas
    public static final int MAX_ROWS = 20;  // número máximo de filas
    public static final int COLUMNS = 4;
    private Person[][] seats;

    /**
     * Constructor for objects of class Tram
     */
    public Tram()
    {
        seats=new Person[MAX_ROWS][COLUMNS];
    }

    /**
     * Tram Constructor
     *
     * @param rows número de filas entre 5 y 20
     */
    public Tram(int rows)
    {
       if(rows>MAX_ROWS || rows<MIN_ROWS)
        throw new RuntimeException("numero de fila no valido");
       seats=new Person[rows][COLUMNS];
    }

    /**
     * Método que devuelve un valor booleano true si ha podido sentar a una persona, false en caso contrario
     * (el asiento estaba ocupado o parámetros incorrectos).
     *
     * @param row número de fila
     * @param column número de columna 
     * @param person el objeto persona
     * @return true si ha podido sentar a una persona, false en caso contrario
     */
    public boolean seatPerson(int row, int column, Person person)
    {
        if (person != null && row >= 0 && row <= seats.length && column >= 0 && column <=seats[0].length)
            if (seats[row][column] == null)
            {
                seats[row][column]= person;
                return true;
            }      
        return false;
    }

    /**
     * Método que devuelve un ArrayList con los pasajeros (Person) sentados en dicha fila
     *
     * @param row número de fila
     * @return una colección ArrayList con los pasajeros de la fila o null si el parámetro es incorrecto
     */
    public ArrayList<Person> passengersInRow(int row)
    {
        if(row<0||row>MAX_ROWS)
            return null;
            
        ArrayList<Person> passengersInRow=new ArrayList<Person>();
        for(int j=0;j<COLUMNS;j++)
            {
                if(seats[row][j]!=null)
                passengersInRow.add(seats[row][j]);
            }
            return passengersInRow;
    }

    /**
     * Método que devuelve un entero con el número de adultos sentados en alguna de las ventanillas laterales del tranvía
     *(primera y última columna).
     *
     * @return número de adultos sentados en alguna de las ventanillas
     */
    public int adultsInWindow()
    {
        int cont=0;
        for(int i =0;i<seats.length;i++)
            {
                if(seats[i][0]!=null && seats[i][0].getAge()>=18)
                    cont++;
                if(seats[i][4]!=null && seats[i][4].getAge()>=18)
                    cont++;
            }
            return cont;
    }
    
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

//     /**
//      * Método que recibe un conjunto de personas y les asigne un asiento libre. 
//      * Si hay más personas que asientos libres se ocuparán todos los asientos libres.
//      *
//      * @param persons el conjunto de personas
//      */
//     public void seatPersonSet(HashSet<Person> persons)
//     {
//         for (int i=0;i<seats.length;i++)
//             for(int j=0;j<seats[i].length;j++)
//             if(seats[i][j]==null)
//             {
//                 bookSeat(persons,i,j);
//             }
//     }
}
