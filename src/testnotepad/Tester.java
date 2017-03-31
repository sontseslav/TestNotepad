package testnotepad;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;

/**
 * Test class
 * @author Stanislav
 */
public class Tester {
    private static final String APPLICATION_PATH = 
            "C:\\Windows\\system32\\notepad.exe";
    private static DesktopOptions options;
    private static WiniumDriver driver;
    
    /**
     * Generates random ASCII string 
     * with length from 5 to 25 characters
     * @return random ASCII string
     */
    private String generateString(){
        Random rnd = new Random();
        int length = rnd.nextInt(21) + 5;
        StringBuilder sb = new StringBuilder(length);
        while (sb.length() < length){
            char c = (char)(rnd.nextInt(95) + 32);
            sb.append(c);
        }
        return sb.toString();
    }
    
    /**
     * Initialize testing process
     * @throws java.io.IOException
     */
    @BeforeClass
    public static void initTest()throws IOException{
        options = new DesktopOptions();
        options.setApplicationPath(APPLICATION_PATH);
        System.out.println("Init completed.");
    }
    /**
     * Main test
     */
    @Test
    public void testNotepad(){
        System.out.println("Start testing...");
        try{
            driver = new WiniumDriver(new URL("http://localhost:9999"), options);
            driver.findElementByClassName("Edit").sendKeys(generateString());
        }catch(MalformedURLException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Testing completed.");
    }
    
    /**
     * Exit and cleanup
     */
    @AfterClass
    public static void exitTesting(){
        if (driver != null){
            driver.close();
            System.out.println("Driver closed.");
        }
        System.out.println("Exiting...");
    }
}
