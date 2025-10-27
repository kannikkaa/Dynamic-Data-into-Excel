import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class handleToolTip {
    public static void main(String[] args) {
        //launch chrome browser
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mayan\\IdeaProjects\\mavenproject\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //OPEN WEB PAGE
        driver.get("https://www.facebook.com/");
        //locate web element by css selector
      String actualToolTip =  driver.findElement(By.xpath("//a[@href='/reg/']")).getAttribute("title");
      String expToolTip = "Sign up for Facebook";
      if(actualToolTip.equals(expToolTip))
      {
          System.out.println("test passed");
      }
      else {
          System.out.println("test failed");
      }


    }
}
