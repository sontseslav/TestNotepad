package testnotepad;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/**
 * Test runner
 * @author Stanislav
 */
public class TestNotepad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Tester.class);
        result.getFailures().forEach((failure) -> {
            System.out.println(failure);
        });
        System.out.println("Test was successfull: " + result.wasSuccessful());
    }
    
}
