import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SvgElement {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(1000);
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");
        Thread.sleep(1000);
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        Thread.sleep(1000);
        WebElement loginBtn = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginBtn.click();
        Thread.sleep(5000);
        //identify svg element using relative xpath
        //   driver.findElement(By.xpath("//span[normalize-space()='Time']")).click();
        Thread.sleep(5000);
        //identify svg element using xpath and namespace
        // driver.findElement(By.xpath("(//*[name()='svg'][@role='presentation'])[6]")).click();
        WebElement span = driver.findElement(By.xpath("//span[text()='Time']"));
        WebElement svg = span.findElement(By.xpath("./preceding-sibling::*[name()='svg']"));
        svg.click();


    }
}
