import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class countAndPrintHyperlinks {
    public static void main(String[] args) {
        //launch chrome browser
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mayan\\IdeaProjects\\mavenproject\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //to open browser in its maximize form
        driver.manage().window().maximize();
        //open web page
        driver.get("https://www.calculator.net/");
        //to count total hyperlinks on webpage
        List<WebElement> linkElements = driver.findElements(By.tagName("a"));
        //to print total hyperlinks on webpage
        System.out.println("Total links on WebPage:" + linkElements.size());
        // to print each hyperlink in console
        for(WebElement k:linkElements){
            System.out.println(k.getText());
        }
        // to close driver
       // driver.close();


    }
}
