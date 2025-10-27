import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.List;

public class BrokenLink {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.deadlinkcity.com/");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total no of links: " + links.size());

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {

        }

        for (WebElement linksName : links) {
            String hrefatValue = linksName.getAttribute("href");
            if (hrefatValue == null || hrefatValue.isEmpty()) {
                System.out.println("href attribute is null or empty, please check again");
                continue;
            }
            try {
                URL linkURL = new URL(hrefatValue);
                HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection();
                conn.setConnectTimeout(5000);
                conn.connect();

                if (conn.getResponseCode() >= 400) {
                    System.out.println(hrefatValue + " is a broken link");
                } else {
                    System.out.println(hrefatValue + " is a valid link");
                }
                conn.disconnect();
            }

            catch (Exception e) {System.out.println(hrefatValue + " could not be checked -> " + e.getMessage());
            }
        }
driver.quit();
    }
}
