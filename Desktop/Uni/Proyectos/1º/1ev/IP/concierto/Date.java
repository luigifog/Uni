
/**
 * Write a description of class Date here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Date
{
    private int day;
    private int month;
    private int year;   
    
    public Date(int day, int month, int year)
    {
    setDate(day,month,year);
    }
    public void setDate(int newDay, int newMonth, int newYear)
    {
        if(newMonth>0 && newMonth<=12)
        month=newMonth;
        
        if(newMonth==1|| newMonth==3|| newMonth==5|| newMonth==7|| newMonth==8|| newMonth==10|| newMonth==12);
            if (newDay>0 && newDay<=31)day=newDay;
        else 
        System.out.println("dia no correcto");
        if(newMonth==4||newMonth==6||newMonth==9||newMonth==11);
        if (newDay>0 && newDay<=30)day=newDay;
        else 
        System.out.println("dia no correcto");
        if(newMonth==2)
        if (newDay>0 && newDay<=28)day=newDay;
        else 
        System.out.println("dia no correcto");
        
        year=newYear;
         
       
        } 
        
        private void setDay(int newDay)
    {
        if (newDay>0 && newDay<=31)
        day=newDay;
    }
    
    public int getDay()
    {
        return day;
    }
    
    private void setMonth(int newMonth)
    {
        if(newMonth>0 && newMonth<=12)
        month=newMonth;
    }
    
    public int getMonth()
    {
        return month;
    }
    
    private void setYear(int newYear)
    {
        year=newYear;
    }
    
    public int getYear()
    {
        return year;
    }
}
