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
public class TimerApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Date d=new Date(31,12,1999);
        Time t=new Time(23,59,55);
        Calendar c=new Calendar(d,t);
        Timer tmr=new Timer(c);
        TimeDisplay disp=new TimeDisplay(c);
        Thread t1=new Thread(tmr);
        Thread t2=new Thread(disp);
        t1.start();
        t2.start();      
    }
    
}
