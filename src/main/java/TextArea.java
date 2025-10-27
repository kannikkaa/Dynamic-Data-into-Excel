import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TextArea {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mayan\\IdeaProjects\\mavenproject\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://text-compare.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions act = new Actions(driver);

        //keyboard actions: sendKeys, ctrl+A, ctrl+C, tab, ctrl+V
        //sendKeys
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inputText"))).sendKeys("welcome to my dome");

        //ctrl+A:selects the text
        act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();

        //ctrl+C
        act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();

        //TAB: shift to 2nd box
        act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();

        //ctrl+V
        act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();

        //ctrl+shift+A
        act.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("A").keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).perform();

        //enter
        act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();



    }
}
