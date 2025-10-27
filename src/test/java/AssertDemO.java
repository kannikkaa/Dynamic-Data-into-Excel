import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class AssertDemO {

    @Test(priority = 1)
    void hardAssert(){//hard assert
        assertEquals(1, 2);
        assertEquals("abc", "avc");
    }

    @Test(priority = 2)
    void softAssert(){//soft assert, in which if it not matches, test still passes
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(1, 2);
        soft.assertTrue(2==2);
    }
}
