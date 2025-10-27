import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class nopcommerce {

    public static void main(String[] args) throws MalformedURLException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        URL url = new URL("https://demo.nopcommerce.com/");
        driver.navigate().to(url);//it accepts url string format as well as URL object format









    }
}
