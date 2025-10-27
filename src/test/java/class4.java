import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class class4 {

    @BeforeClass
    void method(){
        System.out.println("before class of class 4");
    }

    @Test
    void method1(){
        System.out.println("method of class 4");
    }

    @AfterClass
    void method3(){
        System.out.println("after class of class 4");
    }
}
