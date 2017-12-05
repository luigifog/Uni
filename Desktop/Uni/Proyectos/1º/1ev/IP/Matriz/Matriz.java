import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class Matriz here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Matriz
{
    private int[][] numeros;
    public final static int MAX_NUM=20;
    public Matriz (int maxNum)
    {
        if(maxNum >0 && maxNum<=MAX_NUM)
        {
            numeros= new int [maxNum][maxNum];
            genRandom();
        }
        
           
    }
    
    public Matriz(int [][]m)
    {
        numeros=m;
    }
    
      private void genRandom()
    {
        Random r=new Random();
        for(int i=0; i < numeros.length ; i++)
            {
                for(int j=0; j < numeros[i].length ; j++)
                {
                    numeros[i][j]=r.nextInt(50)+1;
                }
            }
    }
    
    public void printMatrix()
    {
        for(int i=0; i < numeros.length ; i++)
            {
                  
                for(int j=0; j < numeros[i].length ; j++)
                {
                    System.out.print(numeros[i][j]+" ");
                }
                System.out.println();
            }
            huecos();
    }
    
     public void huecos()
    {
        System.out.println(" ");
        System.out.println(" ");
    }
    
    public void invertirDiagonales()
    {
        for(int i=0; i<numeros.length/2;i++)
            {
                int aux=numeros[i][i];
                numeros[i][i]=numeros[numeros.length-1-i][numeros.length-1-i];
                numeros[numeros.length-1-i][numeros.length-1-i]=aux;
            }
        for(int i=0; i<numeros.length;i++)
            {
                int aux=numeros[i][numeros.length-1-i];
                numeros[i][numeros.length-1-i]=numeros[numeros.length-1-i][i];
                numeros[numeros.length-1-i][i]=aux;
            }
        toStringNum();
        huecos();
    }
    
    public String toStringNum()
    {
       String cad="";
       for(int i=0; i < numeros.length ; i++)
       {
            for(int j=0; j < numeros[i].length ; j++)
           {
               cad+=numeros[i][j]+"";
           }
           cad+="\n";
       }
       return cad;
    }
    
    public void sumaFilas()
    {
        int aux[]=new int [numeros.length];
        int aux2=0;
        for(int i=0; i < numeros.length ; i++)
        {
           aux2=0;
           for(int j=0; j < numeros[i].length ; j++)
           {
              aux2=aux2+numeros[i][j];
           }
           aux[i]=aux2;
        }
        for(int i=0; i < numeros.length; i++)
        {
            System.out.println(aux[i]);
        
        }
        huecos();
    }
    
    public void cambioColumnas()
    {
        int aux=0;
        for(int i=0; i < numeros.length ; i++)
        {
            aux=numeros[i][0];
           for(int j=1; j < numeros[i].length ; j++)
           {
               numeros[i][j-1]=numeros[i][j];
           }
           numeros[i][numeros[i].length-1]=aux;
        }
    
        for(int i=0; i < numeros.length ; i++)
        {
            for(int j=0; j < numeros[i].length ; j++)
            {
                System.out.print(numeros[i][j]+" ");
            }
            System.out.println();
        }
        huecos();
    }
    
    public void printPos()
    {
        for(int i=0; i < numeros.length ; i++)
        {
            for(int j=0; j < numeros[i].length ; j++)
            {
                System.out.println(numeros[i][j]+"="+"("+ i+","+j+")");
            }
            System.out.println(" ");
        }
        huecos();
    }
    
    public int mayorAdyacente(int fila, int columna)
    {
        int mayor=0;
        int extremo= numeros.length;
        for(int i=fila-1;i<=fila+1;i++)
        {
            for(int j=columna-1;j<=columna+1;j++)
            {
                if(i>=0 && i<numeros.length&& j>=0 && j<numeros[0].length)
                {
                    if (mayor<numeros[i][j])
                    {
                        mayor=numeros[i][j];
                    }
                }
            }
        }
        return mayor;
    }
    
    public void rotar()
    {
        int aux[][]=new int[numeros.length][numeros.length];
        for(int i=0; i < numeros.length ; i++)
        {
            for(int j=0; j < numeros[i].length ; j++)
            {
                aux[j][numeros.length-1-i]=numeros[i][j];
            }
        }
        
        for(int i=0; i < numeros.length ; i++)
        {
            for(int j=0; j < numeros[i].length ; j++)
            {
                System.out.print(aux[i][j]+" ");
            }
            System.out.println(" ");
        }
        huecos();
    }
    
    public int[][] copiar()
    {
        int aux[][]=numeros;
        int k=0;
        for(int i=0; i < numeros.length ; i++)
        {
           for(int j=1; j < numeros[i].length ;j+=2)
           {
                k=j+1;
               if(k<numeros[0].length)
               {
                  
                   aux[i][k]=numeros[i][j];
               }
           }
        }
        for(int i=0; i < numeros.length ; i++)
          {
              for(int j=1; j < numeros[i].length ; j++)
              {
                  System.out.print(aux[i][j]+" ");
              }
              System.out.println(" ");
          }
        return aux;
    }
    
    public void invertir()
    {
        int aux[][]=copiar();
        int aux2[][]=aux;
        for(int i=0; i <= (aux.length)/2 ; i++)
        {
           for(int j=1; j < aux.length ;j+=2)
           {
               aux[i][j]=aux2[aux.length-1-i][j];
           }  
        }
        for(int i=0; i<aux.length;i++)
        {
            for(int j=0;j<aux.length;j++)
            {
                if(aux[i][j]!=aux2[i][j])
                {
                    aux[i][j]=aux2[i][j];
                }
            }
        }
        for(int i=0; i < numeros.length ; i++)
          {
              for(int j=1; j < numeros[i].length ; j++)
              {
                  System.out.print(aux[i][j]+" ");
              }
              System.out.println(" ");
          }
        huecos();
    }
    
    public String puntoSilla()
    {
        int aux=0;
        for(int i=0; i < numeros.length ; i++)
        {
            for(int j=1; j < numeros[i].length ;j++)
            {
                
            }
        }
        return "a";
    }
    
}



