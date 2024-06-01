import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product>productList;

    public void addProduct(Product product){
        if(productList==null) {
            this.productList = new ArrayList<>();
        }
        productList.add(product);
    }
    public void removeProduct(int productId){
        for(Product product : productList){
            if(product.getId() == productId) productList.remove(product);
        }
    }
    public void viewAllProducts(){
        for(Product product: productList) System.out.println(product);
    }
    public void updateStock(int productId, int newStock){
        for(Product product : productList){
            if(product.getId() == productId){
                product.setStockQuantity(newStock);
                break;
        }
        }
    }
    public Product findProductById(int productId){
        for(Product product : productList){
            if(product.getId() == productId){
              return product;
            }
        }
        return null;
    }
}
