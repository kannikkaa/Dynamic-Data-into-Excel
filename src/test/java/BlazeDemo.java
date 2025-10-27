import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BlazeDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://blazedemo.com/");

        WebElement fromPort = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='fromPort']")));
        Select option = new Select(fromPort);
        option.selectByVisibleText("Philadelphia");

        WebElement toPort = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='toPort']")));
        Select option1 = new Select(toPort);
        option1.selectByVisibleText("London");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Find Flights']"))).click();

        int rows = driver.findElements(By.xpath("//table[@class='table']//tr")).size();
        System.out.println("No of rows: " + rows);

        double min = Double.MAX_VALUE;
        for (int r = 1; r < rows; r++) {
            String price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table']//tr[" + r + "]//td[6]"))).getText();
            double prices = Double.parseDouble(price.replaceAll("[$,]", ""));
            if (prices < min) {
                min = prices;
            }
        }
        System.out.println("Minimum price of a flight: " + min);

    }
}