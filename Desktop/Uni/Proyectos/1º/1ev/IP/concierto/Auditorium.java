import java.util.ArrayList;
/**
 * Write a description of class Auditorium here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Auditorium
{
    private int fecha;
    
    private String nombreDeLaLista;
    private ArrayList<Concert>conciertos;
    private Concert concert;
    /**
     * Constructor de auditorios
     * 
     * @param nameA, define el nombre del auditorio tipo String
     * @param name, define el nombre del concierto tipo String
     * @param date es la fecha del concierto tipo Date
     * @param price define el precio del concierto de tipo int
     */
    public Auditorium(String nameA,String name,Date date, int price)
    {
        nombreDeLaLista=nameA;
        concert=new Concert(name,date,price);
        conciertos=new ArrayList<Concert>();
    }

    
    
    /**
     * Busca el concierto por su nombre
     * 
     * @param concertName, es el nombre del concierto
     */
    public void seekConcert(String concertName,Date date, int price)
    {
        Concert concert1=new Concert(concertName,date,price);
        if (concert1.getName()!=concertName)
            throw new RuntimeException("no hay ningun concierto con ese nombre");
        else
        conciertos.get(concert1);
    
    
    
    }
    /**
     * Borra todos los conciertos del año elegidos
     * 
     * @param year, año elegido para borrar dichos conciertos
     */
    public void removeConcerts(int year)
    {
        fecha=concertos.getDate().setYear(year);
        Concert concert1=new Concert();
        conciertos.remove(fecha);
    }
   
   /**

     * Añade un concierto a la lista sólo si no hay otro en la misma fecha

     * @param concertName nombre del nuevo concierto

     * @param date fecha del concierto

     * @param precio número doble para el precio del concierto

     * 

     */

    public void addConcert(String concertName, Date date, double price)

    {

        if (concertName == null || date == null || price < 0 )

            throw new RuntimeException("Parámetro para addConcert incorrecto");

        

        

        boolean sameDate = false;

        for (int i= 0; i < concerts.size() && sameDate == false; i++)     // fijaos que lleva dos condiciones para acabar

        {

            if ( isSameDate(concerts.get(i).getDate(), date) )              // se llama a un método privado que calcula si es la misma

                sameDate = true;

            

        }

        

        

        if (! sameDate)

            concerts.add(new Concert(concertName, price,date));

    

     }    

        

     private boolean isSameDate(Date date1, Date date2)

     {

         return date1.getDay() == date2.getDay() &&

                date1.getMonth() == date2.getMonth() &&

                date1.getYear() == date2.getYear();

      }
}

