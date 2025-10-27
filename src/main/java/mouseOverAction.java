import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mouseOverAction {
    public static void main(String[] args) {
        //launch chrome browser
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mayan\\IdeaProjects\\mavenproject\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //maximize web page
        driver.manage().window().maximize();
        //open web pGE
        driver.get("https://www.ebay.com/");
        //locate web element by link text
       WebElement mouseOverEl =  driver.findElement(By.linkText("Fashion"));

       Actions act = new Actions(driver);
       act.moveToElement(mouseOverEl).perform();

    }
}
