/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railwayticketapplication;
import java.util.logging.Level;
import java.util.logging.Logger;
import timerapplication.*;

/**
 *
 * @author ddsss
 */
public class Train 
{
    private int trainID;
    private String src;
    private String dest;
    private Calendar cal;
    private int availableTickets;
    private int price;
    private DynamicPricer timer;
    
    public Train(int ID,String s,String d,Calendar c,int price,int available)
    {
        trainID=ID;
        src=s;
        dest=d;
        cal=c;
        this.price=price;
        availableTickets=available;
        timer=new DynamicPricer(new Time(1,0,0),this);
        Thread t=new Thread(timer);
        t.start();
    }
    
    int getID()
    {
        return trainID;
    }
    
    String getSrc()
    {
        return src;
    }
    
    String getDest()
    {
        return dest;
    }
    
    Calendar getCal()
    {
        return  cal;
    }
    
    
    synchronized public boolean book()
    {
        while(availableTickets<=0)
        {
            try {
                wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(Train.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        }
        availableTickets--;
        return true;
          
    }
    
    synchronized void cancel()
    {
        availableTickets++;
        notifyAll();
    }
    
    
    public String toString()
    {
        return "\n"+trainID+" | "+src+" - "+dest+" | Rs."+price+" | Tickets:"+availableTickets;
    }

    synchronized void priceHike() 
    {
        price+=100;
    }
    
    
}
