package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class basicLocators {
    public static void main(String[] args) {
      System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
      WebDriver driver = new ChromeDriver();


      //open web pAGE
        driver.get("https://www.saucedemo.com/");
        //locate login button by id
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //locate password button by
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        //locate login button by class
        driver.findElement(By.className("submit-button")).click();
        //Switch to product page
        String currWindowHandle = driver.getWindowHandle();
        driver.switchTo().window(currWindowHandle);
        //locate add to cart by css selector using tag.valueOfClass[attribute=value]
        driver.findElement(By.cssSelector("button.btn[name=add-to-cart-sauce-labs-backpack]")).click();


    }
}
