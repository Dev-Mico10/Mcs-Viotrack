package quarter2;

import org.junit.Test;

public class FriasMinipeta {

    @Test
    public void printMYprofile(){
        String myName = "Jhon";
        String petname = "Choco";
        String favfood = "Sinigang";
        int myAge = 17;


        System.out.println("--- MY DIGITAL PROFILE ---");
        System.out.println("Hello, my name is " + myName + " and I am " + myAge);
        System.out.println("I have wonderful pets named " + petname + ".");
        System.out.println("If I could eat " + favfood + " everyday!");

    }
}