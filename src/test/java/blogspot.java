import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class blogspot {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.findElement(By.className("form-control")).sendKeys("kanika");
        driver.findElement(By.id("email")).sendKeys("kanikachhipa111@gmail.com");
        driver.findElement(By.id("phone")).sendKeys("8302299010");
        driver.findElement(By.xpath("//textarea[@id='textarea']")).sendKeys("Sanjay park, Pune");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='female']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='tuesday']"))).click();

        WebElement drpCountryEle = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//select[@id='country']"))));
        Select drpCountry = new Select(drpCountryEle);
        drpCountry.selectByVisibleText("India");
        drpCountry.selectByIndex(3);
        drpCountry.selectByValue("japan");

        //to capture all optons
        List<WebElement> options = drpCountry.getOptions();
        System.out.println(options.size());

        for (WebElement el : options) {
            System.out.println(el.getText());
        }

        WebElement drpColorsEle = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//select[@id='colors']"))));
        Select drpColors = new Select(drpColorsEle);
        drpColors.selectByVisibleText("Blue");

        WebElement drpAnimalsEle = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//select[@id='animals']"))));
        Select drpAnimals = new Select(drpAnimalsEle);
        drpAnimals.selectByVisibleText("Cat");

//static web table
        int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
        System.out.println("No of rows: " + rows);

        int cols = driver.findElements(By.xpath("//table[@name='BookTable']//tr[1]//th")).size();
        System.out.println("No of columns: " + cols);

        WebElement readRandomData = driver.findElement(By.xpath("//table[@name='BookTable']//tr[4]//td[2]"));
        System.out.println(readRandomData.getText());


        for (int r = 2; r <= rows; r++) {
            for (int c = 1; c <= cols; c++) {
                WebElement readAllData = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[" + c + "]"));
                System.out.print(readAllData.getText() + "\t");
            }
            System.out.println();
        }

        for (int r = 2; r <= rows; r++) {
            String authorName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[2]")).getText();
            if (authorName.equals("Mukesh")) {
                String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[1]")).getText();
                System.out.println(bookName);
            }
        }
        int totalPrice = 0;
        for (int r = 2; r <= rows; r++) {
            String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[4]")).getText();
            totalPrice += Integer.parseInt(price);
        }
        System.out.println("total price of books: " + totalPrice);

        //date pickers
       WebElement calender = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='datepicker']")));
        calender.click();
        String year = "2025";
        String month = "May";
        String date = "20";
        while (true) {
            WebElement curMon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ui-datepicker-month']")));
            String curMonth = curMon.getText();
            WebElement curYea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ui-datepicker-year']")));
            String curYear = curYea.getText();
            if (curMonth.equals(month) && curYear.equals(year)) {
                break;
            }
            WebElement prev = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='ui-datepicker-prev ui-corner-all']")));
            prev.click();
        }
        List<WebElement> allDates = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a")));
        for(WebElement dt: allDates){
            if(dt.getText().equals(date)){
               dt.click();
               break;
            }
        }

        String date1 = "16";
        WebElement calender1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtDate']")));
        calender1.click();

        WebElement curMonth1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='ui-datepicker-month']")));
        Select month1 = new Select(curMonth1);
        month1.selectByVisibleText("Jul");

        WebElement curYear1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='ui-datepicker-year']")));
        Select year1 = new Select(curYear1);
        year1.selectByVisibleText("2025");

        List<WebElement> allDates1 = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a")));
        for (WebElement dt1 : allDates1){
            if(dt1.getText().equals(date1)){
                dt1.click();
                break;
            }
        }



    }
}
