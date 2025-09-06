package FactoryMethodPattern;

public class ExpressShipment  implements Shipment{
    public String getInfo() {
        return "Express Delivery";
    }
    public double getCost() {
            return 150.0;
    }  
}