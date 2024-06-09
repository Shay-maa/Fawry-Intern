package com.example.productmanager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    List<Product>products = new ArrayList<>();
    String productName ;
    String productDesc;
    Double productPrice;
    int productId =0;
    int Id;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "add":
                productName = req.getParameter("name");
                productPrice = Double.parseDouble(req.getParameter("price"));
                productDesc = req.getParameter("desc");
                Product product;
                if (productName != null && productDesc !=null&& productPrice > 0 && productPrice <= Double.MAX_VALUE) {
                    product = new Product(productName, productPrice, ++productId ,productDesc);
                    products.add(product);
                }
                resp.sendRedirect("product?action=get");
                break;
            case "delete":
                Id = Integer.parseInt( req.getParameter("id"));
                products.removeIf(p ->p.getProductId() == Id );
                resp.sendRedirect("product?action=get");
                break;
            case  "update":
                Id = Integer.parseInt( req.getParameter("id"));
                productName = req.getParameter("name");
                productPrice = Double.parseDouble(req.getParameter("price"));
                productDesc = req.getParameter("desc");
                for(Product p : products){
                    if(p.productId == Id){
                        p.setProductName(productName);
                        p.setProductPrice(productPrice);
                        p.setProductDesc(productDesc);
                        req.setAttribute("product", p);
                    }
                }
                resp.sendRedirect("product?action=get");
                break;

            case "edit":
                Id = Integer.parseInt( req.getParameter("id"));
                for (Product p: products) {
                    if(p.getProductId() == Id){
                      req.setAttribute("product",p);
                    }
                }
                req.getRequestDispatcher("edit.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action.equals("get")) {
            req.setAttribute("products", products);
            req.getRequestDispatcher("product.jsp").forward(req,resp);
        }
    }
}
