import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class JavaScriptExecutorDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//only sendKeys and click methods u should remember by using JSE
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement inputbox = driver.findElement(By.xpath("//input[@id='name']"));

        //perform sendKeys(), click() using JSE
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].setAttribute('value', 'John')", inputbox);

        WebElement radioButton = driver.findElement(By.xpath("//input[@id='female']"));
        js.executeScript("arguments[0].click()", radioButton);

        //scroll the page, scroll bar not a web element,we cant inspect it, use only using JSE
        //3 Approaches: scroll the page until i see a particular element, scroll the page till the end of the page, go back to initial point
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://demo.nopcommerce.com/");

//scroll down the page by pixel number(for vertical scroll, work on y axis,going down: +ve y-axis, going up: -ve y-axis)
        //for horizontal scroll, work on x-axis, going right: +ve x-axis, going left: -ve x-axis)
        js.executeScript("window.scrollBy(0, 1500)", "");
        System.out.println(js.executeScript("return window.pageYOffset;"));//1500 pixels down

        //scroll down until the particular element is visible
        WebElement element = driver.findElement(By.xpath("//strong[normalize-space()='News']"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        System.out.println(js.executeScript("return window.pageYOffset;"));//1819 pixels down

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");

        //to find the total vertical pixels(height)
        Long pageHeight = (Long) js.executeScript("return document.body.scrollHeight;");
        System.out.println("Total page height: " + pageHeight + " pixels");//10232 pixels

        //to find the total horizontal pixels(width)
        Long pageWidth = (Long) js.executeScript("return document.body.scrollWidth");
        System.out.println("Total page width: " + pageWidth + " pixels");//1351 pixels(all visible on same page)

        //vertical scroll down the page by pixel number
        js.executeScript("window.scrollBy(0, 5000)", "");
        System.out.println(js.executeScript("return window.pageYOffset;"));

        //vertical scroll up the page by pixel number
        //  js.executeScript("window.scrollBy(0, -2000)", "");
        js.executeScript(" window.scrollBy(0, -document.body.scrollHeight)");

        //reach to the bottom of the page, or we can use window.document.body.scrollHeight
        js.executeScript("window.scrollBy(0, 10232)");
        //  js.executeScript("window.scrollBy(0, document.body.scrollHeight)");

        //horizontal scroll right the page by pixel number
        js.executeScript("window.scrollBy(200, 0)", "");
        System.out.println(js.executeScript("return window.pageXOffset;"));//here it did not scroll to right bec it was visible in one screen only

        //adjust zoom level
        js.executeScript("document.body.style.zoom='50%'");//zoom out the page
        js.executeScript("document.body.style.zoom='150%'");//zoom in the page, use more than 100%, here 1 is normal

        List<String> ids = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(ids.get(0));

        //upload single file
        driver.findElement(By.xpath("//input[@id='singleFileInput']")).sendKeys("C:\\Users\\mayan\\Downloads\\KANIKA_CHHIPA_RESUME.pdf");

        //upload multiple files
        String file1 = "C:\\Users\\mayan\\Downloads\\KANIKA_CHHIPA_RESUME.pdf";
        String file2 = "C:\\Users\\mayan\\Downloads\\Company Wise HR Contacts - HR Contacts.pdf";

        driver.findElement(By.xpath("//input[@id='multipleFilesInput']")).sendKeys(file1+"\n"+file2);

    }
}
