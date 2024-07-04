package org.eclipse.jakarta.hello;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Product {
        int productId =0;
    @NotBlank(message = "Product name is mandatory")
    String productName ;
    @NotNull(message = "Product name is mandatory")
    String productDesc;
    @Min(value = 0, message = "Product price must be non-negative")
    Double productPrice;
    public Product() {
        // Default constructor for JSON binding
    }
        public  Product(String productName , Double productPrice,int productId, String productDesc){
            this.productName = productName;
            this.productPrice = productPrice;
            this.productId = productId;
            this.productDesc=productDesc;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public void setProductPrice(Double productPrice) {
            this.productPrice = productPrice;
        }

        public int getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }

        public String getProductDesc() {
            return productDesc;
        }

        public void setProductDesc(String productDesc) {
            this.productDesc = productDesc;
        }

        public Double getProductPrice() {
            return productPrice;
        }
        @Override
        public String toString() {
            return "Product{" +
                    "productId=" + productId +
                    ", productName='" + productName + '\'' +
                    ", productDesc='" + productDesc + '\'' +
                    ", productPrice=" + productPrice +
                    '}';
        }
}
