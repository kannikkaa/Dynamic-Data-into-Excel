import org.testng.annotations.Test;

public class TestNGDemo {

    // @Test  -> replacement of main method
    //3 tests are there
    //1 open app
    //2 login
    //3 log out
    @Test//(here no priority is given, then default priority is 0, executed first)
    void openApp(){
        System.out.println("opening app");
    }

    @Test(priority = 2)
    void login(){
        System.out.println("login to app");
    }

    @Test(priority = 3)
    void logout(){
        System.out.println("logout from app");
    }
}
