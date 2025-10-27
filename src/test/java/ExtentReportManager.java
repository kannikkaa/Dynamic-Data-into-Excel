import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;//UI of the report
    public ExtentReports extent; //populate common info of the report
    public ExtentTest test;  //create test case entries in the report and update status of the test methods

    public  void onStart(ITestContext context){

        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\ExtentReport.html");//here i have hardcode the path of the report, means
        //so my old report will be replaced with new report, so create report with Time stamp

        sparkReporter.config().setDocumentTitle("Automation report");
        sparkReporter.config().setReportName("Functional testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Computer Name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester Name", "kanika");
        extent.setSystemInfo("os", "Windows10");
        extent.setSystemInfo("Browser name", "chrome");
    }

    public void onTestSuccess(ITestResult result){

        test = extent.createTest(result.getName());
        test.log(Status.PASS, "Test case PASSED IS: "+ result.getName());
    }

    public void onTestFailure(ITestResult result){

        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test case FAILED is: "+result.getName());
        test.log(Status.FAIL, "Test case FAILED cause is: "+result.getThrowable());

    }

    public void onTestSkipped(ITestResult result){

        test = extent.createTest(result.getName());
        test.log(Status.SKIP, "Test case SKIPPED is: "+result.getName());
    }

    public void onFinish(ITestContext context){
        extent.flush();
    }

}
