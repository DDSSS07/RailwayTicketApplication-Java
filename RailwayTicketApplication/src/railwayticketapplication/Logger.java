/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railwayticketapplication;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
/**
 *
 * @author ddsss
 */
public class Logger implements Runnable
{
    List<Ticket> Tickets;
    public Logger(List<Ticket> ticket)
    {
        Tickets=ticket;
    }
    
    synchronized void prepareChart() throws IOException
    {
        for(Ticket t:Tickets)
        {
            String id=Integer.toString(t.getTrain().getID())+".txt";
            try 
            {
                FileOutputStream file=new FileOutputStream(id,true);
                ObjectOutputStream fos=new ObjectOutputStream(file);
                fos.writeObject(t);
                fos.close();
                file.close();
            } catch (FileNotFoundException ex) {
                java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }
    
    public void run()
    {
        try {
            prepareChart();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
