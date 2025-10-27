import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class radioButtonCnt {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\mayan\\IdeaProjects\\mavenproject\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //open web page
        driver.get("https://demo.guru99.com/test/radio.html");

        //locate all radio buttons using relative xpath
       List<WebElement> radioButtonList =  driver.findElements(By.xpath("//input[@type='radio']"));
       //print total no of radio buttons list
        System.out.println("Total no. of radio buttons on web page:" + radioButtonList.size());
        //close browser
        driver.close();

    }
}
