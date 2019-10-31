/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railwayticketapplication;
import timerapplication.*;
import dateapplication.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ddsss
 */
public class DynamicPricer implements Runnable
{
    private Time limit;
    private Time tmr;
    Train train;
    
    public DynamicPricer(Time t,Train tr)
    {
        Time limit=t;
        tmr=new Time(0,0,0);
        train=tr;
    }
    
    public void incrementSec()
    {
        tmr.sec++;
        if(tmr.sec==60)
        {
            tmr.sec=0;
            tmr.min++;
            if(tmr.min==60)
            {
                tmr.min=0;
                tmr.hour++;
                if(tmr.hour==24)
                {
                    tmr.hour=0;
                }
            }
        }
        
        if(tmr.equals(limit))
        {
            tmr.hour=0;
            tmr.min=0;
            tmr.sec=0;
            train.priceHike();
        }
    }
    
    public void run()
    {
        while(true)
        {
            try
            {
                Thread.sleep(1000);
                incrementSec();
            }
            
            catch(InterruptedException e)
            {
                System.out.println(e);
            }  
        }
    }
}
