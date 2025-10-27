import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class blogspot1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://testautomationpractice.blogspot.com/");
        Actions act = new Actions(driver);
        String mainWindowHandle = driver.getWindowHandle();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='alertBtn']"))).click();
        //  driver.switchTo().alert().accept();

        //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='confirmBtn']"))).click();
        //  driver.switchTo().alert().accept();
        //  driver.switchTo().alert().dismiss();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='promptBtn']"))).click();
        Alert myalert = driver.switchTo().alert();//when perform diff operations, make object
        myalert.sendKeys("harry potter");
        myalert.accept();

       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']"))).sendKeys("harry potter");
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']"))).click();
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Harry Potter']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='start']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='stop']"))).click();

      /*  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='PopUp']"))).click();
        String windowHandle = driver.getWindowHandle();
        driver.switchTo().window(windowHandle);
        driver.switchTo().window(mainWindowHandle);*/

       WebElement PointMe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Point Me']")));
       WebElement Mobiles = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Mobiles']")));
       act.moveToElement(PointMe).moveToElement(Mobiles).click().build().perform();

      WebElement doubleClick =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Copy Text']")));
      act.doubleClick(doubleClick).perform();

        WebElement source =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='draggable']")));
        WebElement target =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='droppable']")));
        act.dragAndDrop(source, target).perform();

        //for horizontal slider, always work with x-axis, but with vertical sliders, always change y-axis
        //in this case, it was horizontal slider
      WebElement min_slider =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='HTML7']//span[1]")));
        System.out.println("location of min slider before moving: "+min_slider.getLocation());//890, 2042
        act.clickAndHold(min_slider).moveByOffset(100, 0).perform();
        System.out.println("location after moving of min slider: "+min_slider.getLocation());

        WebElement max_slider =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='HTML7']//span[2]")));
        System.out.println("location of max slider before moving: "+max_slider.getLocation());
        act.clickAndHold(max_slider).moveByOffset(100, 0).perform();
        System.out.println("location after moving of max slider: "+max_slider.getLocation());
    }
}
//methods to perform actions on sliders: dragAndDropBy(Element, x axis, y axis) & act.clickAndHold(min/max slider).moveByOffset(x axis, y axis).perform