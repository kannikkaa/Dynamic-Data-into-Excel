import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class OrangeHrm {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        System.out.println(driver.getTitle());//string format

        System.out.println(driver.getCurrentUrl());//string format

       // System.out.println(driver.getPageSource());//String format

        System.out.println("Window ID: "+driver.getWindowHandle());//string format, CHANGES EVERYTIME WE RUN

        WebElement username = driver.findElement(By.name("username"));
       username.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        WebElement loginBtn = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginBtn.click();

    }

}
