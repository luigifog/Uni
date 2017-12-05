
/**
 * Write a description of class Wheel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wheel
{
   
    
         public double maxPressure;
         public double pressure;
         
         public final static int THRESHOLD =85;
         public Wheel()
         {
            setPressure(0);
            setMaxPressure(0);
            }
         public Wheel( double maxPressure,double pressure)
         {this();
             setMaxPressure(maxPressure);
             setPressure(pressure);
            
            
            }
            
            public double getMaxPressure()
            {
            return maxPressure;
           
        }
            
            public double getPressure()
            {
            return pressure;
        }
        private void setPressure(double pressure)
        {
        if(pressure>=0 && pressure<=getMaxPressure())
        this.pressure=pressure;
        }
        
        private void setMaxPressure(double maxPressure)
        {
        if (maxPressure>=0)
        this.maxPressure=maxPressure;
        }
        
        public boolean test()
        {
        if(pressure>= maxPressure*THRESHOLD/100)
          return true;
        else
          return false;
        }
         
        public void print()
        {
        String OkoFail="";
        if(test()==true)
        OkoFail="OK";
        else
        OkoFail="FAIL";
        
        System.out.println("Max Pressure...." +maxPressure+ "MB");
        System.out.println("Current pressure....."+pressure+ "MB("+ pressure/maxPressure*100);
        System.out.println("Test........."+ OkoFail);
        }
        public String toString()
        {
        
        return "maxPressure"+String.format("%.2f",getMaxPressure())+" Mb.Pressure "+
        ((getMaxPressure()*100)/maxPressure);
        
        }
       
        
}
