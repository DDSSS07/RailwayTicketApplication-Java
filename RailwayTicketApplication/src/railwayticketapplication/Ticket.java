/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railwayticketapplication;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import timerapplication.*;
import java.util.Scanner;
/**
 *
 * @author ddsss
 */

enum Option
{
    buy,cancel;
}
public class Ticket implements Runnable 
{
    private int ticketID;
    private Train train;
    private Customer customer;
    Option option;
    List<Ticket> tickets=new ArrayList<Ticket>();
    
    
    public Ticket(Train tr,Customer c,Option o,List<Ticket> tckts)
    {
        Random rand = new Random();
        ticketID=rand.nextInt(10000);
        train=tr;
        customer=c;
        option=o;
        tickets=tckts;
    }
    
    void buy()
    {
        boolean success=train.book();
        if(success==true)
        {
           tickets.add(this);
           System.out.println("Ticket ID:"+ticketID);
        }
    }
    
    void cancel()
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the ticket ID to be cancelled:");
        int tid=s.nextInt();
        for(Ticket t:tickets)
        {
            
            if(t.ticketID==tid)
            {
                tickets.remove(t);
                train.cancel();
                System.out.println("Ticket has been cancelled");
            }
        }
    }
    
    Train getTrain()
    {
        return train;
    }
    
    public void run()
    {
        if(option==Option.buy)
            this.buy();
        if(option==Option.buy)
            this.cancel();
        
    }
}
