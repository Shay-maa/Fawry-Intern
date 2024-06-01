import java.util.ArrayList;
import java.util.List;

public class OrderManger {
    List<Order>orderList;
    public void addOrder(Order order){

        if(orderList==null) {
            this.orderList = new ArrayList<>();
        }
        orderList.add(order);
    }
    public void removeOrder(int orderId){
     for(Order order : orderList){
         if (order.getId()==orderId) orderList.remove(order);
     }
    }
    public void viewAllOrders(){
       for(Order order : orderList){
        System.out.println(order);
       }
    }
}
