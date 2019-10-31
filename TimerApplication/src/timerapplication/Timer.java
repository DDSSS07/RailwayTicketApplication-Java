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
public class Timer implements Runnable 
{
    Calendar cal;
    
    
    public Timer(Calendar c)
    {
        cal=c;
    }
    
    public void run()
    {
        while(true)
        {
            try
            {
                Thread.sleep(1000);
                cal.tick();
            }
            
            catch(InterruptedException e)
            {
                System.out.println(e);
            }  
        }
    }
}
