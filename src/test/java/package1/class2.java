package package1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class class2 {

    @Test
    void methodOfClass2(){
        System.out.println("method of class 2");
    }

    @AfterMethod
    void am(){
        System.out.println("after method of class 2");
    }
}
