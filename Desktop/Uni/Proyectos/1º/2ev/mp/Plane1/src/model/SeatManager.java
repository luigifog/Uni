package model;
import java.util.ArrayList;

public class SeatManager {
public final static int ROW=10;
public final static int COL=4;
public final static int MIN=0;
public int row;
public int col;
public Person[][]seats;

public SeatManager()
{
	seats=new Person[ROW][COL];
}


/**
 * Recibe como parametro a una persona, y la situa en el sityio pasado por parametro si este esta vacio, si no, retorna false
 * 
 * @param person1
 * @param row
 * @param col
 * @return un boolean
 */
public boolean bookSeat(Person person1,int row,int col)
{
	if(person1==null||row<0||row>=ROW||col<0||col>=COL)
	{
		throw new RuntimeException("datos no validos");
	}
	if(seats[row][col]==null)
	{
		seats[row][col]=person1;
		return true;
	}
	return false;
}


/**
 * Mete en un arrayList los pasajeros que esten situados donde las ventanillas, y cuyas edades esten comprendidas en el rango pasado como parametro
 * 
 * @param minAge
 * @param maxAge
 * @return
 */
public ArrayList<Person> findPassengerByAge(int minAge, int maxAge)
{
	if(minAge<0 || minAge>120||maxAge<minAge||maxAge>120)
	{
		return null;
	}
	ArrayList<Person> passenger=new ArrayList<Person>();
	for(int i=0; i<seats.length;i++)
	{
		if(seats[i][0].getAge()>=minAge && seats[i][0].getAge()<=maxAge)
		{
			passenger.add(seats[i][0]);
		}
		if(seats[i][3].getAge()>=minAge && seats[i][3].getAge()<=maxAge)
		{
			passenger.add(seats[i][3]);
		}
	}
	return passenger;
}
public void rellenar(Person p,int row, int col)
{
	seats[row][col]=p;
}



}
