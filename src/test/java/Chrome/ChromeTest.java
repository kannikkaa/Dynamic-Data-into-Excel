package Chrome;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChromeTest {
    public static class GoogleTest {

        @Test
        public void openGoogleHomePage() {
            // Set path to chromedriver if needed
          //  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.com");

            String title = driver.getTitle();
            System.out.println("Page Title is: " + title);

            // Assertion
            Assert.assertEquals(title, "Google");

            driver.quit();
        }
        @Test
        public void checkGoogleUrl(){
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();

            driver.get("https://www.google.com");
            System.out.println("Google URL: "+driver.getCurrentUrl());

            driver.quit();
        }
    }
}
