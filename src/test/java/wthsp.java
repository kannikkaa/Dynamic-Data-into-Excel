import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class wthsp {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.whatsapp.com/");
      driver.findElement(By.xpath("//a[@class='_aeo8 _9vcv _9u4o _9u4j _9sep']//span[@class='_advp _aeam'][normalize-space()='Log in']")).click();

        driver.findElement(By.xpath("//span[normalize-space()='Log in with phone number']")).click();
        driver.findElement(By.xpath("//input[@value='+91 ']")).sendKeys("8302299010");
    }
}
