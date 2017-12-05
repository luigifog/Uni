package sesion3_dome_inicial;

import java.io.PrintStream;
import java.util.ArrayList;

public class Database {
	private ArrayList<Item> items;
	
	public Database()
	{
		items=new ArrayList<Item>();
	
	}
	
	/**
	 * Metodo que a�ade elementos a la base de datos
	 * @param item a a�adir
	 */
	public void add(Item itemToAdd)
	{
		checkNotNull(itemToAdd);
		items.add(itemToAdd);
	}
	/**
	 * comprueba que ese item existe
	 * @param itemToCheck
	 */
	private void checkNotNull(Item itemToCheck)
	{
		if (itemToCheck==null)
				{throw new RuntimeException("datos no correctos");}
	}
	/**
	 * Calcula y devuelve el numero de items con propietario
	 * @return numero de items con propietario
	 */
	public int numberOfItemsOwned()
	{
		int cont=0;
		for(Item itemToCheck: items)
			if(itemToCheck.getOwn())
				cont++;
		return cont;
	}
	/**
	 * Busca un item pasado por parametro
	 * 
	 * @param theItem
	 * @return
	 */
	public int searchItem(Item theItem)
	{
		if(theItem==null)
		{
			throw new RuntimeException("datos no correctos");
		}
		for(int i=0;i<items.size();i++)
		{
			if (items.get(i)==theItem)
				return i;
		}
		return -1;
	}
	/**
	 * junta todo el tiempo de reproduccion de los items
	 * 
	 * @return
	 */
	public int gatherAllTime()
	{
		int suma=0;
		for(int i=0;i<items.size();i++)
		{
			suma+=items.get(i).getPlayingTime();
		}
		return suma;
	}
	/**
	 * Devuelve el autor o lo que sea que lo hizo
	 * 
	 */
	public void printResponsables(PrintStream out)
	{
		for(int i=0;i<items.size();i++)
		{
			if(items.get(i).getOwn()==true)
			{
				out.println(items.get(i).getResponsable());
			}
		}
	}
	/**
	 * Imprime todos los items
	 * 
	 * @param out
	 */
	public void list(PrintStream out)
	{
		for(Item i: items)
		{
			out.print(i.toString());
		}
	}
	/**
	 * Devuelve las tres primeras letras de todos los items
	 * 
	 * @return
	 */
	public String generateCode()
	{
		String cadena="";
		for(int i=0;i<items.size();i++)
		{
			cadena+=items.get(i).generateSubstring()+"-";
		}
		return cadena;
	}
	/**
	 * Devuelve lo que cuestan todos los items
	 * 
	 * @return
	 */
	public double totalPrice()
	{
		double total=0.0;
		for(int i=0;i<items.size();i++)
		{
			total=total+items.get(i).getPrice();
		}
		return total;
	}
	/**
	 * lista de todos los items prestables
	 * 
	 * @return
	 */
	public String borrowableList()
	{
		String cadena="";
		for(int i=0;i<items.size();i++)
		{
			if(items.get(i) instanceof Borrowable)
			{
				cadena+=items.get(i).generateSubstring()+"-";
			}
		}
		return (("los objetos prestables son: "+cadena));
	}
	/**
	 * Devuelve lista de todos los items prestables que no han sido prestados
	 * 
	 * @return
	 */
	public String freeToUse()
	{
		String cadena="";
		for(int i=0;i<items.size();i++)
		{
			if(items.get(i) instanceof Borrowable)
			{
				if(items.get(i).getOwn()==true)
				{
					Borrowable b=(Borrowable)items.get(i);	
					if(b.isPrestado()==false)
					{
						cadena+=items.get(i).getTitle();
					}
				}
			}
		}
		return (("los objetos libres para usar son: "+cadena));
	}
	
	public void prestar(Item it)
	{
		for(int i=0;i<items.size();i++)
		{
			if(items.get(i) instanceof Borrowable)
			{
				if(items.get(i).getTitle().equals(it.getTitle()))
				{
					Borrowable b=(Borrowable)items.get(i);	
					b.prestar();
				}
			}
		}
	}
	
	
	public void devolver(Item it)
	{
		for(int i=0;i<items.size();i++)
		{
			if(items.get(i) instanceof Borrowable)
			{
				if(items.get(i).getTitle()==it.getTitle())
				{
					Borrowable b=(Borrowable)items.get(i);	
					b.devolver();
				}
			}
		}
	}
}

