package ObserverPattern;
import java.util.ArrayList;
import DataModels.Order;

public class OrderProcessor {
    ArrayList<OrderObserver>  user = new ArrayList<>();
    public void  register(OrderObserver observer) {
        user.add(observer);
    }
    public void  unregister(OrderObserver observer)  {
        user.remove(observer);
    }
    private void  notifyObserver (Order order){
        for (OrderObserver orderObserver : user) {
            orderObserver.update(order);
        }
    }
    public void processOrder(Order order){
        System.out.println("\nProcessing order "+ order.orederId() + ".....");
        System.out.println("Order processed successfully. ");
        notifyObserver(order);
    }
}