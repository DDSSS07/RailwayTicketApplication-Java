/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dateapplication;

import java.util.*;

/**
 *
 * @author 17pw08
 */


public class DateApplication {

    /*public static Date[] sort(Date[] dates)
    {
        Date tempDate;
        for(int i=0;i<dates.length;i++)
        {
            for(int j=i+1;j<dates.length;j++)
            {
                int result=dates[i].compare(dates[j]);
                if(result==1)
                {
                   tempDate=dates[i];
                   dates[i]=dates[j];
                   dates[j]=tempDate;
                }
            }
        }
        return dates;
    }*/
    
    public static void main(String[] args) {
        
        
        Date date1,date2;
        date1=new Date(21,07,1999);
        date2=new Date(02,02,2000);
        

        //System.out.println(date);
        //System.out.println(date1.difference(date2);
        
        /*Date[] dates=new Date[3];
        dates[0]=new Date(1,1,2001);
        dates[1]=new Date(7,7,1999);
        dates[2]=new Date(7,7,1999);
        
        dates=sort(dates);
        
        for(int i=0;i<dates.length;i++
        {
            System.out.println(dates[i]);
        }*/
        
        List<Date> dates=new ArrayList<Date>();
        dates.add(date1);
        dates.add(date2);
        dates.add(new Date(1,2,2000));
        Collections.sort(dates);
        
        System.out.println(dates);
        
        date1.addDays(150);
        System.out.println(date1);
        
    }
        
}
