import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class webTable {
    public static void main(String[] args) {
        //launch chrome browser
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mayan\\IdeaProjects\\mavenproject\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //to open browser in its maximize form
        driver.manage().window().maximize();
        //open url
        driver.get("file:///C:/Users/mayan/OneDrive/Documents/sample%20tabe.html");
//locate second cell
        String text = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText();
        System.out.println(text);
        // find totl rows in web table
        List<WebElement> rowlist = driver.findElements(By.xpath("//table/tbody/tr"));
        System.out.println("rows:" + rowlist.size());
        //find total columns in web table
        List<WebElement> columnlist = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
        System.out.println("columns:" + columnlist.size());

    }
}
