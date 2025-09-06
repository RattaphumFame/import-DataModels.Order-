package TestRunner;
import java.util.List;
import DataModels.*;
import DecoratorPattern.*;
import FactoryMethodPattern.*;
import ObserverPattern.*;
import StrategyPattern.*;

public class Test {
    public static void main(String[] args) {
        Product laptop = new Product("P001", "Lattop", 30000.0);
        Product mouse = new Product("P002", "Mouse", 800.0);
        Order myOrder = new Order("ORD-001", List.of(laptop,mouse), "null");

        OrderCalculator calculator = new OrderCalculator();
        ShipmentFactory shipmentFactory = new ShipmentFactory();

        OrderProcessor orderProcessor = new OrderProcessor();
        InventoryService inventory = new InventoryService();
        EmailService emailer = new EmailService();
        orderProcessor.register(inventory);
        orderProcessor.register(emailer);

        System.out.println("\n-- 2.Test Stratrgy Patern (Discounts ) ---");
        double originalPrice = myOrder.getTotalPrice();
        System.out.println("Original Price "+ originalPrice);

        DiscountStrategy tenPersenOff = new PercentageDiscount(10);
        double priceAfterPercentage = calculator.calculateFinalPrice(myOrder,tenPersenOff);
        System.out.println("Price with 10% dosucount : "+ priceAfterPercentage);

        DiscountStrategy fiveHundredOff = new FixedDiscount(500);
        double priceAfterFixed = calculator.calculateFinalPrice(myOrder, fiveHundredOff);
        System.out.println("Price with 500 THB dosucount : "+ priceAfterFixed);

        System.out.println("\n--  3.Test Factory and Decortor Patterns (Shipment) ---");
        
        Shipment standardShipment = shipmentFactory.createShipment("STANDARD");
        System.out.println("Base Shipment :  "+ standardShipment.getInfo() + ", Cost "+ standardShipment.getCost());

        Shipment gitfWrapped = new GiftWrapDecorator(standardShipment);
        System.out.println("Decorated:  "+gitfWrapped.getInfo() + ", Cost: " + gitfWrapped.getCost());

        Shipment fullyLoaded  = new InsuranceDecorator(standardShipment, myOrder);
        System.out.println("Fully Decorated : "+fullyLoaded.getInfo() + ", Cost : " + fullyLoaded.getCost());

        System.out.println("\n--  4. Printing Final Summary  ---");
        double finalPrice = priceAfterPercentage;
        double totalCost = finalPrice + fullyLoaded.getCost();
        System.out.println("Final price after discount: "+finalPrice);
        System.out.println("Final shipment cost: "+ fullyLoaded.getCost());
        System.out.println("TOTAL to pay : "+totalCost);

        orderProcessor.processOrder(myOrder);

    }
}