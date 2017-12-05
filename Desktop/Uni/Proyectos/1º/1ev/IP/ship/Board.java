import java.util.ArrayList;
/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board
{
    private final static int MIN=5;
    private final static int MAX=10;
    private Ship[][] ships;
    
    public Board(int row,int col)
    {
        if(row<MIN|| col<MIN||row>MAX|| col>MAX)
        {
            ships=new Ship[MIN][MIN];
        }
        ships=new Ship[row][col];
    }
    
    public boolean placeShip(Ship barco,int row)
    {
        int cont=0;
        if(barco==null||row>=MIN||row<0)
        {
            throw new RuntimeException("datos no correctos");
        }
        for(int i=0;i<ships[0].length;i++)
        {
            if(ships[row][i]==null)
            {
                ships[row][cont]=barco;
                return true;
            }
        }
        
        return false;
    }
    
    public void rellenar()
    {
        Ship ship=new Ship();
        for(int i=0;i<ships.length;i++)
        {
            for(int j=0;j<ships[0].length;j++)
            {   
               if(ships[i][j]!=null)
               {
                   ships[i][j]=null;
               }
            }
        }
        for(int i=0;i<ships.length;i++)
        {
            for(int j=0;j<ships[0].length;j++)
            {
                ships[i][j]=ship;
            }
        }
    }
    
    public boolean bombShip(int row, int col, int pot)
    {
        //excepcion pa row y col
        if( ships[row][col]!=null)
        {
            if(ships[row][col].getSubmarine()==false)
            {
                if(ships[row][col].getRes()<=pot)
                {
                    ships[row][col]=null;
                    return true;
                }
            }
        }
        return false;
    }
    
    public int countSubmarines()
    {
        int cont=0;
        for(int i=0;i<ships.length;i++)
        {
            for(int j=0;j<ships.length;j++)
            {
                if(ships[i][i].getSubmarine()==true)
                {
                    cont++;
                }
            }
        }
        return cont;
    }
    
    public ArrayList<String> shipNames(int col)
    {
        ArrayList<String> name=new ArrayList<String>();
        for(int i=0;i<ships.length;i++)
        {
            if(ships[i][col]!=null)
            {
                name.add(ships[i][col].getName());
            }
        }
        return name;
    }
    
    
}