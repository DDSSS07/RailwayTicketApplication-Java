/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timerapplication;

/**
 *
 * @author 17pw08
 */
public class Time 
{
    public int hour,min,sec;
    
    public Time()
    {
        hour=0;
        min=0;
        sec=0;
    }
    
    public Time(int h,int m,int s)
    {
        hour=h;
        min=m;
        sec=s;
    }
    
    public String toString()
    {
        return hour+":"+min+":"+sec;
    }
    
    public boolean incrementSec()
    {
        sec++;
        if(sec==60)
        {
            sec=0;
            min++;
            if(min==60)
            {
                min=0;
                hour++;
                if(hour==24)
                {
                    hour=0;
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean equals(Object o)
    {
        if(((Time)o).hour==hour && ((Time)o).min==min && ((Time)o).sec==sec)
        {
            return true;
        }
        
        return false;
    }
}
