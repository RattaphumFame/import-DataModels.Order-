package ObserverPattern;
import DataModels.Order;

public class EmailService implements OrderObserver{
    @Override
    public void update(Order oreder) {
        System.out.println("[Email Service] Confirmation email sent to " + oreder.customerEmail()+ "for order :  " + oreder.orederId());
    }
}