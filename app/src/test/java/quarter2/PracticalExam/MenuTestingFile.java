package quarter2.PracticalExam; // TODO: Change this to your actual package name

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

import quarter2.PracticalExam.mainmenu;

public class MenuTestingFile {
    @Test
    public void run() {
        String simulatedInput = "1\n" +
                "12345-ID\n" +
                "Minor\n" +
                "Minor\n" +
                "2\n" +
                "Minor\n" +
                "Minor\n" +
                "3\n";



        ByteArrayInputStream automaticInput = new ByteArrayInputStream(simulatedInput.getBytes());

        Scanner allScanner = new Scanner(automaticInput);

        mainmenu2 start = new mainmenu2();

        start.LoggingIn(allScanner);


    }
}