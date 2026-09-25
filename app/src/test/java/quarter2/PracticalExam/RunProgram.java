package quarter2.PracticalExam;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.Test;

public class RunProgram {
    @Test
    public void Run(){
        StringBuilder simulatedInput = new StringBuilder();
        simulatedInput.append("3\n");
        ByteArrayInputStream automatedInput = new ByteArrayInputStream(simulatedInput. toString().getBytes());

        Scanner masterScanner = new Scanner(automatedInput);
        mainmenu menu = new mainmenu();

        menu.Menu(masterScanner);

    }
}
