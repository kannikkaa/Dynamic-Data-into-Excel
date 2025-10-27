package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpathLocator {
    public static void main(String[] args) {
        //launch chrome browser
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mayan\\IdeaProjects\\mavenproject\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //open web pGE
        driver.get("https://www.saucedemo.com/");
        //locate username by using single attribute
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        //locate password using multiple attributes
        driver.findElement(By.xpath("//input[@id='password'][@name='password']")).sendKeys("secret_sauce");
        //locate login button using AND
        driver.findElement(By.xpath("//input[@id='login-button' and @name='login-button']")).click();
        //switch to product page
        String currentWindowHandle = driver.getWindowHandle();
        driver.switchTo().window(currentWindowHandle);
        //locate add to cart by using OR
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack' or @name='add-to-cart-sauce-labs-backpack']")).click();
        //locate addtocart of bike light using contains
        driver.findElement(By.xpath("//button[contains(@id,'bike-light')]")).click();
        //locate addtocart of bolt t shirt using StartsWith
       // driver.findElement(By.xpath("button[starts-with(@id,'add']")).click();
        //locate fleece jacket page using text
        driver.findElement(By.xpath("//*[text()='Sauce Labs Fleece Jacket']")).click();
        //locate add to cart by using text
        driver.findElement(By.xpath("//*[text()='add to cart']")).click();

    }

}
