/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railwayticketapplication;

/**
 *
 * @author ddsss
 */
enum Gender
{
    male,female,others;
}

public class Customer 
{
    private String name;
    private int age;
    private Gender gender;
    
    public Customer(String n,int a,Gender g)
    {
        name=n;
        age=a;
        gender=g;
    }
    
    public String toString()
    {
        return "\n"+name+" | "+age+" | "+gender;
    }
    
    public boolean equals(Object o)
    {
        if(((Customer)o).name==name && ((Customer)o).age==age && ((Customer)o).gender==gender)
        {
            return true;
        }
        
        return false;
    }
}
