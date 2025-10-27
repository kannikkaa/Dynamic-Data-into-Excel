package ListenerDemo;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class MyListener implements ITestListener {

    public void onStart(ITestContext context) {//Triggered once before any test methods inside a <test> tag start running.
        System.out.println("test execution is started...");
    }

    public void onTestStart(ITestResult result) {//Triggered every time an individual @Test method starts execution.
        System.out.println("test method execution is started...");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("test method succeed...");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("test method failed..."+result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("test method skipped...");
    }

    public void onFinish(ITestContext context) {
        System.out.println("test execution has finished...");
    }

}
