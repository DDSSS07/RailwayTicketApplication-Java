/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railwayticketapplication;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import timerapplication.*;
import dateapplication.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ddsss
 */
public class RailwayTicketApplication {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) 
    {
        Train[] tr=new Train[4];
        tr[0]=new Train(10,"CBE","MAS",new Calendar(new Date(21,07,1999),new Time(10,0,0)),500,300);
        tr[1]=new Train(11,"CBE","MAS",new Calendar(new Date(21,07,1999),new Time(11,0,0)),550,300);
        tr[2]=new Train(12,"CBE","MAS",new Calendar(new Date(21,07,1999),new Time(12,0,0)),450,300);
        tr[3]=new Train(13,"CBE","MAS",new Calendar(new Date(21,07,1999),new Time(13,0,0)),300,300);
       
        
        Customer customer=null;
        List <Train> trains=new ArrayList<Train>();
        List <Ticket> tickets=new ArrayList<Ticket>();
        Train train=null;
        Ticket ticket=null;
        
        for(int i=0;i<tr.length;i++)
        {
            trains.add(tr[i]);
        }
                
        while(true)
        {
            //Ticket ticket=null;
            //customer=null;
            //Train train=null;
            System.out.println("1.Register");
            System.out.println("2.Query");
            System.out.println("3.Buy");
            System.out.println("4.Cancel");
            
            System.out.println("Enter your choice:");
            Scanner s=new Scanner(System.in);
            int ch=s.nextInt();
            
            switch(ch)
            {
                case 1: System.out.println("Enter the name:");
                        Scanner s2=new Scanner(System.in);
                        String name=s2.nextLine();
                        System.out.println("Enter the age:");
                        int age=s.nextInt();
                        System.out.println("Enter the gender:");
                        String gender=s2.nextLine();
                        Gender g;
                        
                        if(gender=="Male")
                            g=Gender.male;
                        else if(gender=="Female")
                            g=Gender.female;
                        else if(gender=="Others")
                            g=Gender.others;
                        else
                            g=Gender.others;
                        
                        customer=new Customer(name,age,g);
                        break;
                            
                
                case 2: int id=0;
                        String src="";
                        String dest="";
                        Calendar cl=new Calendar(new Date(21,07,1999),new Time(10,0,0));
                        System.out.println("Enter the train ID:");
                        id=s.nextInt();
                        Scanner s3=new Scanner(System.in);
                        System.out.println("Enter the train source:");
                        src=s3.nextLine();
                        System.out.println("Enter the train destination:");
                        dest=s3.nextLine();
                        List<Train> results=new ArrayList<Train>();
                        QueryEngine qe=new QueryEngine(id,src,dest,trains,cl);
                        results=qe.search();
                        
                        System.out.println(results.size()+" results were found:");
                        
                        int i=0;
                        for(Train trn:results)
                        {
                            i++;
                            System.out.println(i+" "+trn);
                        }
                        
                        System.out.println("Choose your train:");
                        int choice=s.nextInt();
                        train=results.get(i-1);
                        break;
                        
                case 3: ticket=new Ticket(train,customer,Option.buy,tickets);
                        Thread t5=new Thread(ticket);
                        t5.run();
                
                    try {
                        t5.join();
                        railwayticketapplication.Logger log=new railwayticketapplication.Logger(tickets);
                        Thread t3=new Thread(log);
                        t3.start();
                        t3.join();
                        break;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(RailwayTicketApplication.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                           
                        
                case 4: ticket=new Ticket(train,customer,Option.cancel,tickets);
                        Thread t2=new Thread(ticket);
                        t2.run();
                {
                    try {
                        t2.join();
                        railwayticketapplication.Logger log=new railwayticketapplication.Logger(tickets);
                        Thread t4=new Thread(log);
                        t4.start();
                        t4.join();
                        break;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(RailwayTicketApplication.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                
                default:System.out.println("Invalid Option");
                    
            }
            
    }
    } 
}
