package org.demo.child;

import com.example.demo_parent.PService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 PService parentService = new PService();
         String greeting = parentService.greetUser("shivaprasad");
         System.out.println(greeting);
    }
}
