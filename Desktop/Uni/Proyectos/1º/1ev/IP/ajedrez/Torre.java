
/**
 * Write a description of class Torre here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Torre
{
    private final static int MAX_TORRES=8;
    Tablero tablero1=new Tablero();
    public Torre()
    {
        
    }
    public void introducir(int i, int j)
    {
        
        if(i>0 &&i<9 && j>0 &&j<9)
        {
            tablero1.poner('T',i,j);
        }
        tablero1.print();
    }
    public void borrar(int i,int j)
    {
        
        if(i>0 &&i<9 && j>0 &&j<9)
        {
            tablero1.quitar(i,j);
        }
        //tablero1.print();
    }
    
    public void ver()
    {
        
        tablero1.print();
    }
    
    public void comprobar()
    {
       
        System.out.println(tablero1.comprobar());
    }
}
