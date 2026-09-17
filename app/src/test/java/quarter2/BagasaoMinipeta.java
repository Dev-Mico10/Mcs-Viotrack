package quarter2;

import org.junit.Test;

public class BagasaoMinipeta {
    @Test
    public void printMyprofile() {

        // --- 1. THE INPUT (Storing your personal details in variables) ---
        String myname = "Myko";
        String petName = "waffles";
        String favFood = "sinigang";
        int myage = 17;

        // --- 2. THE OUTPUT (Printing to the console) ---
        System.out.println("--- MY DIGITAL PROFILE ---");
        System.out.println("Hello, my name is " + myname + " and I am " + myage + " years old.");
        System.out.println("I have wonderful pet named " + petName + ".");
        System.out.println("If I could, I would eat " + favFood + " every single day!");
    }
}

