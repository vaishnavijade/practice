/*
You are tasked with building a Person Management System that processes a list 
of Person objects using Java Streams. Each Person object contains the following 
attributes:
	Name: (String) The name of the person
	Age: (int) The age of the person
	Location: (String) The location where the person lives

Your goal is to sort by age, filter who atre above 20, and group by location 
using Java Stream operation.


Sample Input:
-------------
4                   //number of persons
Alice,23,New York   //name, age, location of a person
Bob,34,Los Angeles
Charlie,18,New York
David,29,Los Angeles

Sample Output:
-------------
New York => 
Person{name='Alice', age=23, location='New York'}
Los Angeles => 
Person{name='David', age=29, location='Los Angeles'}
Person{name='Bob', age=34, location='Los Angeles'}

*/

import java.util.*;
import java.util.stream.*;

class Person
{
    
    public String name;
    public int age;
    public String location;
    
    Person(String name, int age, String location)
    {
        this.name=name;
        this.age=age;
        this.location=location;
    }
    
    public String toString()
    {
        return "Person{name='"+this.name+"' , age="+this.age+", location='"+this.location+"'}";
    }
    
    public int getAge()
    {
        return this.age;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public String getLocation()
    {
        return this.location;
    }
}

class preSteamprogram
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        
        List<Person> listo = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            String line=sc.nextLine();
            String [] arr=line.split(",");
            listo.add( new Person(arr[0],Integer.parseInt(arr[1]),arr[2]));
        }
        
        Map<String,List<Person>> mapper = listo.stream()
        .sorted(Comparator.comparing(Person::getAge))
        .filter(x->x.getAge()>20)
        .collect(Collectors.groupingBy(Person::getLocation));
        
        for(Map.Entry<String,List<Person>>z : mapper.entrySet())
        {
            System.out.println(z.getKey()+" =>");
            for(Person per : z.getValue())
            {
                System.out.println(per);
            }
        }
        
        
    }
}