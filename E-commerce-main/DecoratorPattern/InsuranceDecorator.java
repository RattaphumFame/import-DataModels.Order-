package DecoratorPattern;
import DataModels.Order;
import FactoryMethodPattern.Shipment;

public class InsuranceDecorator extends ShipmentDecorator{
    private final Order order;
    public InsuranceDecorator(Shipment shipment,Order order) {
        super(shipment);
        this.order = order;
    }
    @Override
    public String getInfo() {
        String wrapped = "("+super.getInfo()+"+ Insurance )" ;
        return wrapped;
    }
    @Override
    public double getCost() {

        return    super.getCost()  +(order.getTotalPrice() * 0.10) ;
    }    
}