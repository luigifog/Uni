
/**
 * Write a description of class Tablero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tablero
{
    private final static int CUADROS=10;
    private char[][] tablero;
    
    public Tablero()
    {
        char contx='0';
        char conty='0';
        tablero=new char[CUADROS][CUADROS];
        for(int i=0;i<tablero.length;i++)
        {
            tablero[i][0]=contx;
            tablero[i][9]=contx;
            contx++;
        }
        for(int j=0;j<tablero.length;j++)
        {
            tablero[0][j]=conty;
            tablero[9][j]=conty;
            conty++;
        }
        for(int k=1;k<tablero.length-1;k++)
        {
            for(int w=1;w<tablero.length-1;w++)
            {
                tablero[k][w]=' ';
            }
        }
    }
    
    public void print()
    {
        for(int i=0;i<tablero.length;i++)
        {
            System.out.println(" ");
            for(int j=0;j<tablero.length;j++)
            {
                System.out.print(tablero[i][j]+" ");
            }
        }
    }
    
    public void poner(char fig, int i, int j)
    {
        tablero[i][j]=fig;
    }
    
    public void quitar(int i, int j)
    {
        if (tablero[i][j]!=' ')
        {
            tablero[i][j]=' ';
        }
    }
    
    public String comprobar()
    {
        int contf=0;
        int contc=0;
        for(int i=1;i<tablero.length-1;i++)
        {
            contf=0;
            contc=0;
            for(int j=1;j<tablero.length-1;j++)
            {
                if(tablero[i][j]!=' ')
                {
                    contf++;
                }
                if(tablero[j][i]!=' ')
                {
                    contc++;
                }
                }
            
            if(contf>=2||contc>=2)
            {
                return ("torre amenazada");
            }
        }
        return ("ninguna torre amenazada");
    }
    }

