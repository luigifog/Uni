
/**
 * Write a description of class Concert here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Concert
{
    private String name;
    private int price;
    private int day;
    private int month;
    private int year;
    private Date date;
    
    
    public Concert(String name,Date date, int price)
    {
        setName(name);
        setDate(date);
        setPriceAmmount(price);
        
    }
   
//     public Concert(int day, int month, int year)
//     {
//         this();
//         setDay(day);
//         setMonth(month);
//         setYear(year);
//         
//     }
    private void setName(String newName)
    {
        name=newName;
    }
    
    public String getName()
    {
        return name;
    }
    
    private void setPriceAmmount(int ammount)
    {
        price=ammount;
    }
    
    public int getPriceAmmount()
    {
        return price;
    }
    
    private void setPrice(String type)
    {
        if (type=="vip")
        price=price*2;
        else if(type=="normal")
        price=price;
        else
        System.out.println("la opcion escogida no es correcta");
    }
    
    public int getPrice()
    {
        return price;
    }
    
    public void knowPrice(String type)
    {
        if(type=="vip"|| type=="normal")
        setPrice(type);
        else
        System.out.println("tipo de entrada no correcta");
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
    
    public void setDate(Date newDate)
    {
        date=newDate;
    }
    
    public Date getDate()
    {
        return date;
    }
    
//     public void setDate(int newDay, int newMonth, int newYear)
//     {
//         if(newMonth>0 && newMonth<=12)
//         month=newMonth;
//         
//         if(newMonth==1|| newMonth==3|| newMonth==5|| newMonth==7|| newMonth==8|| newMonth==10|| newMonth==12);
//             if (newDay>0 && newDay<=31)day=newDay;
//         else 
//         System.out.println("dia no correcto");
//         if(newMonth==4||newMonth==6||newMonth==9||newMonth==11);
//         if (newDay>0 && newDay<=30)day=newDay;
//         else 
//         System.out.println("dia no correcto");
//         if(newMonth==2)
//         if (newDay>0 && newDay<=28)day=newDay;
//         else 
//         System.out.println("dia no correcto");
//         
//         year=newYear;
//          
//        
//         } 
    
   
}
