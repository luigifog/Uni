
/**
 * Write a description of class Motor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Motor
{
    
    private String[][] tablero;
    private final static int DEF=4;
    public Motor()
    {
        tablero=new String[DEF][DEF];
    }
    
    public void print()
    {
        int contx=0;
        int conty=0;
        for(int i =1;i<tablero.length;i++)
        {
            tablero[i][0]=Integer.toString(contx);
            contx++;
            tablero[0][i]=Integer.toString(conty);
            conty++;
          }
        for(int j=0;j<tablero.length;j++)
        {
            for(int k=0;k<tablero.length;k++)
            {
                if(tablero[j][k]==null)
                {
                    tablero[j][k]=" ";
                }
            }
        }
        for(int j=0;j<tablero.length;j++)
        {   
            System.out.println(" ");
            for(int k=0;k<tablero.length;k++)
            {
                System.out.print(tablero[j][k]);
            }
        }
        
    }
    
    public boolean tableroCompleto()
    {
        int cont=0;
        for(int j=0;j<tablero.length;j++)
        {
            for(int k=0;k<tablero[0].length;k++)
            {
               if(tablero[j][k]==" ")
               {
                   cont++;
               }
            }
        }
        if(cont!=0)
        {
            return false;
        }
        return true;
    }
    
    public boolean ocuparCasilla(int x, int y, String name)
    {
        if(name== "X"||name=="O")
        {
            if(tablero[x][y]==" ")
            {
                tablero[x][y]=name;
                return true;
            }
            
        } 
        return false;

    }
    
    public int cuantasf(int f,String name)
    {
        int cont=0;
            if(name!="X" ||name!="O")
        {
            throw new RuntimeException("datos no correctos");
        }
        for(int j=0;j<tablero.length;j++)
        {
            if(tablero[f][j]== name)
            cont++;
        }
        return cont;
    }
    
        public int cuantasc(int f,String name)
    {
        int cont=0;
            if(name!="X" ||name!="O")
        {
            throw new RuntimeException("datos no correctos");
        }
        for(int j=0;j<tablero.length;j++)
        {
            if(tablero[j][f]== name)
            cont++;
        }
        return cont;
    }
    
    public String hayGanador()
    {
        int cont=0;
        int cont2=0;
        for(int j=0;j<tablero.length;j++)
        {
            cont=0;
            cont2=0;
            for(int k=0;k<tablero[0].length;k++)
            {
                if(tablero[j][k]=="X")
                {
                    cont++;   
                }
                if(cont==3)
                {
                    return("ganan las X");
                }
                if(tablero[j][k]=="O")
                {
                    cont2++;   
                }
                if(cont2==3)
                {
                    return("ganan las O");
                }
                
            }
        }
        
        for(int j=0;j<tablero.length;j++)
        {
            cont=0;
            cont2=0;
            for(int k=0;k<tablero[0].length;k++)
            {
                if(tablero[k][j]=="X")
                {
                    cont++;   
                }
                if(cont==3)
                {
                    return("ganan las X");
                }
                if(tablero[k][j]=="O")
                {
                    cont2++;   
                }
                if(cont==3)
                {
                    return("ganan las O");
                }
                
            }
        }
        for(int j=0;j<tablero.length;j++)
        {
            cont=0;
            cont2=0;
        }
        return("tablas");
    }
}
