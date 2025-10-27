import org.testng.annotations.Test;

public class TestDependencies {
    String trackNum = null;

    @Test(priority = 1)
        public  void createShipment(){
     //   System.out.println(5/0);
        trackNum = "ABDJ3267";
        System.out.println("shipment created successfully");
    }

    @Test(priority = 2, dependsOnMethods = {"createShipment"})
    public  void trackShipment() throws Exception{
        if(trackNum != null){
            System.out.println("shipment is tracking");
        } else{
            throw new Exception("generate trackNum");
        }
    }

    @Test(priority = 3)
    public void cancelShipment() throws Exception{
        if(trackNum != null){
            System.out.println("shipment cancelled");
        } else {
            throw new Exception("cant cancel since no shipment no has generated");
        }
    }
}
