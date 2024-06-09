package com.example.productmanager;

import java.util.ArrayList;
import java.util.List;

public class Product {
    int productId =0;
    String productName ;
    String productDesc;
    Double productPrice;
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

