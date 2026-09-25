package quarter2.PracticalExam;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.Test;

public class RunProgram {
    @Test
    public void Run(){
        ByteArrayInputStream automatedInput = new ByteArrayInputStream("3\n".getBytes());

        Scanner masterScanner = new Scanner(automatedInput);
        mainmenu menu = new mainmenu();

        menu.Menu(masterScanner);

    }
}
