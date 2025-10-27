package package1;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class class1 {

    @Test
    void methodOfClass1(){
        System.out.println("method 1 of class 1");
    }

    @BeforeMethod
    void bm(){
        System.out.println("this is before method of class 1");
    }
}
