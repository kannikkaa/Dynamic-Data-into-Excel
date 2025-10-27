import org.example.Main;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class HeadlessTesting {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        // setting for headless mode of execution
        //options.addArguments("--headless=new");

        //to not get the message"Chrome is being controlled by automated test software" on the top of the screen
       // options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        //to run test cases in incognito mode
        // options.addArguments("--incognito");

        //to enable extensions in browser
        File file = new File("C:\\Users\\mayan\\Downloads\\uBlock-Chrome-Web-Store.zip");
        options.addExtensions(file);

        WebDriver driver = new ChromeDriver(options);
driver.manage().window().maximize();
        driver.get("https://text-compare.com/");
       // driver.get("https://www.opencart.com/");

       /* String act_title = driver.getTitle();
        if (act_title.equals("OpenCart - Open Source Shopping Cart Solution")) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }*/
    }
}
