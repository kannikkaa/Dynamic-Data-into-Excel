import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class uploadFiles {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mayan\\IdeaProjects\\mavenproject\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //maximize webpage
        driver.manage().window().maximize();
        //open webpage
        driver.get("https://demoqa.com/upload-download");
        //locate element using xpath AND UPLOAD FILE USING sendKeys method,using it bec (type=file) attribute was given in HTML code
       driver.findElement(By.xpath("//input[@id='uploadFile']")).sendKeys("C:\\Users\\mayan\\OneDrive\\Pictures\\Screenshots 1");


    }
}
