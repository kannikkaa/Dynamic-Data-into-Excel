import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDom {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
       driver.get("https://books-pwakit.appspot.com/");

       //xpath cant handle shadow DOM elements,only cssSelector can handle
     //this element is inside single shadow DOM, if directly use sendKeys, will throw noSuchElementException
        String cssSelectorForHost1 = "book-app[apptitle='BOOKS']";
        SearchContext shadow = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
        Thread.sleep(1000);
        shadow.findElement(By.cssSelector("#input")).sendKeys("welcome");
    }
}
