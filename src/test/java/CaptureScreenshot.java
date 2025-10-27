import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;


public class CaptureScreenshot {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //full page ss,ss of specific area of the page, web element ss
        driver.get("https://demo.nopcommerce.com/");

        //make object of takesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        //1) capture full page screenshot, and make a file of it
       File sourceFile =  ts.getScreenshotAs(OutputType.FILE);
       //capture that particular file to get the location
       File targetFile = new File(System.getProperty("user.dir")+"\\fullPage.png");
       //copy source file to target file
        FileUtils.copyFile(sourceFile, targetFile);

        //2) capture specific section of page
        WebElement featuredProducts = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
       File sourceFile1 = featuredProducts.getScreenshotAs(OutputType.FILE);
        File targetFile1 = new File(System.getProperty("user.dir")+"\\sectionScreenshot.png");
        FileUtils.copyFile(sourceFile1, targetFile1);

//3) capture particular web element
        WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        File sourceFile2 = logo.getScreenshotAs(OutputType.FILE);
        File targetFile2 = new File(System.getProperty("user.dir")+"\\webElementScreenshot.png");
        FileUtils.copyFile(sourceFile2, targetFile2);

        driver.quit();
    }
}
