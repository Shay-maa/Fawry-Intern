import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ProductManager productManager = new ProductManager();
    private static CustomerManager customerManager = new CustomerManager();
    private static OrderManger orderManager = new OrderManger();
    public static void main(String[] args) {
        boolean running = true;
        while (running){
            menu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    addNewProduct();
                    break;
                case 2:
                    removeProduct();
                    break;
                case 3:
                    viewAllProducts();
                    break;
                case 4:
                    addNewCustomer();
                    break;
                case 5:
                    removeCustomer();
                    break;
                case 6:
                    viewAllCustomer();
                    break;
                case 7:
                    createNewOrder();
                    break;
                case 8:
                    viewAllOrders();
                    break;
                case 9:
                    running=false;
                    break;
                default:
                    System.out.println("Invalid choice, Please try again...");
            }
        }
        scanner.close();
    }
    private static void menu(){
        System.out.println("1- Add a new product");
        System.out.println("2- Remove a product");
        System.out.println("3- View all products");
        System.out.println("4- Add a new customer");
        System.out.println("5- Remove a customer");
        System.out.println("6- View all customers");
        System.out.println("7- Create a new order");
        System.out.println("8- View all orders");
        System.out.println("9- Exit");
        System.out.println("Enter Your choice: ");
    }
    private static void addNewProduct(){
        System.out.println("Enter Product Id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter product name");
        String name = scanner.nextLine();
        System.out.println("Enter product description");
        String description = scanner.nextLine();
        System.out.println("Enter product price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter product stock");
        int stockQuantity = Integer.parseInt(scanner.nextLine());
        Product product = new Product(id , name,description,price,stockQuantity);
        productManager.addProduct(product);
        System.out.println("Product was added successfully..");
    }
    private static void removeProduct(){
        System.out.println("Enter Product ID");
        int id = Integer.parseInt(scanner.nextLine());
        productManager.removeProduct(id);
        System.out.println("Product removed");
    }
    private static void viewAllProducts(){
        productManager.viewAllProducts();
    }
    private static void addNewCustomer(){
        System.out.println("Enter Customer Id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Customer name");
        String name = scanner.nextLine();
        System.out.println("Enter Customer email");
        String email = scanner.nextLine();
        System.out.println("Enter Customer address");
        String address = scanner.nextLine();
        Customer customer = new Customer(id, name, email, address);
        customerManager.addCustomer(customer);
        System.out.println("Customer added successfully");
    }
    private static void removeCustomer(){
        System.out.println("Enter Customer Id");
        int id = Integer.parseInt(scanner.nextLine());
        customerManager.removeCustomer(id);
        System.out.println("Customer removed successfully");
    }
    private static void viewAllCustomer(){
    customerManager.viewAllCustomers();
}

    private static void createNewOrder(){
        System.out.println("Enter order Id");
        int orderId = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter customer Id");
        int customerId = Integer.parseInt(scanner.nextLine());
        Customer customer = customerManager.findCustomerById(customerId) ;
        if (customer== null){
            System.out.println("Customer not found");
            return;
        }
        List<Product>productList = new ArrayList<>();
        while (true){
            System.out.println("Enter Product Id or -1 to cancel");
            int productId = Integer.parseInt(scanner.nextLine());
            if(productId == -1){
                break;
            }
            Product product = productManager.findProductById(productId);
            if(product == null){
                System.out.println("Product not found");
                return;
            }else {
                productList.add(product);
            }
        }
        Order order = new Order(orderId, customer,productList);
        orderManager.addOrder(order);
        System.out.println("Order added successfully");
    }
    private static void viewAllOrders(){
        orderManager.viewAllOrders();
}

}

