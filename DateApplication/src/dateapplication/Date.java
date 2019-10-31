/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dateapplication;

/**
 *
 * @author 17pw08
 */

public class Date implements Comparable 
{
    private int day,month,year;
    
    public Date(int dd,int mm,int yyyy)
    {
        day=dd;
        month=mm;
        year=yyyy;
    }
    
    public String toString()
    {
        //return Integer.toString(day)+"/"+Integer.toString(month)+"/"+Integer.toString(year);
        return day+"/"+month+"/"+year;
    }
    
    public int difference(Date date2)
    {
       int days1=0,days2=0;
       int[] monthDays={31,28,31,30,31,30,31,31,30,31,30,31};
       
       for(int i=0;i<month;i++)
       {
           days1+=monthDays[i];
       }
       for(int i=0;i<(date2).month;i++)
       {
           days2+=monthDays[i];
       }
       
       days1+=365*year+day;
       days2+=365*(date2).year+(date2).day;
       
       int leapYears=0;
       
       if(month<=2)
           leapYears=--year;
       days1+=leapYears / 4 - leapYears / 100 + leapYears / 400;
       
       if(date2.month<=2)
           leapYears=--(date2).year;
       days2+=leapYears / 4 - leapYears / 100 + leapYears / 400;
       
       return Math.abs(days1-days2);  
    }
    
    /*public int compare(Date ((Date)o))
    {
         if(year>((Date)o).year)
             return 1;
         else if(year<((Date)o).year)
             return -1;
         else
         {
            if(month>((Date)o).month)
             return 1;
            else if(month<((Date)o).month)
             return -1;
            else
            {
                if(day>((Date)o).day)
                    return 1;
                else if(day<((Date)o).day)
                    return -1;
                else
                    return 0;
            }
         }
    }*/
    
    public  void addDays(int days)
    {   
        //int rem=0;
        
        int[] monthDays={31,28,31,30,31,30,31,31,30,31,30,31};
        
        if( (year%400==0 || year%4==0) && !(year%100==0))
                monthDays[1]=29;
        
        day=day+days;
        
        while(day>monthDays[month-1])
        {
            day=day-monthDays[month-1];
            month++;
            if(month>12)
            {
              year++;
              month=1;
              if( (year%400==0 || year%4==0) && !(year%100==0))
                monthDays[1]=29;
            }
            
            
            /*if(day==0)
                day++;*/
        }
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Date)
        {
            if(((Date)o).day==day && ((Date)o).month == month && ((Date) o).year==year)
            {
                return true;
            }
            
            else
                return false;
        }
        else 
            return false;
    }
    
    @Override
    public int compareTo(Object o)
    {
        if(year>((Date)o).year)
             return 1;
         else if(year<((Date)o).year)
             return -1;
         else
         {
            if(month>((Date)o).month)
             return 1;
            else if(month<((Date)o).month)
             return -1;
            else
            {
                if(day>((Date)o).day)
                    return 1;
                else if(day<((Date)o).day)
                    return -1;
                else
                    return 0;
            }
         }
    }
    
}
