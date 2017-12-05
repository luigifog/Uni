
/**
 * Write a description of class Potentiometer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Potentiometer
{
   public int position=0;
   
   public final static int  MIN_MOVE=0;
   public final static int MAX_MOVE=10;
  
   public void setMovePosition(int newPosition)
   {
        if (newPosition>=MIN_MOVE)
        {
        
        if(newPosition<=MAX_MOVE)
            position=newPosition;
        }
    }
    
    public int getMovePosition()
    {
    return position;
    }
   
    public void put0()
    {
    position =0;
    }
    
    public void put10()
    {
    position  =10;
    }

     public String toString()
     {
     return ""+getMovePosition();
 }
}
