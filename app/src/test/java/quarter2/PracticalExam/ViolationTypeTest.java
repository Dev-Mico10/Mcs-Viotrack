package quarter2.PracticalExam;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class ViolationTypeTest {

    @Test
    public void testSchoolViolationTrackerIntegration() {
        StringBuilder inputBuilder = new StringBuilder();
        int step = 0;

        while (step < 2) {
            if (step == 0) {
                inputBuilder.append("Improper Uniform").append("\n");
            } else if (step == 1) {
                inputBuilder.append("3 hours community service").append("\n");
            }
            step++;
        }


        ByteArrayInputStream testInputStream = new ByteArrayInputStream(inputBuilder.toString().getBytes());


        InputStream originalSystemIn = System.in;
        try {
            System.setIn(testInputStream);
            Scanner scanner = new Scanner(System.in);


            mainmenu.ViolationType violationType = new mainmenu.ViolationType();
            violationType.runFeature(scanner);
        } finally {
            System.setIn(originalSystemIn);
        }
    }
}