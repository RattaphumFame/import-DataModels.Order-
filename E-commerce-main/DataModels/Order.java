package DataModels;

import java.util.List;

public record Order(String orederId, List<Product> products,String customerEmail){
    public Double getTotalPrice(){
        double total = 0;
        for (Product product: products) {
            total += product.price();
        }
            return total;
    }
}
