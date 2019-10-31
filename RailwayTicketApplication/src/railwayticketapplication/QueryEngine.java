/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railwayticketapplication;
import java.util.*;
import timerapplication.*;
/**
 *
 * @author ddsss
 */
public class QueryEngine 
{
   private int trainID;
   private String src;
   private String dest;
   timerapplication.Calendar cl;
   List <Train> trains;
   
   public QueryEngine(int ID,String s,String d,List tr,timerapplication.Calendar c)
   {
       trainID=ID;
       src=s;
       dest=d;
       trains=tr;
       cl=c;
   }
   
   List<Train> search()
   {
       List<Train> results=new ArrayList<Train>();
       for(Train tr:trains)
       {
           if((tr.getSrc().equals(src) && tr.getDest().equals(dest) && tr.getCal().equals(cl)) || tr.getID()==trainID)
               results.add(tr);
       }
       return results;
   }
}
