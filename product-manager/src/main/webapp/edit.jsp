<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Product</title>
</head>
<body>
<h1>Edit Product</h1>
<form action="product" method="post">
    <input type="hidden" name="action" value="update">
    Id: <input type="text" name="id" value="${product.productId}"><br>
    Name: <input type="text" name="name" value="${product.productName}"><br>
    Price: <input type="text" name="price" value="${product.productPrice}"><br>
    description: <input type="text" name="desc"value="${product.productDesc}"><br>

    <input type="submit" value="Update Product">
</form>
<a href="product?action=get">Back to Product List</a>
</body>
</html>
