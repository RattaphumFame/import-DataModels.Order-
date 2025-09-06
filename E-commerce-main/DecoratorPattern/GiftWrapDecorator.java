package DecoratorPattern;
import FactoryMethodPattern.Shipment;

public class GiftWrapDecorator  extends ShipmentDecorator{
    public GiftWrapDecorator(Shipment shipment) {
        super(shipment);
    }
    @Override
    public String getInfo() {
        String wrapped = "("+super.getInfo()+"+ Gift Wrapped )" ;
        return wrapped;
    }
    @Override
    public double getCost() {
        return super.getCost() + 50.0;
    }  
}