/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timerapplication;
import dateapplication.Date;
/**
 *
 * @author 17pw08
 */
public class Calendar 
{
    private Date date;
    private Time time;
    private boolean read=false;
    
    public Calendar(Date d,Time t)
    {
        date=d;
        time=t;   
    }
    
    public synchronized void tick()
    {
            try
            {   //while(read==false)
                  
                if(time.incrementSec()==true)
                    date.addDays(1);
                read=true;
                wait();
                read=false;
            }
            
            catch(InterruptedException e)
            {
                System.out.println(e);
            }
            
    }
    
     public synchronized String toString()
    {
        //try
        {
            //if(read==true)
            {    
                System.out.print(date+" "+time);
                notify();
                return "";
            }    
            //return " ";
        }
    }
     
    public boolean equals(Object o)
    {
        if(((Calendar)o).date.equals(date) && ((Calendar)o).time.equals(time))
        {
            return true;
        }
        
        return false;
    }
}
