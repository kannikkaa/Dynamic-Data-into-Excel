package ListenerDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

@Listeners(MyListener.class)
public class OrangeHrmListener {

    WebDriver driver;

    @BeforeClass
    void openApp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(priority = 2)
    void testLogo() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        boolean logo = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
        System.out.println("logo displayed...");
    }

    @Test(priority = 1)
    void testUrl(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/");
    }

    @Test(priority = 3, dependsOnMethods = {"testUrl"})
    void testLogin() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }

    @AfterClass
    void logOut() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.quit();
    }
}
