import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Rediff {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.drive", "C:\\Users\\mayan\\IdeaProjects\\mavenproject\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://money.rediff.com/gainers/bse/dailygroupa");

        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Tarmat L')]/self::a"))).getText();
        System.out.println("self: "+text);

         text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Tarmat L')]/parent::td"))).getText();
         System.out.println("Parent: "+text);

        String ancestor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Tarmat L')]/ancestor::tr"))).getText();
        System.out.println("ancestor: "+ancestor);

        String siblingsClose = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Tarmat L')]/ancestor::tr/child::td"))).getText();
        System.out.println("closest siblings: "+siblingsClose);

      WebElement noofRows = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Tarmat L')]/ancestor::tr/following::tr")));
        System.out.println("No of rows following Tarmat L: "+noofRows.getSize());

        WebElement noofRows0 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Tarmat L')]/ancestor::tr/preceding::tr")));
        System.out.println("No of rows preceding Tarmat L: "+noofRows0.getSize());


    }
}