package PageObjectModelDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTestCase2 {
    WebDriver driver;

    @BeforeClass
    void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    void testLogin(){
        LoginPOMUsingPageFactory login1 = new LoginPOMUsingPageFactory(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        login1.setUserName("Admin");
        login1.setPassword("admin123");
        login1.clickLogin();

        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}


