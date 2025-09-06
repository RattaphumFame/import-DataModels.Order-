package FactoryMethodPattern;

public class StandardShipment implements Shipment  { 
    public String getInfo() {
      return " Standard Delivery";
    } 
    public double getCost() {
      
       return 50.0;
    }    
}