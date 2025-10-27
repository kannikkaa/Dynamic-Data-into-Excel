package PageObjectModelDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOMUsingPageFactory {//with using page factory approach

    WebDriver driver;
    //constructor
    LoginPOMUsingPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);//this method makes sure that this driver is applicable for finding all these elements, auto
        //applied to all elements
    }

    //locators
    @FindBy(xpath="//input[@placeholder='username']")   WebElement txt_username;
    @FindBy(xpath="//input[@placeholder='password']")   WebElement txt_password;
    @FindBy(xpath="//button[normalize-space()='Login']")   WebElement btn_login;
   // @FindBy(tagName = "a")    List<WebElement> links;

    //Action methods
    public void setUserName(String user){
       txt_username.sendKeys(user);
    }

    public void setPassword(String pwd){
       txt_password.sendKeys(pwd);
    }

    public void clickLogin(){
       btn_login.click();
    }

}
