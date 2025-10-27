import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class alertPopup {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mayan\\IdeaProjects\\mavenproject\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //find simple alert button and perform click action
        WebElement element = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        Actions act = new Actions(driver);
        act.moveToElement(element).click().perform();
        //switch to alert window and accept the alert
        driver.switchTo().alert().accept(); //ok button is clicked

        // find confirmtion alert and perform click action
        WebElement element1 = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        Actions act1 = new Actions(driver);
        act1.moveToElement(element1).click().perform();
        driver.switchTo().alert().dismiss(); //to cancel alert

        //find prompt alert and perform click action
        WebElement element2 = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        Actions act2 = new Actions(driver);
        act2.moveToElement(element2).click().perform();
        //switch to alert window,enter anything
        driver.switchTo().alert().sendKeys("hello,Kanika");
        //to ok alert
        driver.switchTo().alert().accept();

    }
}
