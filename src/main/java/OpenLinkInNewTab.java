import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OpenLinkInNewTab {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mayan\\IdeaProjects\\mavenproject\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        driver.get("https://demo.nopcommerce.com/");

        WebElement regLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Register']")));

        //to open reg page in other page: ctrl+regLink
        Actions act = new Actions(driver);
        act.keyDown(Keys.CONTROL).click(regLink).keyUp(Keys.CONTROL).perform();

//driver is still focused on home page, switch to reg page
        List<String> ids = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(ids.get(1));//switch to reg page

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("FirstName"))).sendKeys("Kanika");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='gender-female']")));
        element.click();
        System.out.println(element.isSelected());

        //go back to parent page
        driver.switchTo().window(ids.get(0));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='small-searchterms']"))).sendKeys("Computer");


        //selenium 4.0+
        driver.switchTo().newWindow(WindowType.TAB);//opens new tab

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.switchTo().newWindow(WindowType.WINDOW);//opens new window

    }
}
