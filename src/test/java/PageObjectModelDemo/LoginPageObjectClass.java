package PageObjectModelDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageObjectClass {//Without using pageFactory approach
    WebDriver driver;

    //constructors
    LoginPageObjectClass(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    By username_loc = By.xpath("//input[@placeholder='username']");
    By password_loc = By.xpath("//input[@placeholder='password']");
    By loginBtn_loc = By.xpath("//button[normalize-space()='Login']");

    //action methods
    public void setUserName(String user){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(username_loc)).sendKeys(user);

    }

    public void setPassword(String pwd){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(password_loc)).sendKeys(pwd);
    }

    public void clickLogin(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn_loc)).click();
    }
}
