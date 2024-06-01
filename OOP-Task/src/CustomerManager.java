import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private List<Customer>customerList;
    public void addCustomer(Customer customer){
        if(customerList==null) {
        this.customerList = new ArrayList<>();
        }
        customerList.add(customer);
    }
    public void removeCustomer(int customerId){
        for(Customer customer : customerList){
            if(customer.getId() == customerId)
                customerList.remove(customer);
        }
    }
    public void viewAllCustomers(){
        for (Customer customer :customerList){
            System.out.println(customer);
        }
    }
    public Customer findCustomerById (int customerId){
        for(Customer customer : customerList){
            if(customer.getId() == customerId){
               return customer;
            }
        }
        return null;
    }
}
