import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class class3 {

    @Test
    void abc(){
        System.out.println("method from class 3, not in pckage 1");
    }

    @BeforeSuite
    void beforeSuite(){
        System.out.println("before suite of class 3");
    }

    @AfterSuite
    void afterSuite(){
        System.out.println("after suite of class 3");
    }
}
