import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestFacebook {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mayan\\IdeaProjects\\mavenproject\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/reg/?entry_point=login&next=");
        WebElement svgElement = driver.findElement(By.cssSelector("svg.sc-1xliiih.x2lah0s.x1k9omsu.x2h7rmj.x1qfquc1.x1xqnn88.x1om5y7t.x1t9x5o1.x1d1r5r3"));
        Actions actions = new Actions(driver);
        actions.moveToElement(svgElement).click().perform();


    }
}
