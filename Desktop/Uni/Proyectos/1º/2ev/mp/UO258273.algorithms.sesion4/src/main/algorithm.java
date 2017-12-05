package main;

public class algorithm {
/**
 * Metodo que busca un objeto recibido como parametro en un vector recibido como parametro
 * 
 * @param vertor de obj
 * @param obj a buscar en el vector
 * @return posicion en el vector donde encuentra el obj
 */
	
	public static int search(Object[] vector, Object object)
	{
		for(int i=0; i<vector.length;i++)
		{
			if(vector[i]==object)
				return i;
		}
		return -1;
	}
}
