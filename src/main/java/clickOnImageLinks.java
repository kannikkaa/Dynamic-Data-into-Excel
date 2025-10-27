import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;

public class clickOnImageLinks {
    public static void main(String[] args) {
        //launch chromw browser
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mayan\\IdeaProjects\\mavenproject\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //open web page
        driver.get("https://www.opencart.com/");
        //to maximize browser
        driver.manage().window().maximize();
        //locate image links using xpath/cssSelector
        driver.findElement(By.xpath("//img[@src='application/view/image/icon/opencart-logo.png']")).click();
        //verify URL of the current page with expected home page URL
        if (driver.getCurrentUrl().equals("https://www.opencart.com/index.php?route=common/home")) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
        driver.close();
    }
}
